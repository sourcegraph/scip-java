package org.jetbrains.exposed.v1.core.statements
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/

import org.jetbrains.exposed.v1.core.IColumnType
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
import org.jetbrains.exposed.v1.core.Table
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
import org.jetbrains.exposed.v1.core.Transaction
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
import org.jetbrains.exposed.v1.core.statements.api.ResultApi
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/
//                                                  ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ResultApi#
import java.util.*
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/

internal object DefaultValueMarker {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DefaultValueMarker#
//                                 display_name DefaultValueMarker
//                                 documentation ```kotlin\ninternal final object DefaultValueMarker : Any\n```
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DefaultValueMarker#`<init>`().
//                                 display_name DefaultValueMarker
//                                 documentation ```kotlin\nprivate constructor(): DefaultValueMarker\n```
    override fun toString(): String = "DEFAULT"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DefaultValueMarker#toString().
//                        display_name toString
//                        documentation ```kotlin\npublic open override fun toString(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
}

/**
 * Base class representing an SQL statement that can be executed.
 *
 * @param type The specific [StatementType], usually represented by the leading word in the command syntax.
 * @param targets Tables on which to perform the SQL statement.
 */
abstract class Statement<out T>(val type: StatementType, val targets: List<Table>) {
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                       display_name Statement
//                       documentation ```kotlin\npublic abstract class Statement<out T> : Any\n```\n\n----\n\n\n Base class representing an SQL statement that can be executed.\n\n @param type The specific [StatementType], usually represented by the leading word in the command syntax.\n @param targets Tables on which to perform the SQL statement.\n
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/UpdateBuilder#
//             ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#`<init>`().
//                       display_name Statement
//                       documentation ```kotlin\npublic constructor<out T>(type: StatementType, targets: List<Table>): Statement<T>\n```
//                           ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#[T]
//                             display_name FirTypeParameterSymbol T
//                             documentation ```kotlin\nout T\n```
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#`<init>`().(type)
//                                       display_name type
//                                       documentation ```kotlin\ntype: StatementType\n```
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#`<init>`().(type)
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#getType().
//                                       display_name type
//                                       documentation ```kotlin\npublic get(): StatementType\n```
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#type.
//                                       display_name type
//                                       documentation ```kotlin\npublic final val type: StatementType\n```
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//                                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#`<init>`().(targets)
//                                                                   display_name targets
//                                                                   documentation ```kotlin\ntargets: List<Table>\n```
//                                                           ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#`<init>`().(targets)
//                                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#getTargets().
//                                                                   display_name targets
//                                                                   documentation ```kotlin\npublic get(): List<Table>\n```
//                                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#targets.
//                                                                   display_name targets
//                                                                   documentation ```kotlin\npublic final val targets: List<Table>\n```
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    /**
     * Returns the string representation of an SQL statement.
     *
     * If necessary, [transaction] can be used to ensure that database-specific syntax is used to generate the string.
     * To return a non-parameterized string, set [prepared] to `false`.
     */
    abstract fun prepareSQL(transaction: Transaction, prepared: Boolean = true): String
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                          display_name prepareSQL
//                          documentation ```kotlin\npublic abstract fun prepareSQL(transaction: Transaction, prepared: Boolean = ...): String\n\n```\n\n----\n\n\n Returns the string representation of an SQL statement.\n\n If necessary, [transaction] can be used to ensure that database-specific syntax is used to generate the string.\n To return a non-parameterized string, set [prepared] to `false`.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeSelectStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeTableStatement#prepareSQL().
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#prepareSQL().
//                          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().(transaction)
//                                      display_name transaction
//                                      documentation ```kotlin\ntransaction: Transaction\n```
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().(prepared)
//                                                             display_name prepared
//                                                             documentation ```kotlin\nprepared: Boolean = ...\n```
//                                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#

