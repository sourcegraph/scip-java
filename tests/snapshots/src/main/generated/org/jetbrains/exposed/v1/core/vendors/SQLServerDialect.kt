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
import org.jetbrains.exposed.v1.core.statements.MergeStatement
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.DELETE
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/DELETE/
import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.INSERT
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/INSERT/
import org.jetbrains.exposed.v1.core.statements.MergeStatement.ClauseAction.UPDATE
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/
//                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement/ClauseAction/UPDATE/
import org.jetbrains.exposed.v1.core.statements.StatementType
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#
import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
import org.jetbrains.exposed.v1.exceptions.throwUnsupportedException
//     ^^^ reference semanticdb maven . . org/
//         ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                           ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
import java.util.*
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/

internal object SQLServerDataTypeProvider : DataTypeProvider() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#
//                                        display_name SQLServerDataTypeProvider
//                                        documentation ```kotlin\ninternal final object SQLServerDataTypeProvider : DataTypeProvider\n```\n\n----\n\n\n varchar is used instead of "text" because it will be removed in future\n https://docs.microsoft.com/en-us/sql/t-sql/data-types/ntext-text-and-image-transact-sql?view=sql-server-ver15\n
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#`<init>`().
//                                        display_name SQLServerDataTypeProvider
//                                        documentation ```kotlin\nprivate constructor(): SQLServerDataTypeProvider\n```\n\n----\n\n\n varchar is used instead of "text" because it will be removed in future\n https://docs.microsoft.com/en-us/sql/t-sql/data-types/ntext-text-and-image-transact-sql?view=sql-server-ver15\n
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#
    override fun byteType(): String = if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.SQLServer) {
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#byteType().
//                        display_name byteType
//                        documentation ```kotlin\npublic open override fun byteType(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#byteType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
        "TINYINT"
    } else {
        "SMALLINT"
    }

    override fun ubyteType(): String {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#ubyteType().
//                         display_name ubyteType
//                         documentation ```kotlin\npublic open override fun ubyteType(): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ubyteType().
//                            ^^^^^^ reference semanticdb maven . . kotlin/String#
        return if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.SQLServer) {
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                 ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
            "SMALLINT"
        } else {
            "TINYINT"
        }
    }

    override fun integerAutoincType(): String = "INT IDENTITY(1,1)"
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#integerAutoincType().
//                                  display_name integerAutoincType
//                                  documentation ```kotlin\npublic open override fun integerAutoincType(): String\n```
//                                  relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#integerAutoincType().
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun longAutoincType(): String = "BIGINT IDENTITY(1,1)"
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#longAutoincType().
//                               display_name longAutoincType
//                               documentation ```kotlin\npublic open override fun longAutoincType(): String\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#longAutoincType().
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun ulongAutoincType(): String = "NUMERIC(20) IDENTITY(1,1)"
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#ulongAutoincType().
//                                display_name ulongAutoincType
//                                documentation ```kotlin\npublic open override fun ulongAutoincType(): String\n```
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#ulongAutoincType().
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun binaryType(): String {
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#binaryType().
//                          display_name binaryType
//                          documentation ```kotlin\npublic open override fun binaryType(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#binaryType().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
        exposedLogger.error("The length of the Binary column is missing.")
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                    ^^^^^ reference semanticdb maven . . org/slf4j/Logger#error().
        error("The length of the Binary column is missing.")
//      ^^^^^ reference semanticdb maven . . kotlin/error().
    }

    override fun blobType(): String = "VARBINARY(MAX)"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#blobType().
//                        display_name blobType
//                        documentation ```kotlin\npublic open override fun blobType(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#blobType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun uuidType(): String = "uniqueidentifier"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidType().
//                        display_name uuidType
//                        documentation ```kotlin\npublic open override fun uuidType(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun uuidToDB(value: UUID): Any = value.toString()
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidToDB().
//                        display_name uuidToDB
//                        documentation ```kotlin\npublic open override fun uuidToDB(value: UUID): Any\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#uuidToDB().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidToDB().(value)
//                              display_name value
//                              documentation ```kotlin\nvalue: UUID\n```
//                               ^^^^ reference semanticdb maven jdk 11 java/util/UUID#
//                                      ^^^ reference semanticdb maven . . kotlin/Any#
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#uuidToDB().(value)
//                                                  ^^^^^^^^ reference semanticdb maven jdk 11 java/util/UUID#toString().
    override fun dateTimeType(): String = "DATETIME2"
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#dateTimeType().
//                            display_name dateTimeType
//                            documentation ```kotlin\npublic open override fun dateTimeType(): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#dateTimeType().
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun timestampWithTimeZoneType(): String =
//               ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#timestampWithTimeZoneType().
//                                         display_name timestampWithTimeZoneType
//                                         documentation ```kotlin\npublic open override fun timestampWithTimeZoneType(): String\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#timestampWithTimeZoneType().
//                                            ^^^^^^ reference semanticdb maven . . kotlin/String#
        if (currentDialect.h2Mode == H2Dialect.H2CompatibilityMode.SQLServer) {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getH2Mode().
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/h2Mode.
//                                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/H2Dialect#H2CompatibilityMode#SQLServer.
            "TIMESTAMP(9) WITH TIME ZONE"
        } else {
            "DATETIMEOFFSET"
        }

    override fun booleanType(): String = "BIT"
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanType().
//                           display_name booleanType
//                           documentation ```kotlin\npublic open override fun booleanType(): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanType().
//                              ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun booleanToStatementString(bool: Boolean): String = if (bool) "1" else "0"
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanToStatementString().
//                                        display_name booleanToStatementString
//                                        documentation ```kotlin\npublic open override fun booleanToStatementString(bool: Boolean): String\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#booleanToStatementString().
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanToStatementString().(bool)
//                                             display_name bool
//                                             documentation ```kotlin\nbool: Boolean\n```
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#booleanToStatementString().(bool)

    /**
     * varchar is used instead of "text" because it will be removed in future
     * https://docs.microsoft.com/en-us/sql/t-sql/data-types/ntext-text-and-image-transact-sql?view=sql-server-ver15
     */
    override fun textType(): String = "VARCHAR(MAX)"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#textType().
//                        display_name textType
//                        documentation ```kotlin\npublic open override fun textType(): String\n```\n\n----\n\n\n varchar is used instead of "text" because it will be removed in future\n https://docs.microsoft.com/en-us/sql/t-sql/data-types/ntext-text-and-image-transact-sql?view=sql-server-ver15\n
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#textType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
    override fun mediumTextType(): String = textType()
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#mediumTextType().
//                              display_name mediumTextType
//                              documentation ```kotlin\npublic open override fun mediumTextType(): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#mediumTextType().
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#textType().
    override fun largeTextType(): String = textType()
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#largeTextType().
//                             display_name largeTextType
//                             documentation ```kotlin\npublic open override fun largeTextType(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#largeTextType().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#textType().
    override fun jsonType(): String = "NVARCHAR(MAX)"
