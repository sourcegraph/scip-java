package org.jetbrains.exposed.v1.core
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/

import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
import org.jetbrains.exposed.v1.core.vendors.currentDialect
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
import org.jetbrains.exposed.v1.exceptions.UnsupportedByDialectException
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#

/**
 * Represents a database sequence.
 *
 * @param name Name of the sequence.
 * @param startWith Beginning of the sequence.
 * @param incrementBy Value to be added to the current sequence value when creating a new value.
 * @param minValue Minimum value a sequence can generate.
 * @param maxValue Maximum value for the sequence.
 * @param cycle Allows the sequence to wrap around when the [maxValue] or [minValue] has been reached by
 * an ascending or descending sequence respectively.
 * @param cache Specifies how many sequence numbers are to be pre-allocated and stored in memory for faster access.
 */
class Sequence(
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//             display_name Sequence
//             documentation ```kotlin\npublic final class Sequence : Any\n```\n\n----\n\n\n Represents a database sequence.\n\n @param name Name of the sequence.\n @param startWith Beginning of the sequence.\n @param incrementBy Value to be added to the current sequence value when creating a new value.\n @param minValue Minimum value a sequence can generate.\n @param maxValue Maximum value for the sequence.\n @param cycle Allows the sequence to wrap around when the [maxValue] or [minValue] has been reached by\n an ascending or descending sequence respectively.\n @param cache Specifies how many sequence numbers are to be pre-allocated and stored in memory for faster access.\n
//    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().
//             display_name Sequence
//             documentation ```kotlin\npublic constructor(name: String, startWith: Long? = ..., incrementBy: Long? = ..., minValue: Long? = ..., maxValue: Long? = ..., cycle: Boolean? = ..., cache: Long? = ...): Sequence\n```
    val name: String,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(name)
//           display_name name
//           documentation ```kotlin\nname: String\n```
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(name)
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//           display_name name
//           documentation ```kotlin\npublic get(): String\n```
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.
//           display_name name
//           documentation ```kotlin\npublic final val name: String\n```
//            ^^^^^^ reference semanticdb maven . . kotlin/String#
    val startWith: Long? = null,
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(startWith)
//                display_name startWith
//                documentation ```kotlin\nstartWith: Long? = ...\n```
//      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(startWith)
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getStartWith().
//                display_name startWith
//                documentation ```kotlin\npublic get(): Long?\n```
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#startWith.
//                display_name startWith
//                documentation ```kotlin\npublic final val startWith: Long?\n```
//                 ^^^^^ reference semanticdb maven . . kotlin/Long#
    val incrementBy: Long? = null,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(incrementBy)
//                  display_name incrementBy
//                  documentation ```kotlin\nincrementBy: Long? = ...\n```
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(incrementBy)
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIncrementBy().
//                  display_name incrementBy
//                  documentation ```kotlin\npublic get(): Long?\n```
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#incrementBy.
//                  display_name incrementBy
//                  documentation ```kotlin\npublic final val incrementBy: Long?\n```
//                   ^^^^^ reference semanticdb maven . . kotlin/Long#
    val minValue: Long? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(minValue)
//               display_name minValue
//               documentation ```kotlin\nminValue: Long? = ...\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(minValue)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getMinValue().
//               display_name minValue
//               documentation ```kotlin\npublic get(): Long?\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#minValue.
//               display_name minValue
//               documentation ```kotlin\npublic final val minValue: Long?\n```
//                ^^^^^ reference semanticdb maven . . kotlin/Long#
    val maxValue: Long? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(maxValue)
//               display_name maxValue
//               documentation ```kotlin\nmaxValue: Long? = ...\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(maxValue)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getMaxValue().
//               display_name maxValue
//               documentation ```kotlin\npublic get(): Long?\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#maxValue.
//               display_name maxValue
//               documentation ```kotlin\npublic final val maxValue: Long?\n```
//                ^^^^^ reference semanticdb maven . . kotlin/Long#
    val cycle: Boolean? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(cycle)
//            display_name cycle
//            documentation ```kotlin\ncycle: Boolean? = ...\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(cycle)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#cycle.
//            display_name cycle
//            documentation ```kotlin\npublic final val cycle: Boolean?\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getCycle().
//            display_name cycle
//            documentation ```kotlin\npublic get(): Boolean?\n```
//             ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    val cache: Long? = null
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(cache)
//            display_name cache
//            documentation ```kotlin\ncache: Long? = ...\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#`<init>`().(cache)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#cache.
//            display_name cache
//            documentation ```kotlin\npublic final val cache: Long?\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getCache().
//            display_name cache
//            documentation ```kotlin\npublic get(): Long?\n```
//             ^^^^^ reference semanticdb maven . . kotlin/Long#
) {
    /** This name of this sequence in proper database casing. */
    val identifier: String
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
//                 display_name identifier
//                 documentation ```kotlin\npublic final val identifier: String\n```\n\n----\n\n This name of this sequence in proper database casing.
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
        @OptIn(InternalApi::class)
        get() = CoreTransactionManager.currentTransaction().db.identifierManager.cutIfNecessaryAndQuote(name)
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//          display_name identifier
//          documentation ```kotlin\n@OptIn(...) public get(): String\n```
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getName().
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#name.

    override fun toString(): String = "Sequence(identifier=$identifier)"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#toString().
//                        display_name toString
//                        documentation ```kotlin\npublic open override fun toString(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                                                          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.

    /** The SQL statements that create this sequence. */
    val ddl: List<String>
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#ddl.
//          display_name ddl
//          documentation ```kotlin\npublic final val ddl: List<String>\n```\n\n----\n\n The SQL statements that create this sequence.
//           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        get() = createStatement()
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getDdl().
//          display_name ddl
//          documentation ```kotlin\npublic get(): List<String>\n```
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#createStatement().

    /** Returns the SQL statements that create this sequence. */
    fun createStatement(): List<String> {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#createStatement().
//                      display_name createStatement
//                      documentation ```kotlin\npublic final fun createStatement(): List<String>\n```\n\n----\n\n Returns the SQL statements that create this sequence.
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        if (!currentDialect.supportsCreateSequence) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
            throw UnsupportedByDialectException("The current dialect doesn't support create sequence statement", currentDialect)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        }

        val createSequenceDDL = buildString {
//          ^^^^^^^^^^^^^^^^^ definition local 0
//                            display_name createSequenceDDL
//                            documentation ```kotlin\nlocal val createSequenceDDL: String\n```
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
            append("CREATE SEQUENCE ")
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
            if (currentDialect.supportsIfNotExists) {
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
                append("IF NOT EXISTS ")
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
            }
            append(identifier)
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
            appendIfNotNull(" START WITH", startWith)
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getStartWith().
//                                         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#startWith.
            appendIfNotNull(" INCREMENT BY", incrementBy)
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIncrementBy().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#incrementBy.
            appendIfNotNull(" MINVALUE", minValue)
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getMinValue().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#minValue.
            appendIfNotNull(" MAXVALUE", maxValue)
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getMaxValue().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#maxValue.

            if (cycle == true) {
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#cycle.
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getCycle().
                append(" CYCLE")
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
            }

            appendIfNotNull(" CACHE", cache)
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#cache.
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getCache().
        }

        return listOf(createSequenceDDL)
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^^^^^^^^^^^^^ reference local 0
    }

    /** Returns the SQL statements that drop this sequence. */
    fun dropStatement(): List<String> {
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#dropStatement().
//                    display_name dropStatement
//                    documentation ```kotlin\npublic final fun dropStatement(): List<String>\n```\n\n----\n\n Returns the SQL statements that drop this sequence.
//                       ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        if (!currentDialect.supportsCreateSequence) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSequence().
//                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSequence.
            throw UnsupportedByDialectException("The current dialect doesn't support drop sequence statement", currentDialect)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        }

        val dropSequenceDDL = buildString {
//          ^^^^^^^^^^^^^^^ definition local 1
//                          display_name dropSequenceDDL
//                          documentation ```kotlin\nlocal val dropSequenceDDL: String\n```
//                            ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
            append("DROP SEQUENCE ")
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
            if (currentDialect.supportsIfNotExists) {
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsIfNotExists().
//                             ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsIfNotExists.
                append("IF EXISTS ")
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
            }
            append(identifier)
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
        }

        return listOf(dropSequenceDDL)
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^^^^^^^^^^^ reference local 1
    }
}
