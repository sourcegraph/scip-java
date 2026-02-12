  package org.jetbrains.exposed.v1.core
//        ^^^ reference semanticdb maven . . org/
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                      ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                              ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
  
  import org.jetbrains.exposed.v1.core.transactions.CoreTransactionManager
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/
//                                                  ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#
  import org.jetbrains.exposed.v1.core.vendors.DatabaseDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#
  import org.jetbrains.exposed.v1.core.vendors.MysqlDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#
  import org.jetbrains.exposed.v1.core.vendors.SQLiteDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/SQLiteDialect#
  import org.jetbrains.exposed.v1.core.vendors.currentDialect
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
  import org.jetbrains.exposed.v1.core.vendors.currentDialectIfAvailable
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
  import org.jetbrains.exposed.v1.core.vendors.inProperCase
//       ^^^ reference semanticdb maven . . org/
//           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/
//                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/
//                                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/
//                                     ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/
//                                             ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
  /**
   * Common interface for database objects that can be created, modified and dropped.
   */
  interface DdlAware {
//          ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//                   display_name DdlAware
//                   documentation ```kotlin\npublic abstract interface DdlAware : Any\n```\n\n----\n\n\n Common interface for database objects that can be created, modified and dropped.\n
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                   relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
      /** Returns the list of DDL statements that create this object. */
      fun createStatement(): List<String>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                        display_name createStatement
//                        documentation ```kotlin\npublic abstract fun createStatement(): List<String>\n\n```\n\n----\n\n Returns the list of DDL statements that create this object.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#createStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Column#createStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#createStatement().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /** Returns the list of DDL statements that modify this object. */
      fun modifyStatement(): List<String>
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                        display_name modifyStatement
//                        documentation ```kotlin\npublic abstract fun modifyStatement(): List<String>\n\n```\n\n----\n\n Returns the list of DDL statements that modify this object.
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#modifyStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Column#modifyStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#modifyStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Index#modifyStatement().
//                        relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#modifyStatement().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /** Returns the list of DDL statements that drops this object. */
      fun dropStatement(): List<String>
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                      display_name dropStatement
//                      documentation ```kotlin\npublic abstract fun dropStatement(): List<String>\n\n```\n\n----\n\n Returns the list of DDL statements that drops this object.
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#dropStatement().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Column#dropStatement().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Index#dropStatement().
//                      relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/Table#dropStatement().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
  
      /** Returns the list of DDL statements that create this DdlAware instance. */
      val ddl: List<String> get() = createStatement()
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#ddl.
//            display_name ddl
//            documentation ```kotlin\npublic open val ddl: List<String>\n```\n\n----\n\n Returns the list of DDL statements that create this DdlAware instance.
//             ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                          ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#getDdl().
//                              display_name ddl
//                              documentation ```kotlin\npublic get(): List<String>\n```
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
  }
  
  /**
//^^^ reference semanticdb maven . . kotlin/Enum# 20:1
   * Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.
   */
  enum class ReferenceOption {
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
//                           display_name ReferenceOption
//                           documentation ```kotlin\npublic final enum class ReferenceOption : Enum<ReferenceOption>\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//                           relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#`<init>`().
//                           display_name ReferenceOption
//                           documentation ```kotlin\nprivate constructor(): ReferenceOption\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#entries.
//                           display_name entries
//                           documentation ```kotlin\npublic final static val entries: EnumEntries<ReferenceOption>\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#valueOf().
//                           display_name valueOf
//                           documentation ```kotlin\npublic final static fun valueOf(value: String): ReferenceOption\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#valueOf().(value)
//                           display_name value
//                           documentation ```kotlin\nvalue: String\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#values().
//                           display_name values
//                           documentation ```kotlin\npublic final static fun values(): Array<ReferenceOption>\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/getEntries().
//                           display_name entries
//                           documentation ```kotlin\npublic get(): EnumEntries<ReferenceOption>\n```\n\n----\n\n\n Represents referential actions used by `ON UPDATE` or `ON DELETE` subclauses of a `FOREIGN KEY` constraint clause.\n
      /** Updates/deletes the referenced parent row, in addition to any rows in the referencing child table. */
      CASCADE,
  
      /** Updates/deletes the referenced parent row, and sets the column in the referencing child table to `NULL`. */
      SET_NULL,
  
      /** Prevents updating/deleting the referenced parent row. */
      RESTRICT,
  
      /** In some, but not all, databases, this action is equivalent to `RESTRICT`. Please check the documentation. */
      NO_ACTION,
  
      /** Updates/deletes the referenced parent row, and sets the column in the referencing child table to its default value. */
      SET_DEFAULT;
  
      override fun toString(): String = name.replace("_", " ")
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Enum#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#getName().
//                                      ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#name.
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
  }
  
  /**
   * Represents a foreign key constraint.
   */
  data class ForeignKeyConstraint(
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#
//                                display_name ForeignKeyConstraint
//                                documentation ```kotlin\npublic final data class ForeignKeyConstraint : DdlAware\n```\n\n----\n\n\n Represents a foreign key constraint.\n
//                                relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().
//                                display_name ForeignKeyConstraint
//                                documentation ```kotlin\npublic constructor(references: Map<Column<*>, Column<*>>, onUpdate: ReferenceOption?, onDelete: ReferenceOption?, name: String?): ForeignKeyConstraint\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//           ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().
//                                display_name copy
//                                documentation ```kotlin\npublic final fun copy(references: Map<Column<*>, Column<*>> = ..., onUpdate: ReferenceOption? = ..., onDelete: ReferenceOption? = ..., name: String? = ...): ForeignKeyConstraint\n\n```\n\n----\n\n\n Represents a foreign key constraint.\n
      /** Mapping of the foreign key columns in the referencing child table to their referenced parent table columns. */
      val references: Map<Column<*>, Column<*>>,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(references)
//                   display_name references
//                   documentation ```kotlin\nreferences: Map<Column<*>, Column<*>>\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(references)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#component1().
//                   display_name component1
//                   documentation ```kotlin\npublic final operator fun component1(): Map<Column<*>, Column<*>>\n\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().(references)
//                   display_name references
//                   documentation ```kotlin\nreferences: Map<Column<*>, Column<*>> = ...\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                   display_name references
//                   documentation ```kotlin\npublic get(): Map<Column<*>, Column<*>>\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                   display_name references
//                   documentation ```kotlin\npublic final val references: Map<Column<*>, Column<*>>\n```\n\n----\n\n Mapping of the foreign key columns in the referencing child table to their referenced parent table columns.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                    ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#
      private val onUpdate: ReferenceOption?,
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(onUpdate)
//                         display_name onUpdate
//                         documentation ```kotlin\nonUpdate: ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(onUpdate)
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#component2().
//                         display_name component2
//                         documentation ```kotlin\nprivate final operator fun component2(): ReferenceOption?\n\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().(onUpdate)
//                         display_name onUpdate
//                         documentation ```kotlin\nonUpdate: ReferenceOption? = ...\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnUpdate().
//                         display_name onUpdate
//                         documentation ```kotlin\nprivate get(): ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnUpdate().
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onUpdate.
//                         display_name onUpdate
//                         documentation ```kotlin\nprivate final val onUpdate: ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onUpdate.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
      private val onDelete: ReferenceOption?,
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(onDelete)
//                         display_name onDelete
//                         documentation ```kotlin\nonDelete: ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(onDelete)
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#component3().
//                         display_name component3
//                         documentation ```kotlin\nprivate final operator fun component3(): ReferenceOption?\n\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().(onDelete)
//                         display_name onDelete
//                         documentation ```kotlin\nonDelete: ReferenceOption? = ...\n```
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnDelete().
//                         display_name onDelete
//                         documentation ```kotlin\nprivate get(): ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnDelete().
//                ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onDelete.
//                         display_name onDelete
//                         documentation ```kotlin\nprivate final val onDelete: ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onDelete.
//                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
      private val name: String?
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(name)
//                     display_name name
//                     documentation ```kotlin\nname: String?\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`().(name)
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#component4().
//                     display_name component4
//                     documentation ```kotlin\nprivate final operator fun component4(): String?\n\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().(name)
//                     display_name name
//                     documentation ```kotlin\nname: String? = ...\n```
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getName().
//                     display_name name
//                     documentation ```kotlin\nprivate get(): String?\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getName().
//                ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#name.
//                     display_name name
//                     documentation ```kotlin\nprivate final val name: String?\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#name.
//                      ^^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : DdlAware {
//    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
      constructor(
//    ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1). 6:61
//                 display_name ForeignKeyConstraint
//                 documentation ```kotlin\npublic constructor(target: Column<*>, from: Column<*>, onUpdate: ReferenceOption?, onDelete: ReferenceOption?, name: String?): ForeignKeyConstraint\n```
          target: Column<*>,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(target)
//               display_name target
//               documentation ```kotlin\ntarget: Column<*>\n```
//                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          from: Column<*>,
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(from)
//             display_name from
//             documentation ```kotlin\nfrom: Column<*>\n```
//              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
          onUpdate: ReferenceOption?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(onUpdate)
//                 display_name onUpdate
//                 documentation ```kotlin\nonUpdate: ReferenceOption?\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          onDelete: ReferenceOption?,
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(onDelete)
//                 display_name onDelete
//                 documentation ```kotlin\nonDelete: ReferenceOption?\n```
//                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          name: String?
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(name)
//             display_name name
//             documentation ```kotlin\nname: String?\n```
//              ^^^^^^^ reference semanticdb maven . . kotlin/String#
      ) : this(mapOf(from to target), onUpdate, onDelete, name)
//             ^^^^^ reference semanticdb maven . . kotlin/collections/mapOf().
//                   ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(from)
//                        ^^ reference semanticdb maven . . kotlin/to().
//                           ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(target)
//                                    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(onUpdate)
//                                              ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(onDelete)
//                                                        ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#`<init>`(+1).(name)
  
      @OptIn(InternalApi::class)
      private val tx: Transaction
//                ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                   display_name tx
//                   documentation ```kotlin\n@OptIn(...) private final val tx: Transaction\n```
//                    ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#
          get() = CoreTransactionManager.currentTransaction()
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//            display_name tx
//            documentation ```kotlin\nprivate get(): Transaction\n```
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
  
      /** The columns of the referenced parent table. */
      val target: LinkedHashSet<Column<*>> = LinkedHashSet(references.values)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//               display_name target
//               documentation ```kotlin\npublic get(): {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```\n\n----\n\n The columns of the referenced parent table.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//               display_name target
//               documentation ```kotlin\npublic final val target: {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```\n\n----\n\n The columns of the referenced parent table.
//                ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#
//                                           ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#`<init>`().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                                                         ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                                                                    ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#getValues().
//                                                                    ^^^^^^ reference semanticdb maven . . kotlin/collections/Map#values.
  
      /** The referenced parent table. */
      val targetTable: Table = target.first().table
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                    display_name targetTable
//                    documentation ```kotlin\npublic get(): Table\n```\n\n----\n\n The referenced parent table.
//        ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
//                    display_name targetTable
//                    documentation ```kotlin\npublic final val targetTable: Table\n```\n\n----\n\n The referenced parent table.
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                                    ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
  
      /** Name of the referenced parent table. */
      val targetTableName: String
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTableName.
//                        display_name targetTableName
//                        documentation ```kotlin\npublic final val targetTableName: String\n```\n\n----\n\n Name of the referenced parent table.
//                         ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = tx.identity(targetTable)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTableName().
//            display_name targetTableName
//            documentation ```kotlin\npublic get(): String\n```
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTable().
//                            ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTable.
  
      /** Names of the referenced parent table columns. */
      private val targetColumns: String
//                ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetColumns.
//                              display_name targetColumns
//                              documentation ```kotlin\nprivate final val targetColumns: String\n```\n\n----\n\n Names of the referenced parent table columns.
//                               ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = target.joinToString { tx.identity(it) }
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetColumns().
//            display_name targetColumns
//            documentation ```kotlin\nprivate get(): String\n```
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                       ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                    ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                        display_name it
//                                                        documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//                                      ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                  ^^ reference semanticdb maven . . (it)
  
      /** The foreign key columns of the referencing child table. */
      val from: LinkedHashSet<Column<*>> = LinkedHashSet(references.keys)
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//             display_name from
//             documentation ```kotlin\npublic final val from: {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```\n\n----\n\n The foreign key columns of the referencing child table.
//        ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//             display_name from
//             documentation ```kotlin\npublic get(): {kotlin/collections/LinkedHashSet<org/jetbrains/exposed/v1/core/Column<*>>=} LinkedHashSet<Column<*>>\n```\n\n----\n\n The foreign key columns of the referencing child table.
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#
//                                         ^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/util/LinkedHashSet#`<init>`().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                                                       ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#getKeys().
//                                                                  ^^^^ reference semanticdb maven . . kotlin/collections/Map#keys.
  
      /** The referencing child table. */
      val fromTable: Table = from.first().table
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTable.
//                  display_name fromTable
//                  documentation ```kotlin\npublic final val fromTable: Table\n```\n\n----\n\n The referencing child table.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTable().
//                  display_name fromTable
//                  documentation ```kotlin\npublic get(): Table\n```\n\n----\n\n The referencing child table.
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                ^^^^^ reference semanticdb maven . . kotlin/collections/first(+18).
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
  
      /** Name of the referencing child table. */
      val fromTableName: String
//        ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                      display_name fromTableName
//                      documentation ```kotlin\npublic final val fromTableName: String\n```\n\n----\n\n Name of the referencing child table.
//                       ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = tx.identity(fromTable)
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
//            display_name fromTableName
//            documentation ```kotlin\npublic get(): String\n```
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                   ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTable.
//                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTable().
  
      /** Names of the foreign key columns from the referencing child table. */
      private val fromColumns: String
//                ^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromColumns.
//                            display_name fromColumns
//                            documentation ```kotlin\nprivate final val fromColumns: String\n```\n\n----\n\n Names of the foreign key columns from the referencing child table.
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = from.joinToString { tx.identity(it) }
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromColumns().
//            display_name fromColumns
//            documentation ```kotlin\nprivate get(): String\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                  ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                      display_name it
//                                                      documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//                                    ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                                       ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity(+1).
//                                                ^^ reference semanticdb maven . . (it)
  
      /** Reference option when performing update operations. */
      val updateRule: ReferenceOption?
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                   display_name updateRule
//                   documentation ```kotlin\npublic final val updateRule: ReferenceOption?\n```\n\n----\n\n Reference option when performing update operations.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          get() = onUpdate ?: currentDialectIfAvailable?.defaultReferenceOption
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//            display_name updateRule
//            documentation ```kotlin\npublic get(): ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnUpdate().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onUpdate.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#defaultReferenceOption.
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDefaultReferenceOption().
  
      /** Reference option when performing delete operations. */
      val deleteRule: ReferenceOption?
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                   display_name deleteRule
//                   documentation ```kotlin\npublic final val deleteRule: ReferenceOption?\n```\n\n----\n\n Reference option when performing delete operations.
//                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#
          get() = onDelete ?: currentDialectIfAvailable?.defaultReferenceOption
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//            display_name deleteRule
//            documentation ```kotlin\npublic get(): ReferenceOption?\n```
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getOnDelete().
//                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#onDelete.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialectIfAvailable.
//                            ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialectIfAvailable().
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#defaultReferenceOption.
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getDefaultReferenceOption().
  
      /** Custom foreign key name, if provided. */
      val customFkName: String?
//        ^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#customFkName.
//                     display_name customFkName
//                     documentation ```kotlin\npublic final val customFkName: String?\n```\n\n----\n\n Custom foreign key name, if provided.
//                      ^^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = name
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getCustomFkName().
//            display_name customFkName
//            documentation ```kotlin\npublic get(): String?\n```
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getName().
//                ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#name.
  
      /** Name of this foreign key constraint. */
      val fkName: String
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//               display_name fkName
//               documentation ```kotlin\npublic final val fkName: String\n```\n\n----\n\n Name of this foreign key constraint.
//                ^^^^^^ reference semanticdb maven . . kotlin/String#
          @OptIn(InternalApi::class)
          get() = tx.db.identifierManager.cutIfNecessaryAndQuote(
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
//            display_name fkName
//            documentation ```kotlin\n@OptIn(...) public get(): String\n```
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTx().
//                ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#tx.
//                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                   ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
//                                        ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
              name ?: (
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getName().
//            ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#name.
                  "fk_${fromTable.tableNameWithoutSchemeSanitized.replace('.', '_')}_${from.joinToString("_") { it.name }}__" +
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTable.
//                      ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTable().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#getTableNameWithoutSchemeSanitized().
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#tableNameWithoutSchemeSanitized.
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/text/replace().
//                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#from.
//                                                                                     ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFrom().
//                                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                                                                                            ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                                                        display_name it
//                                                                                                                        documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                                                                                              ^^ reference semanticdb maven . . (it)
//                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                                                                                 ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
//                                                                                                                            ^ reference semanticdb maven . . kotlin/String#plus().
                      target.joinToString("_") { it.name }
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTarget().
//                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#target.
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                             ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                         display_name it
//                                                         documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                               ^^ reference semanticdb maven . . (it)
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
                  )
          ).inProperCase()
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      internal val foreignKeyPart: String
//                 ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#foreignKeyPart.
//                                display_name foreignKeyPart
//                                documentation ```kotlin\ninternal final val foreignKeyPart: String\n```
//                                 ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = buildString {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getForeignKeyPart().
//            display_name foreignKeyPart
//            documentation ```kotlin\ninternal get(): String\n```
//                ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              if (fkName.isNotBlank()) {
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
//                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotBlank().
                  append("CONSTRAINT $fkName ")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                                    ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
              }
              append("FOREIGN KEY ($fromColumns) REFERENCES $targetTableName($targetColumns)")
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromColumns.
//                                  ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromColumns().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetTableName().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetTableName.
//                                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getTargetColumns().
//                                                                            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetColumns.
  
              if (deleteRule != ReferenceOption.NO_ACTION) {
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#NO_ACTION.
                  if (deleteRule == ReferenceOption.RESTRICT && !currentDialect.supportsRestrictReferenceOption) {
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#RESTRICT.
//                                                              ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsRestrictReferenceOption().
//                                                                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsRestrictReferenceOption.
                      exposedLogger.warn(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                          "${currentDialect.name} doesn't support FOREIGN KEY with RESTRICT reference option with ON DELETE clause. " +
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                              "Please check your $fromTableName table."
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
                      )
                  } else if (deleteRule == ReferenceOption.SET_DEFAULT && !currentDialect.supportsSetDefaultReferenceOption) {
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#SET_DEFAULT.
//                                                                        ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSetDefaultReferenceOption().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSetDefaultReferenceOption.
                      exposedLogger.warn(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                          "${currentDialect.name} doesn't support FOREIGN KEY with SET DEFAULT reference option with ON DELETE clause. " +
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                              "Please check your $fromTableName table."
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
                      )
                  } else {
                      append(" ON DELETE $deleteRule")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#deleteRule.
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getDeleteRule().
                  }
              }
  
              if (updateRule != ReferenceOption.NO_ACTION) {
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                              ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#NO_ACTION.
                  if (!currentDialect.supportsOnUpdate) {
//                    ^ reference semanticdb maven . . kotlin/Boolean#not().
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsOnUpdate().
//                                    ^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsOnUpdate.
                      exposedLogger.warn("${currentDialect.name} doesn't support FOREIGN KEY with ON UPDATE clause. Please check your $fromTableName table.")
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                         ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
//                                                                                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                                                                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
                  } else if (updateRule == ReferenceOption.RESTRICT && !currentDialect.supportsRestrictReferenceOption) {
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                                         ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#RESTRICT.
//                                                                     ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsRestrictReferenceOption().
//                                                                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsRestrictReferenceOption.
                      exposedLogger.warn(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                          "${currentDialect.name} doesn't support FOREIGN KEY with RESTRICT reference option with ON UPDATE clause. " +
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                              "Please check your $fromTableName table."
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
                      )
                  } else if (updateRule == ReferenceOption.SET_DEFAULT && !currentDialect.supportsSetDefaultReferenceOption) {
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                           ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
//                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ReferenceOption#SET_DEFAULT.
//                                                                        ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                         ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getSupportsSetDefaultReferenceOption().
//                                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#supportsSetDefaultReferenceOption.
                      exposedLogger.warn(
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                                  ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
                          "${currentDialect.name} doesn't support FOREIGN KEY with SET DEFAULT reference option with ON UPDATE clause. " +
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                          ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
                              "Please check your $fromTableName table."
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
                      )
                  } else {
                      append(" ON UPDATE $updateRule")
//                    ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getUpdateRule().
//                                        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#updateRule.
                  }
              }
          }
  
      override fun createStatement(): List<String> = listOf("ALTER TABLE $fromTableName ADD $foreignKeyPart")
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                                                        ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
//                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#foreignKeyPart.
//                                                                                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getForeignKeyPart().
  
      override fun modifyStatement(): List<String> = dropStatement() + createStatement()
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
//                                                                   ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#createStatement().
  
      override fun dropStatement(): List<String> {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          val constraintType = when (currentDialect) {
//            ^^^^^^^^^^^^^^ definition local 0
//                           display_name constraintType
//                           documentation ```kotlin\nlocal val constraintType: String\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
              is MysqlDialect -> "FOREIGN KEY"
              else -> "CONSTRAINT"
          }
          return listOf("ALTER TABLE $fromTableName DROP $constraintType $fkName")
//               ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fromTableName.
//                                    ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFromTableName().
//                                                        ^^^^^^^^^^^^^^ reference local 0
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
      }
  
      /** Returns the parent table column that is referenced by the [from] column in the child table. */
      fun targetOf(from: Column<*>): Column<*>? = references[from]