//               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#jsonType().
//                        display_name jsonType
//                        documentation ```kotlin\npublic open override fun jsonType(): String\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#jsonType().
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#

    override fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder) {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().
//                                    display_name precessOrderByClause
//                                    documentation ```kotlin\npublic open override fun precessOrderByClause(queryBuilder: QueryBuilder, expression: Expression<*>, sortOrder: SortOrder): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                 display_name queryBuilder
//                                                 documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                                                           display_name expression
//                                                                           documentation ```kotlin\nexpression: Expression<*>\n```
//                                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                                                           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(sortOrder)
//                                                                                                     display_name sortOrder
//                                                                                                     documentation ```kotlin\nsortOrder: SortOrder\n```
//                                                                                                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
        when (sortOrder) {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(sortOrder)
            SortOrder.ASC, SortOrder.DESC -> super.precessOrderByClause(queryBuilder, expression, sortOrder)
//                    ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
//                                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(sortOrder)
            SortOrder.ASC_NULLS_FIRST -> super.precessOrderByClause(queryBuilder, expression, SortOrder.ASC)
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC_NULLS_FIRST.
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                      ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
            SortOrder.DESC_NULLS_LAST -> super.precessOrderByClause(queryBuilder, expression, SortOrder.DESC)
//                    ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC_NULLS_LAST.
//                                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
            else -> {
                val sortOrderClause = if (sortOrder == SortOrder.ASC_NULLS_LAST) {
//                  ^^^^^^^^^^^^^^^ definition local 0
//                                  display_name sortOrderClause
//                                  documentation ```kotlin\nlocal val sortOrderClause: Pair<ExpressionWithColumnType<Int>, SortOrder>\n```
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(sortOrder)
//                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC_NULLS_LAST.
                    Expression.build {
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().
                        Case().When(expression.isNull(), intLiteral(1)).Else(intLiteral(0))
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
                    } to SortOrder.ASC
//                    ^^ reference semanticdb maven . . kotlin/to().
//                                 ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#ASC.
                } else {
                    Expression.build {
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#Companion#build().
                        Case().When(expression.isNull(), intLiteral(0)).Else(intLiteral(1))
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#`<init>`().
//                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Case#When().
//                                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ISqlExpressionBuilder#isNull().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
//                                                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CaseWhen#Else().
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/intLiteral().
                    } to SortOrder.DESC
//                    ^^ reference semanticdb maven . . kotlin/to().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#DESC.
                }
                queryBuilder.append(sortOrderClause.first, ", ")
//              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^^^^^^^^^^^^ reference local 0
//                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                  ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
                super.precessOrderByClause(queryBuilder, expression, sortOrderClause.second)
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#precessOrderByClause().
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(queryBuilder)
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#precessOrderByClause().(expression)
//                                                                   ^^^^^^^^^^^^^^^ reference local 0
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#getSecond().
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/Pair#second.
            }
        }
    }

    override fun hexToDb(hexString: String): String = "0x$hexString"
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#hexToDb().
//                       display_name hexToDb
//                       documentation ```kotlin\npublic open override fun hexToDb(hexString: String): String\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#hexToDb().
//                       ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#hexToDb().(hexString)
//                                 display_name hexString
//                                 documentation ```kotlin\nhexString: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                           ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDataTypeProvider#hexToDb().(hexString)
}

@Suppress("TooManyFunctions")
internal object SQLServerFunctionProvider : FunctionProvider() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#
//                                        display_name SQLServerFunctionProvider
//                                        documentation ```kotlin\n@Suppress(...) internal final object SQLServerFunctionProvider : FunctionProvider\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#`<init>`().
//                                        display_name SQLServerFunctionProvider
//                                        documentation ```kotlin\nprivate constructor(): SQLServerFunctionProvider\n```
//                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#
    override fun nextVal(seq: Sequence, builder: QueryBuilder) = builder {
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().
//                       display_name nextVal
//                       documentation ```kotlin\npublic open override fun nextVal(seq: Sequence, builder: QueryBuilder): Unit\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#nextVal().
//                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().(seq)
//                           display_name seq
//                           documentation ```kotlin\nseq: Sequence\n```
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#
//                                      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().(builder)
//                                              display_name builder
//                                              documentation ```kotlin\nbuilder: QueryBuilder\n```
//                                               ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().(builder)
        append("NEXT VALUE FOR ", seq.identifier)
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#nextVal().(seq)
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#getIdentifier().
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Sequence#identifier.
    }

    override fun random(seed: Int?): String = if (seed != null) "RAND($seed)" else "RAND(CHECKSUM(NEWID()))"
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#random().
//                      display_name random
//                      documentation ```kotlin\npublic open override fun random(seed: Int?): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#random().
//                      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#random().(seed)
//                           display_name seed
//                           documentation ```kotlin\nseed: Int?\n```
//                            ^^^^ reference semanticdb maven . . kotlin/Int#
//                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#random().(seed)
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#random().(seed)

    override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().
//                                        display_name charLength
//                                        documentation ```kotlin\npublic open override fun <T : String?> charLength(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#charLength().
//                                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().(expr)
//                                             display_name expr
//                                             documentation ```kotlin\nexpr: Expression<T>\n```
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().(queryBuilder)
//                                                                          display_name queryBuilder
//                                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().(queryBuilder)
        append("LEN(", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#charLength().(expr)
    }

    override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder) {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().
//                                         display_name groupConcat
//                                         documentation ```kotlin\npublic open override fun <T : String?> groupConcat(expr: GroupConcat<T>, queryBuilder: QueryBuilder): Unit\n```
//                                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#groupConcat().
//                                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//                                              display_name expr
//                                              documentation ```kotlin\nexpr: GroupConcat<T>\n```
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#
//                                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(queryBuilder)
//                                                                            display_name queryBuilder
//                                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        @OptIn(InternalApi::class)
        val tr = CoreTransactionManager.currentTransaction()
//          ^^ definition local 1
//             display_name tr
//             documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
        return when {
            expr.separator == null -> tr.throwUnsupportedException("SQL Server requires explicit separator in STRING_AGG")
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
//                                    ^^ reference local 1
//                                       ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
            expr.distinct -> tr.throwUnsupportedException("SQL Server doesn't support DISTINCT in STRING_AGG")
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#distinct.
//               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getDistinct().
//                           ^^ reference local 1
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
            expr.orderBy.size > 1 -> tr.throwUnsupportedException("SQL Server supports only single column in ORDER BY clause in STRING_AGG")
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                       ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//                       ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                            ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
//                                   ^^ reference local 1
//                                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
            else -> queryBuilder {
//                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(queryBuilder)
                append("STRING_AGG(")
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
                append(expr.expr)
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+2).
//                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#expr.
//                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getExpr().
                append(", '${expr.separator}')")
//              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getSeparator().
//                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#separator.
                expr.orderBy.singleOrNull()?.let { (col, order) ->
//              ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#groupConcat().(expr)
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#getOrderBy().
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/GroupConcat#orderBy.
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull().
//                                           ^^^ reference semanticdb maven . . kotlin/let().
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                              display_name <destruct>
//                                                              documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                                  ^^^ definition local 2
//                                                      display_name col
//                                                      documentation ```kotlin\nlocal val col: Expression<*>\n```
//                                                  ^^^ reference semanticdb maven . . (`<destruct>`)
//                                                  ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                                       ^^^^^ definition local 3
//                                                             display_name order
//                                                             documentation ```kotlin\nlocal val order: SortOrder\n```
//                                                       ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                                       ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
                    append(" WITHIN GROUP (ORDER BY ", col, " ", order.name, ")")
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                                     ^^^ reference local 2
//                                                               ^^^^^ reference local 3
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getName().
//                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#name.
                }
            }
        }
    }

    override fun <T : String?> locate(
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().
//                                    display_name locate
//                                    documentation ```kotlin\npublic open override fun <T : String?> locate(queryBuilder: QueryBuilder, expr: Expression<T>, substring: String): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#locate().
        queryBuilder: QueryBuilder,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(queryBuilder)
//                   display_name queryBuilder
//                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
        expr: Expression<T>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(expr)
//           display_name expr
//           documentation ```kotlin\nexpr: Expression<T>\n```
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        substring: String
//      ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(substring)
//                display_name substring
//                documentation ```kotlin\nsubstring: String\n```
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
    ) = queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(queryBuilder)
        append("CHARINDEX(\'", substring, "\',", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(substring)
//                                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#locate().(expr)
    }

    override fun <T : String?> regexp(
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT : String?\n```
//                             ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().
//                                    display_name regexp
//                                    documentation ```kotlin\npublic open override fun <T : String?> regexp(expr1: Expression<T>, pattern: Expression<String>, caseSensitive: Boolean, queryBuilder: QueryBuilder): Unit\n```
//                                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#regexp().
        expr1: Expression<T>,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().(expr1)
//            display_name expr1
//            documentation ```kotlin\nexpr1: Expression<T>\n```
//             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        pattern: Expression<String>,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().(pattern)
//              display_name pattern
//              documentation ```kotlin\npattern: Expression<String>\n```
//               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        caseSensitive: Boolean,
//      ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().(caseSensitive)
//                    display_name caseSensitive
//                    documentation ```kotlin\ncaseSensitive: Boolean\n```
//                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        queryBuilder: QueryBuilder
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#regexp().(queryBuilder)
//                   display_name queryBuilder
//                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
    ) {
        @OptIn(InternalApi::class)
        CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLServer doesn't provide built in REGEXP expression, use LIKE instead.")
//                             ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
    }

    override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().
//                        display_name date
//                        documentation ```kotlin\npublic open override fun <T> date(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#date().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().(queryBuilder)
        append("CAST(", expr, " AS DATE)")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#date().(expr)
    }

    override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder) = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().
