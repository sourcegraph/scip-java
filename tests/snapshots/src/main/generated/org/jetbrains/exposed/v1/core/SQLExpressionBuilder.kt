  @file:Suppress("internal", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
  
  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.dao.id.CompositeID
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/
//                                         ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#
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
  import org.jetbrains.exposed.v1.core.functions.array.ArrayGet
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/
//                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
  import org.jetbrains.exposed.v1.core.functions.array.ArraySlice
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/
//                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
  import org.jetbrains.exposed.v1.core.ops.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/
  import org.jetbrains.exposed.v1.core.vendors.FunctionProvider
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  import java.math.BigDecimal
//       ^^^^ reference semanticdb maven . . java/
//            ^^^^ reference semanticdb maven . . java/math/
//                 ^^^^^^^^^^ reference semanticdb maven jdk 11 java/math/BigDecimal#
  import kotlin.internal.LowPriorityInOverloadResolution
//       ^^^^^^ reference semanticdb maven . . kotlin/
//              ^^^^^^^^ reference semanticdb maven . . kotlin/internal/
//                       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/internal/LowPriorityInOverloadResolution#
  
  // String Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().
  /** Returns the length of this string expression, measured in characters, or `null` if this expression is null. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().[T]
  fun <T : String?> Expression<T>.charLength(): CharLength<T> = CharLength(this)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().
//                                           display_name charLength
//                                           documentation ```kotlin\npublic final fun <T : String?> Expression<T>.charLength(): CharLength<T>\n```\n\n----\n\n Returns the length of this string expression, measured in characters, or `null` if this expression is null.
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#
//                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CharLength#`<init>`().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().[T]
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().
  /** Converts this string expression to lower case. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().[T]
  fun <T : String?> Expression<T>.lowerCase(): LowerCase<T> = LowerCase(this)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().
//                                          display_name lowerCase
//                                          documentation ```kotlin\npublic final fun <T : String?> Expression<T>.lowerCase(): LowerCase<T>\n```\n\n----\n\n Converts this string expression to lower case.
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LowerCase#`<init>`().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().[T]
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/lowerCase().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().
  /** Converts this string expression to upper case. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().[T]
  fun <T : String?> Expression<T>.upperCase(): UpperCase<T> = UpperCase(this)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().
//                                          display_name upperCase
//                                          documentation ```kotlin\npublic final fun <T : String?> Expression<T>.upperCase(): UpperCase<T>\n```\n\n----\n\n Converts this string expression to upper case.
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/UpperCase#`<init>`().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().[T]
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/upperCase().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().
  /**
   * Concatenates all non-null input values of each group from [this] string expression, separated by [separator].
   *
   * @param separator The separator to use between concatenated values. If left `null`, the database default will be used.
   * @param distinct If set to `true`, duplicate values will be eliminated.
   * @param orderBy If specified, values will be sorted in the concatenated string.
   * @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupConcat
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().[T]
  fun <T : String?> Expression<T>.groupConcat(
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().
//                                            display_name groupConcat
//                                            documentation ```kotlin\npublic final fun <T : String?> Expression<T>.groupConcat(separator: String? = ..., distinct: Boolean = ..., orderBy: Pair<Expression<*>, SortOrder>): GroupConcat<T>\n```\n\n----\n\n\n Concatenates all non-null input values of each group from [this] string expression, separated by [separator].\n\n @param separator The separator to use between concatenated values. If left `null`, the database default will be used.\n @param distinct If set to `true`, duplicate values will be eliminated.\n @param orderBy If specified, values will be sorted in the concatenated string.\n @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupConcat\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(separator)
      separator: String? = null,
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(separator)
//              display_name separator
//              documentation ```kotlin\nseparator: String? = ...\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(separator)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(distinct)
      distinct: Boolean = false,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(distinct)
//             display_name distinct
//             documentation ```kotlin\ndistinct: Boolean = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(distinct)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(orderBy)
      orderBy: Pair<Expression<*>, SortOrder>
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(orderBy)
//            display_name orderBy
//            documentation ```kotlin\norderBy: Pair<Expression<*>, SortOrder>\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(orderBy)
  ): GroupConcat<T> = GroupConcat(this, separator, distinct, orderBy)
//   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(separator)
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(distinct)
//                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().(orderBy)
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).
  /**
   * Concatenates all non-null input values of each group from [this] string expression, separated by [separator].
   *
   * @param separator The separator to use between concatenated values. If left `null`, the database default will be used.
   * @param distinct If set to `true`, duplicate values will be eliminated.
   * @param orderBy If specified, values will be sorted in the concatenated string.
   * @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupConcat
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).[T]
  fun <T : String?> Expression<T>.groupConcat(
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).
//                                            display_name groupConcat
//                                            documentation ```kotlin\npublic final fun <T : String?> Expression<T>.groupConcat(separator: String? = ..., distinct: Boolean = ..., orderBy: Array<Pair<Expression<*>, SortOrder>> = ...): GroupConcat<T>\n```\n\n----\n\n\n Concatenates all non-null input values of each group from [this] string expression, separated by [separator].\n\n @param separator The separator to use between concatenated values. If left `null`, the database default will be used.\n @param distinct If set to `true`, duplicate values will be eliminated.\n @param orderBy If specified, values will be sorted in the concatenated string.\n @sample org.jetbrains.exposed.v1.tests.shared.dml.GroupByTests.testGroupConcat\n
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(separator)
      separator: String? = null,
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(separator)
//              display_name separator
//              documentation ```kotlin\nseparator: String? = ...\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(separator)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(distinct)
      distinct: Boolean = false,
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(distinct)
//             display_name distinct
//             documentation ```kotlin\ndistinct: Boolean = ...\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(distinct)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(orderBy)
      orderBy: Array<Pair<Expression<*>, SortOrder>> = emptyArray()
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(orderBy)
//            display_name orderBy
//            documentation ```kotlin\norderBy: Array<Pair<Expression<*>, SortOrder>> = ...\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/emptyArray().
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(orderBy)
  ): GroupConcat<T> = GroupConcat(this, separator, distinct, orderBy = orderBy)
//   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#`<init>`().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(separator)
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(distinct)
//                                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).(orderBy)
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/groupConcat(+1).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/substring().
  /** Extract a substring from this string expression that begins at the specified [start] and with the specified [length]. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/substring().[T]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(start)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(length)
  fun <T : String?> Expression<T>.substring(start: Int, length: Int): Substring<T> = Substring(this, intLiteral(start), intLiteral(length))
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/substring().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/substring().
//                                          display_name substring
//                                          documentation ```kotlin\npublic final fun <T : String?> Expression<T>.substring(start: Int, length: Int): Substring<T>\n```\n\n----\n\n Extract a substring from this string expression that begins at the specified [start] and with the specified [length].
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(start)
//                                                display_name start
//                                                documentation ```kotlin\nstart: Int\n```
//                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(length)
//                                                             display_name length
//                                                             documentation ```kotlin\nlength: Int\n```
//                                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#
//                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Substring#`<init>`().
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(start)
//                                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(length)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/substring().[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(start)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/substring().(length)
//                                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/substring().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/trim().
  /** Removes the longest string containing only spaces from both ends of string expression. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/trim().[T]
  fun <T : String?> Expression<T>.trim(): Trim<T> = Trim(this)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/trim().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/trim().
//                                     display_name trim
//                                     documentation ```kotlin\npublic final fun <T : String?> Expression<T>.trim(): Trim<T>\n```\n\n----\n\n Removes the longest string containing only spaces from both ends of string expression.
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Trim#`<init>`().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/trim().[T]
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/trim().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/locate().
  /** Returns the index of the first occurrence of [substring] in this string expression or 0 if it doesn't contain [substring] */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/locate().[T]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/locate().(substring)
  fun <T : String?> Expression<T>.locate(substring: String): Locate<T> = Locate(this, substring)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/locate().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : String?\n```
//                                ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/locate().
//                                       display_name locate
//                                       documentation ```kotlin\npublic final fun <T : String?> Expression<T>.locate(substring: String): Locate<T>\n```\n\n----\n\n Returns the index of the first occurrence of [substring] in this string expression or 0 if it doesn't contain [substring]
//                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/locate().(substring)
//                                                 display_name substring
//                                                 documentation ```kotlin\nsubstring: String\n```
//                                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Locate#`<init>`().
//                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/locate().(substring)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/locate().[T]
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/locate().(substring)
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/locate().
  
  // General-Purpose Aggregate Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/min().
  /** Returns the minimum value of this expression across all non-null input values, or `null` if there are no non-null values. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/min().[T]
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/min().[S]
  fun <T : Any, S : T?> ExpressionWithColumnType<in S>.min(): Min<T, S> = Min<T, S>(this, this.columnType as IColumnType<T>)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/min().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/min().[S]
//                display_name FirTypeParameterSymbol S
//                documentation ```kotlin\nS : T?\n```
//                                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/min().
//                                                         display_name min
//                                                         documentation ```kotlin\npublic final fun <T : Any, S : T?> ExpressionWithColumnType<in S>.min(): Min<T, S>\n```\n\n----\n\n Returns the minimum value of this expression across all non-null input values, or `null` if there are no non-null values.
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Min#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/min().[T]
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/min().[S]
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/min().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/max().
  /** Returns the maximum value of this expression across all non-null input values, or `null` if there are no non-null values. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/max().[T]
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/max().[S]
  fun <T : Any, S : T?> ExpressionWithColumnType<in S>.max(): Max<T, S> = Max<T, S>(this, this.columnType as IColumnType<T>)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/max().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Any\n```
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/max().[S]
//                display_name FirTypeParameterSymbol S
//                documentation ```kotlin\nS : T?\n```
//                                                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/max().
//                                                         display_name max
//                                                         documentation ```kotlin\npublic final fun <T : Any, S : T?> ExpressionWithColumnType<in S>.max(): Max<T, S>\n```\n\n----\n\n Returns the maximum value of this expression across all non-null input values, or `null` if there are no non-null values.
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#
//                                                                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Max#`<init>`().
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/max().[T]
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/max().[S]
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/max().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/avg().
  /** Returns the average (arithmetic mean) value of this expression across all non-null input values, or `null` if there are no non-null values. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[S]
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/avg().(scale)
  fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<S>.avg(scale: Int = 2): Avg<T, S> = Avg<T, S>(this, scale)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT : Comparable<T>\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[S]
//                          display_name FirTypeParameterSymbol S
//                          documentation ```kotlin\nS : T?\n```
//                                                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/avg().
//                                                                display_name avg
//                                                                documentation ```kotlin\npublic final fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<S>.avg(scale: Int = ...): Avg<T, S>\n```\n\n----\n\n Returns the average (arithmetic mean) value of this expression across all non-null input values, or `null` if there are no non-null values.
//                                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/avg().(scale)
//                                                                      display_name scale
//                                                                      documentation ```kotlin\nscale: Int = ...\n```
//                                                                       ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#
//                                                                                             ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Avg#`<init>`().
//                                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/avg().(scale)
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[T]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/avg().[S]
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/avg().(scale)
//                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/avg().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/sum().
  /** Returns the sum of this expression across all non-null input values, or `null` if there are no non-null values. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/sum().[T]
  fun <T> ExpressionWithColumnType<T>.sum(): Sum<T> = Sum(this, this.columnType)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/sum().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/sum().
//                                        display_name sum
//                                        documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.sum(): Sum<T>\n```\n\n----\n\n Returns the sum of this expression across all non-null input values, or `null` if there are no non-null values.
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#
//                                                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sum#`<init>`().
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/sum().[T]
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/sum().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/count().
  /** Returns the number of input rows for which the value of this expression is not null. */
  fun ExpressionWithColumnType<*>.count(): Count = Count(this)
//                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/count().
//                                      display_name count
//                                      documentation ```kotlin\npublic final fun ExpressionWithColumnType<*>.count(): Count\n```\n\n----\n\n Returns the number of input rows for which the value of this expression is not null.
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/count().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/countDistinct().
  /** Returns the number of distinct input rows for which the value of this expression is not null. */
  fun Column<*>.countDistinct(): Count = Count(this, true)
//              ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/countDistinct().
//                            display_name countDistinct
//                            documentation ```kotlin\npublic final fun Column<*>.countDistinct(): Count\n```\n\n----\n\n Returns the number of distinct input rows for which the value of this expression is not null.
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Count#`<init>`().
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/countDistinct().
  
  // Aggregate Functions for Statistics
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().
  /**
   * Returns the population standard deviation of the non-null input values, or `null` if there are no non-null values.
   *
   * @param scale The scale of the decimal column expression returned.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().[T]
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().(scale)
  fun <T : Any?> ExpressionWithColumnType<T>.stdDevPop(scale: Int = 2): StdDevPop<T> = StdDevPop(this, scale)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().
//                                                     display_name stdDevPop
//                                                     documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.stdDevPop(scale: Int = ...): StdDevPop<T>\n```\n\n----\n\n\n Returns the population standard deviation of the non-null input values, or `null` if there are no non-null values.\n\n @param scale The scale of the decimal column expression returned.\n
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().(scale)
//                                                           display_name scale
//                                                           documentation ```kotlin\nscale: Int = ...\n```
//                                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#
//                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevPop#`<init>`().
//                                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().(scale)
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().[T]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().(scale)
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevPop().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().
  /**
   * Returns the sample standard deviation of the non-null input values, or `null` if there are no non-null values.
   *
   * @param scale The scale of the decimal column expression returned.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().[T]
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().(scale)
  fun <T : Any?> ExpressionWithColumnType<T>.stdDevSamp(scale: Int = 2): StdDevSamp<T> = StdDevSamp(this, scale)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().
//                                                      display_name stdDevSamp
//                                                      documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.stdDevSamp(scale: Int = ...): StdDevSamp<T>\n```\n\n----\n\n\n Returns the sample standard deviation of the non-null input values, or `null` if there are no non-null values.\n\n @param scale The scale of the decimal column expression returned.\n
//                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().(scale)
//                                                            display_name scale
//                                                            documentation ```kotlin\nscale: Int = ...\n```
//                                                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/StdDevSamp#`<init>`().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().(scale)
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().[T]
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().(scale)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/stdDevSamp().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().
  /**
   * Returns the population variance of the non-null input values (square of the population standard deviation), or `null` if there are no non-null values.
   *
   * @param scale The scale of the decimal column expression returned.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().(scale)
  fun <T : Any?> ExpressionWithColumnType<T>.varPop(scale: Int = 2): VarPop<T> = VarPop(this, scale)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().
//                                                  display_name varPop
//                                                  documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.varPop(scale: Int = ...): VarPop<T>\n```\n\n----\n\n\n Returns the population variance of the non-null input values (square of the population standard deviation), or `null` if there are no non-null values.\n\n @param scale The scale of the decimal column expression returned.\n
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().(scale)
//                                                        display_name scale
//                                                        documentation ```kotlin\nscale: Int = ...\n```
//                                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarPop#`<init>`().
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().(scale)
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().[T]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().(scale)
//                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varPop().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().
  /**
   * Returns the sample variance of the non-null input values (square of the sample standard deviation), or `null` if there are no non-null values.
   *
   * @param scale The scale of the decimal column expression returned.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().[T]
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().(scale)
  fun <T : Any?> ExpressionWithColumnType<T>.varSamp(scale: Int = 2): VarSamp<T> = VarSamp(this, scale)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().
//                                                   display_name varSamp
//                                                   documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.varSamp(scale: Int = ...): VarSamp<T>\n```\n\n----\n\n\n Returns the sample variance of the non-null input values (square of the sample standard deviation), or `null` if there are no non-null values.\n\n @param scale The scale of the decimal column expression returned.\n
//                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().(scale)
//                                                         display_name scale
//                                                         documentation ```kotlin\nscale: Int = ...\n```
//                                                          ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#
//                                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/VarSamp#`<init>`().
//                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().(scale)
//            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().(scale)
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/varSamp().
  
  // Array Comparisons
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().
  /** Returns this subquery wrapped in the `ANY` operator. This function is not supported by the SQLite dialect. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().[T]
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().(subQuery)
  fun <T> anyFrom(subQuery: AbstractQuery<*>): Op<T> = AllAnyFromSubQueryOp(true, subQuery)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().
//                display_name anyFrom
//                documentation ```kotlin\npublic final fun <T> anyFrom(subQuery: AbstractQuery<*>): Op<T>\n```\n\n----\n\n Returns this subquery wrapped in the `ANY` operator. This function is not supported by the SQLite dialect.
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().(subQuery)
//                         display_name subQuery
//                         documentation ```kotlin\nsubQuery: AbstractQuery<*>\n```
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().
//                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().(subQuery)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().(subQuery)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).
  /**
   * Returns this array of data wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects.
   *
   * **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be
   * resolved according to the internal mapping of the element's type in [resolveColumnType].
   *
   * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(array)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(delegateType)
  inline fun <reified T : Any> anyFrom(array: Array<T>, delegateType: ColumnType<T>? = null): Op<T> {
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nreified T : Any\n```
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).
//                                     display_name anyFrom
//                                     documentation ```kotlin\npublic final inline fun <reified T : Any> anyFrom(array: Array<T>, delegateType: ColumnType<T>? = ...): Op<T>\n```\n\n----\n\n\n Returns this array of data wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects.\n\n **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be\n resolved according to the internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(array)
//                                           display_name array
//                                           documentation ```kotlin\narray: Array<T>\n```
//                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(delegateType)
//                                                                   display_name delegateType
//                                                                   documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(array)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(delegateType)
      // emptyArray() without type info generates ARRAY[]
//    ⌄ enclosing_range_start local 0
      @OptIn(InternalApi::class)
      val columnType = delegateType ?: resolveColumnType(T::class, if (array.isEmpty()) TextColumnType() else null)
//        ^^^^^^^^^^ definition local 0
//                   display_name columnType
//                   documentation ```kotlin\n@OptIn(...) local val columnType: ColumnType<T>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(delegateType)
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(array)
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/isEmpty().
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                                                                ⌃ enclosing_range_end local 0
      return AllAnyFromArrayOp(true, array.toList(), columnType)
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).(array)
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                                   ^^^^^^^^^^ reference local 0
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+1).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).
  /**
   * Returns this list of data wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects.
   *
   * **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be
   * resolved according to the internal mapping of the element's type in [resolveColumnType].
   *
   * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(array)
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(delegateType)
  inline fun <reified T : Any> anyFrom(array: List<T>, delegateType: ColumnType<T>? = null): Op<T> {
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nreified T : Any\n```
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).
//                                     display_name anyFrom
//                                     documentation ```kotlin\npublic final inline fun <reified T : Any> anyFrom(array: List<T>, delegateType: ColumnType<T>? = ...): Op<T>\n```\n\n----\n\n\n Returns this list of data wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects.\n\n **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be\n resolved according to the internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(array)
//                                           display_name array
//                                           documentation ```kotlin\narray: List<T>\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(delegateType)
//                                                                  display_name delegateType
//                                                                  documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).[T]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(array)
//                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(delegateType)
      // emptyList() without type info generates ARRAY[]
//    ⌄ enclosing_range_start local 1
      @OptIn(InternalApi::class)
      val columnType = delegateType ?: resolveColumnType(T::class, if (array.isEmpty()) TextColumnType() else null)
//        ^^^^^^^^^^ definition local 1
//                   display_name columnType
//                   documentation ```kotlin\n@OptIn(...) local val columnType: ColumnType<T>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(delegateType)
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(array)
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                                                                ⌃ enclosing_range_end local 1
      return AllAnyFromArrayOp(true, array, columnType)
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).(array)
//                                          ^^^^^^^^^^ reference local 1
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+2).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).
  /** Returns this table wrapped in the `ANY` operator. This function is only supported by MySQL, PostgreSQL, and H2 dialects. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).[T]
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).(table)
  fun <T> anyFrom(table: Table): Op<T> = AllAnyFromTableOp(true, table)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).
//                display_name anyFrom
//                documentation ```kotlin\npublic final fun <T> anyFrom(table: Table): Op<T>\n```\n\n----\n\n Returns this table wrapped in the `ANY` operator. This function is only supported by MySQL, PostgreSQL, and H2 dialects.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).(table)
//                      display_name table
//                      documentation ```kotlin\ntable: Table\n```
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).(table)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).(table)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+3).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).
  /** Returns this expression wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).(expression)
  fun <E, T : List<E>?> anyFrom(expression: Expression<T>): Op<E> = AllAnyFromExpressionOp(true, expression)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[E]
//       display_name FirTypeParameterSymbol E
//       documentation ```kotlin\nE\n```
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[T]
//          display_name FirTypeParameterSymbol T
//          documentation ```kotlin\nT : List<E>?\n```
//                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).
//                              display_name anyFrom
//                              documentation ```kotlin\npublic final fun <E, T : List<E>?> anyFrom(expression: Expression<T>): Op<E>\n```\n\n----\n\n Returns this expression wrapped in the `ANY` operator. This function is only supported by PostgreSQL and H2 dialects.
//                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).(expression)
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: Expression<T>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().
//                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).(expression)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[E]
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).[T]
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).(expression)
//                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/anyFrom(+4).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().
  /** Returns this subquery wrapped in the `ALL` operator. This function is not supported by the SQLite dialect. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().[T]
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().(subQuery)
  fun <T> allFrom(subQuery: AbstractQuery<*>): Op<T> = AllAnyFromSubQueryOp(false, subQuery)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().
//                display_name allFrom
//                documentation ```kotlin\npublic final fun <T> allFrom(subQuery: AbstractQuery<*>): Op<T>\n```\n\n----\n\n Returns this subquery wrapped in the `ALL` operator. This function is not supported by the SQLite dialect.
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().(subQuery)
//                         display_name subQuery
//                         documentation ```kotlin\nsubQuery: AbstractQuery<*>\n```
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                     ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromSubQueryOp#`<init>`().
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().(subQuery)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().(subQuery)
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).
  /**
   * Returns this array of data wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects.
   *
   * **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be
   * resolved according to the internal mapping of the element's type in [resolveColumnType].
   *
   * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(array)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(delegateType)
  inline fun <reified T : Any> allFrom(array: Array<T>, delegateType: ColumnType<T>? = null): Op<T> {
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nreified T : Any\n```
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).
//                                     display_name allFrom
//                                     documentation ```kotlin\npublic final inline fun <reified T : Any> allFrom(array: Array<T>, delegateType: ColumnType<T>? = ...): Op<T>\n```\n\n----\n\n\n Returns this array of data wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects.\n\n **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be\n resolved according to the internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(array)
//                                           display_name array
//                                           documentation ```kotlin\narray: Array<T>\n```
//                                            ^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(delegateType)
//                                                                   display_name delegateType
//                                                                   documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(array)
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(delegateType)
      // emptyArray() without type info generates ARRAY[]
//    ⌄ enclosing_range_start local 2
      @OptIn(InternalApi::class)
      val columnType = delegateType ?: resolveColumnType(T::class, if (array.isEmpty()) TextColumnType() else null)
//        ^^^^^^^^^^ definition local 2
//                   display_name columnType
//                   documentation ```kotlin\n@OptIn(...) local val columnType: ColumnType<T>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(delegateType)
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(array)
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/isEmpty().
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                                                                ⌃ enclosing_range_end local 2
      return AllAnyFromArrayOp(false, array.toList(), columnType)
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).(array)
//                                          ^^^^^^ reference semanticdb maven . . kotlin/collections/toList().
//                                                    ^^^^^^^^^^ reference local 2
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+1).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).
  /**
   * Returns this list of data wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects.
   *
   * **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be
   * resolved according to the internal mapping of the element's type in [resolveColumnType].
   *
   * @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.
   */
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(array)
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(delegateType)
  inline fun <reified T : Any> allFrom(array: List<T>, delegateType: ColumnType<T>? = null): Op<T> {
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nreified T : Any\n```
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).
//                                     display_name allFrom
//                                     documentation ```kotlin\npublic final inline fun <reified T : Any> allFrom(array: List<T>, delegateType: ColumnType<T>? = ...): Op<T>\n```\n\n----\n\n\n Returns this list of data wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects.\n\n **Note** If [delegateType] is left `null`, the base column type associated with storing elements of type [T] will be\n resolved according to the internal mapping of the element's type in [resolveColumnType].\n\n @throws IllegalStateException If no column type mapping is found and a [delegateType] is not provided.\n
//                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(array)
//                                           display_name array
//                                           documentation ```kotlin\narray: List<T>\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(delegateType)
//                                                                  display_name delegateType
//                                                                  documentation ```kotlin\ndelegateType: ColumnType<T>? = ...\n```
//                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnType#
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).[T]
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(array)
//                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(delegateType)
      // emptyList() without type info generates ARRAY[]
//    ⌄ enclosing_range_start local 3
      @OptIn(InternalApi::class)
      val columnType = delegateType ?: resolveColumnType(T::class, if (array.isEmpty()) TextColumnType() else null)
//        ^^^^^^^^^^ definition local 3
//                   display_name columnType
//                   documentation ```kotlin\n@OptIn(...) local val columnType: ColumnType<T>\n```
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(delegateType)
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/resolveColumnType().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(array)
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
//                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                                                                ⌃ enclosing_range_end local 3
      return AllAnyFromArrayOp(false, array, columnType)
//           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromArrayOp#`<init>`().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).(array)
//                                           ^^^^^^^^^^ reference local 3
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+2).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).
  /** Returns this table wrapped in the `ALL` operator. This function is only supported by MySQL, PostgreSQL, and H2 dialects. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).[T]
//                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).(table)
  fun <T> allFrom(table: Table): Op<T> = AllAnyFromTableOp(false, table)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).
//                display_name allFrom
//                documentation ```kotlin\npublic final fun <T> allFrom(table: Table): Op<T>\n```\n\n----\n\n Returns this table wrapped in the `ALL` operator. This function is only supported by MySQL, PostgreSQL, and H2 dialects.
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).(table)
//                      display_name table
//                      documentation ```kotlin\ntable: Table\n```
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromTableOp#`<init>`().
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).(table)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).(table)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+3).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).
  /** Returns this expression wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).(expression)
  fun <E, T : List<E>?> allFrom(expression: Expression<T>): Op<E> = AllAnyFromExpressionOp(false, expression)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[E]
//       display_name FirTypeParameterSymbol E
//       documentation ```kotlin\nE\n```
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[T]
//          display_name FirTypeParameterSymbol T
//          documentation ```kotlin\nT : List<E>?\n```
//                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).
//                              display_name allFrom
//                              documentation ```kotlin\npublic final fun <E, T : List<E>?> allFrom(expression: Expression<T>): Op<E>\n```\n\n----\n\n Returns this expression wrapped in the `ALL` operator. This function is only supported by PostgreSQL and H2 dialects.
//                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).(expression)
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: Expression<T>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/AllAnyFromExpressionOp#`<init>`().
//                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).(expression)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[E]
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).[T]
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).(expression)
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/allFrom(+4).
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/get().
  /**
   * Returns the array element stored at the one-based [index] position, or `null` if the stored array itself is null.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.types.ArrayColumnTypeTests.testSelectUsingArrayGet
   */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/get().[E]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/get().[T]
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/get().(index)
  infix operator fun <E, T : List<E>?> ExpressionWithColumnType<T>.get(index: Int): ArrayGet<E, T> {
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/get().[E]
//                      display_name FirTypeParameterSymbol E
//                      documentation ```kotlin\nE\n```
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/get().[T]
//                         display_name FirTypeParameterSymbol T
//                         documentation ```kotlin\nT : List<E>?\n```
//                                                                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/get().
//                                                                     display_name get
//                                                                     documentation ```kotlin\npublic final operator infix fun <E, T : List<E>?> ExpressionWithColumnType<T>.get(index: Int): ArrayGet<E, T>\n```\n\n----\n\n\n Returns the array element stored at the one-based [index] position, or `null` if the stored array itself is null.\n\n @sample org.jetbrains.exposed.v1.tests.shared.types.ArrayColumnTypeTests.testSelectUsingArrayGet\n
//                                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/get().(index)
//                                                                           display_name index
//                                                                           documentation ```kotlin\nindex: Int\n```
//                                                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/get().[E]
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/get().[T]
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/get().(index)
//                 ⌄ enclosing_range_start local 4
      return when (this) {
//                 ^^^^ definition local 4
//                      display_name <when-subject>
//                      documentation ```kotlin\nlocal val <when-subject>: ExpressionWithColumnType<T>\n```
//                    ⌃ enclosing_range_end local 4
          is ArrayGet<*, *> -> ArrayGet(this as Expression<T>, index, this.columnType as IColumnType<E & Any>) as ArrayGet<E, T>
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/get().(index)
//                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#columnType.
//                                                                                       ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#
          else -> ArrayGet(this, index, (this.columnType as ArrayColumnType<E, List<E>>).delegate)
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArrayGet#`<init>`().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/get().(index)
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#delegate.
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ArrayColumnType#getDelegate().
      }
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/get().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/slice().
  /**
   * Returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),
   * or `null` if the stored array itself is null.
   * **Note** If either bounds is left `null`, the database will use the stored array's respective lower or upper limit.
   *
   * @sample org.jetbrains.exposed.v1.tests.shared.types.ArrayColumnTypeTests.testSelectUsingArraySlice
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[T]
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(lower)
//                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(upper)
  fun <E, T : List<E>?> ExpressionWithColumnType<T>.slice(lower: Int? = null, upper: Int? = null): ArraySlice<E, T> =
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[E]
//       display_name FirTypeParameterSymbol E
//       documentation ```kotlin\nE\n```
//        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[T]
//          display_name FirTypeParameterSymbol T
//          documentation ```kotlin\nT : List<E>?\n```
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/slice().
//                                                        display_name slice
//                                                        documentation ```kotlin\npublic final fun <E, T : List<E>?> ExpressionWithColumnType<T>.slice(lower: Int? = ..., upper: Int? = ...): ArraySlice<E, T>\n```\n\n----\n\n\n Returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),\n or `null` if the stored array itself is null.\n **Note** If either bounds is left `null`, the database will use the stored array's respective lower or upper limit.\n\n @sample org.jetbrains.exposed.v1.tests.shared.types.ArrayColumnTypeTests.testSelectUsingArraySlice\n
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(lower)
//                                                              display_name lower
//                                                              documentation ```kotlin\nlower: Int? = ...\n```
//                                                               ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(upper)
//                                                                                  display_name upper
//                                                                                  documentation ```kotlin\nupper: Int? = ...\n```
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[E]
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/slice().[T]
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(lower)
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(upper)
      ArraySlice(this, lower, upper, this.columnType)
//    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/functions/array/ArraySlice#`<init>`().
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(lower)
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/slice().(upper)
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/slice().
  
  // Sequence Manipulation Functions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/nextIntVal().
  /** Advances this sequence and returns the new value. */
  fun Sequence.nextIntVal(): NextVal<Int> = NextVal.IntNextVal(this)
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/nextIntVal().
//                        display_name nextIntVal
//                        documentation ```kotlin\npublic final fun Sequence.nextIntVal(): NextVal<Int>\n```\n\n----\n\n Advances this sequence and returns the new value.
//                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#IntNextVal#`<init>`().
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/nextIntVal().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/nextLongVal().
  /** Advances this sequence and returns the new value. */
  fun Sequence.nextLongVal(): NextVal<Long> = NextVal.LongNextVal(this)
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/nextLongVal().
//                         display_name nextLongVal
//                         documentation ```kotlin\npublic final fun Sequence.nextLongVal(): NextVal<Long>\n```\n\n----\n\n Advances this sequence and returns the new value.
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NextVal#LongNextVal#`<init>`().
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/nextLongVal().
  
  // Value Expressions
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().
  /** Specifies a conversion from one data type to another. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().[R]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().(columnType)
  fun <R> Expression<*>.castTo(columnType: IColumnType<R & Any>): ExpressionWithColumnType<R> = Cast(this, columnType)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().[R]
//       display_name FirTypeParameterSymbol R
//       documentation ```kotlin\nR\n```
//                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().
//                             display_name castTo
//                             documentation ```kotlin\npublic final fun <R> Expression<*>.castTo(columnType: IColumnType<R & Any>): ExpressionWithColumnType<R>\n```\n\n----\n\n Specifies a conversion from one data type to another.
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().(columnType)
//                                        display_name columnType
//                                        documentation ```kotlin\ncolumnType: IColumnType<R & Any>\n```
//                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Cast#`<init>`().
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().(columnType)
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().[R]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().(columnType)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/castTo().
  
  // Misc.
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/function().
  /**
   * Calls a custom SQL function with the specified [functionName] and passes this expression as its only argument.
   */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/function().[T]
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/function().(functionName)
  fun <T> ExpressionWithColumnType<T>.function(functionName: String): CustomFunction<T?> = CustomFunction(functionName, columnType, this)
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/function().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/function().
//                                             display_name function
//                                             documentation ```kotlin\npublic final fun <T> ExpressionWithColumnType<T>.function(functionName: String): CustomFunction<T?>\n```\n\n----\n\n\n Calls a custom SQL function with the specified [functionName] and passes this expression as its only argument.\n
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/function().(functionName)
//                                                          display_name functionName
//                                                          documentation ```kotlin\nfunctionName: String\n```
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
//                                                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/function().(functionName)
//                                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/function().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/function().(functionName)
//                                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/function().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().
  /**
   * Calls a custom SQL function with the specified [functionName], that returns a string, and passing [params] as its arguments.
   */
  @Suppress("FunctionNaming")
  fun CustomStringFunction(
//    ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().
//                         display_name CustomStringFunction
//                         documentation ```kotlin\n@Suppress(...) public final fun CustomStringFunction(functionName: String, vararg params: Expression<*>): CustomFunction<String?>\n```\n\n----\n\n\n Calls a custom SQL function with the specified [functionName], that returns a string, and passing [params] as its arguments.\n
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(functionName)
      functionName: String,
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(functionName)
//                 display_name functionName
//                 documentation ```kotlin\nfunctionName: String\n```
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(functionName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(params)
      vararg params: Expression<*>
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(params)
//                  display_name params
//                  documentation ```kotlin\nvararg params: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(params)
  ): CustomFunction<String?> = CustomFunction(functionName, TextColumnType(), *params)
//   ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(functionName)
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TextColumnType#`<init>`().
//                                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().(params)
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomStringFunction().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().
  /**
   * Calls a custom SQL function with the specified [functionName], that returns a long, and passing [params] as its arguments.
   */
  @Suppress("FunctionNaming")
  fun CustomLongFunction(
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().
//                       display_name CustomLongFunction
//                       documentation ```kotlin\n@Suppress(...) public final fun CustomLongFunction(functionName: String, vararg params: Expression<*>): CustomFunction<Long?>\n```\n\n----\n\n\n Calls a custom SQL function with the specified [functionName], that returns a long, and passing [params] as its arguments.\n
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(functionName)
      functionName: String,
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(functionName)
//                 display_name functionName
//                 documentation ```kotlin\nfunctionName: String\n```
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(functionName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(params)
      vararg params: Expression<*>
//           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(params)
//                  display_name params
//                  documentation ```kotlin\nvararg params: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(params)
  ): CustomFunction<Long?> = CustomFunction(functionName, LongColumnType(), *params)
//   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomFunction#`<init>`().
//                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(functionName)
//                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LongColumnType#`<init>`().
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().(params)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/CustomLongFunction().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
  /** Represents a pattern used for the comparison of string expressions. */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().
  data class LikePattern(
//           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                       display_name LikePattern
//                       documentation ```kotlin\npublic final data class LikePattern : Any\n```\n\n----\n\n Represents a pattern used for the comparison of string expressions.
//           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                       display_name LikePattern
//                       documentation ```kotlin\npublic constructor(pattern: String, escapeChar: Char? = ...): LikePattern\n```\n\n----\n\n The string representation of a pattern to match.
//                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy(). 5:1
//                        display_name copy
//                        documentation ```kotlin\npublic final fun copy(pattern: String = ..., escapeChar: Char? = ...): LikePattern\n\n```\n\n----\n\n The string representation of a pattern to match.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(pattern)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component1().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(pattern)
      /** The string representation of a pattern to match. */
      val pattern: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: String\n```\n\n----\n\n The string representation of a pattern to match.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(pattern)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component1().
//                display_name component1
//                documentation ```kotlin\npublic final operator fun component1(): String\n\n```\n\n----\n\n The string representation of a pattern to match.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: String = ...\n```\n\n----\n\n The string representation of a pattern to match.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                display_name pattern
//                documentation ```kotlin\npublic get(): String\n```\n\n----\n\n The string representation of a pattern to match.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                display_name pattern
//                documentation ```kotlin\npublic final val pattern: String\n```\n\n----\n\n The string representation of a pattern to match.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(pattern)
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component1().
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(pattern)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(escapeChar)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component2().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(escapeChar)
      /** The special character to use as the escape character. */
      val escapeChar: Char? = null
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(escapeChar)
//                   display_name escapeChar
//                   documentation ```kotlin\nescapeChar: Char? = ...\n```\n\n----\n\n The special character to use as the escape character.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(escapeChar)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component2().
//                   display_name component2
//                   documentation ```kotlin\npublic final operator fun component2(): Char?\n\n```\n\n----\n\n The special character to use as the escape character.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(escapeChar)
//                   display_name escapeChar
//                   documentation ```kotlin\nescapeChar: Char? = ...\n```\n\n----\n\n The special character to use as the escape character.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                   display_name escapeChar
//                   documentation ```kotlin\npublic final val escapeChar: Char?\n```\n\n----\n\n The special character to use as the escape character.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                   display_name escapeChar
//                   documentation ```kotlin\npublic get(): Char?\n```\n\n----\n\n The special character to use as the escape character.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                    ^^^^^ reference semanticdb maven . . kotlin/Char#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().(escapeChar)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#component2().
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().(escapeChar)
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#copy().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
      infix operator fun plus(rhs: LikePattern): LikePattern {
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().
//                            display_name plus
//                            documentation ```kotlin\npublic final operator infix fun plus(rhs: LikePattern): LikePattern\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
//                                display_name rhs
//                                documentation ```kotlin\nrhs: LikePattern\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
          require(escapeChar == rhs.escapeChar) { "Mixing escape chars '$escapeChar' vs. '${rhs.escapeChar} is not allowed" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
//                                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
          return LikePattern(pattern + rhs.pattern, rhs.escapeChar)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                   ^ reference semanticdb maven . . kotlin/String#plus().
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                                  ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().(rhs)
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).(rhs)
      infix operator fun plus(rhs: String): LikePattern {
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).
//                            display_name plus
//                            documentation ```kotlin\npublic final operator infix fun plus(rhs: String): LikePattern\n```
//                            ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).(rhs)
//                                display_name rhs
//                                documentation ```kotlin\nrhs: String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).(rhs)
          return LikePattern(pattern + rhs, escapeChar)
//               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                   ^ reference semanticdb maven . . kotlin/String#plus().
//                                     ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).(rhs)
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#plus(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion# 32:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Creates a [LikePattern] from the provided [text], with any special characters escaped using [escapeChar].
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#`<init>`(). 32:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): LikePattern.Companion\n```\n\n----\n\n Creates a [LikePattern] from the provided [text], with any special characters escaped using [escapeChar].
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().
          /** Creates a [LikePattern] from the provided [text], with any special characters escaped using [escapeChar]. */
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(text)
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
          fun ofLiteral(text: String, escapeChar: Char = '\\'): LikePattern {
//            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().
//                      display_name ofLiteral
//                      documentation ```kotlin\npublic final fun ofLiteral(text: String, escapeChar: Char = ...): LikePattern\n```\n\n----\n\n Creates a [LikePattern] from the provided [text], with any special characters escaped using [escapeChar].
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(text)
//                           display_name text
//                           documentation ```kotlin\ntext: String\n```
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                    ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
//                                               display_name escapeChar
//                                               documentation ```kotlin\nescapeChar: Char = ...\n```
//                                                ^^^^ reference semanticdb maven . . kotlin/Char#
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(text)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
//            ⌄ enclosing_range_start local 5
              val likePatternSpecialChars = currentDialect.likePatternSpecialChars
//                ^^^^^^^^^^^^^^^^^^^^^^^ definition local 5
//                                        display_name likePatternSpecialChars
//                                        documentation ```kotlin\nlocal val likePatternSpecialChars: Map<Char, Char?>\n```
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getLikePatternSpecialChars().
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#likePatternSpecialChars.
//                                                                               ⌃ enclosing_range_end local 5
//            ⌄ enclosing_range_start local 6
              val nextExpectedPatternQueue = arrayListOf<Char>()
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 6
//                                         display_name nextExpectedPatternQueue
//                                         documentation ```kotlin\nlocal val nextExpectedPatternQueue: {kotlin/collections/ArrayList<kotlin/Char>=} ArrayList<Char>\n```
//                                           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/arrayListOf().
//                                                             ⌃ enclosing_range_end local 6
//            ⌄ enclosing_range_start local 7
              var nextCharToEscape: Char? = null
//                ^^^^^^^^^^^^^^^^ definition local 7
//                                 display_name nextCharToEscape
//                                 documentation ```kotlin\nlocal var nextCharToEscape: Char?\n```
//                                  ^^^^^ reference semanticdb maven . . kotlin/Char#
//                                             ⌃ enclosing_range_end local 7
//            ⌄ enclosing_range_start local 8
              val escapedPattern = buildString {
//                ^^^^^^^^^^^^^^ definition local 8
//                               display_name escapedPattern
//                               documentation ```kotlin\nlocal val escapedPattern: String\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                             ⌄ enclosing_range_start local 9
                  text.forEach {
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(text)
//                     ^^^^^^^ reference semanticdb maven . . kotlin/text/forEach().
//                             ^ definition local 9 21:17
//                               display_name it
//                               documentation ```kotlin\nit: Char\n```
//                    ⌄ enclosing_range_start local 10
//                                             ⌄ enclosing_range_start local 11
                      val shouldEscape = when (it) {
//                        ^^^^^^^^^^^^ definition local 10
//                                     display_name shouldEscape
//                                     documentation ```kotlin\nlocal val shouldEscape: Boolean\n```
//                                             ^^ definition local 11
//                                                display_name <when-subject>
//                                                documentation ```kotlin\nlocal val <when-subject>: Char\n```
//                                             ^^ reference local 9
//                                              ⌃ enclosing_range_end local 11
                          escapeChar -> true
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
                          in likePatternSpecialChars -> {
//                        ^^ reference semanticdb maven . . kotlin/collections/contains(+10).
//                           ^^^^^^^^^^^^^^^^^^^^^^^ reference local 5
//                                                               ⌄ enclosing_range_start local 12
                              likePatternSpecialChars[it]?.let { nextChar ->
//                            ^^^^^^^^^^^^^^^^^^^^^^^ reference local 5
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                    ^^ reference local 9
//                                                         ^^^ reference semanticdb maven . . kotlin/let().
//                                                               ^^^^^^^^ definition local 12
//                                                                        display_name nextChar
//                                                                        documentation ```kotlin\nnextChar: Char\n```
//                                                                      ⌃ enclosing_range_end local 12
                                  nextExpectedPatternQueue.add(nextChar)
//                                ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 6
//                                                         ^^^ reference semanticdb maven jdk 11 java/util/ArrayList#add().
//                                                             ^^^^^^^^ reference local 12
                                  nextCharToEscape = nextChar
//                                ^^^^^^^^^^^^^^^^ reference local 7
//                                                   ^^^^^^^^ reference local 12
                              }
                              true
                          }
                          nextCharToEscape -> {
//                        ^^^^^^^^^^^^^^^^ reference local 7
                              nextExpectedPatternQueue.removeLast()
//                            ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 6
//                                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/removeLast().
                              nextCharToEscape = nextExpectedPatternQueue.lastOrNull()
//                            ^^^^^^^^^^^^^^^^ reference local 7
//                                               ^^^^^^^^^^^^^^^^^^^^^^^^ reference local 6
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/lastOrNull(+19).
                              true
                          }
                          else -> false
                      }
//                    ⌃ enclosing_range_end local 10
                      if (shouldEscape) {
//                        ^^^^^^^^^^^^ reference local 10
                          append(escapeChar)
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
                      }
                      append(it)
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                           ^^ reference local 9
                  }
//                ⌃ enclosing_range_end local 9
              }
//            ⌃ enclosing_range_end local 8
              return LikePattern(escapedPattern, escapeChar)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                               ^^^^^^^^^^^^^^ reference local 8
//                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().(escapeChar)
          }
//        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#ofLiteral().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#
  /** Represents all the operators available when building SQL expressions. */
  @Suppress("INAPPLICABLE_JVM_NAME", "TooManyFunctions")
  interface ISqlExpressionBuilder {
//          ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#
//                                display_name ISqlExpressionBuilder
//                                documentation ```kotlin\n@Suppress(...) public abstract interface ISqlExpressionBuilder : Any\n```\n\n----\n\n Represents all the operators available when building SQL expressions.
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
  
      // Comparison Operators
      // EQUAL
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().
      /** Checks if this expression is equal to some [t] value. */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().[T]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
      infix fun <T> ExpressionWithColumnType<T>.eq(t: T): Op<Boolean> = when {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().
//                                                 display_name eq
//                                                 documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T> ExpressionWithColumnType<T>.eq(t: T): Op<Boolean>\n```\n\n----\n\n Checks if this expression is equal to some [t] value.
//                                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
//                                                   display_name t
//                                                   documentation ```kotlin\nt: T\n```
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().[T]
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
          t == null -> isNull()
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
          (this as? Column<*>)?.isEntityIdentifier() == true -> table.mapIdComparison(t, ::EqOp)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
//                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
          else -> EqOp(this, wrap(t))
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().(t)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).
      /** Checks if this expression is equal to some [t] value. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).[T]
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).(t)
      infix fun <T> CompositeColumn<T>.eq(t: T): Op<Boolean> {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                     ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).
//                                        display_name eq
//                                        documentation ```kotlin\npublic open infix fun <T> CompositeColumn<T>.eq(t: T): Op<Boolean>\n```\n\n----\n\n Checks if this expression is equal to some [t] value.
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).(t)
//                                          display_name t
//                                          documentation ```kotlin\nt: T\n```
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).[T]
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).(t)
          // For the composite column, create "EqOps" for each real column and combine it using "and" operator
          return this.getRealColumnsWithValues(t).entries
//                    ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#getRealColumnsWithValues().
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).(t)
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#entries.
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getEntries().
//                   ⌄ enclosing_range_start local 13
              .map { e -> (e.key as Column<Any?>).eq(e.value) }
//             ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                   ^ definition local 13
//                     display_name e
//                     documentation ```kotlin\ne: Map.Entry<Column<*>, Any?>\n```
//                         ^ reference local 13
//                           ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getKey().
//                           ^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#key.
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().
//                                                   ^ reference local 13
//                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#getValue().
//                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/Map#Entry#value.
//                   ⌃ enclosing_range_end local 13
              .compoundAnd()
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/compoundAnd().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).
      /** Checks if this expression is equal to some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S1]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S2]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
      infix fun <T, S1 : T?, S2 : T?> Expression<in S1>.eq(other: Expression<in S2>): Op<Boolean> = when {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                  ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S1]
//                     display_name FirTypeParameterSymbol S1
//                     documentation ```kotlin\nS1 : T?\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S2]
//                              display_name FirTypeParameterSymbol S2
//                              documentation ```kotlin\nS2 : T?\n```
//                                                      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).
//                                                         display_name eq
//                                                         documentation ```kotlin\npublic open infix fun <T, S1 : T?, S2 : T?> Expression<in S1>.eq(other: Expression<in S2>): Op<Boolean>\n```\n\n----\n\n Checks if this expression is equal to some [other] expression.
//                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
//                                                               display_name other
//                                                               documentation ```kotlin\nother: Expression<in S2>\n```
//                                                                ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[T]
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S1]
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).[S2]
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
          (other as Expression<*>) is Op.NULL -> isNull()
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
          (other as? QueryParameter)?.compositeValue != null -> (this as Column<*>).table.mapIdComparison(other.value, ::EqOp)
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getValue().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#value.
//                                                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
          else -> EqOp(this, other)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).(other)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).
      /** Checks if this [EntityID] expression is equal to some [t] value. */
      @JvmName("eqEntityIDValue")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[V]
//                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).(t)
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.eq(t: V): Op<Boolean> {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).
//                                                                                 display_name eq
//                                                                                 documentation ```kotlin\n@JvmName(...) public open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.eq(t: V): Op<Boolean>\n```\n\n----\n\n Checks if this [EntityID] expression is equal to some [t] value.
//                                                                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).(t)
//                                                                                   display_name t
//                                                                                   documentation ```kotlin\nt: V\n```
//                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).[V]
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).(t)
          if (t == null) return isNull()
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).(t)
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
  
//        ⌄ enclosing_range_start local 14
          @Suppress("UNCHECKED_CAST")
          val table = (columnType as EntityIDColumnType<*>).idColumn.table as IdTable<T>
//            ^^^^^ definition local 14
//                  display_name table
//                  documentation ```kotlin\n@Suppress(...) local val table: IdTable<T>\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                     ⌃ enclosing_range_end local 14
//        ⌄ enclosing_range_start local 15
          val entityID = EntityID(t, table)
//            ^^^^^^^^ definition local 15
//                     display_name entityID
//                     documentation ```kotlin\nlocal val entityID: EntityID<T>\n```
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).(t)
//                                   ^^^^^ reference local 14
//                                        ⌃ enclosing_range_end local 15
          return if ((this as? Column<*>)?.isEntityIdentifier() == true) {
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
              this.table.mapIdComparison(entityID, ::EqOp)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                       ^^^^^^^^ reference local 15
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
          } else {
              EqOp(this, wrap(entityID))
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                            ^^^^^^^^ reference local 15
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).
      /** Checks if this [EntityID] expression is equal to some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[V]
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.eq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).
//                                                                                 display_name eq
//                                                                                 documentation ```kotlin\npublic open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.eq(other: Expression<V>): Op<Boolean>\n```\n\n----\n\n Checks if this [EntityID] expression is equal to some [other] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).(other)
          other: Expression<V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<V>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).(other)
//                           ⌄ enclosing_range_start local 16
      ): Op<Boolean> = when (other as Expression<*>) {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).(other)
//                           ^^^^^^^^^^^^^^^^^^^^^^ definition local 16
//                                                  display_name <when-subject>
//                                                  documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ⌃ enclosing_range_end local 16
          is Op.NULL -> isNull()
//           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
          else -> EqOp(this, other)
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).(other)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).
      /** Checks if this expression is equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[V]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[E]
      infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.eq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[V]
//                          display_name FirTypeParameterSymbol V
//                          documentation ```kotlin\nV : T?\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[E]
//                                  display_name FirTypeParameterSymbol E
//                                  documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).
//                                                                   display_name eq
//                                                                   documentation ```kotlin\npublic open infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.eq(other: ExpressionWithColumnType<E>): Op<Boolean>\n```\n\n----\n\n Checks if this expression is equal to some [other] [EntityID] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[T]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[V]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).(other)
      ): Op<Boolean> = other eq this
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).(other)
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+4).
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq(+5).
  
      // NOT EQUAL
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().
      /** Checks if this expression is not equal to some [other] value. */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
      infix fun <T> ExpressionWithColumnType<T>.neq(other: T): Op<Boolean> = when {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().
//                                                  display_name neq
//                                                  documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T> ExpressionWithColumnType<T>.neq(other: T): Op<Boolean>\n```\n\n----\n\n Checks if this expression is not equal to some [other] value.
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
//                                                        display_name other
//                                                        documentation ```kotlin\nother: T\n```
//                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().[T]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
          other == null -> isNotNull()
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
          (this as? Column<*>)?.isEntityIdentifier() == true -> table.mapIdComparison(other, ::NeqOp)
//                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
          else -> NeqOp(this, wrap(other))
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().(other)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).
      /** Checks if this expression is not equal to some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S1]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S2]
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
      infix fun <T, S1 : T?, S2 : T?> Expression<in S1>.neq(other: Expression<in S2>): Op<Boolean> = when {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                  ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S1]
//                     display_name FirTypeParameterSymbol S1
//                     documentation ```kotlin\nS1 : T?\n```
//                           ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S2]
//                              display_name FirTypeParameterSymbol S2
//                              documentation ```kotlin\nS2 : T?\n```
//                                                      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).
//                                                          display_name neq
//                                                          documentation ```kotlin\npublic open infix fun <T, S1 : T?, S2 : T?> Expression<in S1>.neq(other: Expression<in S2>): Op<Boolean>\n```\n\n----\n\n Checks if this expression is not equal to some [other] expression.
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
//                                                                display_name other
//                                                                documentation ```kotlin\nother: Expression<in S2>\n```
//                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[T]
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S1]
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).[S2]
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
          (other as Expression<*>) is Op.NULL -> isNotNull()
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
          (other as? QueryParameter)?.compositeValue != null -> (this as Column<*>).table.mapIdComparison(other.value, ::NeqOp)
//         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getValue().
//                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#value.
//                                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
          else -> NeqOp(this, other)
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).(other)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).
      /** Checks if this [EntityID] expression is not equal to some [t] value. */
      @JvmName("neqEntityIDValue")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[V]
//                                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).(t)
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.neq(t: V): Op<Boolean> {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).
//                                                                                  display_name neq
//                                                                                  documentation ```kotlin\n@JvmName(...) public open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.neq(t: V): Op<Boolean>\n```\n\n----\n\n Checks if this [EntityID] expression is not equal to some [t] value.
//                                                                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).(t)
//                                                                                    display_name t
//                                                                                    documentation ```kotlin\nt: V\n```
//                                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).[V]
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).(t)
          if (t == null) return isNotNull()
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).(t)
//                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
//        ⌄ enclosing_range_start local 17
          @Suppress("UNCHECKED_CAST")
          val table = (columnType as EntityIDColumnType<*>).idColumn.table as IdTable<T>
//            ^^^^^ definition local 17
//                  display_name table
//                  documentation ```kotlin\n@Suppress(...) local val table: IdTable<T>\n```
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                     ⌃ enclosing_range_end local 17
//        ⌄ enclosing_range_start local 18
          val entityID = EntityID(t, table)
//            ^^^^^^^^ definition local 18
//                     display_name entityID
//                     documentation ```kotlin\nlocal val entityID: EntityID<T>\n```
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).(t)
//                                   ^^^^^ reference local 17
//                                        ⌃ enclosing_range_end local 18
          return if ((this as? Column<*>)?.isEntityIdentifier() == true) {
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
              this.table.mapIdComparison(entityID, ::NeqOp)
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdComparison().
//                                       ^^^^^^^^ reference local 18
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
          } else {
              NeqOp(this, wrap(entityID))
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                             ^^^^^^^^ reference local 18
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).
      /** Checks if this [EntityID] expression is not equal to some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[V]
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.neq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).
//                                                                                  display_name neq
//                                                                                  documentation ```kotlin\npublic open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.neq(other: Expression<V>): Op<Boolean>\n```\n\n----\n\n Checks if this [EntityID] expression is not equal to some [other] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).(other)
          other: Expression<V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<V>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).(other)
//                           ⌄ enclosing_range_start local 19
      ): Op<Boolean> = when (other as Expression<*>) {
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).(other)
//                           ^^^^^^^^^^^^^^^^^^^^^^ definition local 19
//                                                  display_name <when-subject>
//                                                  documentation ```kotlin\nlocal val <when-subject>: Expression<*>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                ⌃ enclosing_range_end local 19
          is Op.NULL -> isNotNull()
//           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#NULL#
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
          else -> NeqOp(this, other)
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NeqOp#`<init>`().
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).(other)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).
      /** Checks if this expression is not equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[V]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[E]
      infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.neq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[V]
//                          display_name FirTypeParameterSymbol V
//                          documentation ```kotlin\nV : T?\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[E]
//                                  display_name FirTypeParameterSymbol E
//                                  documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).
//                                                                    display_name neq
//                                                                    documentation ```kotlin\npublic open infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.neq(other: ExpressionWithColumnType<E>): Op<Boolean>\n```\n\n----\n\n Checks if this expression is not equal to some [other] [EntityID] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[T]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[V]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).(other)
      ): Op<Boolean> = other neq this
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).(other)
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+3).
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#neq(+4).
  
      // LESS THAN
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().
      /** Checks if this expression is less than some [t] value. */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[S]
