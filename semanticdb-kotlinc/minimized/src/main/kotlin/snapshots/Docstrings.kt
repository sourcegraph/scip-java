package snapshots

import java.io.Serializable

abstract class DocstringSuperclass
/** Example class docstring. */
class Docstrings :  DocstringSuperclass(), Serializable {
}

/** Example method docstring. */
fun docstrings() { }