//        ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetOf().
//                 display_name targetOf
//                 documentation ```kotlin\npublic final fun targetOf(from: Column<*>): Column<*>?\n```\n\n----\n\n Returns the parent table column that is referenced by the [from] column in the child table.
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetOf().(from)
//                      display_name from
//                      documentation ```kotlin\nfrom: Column<*>\n```
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                   ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                                                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                                                ^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/Map#get().
//                                                           ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#targetOf().(from)
  
      operator fun plus(other: ForeignKeyConstraint): ForeignKeyConstraint {
//                 ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#plus().
//                      display_name plus
//                      documentation ```kotlin\npublic final operator fun plus(other: ForeignKeyConstraint): ForeignKeyConstraint\n```
//                      ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#plus().(other)
//                            display_name other
//                            documentation ```kotlin\nother: ForeignKeyConstraint\n```
//                             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#
          return copy(references = references + other.references)
//               ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#copy().
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                                 ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
//                                            ^ reference semanticdb maven . . kotlin/collections/plus(+39).
//                                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#plus().(other)
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getReferences().
//                                                    ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#references.
      }
  
      override fun toString() = "ForeignKeyConstraint(fkName='$fkName')"
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#fkName.
//                                                             ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ForeignKeyConstraint#getFkName().
  }
  
  /**
   * Represents a check constraint.
   */
  data class CheckConstraint(
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#
//                           display_name CheckConstraint
//                           documentation ```kotlin\npublic final data class CheckConstraint : DdlAware\n```\n\n----\n\n\n Represents a check constraint.\n
//                           relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().
//                           display_name CheckConstraint
//                           documentation ```kotlin\npublic constructor(tableName: String, checkName: String, checkOp: String): CheckConstraint\n```\n\n----\n\n Name of the table where the constraint is defined.
//           ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#copy().
//                           display_name copy
//                           documentation ```kotlin\npublic final fun copy(tableName: String = ..., checkName: String = ..., checkOp: String = ...): CheckConstraint\n\n```\n\n----\n\n\n Represents a check constraint.\n
      /** Name of the table where the constraint is defined. */
      val tableName: String,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(tableName)
//                  display_name tableName
//                  documentation ```kotlin\ntableName: String\n```\n\n----\n\n Name of the table where the constraint is defined.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(tableName)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#component1().
//                  display_name component1
//                  documentation ```kotlin\npublic final operator fun component1(): String\n\n```\n\n----\n\n Name of the table where the constraint is defined.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#copy().(tableName)
//                  display_name tableName
//                  documentation ```kotlin\ntableName: String = ...\n```\n\n----\n\n Name of the table where the constraint is defined.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getTableName().
//                  display_name tableName
//                  documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the table where the constraint is defined.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getTableName().
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#tableName.
//                  display_name tableName
//                  documentation ```kotlin\npublic final val tableName: String\n```\n\n----\n\n Name of the table where the constraint is defined.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#tableName.
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Name of the check constraint. */
      val checkName: String,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(checkName)
//                  display_name checkName
//                  documentation ```kotlin\ncheckName: String\n```\n\n----\n\n Name of the check constraint.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(checkName)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkName.
//                  display_name checkName
//                  documentation ```kotlin\npublic final val checkName: String\n```\n\n----\n\n Name of the check constraint.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkName.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#component2().
//                  display_name component2
//                  documentation ```kotlin\npublic final operator fun component2(): String\n\n```\n\n----\n\n Name of the check constraint.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#copy().(checkName)
//                  display_name checkName
//                  documentation ```kotlin\ncheckName: String = ...\n```\n\n----\n\n Name of the check constraint.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckName().
//                  display_name checkName
//                  documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Name of the check constraint.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckName().
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Boolean expression used for the check constraint. */
      val checkOp: String
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(checkOp)
//                display_name checkOp
//                documentation ```kotlin\ncheckOp: String\n```\n\n----\n\n Boolean expression used for the check constraint.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().(checkOp)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkOp.
//                display_name checkOp
//                documentation ```kotlin\npublic final val checkOp: String\n```\n\n----\n\n Boolean expression used for the check constraint.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkOp.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#component3().
//                display_name component3
//                documentation ```kotlin\npublic final operator fun component3(): String\n\n```\n\n----\n\n Boolean expression used for the check constraint.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#copy().(checkOp)
//                display_name checkOp
//                documentation ```kotlin\ncheckOp: String = ...\n```\n\n----\n\n Boolean expression used for the check constraint.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckOp().
//                display_name checkOp
//                documentation ```kotlin\npublic get(): String\n```\n\n----\n\n Boolean expression used for the check constraint.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckOp().
//                 ^^^^^^ reference semanticdb maven . . kotlin/String#
  ) : DdlAware {
//    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
  
      internal val checkPart = "CONSTRAINT $checkName CHECK ($checkOp)"
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkPart.
//                           display_name checkPart
//                           documentation ```kotlin\ninternal final val checkPart: String\n```
//                 ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckPart().
//                           display_name checkPart
//                           documentation ```kotlin\ninternal get(): String\n```
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkName.
//                                          ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckName().
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkOp.
//                                                            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckOp().
  
      private val DatabaseDialect.cannotAlterCheckConstraint: Boolean
//                                ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#cannotAlterCheckConstraint.
//                                                           display_name cannotAlterCheckConstraint
//                                                           documentation ```kotlin\nprivate final val DatabaseDialect.cannotAlterCheckConstraint: Boolean\n```
//                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          get() = this is SQLiteDialect || (this as? MysqlDialect)?.isMysql8 == false
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCannotAlterCheckConstraint().
//            display_name cannotAlterCheckConstraint
//            documentation ```kotlin\nprivate get(): Boolean\n```
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#getIsMysql8().
//                                                                  ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/MysqlDialect#isMysql8.
  
      override fun createStatement(): List<String> {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          return if (currentDialect.cannotAlterCheckConstraint) {
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#cannotAlterCheckConstraint.
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCannotAlterCheckConstraint().
              exposedLogger.warn("Creation of CHECK constraints is not currently supported by ${currentDialect.name}")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
              listOf()
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+2).
          } else {
              listOf("ALTER TABLE $tableName ADD $checkPart")
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getTableName().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#tableName.
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkPart.
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckPart().
          }
      }
  
      override fun modifyStatement(): List<String> = dropStatement() + createStatement()
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#dropStatement().
//                                                                   ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#createStatement().
  
      override fun dropStatement(): List<String> {
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
          return if (currentDialect.cannotAlterCheckConstraint) {
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                   ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#cannotAlterCheckConstraint.
//                                  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCannotAlterCheckConstraint().
              exposedLogger.warn("Deletion of CHECK constraints is not currently supported by ${currentDialect.name}")
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/exposedLogger.
//            ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/getExposedLogger().
//                          ^^^^ reference semanticdb maven . . org/slf4j/Logger#warn().
//                                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#getName().
//                                                                                                             ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#name.
              listOf()
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf(+2).
          } else {
              listOf("ALTER TABLE $tableName DROP CONSTRAINT $checkName")
//            ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getTableName().
//                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#tableName.
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#checkName.
//                                                            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#getCheckName().
          }
      }
  
      companion object {
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion# 10:5
//                       display_name Companion
//                       documentation ```kotlin\npublic final companion object Companion : Any\n```
//    ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#`<init>`(). 10:5
//                       display_name Companion
//                       documentation ```kotlin\nprivate constructor(): CheckConstraint.Companion\n```
          fun from(table: Table, name: String, op: Op<Boolean>): CheckConstraint {
//            ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().
//                 display_name from
//                 documentation ```kotlin\npublic final fun from(table: Table, name: String, op: Op<Boolean>): CheckConstraint\n```
//                 ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(table)
//                       display_name table
//                       documentation ```kotlin\ntable: Table\n```
//                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
//                               ^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(name)
//                                    display_name name
//                                    documentation ```kotlin\nname: String\n```
//                                     ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                             ^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(op)
//                                                display_name op
//                                                documentation ```kotlin\nop: Op<Boolean>\n```
//                                                 ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
//                                                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#
              require(name.isNotBlank()) { "Check constraint name cannot be blank" }
//            ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                    ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(name)
//                         ^^^^^^^^^^ reference semanticdb maven . . kotlin/text/isNotBlank().
              @OptIn(InternalApi::class)
              val tr = CoreTransactionManager.currentTransaction()
//                ^^ definition local 1
//                   display_name tr
//                   documentation ```kotlin\n@OptIn(...) local val tr: Transaction\n```
//                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/CoreTransactionManager#currentTransaction().
              val identifierManager = tr.db.identifierManager
//                ^^^^^^^^^^^^^^^^^ definition local 2
//                                  display_name identifierManager
//                                  documentation ```kotlin\nlocal val identifierManager: IdentifierManagerApi\n```
//                                    ^^ reference local 1
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#db.
//                                       ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/transactions/TransactionInterface#getDb().
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#getIdentifierManager().
//                                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DatabaseApi#identifierManager.
              val tableName = tr.identity(table)
//                ^^^^^^^^^ definition local 3
//                          display_name tableName
//                          documentation ```kotlin\nlocal val tableName: String\n```
//                            ^^ reference local 1
//                               ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Transaction#identity().
//                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(table)
              val checkOpSQL = op.toString().replace("$tableName.", "")
//                ^^^^^^^^^^ definition local 4
//                           display_name checkOpSQL
//                           documentation ```kotlin\nlocal val checkOpSQL: String\n```
//                             ^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(op)
//                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#toString().
//                                           ^^^^^^^ reference semanticdb maven . . kotlin/text/replace(+1).
//                                                     ^^^^^^^^^ reference local 3
              return CheckConstraint(tableName, identifierManager.cutIfNecessaryAndQuote(name), checkOpSQL)
//                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#`<init>`().
//                                   ^^^^^^^^^ reference local 3
//                                              ^^^^^^^^^^^^^^^^^ reference local 2
//                                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/statements/api/IdentifierManagerApi#cutIfNecessaryAndQuote().
//                                                                                       ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/CheckConstraint#Companion#from().(name)
//                                                                                              ^^^^^^^^^^ reference local 4
          }
      }
  }
  
  /** A conditional expression used as a filter when creating a partial index. */
  typealias FilterCondition = (SqlExpressionBuilder.() -> Op<Boolean>)?
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/FilterCondition#
//                          display_name FirTypeAliasSymbol org/jetbrains/exposed/v1/core/FilterCondition
//                          documentation ```kotlin\npublic final typealias FilterCondition = (SqlExpressionBuilder.() -> Op<Boolean>)?\n\n```\n\n----\n\n A conditional expression used as a filter when creating a partial index.
  
  /**
   * Represents an index.
   */
  data class Index(
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                 display_name Index
//                 documentation ```kotlin\npublic final data class Index : DdlAware\n```\n\n----\n\n\n Represents an index.\n
//                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().
//                 display_name Index
//                 documentation ```kotlin\npublic constructor(columns: List<Column<*>>, unique: Boolean, customName: String? = ..., indexType: String? = ..., filterCondition: Op<Boolean>? = ..., functions: List<ExpressionWithColumnType<*>>? = ..., functionsTable: Table? = ...): Index\n```\n\n----\n\n Columns that are part of the index.
//           ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().
//                 display_name copy
//                 documentation ```kotlin\npublic final fun copy(columns: List<Column<*>> = ..., unique: Boolean = ..., customName: String? = ..., indexType: String? = ..., filterCondition: Op<Boolean>? = ..., functions: List<ExpressionWithColumnType<*>>? = ..., functionsTable: Table? = ...): Index\n\n```\n\n----\n\n\n Represents an index.\n
      /** Columns that are part of the index. */
      val columns: List<Column<*>>,
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>>\n```\n\n----\n\n Columns that are part of the index.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(columns)
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                display_name columns
//                documentation ```kotlin\npublic final val columns: List<Column<*>>\n```\n\n----\n\n Columns that are part of the index.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component1().
//                display_name component1
//                documentation ```kotlin\npublic final operator fun component1(): List<Column<*>>\n\n```\n\n----\n\n Columns that are part of the index.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(columns)
//                display_name columns
//                documentation ```kotlin\ncolumns: List<Column<*>> = ...\n```\n\n----\n\n Columns that are part of the index.
//        ^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                display_name columns
//                documentation ```kotlin\npublic get(): List<Column<*>>\n```\n\n----\n\n Columns that are part of the index.
//        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      /** Whether the index in unique or not. */
      val unique: Boolean,
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(unique)
//               display_name unique
//               documentation ```kotlin\nunique: Boolean\n```\n\n----\n\n Whether the index in unique or not.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(unique)
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component2().
//               display_name component2
//               documentation ```kotlin\npublic final operator fun component2(): Boolean\n\n```\n\n----\n\n Whether the index in unique or not.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(unique)
//               display_name unique
//               documentation ```kotlin\nunique: Boolean = ...\n```\n\n----\n\n Whether the index in unique or not.
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//               display_name unique
//               documentation ```kotlin\npublic get(): Boolean\n```\n\n----\n\n Whether the index in unique or not.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//        ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//               display_name unique
//               documentation ```kotlin\npublic final val unique: Boolean\n```\n\n----\n\n Whether the index in unique or not.
//        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
      /** Optional custom name for the index. */
      val customName: String? = null,
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(customName)
//                   display_name customName
//                   documentation ```kotlin\ncustomName: String? = ...\n```\n\n----\n\n Optional custom name for the index.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(customName)
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component3().
//                   display_name component3
//                   documentation ```kotlin\npublic final operator fun component3(): String?\n\n```\n\n----\n\n Optional custom name for the index.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(customName)
//                   display_name customName
//                   documentation ```kotlin\ncustomName: String? = ...\n```\n\n----\n\n Optional custom name for the index.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#customName.
//                   display_name customName
//                   documentation ```kotlin\npublic final val customName: String?\n```\n\n----\n\n Optional custom name for the index.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#customName.
//        ^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getCustomName().
//                   display_name customName
//                   documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Optional custom name for the index.
//        ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getCustomName().
//                    ^^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Optional custom index type (e.g, BTREE or HASH) */
      val indexType: String? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(indexType)
//                  display_name indexType
//                  documentation ```kotlin\nindexType: String? = ...\n```\n\n----\n\n Optional custom index type (e.g, BTREE or HASH)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(indexType)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component4().
//                  display_name component4
//                  documentation ```kotlin\npublic final operator fun component4(): String?\n\n```\n\n----\n\n Optional custom index type (e.g, BTREE or HASH)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(indexType)
//                  display_name indexType
//                  documentation ```kotlin\nindexType: String? = ...\n```\n\n----\n\n Optional custom index type (e.g, BTREE or HASH)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//                  display_name indexType
//                  documentation ```kotlin\npublic get(): String?\n```\n\n----\n\n Optional custom index type (e.g, BTREE or HASH)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexType().
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                  display_name indexType
//                  documentation ```kotlin\npublic final val indexType: String?\n```\n\n----\n\n Optional custom index type (e.g, BTREE or HASH)
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexType.
//                   ^^^^^^^ reference semanticdb maven . . kotlin/String#
      /** Partial index filter condition */
      val filterCondition: Op<Boolean>? = null,
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: Op<Boolean>? = ...\n```\n\n----\n\n Partial index filter condition
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(filterCondition)
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component5().
//                        display_name component5
//                        documentation ```kotlin\npublic final operator fun component5(): Op<Boolean>?\n\n```\n\n----\n\n Partial index filter condition
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(filterCondition)
//                        display_name filterCondition
//                        documentation ```kotlin\nfilterCondition: Op<Boolean>? = ...\n```\n\n----\n\n Partial index filter condition
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#filterCondition.
//                        display_name filterCondition
//                        documentation ```kotlin\npublic final val filterCondition: Op<Boolean>?\n```\n\n----\n\n Partial index filter condition
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#filterCondition.
//        ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFilterCondition().
//                        display_name filterCondition
//                        documentation ```kotlin\npublic get(): Op<Boolean>?\n```\n\n----\n\n Partial index filter condition
//        ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFilterCondition().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Op#
      /** Functions that are part of the index. */
      val functions: List<ExpressionWithColumnType<*>>? = null,
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```\n\n----\n\n Functions that are part of the index.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(functions)
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component6().
//                  display_name component6
//                  documentation ```kotlin\npublic final operator fun component6(): List<ExpressionWithColumnType<*>>?\n\n```\n\n----\n\n Functions that are part of the index.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(functions)
//                  display_name functions
//                  documentation ```kotlin\nfunctions: List<ExpressionWithColumnType<*>>? = ...\n```\n\n----\n\n Functions that are part of the index.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                  display_name functions
//                  documentation ```kotlin\npublic final val functions: List<ExpressionWithColumnType<*>>?\n```\n\n----\n\n Functions that are part of the index.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                  display_name functions
//                  documentation ```kotlin\npublic get(): List<ExpressionWithColumnType<*>>?\n```\n\n----\n\n Functions that are part of the index.
//        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
      /** Table where the functional index should be defined. */
      val functionsTable: Table? = null
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(functionsTable)
//                       display_name functionsTable
//                       documentation ```kotlin\nfunctionsTable: Table? = ...\n```\n\n----\n\n Table where the functional index should be defined.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#`<init>`().(functionsTable)
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#component7().
//                       display_name component7
//                       documentation ```kotlin\npublic final operator fun component7(): Table?\n\n```\n\n----\n\n Table where the functional index should be defined.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#copy().(functionsTable)
//                       display_name functionsTable
//                       documentation ```kotlin\nfunctionsTable: Table? = ...\n```\n\n----\n\n Table where the functional index should be defined.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functionsTable.
//                       display_name functionsTable
//                       documentation ```kotlin\npublic final val functionsTable: Table?\n```\n\n----\n\n Table where the functional index should be defined.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functionsTable.
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctionsTable().
//                       display_name functionsTable
//                       documentation ```kotlin\npublic get(): Table?\n```\n\n----\n\n Table where the functional index should be defined.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctionsTable().
//                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  ) : DdlAware {
//    ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#
      /** Table where the index is defined. */
      val table: Table
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//              display_name table
//              documentation ```kotlin\npublic get(): Table\n```\n\n----\n\n Table where the index is defined.
//        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//              display_name table
//              documentation ```kotlin\npublic final val table: Table\n```\n\n----\n\n Table where the index is defined.
//               ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#
  
      /** Name of the index. */
      @OptIn(InternalApi::class)
      val indexName: String
//        ^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                  display_name indexName
//                  documentation ```kotlin\n@OptIn(...) public final val indexName: String\n```\n\n----\n\n Name of the index.
//                   ^^^^^^ reference semanticdb maven . . kotlin/String#
          get() = customName ?: buildString {
//        ^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//            display_name indexName
//            documentation ```kotlin\npublic get(): String\n```
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#customName.
//                ^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getCustomName().
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/buildString().
              append(table.nameInDatabaseCaseUnquoted())
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCaseUnquoted().
              append('_')
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              append(columns.joinToString("_") { it.name })
//            ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                   ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                           ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                             ^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                         display_name it
//                                                         documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                               ^^ reference semanticdb maven . . (it)
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getName().
//                                                  ^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#name.
              functions?.let { f ->
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                       ^^^ reference semanticdb maven . . kotlin/let().
//                             ^ definition semanticdb maven . . (f)
//                               display_name f
//                               documentation ```kotlin\nf: List<ExpressionWithColumnType<*>>\n```
                  if (columns.isNotEmpty()) append('_')
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                    ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                            ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                          ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
                  append(f.joinToString("_") { it.toString().substringBefore("(").lowercase() })
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
//                       ^ reference semanticdb maven . . (f)
//                         ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
//                                           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                                                              display_name it
//                                                                                              documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                             ^^ reference semanticdb maven . . (it)
//                                                ^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/ExpressionWithColumnType#toString().
//                                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/text/substringBefore(+1).
//                                                                                ^^^^^^^^^ reference semanticdb maven . . kotlin/text/lowercase(+2).
              }
              if (unique) {
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
                  append("_unique")
//                ^^^^^^ reference semanticdb maven jdk 11 java/lang/StringBuilder#append().
              }
          }.inProperCase()
//          ^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/inProperCase().
  
      init {
          require(columns.isNotEmpty() || functions?.isNotEmpty() == true) { "At least one column or function is required to create an index" }
//        ^^^^^^^ reference semanticdb maven . . kotlin/require(+1).
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                        ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                        ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                                                   ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
          val columnsTable = if (columns.isNotEmpty()) {
//            ^^^^^^^^^^^^ definition local 5
//                         display_name columnsTable
//                         documentation ```kotlin\nlocal val columnsTable: Table?\n```
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              val table = columns.distinctBy { it.table }.singleOrNull()?.table
//                ^^^^^ definition local 6
//                      display_name table
//                      documentation ```kotlin\nlocal val table: Table?\n```
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                        ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/distinctBy(+9).
//                                           ^^^^^^^^^^^^ definition semanticdb maven . . (it)
//                                                        display_name it
//                                                        documentation ```kotlin\nit: ExpressionWithColumnType<*>\n```
//                                             ^^ reference semanticdb maven . . (it)
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
//                                                        ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/singleOrNull(+19).
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#getTable().
//                                                                        ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Column#table.
              requireNotNull(table) { "Columns from different tables can't persist in one index" }
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/requireNotNull(+1).
//                           ^^^^^ reference local 6
              table
//            ^^^^^ reference local 6
          } else {
              null
          }
          if (functions?.isNotEmpty() == true) {
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
//                       ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/isNotEmpty(+9).
              requireNotNull(functionsTable) { "functionsTable argument must also be provided if functions are defined to create an index" }
//            ^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/requireNotNull(+1).
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functionsTable.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctionsTable().
          }
          this.table = columnsTable ?: functionsTable!!
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                     ^^^^^^^^^^^^ reference local 5
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functionsTable.
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctionsTable().
      }
  
      override fun createStatement(): List<String> = listOf(currentDialect.createIndex(this))
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
//                                 display_name createStatement
//                                 documentation ```kotlin\npublic open override fun createStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#createStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//                                                          ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                                                                         ^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#createIndex().
      override fun modifyStatement(): List<String> = dropStatement() + createStatement()
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#modifyStatement().
//                                 display_name modifyStatement
//                                 documentation ```kotlin\npublic open override fun modifyStatement(): List<String>\n```
//                                 relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#modifyStatement().
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                   ^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#dropStatement().
//                                                                   ^ reference semanticdb maven . . kotlin/collections/plus(+32).
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#createStatement().
      override fun dropStatement(): List<String> = listOf(
//                 ^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#dropStatement().
//                               display_name dropStatement
//                               documentation ```kotlin\npublic open override fun dropStatement(): List<String>\n```
//                               relationship is_reference is_implementation semanticdb maven . . org/jetbrains/exposed/v1/core/DdlAware#dropStatement().
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                 ^^^^^^ reference semanticdb maven . . kotlin/collections/listOf().
          currentDialect.dropIndex(table.nameInDatabaseCase(), indexName, unique, filterCondition != null || functions != null)
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/currentDialect.
//        ^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/getCurrentDialect().
//                       ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/vendors/DatabaseDialect#dropIndex().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                 ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                       ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                             ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                                                        ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#filterCondition.
//                                                                                ^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFilterCondition().
//                                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#functions.
//                                                                                                           ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getFunctions().
      )
  
      /** Returns `true` if the [other] index has the same columns and uniqueness as this index, but a different name, `false` otherwise */
      fun onlyNameDiffer(other: Index): Boolean = indexName != other.indexName && columns == other.columns && unique == other.unique
//        ^^^^^^^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().
//                       display_name onlyNameDiffer
//                       documentation ```kotlin\npublic final fun onlyNameDiffer(other: Index): Boolean\n```\n\n----\n\n Returns `true` if the [other] index has the same columns and uniqueness as this index, but a different name, `false` otherwise
//                       ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().(other)
//                             display_name other
//                             documentation ```kotlin\nother: Index\n```
//                              ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                             ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().(other)
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                                   ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                           ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().(other)
//                                                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                                 ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                                                                                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#onlyNameDiffer().(other)
//                                                                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                                                                                                                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
  
      override fun equals(other: Any?): Boolean {
//                 ^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().
//                        display_name equals
//                        documentation ```kotlin\npublic open override operator fun equals(other: Any?): Boolean\n```
//                        relationship is_reference is_implementation semanticdb maven . . kotlin/Any#equals().
//                        ^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
//                              display_name other
//                              documentation ```kotlin\nother: Any?\n```
//                               ^^^^ reference semanticdb maven . . kotlin/Any#
//                                      ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
          if (this === other) return true
//                     ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
          if (other !is Index) return false
//            ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
  
          if (indexName != other.indexName) return false
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//            ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                         ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                               ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
          if (columns != other.columns) return false
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//            ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                       ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
          if (unique != other.unique) return false
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                      ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#equals().(other)
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                            ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
  
          return true
      }
  
      override fun hashCode(): Int {
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#hashCode().
//                          display_name hashCode
//                          documentation ```kotlin\npublic open override fun hashCode(): Int\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#hashCode().
//                             ^^^ reference semanticdb maven . . kotlin/Int#
          var result = indexName.hashCode()
//            ^^^^^^ definition local 7
//                   display_name result
//                   documentation ```kotlin\nlocal var result: Int\n```
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                     ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                               ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          result = 31 * result + columns.hashCode()
//        ^^^^^^ reference local 7
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 7
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                               ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                       ^^^^^^^^ reference semanticdb maven . . kotlin/Any#hashCode().
          result = 31 * result + unique.hashCode()
//        ^^^^^^ reference local 7
//                    ^ reference semanticdb maven . . kotlin/Int#times(+2).
//                      ^^^^^^ reference local 7
//                             ^ reference semanticdb maven . . kotlin/Int#plus(+2).
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//                               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/Boolean#hashCode().
          return result
//               ^^^^^^ reference local 7
      }
  
      override fun toString(): String =
//                 ^^^^^^^^ definition semanticdb maven . . org/jetbrains/exposed/v1/core/Index#toString().
//                          display_name toString
//                          documentation ```kotlin\npublic open override fun toString(): String\n```
//                          relationship is_reference is_implementation semanticdb maven . . kotlin/Any#toString().
//                             ^^^^^^ reference semanticdb maven . . kotlin/String#
          "${if (unique) "Unique " else ""}Index '$indexName' for '${table.nameInDatabaseCase()}' on columns ${columns.joinToString()}"
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getUnique().
//               ^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#unique.
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getIndexName().
//                                                 ^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#indexName.
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getTable().
//                                                                   ^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#table.
//                                                                         ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Table#nameInDatabaseCase().
//                                                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#columns.
//                                                                                                             ^^^^^^^ reference semanticdb maven . . org/jetbrains/exposed/v1/core/Index#getColumns().
//                                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/joinToString(+9).
  }