//                                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.less(t: T): LessOp = LessOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().
//                                                                              display_name less
//                                                                              documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.less(t: T): LessOp\n```\n\n----\n\n Checks if this expression is less than some [t] value.
//                                                                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().(t)
//                                                                                display_name t
//                                                                                documentation ```kotlin\nt: T\n```
//                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                                                                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().[S]
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().(t)
//                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).
      /** Checks if this expression is less than some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[S]
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.less(other: Expression<in S>): LessOp = LessOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).
//                                                                display_name less
//                                                                documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.less(other: Expression<in S>): LessOp\n```\n\n----\n\n Checks if this expression is less than some [other] expression.
//                                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).(other)
//                                                                      display_name other
//                                                                      documentation ```kotlin\nother: Expression<in S>\n```
//                                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                                                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).[S]
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).(other)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).
      /** Checks if this [EntityID] expression is less than some [t] value. */
      @JvmName("lessEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).[T]
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).(t)
      infix fun <T : Comparable<T>> Column<EntityID<T>>.less(t: T): LessOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).
//                                                           display_name less
//                                                           documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>> Column<EntityID<T>>.less(t: T): LessOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than some [t] value.
//                                                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).(t)
//                                                             display_name t
//                                                             documentation ```kotlin\nt: T\n```
//                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).(t)
          LessOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).(t)
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).
      /** Checks if this [EntityID] expression is less than some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[E]
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[V]
      infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.less(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[V]
//                                                      display_name FirTypeParameterSymbol V
//                                                      documentation ```kotlin\nV : T?\n```
//                                                                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).
//                                                                                             display_name less
//                                                                                             documentation ```kotlin\npublic open infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.less(other: Expression<in V>): LessOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than some [other] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[E]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).(other)
      ): LessOp = LessOp(this, other)
//       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).(other)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).
      /** Checks if this expression is less than some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[V]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[E]
      infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.less(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[V]
//                                    display_name FirTypeParameterSymbol V
//                                    documentation ```kotlin\nV : T?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[E]
//                                            display_name FirTypeParameterSymbol E
//                                            documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).
//                                                                               display_name less
//                                                                               documentation ```kotlin\npublic open infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.less(other: ExpressionWithColumnType<E>): LessOp\n```\n\n----\n\n Checks if this expression is less than some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[V]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).(other)
      ): LessOp = LessOp(this, other)
//       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).(other)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).
      /** Checks if this [EntityID] expression is less than some [other] [EntityID] expression. */
      @JvmName("lessBetweenEntityIDs")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[E]
      infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.less(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).
