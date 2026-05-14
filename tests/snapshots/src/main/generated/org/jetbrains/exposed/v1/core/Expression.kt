  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.statements.DefaultValueMarker
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                                ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DefaultValueMarker#
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  /**
   * An object to which SQL expressions and values can be appended.
   */
//                  ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
  class QueryBuilder(
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                   display_name QueryBuilder
//                   documentation ```kotlin\npublic final class QueryBuilder : Any\n```\n\n----\n\n\n An object to which SQL expressions and values can be appended.\n
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                   display_name QueryBuilder
//                   documentation ```kotlin\npublic constructor(prepared: Boolean): QueryBuilder\n```\n\n----\n\n Whether the query is parameterized or not.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().(prepared)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
      /** Whether the query is parameterized or not. */
      val prepared: Boolean
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().(prepared)
//                 display_name prepared
//                 documentation ```kotlin\nprepared: Boolean\n```\n\n----\n\n Whether the query is parameterized or not.
//        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().(prepared)
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
//                 display_name prepared
//                 documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the query is parameterized or not.
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
//                 display_name prepared
//                 documentation ```kotlin\npublic final val prepared: Boolean\n```\n\n----\n\n Whether the query is parameterized or not.
//                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().(prepared)
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
  ) {
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
      private val internalBuilder = StringBuilder()
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                                display_name internalBuilder
//                                documentation ```kotlin\nprivate get(): {kotlin/text/StringBuilder=} StringBuilder\n```
//                ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                display_name internalBuilder
//                                documentation ```kotlin\nprivate final val internalBuilder: {kotlin/text/StringBuilder=} StringBuilder\n```
//                                  ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#`<init>`().
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
      private val _args = mutableListOf<Pair<IColumnType<*>, Any?>>()
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//                      display_name _args
//                      documentation ```kotlin\nprivate final val _args: MutableList<Pair<IColumnType<*>, Any?>>\n```
//                ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
//                      display_name _args
//                      documentation ```kotlin\nprivate get(): MutableList<Pair<IColumnType<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
      /** Returns the list of arguments used in this query. */
//                                               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
      val args: List<Pair<IColumnType<*>, Any?>> get() = _args
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//             display_name args
//             documentation ```kotlin\npublic final val args: List<Pair<IColumnType<*>, Any?>>\n```\n\n----\n\n Returns the list of arguments used in this query.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                               ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
//                                                   display_name args
//                                                   documentation ```kotlin\npublic get(): List<Pair<IColumnType<*>, Any?>>\n```
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//                                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#args.
//                                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getArgs().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().(body)
      operator fun invoke(body: QueryBuilder.() -> Unit): Unit = body()
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                        display_name invoke
//                        documentation ```kotlin\npublic final operator fun invoke(body: QueryBuilder.() -> Unit): Unit\n```
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().(body)
//                             display_name body
//                             documentation ```kotlin\nbody: QueryBuilder.() -> Unit\n```
//                              ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                        ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                               ^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().(body)
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().(body)
//                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
      /** Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().[T]
      fun <T> Iterable<T>.appendTo(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                 display_name appendTo
//                                 documentation ```kotlin\npublic final fun <T> Iterable<T>.appendTo(separator: CharSequence = ..., prefix: CharSequence = ..., postfix: CharSequence = ..., transform: QueryBuilder.(T) -> Unit): Unit\n```\n\n----\n\n Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(separator)
          separator: CharSequence = ", ",
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(separator)
//                  display_name separator
//                  documentation ```kotlin\nseparator: CharSequence = ...\n```
//                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(separator)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(prefix)
          prefix: CharSequence = "",
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: CharSequence = ...\n```
//                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(prefix)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(postfix)
          postfix: CharSequence = "",
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(postfix)
//                display_name postfix
//                documentation ```kotlin\npostfix: CharSequence = ...\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(postfix)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(transform)
          transform: QueryBuilder.(T) -> Unit
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(transform)
//                  display_name transform
//                  documentation ```kotlin\ntransform: QueryBuilder.(T) -> Unit\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(transform)
      ) {
          internalBuilder.append(prefix)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(prefix)
//                         ⌄ enclosing_range_start local 0
//                                ⌄ enclosing_range_start local 1
          forEachIndexed { index, element ->
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed(+9).
//                         ^^^^^ definition local 0
//                               display_name index
//                               documentation ```kotlin\nindex: Int\n```
//                                ^^^^^^^ definition local 1
//                                        display_name element
//                                        documentation ```kotlin\nelement: T\n```
//                             ⌃ enclosing_range_end local 0
//                                      ⌃ enclosing_range_end local 1
              if (index > 0) internalBuilder.append(separator)
//                ^^^^^ reference local 0
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(separator)
              transform(element)
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(transform)
//                      ^^^^^^^ reference local 1
          }
          internalBuilder.append(postfix)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().(postfix)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
      /** Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).[T]
      fun <T> Array<T>.appendTo(
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//                     ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                              display_name appendTo
//                              documentation ```kotlin\npublic final fun <T> Array<T>.appendTo(separator: CharSequence = ..., prefix: CharSequence = ..., postfix: CharSequence = ..., transform: QueryBuilder.(T) -> Unit): Unit\n```\n\n----\n\n Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).[T]
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(separator)
          separator: CharSequence = ", ",
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(separator)
//                  display_name separator
//                  documentation ```kotlin\nseparator: CharSequence = ...\n```
//                   ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(separator)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(prefix)
          prefix: CharSequence = "",
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(prefix)
//               display_name prefix
//               documentation ```kotlin\nprefix: CharSequence = ...\n```
//                ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(prefix)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(postfix)
          postfix: CharSequence = "",
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(postfix)
//                display_name postfix
//                documentation ```kotlin\npostfix: CharSequence = ...\n```
//                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(postfix)
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(transform)
          transform: QueryBuilder.(T) -> Unit
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(transform)
//                  display_name transform
//                  documentation ```kotlin\ntransform: QueryBuilder.(T) -> Unit\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(transform)
      ) {
          internalBuilder.append(prefix)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(prefix)
//                         ⌄ enclosing_range_start local 2
//                                ⌄ enclosing_range_start local 3
          forEachIndexed { index, element ->
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/forEachIndexed().
//                         ^^^^^ definition local 2
//                               display_name index
//                               documentation ```kotlin\nindex: Int\n```
//                                ^^^^^^^ definition local 3
//                                        display_name element
//                                        documentation ```kotlin\nelement: T\n```
//                             ⌃ enclosing_range_end local 2
//                                      ⌃ enclosing_range_end local 3
              if (index > 0) internalBuilder.append(separator)
//                ^^^^^ reference local 2
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(separator)
              transform(element)
//            ^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#invoke().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(transform)
//                      ^^^^^^^ reference local 3
          }
          internalBuilder.append(postfix)
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).(postfix)
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
      /** Appends the specified [value] to this [QueryBuilder]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().(value)
      fun append(value: Char): QueryBuilder = apply { internalBuilder.append(value) }
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
//               display_name append
//               documentation ```kotlin\npublic final fun append(value: Char): QueryBuilder\n```\n\n----\n\n Appends the specified [value] to this [QueryBuilder].
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Char\n```
//                      ^^^^ reference semanticdb maven . . kotlin/Char#
//                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                            ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                                                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().(value)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().(value)
//                                                                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
      /** Appends the specified [value] to this [QueryBuilder]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).(value)
      fun append(value: String): QueryBuilder = apply { internalBuilder.append(value) }
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//               display_name append
//               documentation ```kotlin\npublic final fun append(value: String): QueryBuilder\n```\n\n----\n\n Appends the specified [value] to this [QueryBuilder].
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: String\n```
//                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                              ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                                                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).(value)
//                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).(value)
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
      /** Appends the specified [value] to this [QueryBuilder]. */
//               ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).(value)
      fun append(value: Expression<*>): QueryBuilder = apply(value::toQueryBuilder)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//               display_name append
//               documentation ```kotlin\npublic final fun append(value: Expression<*>): QueryBuilder\n```\n\n----\n\n Appends the specified [value] to this [QueryBuilder].
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: Expression<*>\n```
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).(value)
//                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).(value)
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus().
      /** Appends the receiver [Char] to this [QueryBuilder]. */
      operator fun Char.unaryPlus(): QueryBuilder = append(this)
//                      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus().
//                                display_name unaryPlus
//                                documentation ```kotlin\npublic final operator fun Char.unaryPlus(): QueryBuilder\n```\n\n----\n\n Appends the receiver [Char] to this [QueryBuilder].
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
//                                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
      /** Appends the receiver [String] to this [QueryBuilder]. */
      operator fun String.unaryPlus(): QueryBuilder = append(this)
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                  display_name unaryPlus
//                                  documentation ```kotlin\npublic final operator fun String.unaryPlus(): QueryBuilder\n```\n\n----\n\n Appends the receiver [String] to this [QueryBuilder].
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
      /** Appends the receiver [Expression] to this [QueryBuilder]. */
      operator fun Expression<*>.unaryPlus(): QueryBuilder = append(this)
//                               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//                                         display_name unaryPlus
//                                         documentation ```kotlin\npublic final operator fun Expression<*>.unaryPlus(): QueryBuilder\n```\n\n----\n\n Appends the receiver [Expression] to this [QueryBuilder].
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
      /** Adds the specified [argument] as a value of the specified [column]. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().[T]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(column)
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
      fun <T> registerArgument(column: Column<*>, argument: T) {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                             display_name registerArgument
//                             documentation ```kotlin\npublic final fun <T> registerArgument(column: Column<*>, argument: T): Unit\n```\n\n----\n\n Adds the specified [argument] as a value of the specified [column].
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(column)
//                                    display_name column
//                                    documentation ```kotlin\ncolumn: Column<*>\n```
//                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
//                                                         display_name argument
//                                                         documentation ```kotlin\nargument: T\n```
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().[T]
//                                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(column)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
//              ⌄ enclosing_range_start local 4
          when (argument) {
//              ^^^^^^^^ definition local 4
//                       display_name <when-subject>
//                       documentation ```kotlin\nlocal val <when-subject>: T\n```
//              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
//                     ⌃ enclosing_range_end local 4
              is Expression<*> -> append(argument)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
              DefaultValueMarker -> append(
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                  @OptIn(InternalApi::class)
                  CoreTransactionManager.currentTransaction()
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
                      .db.dialect.dataTypeProvider
//                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                     ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#dialect.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getDialect().
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dataTypeProvider.
//                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDataTypeProvider().
                      .processForDefaultValue(column.dbDefaultValue!!)
//                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(column)
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
              )
              else -> registerArgument(column.columnType, argument)
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(column)
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().(argument)
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
      /** Adds the specified [argument] as a value of the specified [sqlType]. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).[T]
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(sqlType)
//                                                      ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(argument)
      fun <T> registerArgument(sqlType: IColumnType<*>, argument: T): Unit = registerArguments(sqlType, listOf(argument))
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
//                             display_name registerArgument
//                             documentation ```kotlin\npublic final fun <T> registerArgument(sqlType: IColumnType<*>, argument: T): Unit\n```\n\n----\n\n Adds the specified [argument] as a value of the specified [sqlType].
//                             ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(sqlType)
//                                     display_name sqlType
//                                     documentation ```kotlin\nsqlType: IColumnType<*>\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(argument)
//                                                               display_name argument
//                                                               documentation ```kotlin\nargument: T\n```
//                                                                    ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                           ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().
//                                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(sqlType)
//                                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                                                             ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(argument)
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).[T]
//                                                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(sqlType)
//                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).(argument)
//                                                                                                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument(+1).
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().
      /** Adds the specified sequence of [arguments] as values of the specified [sqlType]. */
