package org.jetbrains.exposed.v1.core
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/

/**
 * API marked with this annotation is experimental.
 * Any behavior associated with its use is not guaranteed to be stable.
 */
@RequiresOptIn(
    message = "This database migration API is experimental. " +
        "Its usage must be marked with '@OptIn(org.jetbrains.exposed.v1.sql.ExperimentalDatabaseMigrationApi::class)' " +
        "or '@org.jetbrains.exposed.v1.sql.ExperimentalDatabaseMigrationApi'."
)
@Target(AnnotationTarget.FUNCTION)
//                       ^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#FUNCTION.
annotation class ExperimentalDatabaseMigrationApi
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExperimentalDatabaseMigrationApi#
//                                                display_name ExperimentalDatabaseMigrationApi
//                                                documentation ```kotlin\n@RequiresOptIn(...) @Target(...) public final annotation class ExperimentalDatabaseMigrationApi : Annotation\n```\n\n----\n\n\n API marked with this annotation is experimental.\n Any behavior associated with its use is not guaranteed to be stable.\n
//                                                relationship is_reference is_implementation semanticdb maven . . kotlin/Annotation#
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExperimentalDatabaseMigrationApi#`<init>`().
//                                                display_name ExperimentalDatabaseMigrationApi
//                                                documentation ```kotlin\npublic constructor(): ExperimentalDatabaseMigrationApi\n```\n\n----\n\n\n API marked with this annotation is experimental.\n Any behavior associated with its use is not guaranteed to be stable.\n

/**
 * API marked with this annotation is experimental.
 * Any behavior associated with its use is not guaranteed to be stable.
 */
@RequiresOptIn(
    message = "This API is experimental and the behavior defined by setting this value to 'true' is now the default. " +
        "Its usage must be marked with '@OptIn(org.jetbrains.exposed.v1.sql.ExperimentalKeywordApi::class)' " +
        "or '@org.jetbrains.exposed.v1.sql.ExperimentalKeywordApi'."
)
@Target(AnnotationTarget.PROPERTY)
//                       ^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#PROPERTY.
annotation class ExperimentalKeywordApi
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExperimentalKeywordApi#
//                                      display_name ExperimentalKeywordApi
//                                      documentation ```kotlin\n@RequiresOptIn(...) @Target(...) public final annotation class ExperimentalKeywordApi : Annotation\n```\n\n----\n\n\n API marked with this annotation is experimental.\n Any behavior associated with its use is not guaranteed to be stable.\n
//                                      relationship is_reference is_implementation semanticdb maven . . kotlin/Annotation#
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ExperimentalKeywordApi#`<init>`().
//                                      display_name ExperimentalKeywordApi
//                                      documentation ```kotlin\npublic constructor(): ExperimentalKeywordApi\n```\n\n----\n\n\n API marked with this annotation is experimental.\n Any behavior associated with its use is not guaranteed to be stable.\n

/**
 * API marked with this annotation is internal and should not be used outside Exposed.
 * It may be changed or removed in the future without notice.
 * Using it outside Exposed may result in undefined and unexpected behaviour.
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
//                              ^^^^^ reference semanticdb maven . . kotlin/RequiresOptIn#Level#ERROR.
    message = "This API is internal in Exposed and should not be used. It may be changed or removed in the future without notice."
)
@Target(
    AnnotationTarget.CLASS,
//                   ^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#CLASS.
    AnnotationTarget.CONSTRUCTOR,
//                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#CONSTRUCTOR.
    AnnotationTarget.FUNCTION,
//                   ^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#FUNCTION.
    AnnotationTarget.PROPERTY,
//                   ^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#PROPERTY.
    AnnotationTarget.PROPERTY_SETTER,
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#PROPERTY_SETTER.
    AnnotationTarget.TYPEALIAS
//                   ^^^^^^^^^ reference semanticdb maven . . kotlin/annotation/AnnotationTarget#TYPEALIAS.
)
annotation class InternalApi
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#
//                           display_name InternalApi
//                           documentation ```kotlin\n@RequiresOptIn(...) @Target(...) public final annotation class InternalApi : Annotation\n```\n\n----\n\n\n API marked with this annotation is internal and should not be used outside Exposed.\n It may be changed or removed in the future without notice.\n Using it outside Exposed may result in undefined and unexpected behaviour.\n
//                           relationship is_reference is_implementation semanticdb maven . . kotlin/Annotation#
//               ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/InternalApi#`<init>`().
//                           display_name InternalApi
//                           documentation ```kotlin\npublic constructor(): InternalApi\n```\n\n----\n\n\n API marked with this annotation is internal and should not be used outside Exposed.\n It may be changed or removed in the future without notice.\n Using it outside Exposed may result in undefined and unexpected behaviour.\n
