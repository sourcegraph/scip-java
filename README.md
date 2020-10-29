# Java LSIF indexer ![](https://img.shields.io/badge/status-development-yellow?style=flat)

Visit https://lsif.dev/ to learn about LSIF.

## Progress

- Cross- and same-file references, definitions and hovers (excl stdlib+external dependencies)
- Tentative Gradle support

## Development

- JDK 9 or higher
- Kotlin
- Gradle

### Build the LSIF indexer

This compiles the indexer and generates a script to launch it at `./build/install/lsifjava/bin/lsifjava`

```
git clone https://github.com/sourcegraph/lsif-java
cd lsif-java
./gradlew installDist
```

### Build the release JAR

The resulting JAR is at `./build/libs/lsifjava-<version>.jar`

```
./gradlew fatJar
```

## Generating an LSIF dump

Ensure the JRE version is the same or higher than the version the project requires to compile e.g. if
`sourceCompatibility = '1.9'` is specified in `build.gradle`, ensure the JRE version is 9+, with a minimum of JRE 8 required to
run lsif-java  

```
java -jar lsifjava-<version>.jar \
  -projectRoot <project directory> \
  -out dump.lsif
```

## Comparison to [Microsoft/lsif-java](https://github.com/Microsoft/lsif-java)

- sourcegraph/lsif-java is ~10x faster *(untested for new com.sun.source based lsif-java)*
- sourcegraph/lsif-java supports cross-file hovers/definitions/references (Microsoft/lsif-java does not)
- sourcegraph/lsif-java uses com.sun.source, which provides access to the Java Compiler API
- Microsoft/lsif-java uses [eclipse.jdt.ls](https://github.com/eclipse/eclipse.jdt.ls), which is built on [eclipse.jdt.core](https://github.com/eclipse/eclipse.jdt.core)

See https://github.com/microsoft/lsif-java/issues/61 for the status of collaboration efforts.