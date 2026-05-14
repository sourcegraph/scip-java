  @file:Suppress("internal", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
  
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
  import org.jetbrains.exposed.v1.core.dao.id.CompositeID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
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
  import kotlin.internal.LowPriorityInOverloadResolution
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^ reference semanticdb maven . . kotlin/internal/
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/internal/LowPriorityInOverloadResolution#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
  /**
   * Represents the underlying mapping of columns scheduled for change along with their new values.
   */
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#[T]
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(type)
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(targets)
  abstract class UpdateBuilder<out T>(type: StatementType, targets: List<Table>) : Statement<T>(type, targets) {
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//                             display_name UpdateBuilder
//                             documentation ```kotlin\npublic abstract class UpdateBuilder<out T> : Statement<T>\n```\n\n----\n\n\n Represents the underlying mapping of columns scheduled for change along with their new values.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertStatement#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateStatement#
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().
//                             display_name UpdateBuilder
//                             documentation ```kotlin\npublic constructor<out T>(type: StatementType, targets: List<Table>): UpdateBuilder<T>\n```
//                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#[T]
//                                   display_name FirTypeParameterSymbol T
//                                   documentation ```kotlin\nout T\n```
//                                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(type)
//                                         display_name type
//                                         documentation ```kotlin\ntype: StatementType\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//                                                         ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(targets)
//                                                                 display_name targets
//                                                                 documentation ```kotlin\ntargets: List<Table>\n```
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(type)
//                                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(targets)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#[T]
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(type)
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().(targets)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
      /** The mapping of columns scheduled for change with their new values. */
      @InternalApi
      val values: MutableMap<Column<*>, Any?> = LinkedHashMap()
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//               display_name values
//               documentation ```kotlin\npublic get(): MutableMap<Column<*>, Any?>\n```\n\n----\n\n The mapping of columns scheduled for change with their new values.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//               display_name values
//               documentation ```kotlin\n@InternalApi() public final val values: MutableMap<Column<*>, Any?>\n```\n\n----\n\n The mapping of columns scheduled for change with their new values.
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                              ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashMap#`<init>`().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().(column)
      open operator fun contains(column: Column<*>): Boolean {
//                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().
//                               display_name contains
//                               documentation ```kotlin\npublic open operator fun contains(column: Column<*>): Boolean\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: Column<*>\n```
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().(column)
          @OptIn(InternalApi::class)
          return values.contains(column)
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().(column)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#contains().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#hasBatchedValues.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getHasBatchedValues().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().(value)
      /** Whether the underlying mapping has at least one stored value that is a batched statement. */
      protected var hasBatchedValues: Boolean = false
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getHasBatchedValues().
//                                   display_name hasBatchedValues
//                                   documentation ```kotlin\nprotected get(): Boolean\n```\n\n----\n\n Whether the underlying mapping has at least one stored value that is a batched statement.
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#hasBatchedValues.
//                                   display_name hasBatchedValues
//                                   documentation ```kotlin\nprotected final var hasBatchedValues: Boolean\n```\n\n----\n\n Whether the underlying mapping has at least one stored value that is a batched statement.
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().
//                                   display_name hasBatchedValues
//                                   documentation ```kotlin\nprotected set(value: Boolean): Unit\n```\n\n----\n\n Whether the underlying mapping has at least one stored value that is a batched statement.
//                  ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().(value)
//                                   display_name value
//                                   documentation ```kotlin\nvalue: Boolean\n```\n\n----\n\n Whether the underlying mapping has at least one stored value that is a batched statement.
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#hasBatchedValues.
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getHasBatchedValues().
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().(value)
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().
      @OptIn(InternalApi::class)
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().(column)
      private fun checkThatExpressionWasNotSetInPreviousBatch(column: Column<*>) {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().
//                                                            display_name checkThatExpressionWasNotSetInPreviousBatch
//                                                            documentation ```kotlin\n@OptIn(...) private final fun checkThatExpressionWasNotSetInPreviousBatch(column: Column<*>): Unit\n```
//                                                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().(column)
//                                                                   display_name column
//                                                                   documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().(column)
          require(!(values.containsKey(column) && hasBatchedValues)) { "$column is already initialized in a batch" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^ reference semanticdb maven . . kotlin/Boolean#not().
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//                         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#containsKey().
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().(column)
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getHasBatchedValues().
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#hasBatchedValues.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setHasBatchedValues().
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().(column)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().
      @LowPriorityInOverloadResolution
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
      open operator fun <S> set(column: Column<S>, value: S) {
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().[S]
//                         display_name FirTypeParameterSymbol S
//                         documentation ```kotlin\nS\n```
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().
//                              display_name set
//                              documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open operator fun <S> set(column: Column<S>, value: S): Unit\n```
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<S>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
//                                                       display_name value
//                                                       documentation ```kotlin\nvalue: S\n```
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().[S]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
          require(column.columnType is NullableColumnWithTransform<*, *> || column.columnType.nullable || (value != null && value !is Op.NULL)) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NullableColumnWithTransform#
//                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
//                                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
//                                                                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
              "Trying to set null to not nullable column $column"
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
          }
  
          if (column.isEntityIdentifier() && (value as EntityID<*>).value is CompositeID) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
//                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
              (value.value as CompositeID).setComponentValues()
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
//                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
          } else {
              column.columnType.validateValueBeforeUpdate(value)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#validateValueBeforeUpdate().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
              @OptIn(InternalApi::class)
              values[column] = value
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(column)
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().(value)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).
      @Suppress("UNCHECKED_CAST")
      @JvmName("setWithEntityIdValue")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).[S]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
      operator fun <S : Any> set(column: Column<EntityID<S>>, value: S) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Any\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).
//                               display_name set
//                               documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <S : Any> set(column: Column<EntityID<S>>, value: S): Unit\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: Column<EntityID<S>>\n```
//                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
//                                                                  display_name value
//                                                                  documentation ```kotlin\nvalue: S\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).[S]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
          if (value is CompositeID) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
              value.setComponentValues()
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
          } else {
//            ⌄ enclosing_range_start local 0
              val entityId: EntityID<S> = EntityID(value, (column.foreignKey?.targetTable ?: column.table) as IdTable<S>)
//                ^^^^^^^^ definition local 0
//                         display_name entityId
//                         documentation ```kotlin\nlocal val entityId: EntityID<S>\n```
//                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(value)
//                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                                                      ⌃ enclosing_range_end local 0
              column.columnType.validateValueBeforeUpdate(entityId)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#validateValueBeforeUpdate().
//                                                        ^^^^^^^^ reference local 0
              @OptIn(InternalApi::class)
              values[column] = entityId
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).(column)
//                             ^^^^^^^^ reference local 0
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).
      @Suppress("UNCHECKED_CAST")
      @JvmName("setWithNullableEntityIdValue")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).[S]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
      operator fun <S : Any> set(column: Column<EntityID<S>?>, value: S?) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Any\n```
//                           ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).
//                               display_name set
//                               documentation ```kotlin\n@Suppress(...) @JvmName(...) public final operator fun <S : Any> set(column: Column<EntityID<S>?>, value: S?): Unit\n```
//                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                                      display_name column
//                                      documentation ```kotlin\ncolumn: Column<EntityID<S>?>\n```
//                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
//                                                                   display_name value
//                                                                   documentation ```kotlin\nvalue: S?\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).[S]
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
          require(column.columnType.nullable || value != null) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
              "Trying to set null to not nullable column $column"
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
          }
          if (value is CompositeID) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
              value.setComponentValues()
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
          } else {
//            ⌄ enclosing_range_start local 1
//                                                    ⌄ enclosing_range_start local 2
              val entityId: EntityID<S>? = value?.let { EntityID(it, (column.foreignKey?.targetTable ?: column.table) as IdTable<S>) }
//                ^^^^^^^^ definition local 1
//                         display_name entityId
//                         documentation ```kotlin\nlocal val entityId: EntityID<S>?\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(value)
//                                                ^^^ reference semanticdb maven . . kotlin/let().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                                                                                                     display_name it
//                                                                                                                                     documentation ```kotlin\nit: S\n```
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                                               ^^ reference local 2
//                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                                                                   ⌃ enclosing_range_end local 1
//                                                                                                                                   ⌃ enclosing_range_end local 2
              column.columnType.validateValueBeforeUpdate(entityId)
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#validateValueBeforeUpdate().
//                                                        ^^^^^^^^ reference local 1
              @OptIn(InternalApi::class)
              values[column] = entityId
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).(column)
//                             ^^^^^^^^ reference local 1
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).
      @JvmName("setWithEntityIdExpression")
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[S]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[ID]
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[E]
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
//                                                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(value)
      operator fun <S : Any?, ID : EntityID<S>, E : Expression<S>> set(column: Column<ID>, value: E) {
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS\n```
//                            ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[ID]
//                               display_name FirTypeParameterSymbol ID
//                               documentation ```kotlin\nID : EntityID<S>\n```
//                                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[E]
//                                                display_name FirTypeParameterSymbol E
//                                                documentation ```kotlin\nE : Expression<S>\n```
//                                                                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).
//                                                                     display_name set
//                                                                     documentation ```kotlin\n@JvmName(...) public final operator fun <S, ID : EntityID<S>, E : Expression<S>> set(column: Column<ID>, value: E): Unit\n```
//                                                                     ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
//                                                                            display_name column
//                                                                            documentation ```kotlin\ncolumn: Column<ID>\n```
//                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(value)
//                                                                                               display_name value
//                                                                                               documentation ```kotlin\nvalue: E\n```
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[S]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[ID]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).[E]
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(value)
          require(column.columnType.nullable || value !is Op.NULL) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(value)
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
              "Trying to set null to not nullable column $column"
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
          }
          checkThatExpressionWasNotSetInPreviousBatch(column)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
          @OptIn(InternalApi::class)
          values[column] = value
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(column)
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).(value)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[S]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[E]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(column)
//                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(value)
      open operator fun <T, S : T?, E : Expression<S>> set(column: Column<T>, value: E) = update(column, value)
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[T]
//                         display_name FirTypeParameterSymbol T
//                         documentation ```kotlin\nT\n```
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[S]
//                            display_name FirTypeParameterSymbol S
//                            documentation ```kotlin\nS : T?\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : Expression<S>\n```
//                                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).
//                                                         display_name set
//                                                         documentation ```kotlin\npublic open operator fun <T, S : T?, E : Expression<S>> set(column: Column<T>, value: E): Unit\n```
//                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(column)
//                                                                display_name column
//                                                                documentation ```kotlin\ncolumn: Column<T>\n```
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(value)
//                                                                                  display_name value
//                                                                                  documentation ```kotlin\nvalue: E\n```
//                                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
//                                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(column)
//                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(value)
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[T]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[S]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).[E]
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(column)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).(value)
//                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(column)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(value)
      open operator fun <S> set(column: Column<S>, value: AbstractQuery<*>) = update(column, wrapAsExpression(value))
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).[S]
//                         display_name FirTypeParameterSymbol S
//                         documentation ```kotlin\nS\n```
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).
//                              display_name set
//                              documentation ```kotlin\npublic open operator fun <S> set(column: Column<S>, value: AbstractQuery<*>): Unit\n```
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: Column<S>\n```
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(value)
//                                                       display_name value
//                                                       documentation ```kotlin\nvalue: AbstractQuery<*>\n```
//                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(column)
//                                                                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/wrapAsExpression().
//                                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(value)
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).[S]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(column)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).(value)
//                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+5).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(column)
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(value)
      open operator fun <S> set(column: CompositeColumn<S>, value: S) {
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).[S]
//                         display_name FirTypeParameterSymbol S
//                         documentation ```kotlin\nS\n```
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).
//                              display_name set
//                              documentation ```kotlin\npublic open operator fun <S> set(column: CompositeColumn<S>, value: S): Unit\n```
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(column)
//                                     display_name column
//                                     documentation ```kotlin\ncolumn: CompositeColumn<S>\n```
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(value)
//                                                                display_name value
//                                                                documentation ```kotlin\nvalue: S\n```
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).[S]
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(column)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(value)
//                                                         ⌄ enclosing_range_start local 3
//                                                          ⌄ enclosing_range_start local 4
//                                                                      ⌄ enclosing_range_start local 5
          column.getRealColumnsWithValues(value).forEach { (realColumn, itsValue) ->
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(column)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).(value)
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                                                         ^^^^^^^^^^^^^^^^^^^^^^ definition local 3
//                                                                                display_name <destruct>
//                                                                                documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, Any?>\n```
//                                                          ^^^^^^^^^^ reference local 3
//                                                          ^^^^^^^^^^ definition local 4
//                                                                     display_name realColumn
//                                                                     documentation ```kotlin\nlocal val realColumn: Column<*>\n```
//                                                          ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                                                      ^^^^^^^^ reference local 3
//                                                                      ^^^^^^^^ definition local 5
//                                                                               display_name itsValue
//                                                                               documentation ```kotlin\nlocal val itsValue: Any?\n```
//                                                                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                                                   ⌃ enclosing_range_end local 4
//                                                                             ⌃ enclosing_range_end local 5
//                                                                              ⌃ enclosing_range_end local 3
              set(realColumn as Column<Any?>, itsValue)
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().
//                ^^^^^^^^^^ reference local 4
//                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                            ^^^^^^^^ reference local 5
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set(+6).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
      @Suppress("UNCHECKED_CAST")
      private fun CompositeID.setComponentValues() {
//                            ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
//                                               display_name setComponentValues
//                                               documentation ```kotlin\n@Suppress(...) private final fun CompositeID.setComponentValues(): Unit\n```
//                              ⌄ enclosing_range_start local 6
//                               ⌄ enclosing_range_start local 7
//                                         ⌄ enclosing_range_start local 8
          this.values.forEach { (idColumn, idValue) ->
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                    ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+11).
//                              ^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                  display_name <destruct>
//                                                  documentation ```kotlin\n<destruct>: Map.Entry<Column<*>, Any?>\n```
//                               ^^^^^^^^ reference local 6
//                               ^^^^^^^^ definition local 7
//                                        display_name idColumn
//                                        documentation ```kotlin\nlocal val idColumn: Column<*>\n```
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/collections/component1(+10).
//                                         ^^^^^^^ reference local 6
//                                         ^^^^^^^ definition local 8
//                                                 display_name idValue
//                                                 documentation ```kotlin\nlocal val idValue: Any?\n```
//                                         ^^^^^^^ reference semanticdb maven . . kotlin/collections/component2(+10).
//                                      ⌃ enclosing_range_end local 7
//                                               ⌃ enclosing_range_end local 8
//                                                ⌃ enclosing_range_end local 6
              set(idColumn as Column<Any?>, idValue)
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#set().
//                ^^^^^^^^ reference local 7
//                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                          ^^^^^^^ reference local 8
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#setComponentValues().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
      /**
       * Updates the mapping of the specified [column] with the specified [value] if [column] has not been previously
       * set up for a change and if [value] is of a valid type.
       **/
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[T]
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[S]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(column)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(value)
      open fun <T, S : T?> update(column: Column<T>, value: Expression<S>) {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[S]
//                   display_name FirTypeParameterSymbol S
//                   documentation ```kotlin\nS : T?\n```
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
//                                display_name update
//                                documentation ```kotlin\npublic open fun <T, S : T?> update(column: Column<T>, value: Expression<S>): Unit\n```\n\n----\n\n\n Updates the mapping of the specified [column] with the specified [value] if [column] has not been previously\n set up for a change and if [value] is of a valid type.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/BatchUpdateStatement#update().
//                                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(column)
//                                       display_name column
//                                       documentation ```kotlin\ncolumn: Column<T>\n```
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(value)
//                                                         display_name value
//                                                         documentation ```kotlin\nvalue: Expression<S>\n```
//                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[T]
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().[S]
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(column)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(value)
          checkThatExpressionWasNotSetInPreviousBatch(column)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#checkThatExpressionWasNotSetInPreviousBatch().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(column)
          @OptIn(InternalApi::class)
          values[column] = value
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#getValues().
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#values.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/set().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(column)
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().(value)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).
      /** Updates the mapping of the specified [column] with the value of the provided expression. */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[T]
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[S]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(column)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(value)
      open fun <T, S : T?> update(column: Column<T>, value: SqlExpressionBuilder.() -> Expression<S>) {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[S]
//                   display_name FirTypeParameterSymbol S
//                   documentation ```kotlin\nS : T?\n```
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).
//                                display_name update
//                                documentation ```kotlin\npublic open fun <T, S : T?> update(column: Column<T>, value: SqlExpressionBuilder.() -> Expression<S>): Unit\n```\n\n----\n\n Updates the mapping of the specified [column] with the value of the provided expression.
//                                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(column)
//                                       display_name column
//                                       documentation ```kotlin\ncolumn: Column<T>\n```
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(value)
//                                                         display_name value
//                                                         documentation ```kotlin\nvalue: SqlExpressionBuilder.() -> Expression<S>\n```
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[T]
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).[S]
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(column)
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(value)
          update(column, SqlExpressionBuilder.value())
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(column)
//                                            ^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).(value)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#update(+1).
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
