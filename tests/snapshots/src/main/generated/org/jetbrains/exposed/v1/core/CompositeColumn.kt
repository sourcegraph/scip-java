  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  /**
   * Composite column represents multiple tightly related standard columns, which behave like a single column for the user
   *
   * @author Vladislav Kisel
   */
  abstract class CompositeColumn<T> : Expression<T>() {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                               display_name CompositeColumn
//                               documentation ```kotlin\npublic abstract class CompositeColumn<T> : Expression<T>\n```\n\n----\n\n\n Composite column represents multiple tightly related standard columns, which behave like a single column for the user\n\n @author Vladislav Kisel\n
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#`<init>`().
//                               display_name CompositeColumn
//                               documentation ```kotlin\npublic constructor<T>(): CompositeColumn<T>\n```\n\n----\n\n\n Composite column represents multiple tightly related standard columns, which behave like a single column for the user\n\n @author Vladislav Kisel\n
//                               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#[T]
//                                 display_name FirTypeParameterSymbol T
//                                 documentation ```kotlin\nT\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
      internal var nullable: Boolean = false
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getNullable().
//                          display_name nullable
//                          documentation ```kotlin\ninternal get(): Boolean\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#nullable.
//                          display_name nullable
//                          documentation ```kotlin\ninternal final var nullable: Boolean\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#setNullable().
//                          display_name nullable
//                          documentation ```kotlin\ninternal set(value: Boolean): Unit\n```
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#setNullable().(value)
//                          display_name value
//                          documentation ```kotlin\nvalue: Boolean\n```
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  
      /**
       * Parses the [compositeValue] and returns a list of real columns with their values.
       *
       * @return Map of real columns as keys to their parsed values.
       */
      abstract fun getRealColumnsWithValues(compositeValue: T): Map<Column<*>, Any?>
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                          display_name getRealColumnsWithValues
//                                          documentation ```kotlin\npublic abstract fun getRealColumnsWithValues(compositeValue: T): Map<Column<*>, Any?>\n\n```\n\n----\n\n\n Parses the [compositeValue] and returns a list of real columns with their values.\n\n @return Map of real columns as keys to their parsed values.\n
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumnsWithValues().
//                                          ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().(compositeValue)
//                                                         display_name compositeValue
//                                                         documentation ```kotlin\ncompositeValue: T\n```
//                                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
  
      /**
       * Returns a list of real columns, wrapped by this composite column.
       */
      abstract fun getRealColumns(): List<Column<*>>
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                                display_name getRealColumns
//                                documentation ```kotlin\npublic abstract fun getRealColumns(): List<Column<*>>\n\n```\n\n----\n\n\n Returns a list of real columns, wrapped by this composite column.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumns().
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /**
       * Restores the composite value based on its component column values loaded from the database.
       */
      abstract fun restoreValueFromParts(parts: Map<Column<*>, Any?>): T
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#restoreValueFromParts().
//                                       display_name restoreValueFromParts
//                                       documentation ```kotlin\npublic abstract fun restoreValueFromParts(parts: Map<Column<*>, Any?>): T\n\n```\n\n----\n\n\n Restores the composite value based on its component column values loaded from the database.\n
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#restoreValueFromParts().
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#restoreValueFromParts().(parts)
//                                             display_name parts
//                                             documentation ```kotlin\nparts: Map<Column<*>, Any?>\n```
//                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
  
      override fun toQueryBuilder(queryBuilder: QueryBuilder) = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#toQueryBuilder().(queryBuilder)
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
          getRealColumns().appendTo { +it }
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                  ^^^^^^^ definition semanticdb maven . . (it)
//                                          display_name it
//                                          documentation ```kotlin\nit: Column<*>\n```
//                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                     ^^ reference semanticdb maven . . (it)
      }
  }
  
  /**
   * Extension of [CompositeColumn] that consists of two columns, [column1] and [column2].
   */
  abstract class BiCompositeColumn<C1, C2, T>(
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#
//                                 display_name BiCompositeColumn
//                                 documentation ```kotlin\npublic abstract class BiCompositeColumn<C1, C2, T> : CompositeColumn<T>\n```\n\n----\n\n\n Extension of [CompositeColumn] that consists of two columns, [column1] and [column2].\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().
//                                 display_name BiCompositeColumn
//                                 documentation ```kotlin\npublic constructor<C1, C2, T>(column1: Column<C1>, column2: Column<C2>, transformFromValue: (T) -> Pair<C1?, C2?>, transformToValue: (Any?, Any?) -> T, nullable: Boolean = ...): BiCompositeColumn<C1, C2, T>\n```\n\n----\n\n Transformation that receives the column's composite value and returns the parsed values of the underlying columns.
//                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#[C1]
//                                    display_name FirTypeParameterSymbol C1
//                                    documentation ```kotlin\nC1\n```
//                                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#[C2]
//                                        display_name FirTypeParameterSymbol C2
//                                        documentation ```kotlin\nC2\n```
//                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#[T]
//                                           display_name FirTypeParameterSymbol T
//                                           documentation ```kotlin\nT\n```
      protected val column1: Column<C1>,
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(column1)
//                          display_name column1
//                          documentation ```kotlin\ncolumn1: Column<C1>\n```
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(column1)
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column1.
//                          display_name column1
//                          documentation ```kotlin\nprotected final val column1: Column<C1>\n```
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn1().
//                          display_name column1
//                          documentation ```kotlin\nprotected get(): Column<C1>\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
      protected val column2: Column<C2>,
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(column2)
//                          display_name column2
//                          documentation ```kotlin\ncolumn2: Column<C2>\n```
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(column2)
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column2.
//                          display_name column2
//                          documentation ```kotlin\nprotected final val column2: Column<C2>\n```
//                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn2().
//                          display_name column2
//                          documentation ```kotlin\nprotected get(): Column<C2>\n```
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
      /** Transformation that receives the column's composite value and returns the parsed values of the underlying columns. */
      val transformFromValue: (T) -> Pair<C1?, C2?>,
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(transformFromValue)
//                           display_name transformFromValue
//                           documentation ```kotlin\ntransformFromValue: (T) -> Pair<C1?, C2?>\n```\n\n----\n\n Transformation that receives the column's composite value and returns the parsed values of the underlying columns.
//        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(transformFromValue)
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getTransformFromValue().
//                           display_name transformFromValue
//                           documentation ```kotlin\npublic get(): (T) -> Pair<C1?, C2?>\n```\n\n----\n\n Transformation that receives the column's composite value and returns the parsed values of the underlying columns.
//        ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#transformFromValue.
//                           display_name transformFromValue
//                           documentation ```kotlin\npublic final val transformFromValue: (T) -> Pair<C1?, C2?>\n```\n\n----\n\n Transformation that receives the column's composite value and returns the parsed values of the underlying columns.
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
      /** Transformation that receives the retrieved values of [column1] and [column2] and returns a composite value. */
      val transformToValue: (Any?, Any?) -> T,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(transformToValue)
//                         display_name transformToValue
//                         documentation ```kotlin\ntransformToValue: (Any?, Any?) -> T\n```\n\n----\n\n Transformation that receives the retrieved values of [column1] and [column2] and returns a composite value.
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(transformToValue)
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getTransformToValue().
//                         display_name transformToValue
//                         documentation ```kotlin\npublic get(): (Any?, Any?) -> T\n```\n\n----\n\n Transformation that receives the retrieved values of [column1] and [column2] and returns a composite value.
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#transformToValue.
//                         display_name transformToValue
//                         documentation ```kotlin\npublic final val transformToValue: (Any?, Any?) -> T\n```\n\n----\n\n Transformation that receives the retrieved values of [column1] and [column2] and returns a composite value.
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
      nullable: Boolean = false
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(nullable)
//             display_name nullable
//             documentation ```kotlin\nnullable: Boolean = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
  ) : CompositeColumn<T>() {
//    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
      init {
          this.nullable = nullable
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getNullable().
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#nullable.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#setNullable().
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#`<init>`().(nullable)
      }
  
      override fun getRealColumns(): List<Column<*>> = listOf(column1, column2)
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumns().
//                                display_name getRealColumns
//                                documentation ```kotlin\npublic open override fun getRealColumns(): List<Column<*>>\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumns().
//                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                     ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column1.
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn1().
//                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column2.
//                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn2().
  
      override fun getRealColumnsWithValues(compositeValue: T): Map<Column<*>, Any?> {
//                 ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumnsWithValues().
//                                          display_name getRealColumnsWithValues
//                                          documentation ```kotlin\npublic open override fun getRealColumnsWithValues(compositeValue: T): Map<Column<*>, Any?>\n```
//                                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                          ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumnsWithValues().(compositeValue)
//                                                         display_name compositeValue
//                                                         documentation ```kotlin\ncompositeValue: T\n```
//                                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
          require(compositeValue != null || nullable) {
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumnsWithValues().(compositeValue)
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getNullable().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#nullable.
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#setNullable().
              "Can't set null value to non-nullable ${this::class.simpleName} column"
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getSimpleName().
//                                                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#simpleName.
          }
          val (v1, v2) = transformFromValue(compositeValue)
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 0
//                                                          display_name <destruct>
//                                                          documentation ```kotlin\nlocal val <destruct>: Pair<C1?, C2?>\n```
//             ^^ reference local 0
//             ^^ definition local 1
//                display_name v1
//                documentation ```kotlin\nlocal val v1: C1?\n```
//             ^^ reference semanticdb maven . . kotlin/Pair#component1().
//                 ^^ reference local 0
//                 ^^ definition local 2
//                    display_name v2
//                    documentation ```kotlin\nlocal val v2: C2?\n```
//                 ^^ reference semanticdb maven . . kotlin/Pair#component2().
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getTransformFromValue().
//                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#transformFromValue.
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getRealColumnsWithValues().(compositeValue)
          return mapOf(column1 to v1, column2 to v2)
//               ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column1.
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn1().
//                             ^^ reference semanticdb maven . . kotlin/to().
//                                ^^ reference local 1
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column2.
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn2().
//                                            ^^ reference semanticdb maven . . kotlin/to().
//                                               ^^ reference local 2
      }
  
      override fun restoreValueFromParts(parts: Map<Column<*>, Any?>): T {
//                 ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#restoreValueFromParts().
//                                       display_name restoreValueFromParts
//                                       documentation ```kotlin\npublic open override fun restoreValueFromParts(parts: Map<Column<*>, Any?>): T\n```
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#restoreValueFromParts().
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#restoreValueFromParts().(parts)
//                                             display_name parts
//                                             documentation ```kotlin\nparts: Map<Column<*>, Any?>\n```
//                                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
          val v1 = parts[column1]
//            ^^ definition local 3
//               display_name v1
//               documentation ```kotlin\nlocal val v1: Any?\n```
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#restoreValueFromParts().(parts)
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column1.
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn1().
          val v2 = parts[column2]
//            ^^ definition local 4
//               display_name v2
//               documentation ```kotlin\nlocal val v2: Any?\n```
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#restoreValueFromParts().(parts)
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#column2.
//                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getColumn2().
          val result = transformToValue(v1, v2)
//            ^^^^^^ definition local 5
//                   display_name result
//                   documentation ```kotlin\nlocal val result: T\n```
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getTransformToValue().
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#transformToValue.
//                                      ^^ reference local 3
//                                          ^^ reference local 4
          check(result != null || nullable) {
//        ^^^^^ reference semanticdb maven . . kotlin/check(+1).
//              ^^^^^^ reference local 5
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#getNullable().
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#nullable.
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BiCompositeColumn#setNullable().
              "Null value received from DB for non-nullable ${this::class.simpleName} column"
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#getSimpleName().
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/reflect/KClass#simpleName.
          }
          return result
//               ^^^^^^ reference local 5
      }
  }
