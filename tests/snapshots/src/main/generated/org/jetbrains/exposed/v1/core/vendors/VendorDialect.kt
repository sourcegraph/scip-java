package org.jetbrains.exposed.v1.core.vendors
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/

import org.jetbrains.exposed.v1.core.*
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
import org.jetbrains.exposed.v1.core.Function
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#

/**
 * Base implementation of a vendor dialect
 */
abstract class VendorDialect(
//             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                           display_name VendorDialect
//                           documentation ```kotlin\npublic abstract class VendorDialect : DatabaseDialect\n```\n\n----\n\n\n Base implementation of a vendor dialect\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
//             ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().
//                           display_name VendorDialect
//                           documentation ```kotlin\npublic constructor(name: String, dataTypeProvider: DataTypeProvider, functionProvider: FunctionProvider): VendorDialect\n```
    override val name: String,
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//                    display_name name
//                    documentation ```kotlin\nname: String\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(name)
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getName().
//                    display_name name
//                    documentation ```kotlin\npublic get(): String\n```
//               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#name.
//                    display_name name
//                    documentation ```kotlin\npublic open override val name: String\n```
//                     ^^^^^^ reference semanticdb maven . . kotlin/String#
    override val dataTypeProvider: DataTypeProvider,
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//                                display_name dataTypeProvider
//                                documentation ```kotlin\ndataTypeProvider: DataTypeProvider\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(dataTypeProvider)
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dataTypeProvider.
//                                display_name dataTypeProvider
//                                documentation ```kotlin\npublic open override val dataTypeProvider: DataTypeProvider\n```
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getDataTypeProvider().
//                                display_name dataTypeProvider
//                                documentation ```kotlin\npublic get(): DataTypeProvider\n```
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
    override val functionProvider: FunctionProvider
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//                                display_name functionProvider
//                                documentation ```kotlin\nfunctionProvider: FunctionProvider\n```
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#`<init>`().(functionProvider)
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#functionProvider.
//                                display_name functionProvider
//                                documentation ```kotlin\npublic open override val functionProvider: FunctionProvider\n```
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getFunctionProvider().
//                                display_name functionProvider
//                                documentation ```kotlin\npublic get(): FunctionProvider\n```
//                                 ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
) : DatabaseDialect {
//  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#

    protected val identifierManager
//                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                  display_name identifierManager
//                                  documentation ```kotlin\nprotected final val identifierManager: IdentifierManagerApi\n```
        @OptIn(InternalApi::class)
        get() = CoreTransactionManager.currentTransaction().db.identifierManager
//      ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//          display_name identifierManager
//          documentation ```kotlin\n@OptIn(...) protected get(): IdentifierManagerApi\n```
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                                          ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.

    @Suppress("UnnecessaryAbstractClass")
    abstract class DialectNameProvider(val dialectName: String)
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//                                     display_name DialectNameProvider
//                                     documentation ```kotlin\n@Suppress(...) public abstract class DialectNameProvider : Any\n```
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MariaDBDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLNGDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#
//                                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#Companion#
//                 ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().
//                                     display_name DialectNameProvider
//                                     documentation ```kotlin\npublic constructor(dialectName: String): VendorDialect.DialectNameProvider\n```
//                                         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                                     display_name dialectName
//                                                     documentation ```kotlin\ndialectName: String\n```
//                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#`<init>`().(dialectName)
//                                         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                                     display_name dialectName
//                                                     documentation ```kotlin\npublic final val dialectName: String\n```
//                                         ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
//                                                     display_name dialectName
//                                                     documentation ```kotlin\npublic get(): String\n```
//                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#

    override val supportsMultipleGeneratedKeys: Boolean = true
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getSupportsMultipleGeneratedKeys().
//                                             display_name supportsMultipleGeneratedKeys
//                                             documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#supportsMultipleGeneratedKeys.
//                                             display_name supportsMultipleGeneratedKeys
//                                             documentation ```kotlin\npublic open override val supportsMultipleGeneratedKeys: Boolean\n```
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    fun filterCondition(index: Index): String? {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
//                      display_name filterCondition
//                      documentation ```kotlin\npublic final fun filterCondition(index: Index): String?\n```
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
//                            display_name index
//                            documentation ```kotlin\nindex: Index\n```
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/String#
        return index.filterCondition?.let {
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().(index)
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#filterCondition.
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFilterCondition().
//                                    ^^^ reference semanticdb maven . . kotlin/let().
//                                        ^ definition semanticdb maven . . (it) 13:9
//                                          display_name it
//                                          documentation ```kotlin\nit: String\n```
            when (currentDialect) {
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
                is PostgreSQLDialect, is SQLServerDialect, is SQLiteDialect -> {
                    QueryBuilder(false)
//                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
                        .append(" WHERE ").append(it)
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                                                ^^ reference semanticdb maven . . (it)
                        .toString()
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
                }

                else -> {
                    exposedLogger.warn("Index creation with a filter condition is not supported in ${currentDialect.name}")
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                                                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                    return null
                }
            }
        } ?: ""
    }

    private fun indexFunctionToString(function: Function<*>): String {
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
//                                    display_name indexFunctionToString
//                                    documentation ```kotlin\nprivate final fun indexFunctionToString(function: Function<*>): String\n```
//                                    ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
//                                             display_name function
//                                             documentation ```kotlin\nfunction: Function<*>\n```
//                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#
//                                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
        val baseString = function.toString()
//          ^^^^^^^^^^ definition local 0
//                     display_name baseString
//                     documentation ```kotlin\nlocal val baseString: String\n```
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().(function)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Function#toString().
        return when (currentDialect) {
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
            // SQLite & Oracle do not support "." operator (with table prefix) in index expressions
            is SQLiteDialect, is OracleDialect -> baseString.replace(Regex("""^*[^( ]*\."""), "")
//                                                ^^^^^^^^^^ reference local 0
//                                                           ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+2).
//                                                                   ^^^^^ reference semanticdb maven . . kotlin/text/Regex#`<init>`(+1).
            is MysqlDialect -> if (baseString.first() != '(') "($baseString)" else baseString
//                                 ^^^^^^^^^^ reference local 0
//                                            ^^^^^ reference semanticdb maven . . kotlin/text/first().
//                                                               ^^^^^^^^^^ reference local 0
//                                                                                 ^^^^^^^^^^ reference local 0
            else -> baseString
//                  ^^^^^^^^^^ reference local 0
        }
    }

    /**
     * Uniqueness might be required for foreign key constraints.
     *
     * In PostgreSQL (https://www.postgresql.org/docs/current/indexes-unique.html), UNIQUE means B-tree only.
     * Unique constraints can not be partial
     * Unique indexes can be partial
     */
    override fun createIndex(index: Index): String {
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                           display_name createIndex
//                           documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```\n\n----\n\n\n Uniqueness might be required for foreign key constraints.\n\n In PostgreSQL (https://www.postgresql.org/docs/current/indexes-unique.html), UNIQUE means B-tree only.\n Unique constraints can not be partial\n Unique indexes can be partial\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#createIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#createIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#createIndex().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                 display_name index
//                                 documentation ```kotlin\nindex: Index\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
        @OptIn(InternalApi::class)
        val t = CoreTransactionManager.currentTransaction()
//          ^ definition local 1
//            display_name t
//            documentation ```kotlin\n@OptIn(...) local val t: Transaction\n```
//                                     ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
        val quotedTableName = t.identity(index.table)
//          ^^^^^^^^^^^^^^^ definition local 2
//                          display_name quotedTableName
//                          documentation ```kotlin\nlocal val quotedTableName: String\n```
//                            ^ reference local 1
//                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
        val quotedIndexName = t.db.identifierManager.cutIfNecessaryAndQuote(index.indexName)
//          ^^^^^^^^^^^^^^^ definition local 3
//                          display_name quotedIndexName
//                          documentation ```kotlin\nlocal val quotedIndexName: String\n```
//                            ^ reference local 1
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                 ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                                   ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
        val keyFields = index.columns.plus(index.functions ?: emptyList())
//          ^^^^^^^^^ definition local 4
//                    display_name keyFields
//                    documentation ```kotlin\nlocal val keyFields: List<ExpressionWithColumnType<*>>\n```
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                    ^^^^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                            ^^^^^^^^^ reference semanticdb maven . . kotlin/collections/emptyList().
        val fieldsList = keyFields.joinToString(prefix = "(", postfix = ")") {
//          ^^^^^^^^^^ definition local 5
//                     display_name fieldsList
//                     documentation ```kotlin\nlocal val fieldsList: String\n```
//                       ^^^^^^^^^ reference local 4
//                                 ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                           ^ definition semanticdb maven . . (it) 11:9
//                                                                             display_name it
//                                                                             documentation ```kotlin\nit: String\n```
            when (it) {
//                ^^ reference semanticdb maven . . (it)
                is Column<*> -> t.identity(it)
//                              ^ reference local 1
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                         ^^ reference semanticdb maven . . (it)
                is Function<*> -> indexFunctionToString(it)
//                                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#indexFunctionToString().
//                                                      ^^ reference semanticdb maven . . (it)
                // returned by existingIndices() mapping String metadata to stringLiteral()
                is LiteralOp<*> -> it.value.toString().trim('"')
//                                 ^^ reference semanticdb maven . . (it)
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#getValue().
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/LiteralOp#value.
//                                          ^^^^^^^^ reference semanticdb maven . . kotlin/toString().
//                                                     ^^^^ reference semanticdb maven . . kotlin/text/trim(+3).
                else -> {
                    exposedLogger.warn("Unexpected defining key field will be passed as String: $it")
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                               ^^ reference semanticdb maven . . (it)
                    it.toString()
//                  ^^ reference semanticdb maven . . (it)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
                }
            }
        }
        val includesOnlyColumns = index.functions?.isEmpty() != false
//          ^^^^^^^^^^^^^^^^^^^ definition local 6
//                              display_name includesOnlyColumns
//                              documentation ```kotlin\nlocal val includesOnlyColumns: Boolean\n```
//                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                 ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
        val maybeFilterCondition = filterCondition(index) ?: return ""
//          ^^^^^^^^^^^^^^^^^^^^ definition local 7
//                               display_name maybeFilterCondition
//                               documentation ```kotlin\nlocal val maybeFilterCondition: String\n```
//                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#filterCondition().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)

        return when {
            // unique and no filter -> constraint, the type is not supported
            index.unique && maybeFilterCondition.isEmpty() && includesOnlyColumns -> {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                          ^^^^^^^^^^^^^^^^^^^^ reference local 7
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/text/isEmpty().
//                                                            ^^^^^^^^^^^^^^^^^^^ reference local 6
                "ALTER TABLE $quotedTableName ADD CONSTRAINT $quotedIndexName UNIQUE $fieldsList"
//                            ^^^^^^^^^^^^^^^ reference local 2
//                                                            ^^^^^^^^^^^^^^^ reference local 3
//                                                                                    ^^^^^^^^^^ reference local 5
            }
            // unique and filter -> index only, the type is not supported
            index.unique -> {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
                "CREATE UNIQUE INDEX $quotedIndexName ON $quotedTableName $fieldsList$maybeFilterCondition"
//                                    ^^^^^^^^^^^^^^^ reference local 3
//                                                        ^^^^^^^^^^^^^^^ reference local 2
//                                                                         ^^^^^^^^^^ reference local 5
//                                                                                    ^^^^^^^^^^^^^^^^^^^^ reference local 7
            }
            // type -> can't be unique or constraint
            index.indexType != null -> {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
                createIndexWithType(
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
                    name = quotedIndexName, table = quotedTableName,
//                         ^^^^^^^^^^^^^^^ reference local 3
//                                                  ^^^^^^^^^^^^^^^ reference local 2
                    columns = fieldsList, type = index.indexType, filterCondition = maybeFilterCondition
//                            ^^^^^^^^^^ reference local 5
//                                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().(index)
//                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                                                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                                                                                  ^^^^^^^^^^^^^^^^^^^^ reference local 7
                )
            }

            else -> {
                "CREATE INDEX $quotedIndexName ON $quotedTableName $fieldsList$maybeFilterCondition"
//                             ^^^^^^^^^^^^^^^ reference local 3
//                                                 ^^^^^^^^^^^^^^^ reference local 2
//                                                                  ^^^^^^^^^^ reference local 5
//                                                                             ^^^^^^^^^^^^^^^^^^^^ reference local 7
            }
        }
    }

    protected open fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String {
//                     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
//                                         display_name createIndexWithType
//                                         documentation ```kotlin\nprotected open fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#createIndexWithType().
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().
//                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                              display_name name
//                                              documentation ```kotlin\nname: String\n```
//                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                                             display_name table
//                                                             documentation ```kotlin\ntable: String\n```
//                                                              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                                              display_name columns
//                                                                              documentation ```kotlin\ncolumns: String\n```
//                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                                            display_name type
//                                                                                            documentation ```kotlin\ntype: String\n```
//                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                     ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
//                                                                                                                     display_name filterCondition
//                                                                                                                     documentation ```kotlin\nfilterCondition: String\n```
//                                                                                                                      ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                                               ^^^^^^ reference semanticdb maven . . kotlin/String#
        return "CREATE INDEX $name ON $table $columns USING $type$filterCondition"
//                            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(name)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(table)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(columns)
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(type)
//                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().(filterCondition)
    }

    override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                         display_name dropIndex
//                         documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#dropIndex().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#dropIndex().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#dropIndex().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#dropIndex().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                   display_name tableName
//                                   documentation ```kotlin\ntableName: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
//                                                      display_name indexName
//                                                      documentation ```kotlin\nindexName: String\n```
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isUnique)
//                                                                        display_name isUnique
//                                                                        documentation ```kotlin\nisUnique: Boolean\n```
//                                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                        display_name isPartialOrFunctional
//                                                                                                        documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
        return "ALTER TABLE ${identifierManager.quoteIfNecessary(tableName)} DROP CONSTRAINT ${identifierManager.cutIfNecessaryAndQuote(indexName)}"
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(tableName)
//                                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                               ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().(indexName)
    }

    override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> =
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                            display_name modifyColumn
//                            documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#modifyColumn().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#modifyColumn().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/OracleDialect#modifyColumn().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PostgreSQLDialect#modifyColumn().
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                   display_name column
//                                   documentation ```kotlin\ncolumn: Column<*>\n```
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(columnDiff)
//                                                          display_name columnDiff
//                                                          documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        @OptIn(InternalApi::class)
        listOf("ALTER TABLE ${CoreTransactionManager.currentTransaction().identity(column.table)} MODIFY COLUMN ${column.descriptionDdl(true)}")