    /** Returns all mappings of columns and expression types to their values needed to prepare an SQL statement. */
    abstract fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#arguments().
//                         display_name arguments
//                         documentation ```kotlin\npublic abstract fun arguments(): Iterable<Iterable<Pair<IColumnType<*>, Any?>>>\n\n```\n\n----\n\n Returns all mappings of columns and expression types to their values needed to prepare an SQL statement.
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/AbstractQuery#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ExplainQuery#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/DeleteStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/InsertSelectStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#arguments().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/ReturningStatement#arguments().
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
}

/** Holds information related to a particular [statement] and the [args] needed to prepare it for execution. */
class StatementContext(val statement: Statement<*>, val args: Iterable<Pair<IColumnType<*>, Any?>>) {
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#
//                     display_name StatementContext
//                     documentation ```kotlin\npublic final class StatementContext : Any\n```\n\n----\n\n Holds information related to a particular [statement] and the [args] needed to prepare it for execution.
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#`<init>`().
//                     display_name StatementContext
//                     documentation ```kotlin\npublic constructor(statement: Statement<*>, args: Iterable<Pair<IColumnType<*>, Any?>>): StatementContext\n```
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#`<init>`().(statement)
//                                   display_name statement
//                                   documentation ```kotlin\nstatement: Statement<*>\n```
//                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#`<init>`().(statement)
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getStatement().
//                                   display_name statement
//                                   documentation ```kotlin\npublic get(): Statement<*>\n```
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#statement.
//                                   display_name statement
//                                   documentation ```kotlin\npublic final val statement: Statement<*>\n```
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#
//                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#`<init>`().(args)
//                                                           display_name args
//                                                           documentation ```kotlin\nargs: Iterable<Pair<IColumnType<*>, Any?>>\n```
//                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#`<init>`().(args)
//                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#args.
//                                                           display_name args
//                                                           documentation ```kotlin\npublic final val args: Iterable<Pair<IColumnType<*>, Any?>>\n```
//                                                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getArgs().
//                                                           display_name args
//                                                           documentation ```kotlin\npublic get(): Iterable<Pair<IColumnType<*>, Any?>>\n```
//                                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#
    /** Returns the string representation of the SQL statement associated with this [StatementContext]. */
    fun sql(transaction: Transaction) = statement.prepareSQL(transaction)
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#sql().
//          display_name sql
//          documentation ```kotlin\npublic final fun sql(transaction: Transaction): String\n```\n\n----\n\n Returns the string representation of the SQL statement associated with this [StatementContext].
//          ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#sql().(transaction)
//                      display_name transaction
//                      documentation ```kotlin\ntransaction: Transaction\n```
//                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getStatement().
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#statement.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/Statement#prepareSQL().
//                                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#sql().(transaction)
}

/**
 * Returns the string representation of [this] context's [Statement] with its argument values included
 * directly instead of parameter placeholders.
 */
