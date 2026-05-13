import sbt._

// Task key for regenerating the SCIP/SemanticDB golden snapshots emitted by
// the semanticdb-kotlinc compiler plugin over the Kotlin minimized fixtures.
// Defined here (in the project/ build sources) so build.sbt can `import` it.
//
// We deliberately do NOT call this `snapshots` to avoid colliding with the
// existing top-level `snapshots` test project (`lazy val snapshots = project`).
object SemanticdbKotlincKeys {
  lazy val kotlincSnapshots = taskKey[Unit](
    "Run the SCIP snapshot generator over the semanticdb-kotlinc minimized project"
  )
}
