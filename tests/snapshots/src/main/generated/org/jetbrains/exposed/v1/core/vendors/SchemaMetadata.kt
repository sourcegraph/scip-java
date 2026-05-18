  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#
  /**
   * Represents metadata information about the current schema and its associated tables.
   */
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().
//                         ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().
  data class SchemaMetadata(
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#
//                          display_name SchemaMetadata
//                          documentation ```kotlin\npublic final data class SchemaMetadata : Any\n```\n\n----\n\n\n Represents metadata information about the current schema and its associated tables.\n
//           ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().
//                          display_name SchemaMetadata
//                          documentation ```kotlin\npublic constructor(schemaName: String, tableNames: List<String>): SchemaMetadata\n```\n\n----\n\n Name of the current schema.
//                         ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy(). 5:1
//                           display_name copy
//                           documentation ```kotlin\npublic final fun copy(schemaName: String = ..., tableNames: List<String> = ...): SchemaMetadata\n\n```\n\n----\n\n Name of the current schema.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(schemaName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#schemaName.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getSchemaName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component1().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(schemaName)
      /** Name of the current schema. */
      val schemaName: String,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(schemaName)
//                   display_name schemaName
//                   documentation ```kotlin\nschemaName: String\n```\n\n----\n\n Name of the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(schemaName)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component1().
//                   display_name component1
//                   documentation ```kotlin\npublic final operator fun component1(): String\n\n```\n\n----\n\n Name of the current schema.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(schemaName)
//                   display_name schemaName
//                   documentation ```kotlin\nschemaName: String = ...\n```\n\n----\n\n Name of the current schema.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getSchemaName().
//                   display_name schemaName
//                   documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getSchemaName().
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#schemaName.
//                   display_name schemaName
//                   documentation ```kotlin\npublic final val schemaName: String\n```\n\n----\n\n Name of the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#schemaName.
//                    ^^^^^^ reference semanticdb maven . . kotlin/String#
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(schemaName)
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#schemaName.
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getSchemaName().
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component1().
//                         ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(schemaName)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(tableNames)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#tableNames.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getTableNames().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component2().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(tableNames)
      /** Names of the existing tables in the current schema. */
      val tableNames: List<String>
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(tableNames)
//                   display_name tableNames
//                   documentation ```kotlin\ntableNames: List<String>\n```\n\n----\n\n Names of the existing tables in the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(tableNames)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component2().
//                   display_name component2
//                   documentation ```kotlin\npublic final operator fun component2(): List<String>\n\n```\n\n----\n\n Names of the existing tables in the current schema.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(tableNames)
//                   display_name tableNames
//                   documentation ```kotlin\ntableNames: List<String> = ...\n```\n\n----\n\n Names of the existing tables in the current schema.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getTableNames().
//                   display_name tableNames
//                   documentation ```kotlin\npublic get(): List<String>\n```\n\n----\n\n Names of the existing tables in the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getTableNames().
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#tableNames.
//                   display_name tableNames
//                   documentation ```kotlin\npublic final val tableNames: List<String>\n```\n\n----\n\n Names of the existing tables in the current schema.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#tableNames.
//                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().(tableNames)
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#tableNames.
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#getTableNames().
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#component2().
//                               ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().(tableNames)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SchemaMetadata#copy().
