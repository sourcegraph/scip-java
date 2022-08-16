---
id: contributing
sidebar_label: Guide
title: Contributing guide
---

This page documents tips and tricks for contributing to the
[sourcegraph/scip-java](https://github.com/sourcegraph/scip-java) codebase.

## System dependencies

- `java`: any version should work
- `git`: any version should work
- `gradle`: `brew install gradle`, or see
  [general installation guide](https://gradle.org/install/).
- `mvn`: `brew install maven`, or see
  [general installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac).

## Project structure

These are the main components of the project.

- `semanticdb-javac/src/main/java`: the Java compiler plugin that creates
  SemanticDB files.
- `tests/minimized`: minimized Java source files that reproduce interesting test
  cases.
- `tests/unit`: fast running unit tests that are helpful for local edit-and-test
  workflows.
- `tests/snapshots`: slow running
  ["snapshot tests"](https://jestjs.io/docs/en/snapshot-testing) that index a
  corpus of published Java libraries.
- `cli/src/main/scala`: implementation of the `scip-java` command-line
  interface.
- `build.sbt`: the sbt build definition.
- `project/plugins.sbt`: plugins for the sbt build.

## Helpful commands

| Command                                                             | Where    | Description                                                                         |
| ------------------------------------------------------------------- | -------- | ----------------------------------------------------------------------------------- |
| `./sbt`                                                             | terminal | Start interactive sbt shell with Java 11. Takes a while to load on the first run.   |
| `unit/test`                                                         | sbt      | Run fast unit tests.                                                                |
| `~unit/test`                                                        | sbt      | Start watch mode to run tests on file save, good for local edit-and-test workflows. |
| `buildTools/test`                                                   | sbt      | Run slow build tool tests (Gradle, Maven).                                          |
| `snapshots/testOnly tests.MinimizedSnapshotSuite`                   | sbt      | Runs fast snapshot tests. Indexes a small set of files under `tests/minimized`.     |
| `snapshots/testOnly tests.MinimizedSnapshotSuite -- *InnerClasses*` | sbt      | Runs only individual tests cases matching the name "InnerClasses".                  |
| `snapshots/testOnly tests.LibrarySnapshotSuite`                     | sbt      | Runs slow snapshot tests. Indexes a corpus of external Java libraries.              |
| `snapshots/test`                                                    | sbt      | Runs all snapshot tests.                                                            |
| `snapshots/run`                                                     | sbt      | Update snapshot tests. Use this command after you have fixed a bug.                 |
| `cli/run --cwd DIRECTORY`                                           | sbt      | Run `scip-java` command-line tool against a given Gradle/Maven build.               |
| `cd website && yarn install && yarn start`                          | terminal | Start live-reload preview of the website at http://localhost:3000/scip-java.        |
| `docs/mdoc --watch`                                                 | sbt      | Re-generate markdown files in the `docs/` directory.                                |
| `fixAll`                                                            | sbt      | Run Scalafmt, Scalafix and Javafmt on all sources. Run this before opening a PR.    |

## Import the project into IntelliJ

It's recommended to use IntelliJ when editing code in this codebase.

First, install the
[IntelliJ Community Edition](https://www.jetbrains.com/idea/download/). The
community edition is
[open source](https://github.com/JetBrains/intellij-community) and free to use.

Next, install the following IntelliJ plugins:

- IntelliJ Scala plugin.
- Google Java Format

Next, follow
[these instructions](https://github.com/HPI-Information-Systems/Metanome/wiki/Installing-the-google-styleguide-settings-in-intellij-and-eclipse)
here to configure the Google Java formatter.

Finally, run "File > Project From Existing Sources" to import the sbt build into
IntelliJ. Select the "sbt" option if it asks you to choose between
sbt/BSP/Bloop.

It's best to run tests from the sbt shell, not from the IntelliJ UI.

## Importing the project with Metals

While the cross-language support won't be as rich as it is in IntelliJ,
[Metals](https://scalameta.org/metals/) does offer rich language support for
Scala and basic Java navigation support (thanks to scip-java!). When using
Metals and your editor of choice it's recommended to use sbt as your build
server. This isn't the default with Metals, so you'll want to use the `Metals:
Switch build server` command and choose `sbt`.

## Tests are written in Scala

This codebases uses the Scala library [MUnit](https://scalameta.org/munit/) to
write tests because:

- MUnit has built-in assertions that print readable multiline diffs in color.
- MUnit makes it easy to implement
  [snapshot testing](https://jestjs.io/docs/en/snapshot-testing), which is a
  testing technique that's heavily used in this codebase.
- Multiline literal strings in Scala make it easy to write unit tests for source
  code (which is always multiline). Modern versions of Java support multiline
  string literals, but they're not supported in Java 8, which is supported by
  scip-java.
