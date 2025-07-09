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
 * Represents a database schema.
 *
 * @param name The schema name.
 * @param authorization Specifies the name of the database-level principal that will own the schema.
 * @param password Used only for Oracle schema.
 * @param defaultTablespace Used only for Oracle schema.
 * @param temporaryTablespace Used only for Oracle schema.
 * @param quota Used only for Oracle schema.
 * @param on Used only for Oracle schema.
 */
data class Schema(
//         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                display_name Schema
//                documentation ```kotlin\npublic final data class Schema : Any\n```\n\n----\n\n\n Represents a database schema.\n\n @param name The schema name.\n @param authorization Specifies the name of the database-level principal that will own the schema.\n @param password Used only for Oracle schema.\n @param defaultTablespace Used only for Oracle schema.\n @param temporaryTablespace Used only for Oracle schema.\n @param quota Used only for Oracle schema.\n @param on Used only for Oracle schema.\n
//         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().
//                display_name Schema
//                documentation ```kotlin\npublic constructor(name: String, authorization: String? = ..., password: String? = ..., defaultTablespace: String? = ..., temporaryTablespace: String? = ..., quota: String? = ..., on: String? = ...): Schema\n```
//         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().
//                display_name copy
//                documentation ```kotlin\npublic final fun copy(name: String = ..., authorization: String? = ..., password: String? = ..., defaultTablespace: String? = ..., temporaryTablespace: String? = ..., quota: String? = ..., on: String? = ...): Schema\n\n```\n\n----\n\n\n Represents a database schema.\n\n @param name The schema name.\n @param authorization Specifies the name of the database-level principal that will own the schema.\n @param password Used only for Oracle schema.\n @param defaultTablespace Used only for Oracle schema.\n @param temporaryTablespace Used only for Oracle schema.\n @param quota Used only for Oracle schema.\n @param on Used only for Oracle schema.\n
    private val name: String,
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String\n```
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(name)
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component1().
//                   display_name component1
//                   documentation ```kotlin\nprivate final operator fun component1(): String\n\n```
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(name)
//                   display_name name
//                   documentation ```kotlin\nname: String = ...\n```
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getName().
//                   display_name name
//                   documentation ```kotlin\nprivate get(): String\n```
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getName().
//              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#name.
//                   display_name name
//                   documentation ```kotlin\nprivate final val name: String\n```
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#name.
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
    val authorization: String? = null,
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(authorization)
//                    display_name authorization
//                    documentation ```kotlin\nauthorization: String? = ...\n```
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(authorization)
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//                    display_name authorization
//                    documentation ```kotlin\npublic final val authorization: String?\n```
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component2().
//                    display_name component2
//                    documentation ```kotlin\npublic final operator fun component2(): String?\n\n```
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(authorization)
//                    display_name authorization
//                    documentation ```kotlin\nauthorization: String? = ...\n```
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
//                    display_name authorization
//                    documentation ```kotlin\npublic get(): String?\n```
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
//                     ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val password: String? = null,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(password)
//               display_name password
//               documentation ```kotlin\npassword: String? = ...\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(password)
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component3().
//               display_name component3
//               documentation ```kotlin\npublic final operator fun component3(): String?\n\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(password)
//               display_name password
//               documentation ```kotlin\npassword: String? = ...\n```
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getPassword().
//               display_name password
//               documentation ```kotlin\npublic get(): String?\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getPassword().
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#password.
//               display_name password
//               documentation ```kotlin\npublic final val password: String?\n```
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#password.
//                ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val defaultTablespace: String? = null,
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(defaultTablespace)
//                        display_name defaultTablespace
//                        documentation ```kotlin\ndefaultTablespace: String? = ...\n```
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(defaultTablespace)
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component4().
//                        display_name component4
//                        documentation ```kotlin\npublic final operator fun component4(): String?\n\n```
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(defaultTablespace)
//                        display_name defaultTablespace
//                        documentation ```kotlin\ndefaultTablespace: String? = ...\n```
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#defaultTablespace.
//                        display_name defaultTablespace
//                        documentation ```kotlin\npublic final val defaultTablespace: String?\n```
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#defaultTablespace.
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getDefaultTablespace().
//                        display_name defaultTablespace
//                        documentation ```kotlin\npublic get(): String?\n```
//      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getDefaultTablespace().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val temporaryTablespace: String? = null,
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(temporaryTablespace)
//                          display_name temporaryTablespace
//                          documentation ```kotlin\ntemporaryTablespace: String? = ...\n```
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(temporaryTablespace)
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component5().
//                          display_name component5
//                          documentation ```kotlin\npublic final operator fun component5(): String?\n\n```
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(temporaryTablespace)
//                          display_name temporaryTablespace
//                          documentation ```kotlin\ntemporaryTablespace: String? = ...\n```
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getTemporaryTablespace().
//                          display_name temporaryTablespace
//                          documentation ```kotlin\npublic get(): String?\n```
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getTemporaryTablespace().
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#temporaryTablespace.
//                          display_name temporaryTablespace
//                          documentation ```kotlin\npublic final val temporaryTablespace: String?\n```
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#temporaryTablespace.
//                           ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val quota: String? = null,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(quota)
//            display_name quota
//            documentation ```kotlin\nquota: String? = ...\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(quota)
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component6().
//            display_name component6
//            documentation ```kotlin\npublic final operator fun component6(): String?\n\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(quota)
//            display_name quota
//            documentation ```kotlin\nquota: String? = ...\n```
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getQuota().
//            display_name quota
//            documentation ```kotlin\npublic get(): String?\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getQuota().
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#quota.
//            display_name quota
//            documentation ```kotlin\npublic final val quota: String?\n```
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#quota.
//             ^^^^^^^ reference semanticdb maven . . kotlin/String#
    val on: String? = null
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(on)
//         display_name on
//         documentation ```kotlin\non: String? = ...\n```
//      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#`<init>`().(on)
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#component7().
//         display_name component7
//         documentation ```kotlin\npublic final operator fun component7(): String?\n\n```
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#copy().(on)
//         display_name on
//         documentation ```kotlin\non: String? = ...\n```
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getOn().
//         display_name on
//         documentation ```kotlin\npublic get(): String?\n```
//      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getOn().
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#on.
//         display_name on
//         documentation ```kotlin\npublic final val on: String?\n```
//      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#on.
//          ^^^^^^^ reference semanticdb maven . . kotlin/String#
) {
    /** This schema's name in proper database casing. */
    val identifier
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
//                 display_name identifier
//                 documentation ```kotlin\npublic final val identifier: String\n```\n\n----\n\n This schema's name in proper database casing.
        @OptIn(InternalApi::class)
        get() = CoreTransactionManager.currentTransaction().db.identifierManager.cutIfNecessaryAndQuote(name)
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//          display_name identifier
//          documentation ```kotlin\n@OptIn(...) public get(): String\n```
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                                               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getName().
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#name.

    /** The SQL statements that create this schema. */
    val ddl: List<String>
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#ddl.
//          display_name ddl
//          documentation ```kotlin\npublic final val ddl: List<String>\n```\n\n----\n\n The SQL statements that create this schema.
//           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        get() = createStatement()
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getDdl().
//          display_name ddl
//          documentation ```kotlin\npublic get(): List<String>\n```
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#createStatement().

    /** Returns the SQL statements that create this schema. */
    fun createStatement(): List<String> {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#createStatement().
//                      display_name createStatement
//                      documentation ```kotlin\npublic final fun createStatement(): List<String>\n```\n\n----\n\n Returns the SQL statements that create this schema.
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        if (!currentDialect.supportsCreateSchema) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
            throw UnsupportedByDialectException("The current dialect doesn't support create schema statement", currentDialect)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        }

        return listOf(currentDialect.createSchema(this))
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().
    }

    /** Returns the SQL statements that drop this schema, as well as all its objects if [cascade] is `true`. */
    fun dropStatement(cascade: Boolean): List<String> {
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#dropStatement().
//                    display_name dropStatement
//                    documentation ```kotlin\npublic final fun dropStatement(cascade: Boolean): List<String>\n```\n\n----\n\n Returns the SQL statements that drop this schema, as well as all its objects if [cascade] is `true`.
//                    ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#dropStatement().(cascade)
//                            display_name cascade
//                            documentation ```kotlin\ncascade: Boolean\n```
//                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        if (!currentDialect.supportsCreateSchema) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
            throw UnsupportedByDialectException("The current dialect doesn't support drop schema statement", currentDialect)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        }

        return listOf(currentDialect.dropSchema(this, cascade))
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#dropStatement().(cascade)
    }

    /** Returns the SQL statements that set this schema as the current schema. */
    fun setSchemaStatement(): List<String> {
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#setSchemaStatement().
//                         display_name setSchemaStatement
//                         documentation ```kotlin\npublic final fun setSchemaStatement(): List<String>\n```\n\n----\n\n Returns the SQL statements that set this schema as the current schema.
//                            ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        if (!currentDialect.supportsCreateSchema) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsCreateSchema().
//                          ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsCreateSchema.
            throw UnsupportedByDialectException("The current dialect doesn't support schemas", currentDialect)
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/UnsupportedByDialectException#`<init>`().
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
        }

        return listOf(currentDialect.setSchema(this))
//             ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                    ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
    }
}

/** Appends both [str1] and [str2] to the receiver [StringBuilder] if [str2] is not `null`. */
internal fun StringBuilder.appendIfNotNull(str1: String, str2: Any?) = apply {
//                         ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                         display_name appendIfNotNull
//                                         documentation ```kotlin\ninternal final fun {kotlin/text/StringBuilder=} StringBuilder.appendIfNotNull(str1: String, str2: Any?): {kotlin/text/StringBuilder=} StringBuilder\n```\n\n----\n\n Appends both [str1] and [str2] to the receiver [StringBuilder] if [str2] is not `null`.
//                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().(str1)
//                                              display_name str1
//                                              documentation ```kotlin\nstr1: String\n```
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().(str2)
//                                                            display_name str2
//                                                            documentation ```kotlin\nstr2: Any?\n```
//                                                             ^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                     ^^^^^ reference semanticdb maven . . kotlin/apply().
    if (str2 != null) {
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().(str2)
        this.append("$str1 $str2")
//           ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().(str1)
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().(str2)
    }
}