//                        display_name time
//                        documentation ```kotlin\npublic open override fun <T> time(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#time().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().(queryBuilder)
        append("SUBSTRING(CONVERT(NVARCHAR, ", expr, ", 121), 12, 15)")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#time().(expr)
    }

    override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().
//                        display_name year
//                        documentation ```kotlin\npublic open override fun <T> year(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#year().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().(queryBuilder)
        append("DATEPART(YEAR, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#year().(expr)
    }

    override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().
//                         display_name month
//                         documentation ```kotlin\npublic open override fun <T> month(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#month().
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().(expr)
//                              display_name expr
//                              documentation ```kotlin\nexpr: Expression<T>\n```
//                               ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                              ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().(queryBuilder)
//                                                           display_name queryBuilder
//                                                           documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                           ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().(queryBuilder)
        append("DATEPART(MONTH, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#month().(expr)
    }

    override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().
//                       display_name day
//                       documentation ```kotlin\npublic open override fun <T> day(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#day().
//                       ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().(expr)
//                            display_name expr
//                            documentation ```kotlin\nexpr: Expression<T>\n```
//                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                            ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().(queryBuilder)
//                                                         display_name queryBuilder
//                                                         documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                         ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().(queryBuilder)
        append("DATEPART(DAY, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#day().(expr)
    }

    override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().
//                        display_name hour
//                        documentation ```kotlin\npublic open override fun <T> hour(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#hour().
//                        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().(expr)
//                             display_name expr
//                             documentation ```kotlin\nexpr: Expression<T>\n```
//                              ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                             ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().(queryBuilder)
//                                                          display_name queryBuilder
//                                                          documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                          ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().(queryBuilder)
        append("DATEPART(HOUR, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#hour().(expr)
    }

    override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().
//                          display_name second
//                          documentation ```kotlin\npublic open override fun <T> second(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#second().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().(queryBuilder)
        append("DATEPART(SECOND, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#second().(expr)
    }

    override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().
//                          display_name minute
//                          documentation ```kotlin\npublic open override fun <T> minute(expr: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#minute().
//                          ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().(expr)
//                               display_name expr
//                               documentation ```kotlin\nexpr: Expression<T>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().(queryBuilder)
//                                                            display_name queryBuilder
//                                                            documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().(queryBuilder)
        append("DATEPART(MINUTE, ", expr, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#minute().(expr)
    }

    override fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().
//                             display_name stdDevPop
//                             documentation ```kotlin\npublic open override fun <T> stdDevPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevPop().
//                             ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().(expression)
//                                        display_name expression
//                                        documentation ```kotlin\nexpression: Expression<T>\n```
//                                         ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().(queryBuilder)
//                                                                     display_name queryBuilder
//                                                                     documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                     ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().(queryBuilder)
        append("STDEVP(", expression, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevPop().(expression)
    }

    override fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().
//                              display_name stdDevSamp
//                              documentation ```kotlin\npublic open override fun <T> stdDevSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#stdDevSamp().
//                              ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().(expression)
//                                         display_name expression
//                                         documentation ```kotlin\nexpression: Expression<T>\n```
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                         ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().(queryBuilder)
//                                                                      display_name queryBuilder
//                                                                      documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                       ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                      ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().(queryBuilder)
        append("STDEV(", expression, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#stdDevSamp().(expression)
    }

    override fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().
//                          display_name varPop
//                          documentation ```kotlin\npublic open override fun <T> varPop(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varPop().
//                          ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().(expression)
//                                     display_name expression
//                                     documentation ```kotlin\nexpression: Expression<T>\n```
//                                      ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                     ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().(queryBuilder)
//                                                                  display_name queryBuilder
//                                                                  documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                  ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().(queryBuilder)
        append("VARP(", expression, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varPop().(expression)
    }

    override fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit = queryBuilder {
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().
//                           display_name varSamp
//                           documentation ```kotlin\npublic open override fun <T> varSamp(expression: Expression<T>, queryBuilder: QueryBuilder): Unit\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#varSamp().
//                           ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().(expression)
//                                      display_name expression
//                                      documentation ```kotlin\nexpression: Expression<T>\n```
//                                       ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().(queryBuilder)
//                                                                   display_name queryBuilder
//                                                                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
//                                                                                   ^^^^ reference semanticdb maven . . kotlin/Unit#
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().(queryBuilder)
        append("VAR(", expression, ")")
//      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                     ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#varSamp().(expression)
    }

    override fun <T> jsonExtract(
//                ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().[T]
//                  display_name FirTypeParameterSymbol T
//                  documentation ```kotlin\nT\n```
//                   ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().
//                               display_name jsonExtract
//                               documentation ```kotlin\npublic open override fun <T> jsonExtract(expression: Expression<T>, vararg path: String, toScalar: Boolean, jsonType: IColumnType<*>, queryBuilder: QueryBuilder): Unit\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#jsonExtract().
        expression: Expression<T>,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(expression)
//                 display_name expression
//                 documentation ```kotlin\nexpression: Expression<T>\n```
//                  ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
        vararg path: String,
//             ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(path)
//                  display_name path
//                  documentation ```kotlin\nvararg path: String\n```
//                   ^^^^^^ reference semanticdb maven . . kotlin/Array#
        toScalar: Boolean,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(toScalar)
//               display_name toScalar
//               documentation ```kotlin\ntoScalar: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        jsonType: IColumnType<*>,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(jsonType)
//               display_name jsonType
//               documentation ```kotlin\njsonType: IColumnType<*>\n```
//                ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#
        queryBuilder: QueryBuilder
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(queryBuilder)
//                   display_name queryBuilder
//                   documentation ```kotlin\nqueryBuilder: QueryBuilder\n```
//                    ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#
    ) {
        @OptIn(InternalApi::class)
        if (path.size > 1) {
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(path)
//               ^^^^ reference semanticdb maven . . kotlin/Array#getSize().
//               ^^^^ reference semanticdb maven . . kotlin/Array#size.
//                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
            CoreTransactionManager.currentTransaction().throwUnsupportedException("SQLServer does not support multiple JSON path arguments")
//                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
//                                                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
        }
        queryBuilder {
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#invoke().
//      ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(queryBuilder)
            append(if (toScalar) "JSON_VALUE" else "JSON_QUERY")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(toScalar)
            append("(", expression, ", ")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/append().
//                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(expression)
            path.ifEmpty { arrayOf("") }.appendTo { +"'$$it'" }
//          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#jsonExtract().(path)
//               ^^^^^^^ reference semanticdb maven . . kotlin/collections/ifEmpty().
//                         ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#appendTo(+1).
//                                                ^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                              display_name it
//                                                              documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                  ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                                                       ^^ reference semanticdb maven . . (it)
            append(")")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
        }
    }

    override fun update(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().
//                      display_name update
//                      documentation ```kotlin\npublic open override fun update(target: Table, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
        target: Table,
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(target)
//             display_name target
//             documentation ```kotlin\ntarget: Table\n```
//              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        columnsAndValues: List<Pair<Column<*>, Any?>>,
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(columnsAndValues)
//                       display_name columnsAndValues
//                       documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        limit: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        val def = super.update(target, columnsAndValues, null, where, transaction)
//          ^^^ definition local 4
//              display_name def
//              documentation ```kotlin\nlocal val def: String\n```
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(target)
//                                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(columnsAndValues)
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(where)
//                                                                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(transaction)
        return if (limit != null) def.replaceFirst("UPDATE", "UPDATE TOP($limit)") else def
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(limit)
//                                ^^^ reference local 4
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update().(limit)
//                                                                                      ^^^ reference local 4
    }

    override fun update(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).