//                                                                       display_name less
//                                                                       documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.less(other: Expression<E>): LessOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).(other)
          other: Expression<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<E>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).(other)
      ): LessOp = LessOp(this, other)
//       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessOp#`<init>`().
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).(other)
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#less(+5).
  
      // LESS THAN OR EQUAL
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().
      /** Checks if this expression is less than or equal to some [t] value */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[S]
//                                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.lessEq(t: T): LessEqOp = LessEqOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().
//                                                                                display_name lessEq
//                                                                                documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.lessEq(t: T): LessEqOp\n```\n\n----\n\n Checks if this expression is less than or equal to some [t] value
//                                                                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().(t)
//                                                                                  display_name t
//                                                                                  documentation ```kotlin\nt: T\n```
//                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                                                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().[S]
//                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().(t)
//                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).
      /** Checks if this expression is less than or equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[S]
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.lessEq(other: Expression<in S>): LessEqOp = LessEqOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).
//                                                                  display_name lessEq
//                                                                  documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.lessEq(other: Expression<in S>): LessEqOp\n```\n\n----\n\n Checks if this expression is less than or equal to some [other] expression
//                                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).(other)
//                                                                        display_name other
//                                                                        documentation ```kotlin\nother: Expression<in S>\n```
//                                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                                                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                                                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).[S]
//                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).(other)
//                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).
      /** Checks if this [EntityID] expression is less than or equal to some [t] value */
      @JvmName("lessEqEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).[T]
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).(t)
      infix fun <T : Comparable<T>> Column<EntityID<T>>.lessEq(t: T): LessEqOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).
