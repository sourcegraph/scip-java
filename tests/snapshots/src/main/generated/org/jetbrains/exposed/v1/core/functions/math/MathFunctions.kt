package org.jetbrains.exposed.v1.core.functions.math
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import org.jetbrains.exposed.v1.core.vendors.H2Dialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
import org.jetbrains.exposed.v1.core.vendors.OracleDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
import org.jetbrains.exposed.v1.core.vendors.SQLiteDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
import org.jetbrains.exposed.v1.core.vendors.currentDialectIfAvailable
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
import org.jetbrains.exposed.v1.core.vendors.h2Mode
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
import java.math.BigDecimal
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/math/
//               ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
import java.math.MathContext
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/math/
//               ^^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#

/**
 * Returns the absolute value of a number
 */
class AbsFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<T>(
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#
//                display_name AbsFunction
//                documentation ```kotlin\npublic final class AbsFunction<T : Number?> : CustomFunction<T>\n```\n\n----\n\n\n Returns the absolute value of a number\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#`<init>`().
//                display_name AbsFunction
//                documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): AbsFunction<T>\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Number?\n```
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#`<init>`().(expression)
//                                        display_name expression
//                                        documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "ABS",
    columnType = expression.columnType,
//               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#`<init>`().(expression)
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/AbsFunction#`<init>`().(expression)
)

/**
 * Returns the smallest integer value that is >= a number
 */
class CeilingFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<Long?>(
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#
//                    display_name CeilingFunction
//                    documentation ```kotlin\npublic final class CeilingFunction<T : Number?> : CustomFunction<Long?>\n```\n\n----\n\n\n Returns the smallest integer value that is >= a number\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#`<init>`().
//                    display_name CeilingFunction
//                    documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): CeilingFunction<T>\n```
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nT : Number?\n```
//                                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#`<init>`().(expression)
//                                            display_name expression
//                                            documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = if (
        currentDialectIfAvailable is SQLiteDialect || currentDialectIfAvailable is OracleDialect ||
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
        currentDialectIfAvailable?.h2Mode == H2Dialect.H2CompatibilityMode.Oracle
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#Oracle.
    ) {
        "CEIL"
    } else {
        "CEILING"
    },
    columnType = LongColumnType(),
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/CeilingFunction#`<init>`().(expression)
)

/**
 * →Returns e raised to the power of a specified number
 */
class ExpFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#
//                display_name ExpFunction
//                documentation ```kotlin\npublic final class ExpFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns e raised to the power of a specified number\n
//                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#`<init>`().
//                display_name ExpFunction
//                documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): ExpFunction<T>\n```
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : Number?\n```
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#`<init>`().(expression)
//                                        display_name expression
//                                        documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "EXP",
    columnType = DecimalColumnType.INSTANCE,
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/ExpFunction#`<init>`().(expression)
)

/**
 * →Returns the largest integer value that is <= to a number
 */
class FloorFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<Long?>(
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#
//                  display_name FloorFunction
//                  documentation ```kotlin\npublic final class FloorFunction<T : Number?> : CustomFunction<Long?>\n```\n\n----\n\n\n \tReturns the largest integer value that is <= to a number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#`<init>`().
//                  display_name FloorFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): FloorFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "FLOOR",
    columnType = LongColumnType(),
//               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/FloorFunction#`<init>`().(expression)
)

/**
 * →Returns the value of a number raised to the power of another number
 */
class PowerFunction<B : Number?, E : Number?>(
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#
//                  display_name PowerFunction
//                  documentation ```kotlin\npublic final class PowerFunction<B : Number?, E : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the value of a number raised to the power of another number\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().
//                  display_name PowerFunction
//                  documentation ```kotlin\npublic constructor<B : Number?, E : Number?>(base: ExpressionWithColumnType<B>, exponent: Expression<E>, precision: Int = ..., scale: Int = ...): PowerFunction<B, E>\n```\n\n----\n\n Count of decimal digits in the fractional part.
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#[B]
//                    display_name FirTypeParameterSymbol B
//                    documentation ```kotlin\nB : Number?\n```
//                               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#[E]
//                                 display_name FirTypeParameterSymbol E
//                                 documentation ```kotlin\nE : Number?\n```
    base: ExpressionWithColumnType<B>,
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(base)
//       display_name base
//       documentation ```kotlin\nbase: ExpressionWithColumnType<B>\n```
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
    exponent: Expression<E>,
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(exponent)
//           display_name exponent
//           documentation ```kotlin\nexponent: Expression<E>\n```
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
    precision: Int = MathContext.DECIMAL64.precision,
//  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(precision)
//            display_name precision
//            documentation ```kotlin\nprecision: Int = ...\n```
//             ^^^ reference semanticdb maven . . kotlin/Int#
//                               ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#DECIMAL64.
//                                         ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#getPrecision().
//                                         ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#precision.
    /** Count of decimal digits in the fractional part. */
    scale: Int = 10
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(scale)
//        display_name scale
//        documentation ```kotlin\nscale: Int = ...\n```\n\n----\n\n Count of decimal digits in the fractional part.
//         ^^^ reference semanticdb maven . . kotlin/Int#
) : CustomFunction<BigDecimal?>(
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "POWER",
    columnType = DecimalColumnType(precision, scale),
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(precision)
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(scale)
    expr = arrayOf(base, exponent)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(base)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/PowerFunction#`<init>`().(exponent)
)