//                      display_name update
//                      documentation ```kotlin\npublic open override fun update(targets: Join, columnsAndValues: List<Pair<Column<*>, Any?>>, limit: Int?, where: Op<Boolean>?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#update(+1).
        targets: Join,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(targets)
//              display_name targets
//              documentation ```kotlin\ntargets: Join\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
        columnsAndValues: List<Pair<Column<*>, Any?>>,
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(columnsAndValues)
//                       display_name columnsAndValues
//                       documentation ```kotlin\ncolumnsAndValues: List<Pair<Column<*>, Any?>>\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        limit: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String = with(QueryBuilder(true)) {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
//              ^^^^ reference semanticdb maven . . kotlin/with().
//                   ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
        val tableToUpdate = columnsAndValues.map { it.first.table }.distinct().singleOrNull()
//          ^^^^^^^^^^^^^ definition local 5
//                        display_name tableToUpdate
//                        documentation ```kotlin\nlocal val tableToUpdate: Table\n```
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(columnsAndValues)
//                                           ^^^ reference semanticdb maven . . kotlin/collections/map(+9).
//                                               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                  display_name it
//                                                                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                 ^^ reference semanticdb maven . . (it)
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#first.
//                                                    ^^^^^ reference semanticdb maven . . kotlin/Pair#getFirst().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                  ^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinct(+9).
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
            ?: transaction.throwUnsupportedException("SQLServer supports a join updates with a single table columns to update.")
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(transaction)
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().

        targets.checkJoinTypes(StatementType.UPDATE)
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(targets)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#UPDATE.
        if (limit != null) {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(limit)
            +"UPDATE TOP($limit) "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(limit)
        } else {
            +"UPDATE "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
        }
        tableToUpdate.describe(transaction, this)
//      ^^^^^^^^^^^^^ reference local 5
//                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(transaction)
        +" SET "
//      ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
        columnsAndValues.appendTo(this) { (col, value) ->
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(columnsAndValues)
//                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendTo().
//                                        ^^^^^^^^^^^^ definition semanticdb maven . . (`<destruct>`)
//                                                     display_name <destruct>
//                                                     documentation ```kotlin\n<destruct>: Pair<Column<*>, Any?>\n```
//                                         ^^^ definition local 6
//                                             display_name col
//                                             documentation ```kotlin\nlocal val col: Column<*>\n```
//                                         ^^^ reference semanticdb maven . . (`<destruct>`)
//                                         ^^^ reference semanticdb maven . . kotlin/Pair#component1().
//                                              ^^^^^ definition local 7
//                                                    display_name value
//                                                    documentation ```kotlin\nlocal val value: Any?\n```
//                                              ^^^^^ reference semanticdb maven . . (`<destruct>`)
//                                              ^^^^^ reference semanticdb maven . . kotlin/Pair#component2().
            append("${transaction.fullIdentity(col)}=")
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#append(+1).
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(transaction)
//                                ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#fullIdentity().
//                                             ^^^ reference local 6
            registerArgument(col, value)
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#registerArgument().
//                           ^^^ reference local 6
//                                ^^^^^ reference local 7
        }

        appendJoinPartForUpdateClause(tableToUpdate, targets, transaction)
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPartForUpdateClause().
//                                    ^^^^^^^^^^^^^ reference local 5
//                                                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(targets)
//                                                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(transaction)

        where?.let {
//      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#update(+1).(where)
//             ^^^ reference semanticdb maven . . kotlin/let().
//                 ^ definition semanticdb maven . . (it) 3:9
//                   display_name it
//                   documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
            +" AND "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
            +it
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//           ^^ reference semanticdb maven . . (it)
        }
        toString()
//      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
    }

    override fun upsert(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().
//                      display_name upsert
//                      documentation ```kotlin\npublic open override fun upsert(table: Table, data: List<Pair<Column<*>, Any?>>, expression: String, onUpdate: List<Pair<Column<*>, Any?>>, keyColumns: List<Column<*>>, where: Op<Boolean>?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
        table: Table,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(table)
//            display_name table
//            documentation ```kotlin\ntable: Table\n```
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        data: List<Pair<Column<*>, Any?>>,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(data)
//           display_name data
//           documentation ```kotlin\ndata: List<Pair<Column<*>, Any?>>\n```
//            ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        expression: String,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(expression)
//                 display_name expression
//                 documentation ```kotlin\nexpression: String\n```
//                  ^^^^^^ reference semanticdb maven . . kotlin/String#
        onUpdate: List<Pair<Column<*>, Any?>>,
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(onUpdate)
//               display_name onUpdate
//               documentation ```kotlin\nonUpdate: List<Pair<Column<*>, Any?>>\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        keyColumns: List<Column<*>>,
//      ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(keyColumns)
//                 display_name keyColumns
//                 documentation ```kotlin\nkeyColumns: List<Column<*>>\n```
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        // SQLSERVER MERGE statement must be terminated by a semi-colon (;)
        return super.upsert(table, data, expression, onUpdate, keyColumns, where, transaction) + ";"
//                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#upsert().
//                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(table)
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(data)
//                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(expression)
//                                                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(onUpdate)
//                                                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(keyColumns)
//                                                                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(where)
//                                                                                ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#upsert().(transaction)
//                                                                                             ^ reference semanticdb maven . . kotlin/String#plus().
    }

    override fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String {
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().
//                      display_name delete
//                      documentation ```kotlin\npublic open override fun delete(ignore: Boolean, table: Table, where: String?, limit: Int?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(ignore)
//                             display_name ignore
//                             documentation ```kotlin\nignore: Boolean\n```
//                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(table)
//                                             display_name table
//                                             documentation ```kotlin\ntable: Table\n```
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(where)
//                                                           display_name where
//                                                           documentation ```kotlin\nwhere: String?\n```
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                     ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(limit)
//                                                                           display_name limit
//                                                                           documentation ```kotlin\nlimit: Int?\n```
//                                                                            ^^^^ reference semanticdb maven . . kotlin/Int#
//                                                                                  ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(transaction)
//                                                                                              display_name transaction
//                                                                                              documentation ```kotlin\ntransaction: Transaction\n```
//                                                                                               ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
        val def = super.delete(ignore, table, where, null, transaction)
//          ^^^ definition local 8
//              display_name def
//              documentation ```kotlin\nlocal val def: String\n```
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(ignore)
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(table)
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(where)
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(transaction)
        return if (limit != null) def.replaceFirst("DELETE", "DELETE TOP($limit)") else def
//                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(limit)
//                                ^^^ reference local 8
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/replaceFirst(+1).
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete().(limit)
//                                                                                      ^^^ reference local 8
    }

    override fun delete(
//               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).
//                      display_name delete
//                      documentation ```kotlin\npublic open override fun delete(ignore: Boolean, targets: Join, targetTables: List<Table>, where: Op<Boolean>?, limit: Int?, transaction: Transaction): String\n```
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#delete(+1).
        ignore: Boolean,
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(ignore)
//             display_name ignore
//             documentation ```kotlin\nignore: Boolean\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        targets: Join,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(targets)
//              display_name targets
//              documentation ```kotlin\ntargets: Join\n```
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Join#
        targetTables: List<Table>,
//      ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(targetTables)
//                   display_name targetTables
//                   documentation ```kotlin\ntargetTables: List<Table>\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        where: Op<Boolean>?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(where)
//            display_name where
//            documentation ```kotlin\nwhere: Op<Boolean>?\n```
//             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        limit: Int?,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(limit)
//            display_name limit
//            documentation ```kotlin\nlimit: Int?\n```
//             ^^^^ reference semanticdb maven . . kotlin/Int#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        if (ignore) {
//          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(ignore)
            transaction.throwUnsupportedException("SQL Server doesn't support IGNORE in DELETE from join relation")
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(transaction)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
        }
        val tableToDelete = targetTables.singleOrNull()