//                                                             display_name lessEq
//                                                             documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>> Column<EntityID<T>>.lessEq(t: T): LessEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than or equal to some [t] value
//                                                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).(t)
//                                                               display_name t
//                                                               documentation ```kotlin\nt: T\n```
//                                                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).(t)
          LessEqOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                     ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).(t)
//                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).
      /** Checks if this [EntityID] expression is less than or equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[E]
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[V]
      infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.lessEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[V]
//                                                      display_name FirTypeParameterSymbol V
//                                                      documentation ```kotlin\nV : T?\n```
//                                                                                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).
//                                                                                               display_name lessEq
//                                                                                               documentation ```kotlin\npublic open infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.lessEq(other: Expression<in V>): LessEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than or equal to some [other] expression
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[E]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).(other)
      ): LessEqOp = LessEqOp(this, other)
//       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).(other)
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).
      /** Checks if this expression is less than or equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[V]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[E]
      infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.lessEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[V]
//                                    display_name FirTypeParameterSymbol V
//                                    documentation ```kotlin\nV : T?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[E]
//                                            display_name FirTypeParameterSymbol E
//                                            documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).
//                                                                                 display_name lessEq
//                                                                                 documentation ```kotlin\npublic open infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.lessEq(other: ExpressionWithColumnType<E>): LessEqOp\n```\n\n----\n\n Checks if this expression is less than or equal to some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[V]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).(other)
      ): LessEqOp = LessEqOp(this, other)
//       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).(other)
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).
      /** Checks if this [EntityID] expression is less than or equal to some [other] [EntityID] expression. */
      @JvmName("lessEqBetweenEntityIDs")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[E]
      infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.lessEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).
//                                                                         display_name lessEq
//                                                                         documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.lessEq(other: Expression<E>): LessEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is less than or equal to some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).(other)
          other: Expression<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<E>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).(other)
      ): LessEqOp = LessEqOp(this, other)
//       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqOp#`<init>`().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).(other)
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEq(+5).
  
      // GREATER THAN
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().
      /** Checks if this expression is greater than some [t] value. */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[S]
//                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.greater(t: T): GreaterOp = GreaterOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().
//                                                                                 display_name greater
//                                                                                 documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.greater(t: T): GreaterOp\n```\n\n----\n\n Checks if this expression is greater than some [t] value.
//                                                                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().(t)
//                                                                                   display_name t
//                                                                                   documentation ```kotlin\nt: T\n```
//                                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().[S]
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().(t)
//                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).
      /** Checks if this expression is greater than some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[S]
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.greater(other: Expression<in S>): GreaterOp = GreaterOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).
//                                                                   display_name greater
//                                                                   documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.greater(other: Expression<in S>): GreaterOp\n```\n\n----\n\n Checks if this expression is greater than some [other] expression.
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).(other)
//                                                                         display_name other
//                                                                         documentation ```kotlin\nother: Expression<in S>\n```
//                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                                                                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).[S]
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).(other)
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).
      /** Checks if this [EntityID] expression is greater than some [t] value. */
      @JvmName("greaterEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).[T]
//                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).(t)
      infix fun <T : Comparable<T>> Column<EntityID<T>>.greater(t: T): GreaterOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).
//                                                              display_name greater
//                                                              documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>> Column<EntityID<T>>.greater(t: T): GreaterOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than some [t] value.
//                                                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).(t)
//                                                                display_name t
//                                                                documentation ```kotlin\nt: T\n```
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).(t)
          GreaterOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).(t)
//                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).
      /** Checks if this [EntityID] expression is greater than some [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[E]
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[V]
      infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.greater(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[V]
//                                                      display_name FirTypeParameterSymbol V
//                                                      documentation ```kotlin\nV : T?\n```
//                                                                                        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).
//                                                                                                display_name greater
//                                                                                                documentation ```kotlin\npublic open infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.greater(other: Expression<in V>): GreaterOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than some [other] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[E]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).(other)
      ): GreaterOp = GreaterOp(this, other)
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).(other)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).
      /** Checks if this expression is greater than some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[V]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[E]
      infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.greater(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[V]
//                                    display_name FirTypeParameterSymbol V
//                                    documentation ```kotlin\nV : T?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[E]
//                                            display_name FirTypeParameterSymbol E
//                                            documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).
//                                                                                  display_name greater
//                                                                                  documentation ```kotlin\npublic open infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.greater(other: ExpressionWithColumnType<E>): GreaterOp\n```\n\n----\n\n Checks if this expression is greater than some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[V]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).(other)
      ): GreaterOp = GreaterOp(this, other)
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).(other)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).
      /** Checks if this [EntityID] expression is greater than some [other] [EntityID] expression. */
      @JvmName("greaterBetweenEntityIDs")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[E]
      infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.greater(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).
//                                                                          display_name greater
//                                                                          documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.greater(other: Expression<E>): GreaterOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).(other)
          other: Expression<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<E>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).(other)
      ): GreaterOp = GreaterOp(this, other)
//       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterOp#`<init>`().
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).(other)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greater(+5).
  
      // GREATER THAN OR EQUAL
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().
      /** Checks if this expression is greater than or equal to some [t] value */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[S]
//                                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.greaterEq(t: T): GreaterEqOp = GreaterEqOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().
//                                                                                   display_name greaterEq
//                                                                                   documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.greaterEq(t: T): GreaterEqOp\n```\n\n----\n\n Checks if this expression is greater than or equal to some [t] value
//                                                                                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().(t)
//                                                                                     display_name t
//                                                                                     documentation ```kotlin\nt: T\n```
//                                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                                                                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                                                                                                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                               ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().[S]
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().(t)
//                                                                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).
      /** Checks if this expression is greater than or equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[S]
//                                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.greaterEq(other: Expression<in S>): GreaterEqOp = GreaterEqOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).
//                                                                     display_name greaterEq
//                                                                     documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.greaterEq(other: Expression<in S>): GreaterEqOp\n```\n\n----\n\n Checks if this expression is greater than or equal to some [other] expression
//                                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).(other)
//                                                                           display_name other
//                                                                           documentation ```kotlin\nother: Expression<in S>\n```
//                                                                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                                                                                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).[S]
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).(other)
//                                                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).
      /** Checks if this [EntityID] expression is greater than or equal to some [t] value */
      @JvmName("greaterEqEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).[T]
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).(t)
      infix fun <T : Comparable<T>> Column<EntityID<T>>.greaterEq(t: T): GreaterEqOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                                      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).
//                                                                display_name greaterEq
//                                                                documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>> Column<EntityID<T>>.greaterEq(t: T): GreaterEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than or equal to some [t] value
//                                                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).(t)
//                                                                  display_name t
//                                                                  documentation ```kotlin\nt: T\n```
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).[T]
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).(t)
          GreaterEqOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).(t)
//                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).
      /** Checks if this [EntityID] expression is greater than or equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[E]
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[V]
      infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.greaterEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[V]
//                                                      display_name FirTypeParameterSymbol V
//                                                      documentation ```kotlin\nV : T?\n```
//                                                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).
//                                                                                                  display_name greaterEq
//                                                                                                  documentation ```kotlin\npublic open infix fun <T : Comparable<T>, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.greaterEq(other: Expression<in V>): GreaterEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than or equal to some [other] expression
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[E]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).(other)
      ): GreaterEqOp = GreaterEqOp(this, other)
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).(other)
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).
      /** Checks if this expression is greater than or equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[V]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[E]
      infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.greaterEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[V]
//                                    display_name FirTypeParameterSymbol V
//                                    documentation ```kotlin\nV : T?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[E]
//                                            display_name FirTypeParameterSymbol E
//                                            documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).
//                                                                                    display_name greaterEq
//                                                                                    documentation ```kotlin\npublic open infix fun <T : Comparable<T>, V : T?, E : EntityID<T>?> Expression<V>.greaterEq(other: ExpressionWithColumnType<E>): GreaterEqOp\n```\n\n----\n\n Checks if this expression is greater than or equal to some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[V]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).(other)
      ): GreaterEqOp = GreaterEqOp(this, other)
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).(other)
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).
      /** Checks if this [EntityID] expression is greater than or equal to some [other] [EntityID] expression. */
      @JvmName("greaterEqBetweenEntityIDs")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[E]
      infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.greaterEq(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[E]
//                                    display_name FirTypeParameterSymbol E
//                                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                  ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).
//                                                                            display_name greaterEq
//                                                                            documentation ```kotlin\n@JvmName(...) public open infix fun <T : Comparable<T>, E : EntityID<T>?> Expression<E>.greaterEq(other: Expression<E>): GreaterEqOp\n```\n\n----\n\n Checks if this [EntityID] expression is greater than or equal to some [other] [EntityID] expression.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).(other)
          other: Expression<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<E>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).(other)
      ): GreaterEqOp = GreaterEqOp(this, other)
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqOp#`<init>`().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).(other)
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEq(+5).
  
      // Comparison Predicates
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
      /** Returns `true` if this expression is between the values [from] and [to], `false` otherwise. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[S]
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(from)
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(to)
      fun <T, S : T?> ExpressionWithColumnType<in S>.between(from: T, to: T): Between = Between(this, wrap(from), wrap(to))
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[S]
//              display_name FirTypeParameterSymbol S
//              documentation ```kotlin\nS : T?\n```
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
//                                                           display_name between
//                                                           documentation ```kotlin\npublic open fun <T, S : T?> ExpressionWithColumnType<in S>.between(from: T, to: T): Between\n```\n\n----\n\n Returns `true` if this expression is between the values [from] and [to], `false` otherwise.
//                                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(from)
//                                                                display_name from
//                                                                documentation ```kotlin\nfrom: T\n```
//                                                                    ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(to)
//                                                                       display_name to
//                                                                       documentation ```kotlin\nto: T\n```
//                                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().
//                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(from)
//                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(to)
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[T]
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().[S]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(from)
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().(to)
//                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).
      /** Returns `true` if this [EntityID] expression is between the values [from] and [to], `false` otherwise. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[E]
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(from)
//                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(to)
      fun <T : Any, E : EntityID<T>?> Column<E>.between(from: T, to: T): Between =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : Any\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[E]
//                    display_name FirTypeParameterSymbol E
//                    documentation ```kotlin\nE : EntityID<T>?\n```
//                                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).
//                                                      display_name between
//                                                      documentation ```kotlin\npublic open fun <T : Any, E : EntityID<T>?> Column<E>.between(from: T, to: T): Between\n```\n\n----\n\n Returns `true` if this [EntityID] expression is between the values [from] and [to], `false` otherwise.
//                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(from)
//                                                           display_name from
//                                                           documentation ```kotlin\nfrom: T\n```
//                                                               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(to)
//                                                                  display_name to
//                                                                  documentation ```kotlin\nto: T\n```
//                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[T]
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).[E]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(from)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(to)
          Between(this, wrap(EntityID(from, this.idTable())), wrap(EntityID(to, this.idTable())))
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Between#`<init>`().
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(from)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).(to)
//                                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#between(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
      /** Returns `true` if this expression is null, `false` otherwise. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().[T]
      fun <T> Expression<T>.isNull() = when {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
//                                 display_name isNull
//                                 documentation ```kotlin\npublic open fun <T> Expression<T>.isNull(): Op<Boolean>\n```\n\n----\n\n Returns `true` if this expression is null, `false` otherwise.
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().[T]
          this is Column<*> && isEntityIdentifier() -> table.mapIdOperator(::IsNullOp)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().
          this is QueryParameter && compositeValue != null -> {
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//            ⌄ enclosing_range_start local 20
              val table = compositeValue.values.keys.first().table
//                ^^^^^ definition local 20
//                      display_name table
//                      documentation ```kotlin\nlocal val table: Table\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                              ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                              ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                               ⌃ enclosing_range_end local 20
              table.mapIdOperator(::IsNullOp)
//            ^^^^^ reference local 20
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().
          }
          else -> IsNullOp(this)
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().
      /** Returns `true` if this string expression is null or empty, `false` otherwise. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().[T]
      fun <T : String?> Expression<T>.isNullOrEmpty() = IsNullOp(this).or { this@isNullOrEmpty.charLength() eq 0 }
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : String?\n```
//                                    ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().
//                                                  display_name isNullOrEmpty
//                                                  documentation ```kotlin\npublic open fun <T : String?> Expression<T>.isNullOrEmpty(): Op<Boolean>\n```\n\n----\n\n Returns `true` if this string expression is null or empty, `false` otherwise.
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNullOp#`<init>`().
//                                                                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/or(+1).
//                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/charLength().
//                                                                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eq().
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().[T]
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNullOrEmpty().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
      /** Returns `true` if this expression is not null, `false` otherwise. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().[T]
      fun <T> Expression<T>.isNotNull() = when {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                          ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
//                                    display_name isNotNull
//                                    documentation ```kotlin\npublic open fun <T> Expression<T>.isNotNull(): Op<Boolean>\n```\n\n----\n\n Returns `true` if this expression is not null, `false` otherwise.
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().[T]
          this is Column<*> && isEntityIdentifier() -> table.mapIdOperator(::IsNotNullOp)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/isEntityIdentifier().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().
          this is QueryParameter && compositeValue != null -> {
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//            ⌄ enclosing_range_start local 21
              val table = compositeValue.values.keys.first().table
//                ^^^^^ definition local 21
//                      display_name table
//                      documentation ```kotlin\nlocal val table: Table\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#compositeValue.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#getCompositeValue().
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#getValues().
//                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#values.
//                                              ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#getKeys().
//                                              ^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#keys.
//                                                   ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                               ⌃ enclosing_range_end local 21
              table.mapIdOperator(::IsNotNullOp)
//            ^^^^^ reference local 21
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#mapIdOperator().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().
          }
          else -> IsNotNullOp(this)
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotNullOp#`<init>`().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotNull().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().
      /** Checks if this expression is equal to some [t] value, with `null` treated as a comparable value */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[S]
//                                                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.isNotDistinctFrom(t: T): IsNotDistinctFromOp = IsNotDistinctFromOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().
//                                                                                           display_name isNotDistinctFrom
//                                                                                           documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.isNotDistinctFrom(t: T): IsNotDistinctFromOp\n```\n\n----\n\n Checks if this expression is equal to some [t] value, with `null` treated as a comparable value
//                                                                                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().(t)
//                                                                                             display_name t
//                                                                                             documentation ```kotlin\nt: T\n```
//                                                                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                                                                                                                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                                                                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                                                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().[S]
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().(t)
//                                                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).
      /** Checks if this expression is equal to some [other] expression, with `null` treated as a comparable value */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[S]
//                                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.isNotDistinctFrom(other: Expression<in S>): IsNotDistinctFromOp = IsNotDistinctFromOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).
//                                                                             display_name isNotDistinctFrom
//                                                                             documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.isNotDistinctFrom(other: Expression<in S>): IsNotDistinctFromOp\n```\n\n----\n\n Checks if this expression is equal to some [other] expression, with `null` treated as a comparable value
//                                                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).(other)
//                                                                                   display_name other
//                                                                                   documentation ```kotlin\nother: Expression<in S>\n```
//                                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                                                                                                                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                                                                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).[S]
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).(other)
//                                                                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).
      /** Checks if this expression is equal to some [t] value, with `null` treated as a comparable value */
      @JvmName("isNotDistinctFromEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).[T]
//                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).(t)
      infix fun <T : Any> Column<EntityID<T>>.isNotDistinctFrom(t: T): IsNotDistinctFromOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                                            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).
//                                                              display_name isNotDistinctFrom
//                                                              documentation ```kotlin\n@JvmName(...) public open infix fun <T : Any> Column<EntityID<T>>.isNotDistinctFrom(t: T): IsNotDistinctFromOp\n```\n\n----\n\n Checks if this expression is equal to some [t] value, with `null` treated as a comparable value
//                                                              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).(t)
//                                                                display_name t
//                                                                documentation ```kotlin\nt: T\n```
//                                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).(t)
          IsNotDistinctFromOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).(t)
