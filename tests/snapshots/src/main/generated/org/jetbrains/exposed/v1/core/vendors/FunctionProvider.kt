  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
  import org.jetbrains.exposed.v1.core.*
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  import org.jetbrains.exposed.v1.core.statements.MergeStatement
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
  import org.jetbrains.exposed.v1.core.statements.StatementType
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
  import org.jetbrains.exposed.v1.exceptions.UnsupportedByDialectException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#
  import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#`<init>`().
  /**
   * Provides definitions for all the supported SQL functions.
   * By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific function, or it
   * is implemented differently, the corresponding function should be overridden.
   */
  @Suppress("UnnecessaryAbstractClass", "TooManyFunctions")
  abstract class FunctionProvider {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//                                display_name FunctionProvider
//                                documentation ```kotlin\n@Suppress(...) public abstract class FunctionProvider : Any\n```\n\n----\n\n\n Provides definitions for all the supported SQL functions.\n By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific function, or it\n is implemented differently, the corresponding function should be overridden.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#`<init>`().
//                                display_name FunctionProvider
//                                documentation ```kotlin\npublic constructor(): FunctionProvider\n```\n\n----\n\n\n Provides definitions for all the supported SQL functions.\n By default, definitions from the SQL standard are provided but if a vendor doesn't support a specific function, or it\n is implemented differently, the corresponding function should be overridden.\n
      // Mathematical functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
      /**
       * SQL function that returns the next value of the specified sequence.
       *
       * @param seq Sequence that produces the value.
       * @param builder Query builder to append the SQL function to.
       */
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(seq)
//                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(builder)
      open fun nextVal(seq: Sequence, builder: QueryBuilder): Unit = builder {
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                     display_name nextVal
//                     documentation ```kotlin\npublic open fun nextVal(seq: Sequence, builder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the next value of the specified sequence.\n\n @param seq Sequence that produces the value.\n @param builder Query builder to append the SQL function to.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#nextVal().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#nextVal().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#nextVal().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().
//                     ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(seq)
//                         display_name seq
//                         documentation ```kotlin\nseq: Sequence\n```
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(builder)
//                                            display_name builder
//                                            documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(builder)
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(seq)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(builder)
          append(seq.identifier, ".NEXTVAL")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().(seq)
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
      /**
       * SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).
       *
       * **Note:** Some vendors generate values outside this range, or ignore the given seed, check the documentation.
       *
       * @param seed Optional seed.
       */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().(seed)
      open fun random(seed: Int?): String = "RANDOM(${seed?.toString().orEmpty()})"
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
//                    display_name random
//                    documentation ```kotlin\npublic open fun random(seed: Int?): String\n```\n\n----\n\n\n SQL function that generates a random value uniformly distributed between 0 (inclusive) and 1 (exclusive).\n\n **Note:** Some vendors generate values outside this range, or ignore the given seed, check the documentation.\n\n @param seed Optional seed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#random().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#random().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#random().
//                    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().(seed)
//                         display_name seed
//                         documentation ```kotlin\nseed: Int?\n```
//                          ^^^^ reference semanticdb maven . . kotlin/Int#
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().(seed)
//                                                          ^^^^^^^^ reference semanticdb maven . . kotlin/Int#toString().
//                                                                     ^^^^^^^ reference semanticdb maven . . kotlin/text/orEmpty().
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().(seed)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
  
      // String functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
      /**
       * SQL function that returns the length of [expr], measured in characters, or `null` if [expr] is null.
       *
       * @param expr String expression to count characters in.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().[T]
//                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(expr)
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(queryBuilder)
      open fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
//                                      display_name charLength
//                                      documentation ```kotlin\npublic open fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the length of [expr], measured in characters, or `null` if [expr] is null.\n\n @param expr String expression to count characters in.\n @param queryBuilder Query builder to append the SQL function to.\n
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#charLength().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().
//                                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#charLength().
//                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(expr)
//                                           display_name expr
//                                           documentation ```kotlin\nexpr: Expression<T>\n```
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(queryBuilder)
//                                                                        display_name queryBuilder
//                                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                        ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(queryBuilder)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().[T]
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(expr)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(queryBuilder)
          append("CHAR_LENGTH(", expr, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().(expr)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
      /**
       * SQL function that extracts a substring from the specified string expression.
       *
       * @param expr The expression to extract the substring from.
       * @param start The start of the substring.
       * @param length The length of the substring.
       * @param builder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().[T]
      open fun <T : String?> substring(
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
//                                     display_name substring
//                                     documentation ```kotlin\npublic open fun <T : String?> substring(expr: Expression<T>, start: Expression<Int>, length: Expression<Int>, builder: QueryBuilder, prefix: String = ...): Unit\n```\n\n----\n\n\n SQL function that extracts a substring from the specified string expression.\n\n @param expr The expression to extract the substring from.\n @param start The start of the substring.\n @param length The length of the substring.\n @param builder Query builder to append the SQL function to.\n
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#substring().
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#substring().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(expr)
          expr: Expression<T>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<T>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(start)
          start: Expression<Int>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(start)
//              display_name start
//              documentation ```kotlin\nstart: Expression<Int>\n```
//               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(start)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(length)
          length: Expression<Int>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(length)
//               display_name length
//               documentation ```kotlin\nlength: Expression<Int>\n```
//                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(length)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(builder)
          builder: QueryBuilder,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(builder)
//                display_name builder
//                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(builder)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(prefix)
          prefix: String = "SUBSTRING"
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: String = ...\n```
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(prefix)
      ): Unit = builder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(builder)
          append(prefix, "(", expr, ", ", start, ", ", length, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(prefix)
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(expr)
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(start)
//                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().(length)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#substring().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
      /**
       * SQL function that concatenates multiple string expressions together with a given separator.
       *
       * @param separator Separator to use.
       * @param queryBuilder Query builder to append the SQL function to.
       * @param expr String expressions to concatenate.
       */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(separator)
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(queryBuilder)
//                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(expr)
      open fun concat(separator: String, queryBuilder: QueryBuilder, vararg expr: Expression<*>): Unit = queryBuilder {
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
//                    display_name concat
//                    documentation ```kotlin\npublic open fun concat(separator: String, queryBuilder: QueryBuilder, vararg expr: Expression<*>): Unit\n```\n\n----\n\n\n SQL function that concatenates multiple string expressions together with a given separator.\n\n @param separator Separator to use.\n @param queryBuilder Query builder to append the SQL function to.\n @param expr String expressions to concatenate.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#concat().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#concat().
//                    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(separator)
//                              display_name separator
//                              documentation ```kotlin\nseparator: String\n```
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(queryBuilder)
//                                                    display_name queryBuilder
//                                                    documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(expr)
//                                                                               display_name expr
//                                                                               documentation ```kotlin\nvararg expr: Expression<*>\n```
//                                                                                ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                                                ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(queryBuilder)
//                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(separator)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(queryBuilder)
//                                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(expr)
          if (separator == "") {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(separator)
              append("CONCAT(")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          } else {
              append("CONCAT_WS('", separator, "',")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(separator)
          }
//                      ⌄ enclosing_range_start local 0
          expr.appendTo { +it }
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().(expr)
//             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                      ^^^^^^^ definition local 0
//                              display_name it
//                              documentation ```kotlin\nit: CapturedType(out Expression<*>)\n```
//                        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                         ^^ reference local 0
//                            ⌃ enclosing_range_end local 0
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#concat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
      /**
       * SQL function that concatenates strings from a group into a single string.
       *
       * @param expr Group concat options.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().[T]
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(queryBuilder)
      open fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                           ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                                       display_name groupConcat
//                                       documentation ```kotlin\npublic open fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that concatenates strings from a group into a single string.\n\n @param expr Group concat options.\n @param queryBuilder Query builder to append the SQL function to.\n
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#groupConcat().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#groupConcat().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().
//                                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#groupConcat().
//                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                                            display_name expr
//                                            documentation ```kotlin\nexpr: GroupConcat<T>\n```
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(queryBuilder)
//                                                                          display_name queryBuilder
//                                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                          ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(queryBuilder)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().[T]
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(queryBuilder)
          append("GROUP_CONCAT(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          if (expr.distinct) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
              append("DISTINCT ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
          append(expr.expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
          if (expr.orderBy.isNotEmpty()) {
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty().
              append(" ORDER BY ")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                    ⌄ enclosing_range_start local 1
//                                     ⌄ enclosing_range_start local 2
//                                                 ⌄ enclosing_range_start local 3
              expr.orderBy.appendTo { (expression, sortOrder) ->
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                    ^^^^^^^^^^^^^^^^^^^^^^^ definition local 1
//                                                            display_name <destruct>
//                                                            documentation ```kotlin\n<destruct>: CapturedType(out Pair<Expression<*>, SortOrder>)\n```
//                                     ^^^^^^^^^^ reference local 1
//                                     ^^^^^^^^^^ definition local 2
//                                                display_name expression
//                                                documentation ```kotlin\nlocal val expression: Expression<*>\n```
//                                     ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                 ^^^^^^^^^ reference local 1
//                                                 ^^^^^^^^^ definition local 3
//                                                           display_name sortOrder
//                                                           documentation ```kotlin\nlocal val sortOrder: SortOrder\n```
//                                                 ^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                              ⌃ enclosing_range_end local 2
//                                                         ⌃ enclosing_range_end local 3
//                                                          ⌃ enclosing_range_end local 1
                  currentDialect.dataTypeProvider.precessOrderByClause(this, expression, sortOrder)
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
//                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                           ^^^^^^^^^^ reference local 2
//                                                                                       ^^^^^^^^^ reference local 3
              }
          }
//                            ⌄ enclosing_range_start local 4
          expr.separator?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().(expr)
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                        ^^^ reference semanticdb maven . . kotlin/let().
//                            ^ definition local 4 2:9
//                              display_name it
//                              documentation ```kotlin\nit: String\n```
              append(" SEPARATOR '$it'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                 ^^ reference local 4
          }
//        ⌃ enclosing_range_end local 4
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
      /**
       * SQL function that returns the index of the first occurrence of the given substring [substring]
       * in the string expression [expr]
       *
       * @param queryBuilder Query builder to append the SQL function to.
       * @param expr String expression to find the substring in.
       * @param substring: Substring to find
       * @return index of the first occurrence of [substring] in [expr] starting from 1
       * or 0 if [expr] doesn't contain [substring]
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().[T]
//                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(queryBuilder)
//                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(expr)
//                                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(substring)
      open fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String) {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
//                                  display_name locate
//                                  documentation ```kotlin\npublic open fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```\n\n----\n\n\n SQL function that returns the index of the first occurrence of the given substring [substring]\n in the string expression [expr]\n\n @param queryBuilder Query builder to append the SQL function to.\n @param expr String expression to find the substring in.\n @param substring: Substring to find\n @return index of the first occurrence of [substring] in [expr] starting from 1\n or 0 if [expr] doesn't contain [substring]\n
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#locate().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#locate().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#locate().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#locate().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#locate().
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(queryBuilder)
//                                               display_name queryBuilder
//                                               documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(expr)
//                                                                   display_name expr
//                                                                   documentation ```kotlin\nexpr: Expression<T>\n```
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(substring)
//                                                                                             display_name substring
//                                                                                             documentation ```kotlin\nsubstring: String\n```
//                                                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().[T]
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(queryBuilder)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(expr)
//                                                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().(substring)
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for LOCATE. There must be vendor specific implementation.", currentDialect
//                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
  
      // Pattern matching
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
      /**
       * Marker interface for the possible pattern matching modes.
       */
      interface MatchMode {
//              ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                        display_name MatchMode
//                        documentation ```kotlin\npublic abstract interface MatchMode : Any\n```\n\n----\n\n\n Marker interface for the possible pattern matching modes.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#mode().
          /** SQL representation of the mode. */
          fun mode(): String
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#mode().
//                 display_name mode
//                 documentation ```kotlin\npublic abstract fun mode(): String\n\n```\n\n----\n\n SQL representation of the mode.
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#MysqlMatchMode#mode().
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#mode().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().
      /**
       * SQL function that checks whether the given string expression matches the given pattern.
       *
       * **Note:** The `mode` parameter is not supported by all vendors, please check the documentation.
       *
       * @receiver Expression to check.
       * @param pattern Pattern the expression is checked against.
       * @param mode Match mode used to check the expression.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().[T]
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(pattern)
//                                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(mode)
      open fun <T : String?> Expression<T>.match(pattern: String, mode: MatchMode? = null): Op<Boolean> = with(
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                                         ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().
//                                               display_name match
//                                               documentation ```kotlin\npublic open fun <T : String?> Expression<T>.match(pattern: String, mode: FunctionProvider.MatchMode? = ...): Op<Boolean>\n```\n\n----\n\n\n SQL function that checks whether the given string expression matches the given pattern.\n\n **Note:** The `mode` parameter is not supported by all vendors, please check the documentation.\n\n @receiver Expression to check.\n @param pattern Pattern the expression is checked against.\n @param mode Match mode used to check the expression.\n
//                                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#match().
//                                               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(pattern)
//                                                       display_name pattern
//                                                       documentation ```kotlin\npattern: String\n```
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(mode)
//                                                                     display_name mode
//                                                                     documentation ```kotlin\nmode: FunctionProvider.MatchMode? = ...\n```
//                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#MatchMode#
//                                                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                                        ^^^^ reference semanticdb maven . . kotlin/with().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().[T]
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(pattern)
//                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(mode)
          SqlExpressionBuilder
      ) {
          this@match.like(pattern)
//                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#like().
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().(pattern)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#match().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
      /**
       * SQL function that performs a pattern match of a given string expression against a given pattern.
       *
       * @param expr1 String expression to test.
       * @param pattern Pattern to match against.
       * @param caseSensitive Whether the matching is case-sensitive or not.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().[T]
      open fun <T : String?> regexp(
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT : String?\n```
//                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
//                                  display_name regexp
//                                  documentation ```kotlin\npublic open fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that performs a pattern match of a given string expression against a given pattern.\n\n @param expr1 String expression to test.\n @param pattern Pattern to match against.\n @param caseSensitive Whether the matching is case-sensitive or not.\n @param queryBuilder Query builder to append the SQL function to.\n
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#regexp().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#regexp().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#regexp().
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(expr1)
          expr1: Expression<T>,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(expr1)
//              display_name expr1
//              documentation ```kotlin\nexpr1: Expression<T>\n```
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(expr1)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(pattern)
          pattern: Expression<String>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(pattern)
//                display_name pattern
//                documentation ```kotlin\npattern: Expression<String>\n```
//                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(pattern)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(caseSensitive)
          caseSensitive: Boolean,
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(caseSensitive)
//                      display_name caseSensitive
//                      documentation ```kotlin\ncaseSensitive: Boolean\n```
//                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(caseSensitive)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(queryBuilder)
      ): Unit = queryBuilder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(queryBuilder)
          append("REGEXP_LIKE(", expr1, ", ", pattern, ", ")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(expr1)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(pattern)
          if (caseSensitive) {
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().(caseSensitive)
              append("'c'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          } else {
              append("'i'")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          }
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
  
      // Date/Time functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
      /**
       * SQL function that extracts the date field from a given temporal expression.
       *
       * @param expr Expression to extract the year from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(expr)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(queryBuilder)
      open fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
//                      display_name date
//                      documentation ```kotlin\npublic open fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the date field from a given temporal expression.\n\n @param expr Expression to extract the year from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#date().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#date().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#date().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<T>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(queryBuilder)
//                                                        display_name queryBuilder
//                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                        ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(expr)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(queryBuilder)
          append("DATE(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
      /**
       * SQL function that extracts the time field from a given temporal expression.
       *
       * @param expr Expression to extract the year from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(expr)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(queryBuilder)
      open fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                      display_name time
//                      documentation ```kotlin\npublic open fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the time field from a given temporal expression.\n\n @param expr Expression to extract the year from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#time().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#time().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#time().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#time().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#time().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<T>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(queryBuilder)
//                                                        display_name queryBuilder
//                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(expr)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().(queryBuilder)
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for TIME. There must be a vendor-specific implementation.", currentDialect
//                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
      /**
       * SQL function that extracts the year field from a given date.
       *
       * @param expr Expression to extract the year from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(expr)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(queryBuilder)
      open fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
//                      display_name year
//                      documentation ```kotlin\npublic open fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the year field from a given date.\n\n @param expr Expression to extract the year from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#year().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#year().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#year().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<T>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(queryBuilder)
//                                                        display_name queryBuilder
//                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                        ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(expr)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(queryBuilder)
          append("YEAR(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
      /**
       * SQL function that extracts the month field from a given date.
       * The returned value is a number between 1 and 12 both inclusive.
       *
       * @param expr Expression to extract the month from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().[T]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(expr)
//                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(queryBuilder)
      open fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
//                       display_name month
//                       documentation ```kotlin\npublic open fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the month field from a given date.\n The returned value is a number between 1 and 12 both inclusive.\n\n @param expr Expression to extract the month from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#month().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#month().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#month().
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(expr)
//                            display_name expr
//                            documentation ```kotlin\nexpr: Expression<T>\n```
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(queryBuilder)
//                                                         display_name queryBuilder
//                                                         documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                         ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().[T]
//                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(expr)
//                                                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(queryBuilder)
          append("MONTH(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
      /**
       * SQL function that extracts the day field from a given date.
       * The returned value is a number between 1 and 31 both inclusive.
       *
       * @param expr Expression to extract the day from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().[T]
//                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(expr)
//                                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(queryBuilder)
      open fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
//                     display_name day
//                     documentation ```kotlin\npublic open fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the day field from a given date.\n The returned value is a number between 1 and 31 both inclusive.\n\n @param expr Expression to extract the day from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#day().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#day().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#day().
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(expr)
//                          display_name expr
//                          documentation ```kotlin\nexpr: Expression<T>\n```
//                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                          ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(queryBuilder)
//                                                       display_name queryBuilder
//                                                       documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                       ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(expr)
//                                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(queryBuilder)
          append("DAY(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
      /**
       * SQL function that extracts the hour field from a given date.
       * The returned value is a number between 0 and 23 both inclusive.
       *
       * @param expr Expression to extract the hour from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().[T]
//                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(expr)
//                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(queryBuilder)
      open fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
//                      display_name hour
//                      documentation ```kotlin\npublic open fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the hour field from a given date.\n The returned value is a number between 0 and 23 both inclusive.\n\n @param expr Expression to extract the hour from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#hour().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#hour().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#hour().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(expr)
//                           display_name expr
//                           documentation ```kotlin\nexpr: Expression<T>\n```
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(queryBuilder)
//                                                        display_name queryBuilder
//                                                        documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                        ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().[T]
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(expr)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(queryBuilder)
          append("HOUR(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
      /**
       * SQL function that extracts the minute field from a given date.
       * The returned value is a number between 0 and 59 both inclusive.
       *
       * @param expr Expression to extract the minute from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(expr)
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(queryBuilder)
      open fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
//                        display_name minute
//                        documentation ```kotlin\npublic open fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the minute field from a given date.\n The returned value is a number between 0 and 59 both inclusive.\n\n @param expr Expression to extract the minute from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#minute().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#minute().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#minute().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().[T]
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(expr)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(queryBuilder)
          append("MINUTE(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
      /**
       * SQL function that extracts the second field from a given date.
       * The returned value is a number between 0 and 59 both inclusive.
       *
       * @param expr Expression to extract the second from.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(expr)
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(queryBuilder)
      open fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
//                        display_name second
//                        documentation ```kotlin\npublic open fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts the second field from a given date.\n The returned value is a number between 0 and 59 both inclusive.\n\n @param expr Expression to extract the second from.\n @param queryBuilder Query builder to append the SQL function to.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#second().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#second().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#second().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().[T]
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(expr)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(queryBuilder)
          append("SECOND(")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
          append(expr)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().(expr)
          append(")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
  
      // Cast functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
      /**
       * SQL function that casts an expression to a specific type.
       *
       * @param expr Expression to cast.
       * @param type Type to cast the expression to.
       * @param builder Query builder to append the SQL function to.
       */
      open fun cast(
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
//                  display_name cast
//                  documentation ```kotlin\npublic open fun cast(expr: Expression<*>, type: IColumnType<*>, builder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that casts an expression to a specific type.\n\n @param expr Expression to cast.\n @param type Type to cast the expression to.\n @param builder Query builder to append the SQL function to.\n
//                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#cast().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(expr)
          expr: Expression<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: Expression<*>\n```
//              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(type)
          type: IColumnType<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(type)
//             display_name type
//             documentation ```kotlin\ntype: IColumnType<*>\n```
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(type)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(builder)
          builder: QueryBuilder
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(builder)
//                display_name builder
//                documentation ```kotlin\nbuilder: QueryBuilder\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(builder)
      ): Unit = builder {
//       ^^^^ reference semanticdb maven . . kotlin/Unit#
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(builder)
          append("CAST(", expr, " AS ", type.sqlType(), ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(expr)
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().(type)
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#cast().
  
      // Aggregate Functions for Statistics
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
      /**
       * SQL function that returns the population standard deviation of the non-null input values,
       * or `null` if there are no non-null values.
       *
       * @param expression Expression from which the population standard deviation is calculated.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().[T]
//                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(expression)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(queryBuilder)
      open fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
//                           display_name stdDevPop
//                           documentation ```kotlin\npublic open fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the population standard deviation of the non-null input values,\n or `null` if there are no non-null values.\n\n @param expression Expression from which the population standard deviation is calculated.\n @param queryBuilder Query builder to append the SQL function to.\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevPop().
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(expression)
//                                      display_name expression
//                                      documentation ```kotlin\nexpression: Expression<T>\n```
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(queryBuilder)
//                                                                   display_name queryBuilder
//                                                                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(expression)
//                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(queryBuilder)
          append("STDDEV_POP(", expression, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().(expression)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
      /**
       * SQL function that returns the sample standard deviation of the non-null input values,
       * or `null` if there are no non-null values.
       *
       * @param expression Expression from which the sample standard deviation is calculated.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(expression)
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(queryBuilder)
      open fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
//                            display_name stdDevSamp
//                            documentation ```kotlin\npublic open fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the sample standard deviation of the non-null input values,\n or `null` if there are no non-null values.\n\n @param expression Expression from which the sample standard deviation is calculated.\n @param queryBuilder Query builder to append the SQL function to.\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#stdDevSamp().
//                            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(expression)
//                                       display_name expression
//                                       documentation ```kotlin\nexpression: Expression<T>\n```
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                       ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(queryBuilder)
//                                                                    display_name queryBuilder
//                                                                    documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                    ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().[T]
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(expression)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(queryBuilder)
          append("STDDEV_SAMP(", expression, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().(expression)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
      /**
       * SQL function that returns the population variance of the non-null input values (square of the population standard deviation),
       * or `null` if there are no non-null values.
       *
       * @param expression Expression from which the population variance is calculated.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().[T]
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(expression)
//                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(queryBuilder)
      open fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
//                        display_name varPop
//                        documentation ```kotlin\npublic open fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the population variance of the non-null input values (square of the population standard deviation),\n or `null` if there are no non-null values.\n\n @param expression Expression from which the population variance is calculated.\n @param queryBuilder Query builder to append the SQL function to.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varPop().
//                        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(expression)
//                                   display_name expression
//                                   documentation ```kotlin\nexpression: Expression<T>\n```
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                   ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(queryBuilder)
//                                                                display_name queryBuilder
//                                                                documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().[T]
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(expression)
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(queryBuilder)
          append("VAR_POP(", expression, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().(expression)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
      /**
       * SQL function that returns the sample variance of the non-null input values (square of the sample standard deviation),
       * or `null` if there are no non-null values.
       *
       * @param expression Expression from which the sample variance is calculated.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().[T]
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(expression)
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(queryBuilder)
      open fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
//                         display_name varSamp
//                         documentation ```kotlin\npublic open fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns the sample variance of the non-null input values (square of the sample standard deviation),\n or `null` if there are no non-null values.\n\n @param expression Expression from which the sample variance is calculated.\n @param queryBuilder Query builder to append the SQL function to.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#varSamp().
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(expression)
//                                    display_name expression
//                                    documentation ```kotlin\nexpression: Expression<T>\n```
//                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(queryBuilder)
//                                                                 display_name queryBuilder
//                                                                 documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                 ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(queryBuilder)
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().[T]
//                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(expression)
//                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(queryBuilder)
          append("VAR_SAMP(", expression, ")")
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().(expression)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
  
      // Array Functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
      /**
       * SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),
       * or `null` if the stored array itself is null.
       *
       * @param expression Array expression from which the subarray is returned.
       * @param lower Lower bounds (inclusive) of a subarray.
       * @param upper Upper bounds (inclusive) of a subarray.
       * **Note** If either bounds is left `null`, the database will use the stored array's respective lower or upper limit.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().[T]
//                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(expression)
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(lower)
//                                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(upper)
//                                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(queryBuilder)
      open fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder) {
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
//                            display_name arraySlice
//                            documentation ```kotlin\npublic open fun <T> arraySlice(expression: Expression<T>, lower: Int?, upper: Int?, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that returns a subarray of elements stored from between [lower] and [upper] bounds (inclusive),\n or `null` if the stored array itself is null.\n\n @param expression Array expression from which the subarray is returned.\n @param lower Lower bounds (inclusive) of a subarray.\n @param upper Upper bounds (inclusive) of a subarray.\n **Note** If either bounds is left `null`, the database will use the stored array's respective lower or upper limit.\n @param queryBuilder Query builder to append the SQL function to.\n
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#arraySlice().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#arraySlice().
//                            ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(expression)
//                                       display_name expression
//                                       documentation ```kotlin\nexpression: Expression<T>\n```
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(lower)
//                                                             display_name lower
//                                                             documentation ```kotlin\nlower: Int?\n```
//                                                              ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                    ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(upper)
//                                                                          display_name upper
//                                                                          documentation ```kotlin\nupper: Int?\n```
//                                                                           ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                 ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(queryBuilder)
//                                                                                              display_name queryBuilder
//                                                                                              documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().[T]
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(expression)
//                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(lower)
//                                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(upper)
//                                                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().(queryBuilder)
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for ARRAY_SLICE. There must be a vendor specific implementation", currentDialect
//                                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#arraySlice().
  
      // JSON Functions
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
      /**
       * SQL function that extracts data from a JSON object at the specified [path], either as a JSON representation or as a scalar value.
       *
       * @param expression Expression from which to extract JSON subcomponents matched by [path].
       * @param path String(s) representing JSON path/keys that match fields to be extracted.
       * **Note:** Multiple [path] arguments are not supported by all vendors; please check the documentation.
       * @param toScalar If `true`, the extracted result is a scalar or text value; otherwise, it is a JSON object.
       * @param jsonType Column type of [expression] to check, if casting to JSONB is required.
       * @param queryBuilder Query builder to append the SQL function to.
       */
//              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().[T]
      open fun <T> jsonExtract(
//              ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().[T]
//                display_name FirTypeParameterSymbol T
//                documentation ```kotlin\nT\n```
//                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
//                             display_name jsonExtract
//                             documentation ```kotlin\npublic open fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that extracts data from a JSON object at the specified [path], either as a JSON representation or as a scalar value.\n\n @param expression Expression from which to extract JSON subcomponents matched by [path].\n @param path String(s) representing JSON path/keys that match fields to be extracted.\n **Note:** Multiple [path] arguments are not supported by all vendors; please check the documentation.\n @param toScalar If `true`, the extracted result is a scalar or text value; otherwise, it is a JSON object.\n @param jsonType Column type of [expression] to check, if casting to JSONB is required.\n @param queryBuilder Query builder to append the SQL function to.\n
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExtract().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExtract().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExtract().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExtract().
//              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(expression)
          expression: Expression<T>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<T>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(toScalar)
          toScalar: Boolean,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(toScalar)
//                 display_name toScalar
//                 documentation ```kotlin\ntoScalar: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(toScalar)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().(queryBuilder)
      ) {
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for JSON_EXTRACT. There must be a vendor specific implementation", currentDialect
//                                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
      /**
       * SQL function that checks whether a [candidate] expression is contained within a JSON [target].
       *
       * @param target JSON expression being searched.
       * @param candidate Expression to search for in [target].
       * @param path String representing JSON path/keys that match specific fields to search for [candidate].
       * **Note:** A [path] argument is not supported by all vendors; please check the documentation.
       * @param jsonType Column type of [target] to check, if casting to JSONB is required.
       * @param queryBuilder Query builder to append the SQL function to.
       */
      open fun jsonContains(
//             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
//                          display_name jsonContains
//                          documentation ```kotlin\npublic open fun jsonContains(target: Expression<*>, candidate: Expression<*>, path: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that checks whether a [candidate] expression is contained within a JSON [target].\n\n @param target JSON expression being searched.\n @param candidate Expression to search for in [target].\n @param path String representing JSON path/keys that match specific fields to search for [candidate].\n **Note:** A [path] argument is not supported by all vendors; please check the documentation.\n @param jsonType Column type of [target] to check, if casting to JSONB is required.\n @param queryBuilder Query builder to append the SQL function to.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonContains().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonContains().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(target)
          target: Expression<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Expression<*>\n```
//                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(candidate)
          candidate: Expression<*>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(candidate)
//                  display_name candidate
//                  documentation ```kotlin\ncandidate: Expression<*>\n```
//                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(candidate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(path)
          path: String?,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(path)
//             display_name path
//             documentation ```kotlin\npath: String?\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().(queryBuilder)
      ) {
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for JSON_CONTAINS. There must be a vendor specific implementation", currentDialect
//                                                                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonContains().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
      /**
       * SQL function that checks whether data exists within a JSON [expression] at the specified [path].
       *
       * @param expression JSON expression being checked.
       * @param path String(s) representing JSON path/keys that match fields to check for existing data.
       * **Note:** Multiple [path] arguments are not supported by all vendors; please check the documentation.
       * @param optional String representing any optional vendor-specific clause or argument.
       * @param jsonType Column type of [expression] to check, if casting to JSONB is required.
       * @param queryBuilder Query builder to append the SQL function to.
       */
      open fun jsonExists(
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
//                        display_name jsonExists
//                        documentation ```kotlin\npublic open fun jsonExists(expression: Expression<*>, vararg path: String, optional: String?, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n SQL function that checks whether data exists within a JSON [expression] at the specified [path].\n\n @param expression JSON expression being checked.\n @param path String(s) representing JSON path/keys that match fields to check for existing data.\n **Note:** Multiple [path] arguments are not supported by all vendors; please check the documentation.\n @param optional String representing any optional vendor-specific clause or argument.\n @param jsonType Column type of [expression] to check, if casting to JSONB is required.\n @param queryBuilder Query builder to append the SQL function to.\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#jsonExists().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#jsonExists().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#jsonExists().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#jsonExists().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(expression)
          expression: Expression<*>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: Expression<*>\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(path)
          vararg path: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(path)
//                    display_name path
//                    documentation ```kotlin\nvararg path: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/Array#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(path)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(optional)
          optional: String?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(optional)
//                 display_name optional
//                 documentation ```kotlin\noptional: String?\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(optional)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(jsonType)
          jsonType: IColumnType<*>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(jsonType)
//                 display_name jsonType
//                 documentation ```kotlin\njsonType: IColumnType<*>\n```
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(jsonType)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(queryBuilder)
          queryBuilder: QueryBuilder
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(queryBuilder)
//                     display_name queryBuilder
//                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().(queryBuilder)
      ) {
          throw UnsupportedByDialectException(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
              "There's no generic SQL for JSON_EXISTS. There must be a vendor specific implementation", currentDialect
//                                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExists().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#DEFAULT_VALUE_EXPRESSION.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#getDEFAULT_VALUE_EXPRESSION().
      // Commands
      @Suppress("VariableNaming")
      open val DEFAULT_VALUE_EXPRESSION: String = "DEFAULT VALUES"
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#DEFAULT_VALUE_EXPRESSION.
//                                      display_name DEFAULT_VALUE_EXPRESSION
//                                      documentation ```kotlin\n@Suppress(...) public open val DEFAULT_VALUE_EXPRESSION: String\n```
//             ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#getDEFAULT_VALUE_EXPRESSION().
//                                      display_name DEFAULT_VALUE_EXPRESSION
//                                      documentation ```kotlin\npublic get(): String\n```
//                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#DEFAULT_VALUE_EXPRESSION.
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#getDEFAULT_VALUE_EXPRESSION().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
      /**
       * Returns the SQL command that inserts a new row into a table.
       *
       * **Note:** The `ignore` parameter is not supported by all vendors, please check the documentation.
       *
       * @param ignore Whether to ignore errors or not.
       * @param table Table to insert the new row into.
       * @param columns Columns to insert the values into.
       * @param expr Expression with the values to insert.
       * @param transaction Transaction where the operation is executed.
       */
      open fun insert(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
//                    display_name insert
//                    documentation ```kotlin\npublic open fun insert(ignore: Boolean, table: Table, columns: List<Column<*>>, expr: String, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that inserts a new row into a table.\n\n **Note:** The `ignore` parameter is not supported by all vendors, please check the documentation.\n\n @param ignore Whether to ignore errors or not.\n @param table Table to insert the new row into.\n @param columns Columns to insert the values into.\n @param expr Expression with the values to insert.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#insert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
          expr: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
//             display_name expr
//             documentation ```kotlin\nexpr: String\n```
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (ignore) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(ignore)
              transaction.throwUnsupportedException("There's no generic SQL for INSERT IGNORE. There must be vendor specific implementation.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
  
//        ⌄ enclosing_range_start local 5
          val autoIncColumn = table.autoIncColumn
//            ^^^^^^^^^^^^^ definition local 5
//                          display_name autoIncColumn
//                          documentation ```kotlin\nlocal val autoIncColumn: Column<*>?\n```
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                              ⌃ enclosing_range_end local 5
  
//        ⌄ enclosing_range_start local 6
//                                                                                            ⌄ enclosing_range_start local 7
          val nextValExpression = autoIncColumn?.autoIncColumnType?.nextValExpression?.takeIf { autoIncColumn !in columns }
//            ^^^^^^^^^^^^^^^^^ definition local 6
//                              display_name nextValExpression
//                              documentation ```kotlin\nlocal val nextValExpression: NextVal<*>?\n```
//                                ^^^^^^^^^^^^^ reference local 5
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
//                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 7
//                                                                                                                          display_name it
//                                                                                                                          documentation ```kotlin\nit: NextVal<*>\n```
//                                                                                              ^^^^^^^^^^^^^ reference local 5
//                                                                                                            ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                            ^^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                                                                                                        ⌃ enclosing_range_end local 6
//                                                                                                                        ⌃ enclosing_range_end local 7
//        ⌄ enclosing_range_start local 8
          val isInsertFromSelect = columns.isNotEmpty() && expr.isNotEmpty() && !expr.startsWith("VALUES")
//            ^^^^^^^^^^^^^^^^^^ definition local 8
//                               display_name isInsertFromSelect
//                               documentation ```kotlin\nlocal val isInsertFromSelect: Boolean\n```
//                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
//                                                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotEmpty().
//                                                                              ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/startsWith().
//                                                                                                       ⌃ enclosing_range_end local 8
  
//        ⌄ enclosing_range_start local 9
//             ⌄ enclosing_range_start local 12
//                              ⌄ enclosing_range_start local 13
          val (columnsToInsert, valuesExpr) = when {
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 9 10:9
//                                                   display_name <destruct>
//                                                   documentation ```kotlin\nlocal val <destruct>: Pair<List<Column<*>>, String>\n```
//             ^^^^^^^^^^^^^^^ definition local 12
//                             display_name columnsToInsert
//                             documentation ```kotlin\nlocal val columnsToInsert: List<Column<*>>\n```
//             ^^^^^^^^^^^^^^^ reference local 9
//             ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                              ^^^^^^^^^^ definition local 13
//                                         display_name valuesExpr
//                                         documentation ```kotlin\nlocal val valuesExpr: String\n```
//                              ^^^^^^^^^^ reference local 9
//                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                           ⌃ enclosing_range_end local 12
//                                       ⌃ enclosing_range_end local 13
              isInsertFromSelect -> columns to expr
//            ^^^^^^^^^^^^^^^^^^ reference local 8
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                          ^^ reference semanticdb maven . . kotlin/to().
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
              nextValExpression != null && columns.isNotEmpty() -> (columns + autoIncColumn) to expr.dropLast(1) + ", $nextValExpression)"
//            ^^^^^^^^^^^^^^^^^ reference local 6
//                                         ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                                                          ^ reference semanticdb maven . . kotlin/collections/plus(+28).
//                                                                            ^^^^^^^^^^^^^ reference local 5
//                                                                                           ^^ reference semanticdb maven . . kotlin/to().
//                                                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
//                                                                                                   ^^^^^^^^ reference semanticdb maven . . kotlin/text/dropLast(+1).
//                                                                                                               ^ reference semanticdb maven . . kotlin/String#plus().
//                                                                                                                     ^^^^^^^^^^^^^^^^^ reference local 6
              nextValExpression != null -> listOf(autoIncColumn) to "VALUES ($nextValExpression)"
//            ^^^^^^^^^^^^^^^^^ reference local 6
//                                         ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                ^^^^^^^^^^^^^ reference local 5
//                                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                                            ^^^^^^^^^^^^^^^^^ reference local 6
              columns.isNotEmpty() -> columns to expr
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(columns)
//                                            ^^ reference semanticdb maven . . kotlin/to().
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(expr)
              currentDialect is OracleDialect -> {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                ⌄ enclosing_range_start local 10
//                                                                                                   ⌄ enclosing_range_start local 11
                  val oracleDefaults = table.columns.joinToString(prefix = "VALUES(", postfix = ")") { "DEFAULT" }
//                    ^^^^^^^^^^^^^^ definition local 10
//                                   display_name oracleDefaults
//                                   documentation ```kotlin\nlocal val oracleDefaults: String\n```
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#columns.
//                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getColumns().
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                   ^^^^^^^^^^^^^ definition local 11
//                                                                                                                 display_name it
//                                                                                                                 documentation ```kotlin\nit: Column<*>\n```
//                                                                                                               ⌃ enclosing_range_end local 10
//                                                                                                               ⌃ enclosing_range_end local 11
                  emptyList<Column<*>>() to oracleDefaults
//                ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                       ^^ reference semanticdb maven . . kotlin/to().
//                                          ^^^^^^^^^^^^^^ reference local 10
              }
              else -> emptyList<Column<*>>() to DEFAULT_VALUE_EXPRESSION
//                    ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                           ^^ reference semanticdb maven . . kotlin/to().
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#DEFAULT_VALUE_EXPRESSION.
//                                              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#getDEFAULT_VALUE_EXPRESSION().
          }
//        ⌃ enclosing_range_end local 9
//        ⌄ enclosing_range_start local 14
//                                                 ⌄ enclosing_range_start local 15
//                                                                                                                ⌄ enclosing_range_start local 16
          val columnsExpr = columnsToInsert.takeIf { it.isNotEmpty() }?.joinToString(prefix = "(", postfix = ")") { transaction.identity(it) } ?: ""
//            ^^^^^^^^^^^ definition local 14
//                        display_name columnsExpr
//                        documentation ```kotlin\nlocal val columnsExpr: String\n```
//                          ^^^^^^^^^^^^^^^ reference local 12
//                                          ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                 ^^^^^^^^^^^^^^^^^^^ definition local 15
//                                                                     display_name it
//                                                                     documentation ```kotlin\nit: List<Column<*>>\n```
//                                                   ^^ reference local 15
//                                                      ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 16
//                                                                                                                                             display_name it
//                                                                                                                                             documentation ```kotlin\nit: Column<*>\n```
//                                                                                                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
//                                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                                                       ^^ reference local 16
//                                                                   ⌃ enclosing_range_end local 15
//                                                                                                                                           ⌃ enclosing_range_end local 16
//                                                                                                                                                 ⌃ enclosing_range_end local 14
  
          return "INSERT INTO ${transaction.identity(table)} $columnsExpr $valuesExpr"
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(transaction)
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().(table)
//                                                            ^^^^^^^^^^^ reference local 14
//                                                                         ^^^^^^^^^^ reference local 13
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
      /**
       * Generates the SQL MERGE command which synchronizes two datasets by inserting new rows,
       * or updating/deleting existing ones in the target table based on data from another table.
       *
       * @param dest The table that will be modified.
       * @param source The table providing the data for modification.
       * @param transaction The transaction in which the operation will be executed.
       * @param clauses A list of `MergeStatement.When` instances describing the `when` clauses of the SQL command.
       * @param on The condition that determines whether to apply insertions or updates/deletions.
       */
      open fun merge(
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                   display_name merge
//                   documentation ```kotlin\npublic open fun merge(dest: Table, source: Table, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>?): String\n```\n\n----\n\n\n Generates the SQL MERGE command which synchronizes two datasets by inserting new rows,\n or updating/deleting existing ones in the target table based on data from another table.\n\n @param dest The table that will be modified.\n @param source The table providing the data for modification.\n @param transaction The transaction in which the operation will be executed.\n @param clauses A list of `MergeStatement.When` instances describing the `when` clauses of the SQL command.\n @param on The condition that determines whether to apply insertions or updates/deletions.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#merge().
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
          dest: Table,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
//             display_name dest
//             documentation ```kotlin\ndest: Table\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(source)
          source: Table,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(source)
//               display_name source
//               documentation ```kotlin\nsource: Table\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(source)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(clauses)
          clauses: List<MergeStatement.Clause>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(clauses)
//                display_name clauses
//                documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(clauses)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(on)
          on: Op<Boolean>?
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(on)
//           display_name on
//           documentation ```kotlin\non: Op<Boolean>?\n```
//            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(on)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          validateMergeStatement(transaction, clauses)
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(clauses)
  
//        ⌄ enclosing_range_start local 17
          val onCondition = (
//            ^^^^^^^^^^^ definition local 17
//                        display_name onCondition
//                        documentation ```kotlin\nlocal val onCondition: String\n```
              on?.toString() ?: run {
//            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(on)
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toString().
//                              ^^^ reference semanticdb maven . . kotlin/run(+1).
//                ⌄ enclosing_range_start local 18
                  val targetKey = dest.primaryKey?.columns?.singleOrNull()
//                    ^^^^^^^^^ definition local 18
//                              display_name targetKey
//                              documentation ```kotlin\nlocal val targetKey: Column<*>?\n```
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull().
//                                                                       ⌃ enclosing_range_end local 18
//                ⌄ enclosing_range_start local 19
                  val sourceKey = source.primaryKey?.columns?.singleOrNull()
//                    ^^^^^^^^^ definition local 19
//                              display_name sourceKey
//                              documentation ```kotlin\nlocal val sourceKey: Column<*>?\n```
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(source)
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull().
//                                                                         ⌃ enclosing_range_end local 19
  
                  if (targetKey == null || sourceKey == null) {
//                    ^^^^^^^^^ reference local 18
//                                         ^^^^^^^^^ reference local 19
                      transaction.throwUnsupportedException("MERGE requires an ON condition to be specified.")
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                  }
  
                  "${transaction.fullIdentity(targetKey)}=${transaction.fullIdentity(sourceKey)}"
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                            ^^^^^^^^^ reference local 18
//                                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                                                   ^^^^^^^^^ reference local 19
              }
//                  ⌄ enclosing_range_start local 20
              ).let { if (currentDialect is OracleDialect) "($it)" else it }
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 20
//                                                                           display_name it
//                                                                           documentation ```kotlin\nit: String\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                            ^^ reference local 20
//                                                                      ^^ reference local 20
//                                                                         ⌃ enclosing_range_end local 17
//                                                                         ⌃ enclosing_range_end local 20
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"MERGE INTO ${transaction.identity(dest)} "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
              +"USING ${transaction.identity(source)} "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(source)
              +"ON $onCondition "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                  ^^^^^^^^^^^ reference local 17
              addClausesToMergeStatement(transaction, dest, clauses)
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(transaction)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(dest)
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().(clauses)
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
      /**
       * Generates the SQL MERGE command which synchronizes two datasets by inserting new rows,
       * or updating/deleting existing ones in the target table based on data from subquery.
       *
       * @param dest The table that will be modified.
       * @param source The query providing the data for modification.
       * @param transaction The transaction in which the operation will be executed.
       * @param clauses A list of `MergeStatement.When` instances describing the `when` clauses of the SQL command.
       * @param on The condition that determines whether to apply insertions or updates/deletions.
       */
      open fun mergeSelect(
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
//                         display_name mergeSelect
//                         documentation ```kotlin\npublic open fun mergeSelect(dest: Table, source: QueryAlias, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>, prepared: Boolean): String\n```\n\n----\n\n\n Generates the SQL MERGE command which synchronizes two datasets by inserting new rows,\n or updating/deleting existing ones in the target table based on data from subquery.\n\n @param dest The table that will be modified.\n @param source The query providing the data for modification.\n @param transaction The transaction in which the operation will be executed.\n @param clauses A list of `MergeStatement.When` instances describing the `when` clauses of the SQL command.\n @param on The condition that determines whether to apply insertions or updates/deletions.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#mergeSelect().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(dest)
          dest: Table,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(dest)
//             display_name dest
//             documentation ```kotlin\ndest: Table\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(dest)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(source)
          source: QueryAlias,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(source)
//               display_name source
//               documentation ```kotlin\nsource: QueryAlias\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(source)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(clauses)
          clauses: List<MergeStatement.Clause>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(clauses)
//                display_name clauses
//                documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(clauses)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(on)
          on: Op<Boolean>,
//        ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(on)
//           display_name on
//           documentation ```kotlin\non: Op<Boolean>\n```
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(on)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(prepared)
          prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(prepared)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          validateMergeStatement(transaction, clauses)
//        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().
//                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(clauses)
  
//        ⌄ enclosing_range_start local 21
          val using = source.query.prepareSQL(transaction, prepared)
//            ^^^^^ definition local 21
//                  display_name using
//                  documentation ```kotlin\nlocal val using: String\n```
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(source)
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getQuery().
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#query.
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(prepared)
//                                                                 ⌃ enclosing_range_end local 21
  
//        ⌄ enclosing_range_start local 22
          val onRaw = if (currentDialect is OracleDialect) "($on)" else "$on"
//            ^^^^^ definition local 22
//                  display_name onRaw
//                  documentation ```kotlin\nlocal val onRaw: String\n```
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(on)
//                                                                        ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(on)
//                                                                          ⌃ enclosing_range_end local 22
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"MERGE INTO ${transaction.identity(dest)} "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(dest)
              +"USING ( $using ) ${if (currentDialect is OracleDialect) "" else "as"} ${source.alias} "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                       ^^^^^ reference local 21
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                                                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(source)
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#alias.
//                                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#getAlias().
              +"ON $onRaw "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                  ^^^^^ reference local 22
              addClausesToMergeStatement(transaction, dest, clauses)
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(transaction)
//                                                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(dest)
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().(clauses)
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().
//                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
      private fun validateMergeStatement(transaction: Transaction, clauses: List<MergeStatement.Clause>) {
//                ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().
//                                       display_name validateMergeStatement
//                                       documentation ```kotlin\nprivate final fun validateMergeStatement(transaction: Transaction, clauses: List<MergeStatement.Clause>): Unit\n```
//                                       ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                                                   display_name transaction
//                                                   documentation ```kotlin\ntransaction: Transaction\n```
//                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                 ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
//                                                                         display_name clauses
//                                                                         documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
          if (currentDialect !is OracleDialect) {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                            ⌄ enclosing_range_start local 23
              if (clauses.any { it.deleteWhere != null }) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
//                        ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 23
//                                                       display_name it
//                                                       documentation ```kotlin\nit: MergeStatement.Clause\n```
//                              ^^ reference local 23
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#deleteWhere.
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getDeleteWhere().
//                                                     ⌃ enclosing_range_end local 23
                  transaction.throwUnsupportedException("'deleteWhere' parameter can be used only as a part of Oracle SQL update clause statement.")
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              }
          }
  
          if (currentDialect !is PostgreSQLDialect) {
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                            ⌄ enclosing_range_start local 24
              if (clauses.any { it.action == MergeStatement.ClauseAction.DO_NOTHING }) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
//                        ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 24
//                                                                                    display_name it
//                                                                                    documentation ```kotlin\nit: MergeStatement.Clause\n```
//                              ^^ reference local 24
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DO_NOTHING.
//                                                                                  ⌃ enclosing_range_end local 24
                  transaction.throwUnsupportedException("DO NOTHING actions is supported only by Postgres database.")
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              }
  
//                            ⌄ enclosing_range_start local 25
              if (clauses.any { it.overridingUserValue }) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
//                        ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 25
//                                                       display_name it
//                                                       documentation ```kotlin\nit: MergeStatement.Clause\n```
//                              ^^ reference local 25
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingUserValue().
//                                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingUserValue.
//                                                     ⌃ enclosing_range_end local 25
                  transaction.throwUnsupportedException("OVERRIDING USER VALUE modifier is supported only by Postgres database.")
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              }
  
//                            ⌄ enclosing_range_start local 26
              if (clauses.any { it.overridingSystemValue }) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(clauses)
//                        ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 26
//                                                         display_name it
//                                                         documentation ```kotlin\nit: MergeStatement.Clause\n```
//                              ^^ reference local 26
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingSystemValue().
//                                 ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingSystemValue.
//                                                       ⌃ enclosing_range_end local 26
                  transaction.throwUnsupportedException("OVERRIDING SYSTEM VALUE modifier is supported only by Postgres database.")
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#validateMergeStatement().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
      /**
       * Returns the SQL command that updates one or more rows of a table.
       *
       * @param target Table to update values from.
       * @param columnsAndValues Pairs of column to update and values to update with.
       * @param limit Maximum number of rows to update.
       * @param where Condition that decides the rows to update.
       * @param transaction Transaction where the operation is executed.
       */
      open fun update(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
//                    display_name update
//                    documentation ```kotlin\npublic open fun update(target: Table, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that updates one or more rows of a table.\n\n @param target Table to update values from.\n @param columnsAndValues Pairs of column to update and values to update with.\n @param limit Maximum number of rows to update.\n @param where Condition that decides the rows to update.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(target)
          target: Table,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(target)
//               display_name target
//               documentation ```kotlin\ntarget: Table\n```
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(target)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(transaction)
      ): String = with(QueryBuilder(true)) {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^ reference semanticdb maven . . kotlin/with().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
          +"UPDATE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          target.describe(transaction, this)
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(target)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(transaction)
  
//                                                            ⌄ enclosing_range_start local 27
//                                                             ⌄ enclosing_range_start local 28
//                                                                  ⌄ enclosing_range_start local 29
          columnsAndValues.appendTo(this, prefix = " SET ") { (col, value) ->
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(columnsAndValues)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                            ^^^^^^^^^^^^ definition local 27
//                                                                         display_name <destruct>
//                                                                         documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                             ^^^ reference local 27
//                                                             ^^^ definition local 28
//                                                                 display_name col
//                                                                 documentation ```kotlin\nlocal val col: Column<*>\n```
//                                                             ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                  ^^^^^ reference local 27
//                                                                  ^^^^^ definition local 29
//                                                                        display_name value
//                                                                        documentation ```kotlin\nlocal val value: Any?\n```
//                                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                               ⌃ enclosing_range_end local 28
//                                                                      ⌃ enclosing_range_end local 29
//                                                                       ⌃ enclosing_range_end local 27
              append("${transaction.identity(col)}=")
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(transaction)
//                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                           ^^^ reference local 28
              registerArgument(col, value)
//            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             ^^^ reference local 28
//                                  ^^^^^ reference local 29
          }
  
//                   ⌄ enclosing_range_start local 30
          where?.let {
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(where)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^ definition local 30 3:9
//                     display_name it
//                     documentation ```kotlin\nit: Op<Boolean>\n```
              +" WHERE "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              +it
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//             ^^ reference local 30
          }
//        ⌃ enclosing_range_end local 30
//                   ⌄ enclosing_range_start local 31
          limit?.let { +" LIMIT $it" }
//        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().(limit)
//               ^^^ reference semanticdb maven . . kotlin/let().
//                   ^^^^^^^^^^^^^^^^^ definition local 31
//                                     display_name it
//                                     documentation ```kotlin\nit: Int\n```
//                     ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                               ^^ reference local 31
//                                   ⌃ enclosing_range_end local 31
          toString()
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
      /**
       * Returns the SQL command that updates one or more rows of a join.
       *
       * @param targets Join to update values from.
       * @param columnsAndValues Pairs of column to update and values to update with.
       * @param limit Maximum number of rows to update.
       * @param where Condition that decides the rows to update.
       * @param transaction Transaction where the operation is executed.
       */
      open fun update(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
//                    display_name update
//                    documentation ```kotlin\npublic open fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that updates one or more rows of a join.\n\n @param targets Join to update values from.\n @param columnsAndValues Pairs of column to update and values to update with.\n @param limit Maximum number of rows to update.\n @param where Condition that decides the rows to update.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#update().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#update().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#update(+1).
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#update().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(columnsAndValues)
          columnsAndValues: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(columnsAndValues)
//                         display_name columnsAndValues
//                         documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(columnsAndValues)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(transaction)
      ): String = transaction.throwUnsupportedException("UPDATE with a join clause is unsupported")
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
      protected fun QueryBuilder.appendJoinPart(
//                               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
//                                              display_name appendJoinPart
//                                              documentation ```kotlin\nprotected final fun QueryBuilder.appendJoinPart(targetTable: Table, targets: Join, transaction: Transaction, filterTargetTable: Boolean = ...): Unit\n```
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targetTable)
          targetTable: Table,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targetTable)
//                    display_name targetTable
//                    documentation ```kotlin\ntargetTable: Table\n```
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targetTable)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(filterTargetTable)
          filterTargetTable: Boolean = true
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(filterTargetTable)
//                          display_name filterTargetTable
//                          documentation ```kotlin\nfilterTargetTable: Boolean = ...\n```
//                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(filterTargetTable)
      ) {
//        ⌄ enclosing_range_start local 32
          val joinPartsToAppend = if (filterTargetTable) {
//            ^^^^^^^^^^^^^^^^^ definition local 32
//                              display_name joinPartsToAppend
//                              documentation ```kotlin\nlocal val joinPartsToAppend: List<Join.JoinPart>\n```
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(filterTargetTable)
//                                     ⌄ enclosing_range_start local 33
              targets.joinParts.filter { it.joinPart != targetTable }
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                              ^^^^^^ reference semanticdb maven . . kotlin/collections/filter(+9).
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 33
//                                                                    display_name it
//                                                                    documentation ```kotlin\nit: Join.JoinPart\n```
//                                       ^^ reference local 33
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targetTable)
//                                                                  ⌃ enclosing_range_end local 33
          } else {
              targets.joinParts
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
          }
//        ⌃ enclosing_range_end local 32
          if (targets.table != targetTable) {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targetTable)
              targets.table.describe(transaction, this)
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getTable().
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#table.
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(transaction)
              if (joinPartsToAppend.isNotEmpty()) {
//                ^^^^^^^^^^^^^^^^^ reference local 32
//                                  ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                  +", "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              }
          }
  
//                                               ⌄ enclosing_range_start local 34
          joinPartsToAppend.appendTo(this, ", ") {
//        ^^^^^^^^^^^^^^^^^ reference local 32
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                               ^ definition local 34 2:9
//                                                 display_name it
//                                                 documentation ```kotlin\nit: Join.JoinPart\n```
              it.joinPart.describe(transaction, this)
//            ^^ reference local 34
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinPart().
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinPart.
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnSet#describe().
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(transaction)
          }
//        ⌃ enclosing_range_end local 34
  
          +" WHERE "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                  ⌄ enclosing_range_start local 35
          targets.joinParts.appendTo(this, " AND ") {
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().(targets)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                                  ^ definition local 35 2:9
//                                                    display_name it
//                                                    documentation ```kotlin\nit: Join.JoinPart\n```
              it.appendConditions(this)
//            ^^ reference local 35
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#appendConditions().
          }
//        ⌃ enclosing_range_end local 35
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
//                                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(tableToUpdate)
//                                                                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(targets)
//                                                                                                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(transaction)
      protected fun QueryBuilder.appendJoinPartForUpdateClause(tableToUpdate: Table, targets: Join, transaction: Transaction) {
//                               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
//                                                             display_name appendJoinPartForUpdateClause
//                                                             documentation ```kotlin\nprotected final fun QueryBuilder.appendJoinPartForUpdateClause(tableToUpdate: Table, targets: Join, transaction: Transaction): Unit\n```
//                                                             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(tableToUpdate)
//                                                                           display_name tableToUpdate
//                                                                           documentation ```kotlin\ntableToUpdate: Table\n```
//                                                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                                                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(targets)
//                                                                                           display_name targets
//                                                                                           documentation ```kotlin\ntargets: Join\n```
//                                                                                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                                                                                                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(transaction)
//                                                                                                              display_name transaction
//                                                                                                              documentation ```kotlin\ntransaction: Transaction\n```
//                                                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(tableToUpdate)
//                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(targets)
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(transaction)
          +" FROM "
//        ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
          appendJoinPart(tableToUpdate, targets, transaction, true)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(tableToUpdate)
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(targets)
//                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().(transaction)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().(statementType)
      internal fun Join.checkJoinTypes(statementType: StatementType) {
//                      ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                     display_name checkJoinTypes
//                                     documentation ```kotlin\ninternal final fun Join.checkJoinTypes(statementType: StatementType): Unit\n```
//                                     ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().(statementType)
//                                                   display_name statementType
//                                                   documentation ```kotlin\nstatementType: StatementType\n```
//                                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().(statementType)
//                          ⌄ enclosing_range_start local 36
          if (joinParts.any { it.joinType != JoinType.INNER }) {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#getJoinParts().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#joinParts.
//                      ^^^ reference semanticdb maven . . kotlin/collections/any(+19).
//                          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 36
//                                                            display_name it
//                                                            documentation ```kotlin\nit: Join.JoinPart\n```
//                            ^^ reference local 36
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#getJoinType().
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#JoinPart#joinType.
//                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/JoinType#INNER.
//                                                          ⌃ enclosing_range_end local 36
              exposedLogger.warn("All tables in ${statementType.name} statement will be joined using inner join by default")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().(statementType)
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#getName().
//                                                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#name.
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
      /**
       * Returns the SQL command that either inserts a new row into a table, or, if insertion would violate a unique constraint,
       * first deletes the existing row before inserting a new row.
       *
       * **Note:** This operation is not supported by all vendors, please check the documentation.
       *
       * @param table Table to either insert values into or delete values from then insert into.
       * @param columns Columns to replace the values in.
       * @param expression Expression with the values to use in replace.
       * @param transaction Transaction where the operation is executed.
       */
      open fun replace(
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
//                     display_name replace
//                     documentation ```kotlin\npublic open fun replace(table: Table, columns: List<Column<*>>, expression: String, transaction: Transaction, prepared: Boolean = ...): String\n```\n\n----\n\n\n Returns the SQL command that either inserts a new row into a table, or, if insertion would violate a unique constraint,\n first deletes the existing row before inserting a new row.\n\n **Note:** This operation is not supported by all vendors, please check the documentation.\n\n @param table Table to either insert values into or delete values from then insert into.\n @param columns Columns to replace the values in.\n @param expression Expression with the values to use in replace.\n @param transaction Transaction where the operation is executed.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#replace().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#replace().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(columns)
          columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(columns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(transaction)
          transaction: Transaction,
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(transaction)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(prepared)
          prepared: Boolean = true
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean = ...\n```
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(prepared)
      ): String = transaction.throwUnsupportedException("There's no generic SQL for REPLACE. There must be a vendor specific implementation.")
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#replace().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
      /**
       * Returns the SQL command that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.
       *
       * **Note:** Vendors that do not support this operation directly implement the standard MERGE USING command.
       *
       * @param table Table to either insert values into or update values from.
       * @param data Pairs of columns to use for insert or update and values to insert or update.
       * @param expression Expression with the values to use in the insert clause.
       * @param onUpdate List of pairs of specific columns to update and the expressions to update them with.
       * @param keyColumns Columns to include in the condition that determines a unique constraint match.
       * @param where Condition that determines which rows to update, if a unique violation is found.
       * @param transaction Transaction where the operation is executed.
       */
      open fun upsert(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//                    display_name upsert
//                    documentation ```kotlin\npublic open fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that either inserts a new row into a table, or updates the existing row if insertion would violate a unique constraint.\n\n **Note:** Vendors that do not support this operation directly implement the standard MERGE USING command.\n\n @param table Table to either insert values into or update values from.\n @param data Pairs of columns to use for insert or update and values to insert or update.\n @param expression Expression with the values to use in the insert clause.\n @param onUpdate List of pairs of specific columns to update and the expressions to update them with.\n @param keyColumns Columns to include in the condition that determines a unique constraint match.\n @param where Condition that determines which rows to update, if a unique violation is found.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#upsert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#upsert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#upsert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#upsert().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(data)
          data: List<Pair<Column<*>, Any?>>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(data)
//             display_name data
//             documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(data)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(expression)
          expression: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(expression)
//                   display_name expression
//                   documentation ```kotlin\nexpression: String\n```
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(expression)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(onUpdate)
          onUpdate: List<Pair<Column<*>, Any?>>,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(onUpdate)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(keyColumns)
          keyColumns: List<Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(keyColumns)
//                   display_name keyColumns
//                   documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(keyColumns)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (where != null) {
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(where)
              transaction.throwUnsupportedException("MERGE implementation of UPSERT doesn't support single WHERE clause")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          if (keyColumns.isEmpty()) {
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
              transaction.throwUnsupportedException("UPSERT requires a unique key or constraint as a conflict target")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
  
//        ⌄ enclosing_range_start local 37
          val dataColumns = data.unzip().first
//            ^^^^^^^^^^^ definition local 37
//                        display_name dataColumns
//                        documentation ```kotlin\nlocal val dataColumns: List<Column<*>>\n```
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(data)
//                               ^^^^^ reference semanticdb maven . . kotlin/collections/unzip(+1).
//                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                           ⌃ enclosing_range_end local 37
//        ⌄ enclosing_range_start local 38
          val autoIncColumn = table.autoIncColumn
//            ^^^^^^^^^^^^^ definition local 38
//                          display_name autoIncColumn
//                          documentation ```kotlin\nlocal val autoIncColumn: Column<*>?\n```
//                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                              ⌃ enclosing_range_end local 38
//        ⌄ enclosing_range_start local 39
          val nextValExpression = autoIncColumn?.autoIncColumnType?.nextValExpression
//            ^^^^^^^^^^^^^^^^^ definition local 39
//                              display_name nextValExpression
//                              documentation ```kotlin\nlocal val nextValExpression: NextVal<*>?\n```
//                                ^^^^^^^^^^^^^ reference local 38
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//                                                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
//                                                                                  ⌃ enclosing_range_end local 39
//        ⌄ enclosing_range_start local 40
//                                                           ⌄ enclosing_range_start local 41
          val dataColumnsWithoutAutoInc = autoIncColumn?.let { dataColumns - autoIncColumn } ?: dataColumns
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 40
//                                      display_name dataColumnsWithoutAutoInc
//                                      documentation ```kotlin\nlocal val dataColumnsWithoutAutoInc: List<Column<*>>\n```
//                                        ^^^^^^^^^^^^^ reference local 38
//                                                       ^^^ reference semanticdb maven . . kotlin/let().
//                                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 41
//                                                                                           display_name it
//                                                                                           documentation ```kotlin\nit: Column<*>\n```
//                                                             ^^^^^^^^^^^ reference local 37
//                                                                         ^ reference semanticdb maven . . kotlin/collections/minus().
//                                                                           ^^^^^^^^^^^^^ reference local 38
//                                                                                              ^^^^^^^^^^^ reference local 37
//                                                                                         ⌃ enclosing_range_end local 41
//                                                                                                        ⌃ enclosing_range_end local 40
//        ⌄ enclosing_range_start local 42
          val tableIdentifier = transaction.identity(table)
//            ^^^^^^^^^^^^^^^ definition local 42
//                            display_name tableIdentifier
//                            documentation ```kotlin\nlocal val tableIdentifier: String\n```
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
//                                                        ⌃ enclosing_range_end local 42
  
          return with(QueryBuilder(true)) {
//               ^^^^ reference semanticdb maven . . kotlin/with().
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
              +"MERGE INTO "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              table.describe(transaction, this)
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(table)
//                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
              +" T USING "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                                 ⌄ enclosing_range_start local 43
//                                                                  ⌄ enclosing_range_start local 44
//                                                                          ⌄ enclosing_range_start local 45
              data.appendTo(prefix = "(VALUES (", postfix = ")") { (column, value) ->
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(data)
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                 ^^^^^^^^^^^^^^^ definition local 43
//                                                                                 display_name <destruct>
//                                                                                 documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                  ^^^^^^ reference local 43
//                                                                  ^^^^^^ definition local 44
//                                                                         display_name column
//                                                                         documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                                  ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                          ^^^^^ reference local 43
//                                                                          ^^^^^ definition local 45
//                                                                                display_name value
//                                                                                documentation ```kotlin\nlocal val value: Any?\n```
//                                                                          ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                       ⌃ enclosing_range_end local 44
//                                                                              ⌃ enclosing_range_end local 45
//                                                                               ⌃ enclosing_range_end local 43
                  registerArgument(column, value)
//                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                                 ^^^^^^ reference local 44
//                                         ^^^^^ reference local 45
              }
//                                                                   ⌄ enclosing_range_start local 46
              dataColumns.appendTo(prefix = ") S(", postfix = ")") { column ->
//            ^^^^^^^^^^^ reference local 37
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                   ^^^^^^ definition local 46
//                                                                          display_name column
//                                                                          documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                        ⌃ enclosing_range_end local 46
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference local 46
              }
  
              +" ON "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                                                    ⌄ enclosing_range_start local 47
              keyColumns.appendTo(separator = " AND ", prefix = "(", postfix = ")") { column ->
//            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(keyColumns)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                                    ^^^^^^ definition local 47
//                                                                                           display_name column
//                                                                                           documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                                         ⌃ enclosing_range_end local 47
//                ⌄ enclosing_range_start local 48
                  val columnName = transaction.identity(column)
//                    ^^^^^^^^^^ definition local 48
//                               display_name columnName
//                               documentation ```kotlin\nlocal val columnName: String\n```
//                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                      ^^^^^^ reference local 47
//                                                            ⌃ enclosing_range_end local 48
                  append("T.$columnName=S.$columnName")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^^^^ reference local 48
//                                         ^^^^^^^^^^ reference local 48
              }
  
              if (onUpdate.isNotEmpty()) {
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(onUpdate)
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
                  +" WHEN MATCHED THEN UPDATE SET "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                    ⌄ enclosing_range_start local 49
//                                     ⌄ enclosing_range_start local 50
//                                                     ⌄ enclosing_range_start local 51
                  onUpdate.appendTo { (columnToUpdate, updateExpression) ->
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(onUpdate)
//                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 49
//                                                                       display_name <destruct>
//                                                                       documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                     ^^^^^^^^^^^^^^ reference local 49
//                                     ^^^^^^^^^^^^^^ definition local 50
//                                                    display_name columnToUpdate
//                                                    documentation ```kotlin\nlocal val columnToUpdate: Column<*>\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                     ^^^^^^^^^^^^^^^^ reference local 49
//                                                     ^^^^^^^^^^^^^^^^ definition local 51
//                                                                      display_name updateExpression
//                                                                      documentation ```kotlin\nlocal val updateExpression: Any?\n```
//                                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                  ⌃ enclosing_range_end local 50
//                                                                    ⌃ enclosing_range_end local 51
//                                                                     ⌃ enclosing_range_end local 49
                      append("T.${transaction.identity(columnToUpdate)}=")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                     ^^^^^^^^^^^^^^ reference local 50
//                          ⌄ enclosing_range_start local 52
                      when (updateExpression) {
//                          ^^^^^^^^^^^^^^^^ reference local 51
//                          ^^^^^^^^^^^^^^^^ definition local 52
//                                           display_name <when-subject>
//                                           documentation ```kotlin\nlocal val <when-subject>: Any?\n```
//                                         ⌃ enclosing_range_end local 52
                          is QueryParameter<*>, !is Expression<*> -> registerArgument(columnToUpdate.columnType, updateExpression)
//                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                                                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                                                                                    ^^^^^^^^^^^^^^ reference local 50
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                               ^^^^^^^^^^^^^^^^ reference local 51
                          else -> append(updateExpression.toString().replace("$tableIdentifier.", "T."))
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                       ^^^^^^^^^^^^^^^^ reference local 51
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                                             ^^^^^^^^^^^^^^^ reference local 42
                      }
                  }
              }
  
              +" WHEN NOT MATCHED THEN INSERT "
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                               ⌄ enclosing_range_start local 53
              dataColumnsWithoutAutoInc.appendTo(prefix = "(") { column ->
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 40
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                               ^^^^^^ definition local 53
//                                                                      display_name column
//                                                                      documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                    ⌃ enclosing_range_end local 53
                  append(transaction.identity(column))
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                            ^^^^^^ reference local 53
              }
//                                   ⌄ enclosing_range_start local 54
              nextValExpression?.let {
//            ^^^^^^^^^^^^^^^^^ reference local 39
//                               ^^^ reference semanticdb maven . . kotlin/let().
//                                   ^ definition local 54 2:13
//                                     display_name it
//                                     documentation ```kotlin\nit: NextVal<*>\n```
                  append(", ${transaction.identity(autoIncColumn)}")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                 ^^^^^^^^^^^^^ reference local 38
              }
//            ⌃ enclosing_range_end local 54
//                                                                       ⌄ enclosing_range_start local 55
              dataColumnsWithoutAutoInc.appendTo(prefix = ") VALUES(") { column ->
//            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 40
//                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                       ^^^^^^ definition local 55
//                                                                              display_name column
//                                                                              documentation ```kotlin\ncolumn: Column<*>\n```
//                                                                            ⌃ enclosing_range_end local 55
                  append("S.${transaction.identity(column)}")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().(transaction)
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                 ^^^^^^ reference local 55
              }
//                                   ⌄ enclosing_range_start local 56
              nextValExpression?.let {
//            ^^^^^^^^^^^^^^^^^ reference local 39
//                               ^^^ reference semanticdb maven . . kotlin/let().
//                                   ^ definition local 56 2:13
//                                     display_name it
//                                     documentation ```kotlin\nit: NextVal<*>\n```
                  append(", $it")
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^ reference local 56
              }
//            ⌃ enclosing_range_end local 56
              +")"
//            ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              toString()
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
      /**
       * Appends to a [queryBuilder] the SQL syntax for a column that represents the same values from the INSERT clause
       * of an [upsert] command, which should be used in the UPDATE clause.
       *
       * @param columnName Name of the column for update.
       * @param queryBuilder Query builder to append the SQL syntax to.
       */
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(columnName)
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(queryBuilder)
      open fun insertValue(columnName: String, queryBuilder: QueryBuilder) { queryBuilder { +"S.$columnName" } }
//             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
//                         display_name insertValue
//                         documentation ```kotlin\npublic open fun insertValue(columnName: String, queryBuilder: QueryBuilder): Unit\n```\n\n----\n\n\n Appends to a [queryBuilder] the SQL syntax for a column that represents the same values from the INSERT clause\n of an [upsert] command, which should be used in the UPDATE clause.\n\n @param columnName Name of the column for update.\n @param queryBuilder Query builder to append the SQL syntax to.\n
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#insertValue().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#insertValue().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#insertValue().
//                         ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(columnName)
//                                    display_name columnName
//                                    documentation ```kotlin\ncolumnName: String\n```
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(queryBuilder)
//                                                                                          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                                                               ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(columnName)
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(columnName)
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().(queryBuilder)
//                                                                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#insertValue().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
      /**
       * Returns the SQL command that deletes one or more rows of a table.
       *
       * **Note:** The `ignore` parameter is not supported by all vendors, please check the documentation.
       *
       * @param ignore Whether to ignore errors or not.
       * @param table Table to delete rows from.
       * @param where Condition that decides the rows to delete.
       * @param limit Maximum number of rows to delete.
       * @param transaction Transaction where the operation is executed.
       */
      open fun delete(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                    display_name delete
//                    documentation ```kotlin\npublic open fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that deletes one or more rows of a table.\n\n **Note:** The `ignore` parameter is not supported by all vendors, please check the documentation.\n\n @param ignore Whether to ignore errors or not.\n @param table Table to delete rows from.\n @param where Condition that decides the rows to delete.\n @param limit Maximum number of rows to delete.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(table)
          table: Table,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(table)
//              display_name table
//              documentation ```kotlin\ntable: Table\n```
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(table)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(where)
          where: String?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(where)
//              display_name where
//              documentation ```kotlin\nwhere: String?\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          if (ignore) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(ignore)
              transaction.throwUnsupportedException("There's no generic SQL for DELETE IGNORE. There must be vendor specific implementation.")
//            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(transaction)
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
          }
          return buildString {
//               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append("DELETE FROM ")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              append(transaction.identity(table))
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(transaction)
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(table)
              if (where != null) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(where)
                  append(" WHERE ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                  append(where)
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(where)
              }
              if (limit != null) {
//                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(limit)
                  append(" LIMIT ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                  append(limit)
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().(limit)
              }
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
      /**
       * Returns the SQL command that deletes one or more rows from a table in a join relation.
       *
       * **Note:** The `ignore` and `limit` parameters are not supported by all vendors; please check the documentation.
       *
       * @param ignore Whether to ignore errors or not.
       * @param targets Join to delete rows from.
       * @param targetTables Specific tables in the join to delete rows from.
       * @param where Condition that decides the rows to delete.
       * @param limit Maximum number of rows to delete.
       * @param transaction Transaction where the operation is executed.
       */
      open fun delete(
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
//                    display_name delete
//                    documentation ```kotlin\npublic open fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that deletes one or more rows from a table in a join relation.\n\n **Note:** The `ignore` and `limit` parameters are not supported by all vendors; please check the documentation.\n\n @param ignore Whether to ignore errors or not.\n @param targets Join to delete rows from.\n @param targetTables Specific tables in the join to delete rows from.\n @param where Condition that decides the rows to delete.\n @param limit Maximum number of rows to delete.\n @param transaction Transaction where the operation is executed.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#delete().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#delete(+1).
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#delete(+1).
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#delete().
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(ignore)
          ignore: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(ignore)
//               display_name ignore
//               documentation ```kotlin\nignore: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(ignore)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targets)
          targets: Join,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targets)
//                display_name targets
//                documentation ```kotlin\ntargets: Join\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targets)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targetTables)
          targetTables: List<Table>,
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targetTables)
//                     display_name targetTables
//                     documentation ```kotlin\ntargetTables: List<Table>\n```
//                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(targetTables)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(where)
          where: Op<Boolean>?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(where)
//              display_name where
//              documentation ```kotlin\nwhere: Op<Boolean>?\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(where)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(limit)
          limit: Int?,
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(limit)
//              display_name limit
//              documentation ```kotlin\nlimit: Int?\n```
//               ^^^^ reference semanticdb maven . . kotlin/Int#
//                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(limit)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(transaction)
      ): String = transaction.throwUnsupportedException("DELETE from a join relation is unsupported")
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).(transaction)
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
//                                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
      /**
       * Returns the SQL command that limits and offsets the result of a query.
       *
       * @param size The limit of rows to return.
       * @param offset The number of rows to skip.
       * @param alreadyOrdered Whether the query is already ordered or not.
       */
//                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
//                                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(offset)
//                                                           ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(alreadyOrdered)
      open fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String = buildString {
//             ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                 display_name queryLimitAndOffset
//                                 documentation ```kotlin\npublic open fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String\n```\n\n----\n\n\n Returns the SQL command that limits and offsets the result of a query.\n\n @param size The limit of rows to return.\n @param offset The number of rows to skip.\n @param alreadyOrdered Whether the query is already ordered or not.\n
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlFunctionProvider#queryLimitAndOffset().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#queryLimitAndOffset().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#queryLimitAndOffset().
//                                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
//                                      display_name size
//                                      documentation ```kotlin\nsize: Int?\n```
//                                       ^^^^ reference semanticdb maven . . kotlin/Int#
//                                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(offset)
//                                                    display_name offset
//                                                    documentation ```kotlin\noffset: Long\n```
//                                                     ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                                                                          display_name alreadyOrdered
//                                                                          documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
//                                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(offset)
//                                                                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                  ⌄ enclosing_range_start local 57
          size?.let {
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
//              ^^^ reference semanticdb maven . . kotlin/let().
//                  ^ definition local 57 2:9
//                    display_name it
//                    documentation ```kotlin\nit: Int\n```
              append("LIMIT $size")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
          }
//        ⌃ enclosing_range_end local 57
          if (offset > 0) {
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(offset)
//                   ^ reference semanticdb maven . . kotlin/Long#compareTo(+2).
//                       ⌄ enclosing_range_start local 58
              size?.also { append(" ") }
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(size)
//                  ^^^^ reference semanticdb maven . . kotlin/also().
//                       ^^^^^^^^^^^^^^^ definition local 58
//                                       display_name it
//                                       documentation ```kotlin\nit: Int\n```
//                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                     ⌃ enclosing_range_end local 58
              append("OFFSET $offset")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().(offset)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().
      @Deprecated(
          "This function will be removed in future releases.",
          ReplaceWith("queryLimitAndOffset(size, offset, alreadyOrdered)"),
//        ^^^^^^^^^^^ reference semanticdb maven . . kotlin/ReplaceWith#`<init>`().
          DeprecationLevel.ERROR
//                         ^^^^^ reference semanticdb maven . . kotlin/DeprecationLevel#ERROR.
      )
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(size)
//                                   ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(offset)
//                                                 ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(alreadyOrdered)
      open fun queryLimit(size: Int, offset: Long, alreadyOrdered: Boolean): String = queryLimitAndOffset(size, offset, alreadyOrdered)
//             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().
//                        display_name queryLimit
//                        documentation ```kotlin\n@Deprecated(...) public open fun queryLimit(size: Int, offset: Long, alreadyOrdered: Boolean): String\n```
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(size)
//                             display_name size
//                             documentation ```kotlin\nsize: Int\n```
//                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(offset)
//                                          display_name offset
//                                          documentation ```kotlin\noffset: Long\n```
//                                           ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(alreadyOrdered)
//                                                                display_name alreadyOrdered
//                                                                documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                                                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(size)
//                                                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(offset)
//                                                                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(alreadyOrdered)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(size)
//                                              ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(offset)
//                                                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().(alreadyOrdered)
//                                                                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimit().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
      /**
       * Returns the SQL command that obtains information about a statement execution plan.
       *
       * @param analyze Whether [internalStatement] should also be executed.
       * @param options Optional string of comma-separated parameters specific to the database.
       * @param internalStatement SQL string representing the statement to get information about.
       * @param transaction Transaction where the operation is executed.
       */
      open fun explain(
//             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
//                     display_name explain
//                     documentation ```kotlin\npublic open fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that obtains information about a statement execution plan.\n\n @param analyze Whether [internalStatement] should also be executed.\n @param options Optional string of comma-separated parameters specific to the database.\n @param internalStatement SQL string representing the statement to get information about.\n @param transaction Transaction where the operation is executed.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2FunctionProvider#explain().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#explain().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleFunctionProvider#explain().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#explain().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#explain().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(analyze)
          analyze: Boolean,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(analyze)
//                display_name analyze
//                documentation ```kotlin\nanalyze: Boolean\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(analyze)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(options)
          options: String?,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(options)
//                display_name options
//                documentation ```kotlin\noptions: String?\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(options)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(internalStatement)
          internalStatement: String,
//        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(internalStatement)
//                          display_name internalStatement
//                          documentation ```kotlin\ninternalStatement: String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(internalStatement)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          return buildString {
//               ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append("EXPLAIN ")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              if (analyze) {
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(analyze)
                  append("ANALYZE ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
//                         ⌄ enclosing_range_start local 59
              options?.let {
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(options)
//                     ^^^ reference semanticdb maven . . kotlin/let().
//                         ^ definition local 59 2:13
//                           display_name it
//                           documentation ```kotlin\nit: String\n```
                  appendOptionsToExplain(it)
//                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
//                                       ^^ reference local 59
              }
//            ⌃ enclosing_range_end local 59
              append(internalStatement)
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().(internalStatement)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
      /** Appends optional parameters to an EXPLAIN query. */
//                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().(options)
      protected open fun StringBuilder.appendOptionsToExplain(options: String) {
//                                     ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
//                                                            display_name appendOptionsToExplain
//                                                            documentation ```kotlin\nprotected open fun {kotlin/text/StringBuilder=} StringBuilder.appendOptionsToExplain(options: String): Unit\n```\n\n----\n\n Appends optional parameters to an EXPLAIN query.
//                                                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#appendOptionsToExplain().
//                                                            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().(options)
//                                                                    display_name options
//                                                                    documentation ```kotlin\noptions: String\n```
//                                                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().(options)
          append("$options ")
//        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().(options)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendOptionsToExplain().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
      /**
       * Returns the SQL command that performs an insert, update, or delete, and also returns data from any modified rows.
       *
       * **Note:** This operation is not supported by all vendors, please check the documentation.
       *
       * @param mainSql SQL string representing the underlying statement before appending a RETURNING clause.
       * @param returning Columns and expressions to include in the returned result set.
       * @param transaction Transaction where the operation is executed.
       */
      open fun returning(
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
//                       display_name returning
//                       documentation ```kotlin\npublic open fun returning(mainSql: String, returning: List<Expression<*>>, transaction: Transaction): String\n```\n\n----\n\n\n Returns the SQL command that performs an insert, update, or delete, and also returns data from any modified rows.\n\n **Note:** This operation is not supported by all vendors, please check the documentation.\n\n @param mainSql SQL string representing the underlying statement before appending a RETURNING clause.\n @param returning Columns and expressions to include in the returned result set.\n @param transaction Transaction where the operation is executed.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBFunctionProvider#returning().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLFunctionProvider#returning().
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteFunctionProvider#returning().
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(mainSql)
          mainSql: String,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(mainSql)
//                display_name mainSql
//                documentation ```kotlin\nmainSql: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(mainSql)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(returning)
          returning: List<Expression<*>>,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(returning)
//                  display_name returning
//                  documentation ```kotlin\nreturning: List<Expression<*>>\n```
//                   ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(returning)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(transaction)
          transaction: Transaction
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(transaction)
//                    display_name transaction
//                    documentation ```kotlin\ntransaction: Transaction\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(transaction)
      ): String {
//       ^^^^^^ reference semanticdb maven . . kotlin/String#
          transaction.throwUnsupportedException(
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().(transaction)
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
              "There's no generic SQL for a command with a RETURNING clause. There must be a vendor specific implementation."
          )
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#returning().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().
  @Suppress("NestedBlockDepth", "CyclomaticComplexMethod")
//                                                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                                                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(table)
//                                                                                            ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(clauses)
  private fun QueryBuilder.addClausesToMergeStatement(transaction: Transaction, table: Table, clauses: List<MergeStatement.Clause>) {
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().
//                                                    display_name addClausesToMergeStatement
//                                                    documentation ```kotlin\n@Suppress(...) private final fun QueryBuilder.addClausesToMergeStatement(transaction: Transaction, table: Table, clauses: List<MergeStatement.Clause>): Unit\n```
//                                                    ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                                                display_name transaction
//                                                                documentation ```kotlin\ntransaction: Transaction\n```
//                                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                              ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(table)
//                                                                                    display_name table
//                                                                                    documentation ```kotlin\ntable: Table\n```
//                                                                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                                                            ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(clauses)
//                                                                                                    display_name clauses
//                                                                                                    documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(table)
//                                                                                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(clauses)
//    ⌄ enclosing_range_start local 60
//                                      ⌄ enclosing_range_start local 61
//                                                         ⌄ enclosing_range_start local 62
      fun QueryBuilder.appendValueAlias(column: Column<*>, value: Any?) {
//                     ^^^^^^^^^^^^^^^^ definition local 60
//                                      display_name appendValueAlias
//                                      documentation ```kotlin\nlocal final fun QueryBuilder.appendValueAlias(column: Column<*>, value: Any?): Unit\n```
//                                      ^^^^^^ definition local 61
//                                             display_name column
//                                             documentation ```kotlin\ncolumn: Column<*>\n```
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                         ^^^^^ definition local 62
//                                                               display_name value
//                                                               documentation ```kotlin\nvalue: Any?\n```
//                                                                ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                      ⌃ enclosing_range_end local 61
//                                                                   ⌃ enclosing_range_end local 62
//              ⌄ enclosing_range_start local 63
          when (value) {
//              ^^^^^ reference local 62
//              ^^^^^ definition local 63
//                    display_name <when-subject>
//                    documentation ```kotlin\nlocal val <when-subject>: Any?\n```
//                  ⌃ enclosing_range_end local 63
              is Column<*> -> {
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                ⌄ enclosing_range_start local 64
                  val aliasExpression = transaction.fullIdentity(value)
//                    ^^^^^^^^^^^^^^^ definition local 64
//                                    display_name aliasExpression
//                                    documentation ```kotlin\nlocal val aliasExpression: String\n```
//                                      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                                               ^^^^^ reference local 62
//                                                                    ⌃ enclosing_range_end local 64
                  append(aliasExpression)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^^^^^ reference local 64
              }
  
              is Expression<*> -> {
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                ⌄ enclosing_range_start local 65
                  val aliasExpression = value.toString()
//                    ^^^^^^^^^^^^^^^ definition local 65
//                                    display_name aliasExpression
//                                    documentation ```kotlin\nlocal val aliasExpression: String\n```
//                                      ^^^^^ reference local 62
//                                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                                                     ⌃ enclosing_range_end local 65
                  append(aliasExpression)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                       ^^^^^^^^^^^^^^^ reference local 65
              }
  
              else -> registerArgument(column.columnType, value)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                                     ^^^^^^ reference local 61
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^ reference local 62
          }
      }
//    ⌃ enclosing_range_end local 60
  
//    ⌄ enclosing_range_start local 66
      val autoIncColumn = table.autoIncColumn
//        ^^^^^^^^^^^^^ definition local 66
//                      display_name autoIncColumn
//                      documentation ```kotlin\nlocal val autoIncColumn: Column<*>?\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(table)
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#autoIncColumn.
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getAutoIncColumn().
//                                          ⌃ enclosing_range_end local 66
  
//                      ⌄ enclosing_range_start local 67
      clauses.forEach { clause ->
//    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(clauses)
//            ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                      ^^^^^^ definition local 67
//                             display_name clause
//                             documentation ```kotlin\nclause: MergeStatement.Clause\n```
//                           ⌃ enclosing_range_end local 67
//        ⌄ enclosing_range_start local 68
          val whenMatchedOrNotPrefix = if (clause.type == MergeStatement.ClauseCondition.MATCHED) "WHEN MATCHED " else "WHEN NOT MATCHED "
//            ^^^^^^^^^^^^^^^^^^^^^^ definition local 68
//                                   display_name whenMatchedOrNotPrefix
//                                   documentation ```kotlin\nlocal val whenMatchedOrNotPrefix: String\n```
//                                         ^^^^^^ reference local 67
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getType().
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#type.
//                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseCondition#MATCHED.
//                                                                                                                                       ⌃ enclosing_range_end local 68
//        ⌄ enclosing_range_start local 69
          val defaultValuesStatementSupported = currentDialect !is H2Dialect
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 69
//                                            display_name defaultValuesStatementSupported
//                                            documentation ```kotlin\nlocal val defaultValuesStatementSupported: Boolean\n```
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                                                                         ⌃ enclosing_range_end local 69
//              ⌄ enclosing_range_start local 70
          when (clause.action) {
//              ^^^^^^ reference local 67
//              ^^^^^^^^^^^^^ definition local 70
//                            display_name <when-subject>
//                            documentation ```kotlin\nlocal val <when-subject>: MergeStatement.ClauseAction\n```
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                          ⌃ enclosing_range_end local 70
              MergeStatement.ClauseAction.INSERT -> {
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#INSERT.
//                ⌄ enclosing_range_start local 71
//                                                                                                    ⌄ enclosing_range_start local 72
//                                                                                                                                             ⌄ enclosing_range_start local 73
                  val nextValExpression = autoIncColumn?.autoIncColumnType?.nextValExpression?.takeIf { autoIncColumn !in clause.arguments.map { it.first } }
//                    ^^^^^^^^^^^^^^^^^ definition local 71
//                                      display_name nextValExpression
//                                      documentation ```kotlin\nlocal val nextValExpression: NextVal<*>?\n```
//                                        ^^^^^^^^^^^^^ reference local 66
//                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                                       ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
//                                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getNextValExpression().
//                                                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#nextValExpression.
//                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/takeIf().
//                                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 72
//                                                                                                                                                            display_name it
//                                                                                                                                                            documentation ```kotlin\nit: NextVal<*>\n```
//                                                                                                      ^^^^^^^^^^^^^ reference local 66
//                                                                                                                    ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                                                    ^^^ reference semanticdb maven . . kotlin/collections/List#contains().
//                                                                                                                        ^^^^^^ reference local 67
//                                                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//                                                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                                                                                                                                         ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                                                                                                                             ^^^^^^^^^^^^ definition local 73
//                                                                                                                                                          display_name it
//                                                                                                                                                          documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
//                                                                                                                                               ^^ reference local 73
//                                                                                                                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                                                                                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                                                                                                                        ⌃ enclosing_range_end local 73
//                                                                                                                                                          ⌃ enclosing_range_end local 71
//                                                                                                                                                          ⌃ enclosing_range_end local 72
  
//                ⌄ enclosing_range_start local 74
                  val extraArg = if (nextValExpression != null) listOf(autoIncColumn to nextValExpression) else emptyList()
//                    ^^^^^^^^ definition local 74
//                             display_name extraArg
//                             documentation ```kotlin\nlocal val extraArg: List<Pair<Column<*>, NextVal<*>>>\n```
//                                   ^^^^^^^^^^^^^^^^^ reference local 71
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                     ^^^^^^^^^^^^^ reference local 66
//                                                                                   ^^ reference semanticdb maven . . kotlin/to().
//                                                                                      ^^^^^^^^^^^^^^^^^ reference local 71
//                                                                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
//                                                                                                                        ⌃ enclosing_range_end local 74
  
//                ⌄ enclosing_range_start local 75
                  val allArguments = clause.arguments + extraArg
//                    ^^^^^^^^^^^^ definition local 75
//                                 display_name allArguments
//                                 documentation ```kotlin\nlocal val allArguments: List<Pair<Column<*>, Any?>>\n```
//                                   ^^^^^^ reference local 67
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                                                    ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                      ^^^^^^^^ reference local 74
//                                                             ⌃ enclosing_range_end local 75
                  +whenMatchedOrNotPrefix
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference local 68
                  if (currentDialect !is OracleDialect) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                    ⌄ enclosing_range_start local 76
                      clause.and?.let { append("AND ($it) ") }
//                    ^^^^^^ reference local 67
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 76
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Op<Boolean>\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                    ^^ reference local 76
//                                                           ⌃ enclosing_range_end local 76
                  }
                  +"THEN INSERT "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  if (allArguments.isNotEmpty() || !defaultValuesStatementSupported) {
//                    ^^^^^^^^^^^^ reference local 75
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                 ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 69
//                                      ⌄ enclosing_range_start local 77
//                                                                                              ⌄ enclosing_range_start local 78
                      +allArguments.map { it.first }.joinToString(prefix = "(", postfix = ") ") {
//                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                     ^^^^^^^^^^^^ reference local 75
//                                  ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                      ^^^^^^^^^^^^ definition local 77
//                                                   display_name it
//                                                   documentation ```kotlin\nit: Pair<Column<*>, Any?>\n```
//                                        ^^ reference local 77
//                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                              ^ definition local 78 2:21
//                                                                                                display_name it
//                                                                                                documentation ```kotlin\nit: Column<*>\n```
//                                                 ⌃ enclosing_range_end local 77
                          transaction.identity(it)
//                        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                             ^^ reference local 78
                      }
//                    ⌃ enclosing_range_end local 78
                  }
                  if (clause.overridingSystemValue) {
//                    ^^^^^^ reference local 67
//                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingSystemValue().
//                           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingSystemValue.
                      +"OVERRIDING SYSTEM VALUE"
//                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  }
                  if (clause.overridingUserValue) {
//                    ^^^^^^ reference local 67
//                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getOverridingUserValue().
//                           ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#overridingUserValue.
                      +"OVERRIDING USER VALUE"
//                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  }
                  if (allArguments.isNotEmpty() || !defaultValuesStatementSupported) {
//                    ^^^^^^^^^^^^ reference local 75
//                                 ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                                 ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference local 69
//                                                                                  ⌄ enclosing_range_start local 79
//                                                                                   ⌄ enclosing_range_start local 80
//                                                                                           ⌄ enclosing_range_start local 81
                      allArguments.appendTo(prefix = " VALUES (", postfix = ") ") { (column, value) ->
//                    ^^^^^^^^^^^^ reference local 75
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                                                  ^^^^^^^^^^^^^^^ definition local 79
//                                                                                                  display_name <destruct>
//                                                                                                  documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                                                   ^^^^^^ reference local 79
//                                                                                   ^^^^^^ definition local 80
//                                                                                          display_name column
//                                                                                          documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                                           ^^^^^ reference local 79
//                                                                                           ^^^^^ definition local 81
//                                                                                                 display_name value
//                                                                                                 documentation ```kotlin\nlocal val value: Any?\n```
//                                                                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                                        ⌃ enclosing_range_end local 80
//                                                                                               ⌃ enclosing_range_end local 81
//                                                                                                ⌃ enclosing_range_end local 79
                          appendValueAlias(column, value)
//                        ^^^^^^^^^^^^^^^^ reference local 60
//                                         ^^^^^^ reference local 80
//                                                 ^^^^^ reference local 81
                      }
                  } else {
                      +"DEFAULT VALUES"
//                    ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                  }
                  if (currentDialect is OracleDialect) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                    ⌄ enclosing_range_start local 82
                      clause.and?.let { append("WHERE ($it) ") }
//                    ^^^^^^ reference local 67
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 82
//                                                               display_name it
//                                                               documentation ```kotlin\nit: Op<Boolean>\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                      ^^ reference local 82
//                                                             ⌃ enclosing_range_end local 82
                  }
              }
  
              MergeStatement.ClauseAction.UPDATE -> {
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#UPDATE.
                  +whenMatchedOrNotPrefix
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference local 68
                  if (currentDialect !is OracleDialect) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                    ⌄ enclosing_range_start local 83
                      clause.and?.let { append("AND ($it) ") }
//                    ^^^^^^ reference local 67
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 83
//                                                             display_name it
//                                                             documentation ```kotlin\nit: Op<Boolean>\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                    ^^ reference local 83
//                                                           ⌃ enclosing_range_end local 83
                  }
                  +"THEN UPDATE SET "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                           ⌄ enclosing_range_start local 84
//                                                            ⌄ enclosing_range_start local 85
//                                                                    ⌄ enclosing_range_start local 86
                  clause.arguments.appendTo(postfix = " ") { (column, expression) ->
//                ^^^^^^ reference local 67
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#arguments.
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getArguments().
//                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                           ^^^^^^^^^^^^^^^^^^^^ definition local 84
//                                                                                display_name <destruct>
//                                                                                documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                            ^^^^^^ reference local 84
//                                                            ^^^^^^ definition local 85
//                                                                   display_name column
//                                                                   documentation ```kotlin\nlocal val column: Column<*>\n```
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                                    ^^^^^^^^^^ reference local 84
//                                                                    ^^^^^^^^^^ definition local 86
//                                                                               display_name expression
//                                                                               documentation ```kotlin\nlocal val expression: Any?\n```
//                                                                    ^^^^^^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                                                 ⌃ enclosing_range_end local 85
//                                                                             ⌃ enclosing_range_end local 86
//                                                                              ⌃ enclosing_range_end local 84
                      append("${transaction.identity(column)}=")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().(transaction)
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                   ^^^^^^ reference local 85
                      appendValueAlias(column, expression)
//                    ^^^^^^^^^^^^^^^^ reference local 60
//                                     ^^^^^^ reference local 85
//                                             ^^^^^^^^^^ reference local 86
                  }
                  if (currentDialect is OracleDialect) {
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                                    ⌄ enclosing_range_start local 87
                      clause.and?.let { append("WHERE ($it) ") }
//                    ^^^^^^ reference local 67
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                           ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                                ^^^ reference semanticdb maven . . kotlin/let().
//                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 87
//                                                               display_name it
//                                                               documentation ```kotlin\nit: Op<Boolean>\n```
//                                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                      ^^ reference local 87
//                                                             ⌃ enclosing_range_end local 87
                  }
//                                        ⌄ enclosing_range_start local 88
                  clause.deleteWhere?.let {
//                ^^^^^^ reference local 67
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#deleteWhere.
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getDeleteWhere().
//                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                        ^ definition local 88 2:17
//                                          display_name it
//                                          documentation ```kotlin\nit: Op<Boolean>\n```
                      append("DELETE WHERE $it")
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                          ^^ reference local 88
                  }
//                ⌃ enclosing_range_end local 88
              }
  
              MergeStatement.ClauseAction.DELETE -> {
//                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DELETE.
                  +whenMatchedOrNotPrefix
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference local 68
//                                ⌄ enclosing_range_start local 89
                  clause.and?.let { append("AND ($it) ") }
//                ^^^^^^ reference local 67
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 89
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Op<Boolean>\n```
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                ^^ reference local 89
//                                                       ⌃ enclosing_range_end local 89
                  +"THEN DELETE "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              }
  
              MergeStatement.ClauseAction.DO_NOTHING -> {
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DO_NOTHING.
                  +whenMatchedOrNotPrefix
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                 ^^^^^^^^^^^^^^^^^^^^^^ reference local 68
//                                ⌄ enclosing_range_start local 90
                  clause.and?.let { append("AND ($it) ") }
//                ^^^^^^ reference local 67
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#and.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAnd().
//                            ^^^ reference semanticdb maven . . kotlin/let().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^ definition local 90
//                                                         display_name it
//                                                         documentation ```kotlin\nit: Op<Boolean>\n```
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                ^^ reference local 90
//                                                       ⌃ enclosing_range_end local 90
                  +"THEN DO NOTHING "
//                ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
              }
          }
      }
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/addClausesToMergeStatement().