fun StatementContext.expandArgs(transaction: Transaction): String {
//                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().
//                              display_name expandArgs
//                              documentation ```kotlin\npublic final fun StatementContext.expandArgs(transaction: Transaction): String\n```\n\n----\n\n\n Returns the string representation of [this] context's [Statement] with its argument values included\n directly instead of parameter placeholders.\n
//                              ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().(transaction)
//                                          display_name transaction
//                                          documentation ```kotlin\ntransaction: Transaction\n```
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                         ^^^^^^ reference semanticdb maven . . kotlin/String#
    val sql = sql(transaction)
//      ^^^ definition local 0
//          display_name sql
//          documentation ```kotlin\nlocal val sql: String\n```
//            ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#sql().
//                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/expandArgs().(transaction)
    val iterator = args.iterator()
//      ^^^^^^^^ definition local 1
//               display_name iterator
//               documentation ```kotlin\nlocal val iterator: Iterator<Pair<IColumnType<*>, Any?>>\n```
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#args.
//                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementContext#getArgs().
//                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterable#iterator().

    if (!iterator.hasNext()) return sql
//      ^ reference semanticdb maven . . kotlin/Boolean#not().
//       ^^^^^^^^ reference local 1
//                ^^^^^^^ reference semanticdb maven . . kotlin/collections/Iterator#hasNext().
//                                  ^^^ reference local 0

    return buildString {
//         ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
        val quoteStack = Stack<Char>()
//          ^^^^^^^^^^ definition local 2
//                     display_name quoteStack
//                     documentation ```kotlin\nlocal val quoteStack: Stack<Char>\n```
//                       ^^^^^ reference semanticdb maven jdk 11 java/util/Stack#`<init>`().
        var lastPos = 0
//          ^^^^^^^ definition local 3
//                  display_name lastPos
//                  documentation ```kotlin\nlocal var lastPos: Int\n```

        var i = -1
//          ^ definition local 4
//            display_name i
//            documentation ```kotlin\nlocal var i: Int\n```
        while (++i < sql.length) {
//             ^^ reference semanticdb maven . . kotlin/Int#inc().
//               ^ reference local 4
//                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                   ^^^ reference local 0
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#length.
            val char = sql[i]
//              ^^^^ definition local 5
//                   display_name char
//                   documentation ```kotlin\nlocal val char: Char\n```
//                     ^^^ reference local 0
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#get().
//                         ^ reference local 4
            when {
                char == '?' && quoteStack.isEmpty() -> {
//              ^^^^ reference local 5
//                             ^^^^^^^^^^ reference local 2
//                                        ^^^^^^^ reference semanticdb maven jdk 11 java/util/Stack#isEmpty().
                    if (sql.getOrNull(i + 1) == '?') {
//                      ^^^ reference local 0
//                          ^^^^^^^^^ reference semanticdb maven . . kotlin/text/getOrNull().
//                                    ^ reference local 4
//                                      ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                        i++
//                      ^ reference local 4
//                      ^^^ definition local 6
//                          display_name <unary>
//                          documentation ```kotlin\nlocal val <unary>: Int\n```
//                      ^^^ reference local 6
//                       ^^ reference semanticdb maven . . kotlin/Int#inc().
                        continue
                    }
                    append(sql.substring(lastPos, i))
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                         ^^^ reference local 0
//                             ^^^^^^^^^ reference semanticdb maven . . kotlin/text/substring(+1).
//                                       ^^^^^^^ reference local 3
//                                                ^ reference local 4
                    lastPos = i + 1
//                  ^^^^^^^ reference local 3
//                            ^ reference local 4
//                              ^ reference semanticdb maven . . kotlin/Int#plus(+2).
                    val (col, value) = iterator.next()
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition local 7
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\nlocal val <destruct>: Pair<IColumnType<*>, Any?>\n```
//                       ^^^ reference local 7
//                       ^^^ definition local 8
//                           display_name col
//                           documentation ```kotlin\nlocal val col: IColumnType<*>\n```
//                       ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                            ^^^^^ reference local 7
//                            ^^^^^ definition local 9
//                                  display_name value
//                                  documentation ```kotlin\nlocal val value: Any?\n```
//                            ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
//                                     ^^^^^^^^ reference local 1
//                                              ^^^^ reference semanticdb maven . . kotlin/collections/Iterator#next().
                    append((col as IColumnType<Any>).valueToString(value))
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                          ^^^ reference local 8
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#valueToString().
//                                                                 ^^^^^ reference local 9
                }
                char == '\'' || char == '\"' -> {
//              ^^^^ reference local 5
//                              ^^^^ reference local 5
                    when {
                        quoteStack.isEmpty() -> quoteStack.push(char)
//                      ^^^^^^^^^^ reference local 2
//                                 ^^^^^^^ reference semanticdb maven jdk 11 java/util/Stack#isEmpty().
//                                              ^^^^^^^^^^ reference local 2
//                                                         ^^^^ reference semanticdb maven jdk 11 java/util/Stack#push().
//                                                              ^^^^ reference local 5
                        quoteStack.peek() == char -> quoteStack.pop()
//                      ^^^^^^^^^^ reference local 2
//                                 ^^^^ reference semanticdb maven jdk 11 java/util/Stack#peek().
//                                           ^^^^ reference local 5
//                                                   ^^^^^^^^^^ reference local 2
//                                                              ^^^ reference semanticdb maven jdk 11 java/util/Stack#pop().
                        else -> quoteStack.push(char)
//                              ^^^^^^^^^^ reference local 2
//                                         ^^^^ reference semanticdb maven jdk 11 java/util/Stack#push().
//                                              ^^^^ reference local 5
                    }
                }
            }
        }

        if (lastPos < sql.length) {
//          ^^^^^^^ reference local 3
//                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                    ^^^ reference local 0
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#getLength().
//                        ^^^^^^ reference semanticdb maven . . kotlin/String#length.
            append(sql.substring(lastPos))
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                 ^^^ reference local 0
//                     ^^^^^^^^^ reference semanticdb maven . . kotlin/text/substring().
//                               ^^^^^^^ reference local 3
        }
    }
}

/** Represents the groups that are used to classify the purpose of an SQL statement. */
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 7:1
enum class StatementGroup {
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#
//                        display_name StatementGroup
//                        documentation ```kotlin\npublic final enum class StatementGroup : Enum<StatementGroup>\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#`<init>`().
//                        display_name StatementGroup
//                        documentation ```kotlin\nprivate constructor(): StatementGroup\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#entries.
//                        display_name entries
//                        documentation ```kotlin\npublic final static val entries: EnumEntries<StatementGroup>\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#valueOf().
//                        display_name valueOf
//                        documentation ```kotlin\npublic final static fun valueOf(value: String): StatementGroup\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#valueOf().(value)
//                        display_name value
//                        documentation ```kotlin\nvalue: String\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#values().
//                        display_name values
//                        documentation ```kotlin\npublic final static fun values(): Array<StatementGroup>\n```\n\n----\n\n Represents the groups that are used to classify the purpose of an SQL statement.
//         ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getEntries().
//                        display_name entries
//                        documentation ```kotlin\npublic get(): EnumEntries<StatementType>\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
    /** Data definition language group. */
    DDL,

    /** Data manipulation language group. */
    DML
}

/**
//^^^ reference semanticdb maven . . kotlin/Enum# 50:1
//^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType# 50:1
 * Possible SQL statement types, most often represented by the leading word in the command syntax.
 *
 * @property group The [StatementGroup] associated with the SQL statement.
 */
enum class StatementType(val group: StatementGroup) {
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//                       display_name StatementType
//                       documentation ```kotlin\npublic final enum class StatementType : Enum<StatementType>\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//                       relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3515>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3593>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3680>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3772>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3863>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3967>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4058>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4148>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4252>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4339>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4441>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4555>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4661>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4783>`#
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4883>`#
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#`<init>`().
//                       display_name StatementType
//                       documentation ```kotlin\nprivate constructor(group: StatementGroup): StatementType\n```
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#entries.
//                       display_name entries
//                       documentation ```kotlin\npublic final static val entries: EnumEntries<StatementType>\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#valueOf().
//                       display_name valueOf
//                       documentation ```kotlin\npublic final static fun valueOf(value: String): StatementType\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#valueOf().(value)
//                       display_name value
//                       documentation ```kotlin\nvalue: String\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#values().
//                       display_name values
//                       documentation ```kotlin\npublic final static fun values(): Array<StatementType>\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//         ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/getEntries().
//                       display_name entries
//                       documentation ```kotlin\npublic get(): EnumEntries<StatementType>\n```\n\n----\n\n\n Possible SQL statement types, most often represented by the leading word in the command syntax.\n\n @property group The [StatementGroup] associated with the SQL statement.\n
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#`<init>`().(group)
//                                 display_name group
//                                 documentation ```kotlin\ngroup: StatementGroup\n```
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#`<init>`().(group)
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#getGroup().
//                                 display_name group
//                                 documentation ```kotlin\npublic get(): StatementGroup\n```
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#group.
//                                 display_name group
//                                 documentation ```kotlin\npublic final val group: StatementGroup\n```
//                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#
    /** A SELECT statement to query data. */
    SELECT(StatementGroup.DML),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3515>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A SELECT statement to query data.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3515>`#`<init>`().
//         display_name SELECT
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A SELECT statement to query data.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** An INSERT statement to insert new records. */
    INSERT(StatementGroup.DML),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3593>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n An INSERT statement to insert new records.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3593>`#`<init>`().
//         display_name INSERT
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n An INSERT statement to insert new records.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** An UPDATE statement to modify existing records. */
    UPDATE(StatementGroup.DML),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3680>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n An UPDATE statement to modify existing records.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3680>`#`<init>`().
//         display_name UPDATE
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n An UPDATE statement to modify existing records.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** A DELETE statement to delete existing records. */
    DELETE(StatementGroup.DML),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3772>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A DELETE statement to delete existing records.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3772>`#`<init>`().
//         display_name DELETE
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A DELETE statement to delete existing records.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** A GRANT statement to provide privileges on database objects. */
    GRANT(StatementGroup.DDL),
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3863>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A GRANT statement to provide privileges on database objects.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3863>`#`<init>`().
//        display_name GRANT
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A GRANT statement to provide privileges on database objects.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** A CREATE statement to create database objects. */
    CREATE(StatementGroup.DDL),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3967>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A CREATE statement to create database objects.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 3967>`#`<init>`().
//         display_name CREATE
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A CREATE statement to create database objects.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** An ALTER statement to modify database objects. */
    ALTER(StatementGroup.DDL),
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4058>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n An ALTER statement to modify database objects.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4058>`#`<init>`().
//        display_name ALTER
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n An ALTER statement to modify database objects.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** A TRUNCATE statement to delete data in a database object. */
    TRUNCATE(StatementGroup.DDL),
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4148>`#
//           display_name <anonymous>
//           documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A TRUNCATE statement to delete data in a database object.
//           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4148>`#`<init>`().
//           display_name TRUNCATE
//           documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A TRUNCATE statement to delete data in a database object.
//                          ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** A DROP statement to delete database objects. */
    DROP(StatementGroup.DDL),
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4252>`#
//       display_name <anonymous>
//       documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A DROP statement to delete database objects.
//       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4252>`#`<init>`().
//       display_name DROP
//       documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A DROP statement to delete database objects.
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** An EXEC statement to execute a stored procedure or command. */
    EXEC(StatementGroup.DML),
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4339>`#
//       display_name <anonymous>
//       documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n An EXEC statement to execute a stored procedure or command.
//       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4339>`#`<init>`().
//       display_name EXEC
//       documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n An EXEC statement to execute a stored procedure or command.
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** A PRAGMA statement to configure or query the internal database state. */
    PRAGMA(StatementGroup.DML),
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4441>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A PRAGMA statement to configure or query the internal database state.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4441>`#`<init>`().
//         display_name PRAGMA
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A PRAGMA statement to configure or query the internal database state.
//                        ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** A SHOW statement to provide information about database objects. */
    SHOW(StatementGroup.DML),
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4555>`#
//       display_name <anonymous>
//       documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A SHOW statement to provide information about database objects.
//       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4555>`#`<init>`().
//       display_name SHOW
//       documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A SHOW statement to provide information about database objects.
//                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** Represents multiple statements of mixed types concatenated in a single string. */
    MULTI(StatementGroup.DML),
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4661>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n Represents multiple statements of mixed types concatenated in a single string.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4661>`#`<init>`().
//        display_name MULTI
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Represents multiple statements of mixed types concatenated in a single string.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.

    /** Represents statements not covered by existing constants. */
    OTHER(StatementGroup.DDL),
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4783>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n Represents statements not covered by existing constants.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4783>`#`<init>`().
//        display_name OTHER
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n Represents statements not covered by existing constants.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DDL.

    /** A MERGE statement to insert, update, or delete values by comparing data between source and destination tables. */
    MERGE(StatementGroup.DML),
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4883>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : StatementType\n```\n\n----\n\n A MERGE statement to insert, update, or delete values by comparing data between source and destination tables.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
//  ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/`<anonymous object at 4883>`#`<init>`().
//        display_name MERGE
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n A MERGE statement to insert, update, or delete values by comparing data between source and destination tables.
//                       ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementGroup#DML.
}

/** Stores the result generated by a database after statement execution and indicates the form of the result. */
sealed class StatementResult {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#
//                           display_name StatementResult
//                           documentation ```kotlin\npublic sealed class StatementResult : Any\n```\n\n----\n\n Stores the result generated by a database after statement execution and indicates the form of the result.
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#`<init>`().
//                           display_name StatementResult
//                           documentation ```kotlin\nprotected constructor(): StatementResult\n```\n\n----\n\n Stores the result generated by a database after statement execution and indicates the form of the result.
    /** Stores the affected row [count] (or update count) retrieved on statement execution. */
    data class Count(val count: Int) : StatementResult()
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#
//                   display_name Count
//                   documentation ```kotlin\npublic final data class Count : StatementResult\n```\n\n----\n\n Stores the affected row [count] (or update count) retrieved on statement execution.
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#`<init>`().
//                   display_name Count
//                   documentation ```kotlin\npublic constructor(count: Int): StatementResult.Count\n```
//             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#copy().
//                   display_name copy
//                   documentation ```kotlin\npublic final fun copy(count: Int = ...): StatementResult.Count\n\n```\n\n----\n\n Stores the affected row [count] (or update count) retrieved on statement execution.
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#`<init>`().(count)
//                             display_name count
//                             documentation ```kotlin\ncount: Int\n```
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#`<init>`().(count)
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#component1().
//                             display_name component1
//                             documentation ```kotlin\npublic final operator fun component1(): Int\n\n```
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#copy().(count)
//                             display_name count
//                             documentation ```kotlin\ncount: Int = ...\n```
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#count.
//                             display_name count
//                             documentation ```kotlin\npublic final val count: Int\n```
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#count.
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#getCount().
//                             display_name count
//                             documentation ```kotlin\npublic get(): Int\n```
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Count#getCount().
//                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#

    /** Stores the [resultSet] retrieved on statement execution. */
    data class Object(val resultSet: ResultApi) : StatementResult()
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#
//                    display_name Object
//                    documentation ```kotlin\npublic final data class Object : StatementResult\n```\n\n----\n\n Stores the [resultSet] retrieved on statement execution.
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#`<init>`().
//                    display_name Object
//                    documentation ```kotlin\npublic constructor(resultSet: ResultApi): StatementResult.Object\n```
//             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#copy().
//                    display_name copy
//                    documentation ```kotlin\npublic final fun copy(resultSet: ResultApi = ...): StatementResult.Object\n\n```\n\n----\n\n Stores the [resultSet] retrieved on statement execution.
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#`<init>`().(resultSet)
//                                  display_name resultSet
//                                  documentation ```kotlin\nresultSet: ResultApi\n```
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#`<init>`().(resultSet)
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#component1().
//                                  display_name component1
//                                  documentation ```kotlin\npublic final operator fun component1(): ResultApi\n\n```
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#copy().(resultSet)
//                                  display_name resultSet
//                                  documentation ```kotlin\nresultSet: ResultApi = ...\n```
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#getResultSet().
//                                  display_name resultSet
//                                  documentation ```kotlin\npublic get(): ResultApi\n```
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#getResultSet().
//                        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#resultSet.
//                                  display_name resultSet
//                                  documentation ```kotlin\npublic final val resultSet: ResultApi\n```
//                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#Object#resultSet.
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ResultApi#
//                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementResult#
}