//                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).
      /** Checks if this [EntityID] expression is equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[V]
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.isNotDistinctFrom(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).
//                                                                                                display_name isNotDistinctFrom
//                                                                                                documentation ```kotlin\npublic open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.isNotDistinctFrom(other: Expression<in V>): IsNotDistinctFromOp\n```\n\n----\n\n Checks if this [EntityID] expression is equal to some [other] expression
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).(other)
      ): IsNotDistinctFromOp = IsNotDistinctFromOp(this, other)
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).(other)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).
      /** Checks if this expression is equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[V]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[E]
      infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.isNotDistinctFrom(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[V]
//                          display_name FirTypeParameterSymbol V
//                          documentation ```kotlin\nV : T?\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[E]
//                                  display_name FirTypeParameterSymbol E
//                                  documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).
//                                                                                  display_name isNotDistinctFrom
//                                                                                  documentation ```kotlin\npublic open infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<V>.isNotDistinctFrom(other: ExpressionWithColumnType<E>): IsNotDistinctFromOp\n```\n\n----\n\n Checks if this expression is equal to some [other] [EntityID] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[T]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[V]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).(other)
      ): IsNotDistinctFromOp = IsNotDistinctFromOp(this, other)
//       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsNotDistinctFromOp#`<init>`().
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).(other)
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNotDistinctFrom(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().
      /** Checks if this expression is not equal to some [t] value, with `null` treated as a comparable value */
      @LowPriorityInOverloadResolution
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[S]
//                                                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().(t)
      infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.isDistinctFrom(t: T): IsDistinctFromOp = IsDistinctFromOp(this, wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                                         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().
//                                                                                        display_name isDistinctFrom
//                                                                                        documentation ```kotlin\n@<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun <T : Comparable<T>, S : T?> ExpressionWithColumnType<in S>.isDistinctFrom(t: T): IsDistinctFromOp\n```\n\n----\n\n Checks if this expression is not equal to some [t] value, with `null` treated as a comparable value
//                                                                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().(t)
//                                                                                          display_name t
//                                                                                          documentation ```kotlin\nt: T\n```
//                                                                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                                                                                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                                                                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                                              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().(t)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().[S]
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().(t)
//                                                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).
      /** Checks if this expression is not equal to some [other] expression, with `null` treated as a comparable value */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[S]
//                                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).(other)
      infix fun <T : Comparable<T>, S : T?> Expression<in S>.isDistinctFrom(other: Expression<in S>): IsDistinctFromOp = IsDistinctFromOp(this, other)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Comparable<T>\n```
//                                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[S]
//                                    display_name FirTypeParameterSymbol S
//                                    documentation ```kotlin\nS : T?\n```
//                                                           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).
//                                                                          display_name isDistinctFrom
//                                                                          documentation ```kotlin\npublic open infix fun <T : Comparable<T>, S : T?> Expression<in S>.isDistinctFrom(other: Expression<in S>): IsDistinctFromOp\n```\n\n----\n\n Checks if this expression is not equal to some [other] expression, with `null` treated as a comparable value
//                                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).(other)
//                                                                                display_name other
//                                                                                documentation ```kotlin\nother: Expression<in S>\n```
//                                                                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                                                                                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                                                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).(other)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).[S]
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).(other)
//                                                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).
      /** Checks if this expression is not equal to some [t] value, with `null` treated as a comparable value */
      @JvmName("isDistinctFromEntityID")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).[T]
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).(t)
      infix fun <T : Any> Column<EntityID<T>>.isDistinctFrom(t: T): IsDistinctFromOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                                            ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).
//                                                           display_name isDistinctFrom
//                                                           documentation ```kotlin\n@JvmName(...) public open infix fun <T : Any> Column<EntityID<T>>.isDistinctFrom(t: T): IsDistinctFromOp\n```\n\n----\n\n Checks if this expression is not equal to some [t] value, with `null` treated as a comparable value
//                                                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).(t)
//                                                             display_name t
//                                                             documentation ```kotlin\nt: T\n```
//                                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).(t)
          IsDistinctFromOp(this, wrap(EntityID(t, this.idTable())))
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#`<init>`(+1).
//                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).(t)
//                                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).
      /** Checks if this [EntityID] expression is not equal to some [other] expression */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[E]
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[V]
      infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.isDistinctFrom(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[E]
//                          display_name FirTypeParameterSymbol E
//                          documentation ```kotlin\nE : EntityID<T>?\n```
//                                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[V]
//                                            display_name FirTypeParameterSymbol V
//                                            documentation ```kotlin\nV : T?\n```
//                                                                              ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).
//                                                                                             display_name isDistinctFrom
//                                                                                             documentation ```kotlin\npublic open infix fun <T : Any, E : EntityID<T>?, V : T?> ExpressionWithColumnType<E>.isDistinctFrom(other: Expression<in V>): IsDistinctFromOp\n```\n\n----\n\n Checks if this [EntityID] expression is not equal to some [other] expression
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[E]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).[V]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).(other)
          other: Expression<in V>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).(other)
//              display_name other
//              documentation ```kotlin\nother: Expression<in V>\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).(other)
      ): IsDistinctFromOp = IsDistinctFromOp(this, other)
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).(other)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).
      /** Checks if this expression is not equal to some [other] [EntityID] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[V]
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[E]
      infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<in V>.isDistinctFrom(
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[V]
//                          display_name FirTypeParameterSymbol V
//                          documentation ```kotlin\nV : T?\n```
//                                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[E]
//                                  display_name FirTypeParameterSymbol E
//                                  documentation ```kotlin\nE : EntityID<T>?\n```
//                                                                   ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).
//                                                                                  display_name isDistinctFrom
//                                                                                  documentation ```kotlin\npublic open infix fun <T : Any, V : T?, E : EntityID<T>?> Expression<in V>.isDistinctFrom(other: ExpressionWithColumnType<E>): IsDistinctFromOp\n```\n\n----\n\n Checks if this expression is not equal to some [other] [EntityID] expression.
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[T]
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[V]
//                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).[E]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).(other)
          other: ExpressionWithColumnType<E>
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).(other)
//              display_name other
//              documentation ```kotlin\nother: ExpressionWithColumnType<E>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).(other)
      ): IsDistinctFromOp = IsDistinctFromOp(this, other)
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IsDistinctFromOp#`<init>`().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).(other)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isDistinctFrom(+4).
  
      // Mathematical Operators
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().
      /** Adds the [t] value to this expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().[T]
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().(t)
      infix operator fun <T> ExpressionWithColumnType<T>.plus(t: T): PlusOp<T, T> = PlusOp(this, wrap(t), columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().
//                                                            display_name plus
//                                                            documentation ```kotlin\npublic open operator infix fun <T> ExpressionWithColumnType<T>.plus(t: T): PlusOp<T, T>\n```\n\n----\n\n Adds the [t] value to this expression.
//                                                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().(t)
//                                                              display_name t
//                                                              documentation ```kotlin\nt: T\n```
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#
//                                                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().
//                                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().(t)
//                                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().[T]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().(t)
//                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).
      /** Adds the [other] expression to this expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[S]
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).(other)
      infix operator fun <T, S : T> ExpressionWithColumnType<T>.plus(other: Expression<S>): PlusOp<T, S> = PlusOp(this, other, columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : T\n```
//                                                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).
//                                                                   display_name plus
//                                                                   documentation ```kotlin\npublic open operator infix fun <T, S : T> ExpressionWithColumnType<T>.plus(other: Expression<S>): PlusOp<T, S>\n```\n\n----\n\n Adds the [other] expression to this expression.
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).(other)
//                                                                         display_name other
//                                                                         documentation ```kotlin\nother: Expression<S>\n```
//                                                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#
//                                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PlusOp#`<init>`().
//                                                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).(other)
//                                                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[T]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).[S]
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).(other)
//                                                                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).
      /**
       * Concatenate the value to the input expression.
       *
       * @param value The string value to be concatenated.
       * @return The concatenated expression.
       */
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).(value)
      infix operator fun Expression<String>.plus(value: String): Concat = concat(this, stringLiteral(value))
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).
//                                               display_name plus
//                                               documentation ```kotlin\npublic open operator infix fun Expression<String>.plus(value: String): Concat\n```\n\n----\n\n\n Concatenate the value to the input expression.\n\n @param value The string value to be concatenated.\n @return The concatenated expression.\n
//                                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).(value)
//                                                     display_name value
//                                                     documentation ```kotlin\nvalue: String\n```
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
//                                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().
//                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).(value)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).(value)
//                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).
      /**
       * Concatenate the value to the input expression.
       *
       * @param value The string value to be concatenated.
       * @return The concatenated expression.
       */
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).(value)
      infix operator fun Expression<String>.plus(value: Expression<String>): Concat = concat(this, value)
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).
//                                               display_name plus
//                                               documentation ```kotlin\npublic open operator infix fun Expression<String>.plus(value: Expression<String>): Concat\n```\n\n----\n\n\n Concatenate the value to the input expression.\n\n @param value The string value to be concatenated.\n @return The concatenated expression.\n
//                                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).(value)
//                                                     display_name value
//                                                     documentation ```kotlin\nvalue: Expression<String>\n```
//                                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).(value)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).(value)
//                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).
      /**
       * Concatenate the value to the input expression.
       *
       * @param value The string value to be concatenated.
       * @return The concatenated expression.
       */
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).(value)
      infix operator fun String.plus(value: Expression<String>): Concat = concat(stringLiteral(this), value)
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).
//                                   display_name plus
//                                   documentation ```kotlin\npublic open operator infix fun String.plus(value: Expression<String>): Concat\n```\n\n----\n\n\n Concatenate the value to the input expression.\n\n @param value The string value to be concatenated.\n @return The concatenated expression.\n
//                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).(value)
//                                         display_name value
//                                         documentation ```kotlin\nvalue: Expression<String>\n```
//                                          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().
//                                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).(value)
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).(value)
//                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#plus(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().
      /** Subtracts the [t] value from this expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().[T]
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().(t)
      infix operator fun <T> ExpressionWithColumnType<T>.minus(t: T): MinusOp<T, T> = MinusOp(this, wrap(t), columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().
//                                                             display_name minus
//                                                             documentation ```kotlin\npublic open operator infix fun <T> ExpressionWithColumnType<T>.minus(t: T): MinusOp<T, T>\n```\n\n----\n\n Subtracts the [t] value from this expression.
//                                                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().(t)
//                                                               display_name t
//                                                               documentation ```kotlin\nt: T\n```
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#
//                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().(t)
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().(t)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).
      /** Subtracts the [other] expression from this expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[S]
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).(other)
      infix operator fun <T, S : T> ExpressionWithColumnType<T>.minus(other: Expression<S>): MinusOp<T, S> = MinusOp(this, other, columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : T\n```
//                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).
//                                                                    display_name minus
//                                                                    documentation ```kotlin\npublic open operator infix fun <T, S : T> ExpressionWithColumnType<T>.minus(other: Expression<S>): MinusOp<T, S>\n```\n\n----\n\n Subtracts the [other] expression from this expression.
//                                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).(other)
//                                                                          display_name other
//                                                                          documentation ```kotlin\nother: Expression<S>\n```
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#
//                                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/MinusOp#`<init>`().
//                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).(other)
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[T]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).[S]
//                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).(other)
//                                                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#minus(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().
      /** Multiplies this expression by the [t] value. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().[T]
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().(t)
      infix operator fun <T> ExpressionWithColumnType<T>.times(t: T): TimesOp<T, T> = TimesOp(this, wrap(t), columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().
//                                                             display_name times
//                                                             documentation ```kotlin\npublic open operator infix fun <T> ExpressionWithColumnType<T>.times(t: T): TimesOp<T, T>\n```\n\n----\n\n Multiplies this expression by the [t] value.
//                                                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().(t)
//                                                               display_name t
//                                                               documentation ```kotlin\nt: T\n```
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#
//                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().(t)
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().(t)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).
      /** Multiplies this expression by the [other] expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[S]
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).(other)
      infix operator fun <T, S : T> ExpressionWithColumnType<T>.times(other: Expression<S>): TimesOp<T, S> = TimesOp(this, other, columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : T\n```
//                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).
//                                                                    display_name times
//                                                                    documentation ```kotlin\npublic open operator infix fun <T, S : T> ExpressionWithColumnType<T>.times(other: Expression<S>): TimesOp<T, S>\n```\n\n----\n\n Multiplies this expression by the [other] expression.
//                                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).(other)
//                                                                          display_name other
//                                                                          documentation ```kotlin\nother: Expression<S>\n```
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#
//                                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/TimesOp#`<init>`().
//                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).(other)
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[T]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).[S]
//                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).(other)
//                                                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#times(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().
      /** Divides this expression by the [t] value. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().[T]
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().(t)
      infix operator fun <T> ExpressionWithColumnType<T>.div(t: T): DivideOp<T, T> = DivideOp(this, wrap(t), columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                                                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().
//                                                           display_name div
//                                                           documentation ```kotlin\npublic open operator infix fun <T> ExpressionWithColumnType<T>.div(t: T): DivideOp<T, T>\n```\n\n----\n\n Divides this expression by the [t] value.
//                                                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().(t)
//                                                             display_name t
//                                                             documentation ```kotlin\nt: T\n```
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#
//                                                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().
//                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().(t)
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().(t)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).
      /** Divides this expression by the [other] expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[S]
//                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).(other)
      infix operator fun <T, S : T> ExpressionWithColumnType<T>.div(other: Expression<S>): DivideOp<T, S> = DivideOp(this, other, columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : T\n```
//                                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).
//                                                                  display_name div
//                                                                  documentation ```kotlin\npublic open operator infix fun <T, S : T> ExpressionWithColumnType<T>.div(other: Expression<S>): DivideOp<T, S>\n```\n\n----\n\n Divides this expression by the [other] expression.
//                                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).(other)
//                                                                        display_name other
//                                                                        documentation ```kotlin\nother: Expression<S>\n```
//                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#
//                                                                                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DivideOp#`<init>`().
//                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).(other)
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[T]
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).[S]
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).(other)
//                                                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#div(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().
      /** Calculates the remainder of dividing this expression by the [t] value. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[S]
//                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().(t)
      infix operator fun <T : Number?, S : T> ExpressionWithColumnType<T>.rem(t: S) = ModOp<T, S, T>(this, wrap(t), columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Number?\n```
//                                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[S]
//                                       display_name FirTypeParameterSymbol S
//                                       documentation ```kotlin\nS : T\n```
//                                                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().
//                                                                            display_name rem
//                                                                            documentation ```kotlin\npublic open operator infix fun <T : Number?, S : T> ExpressionWithColumnType<T>.rem(t: S): ModOp<T, S, T>\n```\n\n----\n\n Calculates the remainder of dividing this expression by the [t] value.
//                                                                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().(t)
//                                                                              display_name t
//                                                                              documentation ```kotlin\nt: S\n```
//                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//                                                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().(t)
//                                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().[S]
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().(t)
//                                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).
      /** Calculates the remainder of dividing this expression by the [other] expression. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[T]
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[S]
//                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).(other)
      infix operator fun <T : Number?, S : Number> ExpressionWithColumnType<T>.rem(other: Expression<S>) = ModOp<T, S, T>(this, other, columnType)
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Number?\n```
//                                     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[S]
//                                       display_name FirTypeParameterSymbol S
//                                       documentation ```kotlin\nS : Number\n```
//                                                                             ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).
//                                                                                 display_name rem
//                                                                                 documentation ```kotlin\npublic open operator infix fun <T : Number?, S : Number> ExpressionWithColumnType<T>.rem(other: Expression<S>): ModOp<T, S, T>\n```\n\n----\n\n Calculates the remainder of dividing this expression by the [other] expression.
//                                                                                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).(other)
//                                                                                       display_name other
//                                                                                       documentation ```kotlin\nother: Expression<S>\n```
//                                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#`<init>`().
//                                                                                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).(other)
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[T]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).[S]
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).(other)
//                                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).
      /** Calculates the remainder of dividing the value of [this] numeric PK by the [other] number. */
      @JvmName("remWithEntityId")
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[S]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[ID]
//                                                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).(other)
      infix operator fun <T, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.rem(other: S) where T : Number, T : Comparable<T> =
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Number, Comparable<T>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : Number\n```
//                                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[ID]
//                                          display_name FirTypeParameterSymbol ID
//                                          documentation ```kotlin\nID : EntityID<T>?\n```
//                                                                                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).
//                                                                                           display_name rem
//                                                                                           documentation ```kotlin\n@JvmName(...) public open operator infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.rem(other: S): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing the value of [this] numeric PK by the [other] number.
//                                                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).(other)
//                                                                                                 display_name other
//                                                                                                 documentation ```kotlin\nother: S\n```
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[T]
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[S]
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).[ID]
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).(other)
          ModOp(this, other)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+2).
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).(other)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).
      /** Calculates the remainder of dividing [this] number expression by [other] numeric PK */
      @JvmName("remWithEntityId2")
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[S]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[ID]
//                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).(other)
      infix operator fun <T, S : Number, ID : EntityID<T>?> Expression<S>.rem(other: ExpressionWithColumnType<ID>) where T : Number, T : Comparable<T> =
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Number, Comparable<T>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : Number\n```
//                                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[ID]
//                                          display_name FirTypeParameterSymbol ID
//                                          documentation ```kotlin\nID : EntityID<T>?\n```
//                                                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).
//                                                                            display_name rem
//                                                                            documentation ```kotlin\n@JvmName(...) public open operator infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> Expression<S>.rem(other: ExpressionWithColumnType<ID>): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing [this] number expression by [other] numeric PK
//                                                                            ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).(other)
//                                                                                  display_name other
//                                                                                  documentation ```kotlin\nother: ExpressionWithColumnType<ID>\n```
//                                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[T]
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[S]
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).[ID]
//                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).(other)
          ModOp(this, other)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke(+1).
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).(other)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).
      /** Calculates the remainder of dividing the value of [this] numeric PK by the [other] number expression. */
      @JvmName("remWithEntityId3")
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[S]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[ID]
//                                                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).(other)
      infix operator fun <T, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.rem(other: Expression<S>) where T : Number, T : Comparable<T> =
//                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[T]
//                          display_name FirTypeParameterSymbol T
//                          documentation ```kotlin\nT : Number, Comparable<T>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[S]
//                             display_name FirTypeParameterSymbol S
//                             documentation ```kotlin\nS : Number\n```
//                                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[ID]
//                                          display_name FirTypeParameterSymbol ID
//                                          documentation ```kotlin\nID : EntityID<T>?\n```
//                                                                                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).
//                                                                                           display_name rem
//                                                                                           documentation ```kotlin\n@JvmName(...) public open operator infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.rem(other: Expression<S>): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing the value of [this] numeric PK by the [other] number expression.
//                                                                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).(other)
//                                                                                                 display_name other
//                                                                                                 documentation ```kotlin\nother: Expression<S>\n```
//                                                                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[T]
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[S]
//                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).[ID]
//                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).(other)
          ModOp(this, other)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).(other)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().
      /** Calculates the remainder of dividing this expression by the [t] value. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[S]
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().(t)
      infix fun <T : Number?, S : T> ExpressionWithColumnType<T>.mod(t: S) = this % t
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Number?\n```
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[S]
//                              display_name FirTypeParameterSymbol S
//                              documentation ```kotlin\nS : T\n```
//                                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().
//                                                                   display_name mod
//                                                                   documentation ```kotlin\npublic open infix fun <T : Number?, S : T> ExpressionWithColumnType<T>.mod(t: S): ModOp<T, S, T>\n```\n\n----\n\n Calculates the remainder of dividing this expression by the [t] value.
//                                                                   ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().(t)
//                                                                     display_name t
//                                                                     documentation ```kotlin\nt: S\n```
//                                                                                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem().
//                                                                                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().(t)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[T]
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().[S]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().(t)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).
      /** Calculates the remainder of dividing this expression by the [other] expression. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[S]
//                                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).(other)
      infix fun <T : Number?, S : Number> ExpressionWithColumnType<T>.mod(other: Expression<S>) = this % other
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Number?\n```
//                            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[S]
//                              display_name FirTypeParameterSymbol S
//                              documentation ```kotlin\nS : Number\n```
//                                                                    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).
//                                                                        display_name mod
//                                                                        documentation ```kotlin\npublic open infix fun <T : Number?, S : Number> ExpressionWithColumnType<T>.mod(other: Expression<S>): ModOp<T, S, T>\n```\n\n----\n\n Calculates the remainder of dividing this expression by the [other] expression.
//                                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).(other)
//                                                                              display_name other
//                                                                              documentation ```kotlin\nother: Expression<S>\n```
//                                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                                     ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+1).
//                                                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).(other)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[T]
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).[S]
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).(other)
//                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).
      /** Calculates the remainder of dividing the value of [this] numeric PK by the [other] number. */
      @JvmName("modWithEntityId")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[ID]
