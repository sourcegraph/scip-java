  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.vendors.H2Dialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
  import org.jetbrains.exposed.v1.core.vendors.H2FunctionProvider
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  import org.jetbrains.exposed.v1.core.vendors.h2Mode
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
  /**
   * Represents an SQL function.
   */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().(columnType)
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#columnType.
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Function#getColumnType().
  abstract class Function<T>(override val columnType: IColumnType<T & Any>) : ExpressionWithColumnType<T>()
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                        display_name Function
//                        documentation ```kotlin\npublic abstract class Function<T> : ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents an SQL function.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Random#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5656>`#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().
//                        display_name Function
//                        documentation ```kotlin\npublic constructor<T>(columnType: IColumnType<T & Any>): Function<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().(columnType)
//                                                   display_name columnType
//                                                   documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().(columnType)
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#columnType.
//                                                   display_name columnType
//                                                   documentation ```kotlin\npublic open override val columnType: IColumnType<T & Any>\n```
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Function#getColumnType().
//                                                   display_name columnType
//                                                   documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#[T]
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().(columnType)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#columnType.
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#getColumnType().
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#`<init>`().
//                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
  /**
   * Represents a custom SQL function.
   */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
  open class CustomFunction<T>(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                          display_name CustomFunction
//                          documentation ```kotlin\npublic open class CustomFunction<T> : Function<T>\n```\n\n----\n\n\n Represents a custom SQL function.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
//                          display_name CustomFunction
//                          documentation ```kotlin\npublic constructor<T>(functionName: String, columnType: IColumnType<T & Any>, vararg expr: Expression<*>): CustomFunction<T>\n```\n\n----\n\n Returns the name of the function.
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#[T]
//                            display_name FirTypeParameterSymbol T
//                            documentation ```kotlin\nT\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(functionName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#functionName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getFunctionName().
      /** Returns the name of the function. */
      val functionName: String,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(functionName)
//                     display_name functionName
//                     documentation ```kotlin\nfunctionName: String\n```\n\n----\n\n Returns the name of the function.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(functionName)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#functionName.
//                     display_name functionName
//                     documentation ```kotlin\npublic final val functionName: String\n```\n\n----\n\n Returns the name of the function.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getFunctionName().
//                     display_name functionName
//                     documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the name of the function.
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(functionName)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#functionName.
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getFunctionName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(columnType)
      columnType: IColumnType<T & Any>,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(columnType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getExpr().
      /** Returns the list of arguments of this function. */
      vararg val expr: Expression<*>
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nvararg expr: Expression<*>\n```\n\n----\n\n Returns the list of arguments of this function.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic final val expr: Array<out Expression<*>>\n```\n\n----\n\n Returns the list of arguments of this function.
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): Array<out Expression<*>>\n```\n\n----\n\n Returns the list of arguments of this function.
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(expr)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#expr.
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getExpr().
  ) : Function<T>(columnType) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().(queryBuilder)
          append(functionName, '(')
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#functionName.
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getFunctionName().
//                      ⌄ enclosing_range_start local 0
          expr.appendTo { +it }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#expr.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#getExpr().
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                      ^^^^^^^ definition local 0
//                              display_name it
//                              documentation ```kotlin\nit: CapturedType(out Expression<*>)\n```
//                        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                         ^^ reference local 0
//                            ⌃ enclosing_range_end local 0
          append(')')
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
  /**
   * Represents a custom SQL binary operator.
   */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().
  open class CustomOperator<T>(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
//                          display_name CustomOperator
//                          documentation ```kotlin\npublic open class CustomOperator<T> : Function<T>\n```\n\n----\n\n\n Represents a custom SQL binary operator.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().
//                          display_name CustomOperator
//                          documentation ```kotlin\npublic constructor<T>(operatorName: String, columnType: IColumnType<T & Any>, expr1: Expression<*>, expr2: Expression<*>): CustomOperator<T>\n```\n\n----\n\n Returns the name of the operator.
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#[T]
//                            display_name FirTypeParameterSymbol T
//                            documentation ```kotlin\nT\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(operatorName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#operatorName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getOperatorName().
      /** Returns the name of the operator. */
      val operatorName: String,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(operatorName)
//                     display_name operatorName
//                     documentation ```kotlin\noperatorName: String\n```\n\n----\n\n Returns the name of the operator.
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(operatorName)
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getOperatorName().
//                     display_name operatorName
//                     documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the name of the operator.
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#operatorName.
//                     display_name operatorName
//                     documentation ```kotlin\npublic final val operatorName: String\n```\n\n----\n\n Returns the name of the operator.
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(operatorName)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#operatorName.
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getOperatorName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(columnType)
      columnType: IColumnType<T & Any>,
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(columnType)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr1)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr1.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr1().
      /** Returns the left-hand side operand. */
      val expr1: Expression<*>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr1)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr1.
//              display_name expr1
//              documentation ```kotlin\npublic final val expr1: Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr1().
//              display_name expr1
//              documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the left-hand side operand.
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr1)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr1.
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr1().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr2)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr2.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr2().
      /** Returns the right-hand side operand. */
      val expr2: Expression<*>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr2)
