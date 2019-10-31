# Java LSIF indexer

## Usage

Make sure there is a `pom.xml` in the project root. For Gradle projects, you can create a `pom.xml` by first adding a [`createPom`](https://docs.gradle.org/current/userguide/maven_plugin.html#sec:maven_convention_methods) task then running `gradle createPom`. Here's an example task:

```groovy
task createPom  {
    pom { }.writeTo("pom.xml")
}
```

Then run the Java LSIF indexer:

```
mvn -q compile assembly:single
java -cp \
  target/lsifjava-1.0-SNAPSHOT-jar-with-dependencies.jar \
  Main \
  -projectRoot $PATH_TO_DIR_CONTAINING_POM_XML \
  -noContents \
  -out dump.lsif
```

## Comparison to [Microsoft/lsif-java](https://github.com/Microsoft/lsif-java)

- sourcegraph/lsif-java is ~10x faster
- sourcegraph/lsif-java supports cross-file hovers/definitions/references (Microsoft/lsif-java does not)
- sourcegraph/lsif-java only supports Maven projects (Microsoft/lsif-java: unknown)
- sourcegraph/lsif-java uses [Spoon](https://github.com/INRIA/spoon), which is built on [eclipse.jdt.core](https://github.com/eclipse/eclipse.jdt.core)
- Microsoft/lsif-java uses [eclipse.jdt.ls](https://github.com/eclipse/eclipse.jdt.ls), which is also built on [eclipse.jdt.core](https://github.com/eclipse/eclipse.jdt.core)

See https://github.com/microsoft/lsif-java/issues/61 for the status of collaboration efforts.