/**
 * →Rounds a number to a specified number of decimal places
 */
class RoundFunction<T : Number?>(expression: ExpressionWithColumnType<T>, scale: Int) : CustomFunction<BigDecimal?>(
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#
//                  display_name RoundFunction
//                  documentation ```kotlin\npublic final class RoundFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tRounds a number to a specified number of decimal places\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().
//                  display_name RoundFunction
//                  documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>, scale: Int): RoundFunction<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#[T]
//                    display_name FirTypeParameterSymbol T
//                    documentation ```kotlin\nT : Number?\n```
//                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().(expression)
//                                          display_name expression
//                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().(scale)
//                                                                              display_name scale
//                                                                              documentation ```kotlin\nscale: Int\n```
//                                                                               ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "ROUND",
    columnType = DecimalColumnType(MathContext.DECIMAL64.precision, scale).apply { nullable = true },
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                             ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#DECIMAL64.
//                                                       ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#getPrecision().
//                                                       ^^^^^^^^^ reference semanticdb maven jdk 11 java/math/MathContext#precision.
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().(scale)
//                                                                         ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#getNullable().
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#nullable.
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#setNullable().
    expr = arrayOf(expression, intLiteral(scale))
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().(expression)
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/RoundFunction#`<init>`().(scale)
)

/**
 * Returns the sign of a number:
 *  -1 - negative number
 *  0 - number is 0
 *  1 - positive number
 */
class SignFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<Int?>(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#
//                 display_name SignFunction
//                 documentation ```kotlin\npublic final class SignFunction<T : Number?> : CustomFunction<Int?>\n```\n\n----\n\n\n Returns the sign of a number:\n  -1 - negative number\n  0 - number is 0\n  1 - positive number\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#`<init>`().
//                 display_name SignFunction
//                 documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): SignFunction<T>\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT : Number?\n```
//                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#`<init>`().(expression)
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "SIGN",
    columnType = IntegerColumnType(),
//               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IntegerColumnType#`<init>`().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SignFunction#`<init>`().(expression)
)

/**
 * →Returns the square root of a number
 */
class SqrtFunction<T : Number?>(expression: ExpressionWithColumnType<T>) : CustomFunction<BigDecimal?>(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#
//                 display_name SqrtFunction
//                 documentation ```kotlin\npublic final class SqrtFunction<T : Number?> : CustomFunction<BigDecimal?>\n```\n\n----\n\n\n \tReturns the square root of a number\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#`<init>`().
//                 display_name SqrtFunction
//                 documentation ```kotlin\npublic constructor<T : Number?>(expression: ExpressionWithColumnType<T>): SqrtFunction<T>\n```
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT : Number?\n```
//                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#`<init>`().(expression)
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: ExpressionWithColumnType<T>\n```
//                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
    functionName = "SQRT",
    columnType = DecimalColumnType.INSTANCE,
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#INSTANCE.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#Companion#getINSTANCE().
    expr = arrayOf(expression)
//         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/math/SqrtFunction#`<init>`().(expression)
)