//              display_name expr2
//              documentation ```kotlin\nexpr2: Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr2)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr2.
//              display_name expr2
//              documentation ```kotlin\npublic final val expr2: Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr2().
//              display_name expr2
//              documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the right-hand side operand.
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(expr2)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr2.
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr2().
  ) : Function<T>(columnType) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().(queryBuilder)
          append('(', expr1, ' ', operatorName, ' ', expr2, ')')
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr1.
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr1().
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getOperatorName().
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#operatorName.
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#expr2.
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#getExpr2().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomOperator#
  
  // Mathematical Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#
  /**
   * Represents an SQL function that returns a random value in the range 0.0 <= x < 1.0, using the specified [seed].
   *
   * **Note:** Some vendors generate values outside this range, or ignore the given seed, check the documentation.
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().
  class Random(
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#
//             display_name Random
//             documentation ```kotlin\npublic final class Random : Function<BigDecimal>\n```\n\n----\n\n\n Represents an SQL function that returns a random value in the range 0.0 <= x < 1.0, using the specified [seed].\n\n **Note:** Some vendors generate values outside this range, or ignore the given seed, check the documentation.\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().
//             display_name Random
//             documentation ```kotlin\npublic constructor(seed: Int? = ...): Random\n```\n\n----\n\n Returns the seed.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().(seed)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#seed.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#getSeed().
      /** Returns the seed. */
      val seed: Int? = null
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().(seed)
//             display_name seed
//             documentation ```kotlin\nseed: Int? = ...\n```\n\n----\n\n Returns the seed.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().(seed)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#getSeed().
//             display_name seed
//             documentation ```kotlin\npublic get(): Int?\n```\n\n----\n\n Returns the seed.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#seed.
//             display_name seed
//             documentation ```kotlin\npublic final val seed: Int?\n```\n\n----\n\n Returns the seed.
//              ^^^^ reference semanticdb maven . . kotlin/Int#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().(seed)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#seed.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#getSeed().
  ) : Function<BigDecimal>(DecimalColumnType(precision = 38, scale = 20)) {
//    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().(queryBuilder)
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().(queryBuilder)
//        ⌄ enclosing_range_start local 1
//                                     ⌄ enclosing_range_start local 2
          val functionProvider = when (currentDialect.h2Mode) {
//            ^^^^^^^^^^^^^^^^ definition local 1
//                             display_name functionProvider
//                             documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                     ^^^^^^^^^^^^^^^^^^^^^ definition local 2
//                                                           display_name <when-subject>
//                                                           documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                         ⌃ enclosing_range_end local 2
              H2Dialect.H2CompatibilityMode.Oracle, H2Dialect.H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
              else -> currentDialect.functionProvider
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
          }
//        ⌃ enclosing_range_end local 1
          +functionProvider.random(seed)
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//         ^^^^^^^^^^^^^^^^ reference local 1
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Random#getSeed().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Random#seed.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Random#
  
  // String Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#
  /**
   * Represents an SQL function that returns the length of [expr], measured in characters, or `null` if [expr] is null.
   */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#[T]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().
  class CharLength<T : String?>(
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#
//                 display_name CharLength
//                 documentation ```kotlin\npublic final class CharLength<T : String?> : Function<Int?>\n```\n\n----\n\n\n Represents an SQL function that returns the length of [expr], measured in characters, or `null` if [expr] is null.\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().
//                 display_name CharLength
//                 documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>): CharLength<T>\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT : String?\n```
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#getExpr().
      val expr: Expression<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#getExpr().
  ) : Function<Int?>(IntegerColumnType()) {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.charLength(expr, queryBuilder)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#expr.
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#getExpr().
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#
  /**
   * Represents an SQL function that converts [expr] to lower case.
   */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().
  class LowerCase<T : String?>(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#
//                display_name LowerCase
//                documentation ```kotlin\npublic final class LowerCase<T : String?> : Function<String>\n```\n\n----\n\n\n Represents an SQL function that converts [expr] to lower case.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().
//                display_name LowerCase
//                documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>): LowerCase<T>\n```\n\n----\n\n Returns the expression to convert.
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#getExpr().
      /** Returns the expression to convert. */
      val expr: Expression<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#getExpr().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("LOWER(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#expr.
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().(queryBuilder)
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#
  /**
   * Represents an SQL function that converts [expr] to upper case.
   */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().
  class UpperCase<T : String?>(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#
//                display_name UpperCase
//                documentation ```kotlin\npublic final class UpperCase<T : String?> : Function<String>\n```\n\n----\n\n\n Represents an SQL function that converts [expr] to upper case.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().
//                display_name UpperCase
//                documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>): UpperCase<T>\n```\n\n----\n\n Returns the expression to convert.
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#getExpr().
      /** Returns the expression to convert. */
      val expr: Expression<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression to convert.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#getExpr().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("UPPER(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().(queryBuilder)
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#expr.
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().(queryBuilder)
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
  /**
   * Represents an SQL function that concatenates the text representations of all non-null input values from [expr], separated by [separator].
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().
  class Concat(
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//             display_name Concat
//             documentation ```kotlin\npublic final class Concat : Function<String>\n```\n\n----\n\n\n Represents an SQL function that concatenates the text representations of all non-null input values from [expr], separated by [separator].\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().
//             display_name Concat
//             documentation ```kotlin\npublic constructor(separator: String, vararg expr: Expression<*>): Concat\n```\n\n----\n\n Returns the delimiter.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(separator)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#separator.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getSeparator().
      /** Returns the delimiter. */
      val separator: String,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(separator)
//                  display_name separator
//                  documentation ```kotlin\nseparator: String\n```\n\n----\n\n Returns the delimiter.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(separator)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getSeparator().
//                  display_name separator
//                  documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Returns the delimiter.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#separator.
//                  display_name separator
//                  documentation ```kotlin\npublic final val separator: String\n```\n\n----\n\n Returns the delimiter.
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(separator)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#separator.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getSeparator().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getExpr().
      /** Returns the expressions being concatenated. */
      vararg val expr: Expression<*>
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(expr)
//                    display_name expr
//                    documentation ```kotlin\nvararg expr: Expression<*>\n```\n\n----\n\n Returns the expressions being concatenated.
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(expr)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#expr.
//                    display_name expr
//                    documentation ```kotlin\npublic final val expr: Array<out Expression<*>>\n```\n\n----\n\n Returns the expressions being concatenated.
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getExpr().
//                    display_name expr
//                    documentation ```kotlin\npublic get(): Array<out Expression<*>>\n```\n\n----\n\n Returns the expressions being concatenated.
//                     ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().(expr)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#expr.
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getExpr().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.concat(separator, queryBuilder, expr = expr)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getSeparator().
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#separator.
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().(queryBuilder)
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#expr.
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#getExpr().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
  /**
   * Represents an SQL function that concatenates the text representation of all non-null input values of each group from [expr], separated by [separator]
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().
  class GroupConcat<T : String?>(
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                  display_name GroupConcat
//                  documentation ```kotlin\npublic final class GroupConcat<T : String?> : Function<String>\n```\n\n----\n\n\n Represents an SQL function that concatenates the text representation of all non-null input values of each group from [expr], separated by [separator]\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().
//                  display_name GroupConcat
//                  documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>, separator: String?, distinct: Boolean, vararg orderBy: Pair<Expression<*>, SortOrder>): GroupConcat<T>\n```\n\n----\n\n Returns grouped expression being concatenated.
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : String?\n```
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
      /** Returns grouped expression being concatenated. */
      val expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns grouped expression being concatenated.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns grouped expression being concatenated.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns grouped expression being concatenated.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(separator)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
      /** Returns the delimiter. */
      val separator: String?,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(separator)
//                  display_name separator
//                  documentation ```kotlin\nseparator: String?\n```\n\n----\n\n Returns the delimiter.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(separator)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                  display_name separator
//                  documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Returns the delimiter.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                  display_name separator
//                  documentation ```kotlin\npublic final val separator: String?\n```\n\n----\n\n Returns the delimiter.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(separator)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(distinct)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
      /** Returns `true` if only distinct elements are concatenated, `false` otherwise. */
      val distinct: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(distinct)
//                 display_name distinct
//                 documentation ```kotlin\ndistinct: Boolean\n```\n\n----\n\n Returns `true` if only distinct elements are concatenated, `false` otherwise.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(distinct)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                 display_name distinct
//                 documentation ```kotlin\npublic final val distinct: Boolean\n```\n\n----\n\n Returns `true` if only distinct elements are concatenated, `false` otherwise.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
//                 display_name distinct
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns `true` if only distinct elements are concatenated, `false` otherwise.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(distinct)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(orderBy)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
      /** Returns the order in which the elements of each group are sorted. */
      vararg val orderBy: Pair<Expression<*>, SortOrder>
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(orderBy)
//                       display_name orderBy
//                       documentation ```kotlin\nvararg orderBy: Pair<Expression<*>, SortOrder>\n```\n\n----\n\n Returns the order in which the elements of each group are sorted.
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(orderBy)
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                       display_name orderBy
//                       documentation ```kotlin\npublic get(): Array<out Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n Returns the order in which the elements of each group are sorted.
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                       display_name orderBy
//                       documentation ```kotlin\npublic final val orderBy: Array<out Pair<Expression<*>, SortOrder>>\n```\n\n----\n\n Returns the order in which the elements of each group are sorted.
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().(orderBy)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.groupConcat(this, queryBuilder)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#
  /**
   * Represents an SQL function that extract a substring from [expr] that begins at the specified [start] and with the specified [length].
   */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().
  class Substring<T : String?>(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#
//                display_name Substring
//                documentation ```kotlin\npublic final class Substring<T : String?> : Function<String>\n```\n\n----\n\n\n Represents an SQL function that extract a substring from [expr] that begins at the specified [start] and with the specified [length].\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().
//                display_name Substring
//                documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>, start: Expression<Int>, length: Expression<Int>): Substring<T>\n```\n\n----\n\n Returns the length of the substring.
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getExpr().
      private val expr: Expression<T>,
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(expr)
//                     display_name expr
//                     documentation ```kotlin\nexpr: Expression<T>\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(expr)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#expr.
//                     display_name expr
//                     documentation ```kotlin\nprivate final val expr: Expression<T>\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getExpr().
//                     display_name expr
//                     documentation ```kotlin\nprivate get(): Expression<T>\n```
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(expr)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#expr.
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(start)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#start.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getStart().
      private val start: Expression<Int>,
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(start)
//                      display_name start
//                      documentation ```kotlin\nstart: Expression<Int>\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(start)
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getStart().
//                      display_name start
//                      documentation ```kotlin\nprivate get(): Expression<Int>\n```
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#start.
//                      display_name start
//                      documentation ```kotlin\nprivate final val start: Expression<Int>\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(start)
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#start.
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getStart().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(length)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#length.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getLength().
      /** Returns the length of the substring. */
      val length: Expression<Int>
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(length)
//               display_name length
//               documentation ```kotlin\nlength: Expression<Int>\n```\n\n----\n\n Returns the length of the substring.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(length)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getLength().
//               display_name length
//               documentation ```kotlin\npublic get(): Expression<Int>\n```\n\n----\n\n Returns the length of the substring.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#length.
//               display_name length
//               documentation ```kotlin\npublic final val length: Expression<Int>\n```\n\n----\n\n Returns the length of the substring.
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().(length)
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#length.
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getLength().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.substring(expr, start, length, queryBuilder)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#expr.
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getExpr().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getStart().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#start.
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#getLength().
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#length.
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#
  /**
   * Represents an SQL function that remove the longest string containing only spaces from both ends of [expr]
   */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#[T]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().
  class Trim<T : String?>(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#
//           display_name Trim
//           documentation ```kotlin\npublic final class Trim<T : String?> : Function<String>\n```\n\n----\n\n\n Represents an SQL function that remove the longest string containing only spaces from both ends of [expr]\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().
//           display_name Trim
//           documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>): Trim<T>\n```\n\n----\n\n Returns the expression being trimmed.
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT : String?\n```
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#getExpr().
      /** Returns the expression being trimmed. */
      val expr: Expression<T>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression being trimmed.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression being trimmed.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression being trimmed.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#getExpr().
  ) : Function<String>(TextColumnType()) {
//    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("TRIM(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().(queryBuilder)
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#expr.
//                                                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().(queryBuilder)
//                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#
  /**
   * Represents an SQL function that returns the index of the first occurrence of [substring] in [expr] or 0
   */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(expr)
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#expr.
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getExpr().
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(substring)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#substring.
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getSubstring().
  class Locate<T : String?>(val expr: Expression<T>, val substring: String) : Function<Int>(IntegerColumnType()) {
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#
//             display_name Locate
//             documentation ```kotlin\npublic final class Locate<T : String?> : Function<Int>\n```\n\n----\n\n\n Represents an SQL function that returns the index of the first occurrence of [substring] in [expr] or 0\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().
//             display_name Locate
//             documentation ```kotlin\npublic constructor<T : String?>(expr: Expression<T>, substring: String): Locate<T>\n```
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT : String?\n```
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(expr)
//                                   display_name expr
//                                   documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(expr)
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#expr.
//                                   display_name expr
//                                   documentation ```kotlin\npublic final val expr: Expression<T>\n```
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getExpr().
//                                   display_name expr
//                                   documentation ```kotlin\npublic get(): Expression<T>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(substring)
//                                                                 display_name substring
//                                                                 documentation ```kotlin\nsubstring: String\n```
//                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(substring)
//                                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getSubstring().
//                                                                 display_name substring
//                                                                 documentation ```kotlin\npublic get(): String\n```
//                                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#substring.
//                                                                 display_name substring
//                                                                 documentation ```kotlin\npublic final val substring: String\n```
//                                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#[T]
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(expr)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#expr.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getExpr().
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().(substring)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#substring.
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getSubstring().
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) =
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.locate(queryBuilder, expr, substring)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().(queryBuilder)
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#expr.
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getExpr().
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#getSubstring().
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#substring.
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#
  
  // General-Purpose Aggregate Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
  /**
   * Represents an SQL function that returns the minimum value of [expr] across all non-null input values, or `null` if there are no non-null values.
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[T]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[S]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().
  class Min<T : Any, in S : T?>(
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
//          display_name Min
//          documentation ```kotlin\npublic final class Min<T : Any, in S : T?> : Function<T?>, WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns the minimum value of [expr] across all non-null input values, or `null` if there are no non-null values.\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().
//          display_name Min
//          documentation ```kotlin\npublic constructor<T : Any, in S : T?>(expr: Expression<in S>, columnType: IColumnType<T>): Min<T, S>\n```\n\n----\n\n Returns the expression from which the minimum value is obtained.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT : Any\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[S]
//                        display_name FirTypeParameterSymbol S
//                        documentation ```kotlin\nin S : T?\n```
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#[S]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#getExpr().
      /** Returns the expression from which the minimum value is obtained. */
      val expr: Expression<in S>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<in S>\n```\n\n----\n\n Returns the expression from which the minimum value is obtained.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<in S>\n```\n\n----\n\n Returns the expression from which the minimum value is obtained.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<in S>\n```\n\n----\n\n Returns the expression from which the minimum value is obtained.
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(expr)
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#expr.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(columnType)
      columnType: IColumnType<T>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T>\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(columnType)
  ) : Function<T?>(columnType), WindowFunction<T?> {
//    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().(columnType)
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("MIN(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#expr.
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().(queryBuilder)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Min#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Min#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
  /**
   * Represents an SQL function that returns the maximum value of [expr] across all non-null input values, or `null` if there are no non-null values.
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[T]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[S]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().
  class Max<T : Any, in S : T?>(
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
//          display_name Max
//          documentation ```kotlin\npublic final class Max<T : Any, in S : T?> : Function<T?>, WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns the maximum value of [expr] across all non-null input values, or `null` if there are no non-null values.\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().
//          display_name Max
//          documentation ```kotlin\npublic constructor<T : Any, in S : T?>(expr: Expression<in S>, columnType: IColumnType<T>): Max<T, S>\n```\n\n----\n\n Returns the expression from which the maximum value is obtained.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT : Any\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[S]
//                        display_name FirTypeParameterSymbol S
//                        documentation ```kotlin\nin S : T?\n```
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#[S]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#getExpr().
      /** Returns the expression from which the maximum value is obtained. */
      val expr: Expression<in S>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<in S>\n```\n\n----\n\n Returns the expression from which the maximum value is obtained.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<in S>\n```\n\n----\n\n Returns the expression from which the maximum value is obtained.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<in S>\n```\n\n----\n\n Returns the expression from which the maximum value is obtained.
//              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(expr)
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#expr.
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(columnType)
      columnType: IColumnType<T>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T>\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(columnType)
  ) : Function<T?>(columnType), WindowFunction<T?> {
//    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().(columnType)
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("MAX(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#expr.
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().(queryBuilder)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Max#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Max#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
  /**
   * Represents an SQL function that returns the average (arithmetic mean) of all non-null input values, or `null` if there are no non-null values.
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[T]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[S]
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().
  class Avg<T : Comparable<T>, S : T?>(
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
//          display_name Avg
//          documentation ```kotlin\npublic final class Avg<T : Comparable<T>, S : T?> : Function<BigDecimal?>, WindowFunction<BigDecimal?>\n```\n\n----\n\n\n Represents an SQL function that returns the average (arithmetic mean) of all non-null input values, or `null` if there are no non-null values.\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().
//          display_name Avg
//          documentation ```kotlin\npublic constructor<T : Comparable<T>, S : T?>(expr: Expression<S>, scale: Int): Avg<T, S>\n```\n\n----\n\n Returns the expression from which the average is calculated.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT : Comparable<T>\n```
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[S]
//                               display_name FirTypeParameterSymbol S
//                               documentation ```kotlin\nS : T?\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[T]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#[S]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#getExpr().
      /** Returns the expression from which the average is calculated. */
      val expr: Expression<S>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<S>\n```\n\n----\n\n Returns the expression from which the average is calculated.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<S>\n```\n\n----\n\n Returns the expression from which the average is calculated.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<S>\n```\n\n----\n\n Returns the expression from which the average is calculated.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(scale)
      scale: Int
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(scale)
//          display_name scale
//          documentation ```kotlin\nscale: Int\n```
//           ^^^ reference semanticdb maven . . kotlin/Int#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(scale)
  ) : Function<BigDecimal?>(DecimalColumnType(Int.MAX_VALUE, scale)), WindowFunction<BigDecimal?> {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().(scale)
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("AVG(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#expr.
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().(queryBuilder)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#over().
      override fun over(): WindowFunctionDefinition<BigDecimal?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
  /**
   * Represents an SQL function that returns the sum of [expr] across all non-null input values, or `null` if there are no non-null values.
   */
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().
  class Sum<T>(
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
//          display_name Sum
//          documentation ```kotlin\npublic final class Sum<T> : Function<T?>, WindowFunction<T?>\n```\n\n----\n\n\n Represents an SQL function that returns the sum of [expr] across all non-null input values, or `null` if there are no non-null values.\n
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().
//          display_name Sum
//          documentation ```kotlin\npublic constructor<T>(expr: Expression<T>, columnType: IColumnType<T & Any>): Sum<T>\n```\n\n----\n\n Returns the expression from which the sum is calculated.
//          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#[T]
//            display_name FirTypeParameterSymbol T
//            documentation ```kotlin\nT\n```
//          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#getExpr().
      /** Returns the expression from which the sum is calculated. */
      val expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```\n\n----\n\n Returns the expression from which the sum is calculated.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<T>\n```\n\n----\n\n Returns the expression from which the sum is calculated.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression from which the sum is calculated.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(columnType)
      columnType: IColumnType<T & Any>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(columnType)
  ) : Function<T?>(columnType), WindowFunction<T?> {
//    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().(columnType)
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder { append("SUM(", expr, ")") }
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().(queryBuilder)
//                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#expr.
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#getExpr().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().(queryBuilder)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#over().
      override fun over(): WindowFunctionDefinition<T?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<T?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
  /**
   * Represents an SQL function that returns the number of input rows for which the value of [expr] is not null.
   */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().
  class Count(
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
//            display_name Count
//            documentation ```kotlin\npublic final class Count : Function<Long>, WindowFunction<Long>\n```\n\n----\n\n\n Represents an SQL function that returns the number of input rows for which the value of [expr] is not null.\n
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().
//            display_name Count
//            documentation ```kotlin\npublic constructor(expr: Expression<*>, distinct: Boolean = ...): Count\n```\n\n----\n\n Returns the expression from which the rows are counted.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getExpr().
      /** Returns the expression from which the rows are counted. */
      val expr: Expression<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the expression from which the rows are counted.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(distinct)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#distinct.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getDistinct().
      /** Returns whether only distinct element should be count. */
      val distinct: Boolean = false
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(distinct)
//                 display_name distinct
//                 documentation ```kotlin\ndistinct: Boolean = ...\n```\n\n----\n\n Returns whether only distinct element should be count.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(distinct)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#distinct.
//                 display_name distinct
//                 documentation ```kotlin\npublic final val distinct: Boolean\n```\n\n----\n\n Returns whether only distinct element should be count.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getDistinct().
//                 display_name distinct
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Returns whether only distinct element should be count.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().(distinct)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#distinct.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getDistinct().
  ) : Function<Long>(LongColumnType()), WindowFunction<Long> {
//    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().(queryBuilder)
          +"COUNT("
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          if (distinct) +"DISTINCT "
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#distinct.
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getDistinct().
//                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          +expr
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#expr.
//         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#getExpr().
          +")"
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Count#over().
      override fun over(): WindowFunctionDefinition<Long> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Count#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<Long>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(LongColumnType(), this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
  
  // Aggregate Functions for Statistics
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
  /**
   * Represents an SQL function that returns the population standard deviation of the non-null input values,
   * or `null` if there are no non-null values.
   */
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().
  class StdDevPop<T>(
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
//                display_name StdDevPop
//                documentation ```kotlin\npublic final class StdDevPop<T> : Function<BigDecimal?>, WindowFunction<BigDecimal?>\n```\n\n----\n\n\n Represents an SQL function that returns the population standard deviation of the non-null input values,\n or `null` if there are no non-null values.\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().
//                display_name StdDevPop
//                documentation ```kotlin\npublic constructor<T>(expression: Expression<T>, scale: Int): StdDevPop<T>\n```\n\n----\n\n Returns the expression from which the population standard deviation is calculated.
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#getExpression().
      /** Returns the expression from which the population standard deviation is calculated. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n Returns the expression from which the population standard deviation is calculated.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n Returns the expression from which the population standard deviation is calculated.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression from which the population standard deviation is calculated.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(scale)
      scale: Int
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(scale)
//          display_name scale
//          documentation ```kotlin\nscale: Int\n```
//           ^^^ reference semanticdb maven . . kotlin/Int#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(scale)
  ) : Function<BigDecimal?>(DecimalColumnType(Int.MAX_VALUE, scale)), WindowFunction<BigDecimal?> {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().(scale)
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().(queryBuilder)
//            ⌄ enclosing_range_start local 3
//                                         ⌄ enclosing_range_start local 4
              val functionProvider = when (currentDialect.h2Mode) {
//                ^^^^^^^^^^^^^^^^ definition local 3
//                                 display_name functionProvider
//                                 documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 4
//                                                               display_name <when-subject>
//                                                               documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                             ⌃ enclosing_range_end local 4
                  H2Dialect.H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  else -> currentDialect.functionProvider
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
              }
//            ⌃ enclosing_range_end local 3
              functionProvider.stdDevPop(expression, this)
//            ^^^^^^^^^^^^^^^^ reference local 3
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#expression.
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#getExpression().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#over().
      override fun over(): WindowFunctionDefinition<BigDecimal?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
  /**
   * Represents an SQL function that returns the sample standard deviation of the non-null input values,
   * or `null` if there are no non-null values.
   */
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#[T]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().
  class StdDevSamp<T>(
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
//                 display_name StdDevSamp
//                 documentation ```kotlin\npublic final class StdDevSamp<T> : Function<BigDecimal?>, WindowFunction<BigDecimal?>\n```\n\n----\n\n\n Represents an SQL function that returns the sample standard deviation of the non-null input values,\n or `null` if there are no non-null values.\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().
//                 display_name StdDevSamp
//                 documentation ```kotlin\npublic constructor<T>(expression: Expression<T>, scale: Int): StdDevSamp<T>\n```\n\n----\n\n Returns the expression from which the sample standard deviation is calculated.
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT\n```
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#getExpression().
      /** Returns the expression from which the sample standard deviation is calculated. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n Returns the expression from which the sample standard deviation is calculated.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n Returns the expression from which the sample standard deviation is calculated.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression from which the sample standard deviation is calculated.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(scale)
      scale: Int
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(scale)
//          display_name scale
//          documentation ```kotlin\nscale: Int\n```
//           ^^^ reference semanticdb maven . . kotlin/Int#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(scale)
  ) : Function<BigDecimal?>(DecimalColumnType(Int.MAX_VALUE, scale)), WindowFunction<BigDecimal?> {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().(scale)
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().(queryBuilder)
//            ⌄ enclosing_range_start local 5
//                                         ⌄ enclosing_range_start local 6
              val functionProvider = when (currentDialect.h2Mode) {
//                ^^^^^^^^^^^^^^^^ definition local 5
//                                 display_name functionProvider
//                                 documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                                               display_name <when-subject>
//                                                               documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                             ⌃ enclosing_range_end local 6
                  H2Dialect.H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  else -> currentDialect.functionProvider
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
              }
//            ⌃ enclosing_range_end local 5
              functionProvider.stdDevSamp(expression, this)
//            ^^^^^^^^^^^^^^^^ reference local 5
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#expression.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#getExpression().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#over().
      override fun over(): WindowFunctionDefinition<BigDecimal?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
  /**
   * Represents an SQL function that returns the population variance of the non-null input values (square of the population standard deviation),
   * or `null` if there are no non-null values.
   */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#[T]
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().
  class VarPop<T>(
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
//             display_name VarPop
//             documentation ```kotlin\npublic final class VarPop<T> : Function<BigDecimal?>, WindowFunction<BigDecimal?>\n```\n\n----\n\n\n Represents an SQL function that returns the population variance of the non-null input values (square of the population standard deviation),\n or `null` if there are no non-null values.\n
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().
//             display_name VarPop
//             documentation ```kotlin\npublic constructor<T>(expression: Expression<T>, scale: Int): VarPop<T>\n```\n\n----\n\n Returns the expression from which the population variance is calculated.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#[T]
//               display_name FirTypeParameterSymbol T
//               documentation ```kotlin\nT\n```
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#getExpression().
      /** Returns the expression from which the population variance is calculated. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n Returns the expression from which the population variance is calculated.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n Returns the expression from which the population variance is calculated.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression from which the population variance is calculated.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(scale)
      scale: Int
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(scale)
//          display_name scale
//          documentation ```kotlin\nscale: Int\n```
//           ^^^ reference semanticdb maven . . kotlin/Int#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(scale)
  ) : Function<BigDecimal?>(DecimalColumnType(Int.MAX_VALUE, scale)), WindowFunction<BigDecimal?> {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().(scale)
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().(queryBuilder)
//            ⌄ enclosing_range_start local 7
//                                         ⌄ enclosing_range_start local 8
              val functionProvider = when (currentDialect.h2Mode) {
//                ^^^^^^^^^^^^^^^^ definition local 7
//                                 display_name functionProvider
//                                 documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 8
//                                                               display_name <when-subject>
//                                                               documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                             ⌃ enclosing_range_end local 8
                  H2Dialect.H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  else -> currentDialect.functionProvider
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
              }
//            ⌃ enclosing_range_end local 7
              functionProvider.varPop(expression, this)
//            ^^^^^^^^^^^^^^^^ reference local 7
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#expression.
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#getExpression().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#over().
      override fun over(): WindowFunctionDefinition<BigDecimal?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
  /**
   * Represents an SQL function that returns the sample variance of the non-null input values (square of the sample standard deviation),
   * or `null` if there are no non-null values.
   */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#[T]
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().
  class VarSamp<T>(
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
//              display_name VarSamp
//              documentation ```kotlin\npublic final class VarSamp<T> : Function<BigDecimal?>, WindowFunction<BigDecimal?>\n```\n\n----\n\n\n Represents an SQL function that returns the sample variance of the non-null input values (square of the sample standard deviation),\n or `null` if there are no non-null values.\n
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().
//              display_name VarSamp
//              documentation ```kotlin\npublic constructor<T>(expression: Expression<T>, scale: Int): VarSamp<T>\n```\n\n----\n\n Returns the expression from which the sample variance is calculated.
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(expression)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#getExpression().
      /** Returns the expression from which the sample variance is calculated. */
      val expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```\n\n----\n\n Returns the expression from which the sample variance is calculated.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(expression)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#expression.
//                   display_name expression
//                   documentation ```kotlin\npublic final val expression: Expression<T>\n```\n\n----\n\n Returns the expression from which the sample variance is calculated.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#getExpression().
//                   display_name expression
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n Returns the expression from which the sample variance is calculated.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(expression)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#expression.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#getExpression().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(scale)
      scale: Int
//    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(scale)
//          display_name scale
//          documentation ```kotlin\nscale: Int\n```
//           ^^^ reference semanticdb maven . . kotlin/Int#
//             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(scale)
  ) : Function<BigDecimal?>(DecimalColumnType(Int.MAX_VALUE, scale)), WindowFunction<BigDecimal?> {
//    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#MAX_VALUE.
//                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/Int#Companion#getMAX_VALUE().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().(scale)
//                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().(queryBuilder)
//            ⌄ enclosing_range_start local 9
//                                         ⌄ enclosing_range_start local 10
              val functionProvider = when (currentDialect.h2Mode) {
//                ^^^^^^^^^^^^^^^^ definition local 9
//                                 display_name functionProvider
//                                 documentation ```kotlin\nlocal val functionProvider: FunctionProvider\n```
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^^^^^^^^^ definition local 10
//                                                               display_name <when-subject>
//                                                               documentation ```kotlin\nlocal val <when-subject>: H2Dialect.H2CompatibilityMode?\n```
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                             ⌃ enclosing_range_end local 10
                  H2Dialect.H2CompatibilityMode.SQLServer -> H2FunctionProvider
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
                  else -> currentDialect.functionProvider
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
              }
//            ⌃ enclosing_range_end local 9
              functionProvider.varSamp(expression, this)
//            ^^^^^^^^^^^^^^^^ reference local 9
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#expression.
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#getExpression().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#over().
      override fun over(): WindowFunctionDefinition<BigDecimal?> {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#over().
//                      display_name over
//                      documentation ```kotlin\npublic open override fun over(): WindowFunctionDefinition<BigDecimal?>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunction#over().
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
          return WindowFunctionDefinition(columnType, this)
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#`<init>`().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#getColumnType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#over().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
  
  // Sequence Manipulation Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
  /**
   * Represents an SQL function that advances the specified [seq] and returns the new value.
   */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#[T]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().
  sealed class NextVal<T>(
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                     display_name NextVal
//                     documentation ```kotlin\npublic sealed class NextVal<T> : Function<T>\n```\n\n----\n\n\n Represents an SQL function that advances the specified [seq] and returns the new value.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().
//                     display_name NextVal
//                     documentation ```kotlin\nprotected constructor<T>(seq: Sequence, columnType: IColumnType<T & Any>): NextVal<T>\n```\n\n----\n\n Returns the sequence from which the next value is obtained.
//                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#[T]
//                       display_name FirTypeParameterSymbol T
//                       documentation ```kotlin\nT\n```
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(seq)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#seq.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#getSeq().
      /** Returns the sequence from which the next value is obtained. */
      val seq: Sequence,
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(seq)
//            display_name seq
//            documentation ```kotlin\nseq: Sequence\n```\n\n----\n\n Returns the sequence from which the next value is obtained.
//        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(seq)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#getSeq().
//            display_name seq
//            documentation ```kotlin\npublic get(): Sequence\n```\n\n----\n\n Returns the sequence from which the next value is obtained.
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#seq.
//            display_name seq
//            documentation ```kotlin\npublic final val seq: Sequence\n```\n\n----\n\n Returns the sequence from which the next value is obtained.
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(seq)
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#seq.
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#getSeq().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(columnType)
      columnType: IColumnType<T & Any>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(columnType)
  ) : Function<T>(columnType) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.nextVal(seq, queryBuilder)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#getSeq().
//                                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#seq.
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().(seq)
      class IntNextVal(seq: Sequence) : NextVal<Int>(seq, IntegerColumnType())
//          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#
//                     display_name IntNextVal
//                     documentation ```kotlin\npublic final class IntNextVal : NextVal<Int>\n```
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().
//                     display_name IntNextVal
//                     documentation ```kotlin\npublic constructor(seq: Sequence): NextVal.IntNextVal\n```
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().(seq)
//                         display_name seq
//                         documentation ```kotlin\nseq: Sequence\n```
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                                                   ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().(seq)
//                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().(seq)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().(seq)
      class LongNextVal(seq: Sequence) : NextVal<Long>(seq, LongColumnType())
//          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#
//                      display_name LongNextVal
//                      documentation ```kotlin\npublic final class LongNextVal : NextVal<Long>\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().
//                      display_name LongNextVal
//                      documentation ```kotlin\npublic constructor(seq: Sequence): NextVal.LongNextVal\n```
//                      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().(seq)
//                          display_name seq
//                          documentation ```kotlin\nseq: Sequence\n```
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().(seq)
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().(seq)
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
  
  // Conditional Expressions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#
  /**
   * Represents an SQL function that allows the comparison of [value] to chained conditional clauses.
   *
   * If [value] is not provided, each chained conditional will be evaluated independently.
   */
  @Suppress("FunctionNaming")
//          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
  class Case(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#
//           display_name Case
//           documentation ```kotlin\n@Suppress(...) public final class Case : Any\n```\n\n----\n\n\n Represents an SQL function that allows the comparison of [value] to chained conditional clauses.\n\n If [value] is not provided, each chained conditional will be evaluated independently.\n
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
//           display_name Case
//           documentation ```kotlin\npublic constructor(value: Expression<*>? = ...): Case\n```\n\n----\n\n The value that is compared against every conditional expression.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().(value)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#value.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#getValue().
      /** The value that is compared against every conditional expression. */
      val value: Expression<*>? = null
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().(value)
//              display_name value
//              documentation ```kotlin\nvalue: Expression<*>? = ...\n```\n\n----\n\n The value that is compared against every conditional expression.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().(value)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#getValue().
//              display_name value
//              documentation ```kotlin\npublic get(): Expression<*>?\n```\n\n----\n\n The value that is compared against every conditional expression.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#value.
//              display_name value
//              documentation ```kotlin\npublic final val value: Expression<*>?\n```\n\n----\n\n The value that is compared against every conditional expression.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().(value)
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#value.
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#getValue().
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().
      /** Adds a conditional expression with a [result] if the expression evaluates to `true`. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().[T]
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(cond)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(result)
      fun <T> When(cond: Expression<Boolean>, result: Expression<T>): CaseWhen<T> = CaseWhen<T>(value).When(cond, result)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().
//                 display_name When
//                 documentation ```kotlin\npublic final fun <T> When(cond: Expression<Boolean>, result: Expression<T>): CaseWhen<T>\n```\n\n----\n\n Adds a conditional expression with a [result] if the expression evaluates to `true`.
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(cond)
//                      display_name cond
//                      documentation ```kotlin\ncond: Expression<Boolean>\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(result)
//                                                   display_name result
//                                                   documentation ```kotlin\nresult: Expression<T>\n```
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
//                                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().
//                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#getValue().
//                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#value.
//                                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().
//                                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(cond)
//                                                                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(result)
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(cond)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().(result)
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Case#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
  /**
   * Represents an SQL function that allows the comparison of [value] to chained conditional clauses.
   *
   * If [value] is not provided, each chained conditional will be evaluated independently.
   */
  @Suppress("FunctionNaming")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#[T]
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().
  class CaseWhen<T>(
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
//               display_name CaseWhen
//               documentation ```kotlin\n@Suppress(...) public final class CaseWhen<T> : Any\n```\n\n----\n\n\n Represents an SQL function that allows the comparison of [value] to chained conditional clauses.\n\n If [value] is not provided, each chained conditional will be evaluated independently.\n
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().
//               display_name CaseWhen
//               documentation ```kotlin\npublic constructor<T>(value: Expression<*>?): CaseWhen<T>\n```\n\n----\n\n The value that is compared against every conditional expression.
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().(value)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#value.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getValue().
      /** The value that is compared against every conditional expression. */
      val value: Expression<*>?
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().(value)
//              display_name value
//              documentation ```kotlin\nvalue: Expression<*>?\n```\n\n----\n\n The value that is compared against every conditional expression.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().(value)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getValue().
//              display_name value
//              documentation ```kotlin\npublic get(): Expression<*>?\n```\n\n----\n\n The value that is compared against every conditional expression.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#value.
//              display_name value
//              documentation ```kotlin\npublic final val value: Expression<*>?\n```\n\n----\n\n The value that is compared against every conditional expression.
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().(value)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#value.
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getValue().
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
      /** The boolean conditions to check and their resulting expressions if the condition is met. */
      val cases: MutableList<Pair<Expression<Boolean>, Expression<out T>>> = mutableListOf()
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//              display_name cases
//              documentation ```kotlin\npublic final val cases: MutableList<Pair<Expression<Boolean>, Expression<out T>>>\n```\n\n----\n\n The boolean conditions to check and their resulting expressions if the condition is met.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
//              display_name cases
//              documentation ```kotlin\npublic get(): MutableList<Pair<Expression<Boolean>, Expression<out T>>>\n```\n\n----\n\n The boolean conditions to check and their resulting expressions if the condition is met.
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().
      /** Adds a conditional expression with a [result] if the expression evaluates to `true`. */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(cond)
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(result)
      fun When(cond: Expression<Boolean>, result: Expression<T>): CaseWhen<T> {
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().
//             display_name When
//             documentation ```kotlin\npublic final fun When(cond: Expression<Boolean>, result: Expression<T>): CaseWhen<T>\n```\n\n----\n\n Adds a conditional expression with a [result] if the expression evaluates to `true`.
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(cond)
//                  display_name cond
//                  documentation ```kotlin\ncond: Expression<Boolean>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(result)
//                                               display_name result
//                                               documentation ```kotlin\nresult: Expression<T>\n```
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(cond)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(result)
          cases.add(cond to result)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
//              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(cond)
//                       ^^ reference semanticdb maven . . kotlin/to().
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().(result)
          return this
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#When().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().
      /** Adds an expression that will be used as the function result if all [cases] evaluate to `false`. */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().(e)
      fun Else(e: Expression<T>): ExpressionWithColumnType<T> = CaseWhenElse(this, e)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().
//             display_name Else
//             documentation ```kotlin\npublic final fun Else(e: Expression<T>): ExpressionWithColumnType<T>\n```\n\n----\n\n Adds an expression that will be used as the function result if all [cases] evaluate to `false`.
//             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().(e)
//               display_name e
//               documentation ```kotlin\ne: Expression<T>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().
//                                                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().(e)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().(e)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#
  /**
   * Represents an SQL function that steps through conditions, and either returns a value when the first condition is met
   * or returns [elseResult] if all conditions are `false`.
   */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#[T]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().
  class CaseWhenElse<T>(
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#
//                   display_name CaseWhenElse
//                   documentation ```kotlin\npublic final class CaseWhenElse<T> : ExpressionWithColumnType<T>, ComplexExpression\n```\n\n----\n\n\n Represents an SQL function that steps through conditions, and either returns a value when the first condition is met\n or returns [elseResult] if all conditions are `false`.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().
//                   display_name CaseWhenElse
//                   documentation ```kotlin\npublic constructor<T>(caseWhen: CaseWhen<T>, elseResult: Expression<T>): CaseWhenElse<T>\n```\n\n----\n\n The conditions to check and their results if met.
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT\n```
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(caseWhen)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
      /** The conditions to check and their results if met. */
      val caseWhen: CaseWhen<T>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(caseWhen)
//                 display_name caseWhen
//                 documentation ```kotlin\ncaseWhen: CaseWhen<T>\n```\n\n----\n\n The conditions to check and their results if met.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(caseWhen)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//                 display_name caseWhen
//                 documentation ```kotlin\npublic final val caseWhen: CaseWhen<T>\n```\n\n----\n\n The conditions to check and their results if met.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//                 display_name caseWhen
//                 documentation ```kotlin\npublic get(): CaseWhen<T>\n```\n\n----\n\n The conditions to check and their results if met.
//                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(caseWhen)
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(elseResult)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#elseResult.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getElseResult().
      /** The result if none of the conditions checked are found to be `true`. */
      val elseResult: Expression<T>
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(elseResult)
//                   display_name elseResult
//                   documentation ```kotlin\nelseResult: Expression<T>\n```\n\n----\n\n The result if none of the conditions checked are found to be `true`.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(elseResult)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#elseResult.
//                   display_name elseResult
//                   documentation ```kotlin\npublic final val elseResult: Expression<T>\n```\n\n----\n\n The result if none of the conditions checked are found to be `true`.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getElseResult().
//                   display_name elseResult
//                   documentation ```kotlin\npublic get(): Expression<T>\n```\n\n----\n\n The result if none of the conditions checked are found to be `true`.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().(elseResult)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#elseResult.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getElseResult().
  ) : ExpressionWithColumnType<T>(), ComplexExpression {
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ComplexExpression#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#`<init>`().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#columnType.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getColumnType().
      @Suppress("UNCHECKED_CAST")
      override val columnType: IColumnType<T & Any> =
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#columnType.
//                            display_name columnType
//                            documentation ```kotlin\n@Suppress(...) public open override val columnType: IColumnType<T & Any>\n```
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getColumnType().
//                            display_name columnType
//                            documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
          expressions().filterIsInstance<ExpressionWithColumnType<T>>().firstOrNull()?.columnType
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#expressions().
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                 ⌄ enclosing_range_start local 11
              ?: expressions().filterIsInstance<Op.OpBoolean>().firstOrNull()?.let { BooleanColumnType.INSTANCE as IColumnType<T & Any> }
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#expressions().
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/filterIsInstance(+3).
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/firstOrNull(+19).
//                                                                             ^^^ reference semanticdb maven . . kotlin/let().
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 11
//                                                                                                                                        display_name it
//                                                                                                                                        documentation ```kotlin\nit: @NoInfer Op.OpBoolean\n```
//                                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#INSTANCE.
//                                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BooleanColumnType#Companion#getINSTANCE().
//                                                                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                                                                      ⌃ enclosing_range_end local 11
              ?: error("No column type has been found")
//               ^^^^^ reference semanticdb maven . . kotlin/error().
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#columnType.
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getColumnType().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#expressions().
      private fun expressions(): List<Expression<out T>> {
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#expressions().
//                            display_name expressions
//                            documentation ```kotlin\nprivate final fun expressions(): List<Expression<out T>>\n```
//                               ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌄ enclosing_range_start local 12
          return caseWhen.cases.map { it.second } + elseResult
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
//                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                  ^^^^^^^^^^^^^ definition local 12
//                                                display_name it
//                                                documentation ```kotlin\nit: Pair<Expression<Boolean>, Expression<out T>>\n```
//                                    ^^ reference local 12
//                                       ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                       ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                                ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#elseResult.
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getElseResult().
//                                              ⌃ enclosing_range_end local 12
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#expressions().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().(queryBuilder)
          queryBuilder {
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().(queryBuilder)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
              append("CASE")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
              if (caseWhen.value != null) {
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getValue().
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#value.
                  +" "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  +caseWhen.value
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getValue().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#value.
              }
  
//                 ⌄ enclosing_range_start local 14
//                  ⌄ enclosing_range_start local 15
//                         ⌄ enclosing_range_start local 16
//                                    ⌄ enclosing_range_start local 13
              for ((first, second) in caseWhen.cases) {
//                 ^^^^^^^^^^^^^^^ definition local 14
//                                 display_name <destruct>
//                                 documentation ```kotlin\nlocal val <destruct>: Pair<Expression<Boolean>, Expression<out T>>\n```
//                  ^^^^^ reference local 14
//                  ^^^^^ definition local 15
//                        display_name first
//                        documentation ```kotlin\nlocal val first: Expression<Boolean>\n```
//                  ^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                         ^^^^^^ reference local 14
//                         ^^^^^^ definition local 16
//                                display_name second
//                                documentation ```kotlin\nlocal val second: Expression<out T>\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#caseWhen.
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getCaseWhen().
//                                    ^^^^^^^^^^^^^^ definition local 13
//                                                   display_name <iterator>
//                                                   documentation ```kotlin\nlocal val <iterator>: MutableIterator<Pair<Expression<Boolean>, Expression<out T>>>\n```
//                                    ^^^^^^^^^^^^^^ reference local 13
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#hasNext().
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableIterator#next().
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#iterator().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#cases.
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#getCases().
//                      ⌃ enclosing_range_end local 15
//                              ⌃ enclosing_range_end local 16
//                               ⌃ enclosing_range_end local 14
//                                                 ⌃ enclosing_range_end local 13
                  append(" WHEN ", first, " THEN ", second)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                 ^^^^^ reference local 15
//                                                  ^^^^^^ reference local 16
              }
  
              append(" ELSE ", elseResult, " END")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#elseResult.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#getElseResult().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#
  /**
   * Represents an SQL function that returns the first of its arguments that is not null.
   */
  @Suppress("UNCHECKED_CAST")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[S]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().
  class Coalesce<T, S : T?>(
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#
//               display_name Coalesce
//               documentation ```kotlin\n@Suppress(...) public final class Coalesce<T, S : T?> : Function<T>\n```\n\n----\n\n\n Represents an SQL function that returns the first of its arguments that is not null.\n
//               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().
//               display_name Coalesce
//               documentation ```kotlin\npublic constructor<T, S : T?>(expr: ExpressionWithColumnType<S>, alternate: Expression<out T>, vararg others: Expression<out T>): Coalesce<T, S>\n```
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : T?\n```
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[T]
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#[S]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getExpr().
      private val expr: ExpressionWithColumnType<S>,
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(expr)
//                     display_name expr
//                     documentation ```kotlin\nexpr: ExpressionWithColumnType<S>\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(expr)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#expr.
//                     display_name expr
//                     documentation ```kotlin\nprivate final val expr: ExpressionWithColumnType<S>\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getExpr().
//                     display_name expr
//                     documentation ```kotlin\nprivate get(): ExpressionWithColumnType<S>\n```
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(expr)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#expr.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(alternate)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#alternate.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getAlternate().
      private val alternate: Expression<out T>,
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(alternate)
//                          display_name alternate
//                          documentation ```kotlin\nalternate: Expression<out T>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(alternate)
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#alternate.
//                          display_name alternate
//                          documentation ```kotlin\nprivate final val alternate: Expression<out T>\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getAlternate().
//                          display_name alternate
//                          documentation ```kotlin\nprivate get(): Expression<out T>\n```
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(alternate)
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#alternate.
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getAlternate().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(others)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#others.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getOthers().
      private vararg val others: Expression<out T>
//                       ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(others)
//                              display_name others
//                              documentation ```kotlin\nvararg others: Expression<out T>\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(others)
//                       ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getOthers().
//                              display_name others
//                              documentation ```kotlin\nprivate get(): Array<out Expression<out T>>\n```
//                       ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#others.
//                              display_name others
//                              documentation ```kotlin\nprivate final val others: Array<out Expression<out T>>\n```
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(others)
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#others.
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getOthers().
  ) : Function<T>(expr.columnType as IColumnType<T & Any>) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().(expr)
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                   ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                             ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().(queryBuilder)
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().(queryBuilder)
          (listOf(expr, alternate) + others).appendTo(
//         ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+1).
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#expr.
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getExpr().
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#alternate.
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getAlternate().
//                                 ^ reference semanticdb maven . . kotlin/collections/plus(+30).
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#getOthers().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#others.
//                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
              prefix = "COALESCE(",
              postfix = ")",
              separator = ", "
//          ⌄ enclosing_range_start local 17
          ) { +it }
//          ^^^^^^^ definition local 17
//                  display_name it
//                  documentation ```kotlin\nit: Expression<out T?>\n```
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference local 17
//                ⌃ enclosing_range_end local 17
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#
  
  // Value Expressions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#
  /**
   * Represents an SQL function that specifies a conversion from one data type to another.
   */
//           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#[T]
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().
  class Cast<T>(
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#
//           display_name Cast
//           documentation ```kotlin\npublic final class Cast<T> : Function<T>\n```\n\n----\n\n\n Represents an SQL function that specifies a conversion from one data type to another.\n
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().
//           display_name Cast
//           documentation ```kotlin\npublic constructor<T>(expr: Expression<*>, columnType: IColumnType<T & Any>): Cast<T>\n```\n\n----\n\n Returns the expression being casted.
//           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#[T]
//             display_name FirTypeParameterSymbol T
//             documentation ```kotlin\nT\n```
//           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(expr)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#expr.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#getExpr().
      /** Returns the expression being casted. */
      val expr: Expression<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<*>\n```\n\n----\n\n Returns the expression being casted.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(expr)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#expr.
//             display_name expr
//             documentation ```kotlin\npublic final val expr: Expression<*>\n```\n\n----\n\n Returns the expression being casted.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#getExpr().
//             display_name expr
//             documentation ```kotlin\npublic get(): Expression<*>\n```\n\n----\n\n Returns the expression being casted.
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(expr)
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#expr.
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#getExpr().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(columnType)
      columnType: IColumnType<T & Any>
//    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(columnType)
//               display_name columnType
//               documentation ```kotlin\ncolumnType: IColumnType<T & Any>\n```
//                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(columnType)
  ) : Function<T>(columnType) {
//    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().(columnType)
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().(queryBuilder)
      override fun toQueryBuilder(queryBuilder: QueryBuilder) {
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic open override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().(queryBuilder)
          currentDialect.functionProvider.cast(expr, columnType, queryBuilder)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#expr.
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#getExpr().
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#columnType.
//                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#getColumnType().
//                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().(queryBuilder)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#toQueryBuilder().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#
