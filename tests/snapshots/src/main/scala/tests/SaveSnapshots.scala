package tests

object SaveSnapshots {
  def main(args: Array[String]): Unit = {
    val expectDirectory = tests.snapshots.BuildInfo.snapshotDirectory.toPath
    val mapping = Map(
      "minimized" -> new MinimizedSnapshotScipGenerator(),
      "library" -> new LibrarySnapshotGenerator()
    )

    val enabledGenerators =
      if (args.isEmpty)
        mapping.values.toList
      else
        args.flatMap(mapping.get).toList

    val generator = new AggregateSnapshotGenerator(enabledGenerators)

    generator.run(SnapshotContext(expectDirectory), new SaveSnapshotHandler)
  }
}