//          ^^^^^^^^^^^^^ definition local 9
//                        display_name tableToDelete
//                        documentation ```kotlin\nlocal val tableToDelete: Table\n```
//                          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(targetTables)
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
            ?: transaction.throwUnsupportedException(
//             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(transaction)
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
                "SQL Server doesn't support DELETE from join relation with multiple tables to delete from"
            )
        targets.checkJoinTypes(StatementType.DELETE)
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(targets)
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#checkJoinTypes().
//                                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/StatementType#DELETE.

        return with(QueryBuilder(true)) {
//             ^^^^ reference semanticdb maven . . kotlin/with().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#`<init>`().
            +"DELETE "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
            limit?.let {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(limit)
//                 ^^^ reference semanticdb maven . . kotlin/let().
//                     ^ definition semanticdb maven . . (it) 2:13
//                       display_name it
//                       documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
                +"TOP($it) "
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//                     ^^ reference semanticdb maven . . (it)
            }
            +"FROM "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
            if (tableToDelete is Alias<*>) {
//              ^^^^^^^^^^^^^ reference local 9
                +tableToDelete.alias
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
//               ^^^^^^^^^^^^^ reference local 9
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#alias.
//                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Alias#getAlias().
            } else {
                tableToDelete.describe(transaction, this)
//              ^^^^^^^^^^^^^ reference local 9
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#describe().
//                                     ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(transaction)
            }
            +" FROM "
//          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
            appendJoinPart(tableToDelete, targets, transaction, filterTargetTable = false)
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#appendJoinPart().
//                         ^^^^^^^^^^^^^ reference local 9
//                                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(targets)
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(transaction)
            where?.let {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#delete(+1).(where)
//                 ^^^ reference semanticdb maven . . kotlin/let().
//                     ^ definition semanticdb maven . . (it) 3:13
//                       display_name it
//                       documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
                +" AND "
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+1).
                +it
//              ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#unaryPlus(+2).
//               ^^ reference semanticdb maven . . (it)
            }
            toString()
//          ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryBuilder#toString().
        }
    }

    override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String = buildString {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().
//                                   display_name queryLimitAndOffset
//                                   documentation ```kotlin\npublic open override fun queryLimitAndOffset(size: Int?, offset: Long, alreadyOrdered: Boolean): String\n```
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#queryLimitAndOffset().
//                                   ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(size)
//                                        display_name size
//                                        documentation ```kotlin\nsize: Int?\n```
//                                         ^^^^ reference semanticdb maven . . kotlin/Int#
//                                               ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(offset)
//                                                      display_name offset
//                                                      documentation ```kotlin\noffset: Long\n```
//                                                       ^^^^ reference semanticdb maven . . kotlin/Long#
//                                                             ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
//                                                                            display_name alreadyOrdered
//                                                                            documentation ```kotlin\nalreadyOrdered: Boolean\n```
//                                                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
        if (!alreadyOrdered) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(alreadyOrdered)
            append("ORDER BY(SELECT NULL) ")
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
        }
        append("OFFSET $offset ROWS")
//      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(offset)
        size?.let {
//      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(size)
//            ^^^ reference semanticdb maven . . kotlin/let().
//                ^ definition semanticdb maven . . (it) 2:9
//                  display_name it
//                  documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
            append(" FETCH NEXT $size ROWS ONLY")
//          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#queryLimitAndOffset().(size)
        }
    }

    override fun explain(
//               ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().
//                       display_name explain
//                       documentation ```kotlin\npublic open override fun explain(analyze: Boolean, options: String?, internalStatement: String, transaction: Transaction): String\n```
//                       relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#explain().
        analyze: Boolean,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().(analyze)
//              display_name analyze
//              documentation ```kotlin\nanalyze: Boolean\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        options: String?,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().(options)
//              display_name options
//              documentation ```kotlin\noptions: String?\n```
//               ^^^^^^^ reference semanticdb maven . . kotlin/String#
        internalStatement: String,
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().(internalStatement)
//                        display_name internalStatement
//                        documentation ```kotlin\ninternalStatement: String\n```
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
        transaction: Transaction
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        transaction.throwUnsupportedException(
//      ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#explain().(transaction)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
            "EXPLAIN queries are not currently supported for SQL Server. Please log a YouTrack feature extension request."
        )
    }

    override fun merge(dest: Table, source: Table, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>?): String {
//               ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().
//                     display_name merge
//                     documentation ```kotlin\npublic open override fun merge(dest: Table, source: Table, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>?): String\n```
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                     ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(dest)
//                          display_name dest
//                          documentation ```kotlin\ndest: Table\n```
//                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                  ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(source)
//                                         display_name source
//                                         documentation ```kotlin\nsource: Table\n```
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                                                 ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(transaction)
//                                                             display_name transaction
//                                                             documentation ```kotlin\ntransaction: Transaction\n```
//                                                              ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                           ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(clauses)
//                                                                                   display_name clauses
//                                                                                   documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                                    ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                                                                                 ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(on)
//                                                                                                                    display_name on
//                                                                                                                    documentation ```kotlin\non: Op<Boolean>?\n```
//                                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                                                                                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
        validateMergeCommandClauses(transaction, clauses)
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(transaction)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(clauses)
        return super.merge(dest, source, transaction, clauses, on) + ";"
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#merge().
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(dest)
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(source)
//                                       ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(transaction)
//                                                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(clauses)
//                                                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#merge().(on)
//                                                                 ^ reference semanticdb maven . . kotlin/String#plus().
    }

    override fun mergeSelect(
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().
//                           display_name mergeSelect
//                           documentation ```kotlin\npublic open override fun mergeSelect(dest: Table, source: QueryAlias, transaction: Transaction, clauses: List<MergeStatement.Clause>, on: Op<Boolean>, prepared: Boolean): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
        dest: Table,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(dest)
//           display_name dest
//           documentation ```kotlin\ndest: Table\n```
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
        source: QueryAlias,
//      ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(source)
//             display_name source
//             documentation ```kotlin\nsource: QueryAlias\n```
//              ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/QueryAlias#
        transaction: Transaction,
//      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(transaction)
//                  display_name transaction
//                  documentation ```kotlin\ntransaction: Transaction\n```
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
        clauses: List<MergeStatement.Clause>,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(clauses)
//              display_name clauses
//              documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        on: Op<Boolean>,
//      ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(on)
//         display_name on
//         documentation ```kotlin\non: Op<Boolean>\n```
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
        prepared: Boolean
//      ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(prepared)
//               display_name prepared
//               documentation ```kotlin\nprepared: Boolean\n```
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        validateMergeCommandClauses(transaction, clauses)
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(transaction)
//                                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(clauses)
        return super.mergeSelect(dest, source, transaction, clauses, on, prepared) + ";"
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/FunctionProvider#mergeSelect().
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(dest)
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(source)
//                                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(transaction)
//                                                          ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(clauses)
//                                                                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(on)
//                                                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerFunctionProvider#mergeSelect().(prepared)
//                                                                                 ^ reference semanticdb maven . . kotlin/String#plus().
    }
}

