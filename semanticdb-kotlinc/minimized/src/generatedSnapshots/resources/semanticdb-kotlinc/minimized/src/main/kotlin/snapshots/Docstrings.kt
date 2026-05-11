  package snapshots
//        ^^^^^^^^^ reference semanticdb maven . . snapshots/
  
  import java.io.Serializable
//       ^^^^ reference semanticdb maven . . java/
//            ^^ reference semanticdb maven . . java/io/
//               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/DocstringSuperclass#
//⌄ enclosing_range_start semanticdb maven . . snapshots/DocstringSuperclass#`<init>`().
  abstract class DocstringSuperclass
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/DocstringSuperclass#
//                                   display_name DocstringSuperclass
//                                   documentation ```kotlin\npublic abstract class DocstringSuperclass : Any\n```
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/DocstringSuperclass#`<init>`().
//                                   display_name DocstringSuperclass
//                                   documentation ```kotlin\npublic constructor(): DocstringSuperclass\n```
//                                 ⌃ enclosing_range_end semanticdb maven . . snapshots/DocstringSuperclass#
//                                 ⌃ enclosing_range_end semanticdb maven . . snapshots/DocstringSuperclass#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . snapshots/Docstrings#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Docstrings#`<init>`().
  /** Example class docstring. */
  class Docstrings :  DocstringSuperclass(), Serializable {
//      ^^^^^^^^^^ definition semanticdb maven . . snapshots/Docstrings#
//                 display_name Docstrings
//                 documentation ```kotlin\npublic final class Docstrings : DocstringSuperclass, Serializable\n```\n\n----\n\n Example class docstring.
//                 relationship is_reference is_implementation semanticdb maven . . snapshots/DocstringSuperclass#
//                 relationship is_reference is_implementation semanticdb maven jdk 11 java/io/Serializable#
//      ^^^^^^^^^^ definition semanticdb maven . . snapshots/Docstrings#`<init>`().
//                 display_name Docstrings
//                 documentation ```kotlin\npublic constructor(): Docstrings\n```\n\n----\n\n Example class docstring.
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . snapshots/DocstringSuperclass#
//                                           ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/io/Serializable#
  }
//⌃ enclosing_range_end semanticdb maven . . snapshots/Docstrings#
//⌃ enclosing_range_end semanticdb maven . . snapshots/Docstrings#`<init>`().
  
//⌄ enclosing_range_start semanticdb maven . . snapshots/docstrings().
  /** Example method docstring. */
  fun docstrings() { }
//    ^^^^^^^^^^ definition semanticdb maven . . snapshots/docstrings().
//               display_name docstrings
//               documentation ```kotlin\npublic final fun docstrings(): Unit\n```\n\n----\n\n Example method docstring.
//                   ⌃ enclosing_range_end semanticdb maven . . snapshots/docstrings().
