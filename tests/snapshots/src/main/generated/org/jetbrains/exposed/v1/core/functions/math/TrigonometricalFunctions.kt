  package org.jetbrains.exposed.v1.core.functions.math
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/
  
  import org.jetbrains.exposed.v1.core.CustomFunction
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
  import org.jetbrains.exposed.v1.core.DecimalColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#
  import org.jetbrains.exposed.v1.core.ExpressionWithColumnType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#
  /**
   *   Returns the arc cosine of a number
   */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().(expression)
  class ACosFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#
//                   display_name ACosFunction
//                   documentation ```kotlin\npublic final class ACosFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the arc cosine of a number\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().
//                   display_name ACosFunction
//                   documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): ACosFunction<T>\n```
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT : Number?\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#[T]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().(expression)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().
      functionName = "ACOS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#
  /**
   *   Returns the arc sine of a number
   */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().(expression)
  class ASinFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#
//                   display_name ASinFunction
//                   documentation ```kotlin\npublic final class ASinFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the arc sine of a number\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().
//                   display_name ASinFunction
//                   documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): ASinFunction<T>\n```
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT : Number?\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#[T]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().(expression)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().
      functionName = "ASIN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#
  /**
   *   Returns the arc tangent of a number
   */
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#[T]
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().(expression)
  class ATanFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#
//                   display_name ATanFunction
//                   documentation ```kotlin\npublic final class ATanFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the arc tangent of a number\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().
//                   display_name ATanFunction
//                   documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): ATanFunction<T>\n```
//                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#[T]
//                     display_name FirTypeParameterSymbol T
//                     documentation ```kotlin\nT : Number?\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().(expression)
//                                           display_name expression
//                                           documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#[T]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().(expression)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().
      functionName = "ATAN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#
  /**
   *   Returns the cosine of a number
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().(expression)
  class CosFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#
//                  display_name CosFunction
//                  documentation ```kotlin\npublic final class CosFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the cosine of a number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().
//                  display_name CosFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): CosFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().(expression)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().
      functionName = "COS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#
  /**
   * Returns the cotangent of a number
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().(expression)
  class CotFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#
//                  display_name CotFunction
//                  documentation ```kotlin\npublic final class CotFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n Returns the cotangent of a number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().
//                  display_name CotFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): CotFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().(expression)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().
      functionName = "COT",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#
  /**
   * Convert a radian value into degrees:
   */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().(expression)
  class DegreesFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#
//                      display_name DegreesFunction
//                      documentation ```kotlin\npublic final class DegreesFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n Convert a radian value into degrees:\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().
//                      display_name DegreesFunction
//                      documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): DegreesFunction<T>\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT : Number?\n```
//                                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().(expression)
//                                              display_name expression
//                                              documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#[T]
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().(expression)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().
      functionName = "DEGREES",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#`<init>`().
  /**
   *   Returns the value of PI
   */
  object PiFunction : CustomFunction<BigDecimal>(
//       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#
//                  display_name PiFunction
//                  documentation ```kotlin\npublic final object PiFunction : CustomFunction<BigDecimal>\n```\n\n----\n\n\n \tReturns the value of PI\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//       ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#`<init>`().
//                  display_name PiFunction
//                  documentation ```kotlin\nprivate constructor(): PiFunction\n```\n\n----\n\n\n \tReturns the value of PI\n
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
      functionName = "PI",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf()
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PiFunction#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#
  /**
   * Convert a radian value into degrees:
   */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().(expression)
  class RadiansFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#
//                      display_name RadiansFunction
//                      documentation ```kotlin\npublic final class RadiansFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n Convert a radian value into degrees:\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().
//                      display_name RadiansFunction
//                      documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): RadiansFunction<T>\n```
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#[T]
//                        display_name FirTypeParameterSymbol T
//                        documentation ```kotlin\nT : Number?\n```
//                                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().(expression)
//                                              display_name expression
//                                              documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#[T]
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().(expression)
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().
      functionName = "RADIANS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#
  /**
   *   Returns the sine of a number
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().(expression)
  class SinFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#
//                  display_name SinFunction
//                  documentation ```kotlin\npublic final class SinFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the sine of a number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().
//                  display_name SinFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): SinFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().(expression)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().
      functionName = "SIN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#
  /**
   *   Returns the tangent of a number
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().
//                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().(expression)
  class TanFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#
//                  display_name TanFunction
//                  documentation ```kotlin\npublic final class TanFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the tangent of a number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().
//                  display_name TanFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): TanFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().(expression)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().
      functionName = "TAN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().(expression)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#
