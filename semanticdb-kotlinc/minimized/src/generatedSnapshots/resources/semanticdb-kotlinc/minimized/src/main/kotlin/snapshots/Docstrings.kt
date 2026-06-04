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
//                                   signature_documentation kotlin public abstract class DocstringSuperclass : Any
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . snapshots/DocstringSuperclass#`<init>`().
//                                   display_name DocstringSuperclass
//                                   signature_documentation kotlin public constructor(): DocstringSuperclass
//                                 ⌃ enclosing_range_end semanticdb maven . . snapshots/DocstringSuperclass#
//                                 ⌃ enclosing_range_end semanticdb maven . . snapshots/DocstringSuperclass#`<init>`().
//⌄ enclosing_range_start semanticdb maven . . snapshots/Docstrings#
//⌄ enclosing_range_start semanticdb maven . . snapshots/Docstrings#`<init>`().
  /** Example class docstring. */
  class Docstrings :  DocstringSuperclass(), Serializable {
//      ^^^^^^^^^^ definition semanticdb maven . . snapshots/Docstrings#
//                 display_name Docstrings
//                 signature_documentation kotlin public final class Docstrings : DocstringSuperclass, Serializable
//                 documentation Example class docstring.
//                 relationship is_implementation semanticdb maven . . snapshots/DocstringSuperclass#
//                 relationship is_implementation semanticdb maven jdk 11 java/io/Serializable#
//      ^^^^^^^^^^ definition semanticdb maven . . snapshots/Docstrings#`<init>`().
//                 display_name Docstrings
//                 signature_documentation kotlin public constructor(): Docstrings
//                 documentation Example class docstring.
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
//               signature_documentation kotlin public final fun docstrings(): Unit
//               documentation Example method docstring.
//                   ⌃ enclosing_range_end semanticdb maven . . snapshots/docstrings().