//                                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).(other)
      infix fun <T, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.mod(other: S) where T : Number, T : Comparable<T> = this % other
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Number, Comparable<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Number\n```
//                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[ID]
//                                 display_name FirTypeParameterSymbol ID
//                                 documentation ```kotlin\nID : EntityID<T>?\n```
//                                                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).
//                                                                                  display_name mod
//                                                                                  documentation ```kotlin\n@JvmName(...) public open infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.mod(other: S): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing the value of [this] numeric PK by the [other] number.
//                                                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).(other)
//                                                                                        display_name other
//                                                                                        documentation ```kotlin\nother: S\n```
//                                                                                                                                       ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+2).
//                                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).(other)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[S]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).[ID]
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).(other)
//                                                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).
      /** Calculates the remainder of dividing [this] number expression by [other] numeric PK */
      @JvmName("modWithEntityId2")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[ID]
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).(other)
      infix fun <T, S : Number, ID : EntityID<T>?> Expression<S>.mod(other: ExpressionWithColumnType<ID>) where T : Number, T : Comparable<T> = this % other
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Number, Comparable<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Number\n```
//                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[ID]
//                                 display_name FirTypeParameterSymbol ID
//                                 documentation ```kotlin\nID : EntityID<T>?\n```
//                                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).
//                                                                   display_name mod
//                                                                   documentation ```kotlin\n@JvmName(...) public open infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> Expression<S>.mod(other: ExpressionWithColumnType<ID>): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing [this] number expression by [other] numeric PK
//                                                                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).(other)
//                                                                         display_name other
//                                                                         documentation ```kotlin\nother: ExpressionWithColumnType<ID>\n```
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                                                                                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rem(+3).
//                                                                                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).(other)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[S]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).[ID]
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).(other)
//                                                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).
      /** Calculates the remainder of dividing the value of [this] numeric PK by the [other] number expression. */
      @JvmName("modWithEntityId3")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[T]
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[S]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[ID]
//                                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).(other)
      infix fun <T, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.mod(other: Expression<S>) where T : Number, T : Comparable<T> =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Number, Comparable<T>\n```
//                  ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[S]
//                    display_name FirTypeParameterSymbol S
//                    documentation ```kotlin\nS : Number\n```
//                              ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[ID]
//                                 display_name FirTypeParameterSymbol ID
//                                 documentation ```kotlin\nID : EntityID<T>?\n```
//                                                                              ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).
//                                                                                  display_name mod
//                                                                                  documentation ```kotlin\n@JvmName(...) public open infix fun <T : Number, Comparable<T>, S : Number, ID : EntityID<T>?> ExpressionWithColumnType<ID>.mod(other: Expression<S>): ExpressionWithColumnType<T>\n```\n\n----\n\n Calculates the remainder of dividing the value of [this] numeric PK by the [other] number expression.
//                                                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).(other)
//                                                                                        display_name other
//                                                                                        documentation ```kotlin\nother: Expression<S>\n```
//                                                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[T]
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[S]
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).[ID]
//                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).(other)
          ModOp(this, other)
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#Companion#invoke().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).(other)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#mod(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().
      /**
       * Performs a bitwise `and` on this expression and [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().[T]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseAnd(t: T): AndBitOp<T, T> = AndBitOp(this, wrap(t), columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().
//                                                         display_name bitwiseAnd
//                                                         documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseAnd(t: T): AndBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `and` on this expression and [t].\n
//                                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().(t)
//                                                           display_name t
//                                                           documentation ```kotlin\nt: T\n```
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                     ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().(t)
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().(t)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).
      /**
       * Performs a bitwise `and` on this expression and expression [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).[T]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseAnd(t: Expression<T>): AndBitOp<T, T> = AndBitOp(this, t, columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).
//                                                         display_name bitwiseAnd
//                                                         documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseAnd(t: Expression<T>): AndBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `and` on this expression and expression [t].\n
//                                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).(t)
//                                                           display_name t
//                                                           documentation ```kotlin\nt: Expression<T>\n```
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#
//                                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).(t)
//                                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).[T]
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).(t)
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseAnd(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().
      /**
       * Performs a bitwise `or` on this expression and [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().[T]
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseOr(t: T): OrBitOp<T, T> = OrBitOp(this, wrap(t), columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().
//                                                        display_name bitwiseOr
//                                                        documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseOr(t: T): OrBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `or` on this expression and [t].\n
//                                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().(t)
//                                                          display_name t
//                                                          documentation ```kotlin\nt: T\n```
//                                                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#
//                                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().
//                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().(t)
//                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().[T]
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().(t)
//                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).
      /**
       * Performs a bitwise `or` on this expression and expression [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).[T]
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseOr(t: Expression<T>): OrBitOp<T, T> = OrBitOp(this, t, columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).
//                                                        display_name bitwiseOr
//                                                        documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseOr(t: Expression<T>): OrBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `or` on this expression and expression [t].\n
//                                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).(t)
//                                                          display_name t
//                                                          documentation ```kotlin\nt: Expression<T>\n```
//                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#
//                                                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#`<init>`().
//                                                                                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).(t)
//                                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).[T]
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).(t)
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseOr(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().
      /**
       * Performs a bitwise `or` on this expression and [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().[T]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseXor(t: T): XorBitOp<T, T> = XorBitOp(this, wrap(t), columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().
//                                                         display_name bitwiseXor
//                                                         documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseXor(t: T): XorBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `or` on this expression and [t].\n
//                                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().(t)
//                                                           display_name t
//                                                           documentation ```kotlin\nt: T\n```
//                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().
//                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                     ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().(t)
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().[T]
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().(t)
//                                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).
      /**
       * Performs a bitwise `or` on this expression and expression [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).[T]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).(t)
      infix fun <T> ExpressionWithColumnType<T>.bitwiseXor(t: Expression<T>): XorBitOp<T, T> = XorBitOp(this, t, columnType)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).
//                                                         display_name bitwiseXor
//                                                         documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.bitwiseXor(t: Expression<T>): XorBitOp<T, T>\n```\n\n----\n\n\n Performs a bitwise `or` on this expression and expression [t].\n
//                                                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).(t)
//                                                           display_name t
//                                                           documentation ```kotlin\nt: Expression<T>\n```
//                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#
//                                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#`<init>`().
//                                                                                                            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).(t)
//                                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).[T]
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).(t)
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#bitwiseXor(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().
      /**
       * Performs a bitwise `and` on this expression and [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().[T]
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().(t)
      infix fun <T> ExpressionWithColumnType<T>.hasFlag(t: T): EqOp = EqOp(AndBitOp(this, wrap(t), columnType), wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().
//                                                      display_name hasFlag
//                                                      documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.hasFlag(t: T): EqOp\n```\n\n----\n\n\n Performs a bitwise `and` on this expression and [t].\n
//                                                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().(t)
//                                                        display_name t
//                                                        documentation ```kotlin\nt: T\n```
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#
//                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                             ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().(t)
//                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                   ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().(t)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().[T]
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().(t)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).
      /**
       * Performs a bitwise `and` on this expression and expression [t].
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).[T]
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).(t)
      infix fun <T> ExpressionWithColumnType<T>.hasFlag(t: Expression<T>): EqOp = EqOp(AndBitOp(this, t, columnType), wrap(t))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).
//                                                      display_name hasFlag
//                                                      documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.hasFlag(t: Expression<T>): EqOp\n```\n\n----\n\n\n Performs a bitwise `and` on this expression and expression [t].\n
//                                                      ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).(t)
//                                                        display_name t
//                                                        documentation ```kotlin\nt: Expression<T>\n```
//                                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#
//                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqOp#`<init>`().
//                                                                                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#`<init>`().
//                                                                                                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).(t)
//                                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                                                                                         ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).(t)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).(t)
//                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#hasFlag(+1).
  
      // String Functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
      /** Concatenates the text representations of all the [expr]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().(expr)
      fun concat(vararg expr: Expression<*>): Concat = Concat("", *expr)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
//               display_name concat
//               documentation ```kotlin\npublic open fun concat(vararg expr: Expression<*>): Concat\n```\n\n----\n\n Concatenates the text representations of all the [expr].
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().(expr)
//                           display_name expr
//                           documentation ```kotlin\nvararg expr: Expression<*>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().
//                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().(expr)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().(expr)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).
      /** Concatenates the text representations of all the [expr] using the specified [separator]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(separator)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(expr)
      fun concat(separator: String = "", expr: List<Expression<*>>): Concat = Concat(separator, expr = expr.toTypedArray())
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).
//               display_name concat
//               documentation ```kotlin\npublic open fun concat(separator: String = ..., expr: List<Expression<*>>): Concat\n```\n\n----\n\n Concatenates the text representations of all the [expr] using the specified [separator].
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(separator)
//                         display_name separator
//                         documentation ```kotlin\nseparator: String = ...\n```
//                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(expr)
//                                            display_name expr
//                                            documentation ```kotlin\nexpr: List<Expression<*>>\n```
//                                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#
//                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Concat#`<init>`().
//                                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(separator)
//                                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(expr)
//                                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/toTypedArray().
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(separator)
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).(expr)
//                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#concat(+1).
  
      // Pattern Matching
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().
      /** Checks if this expression matches the specified [pattern]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().(pattern)
      infix fun <T : String?> Expression<T>.like(pattern: String) = like(LikePattern(pattern))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().
//                                               display_name like
//                                               documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.like(pattern: String): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [pattern].
//                                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().(pattern)
//                                                       display_name pattern
//                                                       documentation ```kotlin\npattern: String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).
//                                                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().(pattern)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().[T]
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().(pattern)
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).
      /** Checks if this expression matches the specified [pattern]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).(pattern)
      infix fun <T : String?> Expression<T>.like(pattern: LikePattern): LikeEscapeOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).
//                                               display_name like
//                                               documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.like(pattern: LikePattern): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [pattern].
//                                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).(pattern)
//                                                       display_name pattern
//                                                       documentation ```kotlin\npattern: LikePattern\n```
//                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).[T]
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).(pattern)
          LikeEscapeOp(this, stringParam(pattern.pattern), true, pattern.escapeChar)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).(pattern)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).(pattern)
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).
      /** Checks if this expression matches the specified [pattern]. */
      @JvmName("likeWithEntityID")
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).(pattern)
      infix fun Expression<EntityID<String>>.like(pattern: String) = like(LikePattern(pattern))
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).
//                                                display_name like
//                                                documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.like(pattern: String): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [pattern].
//                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).(pattern)
//                                                        display_name pattern
//                                                        documentation ```kotlin\npattern: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).
//                                                                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).(pattern)
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).(pattern)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).
      /** Checks if this expression matches the specified [pattern]. */
      @JvmName("likeWithEntityID")
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).(pattern)
      infix fun Expression<EntityID<String>>.like(pattern: LikePattern): LikeEscapeOp =
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).
//                                                display_name like
//                                                documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.like(pattern: LikePattern): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [pattern].
//                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).(pattern)
//                                                        display_name pattern
//                                                        documentation ```kotlin\npattern: LikePattern\n```
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).(pattern)
          LikeEscapeOp(this, stringParam(pattern.pattern), true, pattern.escapeChar)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).(pattern)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).(pattern)
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).
      /** Checks if this expression matches the specified [expression]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).(expression)
      infix fun <T : String?> Expression<T>.like(expression: ExpressionWithColumnType<String>): LikeEscapeOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).
//                                               display_name like
//                                               documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.like(expression: ExpressionWithColumnType<String>): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [expression].
//                                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).(expression)
//                                                          display_name expression
//                                                          documentation ```kotlin\nexpression: ExpressionWithColumnType<String>\n```
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).[T]
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).(expression)
          LikeEscapeOp(this, expression, true, null)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).(expression)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).
      /** Checks if this expression matches the specified [expression]. */
      @JvmName("likeWithEntityIDAndExpression")
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).(expression)
      infix fun Expression<EntityID<String>>.like(expression: ExpressionWithColumnType<String>): LikeEscapeOp =
//                                           ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).
//                                                display_name like
//                                                documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.like(expression: ExpressionWithColumnType<String>): LikeEscapeOp\n```\n\n----\n\n Checks if this expression matches the specified [expression].
//                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).(expression)
//                                                           display_name expression
//                                                           documentation ```kotlin\nexpression: ExpressionWithColumnType<String>\n```
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).(expression)
          LikeEscapeOp(this, expression, true, null)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).(expression)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like(+5).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().
      /** Checks if this expression matches the specified [pattern]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().[T]
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().(pattern)
      infix fun <T : String?> Expression<T>.match(pattern: String): Op<Boolean> = match(pattern, null)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().
//                                                display_name match
//                                                documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.match(pattern: String): Op<Boolean>\n```\n\n----\n\n Checks if this expression matches the specified [pattern].
//                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().(pattern)
//                                                        display_name pattern
//                                                        documentation ```kotlin\npattern: String\n```
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).
//                                                                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().(pattern)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().[T]
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().(pattern)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).
      /** Checks if this expression matches the specified [pattern] using the specified match [mode]. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).[T]
      fun <T : String?> Expression<T>.match(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : String?\n```
//                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).
//                                          display_name match
//                                          documentation ```kotlin\npublic open fun <T : String?> Expression<T>.match(pattern: String, mode: FunctionProvider.MatchMode?): Op<Boolean>\n```\n\n----\n\n Checks if this expression matches the specified [pattern] using the specified match [mode].
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(pattern)
          pattern: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(mode)
          mode: FunctionProvider.MatchMode?
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(mode)
//             display_name mode
//             documentation ```kotlin\nmode: FunctionProvider.MatchMode?\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(mode)
      ): Op<Boolean> = with(currentDialect.functionProvider) { this@match.match(pattern, mode) }
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                     ^^^^ reference semanticdb maven . . kotlin/with().
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#functionProvider.
//                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getFunctionProvider().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().
//                                                                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(pattern)
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).(mode)
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#match(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().
      /** Checks if this expression doesn't match the specified [pattern]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().(pattern)
      infix fun <T : String?> Expression<T>.notLike(pattern: String): LikeEscapeOp = notLike(LikePattern(pattern))
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().
//                                                  display_name notLike
//                                                  documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.notLike(pattern: String): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified [pattern].
//                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().(pattern)
//                                                          display_name pattern
//                                                          documentation ```kotlin\npattern: String\n```
//                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).
//                                                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().(pattern)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().[T]
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().(pattern)
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).
      /** Checks if this expression doesn't match the specified [pattern]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).(pattern)
      infix fun <T : String?> Expression<T>.notLike(pattern: LikePattern): LikeEscapeOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).
//                                                  display_name notLike
//                                                  documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.notLike(pattern: LikePattern): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified [pattern].
//                                                  ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).(pattern)
//                                                          display_name pattern
//                                                          documentation ```kotlin\npattern: LikePattern\n```
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).(pattern)
          LikeEscapeOp(this, stringParam(pattern.pattern), false, pattern.escapeChar)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).(pattern)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).(pattern)
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).
      /** Checks if this expression doesn't match the specified [pattern]. */
      @JvmName("notLikeWithEntityID")
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).(pattern)
      infix fun Expression<EntityID<String>>.notLike(pattern: String): LikeEscapeOp = notLike(LikePattern(pattern))
//                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).
//                                                   display_name notLike
//                                                   documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.notLike(pattern: String): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified [pattern].
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).(pattern)
//                                                           display_name pattern
//                                                           documentation ```kotlin\npattern: String\n```
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).
//                                                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#`<init>`().
//                                                                                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).(pattern)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).(pattern)
//                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).
      /** Checks if this expression doesn't match the specified [pattern]. */
      @JvmName("notLikeWithEntityID")
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).(pattern)
      infix fun Expression<EntityID<String>>.notLike(pattern: LikePattern): LikeEscapeOp =
//                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).
//                                                   display_name notLike
//                                                   documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.notLike(pattern: LikePattern): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified [pattern].
//                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).(pattern)
//                                                           display_name pattern
//                                                           documentation ```kotlin\npattern: LikePattern\n```
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).(pattern)
          LikeEscapeOp(this, stringParam(pattern.pattern), false, pattern.escapeChar)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).(pattern)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getPattern().
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#pattern.
//                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).(pattern)
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#escapeChar.
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikePattern#getEscapeChar().
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).
      /** Checks if this expression doesn't match the specified pattern. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).(expression)
      infix fun <T : String?> Expression<T>.notLike(expression: ExpressionWithColumnType<String>): LikeEscapeOp =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).
//                                                  display_name notLike
//                                                  documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.notLike(expression: ExpressionWithColumnType<String>): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified pattern.
//                                                  ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).(expression)
//                                                             display_name expression
//                                                             documentation ```kotlin\nexpression: ExpressionWithColumnType<String>\n```
//                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).[T]
//                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).(expression)
          LikeEscapeOp(this, expression, false, null)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).(expression)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).
      /** Checks if this expression doesn't match the specified [expression]. */
      @JvmName("notLikeWithEntityIDAndExpression")
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).(expression)
      infix fun Expression<EntityID<String>>.notLike(expression: ExpressionWithColumnType<String>): LikeEscapeOp =
//                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).
//                                                   display_name notLike
//                                                   documentation ```kotlin\n@JvmName(...) public open infix fun Expression<EntityID<String>>.notLike(expression: ExpressionWithColumnType<String>): LikeEscapeOp\n```\n\n----\n\n Checks if this expression doesn't match the specified [expression].
//                                                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).(expression)
//                                                              display_name expression
//                                                              documentation ```kotlin\nexpression: ExpressionWithColumnType<String>\n```
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#
//                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).(expression)
          LikeEscapeOp(this, expression, false, null)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LikeEscapeOp#`<init>`().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).(expression)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notLike(+5).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().
      /** Checks if this expression matches the [pattern]. Supports regular expressions. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().[T]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().(pattern)
      infix fun <T : String?> Expression<T>.regexp(pattern: String): RegexpOp<T> = RegexpOp(this, stringParam(pattern), true)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : String?\n```
//                                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().
//                                                 display_name regexp
//                                                 documentation ```kotlin\npublic open infix fun <T : String?> Expression<T>.regexp(pattern: String): RegexpOp<T>\n```\n\n----\n\n Checks if this expression matches the [pattern]. Supports regular expressions.
//                                                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().(pattern)
//                                                         display_name pattern
//                                                         documentation ```kotlin\npattern: String\n```
//                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//                                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().
//                                                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringParam().
//                                                                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().(pattern)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().[T]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().(pattern)
//                                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).
      /** Checks if this expression matches the [pattern]. Supports regular expressions. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).[T]
      fun <T : String?> Expression<T>.regexp(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT : String?\n```
//                                    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).
//                                           display_name regexp
//                                           documentation ```kotlin\npublic open fun <T : String?> Expression<T>.regexp(pattern: Expression<String>, caseSensitive: Boolean = ...): RegexpOp<T>\n```\n\n----\n\n Checks if this expression matches the [pattern]. Supports regular expressions.
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(pattern)
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(caseSensitive)
          caseSensitive: Boolean = true
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean = ...\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(caseSensitive)
      ): RegexpOp<T> = RegexpOp(this, pattern, caseSensitive)
//       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RegexpOp#`<init>`().
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(pattern)
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).(caseSensitive)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#regexp(+1).
  
      // Window Functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rowNumber().
      /** Returns the number of the current row within its partition, counting from 1. */
      fun rowNumber(): RowNumber = RowNumber()
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rowNumber().
//                  display_name rowNumber
//                  documentation ```kotlin\npublic open fun rowNumber(): RowNumber\n```\n\n----\n\n Returns the number of the current row within its partition, counting from 1.
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/RowNumber#`<init>`().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rowNumber().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rank().
      /** Returns the rank of the current row, with gaps; that is, the row_number of the first row in its peer group. */
      fun rank(): Rank = Rank()
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rank().
//             display_name rank
//             documentation ```kotlin\npublic open fun rank(): Rank\n```\n\n----\n\n Returns the rank of the current row, with gaps; that is, the row_number of the first row in its peer group.
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#
//                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Rank#`<init>`().
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#rank().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#denseRank().
      /** Returns the rank of the current row, without gaps; this function effectively counts peer groups. */
      fun denseRank(): DenseRank = DenseRank()
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#denseRank().
//                  display_name denseRank
//                  documentation ```kotlin\npublic open fun denseRank(): DenseRank\n```\n\n----\n\n Returns the rank of the current row, without gaps; this function effectively counts peer groups.
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DenseRank#`<init>`().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#denseRank().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#percentRank().
      /**
       * Returns the relative rank of the current row, that is (rank - 1) / (total partition rows - 1).
       * The value thus ranges from 0 to 1 inclusive.
       */
      fun percentRank(): PercentRank = PercentRank()
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#percentRank().
//                    display_name percentRank
//                    documentation ```kotlin\npublic open fun percentRank(): PercentRank\n```\n\n----\n\n\n Returns the relative rank of the current row, that is (rank - 1) / (total partition rows - 1).\n The value thus ranges from 0 to 1 inclusive.\n
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/PercentRank#`<init>`().
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#percentRank().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#cumeDist().
      /**
       * Returns the cumulative distribution, that is (number of partition rows preceding or peers with current row) /
       * (total partition rows). The value thus ranges from 1/N to 1.
       */
      fun cumeDist(): CumeDist = CumeDist()
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#cumeDist().
//                 display_name cumeDist
//                 documentation ```kotlin\npublic open fun cumeDist(): CumeDist\n```\n\n----\n\n\n Returns the cumulative distribution, that is (number of partition rows preceding or peers with current row)\n (total partition rows). The value thus ranges from 1/N to 1.\n
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CumeDist#`<init>`().
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#cumeDist().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().
      /** Returns an integer ranging from 1 to the [numBuckets], dividing the partition as equally as possible. */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().(numBuckets)
      fun ntile(numBuckets: ExpressionWithColumnType<Int>): Ntile = Ntile(numBuckets)
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().
//              display_name ntile
//              documentation ```kotlin\npublic open fun ntile(numBuckets: ExpressionWithColumnType<Int>): Ntile\n```\n\n----\n\n Returns an integer ranging from 1 to the [numBuckets], dividing the partition as equally as possible.
//              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().(numBuckets)
//                         display_name numBuckets
//                         documentation ```kotlin\nnumBuckets: ExpressionWithColumnType<Int>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#
//                                                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Ntile#`<init>`().
//                                                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().(numBuckets)
//                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().(numBuckets)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#ntile().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().
      /**
       * Returns value evaluated at the row that is [offset] rows before the current row within the partition;
       * if there is no such row, instead returns [defaultValue].
       * Both [offset] and [defaultValue] are evaluated with respect to the current row.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().[T]
      fun <T> ExpressionWithColumnType<T>.lag(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                                        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().
//                                            display_name lag
//                                            documentation ```kotlin\npublic open fun <T> ExpressionWithColumnType<T>.lag(offset: ExpressionWithColumnType<Int> = ..., defaultValue: ExpressionWithColumnType<T>? = ...): Lag<T>\n```\n\n----\n\n\n Returns value evaluated at the row that is [offset] rows before the current row within the partition;\n if there is no such row, instead returns [defaultValue].\n Both [offset] and [defaultValue] are evaluated with respect to the current row.\n
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(offset)
          offset: ExpressionWithColumnType<Int> = intLiteral(1),
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(offset)
//               display_name offset
//               documentation ```kotlin\noffset: ExpressionWithColumnType<Int> = ...\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(offset)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(defaultValue)
          defaultValue: ExpressionWithColumnType<T>? = null
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(defaultValue)
//                     display_name defaultValue
//                     documentation ```kotlin\ndefaultValue: ExpressionWithColumnType<T>? = ...\n```
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(defaultValue)
      ): Lag<T> = Lag(this, offset, defaultValue)
//       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#
//                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lag#`<init>`().
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(offset)
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().(defaultValue)
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lag().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().
      /**
       * Returns value evaluated at the row that is [offset] rows after the current row within the partition;
       * if there is no such row, instead returns [defaultValue].
       * Both [offset] and [defaultValue] are evaluated with respect to the current row.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().[T]
      fun <T> ExpressionWithColumnType<T>.lead(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().
//                                             display_name lead
//                                             documentation ```kotlin\npublic open fun <T> ExpressionWithColumnType<T>.lead(offset: ExpressionWithColumnType<Int> = ..., defaultValue: ExpressionWithColumnType<T>? = ...): Lead<T>\n```\n\n----\n\n\n Returns value evaluated at the row that is [offset] rows after the current row within the partition;\n if there is no such row, instead returns [defaultValue].\n Both [offset] and [defaultValue] are evaluated with respect to the current row.\n
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(offset)
          offset: ExpressionWithColumnType<Int> = intLiteral(1),
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(offset)
//               display_name offset
//               documentation ```kotlin\noffset: ExpressionWithColumnType<Int> = ...\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(offset)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(defaultValue)
          defaultValue: ExpressionWithColumnType<T>? = null
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(defaultValue)
//                     display_name defaultValue
//                     documentation ```kotlin\ndefaultValue: ExpressionWithColumnType<T>? = ...\n```
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(defaultValue)
      ): Lead<T> = Lead(this, offset, defaultValue)
//       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Lead#`<init>`().
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(offset)
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().(defaultValue)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lead().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().
      /**
       * Returns value evaluated at the row that is the first row of the window frame.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().[T]
      fun <T> ExpressionWithColumnType<T>.firstValue(): FirstValue<T> = FirstValue(this)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().
//                                                   display_name firstValue
//                                                   documentation ```kotlin\npublic open fun <T> ExpressionWithColumnType<T>.firstValue(): FirstValue<T>\n```\n\n----\n\n\n Returns value evaluated at the row that is the first row of the window frame.\n
//                                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/FirstValue#`<init>`().
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().[T]
//                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#firstValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().
      /**
       * Returns value evaluated at the row that is the last row of the window frame.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().[T]
      fun <T> ExpressionWithColumnType<T>.lastValue(): LastValue<T> = LastValue(this)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().
//                                                  display_name lastValue
//                                                  documentation ```kotlin\npublic open fun <T> ExpressionWithColumnType<T>.lastValue(): LastValue<T>\n```\n\n----\n\n\n Returns value evaluated at the row that is the last row of the window frame.\n
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#
//                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LastValue#`<init>`().
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().[T]
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lastValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().
      /**
       * Returns value evaluated at the row that is the [n]'th row of the window frame
       * (counting from 1); null if no such row.
       */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().[T]
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().(n)
      fun <T> ExpressionWithColumnType<T>.nthValue(n: ExpressionWithColumnType<Int>): NthValue<T> = NthValue(this, n)
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().
//                                                 display_name nthValue
//                                                 documentation ```kotlin\npublic open fun <T> ExpressionWithColumnType<T>.nthValue(n: ExpressionWithColumnType<Int>): NthValue<T>\n```\n\n----\n\n\n Returns value evaluated at the row that is the [n]'th row of the window frame\n (counting from 1); null if no such row.\n
//                                                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().(n)
//                                                   display_name n
//                                                   documentation ```kotlin\nn: ExpressionWithColumnType<Int>\n```
//                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#
//                                                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NthValue#`<init>`().
//                                                                                                                 ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().(n)
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().[T]
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().(n)
//                                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#nthValue().
  
      // Conditional Expressions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().
      /** Returns the first of its arguments that is not null. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[S]
      fun <T, S : T?> coalesce(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[S]
//              display_name FirTypeParameterSymbol S
//              documentation ```kotlin\nS : T?\n```
//                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().
//                             display_name coalesce
//                             documentation ```kotlin\npublic open fun <T, S : T?> coalesce(expr: ExpressionWithColumnType<S>, alternate: Expression<out T>, vararg others: Expression<out T>): Coalesce<T, S>\n```\n\n----\n\n Returns the first of its arguments that is not null.
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[T]
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().[S]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(expr)
          expr: ExpressionWithColumnType<S>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: ExpressionWithColumnType<S>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(alternate)
          alternate: Expression<out T>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(alternate)
//                  display_name alternate
//                  documentation ```kotlin\nalternate: Expression<out T>\n```
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(alternate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(others)
          vararg others: Expression<out T>
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(others)
//                      display_name others
//                      documentation ```kotlin\nvararg others: Expression<out T>\n```
//                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(others)
      ): Coalesce<T, S> = Coalesce<T, S>(expr, alternate, others = others)
//       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Coalesce#`<init>`().
//                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(expr)
//                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(alternate)
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().(others)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#coalesce().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().
      /**
       * Compares [value] against any chained conditional expressions.
       *
       * If [value] is `null`, chained conditionals will be evaluated separately until the first is evaluated as `true`.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.ConditionsTests.nullOpInCaseTest
       */