private fun validateMergeCommandClauses(transaction: Transaction, clauses: List<MergeStatement.Clause>) {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().
//                                      display_name validateMergeCommandClauses
//                                      documentation ```kotlin\nprivate final fun validateMergeCommandClauses(transaction: Transaction, clauses: List<MergeStatement.Clause>): Unit\n```
//                                      ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                                                  display_name transaction
//                                                  documentation ```kotlin\ntransaction: Transaction\n```
//                                                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
//                                                                ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//                                                                        display_name clauses
//                                                                        documentation ```kotlin\nclauses: List<MergeStatement.Clause>\n```
//                                                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
    when {
        clauses.count { it.action == INSERT } > 1 ->
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//              ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                            display_name it
//                                            documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#INSERT.
//                                            ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
            transaction.throwUnsupportedException("Multiple insert clauses are not supported by DB")
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
        clauses.count { it.action == UPDATE } > 1 ->
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//              ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                            display_name it
//                                            documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#UPDATE.
//                                            ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
            transaction.throwUnsupportedException("Multiple update clauses are not supported by DB")
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
        clauses.count { it.action == DELETE } > 1 ->
//      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(clauses)
//              ^^^^^ reference semanticdb maven . . kotlin/collections/count(+20).
//                    ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                            display_name it
//                                            documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                      ^^ reference semanticdb maven . . (it)
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#action.
//                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#Clause#getAction().
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/MergeStatement#ClauseAction#DELETE.
//                                            ^ reference semanticdb maven . . kotlin/Int#compareTo(+2).
            transaction.throwUnsupportedException("Multiple delete clauses are not supported by DB")
//          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/validateMergeCommandClauses().(transaction)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/exceptions/throwUnsupportedException().
    }
}

/**
 * SQLServer dialect implementation.
 */
open class SQLServerDialect : VendorDialect(dialectName, SQLServerDataTypeProvider, SQLServerFunctionProvider) {
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#
//                          display_name SQLServerDialect
//                          documentation ```kotlin\npublic open class SQLServerDialect : VendorDialect\n```\n\n----\n\n\n SQLServer dialect implementation.\n
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//         ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#`<init>`().
//                          display_name SQLServerDialect
//                          documentation ```kotlin\npublic constructor(): SQLServerDialect\n```\n\n----\n\n\n SQLServer dialect implementation.\n
//                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#dialectName.
//                                          ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#getDialectName().
    override val supportsIfNotExists: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getSupportsIfNotExists().
//                                   display_name supportsIfNotExists
//                                   documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#supportsIfNotExists.
//                                   display_name supportsIfNotExists
//                                   documentation ```kotlin\npublic open override val supportsIfNotExists: Boolean\n```
//                                    ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val defaultReferenceOption: ReferenceOption get() = ReferenceOption.NO_ACTION
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#defaultReferenceOption.
//                                      display_name defaultReferenceOption
//                                      documentation ```kotlin\npublic open override val defaultReferenceOption: ReferenceOption\n```
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                                                       ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getDefaultReferenceOption().
//                                                           display_name defaultReferenceOption
//                                                           documentation ```kotlin\npublic get(): ReferenceOption\n```
//                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#NO_ACTION.
    override val needsQuotesWhenSymbolsInNames: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getNeedsQuotesWhenSymbolsInNames().
//                                             display_name needsQuotesWhenSymbolsInNames
//                                             documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#needsQuotesWhenSymbolsInNames.
//                                             display_name needsQuotesWhenSymbolsInNames
//                                             documentation ```kotlin\npublic open override val needsQuotesWhenSymbolsInNames: Boolean\n```
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val supportsSequenceAsGeneratedKeys: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getSupportsSequenceAsGeneratedKeys().
//                                               display_name supportsSequenceAsGeneratedKeys
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#supportsSequenceAsGeneratedKeys.
//                                               display_name supportsSequenceAsGeneratedKeys
//                                               documentation ```kotlin\npublic open override val supportsSequenceAsGeneratedKeys: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val supportsOnlyIdentifiersInGeneratedKeys: Boolean = true
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getSupportsOnlyIdentifiersInGeneratedKeys().
//                                                      display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                      documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#supportsOnlyIdentifiersInGeneratedKeys.
//                                                      display_name supportsOnlyIdentifiersInGeneratedKeys
//                                                      documentation ```kotlin\npublic open override val supportsOnlyIdentifiersInGeneratedKeys: Boolean\n```
//                                                       ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    override val supportsRestrictReferenceOption: Boolean = false
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getSupportsRestrictReferenceOption().
//                                               display_name supportsRestrictReferenceOption
//                                               documentation ```kotlin\npublic get(): Boolean\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#supportsRestrictReferenceOption.
//                                               display_name supportsRestrictReferenceOption
//                                               documentation ```kotlin\npublic open override val supportsRestrictReferenceOption: Boolean\n```
//                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

    private val nonAcceptableDefaults = arrayOf("DEFAULT")
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getNonAcceptableDefaults().
//                                    display_name nonAcceptableDefaults
//                                    documentation ```kotlin\nprivate get(): Array<String>\n```
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#nonAcceptableDefaults.
//                                    display_name nonAcceptableDefaults
//                                    documentation ```kotlin\nprivate final val nonAcceptableDefaults: Array<String>\n```
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/arrayOf().

    override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean {
//               ^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#isAllowedAsColumnDefault().
//                                        display_name isAllowedAsColumnDefault
//                                        documentation ```kotlin\npublic open override fun isAllowedAsColumnDefault(e: Expression<*>): Boolean\n```
//                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                        ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#isAllowedAsColumnDefault().(e)
//                                          display_name e
//                                          documentation ```kotlin\ne: Expression<*>\n```
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#
//                                                           ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val columnDefault = e.toString().uppercase().trim()
//          ^^^^^^^^^^^^^ definition local 10
//                        display_name columnDefault
//                        documentation ```kotlin\nlocal val columnDefault: String\n```
//                          ^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#isAllowedAsColumnDefault().(e)
//                            ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Expression#toString().
//                                       ^^^^^^^^^ reference semanticdb maven . . kotlin/text/uppercase(+2).
//                                                   ^^^^ reference semanticdb maven . . kotlin/text/trim(+5).
        return columnDefault !in nonAcceptableDefaults
//             ^^^^^^^^^^^^^ reference local 10
//                           ^^^ reference semanticdb maven . . kotlin/Boolean#not().
//                           ^^^ reference semanticdb maven . . kotlin/collections/contains().
//                               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getNonAcceptableDefaults().
//                               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#nonAcceptableDefaults.
    }

