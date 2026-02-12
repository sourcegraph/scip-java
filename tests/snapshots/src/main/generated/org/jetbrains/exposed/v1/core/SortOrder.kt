  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  /** Represents the SQL keywords for defining sort order in an `ORDER BY` clause. */
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/Enum# 31:1
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder# 31:1
  enum class SortOrder(val code: String) {
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//                     display_name SortOrder
//                     documentation ```kotlin\npublic final enum class SortOrder : Enum<SortOrder>\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//                     relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 1049>`#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 168>`#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 265>`#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 366>`#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 576>`#
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 817>`#
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#`<init>`().
//                     display_name SortOrder
//                     documentation ```kotlin\nprivate constructor(code: String): SortOrder\n```
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#entries.
//                     display_name entries
//                     documentation ```kotlin\npublic final static val entries: EnumEntries<SortOrder>\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#valueOf().
//                     display_name valueOf
//                     documentation ```kotlin\npublic final static fun valueOf(value: String): SortOrder\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#valueOf().(value)
//                     display_name value
//                     documentation ```kotlin\nvalue: String\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#values().
//                     display_name values
//                     documentation ```kotlin\npublic final static fun values(): Array<SortOrder>\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//           ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                     display_name entries
//                     documentation ```kotlin\npublic get(): EnumEntries<SortOrder>\n```\n\n----\n\n Represents the SQL keywords for defining sort order in an `ORDER BY` clause.
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#`<init>`().(code)
//                              display_name code
//                              documentation ```kotlin\ncode: String\n```
//                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#`<init>`().(code)
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#code.
//                              display_name code
//                              documentation ```kotlin\npublic final val code: String\n```
//                         ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#getCode().
//                              display_name code
//                              documentation ```kotlin\npublic get(): String\n```
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** The SQL keyword `ASC` for sorting records in ascending order. */
      ASC(code = "ASC"),
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 168>`#
//        display_name <anonymous>
//        documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n The SQL keyword `ASC` for sorting records in ascending order.
//        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 168>`#`<init>`().
//        display_name ASC
//        documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n The SQL keyword `ASC` for sorting records in ascending order.
  
      /** The SQL keyword `DESC` for sorting records in descending order. */
      DESC(code = "DESC"),
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 265>`#
//         display_name <anonymous>
//         documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n The SQL keyword `DESC` for sorting records in descending order.
//         relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 265>`#`<init>`().
//         display_name DESC
//         documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n The SQL keyword `DESC` for sorting records in descending order.
  
      /**
       * The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS FIRST` to position
       * SQL NULL values at the start.
       */
      ASC_NULLS_FIRST(code = "ASC NULLS FIRST"),
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 366>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n\n The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS FIRST` to position\n SQL NULL values at the start.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 366>`#`<init>`().
//                    display_name ASC_NULLS_FIRST
//                    documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n\n The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS FIRST` to position\n SQL NULL values at the start.\n
  
      /**
       * The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS FIRST` to position
       * SQL NULL values at the start preceding non-null records.
       */
      DESC_NULLS_FIRST(code = "DESC NULLS FIRST"),
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 576>`#
//                     display_name <anonymous>
//                     documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n\n The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS FIRST` to position\n SQL NULL values at the start preceding non-null records.\n
//                     relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 576>`#`<init>`().
//                     display_name DESC_NULLS_FIRST
//                     documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n\n The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS FIRST` to position\n SQL NULL values at the start preceding non-null records.\n
  
      /**
       * The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS LAST` to position
       * SQL NULL values at the end following non-null records.
       */
      ASC_NULLS_LAST(code = "ASC NULLS LAST"),
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 817>`#
//                   display_name <anonymous>
//                   documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n\n The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS LAST` to position\n SQL NULL values at the end following non-null records.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 817>`#`<init>`().
//                   display_name ASC_NULLS_LAST
//                   documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n\n The SQL keyword `ASC` for sorting records in ascending order, combined with `NULLS LAST` to position\n SQL NULL values at the end following non-null records.\n
  
      /**
       * The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS LAST` to position
       * SQL NULL values at the end.
       */
      DESC_NULLS_LAST(code = "DESC NULLS LAST")
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 1049>`#
//                    display_name <anonymous>
//                    documentation ```kotlin\nobject : SortOrder\n```\n\n----\n\n\n The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS LAST` to position\n SQL NULL values at the end.\n
//                    relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/SortOrder#
//    ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/`<anonymous object at 1049>`#`<init>`().
//                    display_name DESC_NULLS_LAST
//                    documentation ```kotlin\nprivate constructor(): <anonymous>\n```\n\n----\n\n\n The SQL keyword `DESC` for sorting records in descending order, combined with `NULLS LAST` to position\n SQL NULL values at the end.\n
  }