//         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().[T]
//                              ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
      fun <T> registerArguments(sqlType: IColumnType<*>, arguments: Iterable<T>) {
//         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().[T]
//           display_name FirTypeParameterSymbol T
//           documentation ```kotlin\nT\n```
//            ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().
//                              display_name registerArguments
//                              documentation ```kotlin\npublic final fun <T> registerArguments(sqlType: IColumnType<*>, arguments: Iterable<T>): Unit\n```\n\n----\n\n Adds the specified sequence of [arguments] as values of the specified [sqlType].
//                              ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                      display_name sqlType
//                                      documentation ```kotlin\nsqlType: IColumnType<*>\n```
//                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//                                                                 display_name arguments
//                                                                 documentation ```kotlin\narguments: Iterable<T>\n```
//                                                                  ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
//         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().[T]
//                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                                                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//        ⌄ enclosing_range_start local 5
          val sqlTypeT = (sqlType as IColumnType<T>)
//            ^^^^^^^^ definition local 5
//                     display_name sqlTypeT
//                     documentation ```kotlin\nlocal val sqlTypeT: IColumnType<T>\n```
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                 ⌃ enclosing_range_end local 5
  
          // avoid potentially expensive valueToString call unless we need to sort values
          if (arguments is Collection && arguments.size <= 1) {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Collection#
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Collection#getSize().
//                                                 ^^^^ reference semanticdb maven . . kotlin/collections/Collection#size.
//                                                      ^^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                              ⌄ enclosing_range_start local 6
              arguments.forEach {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//                      ^^^^^^^ reference semanticdb maven . . kotlin/collections/forEach(+10).
//                              ^ definition local 6 7:13
//                                display_name it
//                                documentation ```kotlin\nit: T\n```
                  if (prepared) {
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
                      _args.add(sqlType to it)
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
//                          ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                              ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                      ^^ reference semanticdb maven . . kotlin/to().
//                                         ^^ reference local 6
                      append(sqlTypeT.parameterMarker(it))
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^^ reference local 5
//                                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#parameterMarker().
//                                                    ^^ reference local 6
                  } else {
                      append(sqlTypeT.valueToString(it))
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^^^^^ reference local 5
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                                                  ^^ reference local 6
                  }
              }
//            ⌃ enclosing_range_end local 6
          } else {
//            ⌄ enclosing_range_start local 7
//                         ⌄ enclosing_range_start local 8
              fun toString(value: T) = when {
//                ^^^^^^^^ definition local 7
//                         display_name toString
//                         documentation ```kotlin\nlocal final fun toString(value: T): String\n```
//                         ^^^^^ definition local 8
//                               display_name value
//                               documentation ```kotlin\nvalue: T\n```
//                                ⌃ enclosing_range_end local 8
                  prepared && value is String -> value
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
//                            ^^^^^ reference local 8
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                               ^^^^^ reference local 8
                  else -> sqlTypeT.valueToString(value)
//                        ^^^^^^^^ reference local 5
//                                 ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                                               ^^^^^ reference local 8
              }
//            ⌃ enclosing_range_end local 7
  
//                          ⌄ enclosing_range_start local 9
              arguments.map { it to toString(it) }
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(arguments)
//                      ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                          ^^^^^^^^^^^^^^^^^^^^^^ definition local 9
//                                                 display_name it
//                                                 documentation ```kotlin\nit: T\n```
//                            ^^ reference local 9
//                               ^^ reference semanticdb maven . . kotlin/to().
//                                  ^^^^^^^^ reference local 7
//                                           ^^ reference local 9
//                                               ⌃ enclosing_range_end local 9
//                          ⌄ enclosing_range_start local 10
                  .sortedBy { it.second }
//                 ^^^^^^^^ reference semanticdb maven . . kotlin/collections/sortedBy(+9).
//                          ^^^^^^^^^^^^^ definition local 10
//                                        display_name it
//                                        documentation ```kotlin\nit: Pair<T, String>\n```
//                            ^^ reference local 10
//                               ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                               ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
//                                      ⌃ enclosing_range_end local 10
//                          ⌄ enclosing_range_start local 11
                  .appendTo {
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                          ^ definition local 11 7:17
//                            display_name it
//                            documentation ```kotlin\nit: Pair<T, String>\n```
                      if (prepared) {
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getPrepared().
//                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#prepared.
                          _args.add(sqlType to it.first)
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#_args.
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#get_args().
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().(sqlType)
//                                          ^^ reference semanticdb maven . . kotlin/to().
//                                             ^^ reference local 11
//                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
                          append(sqlTypeT.parameterMarker(it.first))
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                               ^^^^^^^^ reference local 5
//                                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#parameterMarker().
//                                                        ^^ reference local 11
//                                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                           ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
                      } else {
                          append(it.second)
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                               ^^ reference local 11
//                                  ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
                      }
                  }
//                ⌃ enclosing_range_end local 11
          }
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArguments().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
      override fun toString(): String = internalBuilder.toString()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#getInternalBuilder().
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#internalBuilder.
//                                                      ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#toString().
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/append().
  /** Appends all arguments to this [QueryBuilder]. */
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/append().(expr)
  fun QueryBuilder.append(vararg expr: Any): QueryBuilder = apply {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        display_name append
//                        documentation ```kotlin\npublic final fun QueryBuilder.append(vararg expr: Any): QueryBuilder\n```\n\n----\n\n Appends all arguments to this [QueryBuilder].
//                               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/append().(expr)
//                                    display_name expr
//                                    documentation ```kotlin\nvararg expr: Any\n```
//                                     ^^^ reference semanticdb maven . . kotlin/Array#
//                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/append().(expr)
//         ⌄ enclosing_range_start local 13
//                 ⌄ enclosing_range_start local 12
      for (item in expr) {
//         ^^^^ definition local 13
//              display_name item
//              documentation ```kotlin\nlocal val item: Any\n```
//                 ^^^^ definition local 12
//                      display_name <iterator>
//                      documentation ```kotlin\nlocal val <iterator>: Iterator<Any>\n```
//                 ^^^^ reference local 12
//                 ^^^^ reference semanticdb maven . . kotlin/Array#iterator().
//                 ^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                 ^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().(expr)
//            ⌃ enclosing_range_end local 13
//                    ⌃ enclosing_range_end local 12
//              ⌄ enclosing_range_start local 14
          when (item) {
//              ^^^^ reference local 13
//              ^^^^ definition local 14
//                   display_name <when-subject>
//                   documentation ```kotlin\nlocal val <when-subject>: Any\n```
//                 ⌃ enclosing_range_end local 14
              is Char -> append(item)
//               ^^^^ reference semanticdb maven . . kotlin/Char#
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append().
//                              ^^^^ reference local 13
              is String -> append(item)
//               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                ^^^^ reference local 13
              is Expression<*> -> append(item)
//               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                       ^^^^ reference local 13
              else -> throw IllegalArgumentException("Can't append $item as it has unknown type")
//                          ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`().
//                                                                  ^^^^ reference local 13
          }
      }
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/append().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
  /** Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied. */
//     ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().[T]
  fun <T> Iterable<T>.appendTo(
//     ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().[T]
//       display_name FirTypeParameterSymbol T
//       documentation ```kotlin\nT\n```
//                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                             display_name appendTo
//                             documentation ```kotlin\npublic final fun <T> Iterable<T>.appendTo(builder: QueryBuilder, separator: CharSequence = ..., prefix: CharSequence = ..., postfix: CharSequence = ..., transform: QueryBuilder.(T) -> Unit): QueryBuilder\n```\n\n----\n\n Appends all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
//     ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(builder)
      builder: QueryBuilder,
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(builder)
//            display_name builder
//            documentation ```kotlin\nbuilder: QueryBuilder\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(builder)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(separator)
      separator: CharSequence = ", ",
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(separator)
//              display_name separator
//              documentation ```kotlin\nseparator: CharSequence = ...\n```
//               ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                                 ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(separator)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(prefix)
      prefix: CharSequence = "",
//    ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(prefix)
//           display_name prefix
//           documentation ```kotlin\nprefix: CharSequence = ...\n```
//            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                            ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(prefix)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(postfix)
      postfix: CharSequence = "",
//    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(postfix)
//            display_name postfix
//            documentation ```kotlin\npostfix: CharSequence = ...\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/CharSequence#
//                             ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(postfix)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(transform)
      transform: QueryBuilder.(T) -> Unit
//    ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(transform)
//              display_name transform
//              documentation ```kotlin\ntransform: QueryBuilder.(T) -> Unit\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function2#
//                                      ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(transform)
  ): QueryBuilder = builder.apply { this@appendTo.appendTo(separator, prefix, postfix, transform) }
//   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(builder)
//                          ^^^^^ reference semanticdb maven . . kotlin/apply().
//                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo().
//                                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(separator)
//                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(prefix)
//                                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(postfix)
//                                                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().(transform)
//                                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#`<init>`().
  /**
   * Represents an SQL expression of type [T].
   */
//                          ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#[T]
  abstract class Expression<T> {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                          display_name Expression
//                          documentation ```kotlin\npublic abstract class Expression<T> : Any\n```\n\n----\n\n\n Represents an SQL expression of type [T].\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#`<init>`().
//                          display_name Expression
//                          documentation ```kotlin\npublic constructor<T>(): Expression<T>\n```\n\n----\n\n\n Represents an SQL expression of type [T].\n
//                          ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#[T]
//                            display_name FirTypeParameterSymbol T
//                            documentation ```kotlin\nT\n```
//                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#_hashCode.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#get_hashCode().
      private val _hashCode: Int by lazy { toString().hashCode() }
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#_hashCode.
//                          display_name _hashCode
//                          documentation ```kotlin\nprivate final val _hashCode: Int\n```
//                ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#get_hashCode().
//                          display_name _hashCode
//                          documentation ```kotlin\nprivate get(): Int\n```
//                           ^^^ reference semanticdb maven . . kotlin/Int#
//                                  ^^^^ reference semanticdb maven . . kotlin/lazy().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/getValue().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#_hashCode.
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#get_hashCode().
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                                                    ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#_hashCode.
//                                                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#get_hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
      /** Appends the SQL representation of this expression to the specified [queryBuilder]. */
//                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().(queryBuilder)
      abstract fun toQueryBuilder(queryBuilder: QueryBuilder)
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
//                                display_name toQueryBuilder
//                                documentation ```kotlin\npublic abstract fun toQueryBuilder(queryBuilder: QueryBuilder): Unit\n\n```\n\n----\n\n Appends the SQL representation of this expression to the specified [queryBuilder].
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CompositeColumn#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionAlias#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/QueryParameter#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 13554>`#toQueryBuilder().
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 5823>`#toQueryBuilder().
//                                ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().(queryBuilder)
//                                             display_name queryBuilder
//                                             documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().(queryBuilder)
//                                                          ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toQueryBuilder().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().
//                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                  ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
          if (other !is Expression<*>) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
//                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
  
          if (toString() != other.toString()) return false
//            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().(other)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
  
          return true
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#equals().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#hashCode().
      override fun hashCode(): Int = _hashCode
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#_hashCode.
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#get_hashCode().
//                                           ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#hashCode().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
      override fun toString(): String = QueryBuilder(false).append(this).toString()
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
//                                                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
  
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#`<init>`().
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion# 3:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```\n\n----\n\n Builds a new [Expression] using the provided [builder].
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#`<init>`(). 3:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): Expression.Companion\n```\n\n----\n\n Builds a new [Expression] using the provided [builder].
//        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().
          /** Builds a new [Expression] using the provided [builder]. */
//                    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[T]
//                       ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[E]
//                                                ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().(builder)
          inline fun <T, E : Expression<T>> build(builder: SqlExpressionBuilder.() -> E): E = SqlExpressionBuilder.builder()
//                    ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[T]
//                      display_name FirTypeParameterSymbol T
//                      documentation ```kotlin\nT\n```
//                       ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[E]
//                         display_name FirTypeParameterSymbol E
//                         documentation ```kotlin\nE : Expression<T>\n```
//                                          ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().
//                                                display_name build
//                                                documentation ```kotlin\npublic final inline fun <T, E : Expression<T>> build(builder: SqlExpressionBuilder.() -> E): E\n```\n\n----\n\n Builds a new [Expression] using the provided [builder].
//                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().(builder)
//                                                        display_name builder
//                                                        documentation ```kotlin\nbuilder: SqlExpressionBuilder.() -> E\n```
//                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Function1#
//                                                                                                                 ^^^^^^^ reference semanticdb maven . . kotlin/Function1#invoke().
//                                                                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().(builder)
//                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[T]
//                                       ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().[E]
//                                                                                    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().(builder)
//                                                                                                                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().
      }
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#
//    ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#`<init>`().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#`<init>`().
  /**
   * Represents an SQL expression of type [T], but with a specific column type.
   */
//                                        ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#[T]
  abstract class ExpressionWithColumnType<T> : Expression<T>() {
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//                                        display_name ExpressionWithColumnType
//                                        documentation ```kotlin\npublic abstract class ExpressionWithColumnType<T> : Expression<T>\n```\n\n----\n\n\n Represents an SQL expression of type [T], but with a specific column type.\n
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AndBitOp#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhenElse#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnTypeAlias#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ModOp#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/NoOpConversion#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/OrBitOp#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/WindowFunctionDefinition#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/XorBitOp#
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpsertBuilder#InsertValue#
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#`<init>`().
//                                        display_name ExpressionWithColumnType
//                                        documentation ```kotlin\npublic constructor<T>(): ExpressionWithColumnType<T>\n```\n\n----\n\n\n Represents an SQL expression of type [T], but with a specific column type.\n
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#[T]
//                                          display_name FirTypeParameterSymbol T
//                                          documentation ```kotlin\nT\n```
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                        ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#[T]
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
      /** Returns the column type of this expression. Used for operations with literals. */
      abstract val columnType: IColumnType<T & Any>
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                            display_name columnType
//                            documentation ```kotlin\npublic abstract val columnType: IColumnType<T & Any>\n```\n\n----\n\n Returns the column type of this expression. Used for operations with literals.
//                 ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
//                            display_name columnType
//                            documentation ```kotlin\npublic get(): IColumnType<T & Any>\n```\n\n----\n\n Returns the column type of this expression. Used for operations with literals.
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#columnType.
//                                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#getColumnType().
  }
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#`<init>`().
