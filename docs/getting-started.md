---
id: getting-started
title: Getting started
---

By following the instructions on this page, you should be able to generate an
[SCIP](https://microsoft.github.io/language-server-protocol/specifications/scip/0.5.0/specification/)
index of your Java codebase using Gradle or Maven. See
[Supported build tools](#supported-build-tools) for an overview of other build
tools that we're planning to support in the future.

## Install `scip-java`

The most common way to use `scip-java` is to run it from CI to upload SCIP
indexes after merging a pull request.

The easiest way to install `scip-java` is to use the Docker launcher.

### Docker container

Run the `scip-java index`command from the `sourcegraph/scip-java` Docker
container.

```sh
$ docker run -v $(pwd):/home/gradle sourcegraph/scip-java:latest scip-java index
$ src scip upload # (optional) upload index to Sourcegraph
```

If everything went OK, a `index.scip` file should exist after the command has
finished indexing the project.

> The Docker container is made available for convenience at the cost of
> performance. Consider using the [Java launcher](#java-launcher) instead of the
> Docker container for better performance. The Docker container is a large
> download because it includes multiple pre-installed Java versions (Java 8,
> Java 11 and Java 17). Also, external dependencies of your codebase get
> re-downloaded on every `scip-java index` invocation.

Java 8 is the Java version in the Docker container. Use the following commands
to change the default version:

- Java 11: `eval "$(coursier java --jvm 11 --env)"`
- Java 17:
  `eval "$(coursier java --jvm temurin:17 --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json --env)"`

Alternatively, create a `lsif-java.json` file at the root of your repository
with the following values:

```jsonc
// lsif-java.json
{
  "jvm": "11" // or "17"
}
```

### Java launcher

Use the `scip-java` launcher if you can install software from the internet in
your CI.

Use [Coursier](https://get-coursier.io/docs/cli-installation.html) to launch the
`scip-java` Java binary. The jar files for `scip-java` are downloaded the first
time you run the `launch` command, and they are cached for subsequent runs.

Copy-paste the steps below into your CI workflow to launch `scip-java`.

```sh
# macOS/Linux
curl -fLo coursier https://git.io/coursier-cli \
  && chmod +x coursier \
  && ./coursier launch com.sourcegraph:scip-java_2.13:@STABLE_VERSION@ -- --help

# Windows
bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
./coursier launch com.sourcegraph:scip-java_2.13:@STABLE_VERSION@ -- --help

# Homebrew
brew install coursier/formulas/coursier \
 && coursier launch com.sourcegraph:scip-java_2.13:@STABLE_VERSION@ -- --help
```

Additional command-line flags can be passed after the `--` argument. For
example, replace `--help` with `index` in the command above to run the `index`
subcommand.

### Java fat jar

Use the `scip-java` fat jar if your CI does not allow downloading binaries from
the internet.

Use the [Coursier](https://get-coursier.io/docs/cli-installation) `bootstrap`
command to generate a local fat jar binary. The fat jar binary includes all
dependencies and does not require further access to the internet after
installation. The local fat jar will somehow need to be made available to your
CI machine.

```sh
# macOS/Linux
curl -fLo coursier https://git.io/coursier-cli \
  && chmod +x coursier \
  && ./coursier bootstrap --standalone -o scip-java com.sourcegraph:scip-java_2.13:@STABLE_VERSION@
./scip-java --help

# Windows
bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
./coursier bootstrap --standalone -o scip-java com.sourcegraph:scip-java_2.13:@STABLE_VERSION@
./scip-java --help
```

### Java library

The `scip-java` command-line interface is published to Maven Central. You can
run the command-line interface as a library by directly invoking the `main()`
method on the `com.sourcegraph.scip_java.ScipJava` class.

[![](https://img.shields.io/maven-central/v/com.sourcegraph/scip-java_2.13)](https://repo1.maven.org/maven2/com/sourcegraph/scip-java_2.13/)

If you're using Gradle.

```groovy
implementation group: 'com.sourcegraph', name: 'scip-java_2.13', version: '@STABLE_VERSION@'
```

If you're using Maven.

```xml
<dependency>
    <groupId>com.sourcegraph</groupId>
    <artifactId>scip-java_2.13</artifactId>
    <version>@STABLE_VERSION@</version>
</dependency>
```

If you're using sbt.

```scala
scalaVersion := "@SCALA_VERSION@" // Only Scala 2.13 is supported.
libraryDependencies += "com.sourcegraph" %% "scip-java" % "@STABLE_VERSION@"
```

## Run `scip-java index`

> The `index` command is only supported for Gradle, Maven and sbt. See
> [Supported build tools](#supported-build-tools) for more details about other
> build tools.

Run the `scip-java index` command to generate an SCIP index for your codebase.
This command should automatically infer the structure of your codebase and
configure your build tool to generate SCIP.

```sh
# At the root of a Gradle, Maven or sbt codebase.
$ scip-java index
...
info: /path/to/index.scip
```

The `index.scip` file contains the SCIP index and is ready to be used.

> Running `scip-java index` may perform side-effects on your build like cleaning
> the compile cache before indexing. This is done to make sure that all source
> files in the codebase get indexed.

Run `scip-java index --help` to learn more about the available command-line
options.

```scala mdoc:passthrough
com.sourcegraph.scip_java.ScipJava.printHelp(Console.out)
```

## Supported programming languages

| Programming language | Gradle | Maven | sbt | Tracking issue                                              |
| -------------------- | ------ | ----- | --- | ----------------------------------------------------------- |
| Java                 | ✅     | ✅    | ✅  |                                                             |
| Scala                | ✅     | ❌    | ✅  | [#302](https://github.com/sourcegraph/scip-java/issues/302) |
| Kotlin               | ✅     | ❌    | n/a | [#304](https://github.com/sourcegraph/scip-java/issues/304) |

### Java

The `scip-java` indexer is implemented as a Java compiler plugin that runs as
part of your regular compilation in the build tool. By using Java compiler APIs,
`scip-java` is able to generate accurate indexing information for a broad range
of Java versions.

| Java version | Support                             | Tracking issue |
| ------------ | ----------------------------------- | -------------- |
| Java 7       | ❌                                  |                |
| Java 8       | ✅                                  |                |
| Java 11      | ✅                                  |                |
| Java 17      | ✅, requires custom `--add-exports` |                |

For Java 17 and newer versions, the following JVM options are required:

```
--add-exports jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED
--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED
--add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED
--add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED
--add-exports jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED
```

### Scala

Scala version support should always match the Scala versions that are supported
by [Metals](https://scalameta.org/metals), the Scala language server.

| Scala version | Goto definition | Find references | Hover |
| ------------- | --------------- | --------------- | ----- |
| Scala 2.10.x  | ❌              | ❌              | ❌    |
| Scala 2.11.x  | ✅              | ✅              | ✅    |
| Scala 2.12.x  | ✅              | ✅              | ✅    |
| Scala 2.13.x  | ✅              | ✅              | ✅    |
| Scala 3.x     | ✅              | ✅              | ❌    |

> Scala.js and Scala Native have equal support as Scala on the JVM.

### Kotlin

The Kotlin support in scip-java is the least mature compared to the Java and
Scala support. Don't hesitate to report issues at
https://github.com/sourcegraph/scip-kotlin if you encounter issues using the
Kotlin support.

## Supported build tools

It's possible to use scip-java with any Java build tool. Some build tools can be
automatically configured by the `scip-java index` command while other build
tools may require [manual configuration](manual-configuration.md).

### Automatic configuration

Please open an issue if your build tool is not listed in the table below. Feel
free to subscribe to the tracking issues to receive updates on your build tool.

| Build tool | Java | Scala | Kotlin | Tracking issue                                                                   |
| ---------- | ---- | ----- | ------ | -------------------------------------------------------------------------------- |
| Maven      | ✅   | ❌    | ❌     |                                                                                  |
| Gradle     | ✅   | ✅    | ✅     |                                                                                  |
| sbt        | ✅   | ✅    | n/a    |                                                                                  |
| Ant        | ❌   | ❌    | ❌     | [sourcegraph/scip-java#305](https://github.com/sourcegraph/scip-java/issues/305) |
| Bazel      | ✅   | ✅    | ❌     |                                                                                  |
| Buck       | ❌   | ❌    | ❌     | [sourcegraph/scip-java#99](https://github.com/sourcegraph/scip-java/issues/99)   |
| Mill       | ❌   | ❌    | ❌     | [sourcegraph/scip-java#306](https://github.com/sourcegraph/scip-java/issues/306) |

**✅**: automatic indexing is fully supported. Please report a bug if the
`scip-java index` command does not work on your codebase.

**❌**: automatic indexing is not supported but (!) you may still be able to use
`scip-java` by configuring it manually using the instructions
[here](manual-configuration.md).

### Manual configuration

See the [manual configuration](manual-configuration.md) guide for instructions
on how to configure scip-java to work with any build tool.

### Gradle

The `scip-java index` build should be able to automatically index most Gradle
projects. You Gradle build must contain one of the following files in the same
directory where `scip-java index` gets invoked.

- settings.gradle
- gradlew
- build.gradle
- build.gradle.kts

The following Gradle integrations are not yet supported:

| Integration | Supported | Tracking issue                                                                   |
| ----------- | --------- | -------------------------------------------------------------------------------- |
| Android     | ❌        | [sourcegraph/scip-java#177](https://github.com/sourcegraph/scip-java/issues/177) |
| Kotlin      | ✅        |                                                                                  |
| Scala       | ✅        |                                                                                  |

### Maven

The `scip-java index` build should be able to automatically index most Maven
projects. Your Maven build must contain a `pom.xml` file in the same directory
where `scip-java index` gets invoked.

The following Maven integrations are not yet supported:

| Integration         | Supported | Tracking issue                                                                   |
| ------------------- | --------- | -------------------------------------------------------------------------------- |
| scala-maven-plugin  | ❌        | [sourcegraph/scip-java#301](https://github.com/sourcegraph/scip-java/issues/301) |
| scalor-maven-plugin | ❌        | [sourcegraph/scip-java#301](https://github.com/sourcegraph/scip-java/issues/301) |
| kotlin-maven-plugin | ❌        | [sourcegraph/scip-java#304](https://github.com/sourcegraph/scip-java/issues/304) |

### sbt

The `scip-java index` build should be able to automatically index most Maven
projects, with the following caveats:

| Integration   | Supported | Recommendation          |
| ------------- | --------- | ----------------------- |
| sbt <v0.13.17 | ❌        | Upgrade to sbt v0.13.17 |

### Bazel

Bazel is supported by scip-java but it requires custom configuration to work
correctly. Note that the `scip-java index` command does not automatically index
Bazel builds.

The Bazel integration for scip-java is specifically designed to be compatible
with the Bazel build cache to enable incremental indexing. To achieve this,
scip-java must be configured in `WORKSPACE` and `BUILD` files. The scip-java
repository contains an example for how to configure everything.

- [WORKSPACE](https://github.com/sourcegraph/scip-java/blob/main/examples/bazel-example/WORKSPACE):
  adds the required dependencies to be able to run scip-java itself.
- [BUILD](https://github.com/sourcegraph/scip-java/blob/main/examples/bazel-example/src/main/java/example/BUILD):
  configured `java_library` and `java_binary` targets to be indexed with
  scip-java.

Don't hesitate to open an issue in the
[scip-java repository](https://github.com/sourcegraph/scip-java) if you have any
questions about using scip-java with Bazel builds.
