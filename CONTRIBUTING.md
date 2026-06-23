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

This drops you into a shell with `sbt`, `maven`, `gradle`, `bazelisk`,
`nodejs`, `yarn`, `git`, `jq`, etc. all pinned to the versions used in CI.

If you'd rather install tools manually, you'll need at least:

- `java`: any version should work
- `git`: any version should work
- `gradle`: `brew install gradle`, or see
  [general installation guide](https://gradle.org/install/).
- `mvn`: `brew install maven`, or see
  [general installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac).

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
- `build.sbt`: the sbt build definition.
- `project/plugins.sbt`: plugins for the sbt build.

## Helpful commands

| Command                                                             | Where    | Description                                                                         |
| ------------------------------------------------------------------- | -------- | ----------------------------------------------------------------------------------- |
| `sbt`                                                               | terminal | Start interactive sbt shell with Java 11 (run from `nix develop`). Takes a while to load on the first run. |
| `unit/test`                                                         | sbt      | Run fast unit tests.                                                                |
| `~unit/test`                                                        | sbt      | Start watch mode to run tests on file save, good for local edit-and-test workflows. |
| `cli/test`                                                          | sbt      | Run slow build tool tests (Gradle, Maven).                                          |
| `snapshots/testOnly tests.MinimizedSnapshotScipTest`                | sbt      | Runs fast snapshot tests. Indexes a small set of files under `tests/minimized`.     |
| `snapshots/test`                                                    | sbt      | Runs all snapshot tests.                                                            |
| `snapshots/run`                                                     | sbt      | Update only the Java snapshot goldens under `tests/snapshots`.                      |
| `scipKotlincMinimized/kotlincSnapshots`                             | sbt      | Update only the Kotlin snapshot goldens under `scip-kotlinc/minimized`.             |
| `regenerateSnapshots`                                               | sbt      | Regenerate ALL snapshot goldens (Java + Kotlin). Run after fixing a bug.            |
| `cli/run --cwd DIRECTORY`                                           | sbt      | Run `scip-java` command-line tool against a given Gradle/Maven build.               |
| `google-java-format --replace $(git ls-files '*.java')`             | terminal | Format Java sources (from `nix develop`). Enforced by `nix flake check`.            |
| `ktfmt --kotlinlang-style $(git ls-files '*.kt')`                   | terminal | Format Kotlin sources (from `nix develop`). Enforced by `nix flake check`.          |

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

Finally, run "File > Project From Existing Sources" to import the sbt build into
IntelliJ. Select the "sbt" option if it asks you to choose between
sbt/BSP/Bloop.

It's best to run tests from the sbt shell, not from the IntelliJ UI.

## Tests are written in Java with JUnit 5

The unit tests (`tests/unit`) and snapshot tests (`tests/snapshots`) are plain
Java using [JUnit 5](https://junit.org/junit5/), wired into sbt via
[sbt-jupiter-interface](https://github.com/sbt/sbt-jupiter-interface). The
snapshot suite is a JUnit `@TestFactory` that emits one dynamic test per
generated document, comparing it against the committed goldens under
`tests/snapshots/src/main/generated`
([snapshot testing](https://jestjs.io/docs/en/snapshot-testing) is heavily used
in this codebase). Build-tool tests (`scip-java/src/test`) are written in
Kotlin.