//      ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                   ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                                                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().(column)
//                                                                                                                       ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#descriptionDdl().

    override fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String {
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().
//                             display_name addPrimaryKey
//                             documentation ```kotlin\npublic open override fun addPrimaryKey(table: Table, pkName: String?, vararg pkColumns: Column<*>): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#addPrimaryKey().
//                             ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                   display_name table
//                                   documentation ```kotlin\ntable: Table\n```
//                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                           ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                                                  display_name pkName
//                                                  documentation ```kotlin\npkName: String?\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
//                                                                             display_name pkColumns
//                                                                             documentation ```kotlin\nvararg pkColumns: Column<*>\n```
//                                                                              ^^^^^^^^^ reference semanticdb maven . . kotlin/Array#
//                                                                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
        @OptIn(InternalApi::class)
        val transaction = CoreTransactionManager.currentTransaction()
//          ^^^^^^^^^^^ definition local 8
//                      display_name transaction
//                      documentation ```kotlin\n@OptIn(...) local val transaction: Transaction\n```
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
        val columns = pkColumns.joinToString(prefix = "(", postfix = ")") { transaction.identity(it) }
//          ^^^^^^^ definition local 9
//                  display_name columns
//                  documentation ```kotlin\nlocal val columns: String\n```
//                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkColumns)
//                              ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                     display_name it
//                                                                                                     documentation ```kotlin\nit: String\n```
//                                                                          ^^^^^^^^^^^ reference local 8
//                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                               ^^ reference semanticdb maven . . (it)
        val constraint = pkName?.let { " CONSTRAINT ${identifierManager.quoteIfNecessary(it)} " } ?: " "
//          ^^^^^^^^^^ definition local 10
//                     display_name constraint
//                     documentation ```kotlin\nlocal val constraint: String\n```
//                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(pkName)
//                               ^^^ reference semanticdb maven . . kotlin/let().
//                                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                display_name it
//                                                                                                documentation ```kotlin\nit: String\n```
//                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                       ^^ reference semanticdb maven . . (it)
        return "ALTER TABLE ${transaction.identity(table)} ADD${constraint}PRIMARY KEY $columns"
//                            ^^^^^^^^^^^ reference local 8
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#addPrimaryKey().(table)
//                                                              ^^^^^^^^^^ reference local 10
//                                                                                      ^^^^^^^ reference local 9
    }
}
