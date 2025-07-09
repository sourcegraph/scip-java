package org.jetbrains.exposed.v1.core.statements.api
//      ^^^ reference semanticdb maven . . org/
//          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                            ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/
//                                               ^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/

/**
 * Base class representing a savepoint, with the specified [name], which can be referenced during a
 * rollback operation to undo any changes made after the point in the transaction.
 */
@Suppress("UnnecessaryAbstractClass")
abstract class ExposedSavepoint(val name: String)
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#
//                              display_name ExposedSavepoint
//                              documentation ```kotlin\n@Suppress(...) public abstract class ExposedSavepoint : Any\n```\n\n----\n\n\n Base class representing a savepoint, with the specified [name], which can be referenced during a\n rollback operation to undo any changes made after the point in the transaction.\n
//             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#`<init>`().
//                              display_name ExposedSavepoint
//                              documentation ```kotlin\npublic constructor(name: String): ExposedSavepoint\n```
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#`<init>`().(name)
//                                       display_name name
//                                       documentation ```kotlin\nname: String\n```
//                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#`<init>`().(name)
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#getName().
//                                       display_name name
//                                       documentation ```kotlin\npublic get(): String\n```
//                                  ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/ExposedSavepoint#name.
//                                       display_name name
//                                       documentation ```kotlin\npublic final val name: String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