    override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String> {
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().
//                            display_name modifyColumn
//                            documentation ```kotlin\npublic open override fun modifyColumn(column: Column<*>, columnDiff: ColumnDiff): List<String>\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#modifyColumn().
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                   display_name column
//                                   documentation ```kotlin\ncolumn: Column<*>\n```
//                                    ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(columnDiff)
//                                                          display_name columnDiff
//                                                          documentation ```kotlin\ncolumnDiff: ColumnDiff\n```
//                                                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
        @OptIn(InternalApi::class)
        val transaction = CoreTransactionManager.currentTransaction()
//          ^^^^^^^^^^^ definition local 11
//                      display_name transaction
//                      documentation ```kotlin\n@OptIn(...) local val transaction: Transaction\n```
//                                               ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().

        val alterTablePart = "ALTER TABLE ${transaction.identity(column.table)} "
//          ^^^^^^^^^^^^^^ definition local 12
//                         display_name alterTablePart
//                         documentation ```kotlin\nlocal val alterTablePart: String\n```
//                                          ^^^^^^^^^^^ reference local 11
//                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.

        val statements = mutableListOf<String>()
//          ^^^^^^^^^^ definition local 13
//                     display_name statements
//                     documentation ```kotlin\nlocal val statements: MutableList<String>\n```
//                       ^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/mutableListOf().

        val autoIncColumnType = column.autoIncColumnType
//          ^^^^^^^^^^^^^^^^^ definition local 14
//                            display_name autoIncColumnType
//                            documentation ```kotlin\nlocal val autoIncColumnType: AutoIncColumnType<*>?\n```
//                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/autoIncColumnType.
//                                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getAutoIncColumnType().
        val replaceWithNewColumn = columnDiff.autoInc && autoIncColumnType != null && autoIncColumnType.sequence == null
//          ^^^^^^^^^^^^^^^^^^^^ definition local 15
//                               display_name replaceWithNewColumn
//                               documentation ```kotlin\nlocal val replaceWithNewColumn: Boolean\n```
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(columnDiff)
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#autoInc.
//                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getAutoInc().
//                                                       ^^^^^^^^^^^^^^^^^ reference local 14
//                                                                                    ^^^^^^^^^^^^^^^^^ reference local 14
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#getSequence().
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/AutoIncColumnType#sequence.

        statements.add(
//      ^^^^^^^^^^ reference local 13
//                 ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
            buildString {
//          ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
                if (replaceWithNewColumn) {
//                  ^^^^^^^^^^^^^^^^^^^^ reference local 15
                    append(alterTablePart + "ADD NEW_${transaction.identity(column)} ${column.columnType.sqlType()}")
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                         ^^^^^^^^^^^^^^ reference local 12
//                                        ^ reference semanticdb maven . . kotlin/String#plus().
//                                                     ^^^^^^^^^^^ reference local 11
//                                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                       ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                } else {
                    append(alterTablePart + "ALTER COLUMN ${transaction.identity(column)} ${column.columnType.sqlType()}")
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                         ^^^^^^^^^^^^^^ reference local 12
//                                        ^ reference semanticdb maven . . kotlin/String#plus().
//                                                          ^^^^^^^^^^^ reference local 11
//                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                                                                                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                                                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#sqlType().
                }

                if (columnDiff.nullability) {
//                  ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(columnDiff)
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getNullability().
//                             ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#nullability.
                    val defaultValue = column.dbDefaultValue
//                      ^^^^^^^^^^^^ definition local 16
//                                   display_name defaultValue
//                                   documentation ```kotlin\nlocal val defaultValue: Expression<out Any?>?\n```
//                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                                            ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
                    val isPKColumn = column.table.primaryKey?.columns?.contains(column) == true
//                      ^^^^^^^^^^ definition local 17
//                                 display_name isPKColumn
//                                 documentation ```kotlin\nlocal val isPKColumn: Boolean\n```
//                                   ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getPrimaryKey().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#primaryKey.
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#columns.
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#PrimaryKey#getColumns().
//                                                                     ^^^^^^^^ reference semanticdb maven . . kotlin/collections/contains().
//                                                                              ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)

                    if (column.columnType.nullable ||
//                      ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#columnType.
//                             ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getColumnType().
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#getNullable().
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#nullable.
//                                        ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/IColumnType#setNullable().
                        (defaultValue != null && column.defaultValueFun == null && !currentDialect.isAllowedAsColumnDefault(defaultValue))
//                       ^^^^^^^^^^^^ reference local 16
//                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#defaultValueFun.
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDefaultValueFun().
//                                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDefaultValueFun().
//                                                                                 ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                 ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#isAllowedAsColumnDefault().
//                                                                                                                          ^^^^^^^^^^^^ reference local 16
                    ) {
                        append(" NULL")
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                    } else if (!isPKColumn) {
//                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                              ^^^^^^^^^^ reference local 17
                        append(" NOT NULL")
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                    }
                }
            }
        )

        if (columnDiff.defaults) {
//          ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(columnDiff)
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#defaults.
//                     ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ColumnDiff#getDefaults().
            val tableName = column.table.tableName
//              ^^^^^^^^^ definition local 18
//                        display_name tableName
//                        documentation ```kotlin\nlocal val tableName: String\n```
//                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
            val columnName = column.name
//              ^^^^^^^^^^ definition local 19
//                         display_name columnName
//                         documentation ```kotlin\nlocal val columnName: String\n```
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
            val constraintName = "DF_${tableName}_$columnName"
//              ^^^^^^^^^^^^^^ definition local 20
//                             display_name constraintName
//                             documentation ```kotlin\nlocal val constraintName: String\n```
//                                     ^^^^^^^^^ reference local 18
//                                                 ^^^^^^^^^^ reference local 19

            val dropConstraint = "DROP CONSTRAINT IF EXISTS $constraintName"
//              ^^^^^^^^^^^^^^ definition local 21
//                             display_name dropConstraint
//                             documentation ```kotlin\nlocal val dropConstraint: String\n```
//                                                           ^^^^^^^^^^^^^^ reference local 20

            statements.add(
//          ^^^^^^^^^^ reference local 13
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
                buildString {
//              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
                    column.dbDefaultValue?.let {
//                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dbDefaultValue.
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getDbDefaultValue().
//                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#setDbDefaultValue().
//                                         ^^^ reference semanticdb maven . . kotlin/let().
//                                             ^ definition semanticdb maven . . (it) 7:21
//                                               display_name it
//                                               documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
                        append(alterTablePart + dropConstraint)
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                             ^^^^^^^^^^^^^^ reference local 12
//                                            ^ reference semanticdb maven . . kotlin/String#plus().
//                                              ^^^^^^^^^^^^^^ reference local 21
                        append("; ")
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                        append(
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                            alterTablePart +
//                          ^^^^^^^^^^^^^^ reference local 12
//                                         ^ reference semanticdb maven . . kotlin/String#plus().
                                "ADD CONSTRAINT $constraintName DEFAULT ${SQLServerDataTypeProvider.processForDefaultValue(it)} for ${transaction.identity(column)}"
//                                               ^^^^^^^^^^^^^^ reference local 20
//                                                                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DataTypeProvider#processForDefaultValue().
//                                                                                                                         ^^ reference semanticdb maven . . (it)
//                                                                                                                                    ^^^^^^^^^^^ reference local 11
//                                                                                                                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                                                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
                        )
                    } ?: append(alterTablePart + dropConstraint)
//                       ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                              ^^^^^^^^^^^^^^ reference local 12
//                                             ^ reference semanticdb maven . . kotlin/String#plus().
//                                               ^^^^^^^^^^^^^^ reference local 21
                }
            )
        }

        if (replaceWithNewColumn) {
//          ^^^^^^^^^^^^^^^^^^^^ reference local 15
            with(statements) {
//          ^^^^ reference semanticdb maven . . kotlin/with().
//               ^^^^^^^^^^ reference local 13
                add(alterTablePart + "DROP COLUMN ${transaction.identity(column)}")
//              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                  ^^^^^^^^^^^^^^ reference local 12
//                                 ^ reference semanticdb maven . . kotlin/String#plus().
//                                                  ^^^^^^^^^^^ reference local 11
//                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
                add("EXEC sp_rename '${transaction.identity(column.table)}.NEW_${transaction.identity(column)}', '${transaction.identity(column)}', 'COLUMN'")
//              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                     ^^^^^^^^^^^ reference local 11
//                                                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                                          ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                                               ^^^^^^^^^^^ reference local 11
//                                                                                           ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
//                                                                                                                  ^^^^^^^^^^^ reference local 11
//                                                                                                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                                                                                                       ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#modifyColumn().(column)
            }
        }

        return statements
//             ^^^^^^^^^^ reference local 13
    }

    @OptIn(InternalApi::class)
    override fun createDatabase(name: String): String = "CREATE DATABASE ${name.inProperCase()}"
//               ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createDatabase().
//                              display_name createDatabase
//                              documentation ```kotlin\n@OptIn(...) public open override fun createDatabase(name: String): String\n```
//                              relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createDatabase().
//                              ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createDatabase().(name)
//                                   display_name name
//                                   documentation ```kotlin\nname: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createDatabase().(name)
//                                                                              ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().

    override fun listDatabases(): String = "SELECT name FROM sys.databases"
//               ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#listDatabases().
//                             display_name listDatabases
//                             documentation ```kotlin\npublic open override fun listDatabases(): String\n```
//                             relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#listDatabases().
//                                ^^^^^^ reference semanticdb maven . . kotlin/String#

    @OptIn(InternalApi::class)
    override fun dropDatabase(name: String) = "DROP DATABASE ${name.inProperCase()}"
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropDatabase().
//                            display_name dropDatabase
//                            documentation ```kotlin\n@OptIn(...) public open override fun dropDatabase(name: String): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropDatabase().
//                            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropDatabase().(name)
//                                 display_name name
//                                 documentation ```kotlin\nname: String\n```
//                                  ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropDatabase().(name)
//                                                                  ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().

