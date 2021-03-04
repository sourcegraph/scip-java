# Java indexer for the Language Server Index Format (LSIF) ![](https://img.shields.io/badge/status-development-yellow?style=flat)

## Usage

Visit https://sourcegraph.github.io/lsif-java to get started with lsif-java.

⚠ The rest of this readme is targeted at contributors to the lsif-java codebase.

## Overview

This project is implemented as a
[Java compiler plugin](https://docs.oracle.com/en/java/javase/11/docs/api/jdk.compiler/com/sun/source/util/Plugin.html)
that generates one
[SemanticDB](https://scalameta.org/docs/semanticdb/specification.html) file for
every `*.java` source file. After compilation completes, the SemanticDB files
are processed to produce LSIF.

![A three stage pipeline that starts with a list of Java sources, creates a list of SemanticDB files that then become a single LSIF index.](docs/img/semanticdb-javac-pipeline.svg)

### Why Java compiler plugin?

There are several benefits to implementing lsif-java as a compiler plugin:

- **Simple installation**: compiler plugins are enabled with the `-Xplugin`
  compiler option. All Java build tools support a way to customize compiler
  options, simplifying installation.
- **Language fidelity**: by using the Java compiler to produce semantic
  information, we ensure that the produced LSIF data is accurate even as new
  Java language versions with new language features are released.
- **Environment fidelity**: by hooking into the compilation process of the build
  tool, we minimize the risk of diverging from the CI build environment such as
  installed system dependencies, custom compiler options and custom annotation
  processors.

### Why SemanticDB?

SemanticDB is Protobuf schema for information about symbols and types in Java
programs, Scala programs and other languages. There are several benefits to
using SemanticDB as an intermediary representation for LSIF:

- **Simplicity**: It's easy to translate a single Java source file into a single
  SemanticDB file inside a compiler plugin. It's more complicated to produce
  LSIF because compiler plugins does not have access to a project-wide context,
  which is necessary to produce accurate definitions and hovers in multi-module
  projects with external library dependencies.
- **Performance**: SemanticDB is fast to write and read. Each compilation unit
  can be processed independently to keep memory usage low. The final conversion
  from SemanticDB to LSIF can be safely parallelized.
- **Cross-language**: SemanticDB has a
  [spec](https://scalameta.org/docs/semanticdb/specification.html) for Java and
  Scala enabling cross-language navigation in hybrid Java/Scala codebases.
- **Cross-repository**: Compiler plugins have access to both source code and the
  classpath (compiled bytecode of upstream dependencies). SemanticDB has been
  designed so that it's also possible to generate spec-compliant symbols from
  the classpath alone (no source code) and from the syntax tree of an individual
  source file (no classpath). This flexibility allows the
  [Metals](https://scalameta.org/metals/) language server to index codebases
  from a variety of different inputs, and will be helpful for lsif-java in the
  future to unblock cross-repository navigation.

## Contributing

The following sections provide tips on how to contribute to this codebase.

### System dependencies

- `java`: any version should work
- `git`: any version should work
- `lsif-semanticdb`:
  `go get github.com/sourcegraph/lsif-semanticdb/cmd/lsif-semanticdb`
- `gradle`: `brew install gradle`, or see
  [general installation guide](https://gradle.org/install/).
- `mvn`: `brew install maven`, or see
  [general installation guide](https://www.baeldung.com/install-maven-on-windows-linux-mac).

### Project structure

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
- `build.sbt`: the sbt build definition.
- `project/plugins.sbt`: plugins for the sbt build.

### Helpful commands

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
| `cli/run --cwd DIRECTORY`                                           | sbt      | Run `lsif-java` command-line tool against a given Gradle/Maven build.               |
| `cd website && yarn install && yarn start`                          | terminal | Start live-reload preview of the website at http://localhost:3000/lsif-java.        |
| `docs/mdoc --watch`                                                 | sbt      | Re-generate markdown files in the `docs/` directory.                                |
| `fixAll`                                                            | sbt      | Run Scalafmt, Scalafix and Javafmt on all sources. Run this before opening a PR.    |

### Import the project into IntelliJ

It's recommended to use IntelliJ when editing code in this codebase.

First, install the
[IntelliJ Community Edition](https://www.jetbrains.com/idea/download/). The
community edition is
[open source](https://github.com/JetBrains/intellij-community) and free to use.

Next, install the IntelliJ Scala plugin.

Finally, run "File > Project From Existing Sources" to import the sbt build into
IntelliJ. Select the "sbt" option if it asks you to choose between
sbt/BSP/Bloop.

It's best to run tests from the sbt shell, not from the IntelliJ UI.

### Don't use VS Code/Vim/Sublime Text/Emacs

If you want to use completions and precise code navigation, it's not recommended
to use other editors than IntelliJ. IntelliJ is the only IDE that properly
supports hybrid Java/Scala codebases at the moment, although that may change
soon thanks to lsif-java :)

### Tests are written in Scala

This codebases uses the Scala library [MUnit](https://scalameta.org/munit/) to
write tests because:

- MUnit has built-in assertions that print readable multiline diffs in color.
- MUnit makes it easy to implement
  [snapshot testing](https://jestjs.io/docs/en/snapshot-testing), which is a
  testing technique that's heavily used in this codebase.
- Multiline literal strings in Scala make it easy to write unit tests for source
  code (which is always multiline). Modern versions of Java support multiline
  string literals, but they're not supported in Java 8, which is supported by
  lsif-java.

## Benchmarks

See [docs/benchmarks.md] for benchmark results.
