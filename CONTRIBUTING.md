# Contributing guide

This page documents tips and tricks for contributing to the
[sourcegraph/scip-java](https://github.com/sourcegraph/scip-java) codebase.

## System dependencies

The recommended way to get a working development environment is via
[Nix](https://nixos.org/download) and the provided [flake](https://github.com/sourcegraph/scip-java/blob/main/flake.nix):

```sh
nix develop              # default shell (JDK 11)
nix develop .#jdk17      # JDK 17
nix develop .#jdk21      # JDK 21
```

This drops you into a shell with `maven`, `gradle`, `bazelisk`, `nodejs`,
`yarn`, `git`, `jq`, etc. all pinned to the versions used in CI.

If you'd rather install tools manually, you'll need at least:

- `java`: any version should work
- `git`: any version should work
- `mvn`: `brew install maven`, or see
  [general installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac).
- `gradle`: `brew install gradle`, or see
  [general installation guide](https://gradle.org/install/). The project build
  is Maven-based, but the CLI integration tests still exercise Gradle projects.

## Project structure

These are the main components of the project.

- `scip-javac/src/main/java`: the Java compiler plugin that creates
  SCIP files.
- `tests/minimized`: minimized Java source files that reproduce interesting test
  cases.
- `tests/unit`: fast running unit tests that are helpful for local edit-and-test
  workflows.
- `tests/snapshots`: slow running
  ["snapshot tests"](https://jestjs.io/docs/en/snapshot-testing) that index a
  corpus of published Java libraries.
- `scip-java/src/main/kotlin`: implementation of the `scip-java` command-line
  interface.
- `scip-java/src/test`: build-tool integration tests and fixtures for the
  `scip-java` command-line interface.
- `pom.xml`: Maven reactor, dependency versions, and shared plugin setup.
- `*/pom.xml`: Maven module build definitions.
- `build.gradle.kts`, `settings.gradle.kts`, `gradle/libs.versions.toml`: legacy
  Gradle build files kept during the Maven migration experiment.

## Helpful commands

| Command                                                 | Where    | Description                                                             |
| ------------------------------------------------------- | -------- | ----------------------------------------------------------------------- |
| `mvn --batch-mode test`                                 | terminal | Run all Maven reactor tests.                                             |
| `mvn --batch-mode -pl scip-java -am test`               | terminal | Run CLI build-tool integration tests (Gradle, Maven, SCIP config).       |
| `mvn --batch-mode -pl scip-kotlinc -am test`            | terminal | Run Kotlin compiler-plugin tests.                                        |
| `mvn --batch-mode -pl scip-snapshots -am test`          | terminal | Compare Java and Kotlin snapshot goldens.                                |
| `mvn --batch-mode -pl scip-snapshots -am -DskipTests -PsaveSnapshots verify` | terminal | Regenerate Java and Kotlin snapshot goldens.                             |
| `mvn --batch-mode -pl scip-java -am -DskipTests package` | terminal | Build a local `scip-java` distribution under `scip-java/target/install/`. |
| `scip-java/target/install/scip-java/bin/scip-java --cwd DIRECTORY index` | terminal | Run `scip-java` against a given Gradle/Maven build after packaging.       |
| `google-java-format --replace $(git ls-files '*.java')` | terminal | Format Java sources (from `nix develop`). Enforced by `nix flake check`. |
| `ktfmt --kotlinlang-style $(git ls-files '*.kt')`       | terminal | Format Kotlin sources (from `nix develop`). Enforced by `nix flake check`. |

## Import the project into IntelliJ

It's recommended to use IntelliJ when editing code in this codebase.

First, install the
[IntelliJ Community Edition](https://www.jetbrains.com/idea/download/). The
community edition is
[open source](https://github.com/JetBrains/intellij-community) and free to use.

Next, install the following IntelliJ plugins:

- Google Java Format

Next, follow
[these instructions](https://github.com/HPI-Information-Systems/Metanome/wiki/Installing-the-google-styleguide-settings-in-intellij-and-eclipse)
here to configure the Google Java formatter.

Finally, run "File > Project From Existing Sources" to import the Maven build
into IntelliJ. Select the "Maven" option if it asks you to choose a build
model.

It's best to run tests from Maven, not from the IntelliJ UI.

## Tests are written in Java with JUnit 5

The Java tests use [JUnit 5](https://junit.org/junit5/) through Maven Surefire's
Platform support. The snapshot suite is a JUnit `@TestFactory` that emits one
dynamic test per generated document, comparing it against the committed goldens
under `scip-snapshots/expected`. Build-tool tests (`scip-java/src/test`) are
written in Kotlin.
