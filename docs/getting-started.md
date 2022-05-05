---
id: getting-started
title: Getting started
---

By following the instructions on this page, you should be able to generate an
[LSIF](https://microsoft.github.io/language-server-protocol/specifications/lsif/0.5.0/specification/)
index of your Java codebase using Gradle or Maven. See
[Supported build tools](#supported-build-tools) for an overview of other build
tools that we're planning to support in the future.

**NOTE:** Lsif-java expects your build to have one of the following files in the directory where lsif-java index gets invoked
- **Gradle:**
  - settings.gradle
  - gradlew
  - build.gradle
  - build.gradle.kts

- **Maven:**
  - settings.gradle

## Install `lsif-java`

The most common way to use `lsif-java` is to run it from CI to upload LSIF
indexes after merging a pull request. 

The easiest way to install `lsif-java` is to use the Docker launcher.

### Docker container

Run the `lsif-java index`command from the `sourcegraph/lsif-java` Docker
container.

```sh
$ docker run -v $(pwd):/home/gradle sourcegraph/lsif-java:latest lsif-java index
$ src lsif upload # (optional) upload index to Sourcegraph
```

If everything went OK, a `dump.lsif` file should exist after the command has
finished indexing the project.

> The Docker container is made available for convenience at the cost of
> performance. Consider using the [Java launcher](#java-launcher) instead of the
> Docker container for better performance. The Docker container is a large
> download because it includes multiple pre-installed Java versions (Java 8,
> Java 11 and Java 17). Also, external dependencies of your codebase get
> re-downloaded on every `lsif-java index` invocation.

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

Use the `lsif-java` launcher if you can install software from the internet in
your CI.

Use [Coursier](https://get-coursier.io/docs/cli-installation.html) to launch the
`lsif-java` Java binary. The jar files for `lsif-java` are downloaded the first
time you run the `launch` command, and they are cached for subsequent runs.

Copy-paste the steps below into your CI workflow to launch `lsif-java`.

```sh
# macOS/Linux
curl -fLo coursier https://git.io/coursier-cli \
  && chmod +x coursier \
  && ./coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help

# Windows
bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
./coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help

# Homebrew
brew install coursier/formulas/coursier \
 && coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help
```

Additional command-line flags can be passed after the `--` argument. For
example, replace `--help` with `index` in the command above to run the `index`
subcommand.

### Java fat jar

Use the `lsif-java` fat jar if your CI does not allow downloading binaries from
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
  && ./coursier bootstrap --standalone -o lsif-java com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@
./lsif-java --help

# Windows
bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
./coursier bootstrap --standalone -o lsif-java com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@
./lsif-java --help
```

### Java library

The `lsif-java` command-line interface is published to Maven Central. You can
run the command-line interface as a library by directly invoking the `main()`
method on the `com.sourcegraph.lsif_java.LsifJava` class.

[![](https://img.shields.io/maven-central/v/com.sourcegraph/lsif-java_2.13)](https://repo1.maven.org/maven2/com/sourcegraph/lsif-java_2.13/)

If you're using Gradle.

```groovy
implementation group: 'com.sourcegraph', name: 'lsif-java_2.13', version: '@STABLE_VERSION@'
```

If you're using Maven.

```xml
<dependency>
    <groupId>com.sourcegraph</groupId>
    <artifactId>lsif-java_2.13</artifactId>
    <version>@STABLE_VERSION@</version>
</dependency>
```

If you're using sbt.

```scala
scalaVersion := "@SCALA_VERSION@" // Only Scala 2.13 is supported.
libraryDependencies += "com.sourcegraph" %% "lsif-java" % "@STABLE_VERSION@"
```

## Run `lsif-java index`

> The `index` command is only supported for Gradle, Maven and sbt. See
> [Supported build tools](#supported-build-tools) for more details about other
> build tools.

Run the `lsif-java index` command to generate an LSIF index for your codebase.
This command should automatically infer the structure of your codebase and
configure your build tool to generate LSIF.

```sh
# At the root of a Gradle, Maven or sbt codebase.
$ lsif-java index
...
info: /path/to/dump.lsif
```

The `dump.lsif` file contains the LSIF index and is ready to be used.

> Running `lsif-java index` may perform side-effects on your build like cleaning
> the compile cache before indexing. This is done to make sure that all source
> files in the codebase get indexed.

Run `lsif-java index --help` to learn more about the available command-line
options.

```scala mdoc:passthrough
com.sourcegraph.lsif_java.LsifJava.printHelp(Console.out)
```

## Supported programming languages

| Programming language | Gradle | Maven | sbt | Tracking issue                                              |
| -------------------- | ------ | ----- | --- | ----------------------------------------------------------- |
| Java                 | ✅     | ✅    | ✅  |                                                             |
| Scala                | ✅     | ❌    | ✅  | [#302](https://github.com/sourcegraph/lsif-java/issues/302) |
| Kotlin               | ✅     | ❌    | n/a | [#304](https://github.com/sourcegraph/lsif-java/issues/304) |

### Java

The `lsif-java` indexer is implemented as a Java compiler plugin that runs as
part of your regular compilation in the build tool. By using Java compiler APIs,
`lsif-java` is able to generate accurate indexing information for a broad range
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

The Kotlin support in lsif-java is the least mature compared to the Java and
Scala support. Don't hesitate to report issues at
https://github.com/sourcegraph/lsif-kotlin if you encounter issues using the
Kotlin support.

## Supported build tools

It's possible to use lsif-java with any Java build tool. Some build tools can be
automatically configured by the `lsif-java index` command while other build
tools may require [manual configuration](manual-configuration.md).

### Automatic configuration

Please open an issue if your build tool is not listed in the table below. Feel
free to subscribe to the tracking issues to receive updates on your build tool.

| Build tool | Java | Scala | Kotlin | Tracking issue                                                                   |
| ---------- | ---- | ----- | ------ | -------------------------------------------------------------------------------- |
| Maven      | ✅   | ❌    | ❌     |                                                                                  |
| Gradle     | ✅   | ✅    | ✅     |                                                                                  |
| sbt        | ✅   | ✅    | n/a    |                                                                                  |
| Ant        | ❌   | ❌    | ❌     | [sourcegraph/lsif-java#305](https://github.com/sourcegraph/lsif-java/issues/305) |
| Bazel      | ❌   | ❌    | ❌     | [sourcegraph/lsif-java#88](https://github.com/sourcegraph/lsif-java/issues/88)   |
| Buck       | ❌   | ❌    | ❌     | [sourcegraph/lsif-java#99](https://github.com/sourcegraph/lsif-java/issues/99)   |
| Mill       | ❌   | ❌    | ❌     | [sourcegraph/lsif-java#306](https://github.com/sourcegraph/lsif-java/issues/306) |

**✅**: automatic indexing is fully supported. Please report a bug if the
`lsif-java index` command does not work on your codebase.

**❌**: automatic indexing is not supported but (!) you may still be able to use
`lsif-java` by configuring it manually using the instructions
[here](manual-configuration.md).

### Manual configuration

See the [manual configuration](manual-configuration.md) guide for instructions
on how to configure lsif-java to work with any build tool.

### Gradle

The `lsif-java index` build should be able to automatically index most Gradle
projects. However, the following Gradle integrations are not yet supported:

| Integration | Supported | Tracking issue                                                                   |
| ----------- | --------- | -------------------------------------------------------------------------------- |
| Android     | ❌        | [sourcegraph/lsif-java#177](https://github.com/sourcegraph/lsif-java/issues/177) |
| Kotlin      | ✅        |                                                                                  |
| Scala       | ✅        |                                                                                  |

### Maven

The `lsif-java index` build should be able to automatically index most Maven
projects. However, the following Maven integrations are not yet supported:

| Integration         | Supported | Tracking issue                                                                   |
| ------------------- | --------- | -------------------------------------------------------------------------------- |
| scala-maven-plugin  | ❌        | [sourcegraph/lsif-java#301](https://github.com/sourcegraph/lsif-java/issues/301) |
| scalor-maven-plugin | ❌        | [sourcegraph/lsif-java#301](https://github.com/sourcegraph/lsif-java/issues/301) |
| kotlin-maven-plugin | ❌        | [sourcegraph/lsif-java#304](https://github.com/sourcegraph/lsif-java/issues/304) |

### sbt

The `lsif-java index` build should be able to automatically index most Maven
projects, with the following caveats:

| Integration   | Supported | Recommendation          |
| ------------- | --------- | ----------------------- |
| sbt <v0.13.17 | ❌        | Upgrade to sbt v0.13.17 |
