  package snapshots
//        ^^^^^^^^^ reference scip-java maven . . snapshots/
  
  import java.io.Serializable
//       ^^^^ reference scip-java maven . . java/
//            ^^ reference scip-java maven . . java/io/
//               ^^^^^^^^^^^^ reference scip-java maven jdk 11 java/io/Serializable#
  
//⌄ enclosing_range_start scip-java maven . . snapshots/DocstringSuperclass#
//⌄ enclosing_range_start scip-java maven . . snapshots/DocstringSuperclass#`<init>`().
  abstract class DocstringSuperclass
//               ^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/DocstringSuperclass#
//                                   display_name DocstringSuperclass
//                                   signature_documentation kotlin public abstract class DocstringSuperclass : Any
//                                   kind Class
//               ^^^^^^^^^^^^^^^^^^^ definition scip-java maven . . snapshots/DocstringSuperclass#`<init>`().
//                                   display_name DocstringSuperclass
//                                   signature_documentation kotlin public constructor(): DocstringSuperclass
//                                   kind Constructor
//                                 ⌃ enclosing_range_end scip-java maven . . snapshots/DocstringSuperclass#
//                                 ⌃ enclosing_range_end scip-java maven . . snapshots/DocstringSuperclass#`<init>`().
//⌄ enclosing_range_start scip-java maven . . snapshots/Docstrings#
//⌄ enclosing_range_start scip-java maven . . snapshots/Docstrings#`<init>`().
  /** Example class docstring. */
  class Docstrings :  DocstringSuperclass(), Serializable {
//      ^^^^^^^^^^ definition scip-java maven . . snapshots/Docstrings#
//                 display_name Docstrings
//                 signature_documentation kotlin public final class Docstrings : DocstringSuperclass, Serializable
//                 kind Class
//                 documentation  Example class docstring.
//                 relationship is_implementation scip-java maven . . snapshots/DocstringSuperclass#
//                 relationship is_implementation scip-java maven jdk 11 java/io/Serializable#
//      ^^^^^^^^^^ definition scip-java maven . . snapshots/Docstrings#`<init>`().
//                 display_name Docstrings
//                 signature_documentation kotlin public constructor(): Docstrings
//                 kind Constructor
//                 documentation  Example class docstring.
//                    ^^^^^^^^^^^^^^^^^^^ reference scip-java maven . . snapshots/DocstringSuperclass#
//                                           ^^^^^^^^^^^^ reference scip-java maven jdk 11 java/io/Serializable#
  }
//⌃ enclosing_range_end scip-java maven . . snapshots/Docstrings#
//⌃ enclosing_range_end scip-java maven . . snapshots/Docstrings#`<init>`().
  
//⌄ enclosing_range_start scip-java maven . . snapshots/docstrings().
  /** Example method docstring. */
  fun docstrings() { }
//    ^^^^^^^^^^ definition scip-java maven . . snapshots/docstrings().
//               display_name docstrings
//               signature_documentation kotlin public final fun docstrings(): Unit
//               kind Method
//               documentation  Example method docstring.
//                   ⌃ enclosing_range_end scip-java maven . . snapshots/docstrings().