//             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().(value)
      fun case(value: Expression<*>? = null): Case = Case(value)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().
//             display_name case
//             documentation ```kotlin\npublic open fun case(value: Expression<*>? = ...): Case\n```\n\n----\n\n\n Compares [value] against any chained conditional expressions.\n\n If [value] is `null`, chained conditionals will be evaluated separately until the first is evaluated as `true`.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.ConditionsTests.nullOpInCaseTest\n
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().(value)
//                   display_name value
//                   documentation ```kotlin\nvalue: Expression<*>? = ...\n```
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#
//                                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
//                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().(value)
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().(value)
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#case().
  
      // Subquery Expressions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().
      /** Checks if this expression is equals to any row returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().[T]
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().(query)
      infix fun <T> Expression<T>.inSubQuery(query: AbstractQuery<*>): InSubQueryOp<T> = InSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().
//                                           display_name inSubQuery
//                                           documentation ```kotlin\npublic open infix fun <T> Expression<T>.inSubQuery(query: AbstractQuery<*>): InSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is equals to any row returned from [query].
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().(query)
//                                                 display_name query
//                                                 documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/InSubQueryOp#`<init>`().
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().(query)
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().
      /** Checks if this expression is not equals to any row returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().[T]
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().(query)
      infix fun <T> Expression<T>.notInSubQuery(query: AbstractQuery<*>): NotInSubQueryOp<T> = NotInSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().
//                                              display_name notInSubQuery
//                                              documentation ```kotlin\npublic open infix fun <T> Expression<T>.notInSubQuery(query: AbstractQuery<*>): NotInSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is not equals to any row returned from [query].
//                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().(query)
//                                                    display_name query
//                                                    documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#
//                                                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotInSubQueryOp#`<init>`().
//                                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().(query)
//                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().
      /** Checks if this expression is equals to single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().[T]
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().(query)
      infix fun <T> Expression<T>.eqSubQuery(query: AbstractQuery<*>): EqSubQueryOp<T> = EqSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().
//                                           display_name eqSubQuery
//                                           documentation ```kotlin\npublic open infix fun <T> Expression<T>.eqSubQuery(query: AbstractQuery<*>): EqSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is equals to single value returned from [query].
//                                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().(query)
//                                                 display_name query
//                                                 documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EqSubQueryOp#`<init>`().
//                                                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().(query)
//                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#eqSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().
      /** Checks if this expression is not equals to single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().[T]
//                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().(query)
      infix fun <T> Expression<T>.notEqSubQuery(query: AbstractQuery<*>): NotEqSubQueryOp<T> = NotEqSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().
//                                              display_name notEqSubQuery
//                                              documentation ```kotlin\npublic open infix fun <T> Expression<T>.notEqSubQuery(query: AbstractQuery<*>): NotEqSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is not equals to single value returned from [query].
//                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().(query)
//                                                    display_name query
//                                                    documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#
//                                                                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NotEqSubQueryOp#`<init>`().
//                                                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().(query)
//                                                                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notEqSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().
      /** Checks if this expression is less than the single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().[T]
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().(query)
      infix fun <T> Expression<T>.lessSubQuery(query: AbstractQuery<*>): LessSubQueryOp<T> = LessSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().
//                                             display_name lessSubQuery
//                                             documentation ```kotlin\npublic open infix fun <T> Expression<T>.lessSubQuery(query: AbstractQuery<*>): LessSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is less than the single value returned from [query].
//                                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().(query)
//                                                   display_name query
//                                                   documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#
//                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessSubQueryOp#`<init>`().
//                                                                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().[T]
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().(query)
//                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().
      /** Checks if this expression is less than or equal to the single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().(query)
      infix fun <T> Expression<T>.lessEqSubQuery(query: AbstractQuery<*>): LessEqSubQueryOp<T> = LessEqSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().
//                                               display_name lessEqSubQuery
//                                               documentation ```kotlin\npublic open infix fun <T> Expression<T>.lessEqSubQuery(query: AbstractQuery<*>): LessEqSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is less than or equal to the single value returned from [query].
//                                               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().(query)
//                                                     display_name query
//                                                     documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#
//                                                                                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LessEqSubQueryOp#`<init>`().
//                                                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().(query)
//                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#lessEqSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().
      /** Checks if this expression is greater than the single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().[T]
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().(query)
      infix fun <T> Expression<T>.greaterSubQuery(query: AbstractQuery<*>): GreaterSubQueryOp<T> = GreaterSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().
//                                                display_name greaterSubQuery
//                                                documentation ```kotlin\npublic open infix fun <T> Expression<T>.greaterSubQuery(query: AbstractQuery<*>): GreaterSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is greater than the single value returned from [query].
//                                                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().(query)
//                                                      display_name query
//                                                      documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#
//                                                                                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterSubQueryOp#`<init>`().
//                                                                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().[T]
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().(query)
//                                                                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterSubQuery().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().
      /** Checks if this expression is greater than or equal to the single value returned from [query]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().[T]
//                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().(query)
      infix fun <T> Expression<T>.greaterEqSubQuery(query: AbstractQuery<*>): GreaterEqSubQueryOp<T> = GreaterEqSubQueryOp(this, query)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().
//                                                  display_name greaterEqSubQuery
//                                                  documentation ```kotlin\npublic open infix fun <T> Expression<T>.greaterEqSubQuery(query: AbstractQuery<*>): GreaterEqSubQueryOp<T>\n```\n\n----\n\n Checks if this expression is greater than or equal to the single value returned from [query].
//                                                  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().(query)
//                                                        display_name query
//                                                        documentation ```kotlin\nquery: AbstractQuery<*>\n```
//                                                         ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#
//                                                                                                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GreaterEqSubQueryOp#`<init>`().
//                                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().(query)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().[T]
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().(query)
//                                                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#greaterEqSubQuery().
  
      // Array Comparisons
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().
      /**
       * Checks if this expression is equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithSingleExpression01
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().[T]
//                                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().(list)
      infix fun <T> ExpressionWithColumnType<T>.inList(list: Iterable<T>): InListOrNotInListBaseOp<T> = SingleValueInListOp(this, list, isInList = true)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().
//                                                     display_name inList
//                                                     documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.inList(list: Iterable<T>): InListOrNotInListBaseOp<T>\n```\n\n----\n\n\n Checks if this expression is equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithSingleExpression01\n
//                                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().(list)
//                                                          display_name list
//                                                          documentation ```kotlin\nlist: Iterable<T>\n```
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                                                                                      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().
//                                                                                                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().(list)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().[T]
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().(list)
//                                                                                                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).
      /**
       * Checks if expressions from this `Pair` are equal to elements from [list].
       * This syntax is unsupported by SQL Server.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithPairExpressions01
       **/
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T1]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T2]
//                                                                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).(list)
      infix fun <T1, T2> Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>.inList(list: Iterable<Pair<T1, T2>>): InListOrNotInListBaseOp<Pair<T1, T2>> =
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T1]
//                  display_name FirTypeParameterSymbol T1
//                  documentation ```kotlin\nT1\n```
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T2]
//                      display_name FirTypeParameterSymbol T2
//                      documentation ```kotlin\nT2\n```
//                                                                                        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).
//                                                                                               display_name inList
//                                                                                               documentation ```kotlin\npublic open infix fun <T1, T2> Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>.inList(list: Iterable<Pair<T1, T2>>): InListOrNotInListBaseOp<Pair<T1, T2>>\n```\n\n----\n\n\n Checks if expressions from this `Pair` are equal to elements from [list].\n This syntax is unsupported by SQL Server.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithPairExpressions01\n
//                                                                                               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).(list)
//                                                                                                    display_name list
//                                                                                                    documentation ```kotlin\nlist: Iterable<Pair<T1, T2>>\n```
//                                                                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T1]
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).[T2]
//                                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).(list)
          PairInListOp(this, list, isInList = true)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).(list)
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).
      /**
       * Checks if expressions from this `Triple` are equal to elements from [list].
       * This syntax is unsupported by SQL Server.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithTripleExpressions
       **/
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T1]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T2]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T3]
      infix fun <T1, T2, T3> Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>.inList(
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T1]
//                  display_name FirTypeParameterSymbol T1
//                  documentation ```kotlin\nT1\n```
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T2]
//                      display_name FirTypeParameterSymbol T2
//                      documentation ```kotlin\nT2\n```
//                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T3]
//                          display_name FirTypeParameterSymbol T3
//                          documentation ```kotlin\nT3\n```
//                                                                                                                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).
//                                                                                                                                   display_name inList
//                                                                                                                                   documentation ```kotlin\npublic open infix fun <T1, T2, T3> Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>.inList(list: Iterable<Triple<T1, T2, T3>>): InListOrNotInListBaseOp<Triple<T1, T2, T3>>\n```\n\n----\n\n\n Checks if expressions from this `Triple` are equal to elements from [list].\n This syntax is unsupported by SQL Server.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithTripleExpressions\n
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T1]
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T2]
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).[T3]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).(list)
          list: Iterable<Triple<T1, T2, T3>>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).(list)
//             display_name list
//             documentation ```kotlin\nlist: Iterable<Triple<T1, T2, T3>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).(list)
      ): InListOrNotInListBaseOp<Triple<T1, T2, T3>> =
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
          TripleInListOp(this, list, isInList = true)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).(list)
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).
      /**
       * Checks if all columns in this `List` are equal to any of the lists of values from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithMultipleColumns
       **/
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).(list)
      infix fun List<Column<*>>.inList(list: Iterable<List<*>>): InListOrNotInListBaseOp<List<*>> =
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).
//                                     display_name inList
//                                     documentation ```kotlin\npublic open infix fun List<Column<*>>.inList(list: Iterable<List<*>>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if all columns in this `List` are equal to any of the lists of values from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithMultipleColumns\n
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).(list)
//                                          display_name list
//                                          documentation ```kotlin\nlist: Iterable<List<*>>\n```
//                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).(list)
          MultipleInListOp(this, list, isInList = true)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).(list)
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).
      /**
       * Checks if all columns in this `List` are equal to any of the [CompositeID]s from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities
       **/
      @Suppress("UNCHECKED_CAST")
      @JvmName("inListCompositeIDs")
      @LowPriorityInOverloadResolution
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).(list)
      infix fun List<Column<*>>.inList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>> {
//                              ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).
//                                     display_name inList
//                                     documentation ```kotlin\n@Suppress(...) @JvmName(...) @<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun List<Column<*>>.inList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if all columns in this `List` are equal to any of the [CompositeID]s from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities\n
//                                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).(list)
//                                          display_name list
//                                          documentation ```kotlin\nlist: Iterable<CompositeID>\n```
//                                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).(list)
//        ⌄ enclosing_range_start local 22
//                                       ⌄ enclosing_range_start local 23
          val componentList = list.map { id ->
//            ^^^^^^^^^^^^^ definition local 22
//                          display_name componentList
//                          documentation ```kotlin\nlocal val componentList: List<List<Any>>\n```
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).(list)
//                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                       ^^ definition local 23
//                                          display_name id
//                                          documentation ```kotlin\nid: CompositeID\n```
//                                        ⌃ enclosing_range_end local 23
//                              ⌄ enclosing_range_start local 24
              List(this.size) { i ->
//            ^^^^ reference semanticdb maven . . kotlin/collections/List().
//                      ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                      ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                              ^ definition local 24
//                                display_name i
//                                documentation ```kotlin\ni: Int\n```
//                              ⌃ enclosing_range_end local 24
//                ⌄ enclosing_range_start local 25
                  val component = id[this[i] as Column<Any>]
//                    ^^^^^^^^^ definition local 25
//                              display_name component
//                              documentation ```kotlin\nlocal val component: Any\n```
//                                ^^ reference local 23
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                        ^ reference local 24
//                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                         ⌃ enclosing_range_end local 25
//                                 ⌄ enclosing_range_start local 26
                  component.takeIf { this[i].columnType is EntityIDColumnType<*> } ?: (component as EntityID<*>).value
//                ^^^^^^^^^ reference local 25
//                          ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: Any\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                        ^ reference local 24
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                                     ^^^^^^^^^ reference local 25
//                                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                               ⌃ enclosing_range_end local 26
              }
          }
//        ⌃ enclosing_range_end local 22
          return this inList componentList
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+3).
//                           ^^^^^^^^^^^^^ reference local 22
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).
      /**
       * Checks if this [EntityID] column is equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithEntityIDColumns
       */
      @Suppress("UNCHECKED_CAST")
      @JvmName("inListIds")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[ID]
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).(list)
      infix fun <T : Any, ID : EntityID<T>?> Column<ID>.inList(list: Iterable<T>): InListOrNotInListBaseOp<EntityID<T>?> {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[ID]
//                           display_name FirTypeParameterSymbol ID
//                           documentation ```kotlin\nID : EntityID<T>?\n```
//                                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).
//                                                             display_name inList
//                                                             documentation ```kotlin\n@Suppress(...) @JvmName(...) public open infix fun <T : Any, ID : EntityID<T>?> Column<ID>.inList(list: Iterable<T>): InListOrNotInListBaseOp<EntityID<T>?>\n```\n\n----\n\n\n Checks if this [EntityID] column is equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithEntityIDColumns\n
//                                                             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).(list)
//                                                                  display_name list
//                                                                  documentation ```kotlin\nlist: Iterable<T>\n```
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).[ID]
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).(list)
//        ⌄ enclosing_range_start local 27
          val idTable = (columnType as EntityIDColumnType<T>).idColumn.table as IdTable<T>
//            ^^^^^^^ definition local 27
//                    display_name idTable
//                    documentation ```kotlin\nlocal val idTable: IdTable<T>\n```
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                       ⌃ enclosing_range_end local 27
//                                                  ⌄ enclosing_range_start local 28
          return SingleValueInListOp(this, list.map { EntityIDFunctionProvider.createEntityID(it, idTable) }, isInList = true)
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).(list)
//                                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 28
//                                                                                                           display_name it
//                                                                                                           documentation ```kotlin\nit: T\n```
//                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
//                                                                                            ^^ reference local 28
//                                                                                                ^^^^^^^ reference local 27
//                                                                                                         ⌃ enclosing_range_end local 28
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+5).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).
      /**
       * Checks if this [EntityID] column is equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities
       */
      @Suppress("UNCHECKED_CAST")
      @JvmName("inListCompositeEntityIds")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).[ID]
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).(list)
      infix fun <ID : EntityID<CompositeID>> Column<ID>.inList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>> {
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).[ID]
//                  display_name FirTypeParameterSymbol ID
//                  documentation ```kotlin\nID : EntityID<CompositeID>\n```
//                                                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).
//                                                             display_name inList
//                                                             documentation ```kotlin\n@Suppress(...) @JvmName(...) public open infix fun <ID : EntityID<CompositeID>> Column<ID>.inList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if this [EntityID] column is equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities\n
//                                                             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).(list)
//                                                                  display_name list
//                                                                  documentation ```kotlin\nlist: Iterable<CompositeID>\n```
//                                                                   ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).[ID]
//                                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).(list)
//        ⌄ enclosing_range_start local 29
          val idTable = (columnType as EntityIDColumnType<CompositeID>).idColumn.table as CompositeIdTable
