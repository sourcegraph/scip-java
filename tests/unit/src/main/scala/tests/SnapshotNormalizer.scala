package tests

object SnapshotNormalizer {

  /**
   * Replace the JDK major version embedded in `semanticdb maven jdk . ...`
   * symbols with a fixed placeholder so snapshots are stable across JDK
   * versions. The runtime JDK leaks into indexer output via
   * `JdkPackage.forRuntime`, but unit/snapshot tests only care that the symbol
   * *structure* is correct — the actual JDK version is covered by the Maven
   * integration matrix.
   */
  def normalizeJdkVersion(text: String): String = text.replaceAll(
    """jdk \d+""",
    "jdk ."
  )
}
