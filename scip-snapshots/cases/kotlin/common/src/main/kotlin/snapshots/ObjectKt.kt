package snapshots

import java.lang.RuntimeException

object ObjectKt {
  fun fail(message: String?): Nothing {
    throw RuntimeException(message)
  }
}
