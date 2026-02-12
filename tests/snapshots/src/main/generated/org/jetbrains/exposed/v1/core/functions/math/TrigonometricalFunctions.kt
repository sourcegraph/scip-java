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
  
  /**
   *   Returns the arc cosine of a number
   */
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
      functionName = "ACOS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ACosFunction#`<init>`().(expression)
  )
  
  /**
   *   Returns the arc sine of a number
   */
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
      functionName = "ASIN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ASinFunction#`<init>`().(expression)
  )
  
  /**
   *   Returns the arc tangent of a number
   */
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
      functionName = "ATAN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ATanFunction#`<init>`().(expression)
  )
  
  /**
   *   Returns the cosine of a number
   */
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
      functionName = "COS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CosFunction#`<init>`().(expression)
  )
  
  /**
   * Returns the cotangent of a number
   */
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
      functionName = "COT",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CotFunction#`<init>`().(expression)
  )
  
  /**
   * Convert a radian value into degrees:
   */
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
      functionName = "DEGREES",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/DegreesFunction#`<init>`().(expression)
  )
  
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
  
  /**
   * Convert a radian value into degrees:
   */
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
      functionName = "RADIANS",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RadiansFunction#`<init>`().(expression)
  )
  
  /**
   *   Returns the sine of a number
   */
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
      functionName = "SIN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SinFunction#`<init>`().(expression)
  )
  
  /**
   *   Returns the tangent of a number
   */
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
      functionName = "TAN",
      columnType = DecimalColumnType.INSTANCE,
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
      expr = arrayOf(expression)
//           ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/TanFunction#`<init>`().(expression)
  )