    override fun setSchema(schema: Schema): String = "ALTER USER ${schema.authorization} WITH DEFAULT_SCHEMA = ${schema.identifier}"
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#setSchema().
//                         display_name setSchema
//                         documentation ```kotlin\npublic open override fun setSchema(schema: Schema): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#setSchema().
//                         ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#setSchema().(schema)
//                                display_name schema
//                                documentation ```kotlin\nschema: Schema\n```
//                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                 ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#setSchema().(schema)
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
//                                                                                                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#setSchema().(schema)
//                                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                                                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.

    override fun createSchema(schema: Schema): String = buildString {
//               ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createSchema().
//                            display_name createSchema
//                            documentation ```kotlin\npublic open override fun createSchema(schema: Schema): String\n```
//                            relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createSchema().
//                            ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createSchema().(schema)
//                                   display_name schema
//                                   documentation ```kotlin\nschema: Schema\n```
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
        append("CREATE SCHEMA ", schema.identifier)
//      ^^^^^^ reference semanticdb maven . . kotlin/text/append(+4).
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createSchema().(schema)
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                      ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.
        appendIfNotNull(" AUTHORIZATION ", schema.authorization)
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/appendIfNotNull().
//                                         ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createSchema().(schema)
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#authorization.
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getAuthorization().
    }

    override fun dropSchema(schema: Schema, cascade: Boolean): String = "DROP SCHEMA ${schema.identifier}"
//               ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropSchema().
//                          display_name dropSchema
//                          documentation ```kotlin\npublic open override fun dropSchema(schema: Schema, cascade: Boolean): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropSchema().
//                          ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropSchema().(schema)
//                                 display_name schema
//                                 documentation ```kotlin\nschema: Schema\n```
//                                  ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#
//                                          ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropSchema().(cascade)
//                                                  display_name cascade
//                                                  documentation ```kotlin\ncascade: Boolean\n```
//                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                                                     ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropSchema().(schema)
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#getIdentifier().
//                                                                                            ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Schema#identifier.

    override fun createIndex(index: Index): String {
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().
//                           display_name createIndex
//                           documentation ```kotlin\npublic open override fun createIndex(index: Index): String\n```
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().(index)
//                                 display_name index
//                                 documentation ```kotlin\nindex: Index\n```
//                                  ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                          ^^^^^^ reference semanticdb maven . . kotlin/String#
        if (index.functions != null) {
//          ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().(index)
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
            exposedLogger.warn(
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//          ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                        ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                "Functional index on ${index.table.tableName} using ${index.functions.joinToString { it.toString() }} can't be created in SQLServer"
//                                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().(index)
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableName.
//                                                                    ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().(index)
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                 ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                   display_name it
//                                                                                                                   documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                   ^^ reference semanticdb maven . . (it)
//                                                                                                      ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
            )
            return ""
        }
        return super.createIndex(index)
//                   ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndex().
//                               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndex().(index)
    }

    override fun createIndexWithType(
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().
//                                   display_name createIndexWithType
//                                   documentation ```kotlin\nprotected open override fun createIndexWithType(name: String, table: String, columns: String, type: String, filterCondition: String): String\n```
//                                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#createIndexWithType().
        name: String,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(name)
//           display_name name
//           documentation ```kotlin\nname: String\n```
//            ^^^^^^ reference semanticdb maven . . kotlin/String#
        table: String,
//      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(table)
//            display_name table
//            documentation ```kotlin\ntable: String\n```
//             ^^^^^^ reference semanticdb maven . . kotlin/String#
        columns: String,
//      ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(columns)
//              display_name columns
//              documentation ```kotlin\ncolumns: String\n```
//               ^^^^^^ reference semanticdb maven . . kotlin/String#
        type: String,
//      ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(type)
//           display_name type
//           documentation ```kotlin\ntype: String\n```
//            ^^^^^^ reference semanticdb maven . . kotlin/String#
        filterCondition: String
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(filterCondition)
//                      display_name filterCondition
//                      documentation ```kotlin\nfilterCondition: String\n```
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
    ): String {
//     ^^^^^^ reference semanticdb maven . . kotlin/String#
        return "CREATE $type INDEX $name ON $table $columns$filterCondition"
//                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(type)
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(name)
//                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(table)
//                                                  ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(columns)
//                                                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#createIndexWithType().(filterCondition)
    }

    override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String {
//               ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().
//                         display_name dropIndex
//                         documentation ```kotlin\npublic open override fun dropIndex(tableName: String, indexName: String, isUnique: Boolean, isPartialOrFunctional: Boolean): String\n```
//                         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#dropIndex().
//                         ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(tableName)
//                                   display_name tableName
//                                   documentation ```kotlin\ntableName: String\n```
//                                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                            ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(indexName)
//                                                      display_name indexName
//                                                      documentation ```kotlin\nindexName: String\n```
//                                                       ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                               ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(isUnique)
//                                                                        display_name isUnique
//                                                                        documentation ```kotlin\nisUnique: Boolean\n```
//                                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                  ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(isPartialOrFunctional)
//                                                                                                        display_name isPartialOrFunctional
//                                                                                                        documentation ```kotlin\nisPartialOrFunctional: Boolean\n```
//                                                                                                         ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#
        return if (isUnique && !isPartialOrFunctional) {
//                 ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(isUnique)
//                             ^ reference semanticdb maven . . kotlin/Boolean#not().
//                              ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(isPartialOrFunctional)
            "ALTER TABLE ${identifierManager.quoteIfNecessary(tableName)} DROP CONSTRAINT IF EXISTS ${identifierManager.quoteIfNecessary(indexName)}"
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(tableName)
//                                                                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                                                                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(indexName)
        } else {
            "DROP INDEX IF EXISTS ${identifierManager.cutIfNecessaryAndQuote(indexName)} ON ${identifierManager.quoteIfNecessary(tableName)}"
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(indexName)
//                                                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#getIdentifierManager().
//                                                                                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#identifierManager.
//                                                                                                              ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#quoteIfNecessary().
//                                                                                                                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#dropIndex().(tableName)
        }
    }

    // https://docs.microsoft.com/en-us/sql/t-sql/language-elements/like-transact-sql?redirectedfrom=MSDN&view=sql-server-ver15#arguments
    override val likePatternSpecialChars = sqlServerLikePatternSpecialChars
//               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#getLikePatternSpecialChars().
//                                       display_name likePatternSpecialChars
//                                       documentation ```kotlin\npublic get(): Map<Char, Char?>\n```
//               ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#likePatternSpecialChars.
//                                       display_name likePatternSpecialChars
//                                       documentation ```kotlin\npublic open override val likePatternSpecialChars: Map<Char, Char?>\n```
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#getSqlServerLikePatternSpecialChars().
//                                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#sqlServerLikePatternSpecialChars.

    companion object : DialectNameProvider("SQLServer") {
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion# 2:5
//                                                        display_name Companion
//                                                        documentation ```kotlin\npublic final companion object Companion : VendorDialect.DialectNameProvider\n```
//                                                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#`<init>`(). 2:5
//                                                        display_name Companion
//                                                        documentation ```kotlin\nprivate constructor(): SQLServerDialect.Companion\n```
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/VendorDialect#DialectNameProvider#
        private val sqlServerLikePatternSpecialChars = mapOf('%' to null, '_' to null, '[' to ']')
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#getSqlServerLikePatternSpecialChars().
//                                                   display_name sqlServerLikePatternSpecialChars
//                                                   documentation ```kotlin\nprivate get(): Map<Char, Char?>\n```
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLServerDialect#Companion#sqlServerLikePatternSpecialChars.
//                                                   display_name sqlServerLikePatternSpecialChars
//                                                   documentation ```kotlin\nprivate final val sqlServerLikePatternSpecialChars: Map<Char, Char?>\n```
//                                                     ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf(+1).
//                                                               ^^ reference semanticdb maven . . kotlin/to().
//                                                                            ^^ reference semanticdb maven . . kotlin/to().
//                                                                                         ^^ reference semanticdb maven . . kotlin/to().
    }
}