//            ^^^^^^^ definition local 29
//                    display_name idTable
//                    documentation ```kotlin\nlocal val idTable: CompositeIdTable\n```
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                                                                                                       ⌃ enclosing_range_end local 29
          return idTable.idColumns.toList() inList list
//               ^^^^^^^ reference local 29
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
//                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+4).
//                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).(list)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inList(+6).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().
      /**
       * Checks if this expression is not equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithSingleExpression01
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().[T]
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().(list)
      infix fun <T> ExpressionWithColumnType<T>.notInList(list: Iterable<T>): InListOrNotInListBaseOp<T> =
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().
//                                                        display_name notInList
//                                                        documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.notInList(list: Iterable<T>): InListOrNotInListBaseOp<T>\n```\n\n----\n\n\n Checks if this expression is not equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithSingleExpression01\n
//                                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().(list)
//                                                             display_name list
//                                                             documentation ```kotlin\nlist: Iterable<T>\n```
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().[T]
//                                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().(list)
          SingleValueInListOp(this, list, isInList = false)
//        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().(list)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).
      /**
       * Checks if expressions from this `Pair` are not equal to elements from [list].
       * This syntax is unsupported by SQL Server.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testNotInListWithPairExpressionsAndEmptyList
       **/
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T1]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T2]
      infix fun <T1, T2> Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>.notInList(
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T1]
//                  display_name FirTypeParameterSymbol T1
//                  documentation ```kotlin\nT1\n```
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T2]
//                      display_name FirTypeParameterSymbol T2
//                      documentation ```kotlin\nT2\n```
//                                                                                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).
//                                                                                                  display_name notInList
//                                                                                                  documentation ```kotlin\npublic open infix fun <T1, T2> Pair<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>>.notInList(list: Iterable<Pair<T1, T2>>): InListOrNotInListBaseOp<Pair<T1, T2>>\n```\n\n----\n\n\n Checks if expressions from this `Pair` are not equal to elements from [list].\n This syntax is unsupported by SQL Server.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testNotInListWithPairExpressionsAndEmptyList\n
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T1]
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).[T2]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).(list)
          list: Iterable<Pair<T1, T2>>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).(list)
//             display_name list
//             documentation ```kotlin\nlist: Iterable<Pair<T1, T2>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).(list)
      ): InListOrNotInListBaseOp<Pair<T1, T2>> =
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
          PairInListOp(this, list, isInList = false)
//        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/PairInListOp#`<init>`().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).(list)
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).
      /**
       * Checks if expressions from this `Triple` are not equal to elements from [list].
       * This syntax is unsupported by SQL Server.
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithTripleExpressions
       **/
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T1]
//                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T2]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T3]
      infix fun <T1, T2, T3> Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>.notInList(
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T1]
//                  display_name FirTypeParameterSymbol T1
//                  documentation ```kotlin\nT1\n```
//                   ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T2]
//                      display_name FirTypeParameterSymbol T2
//                      documentation ```kotlin\nT2\n```
//                       ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T3]
//                          display_name FirTypeParameterSymbol T3
//                          documentation ```kotlin\nT3\n```
//                                                                                                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).
//                                                                                                                                      display_name notInList
//                                                                                                                                      documentation ```kotlin\npublic open infix fun <T1, T2, T3> Triple<ExpressionWithColumnType<T1>, ExpressionWithColumnType<T2>, ExpressionWithColumnType<T3>>.notInList(list: Iterable<Triple<T1, T2, T3>>): InListOrNotInListBaseOp<Triple<T1, T2, T3>>\n```\n\n----\n\n\n Checks if expressions from this `Triple` are not equal to elements from [list].\n This syntax is unsupported by SQL Server.\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithTripleExpressions\n
//                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T1]
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T2]
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).[T3]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).(list)
          list: Iterable<Triple<T1, T2, T3>>
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).(list)
//             display_name list
//             documentation ```kotlin\nlist: Iterable<Triple<T1, T2, T3>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).(list)
      ): InListOrNotInListBaseOp<Triple<T1, T2, T3>> =
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
          TripleInListOp(this, list, isInList = false)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/TripleInListOp#`<init>`().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).(list)
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).
      /**
       * Checks if all columns in this `List` are not equal to any of the lists of values from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithMultipleColumns
       **/
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).(list)
      infix fun List<Column<*>>.notInList(list: Iterable<List<*>>): InListOrNotInListBaseOp<List<*>> =
//                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).
//                                        display_name notInList
//                                        documentation ```kotlin\npublic open infix fun List<Column<*>>.notInList(list: Iterable<List<*>>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if all columns in this `List` are not equal to any of the lists of values from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithMultipleColumns\n
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).(list)
//                                             display_name list
//                                             documentation ```kotlin\nlist: Iterable<List<*>>\n```
//                                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).(list)
          MultipleInListOp(this, list, isInList = false)
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/MultipleInListOp#`<init>`().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).(list)
//                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).
      /**
       * Checks if all columns in this `List` are not equal to any of the [CompositeID]s from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities
       **/
      @Suppress("UNCHECKED_CAST")
      @JvmName("notInListCompositeIDs")
      @LowPriorityInOverloadResolution
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).(list)
      infix fun List<Column<*>>.notInList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>> {
//                              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).
//                                        display_name notInList
//                                        documentation ```kotlin\n@Suppress(...) @JvmName(...) @<ERROR TYPE REF: HIDDEN: kotlin/internal/LowPriorityInOverloadResolution is invisible>() public open infix fun List<Column<*>>.notInList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if all columns in this `List` are not equal to any of the [CompositeID]s from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities\n
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).(list)
//                                             display_name list
//                                             documentation ```kotlin\nlist: Iterable<CompositeID>\n```
//                                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).(list)
//        ⌄ enclosing_range_start local 30
//                                       ⌄ enclosing_range_start local 31
          val componentList = list.map { id ->
//            ^^^^^^^^^^^^^ definition local 30
//                          display_name componentList
//                          documentation ```kotlin\nlocal val componentList: List<List<Any>>\n```
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).(list)
//                                 ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                       ^^ definition local 31
//                                          display_name id
//                                          documentation ```kotlin\nid: CompositeID\n```
//                                        ⌃ enclosing_range_end local 31
//                              ⌄ enclosing_range_start local 32
              List(this.size) { i ->
//            ^^^^ reference semanticdb maven . . kotlin/collections/List().
//                      ^^^^ reference semanticdb maven . . kotlin/collections/List#getSize().
//                      ^^^^ reference semanticdb maven . . kotlin/collections/List#size.
//                              ^ definition local 32
//                                display_name i
//                                documentation ```kotlin\ni: Int\n```
//                              ⌃ enclosing_range_end local 32
//                ⌄ enclosing_range_start local 33
                  val component = id[this[i] as Column<Any>]
//                    ^^^^^^^^^ definition local 33
//                              display_name component
//                              documentation ```kotlin\nlocal val component: Any\n```
//                                ^^ reference local 31
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeID#get().
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                        ^ reference local 32
//                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                         ⌃ enclosing_range_end local 33
//                                 ⌄ enclosing_range_start local 34
                  component.takeIf { this[i].columnType is EntityIDColumnType<*> } ?: (component as EntityID<*>).value
//                ^^^^^^^^^ reference local 33
//                          ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 34
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: Any\n```
//                                   ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#get().
//                                        ^ reference local 32
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                                     ^^^^^^^^^ reference local 33
//                                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#
//                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#getValue().
//                                                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityID#value.
//                                                                               ⌃ enclosing_range_end local 34
              }
          }
//        ⌃ enclosing_range_end local 30
          return this notInList componentList
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+3).
//                              ^^^^^^^^^^^^^ reference local 30
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).
      /**
       * Checks if this [EntityID] column is not equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithEntityIDColumns
       */
      @Suppress("UNCHECKED_CAST")
      @JvmName("notInListIds")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[ID]
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).(list)
      infix fun <T : Any, ID : EntityID<T>?> Column<ID>.notInList(list: Iterable<T>): InListOrNotInListBaseOp<EntityID<T>?> {
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT : Any\n```
//                        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[ID]
//                           display_name FirTypeParameterSymbol ID
//                           documentation ```kotlin\nID : EntityID<T>?\n```
//                                                      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).
//                                                                display_name notInList
//                                                                documentation ```kotlin\n@Suppress(...) @JvmName(...) public open infix fun <T : Any, ID : EntityID<T>?> Column<ID>.notInList(list: Iterable<T>): InListOrNotInListBaseOp<EntityID<T>?>\n```\n\n----\n\n\n Checks if this [EntityID] column is not equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.dml.SelectTests.testInListWithEntityIDColumns\n
//                                                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).(list)
//                                                                     display_name list
//                                                                     documentation ```kotlin\nlist: Iterable<T>\n```
//                                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).[ID]
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).(list)
//        ⌄ enclosing_range_start local 35
          val idTable = (columnType as EntityIDColumnType<T>).idColumn.table as IdTable<T>
//            ^^^^^^^ definition local 35
//                    display_name idTable
//                    documentation ```kotlin\nlocal val idTable: IdTable<T>\n```
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                     ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                                                                                       ⌃ enclosing_range_end local 35
//                                                  ⌄ enclosing_range_start local 36
          return SingleValueInListOp(this, list.map { EntityIDFunctionProvider.createEntityID(it, idTable) }, isInList = false)
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/SingleValueInListOp#`<init>`().
//                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).(list)
//                                              ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 36
//                                                                                                           display_name it
//                                                                                                           documentation ```kotlin\nit: T\n```
//                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/EntityIDFunctionProvider#createEntityID().
//                                                                                            ^^ reference local 36
//                                                                                                ^^^^^^^ reference local 35
//                                                                                                         ⌃ enclosing_range_end local 36
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+5).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).
      /**
       * Checks if this [EntityID] column is not equal to any element from [list].
       *
       * @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities
       */
      @Suppress("UNCHECKED_CAST")
      @JvmName("notInListCompositeEntityIds")
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).[ID]
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).(list)
      infix fun <ID : EntityID<CompositeID>> Column<ID>.notInList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>> {
//               ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).[ID]
//                  display_name FirTypeParameterSymbol ID
//                  documentation ```kotlin\nID : EntityID<CompositeID>\n```
//                                                      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).
//                                                                display_name notInList
//                                                                documentation ```kotlin\n@Suppress(...) @JvmName(...) public open infix fun <ID : EntityID<CompositeID>> Column<ID>.notInList(list: Iterable<CompositeID>): InListOrNotInListBaseOp<List<*>>\n```\n\n----\n\n\n Checks if this [EntityID] column is not equal to any element from [list].\n\n @sample org.jetbrains.exposed.v1.tests.shared.entities.CompositeIdTableEntityTest.testInListWithCompositeIdEntities\n
//                                                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).(list)
//                                                                     display_name list
//                                                                     documentation ```kotlin\nlist: Iterable<CompositeID>\n```
//                                                                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//                                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InListOrNotInListBaseOp#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).[ID]
//                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).(list)
//        ⌄ enclosing_range_start local 37
          val idTable = (columnType as EntityIDColumnType<CompositeID>).idColumn.table as CompositeIdTable
//            ^^^^^^^ definition local 37
//                    display_name idTable
//                    documentation ```kotlin\nlocal val idTable: CompositeIdTable\n```
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#
//                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#getIdColumn().
//                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/EntityIDColumnType#idColumn.
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#
//                                                                                                       ⌃ enclosing_range_end local 37
          return idTable.idColumns.toList() notInList list
//               ^^^^^^^ reference local 37
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#getIdColumns().
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/CompositeIdTable#idColumns.
//                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/toList(+10).
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+4).
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).(list)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInList(+6).
  
      // "IN (TABLE ...)" comparisons
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().
      /**
       * Checks if this expression is equal to any element from the column of [table] with only a single column.
       *
       * **Note** This function is only supported by MySQL, PostgreSQL, and H2 dialects.
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().[T]
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().(table)
      infix fun <T> ExpressionWithColumnType<T>.inTable(table: Table): InTableOp = InTableOp(this, table, true)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().
//                                                      display_name inTable
//                                                      documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.inTable(table: Table): InTableOp\n```\n\n----\n\n\n Checks if this expression is equal to any element from the column of [table] with only a single column.\n\n **Note** This function is only supported by MySQL, PostgreSQL, and H2 dialects.\n
//                                                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().(table)
//                                                            display_name table
//                                                            documentation ```kotlin\ntable: Table\n```
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#
//                                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().
//                                                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().(table)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().[T]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().(table)
//                                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#inTable().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().
      /**
       * Checks if this expression is **not** equal to any element from the column of [table] with only a single column.
       *
       * **Note** This function is only supported by MySQL, PostgreSQL, and H2 dialects.
       */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().[T]
//                                                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().(table)
      infix fun <T> ExpressionWithColumnType<T>.notInTable(table: Table): InTableOp = InTableOp(this, table, false)
//               ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().[T]
//                 display_name FirTypeParameterSymbol T
//                 documentation ```kotlin\nT\n```
//                                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().
//                                                         display_name notInTable
//                                                         documentation ```kotlin\npublic open infix fun <T> ExpressionWithColumnType<T>.notInTable(table: Table): InTableOp\n```\n\n----\n\n\n Checks if this expression is **not** equal to any element from the column of [table] with only a single column.\n\n **Note** This function is only supported by MySQL, PostgreSQL, and H2 dialects.\n
//                                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().(table)
//                                                               display_name table
//                                                               documentation ```kotlin\ntable: Table\n```
//                                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#
//                                                                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ops/InTableOp#`<init>`().
//                                                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().(table)
//               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().[T]
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().(table)
//                                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#notInTable().
  
      // Misc.
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
      /** Returns the specified [value] as a query parameter of type [T]. */
      @Suppress("UNCHECKED_CAST")
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[S]
//                                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().(value)
      fun <T, S : T?> ExpressionWithColumnType<in S>.wrap(value: T): QueryParameter<T> =
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[S]
//              display_name FirTypeParameterSymbol S
//              documentation ```kotlin\nS : T?\n```
//                                                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
//                                                        display_name wrap
//                                                        documentation ```kotlin\n@Suppress(...) public open fun <T, S : T?> ExpressionWithColumnType<in S>.wrap(value: T): QueryParameter<T>\n```\n\n----\n\n Returns the specified [value] as a query parameter of type [T].
//                                                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().(value)
//                                                              display_name value
//                                                              documentation ```kotlin\nvalue: T\n```
//                                                                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[T]
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().[S]
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().(value)
          QueryParameter(value, columnType as IColumnType<T & Any>)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#`<init>`().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().(value)
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#wrap().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
      /** Returns the specified [value] as a literal of type [T]. */
      @Suppress("UNCHECKED_CAST", "ComplexMethod")
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[T]
//            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[S]
//                                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
      fun <T, S : T?> ExpressionWithColumnType<S>.asLiteral(value: T): LiteralOp<T> = when {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[S]
//              display_name FirTypeParameterSymbol S
//              documentation ```kotlin\nS : T?\n```
//                                                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
//                                                          display_name asLiteral
//                                                          documentation ```kotlin\n@Suppress(...) public open fun <T, S : T?> ExpressionWithColumnType<S>.asLiteral(value: T): LiteralOp<T>\n```\n\n----\n\n Returns the specified [value] as a literal of type [T].
//                                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
//                                                                display_name value
//                                                                documentation ```kotlin\nvalue: T\n```
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[T]
//                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().[S]
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
          value is ByteArray && columnType is BasicBinaryColumnType -> stringLiteral(value.toString(Charsets.UTF_8))
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
//                 ^^^^^^^^^ reference semanticdb maven . . kotlin/ByteArray#
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/BasicBinaryColumnType#
//                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/stringLiteral().
//                                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
//                                                                                         ^^^^^^^^ reference semanticdb maven . . kotlin/collections/toString().
//                                                                                                           ^^^^^ reference semanticdb maven . . kotlin/text/Charsets#UTF_8.
//                                                                                                           ^^^^^ reference semanticdb maven . . kotlin/text/Charsets#getUTF_8().
          columnType is ColumnWithTransform<*, *> -> (columnType as ColumnWithTransform<Any, Any>)
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#
//                 ⌄ enclosing_range_start local 38
              .let { LiteralOp(it.originalColumnType, it.unwrapRecursive(value)) }
//             ^^^ reference semanticdb maven . . kotlin/let().
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 38
//                                                                                 display_name it
//                                                                                 documentation ```kotlin\nit: ColumnWithTransform<Any, Any>\n```
//                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                             ^^ reference local 38
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#getOriginalColumnType().
//                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#originalColumnType.
//                                                    ^^ reference local 38
//                                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnWithTransform#unwrapRecursive().
//                                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
//                                                                               ⌃ enclosing_range_end local 38
          else -> LiteralOp(columnType as IColumnType<T & Any>, value)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#`<init>`().
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().(value)
      } as LiteralOp<T>
//         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#asLiteral().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#intToDecimal().
      fun ExpressionWithColumnType<Int>.intToDecimal(): NoOpConversion<Int, BigDecimal> =
//                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#intToDecimal().
//                                                   display_name intToDecimal
//                                                   documentation ```kotlin\npublic open fun ExpressionWithColumnType<Int>.intToDecimal(): NoOpConversion<Int, BigDecimal>\n```
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#
          NoOpConversion(this, DecimalColumnType(precision = 15, scale = 0))
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#`<init>`().
//                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DecimalColumnType#`<init>`().
//                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#intToDecimal().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[T]
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[E]
      private fun <T : Any, E : EntityID<T>> Column<out E?>.idTable(): IdTable<T> =
//                 ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[T]
//                   display_name FirTypeParameterSymbol T
//                   documentation ```kotlin\nT : Any\n```
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[E]
//                            display_name FirTypeParameterSymbol E
//                            documentation ```kotlin\nE : EntityID<T>\n```
//                                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
//                                                                  display_name idTable
//                                                                  documentation ```kotlin\nprivate final fun <T : Any, E : EntityID<T>> Column<out E?>.idTable(): IdTable<T>\n```
//                                                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().[E]
//              ⌄ enclosing_range_start local 39
          when (val table = this.foreignKey?.targetTable ?: this.table) {
//                  ^^^^^ definition local 39
//                        display_name table
//                        documentation ```kotlin\nlocal val table: Table\n```
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#foreignKey.
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getForeignKey().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setForeignKey().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                   ⌃ enclosing_range_end local 39
              is Alias<*> -> table.delegate
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#
//                           ^^^^^ reference local 39
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#delegate.
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getDelegate().
              else -> table
//                    ^^^^^ reference local 39
          } as IdTable<T>
//             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/dao/id/IdTable#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#idTable().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#`<init>`().
  /**
   * Builder object for creating SQL expressions.
   */
  // TODO: Pick a single way to write "SQL" and use it across the board for 1.0
  // TODO check Kotlin style guide
  // TODO Decide what to do when it comes at the end : "PostgreSQLDialect" vs "PostgresqlDialect" or "PostgreSqlDialect"
  // TODO: make a function same as IStatementBuilder
  @Suppress("ForbiddenComment", "AnnotationSpacing")
  object SqlExpressionBuilder : ISqlExpressionBuilder
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                            display_name SqlExpressionBuilder
//                            documentation ```kotlin\n@Suppress(...) public final object SqlExpressionBuilder : ISqlExpressionBuilder\n```\n\n----\n\n\n Builder object for creating SQL expressions.\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#
//       ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#`<init>`().
//                            display_name SqlExpressionBuilder
//                            documentation ```kotlin\nprivate constructor(): SqlExpressionBuilder\n```\n\n----\n\n\n Builder object for creating SQL expressions.\n
//                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#
//                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/SqlExpressionBuilder#`<init>`().
