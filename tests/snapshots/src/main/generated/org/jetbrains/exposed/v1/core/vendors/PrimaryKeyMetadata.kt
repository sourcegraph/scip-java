  package org.jetbrains.exposed.v1.core.vendors
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
  
//⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
  /**
   * Represents metadata information about a specific table's primary key.
   */
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().
//                             ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().
  data class PrimaryKeyMetadata(
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
//                              display_name PrimaryKeyMetadata
//                              documentation ```kotlin\npublic final data class PrimaryKeyMetadata : Any\n```\n\n----\n\n\n Represents metadata information about a specific table's primary key.\n
//           ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().
//                              display_name PrimaryKeyMetadata
//                              documentation ```kotlin\npublic constructor(name: String, columnNames: List<String>): PrimaryKeyMetadata\n```\n\n----\n\n Name of the primary key.
//                             ^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy(). 5:1
//                               display_name copy
//                               documentation ```kotlin\npublic final fun copy(name: String = ..., columnNames: List<String> = ...): PrimaryKeyMetadata\n\n```\n\n----\n\n Name of the primary key.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(name)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#name.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getName().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component1().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(name)
      /** Name of the primary key. */
      val name: String,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(name)
//             display_name name
//             documentation ```kotlin\nname: String\n```\n\n----\n\n Name of the primary key.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(name)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component1().
//             display_name component1
//             documentation ```kotlin\npublic final operator fun component1(): String\n\n```\n\n----\n\n Name of the primary key.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(name)
//             display_name name
//             documentation ```kotlin\nname: String = ...\n```\n\n----\n\n Name of the primary key.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getName().
//             display_name name
//             documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the primary key.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getName().
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#name.
//             display_name name
//             documentation ```kotlin\npublic final val name: String\n```\n\n----\n\n Name of the primary key.
//        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#name.
//              ^^^^^^ reference semanticdb maven . . kotlin/String#
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(name)
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#name.
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getName().
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component1().
//                   ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(name)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(columnNames)
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#columnNames.
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getColumnNames().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component2().
//    ⌄ enclosing_range_start semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(columnNames)
      /** Names of the primary key's columns. */
      val columnNames: List<String>
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(columnNames)
//                    display_name columnNames
//                    documentation ```kotlin\ncolumnNames: List<String>\n```\n\n----\n\n Names of the primary key's columns.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(columnNames)
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#columnNames.
//                    display_name columnNames
//                    documentation ```kotlin\npublic final val columnNames: List<String>\n```\n\n----\n\n Names of the primary key's columns.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#columnNames.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component2().
//                    display_name component2
//                    documentation ```kotlin\npublic final operator fun component2(): List<String>\n\n```\n\n----\n\n Names of the primary key's columns.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(columnNames)
//                    display_name columnNames
//                    documentation ```kotlin\ncolumnNames: List<String> = ...\n```\n\n----\n\n Names of the primary key's columns.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getColumnNames().
//                    display_name columnNames
//                    documentation ```kotlin\npublic get(): List<String>\n```\n\n----\n\n Names of the primary key's columns.
//        ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getColumnNames().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().(columnNames)
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#columnNames.
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#getColumnNames().
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#component2().
//                                ⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().(columnNames)
  )
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#`<init>`().
//⌃ enclosing_range_end semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/PrimaryKeyMetadata#copy().
