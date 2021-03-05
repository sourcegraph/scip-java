---
id: getting-started
title: Getting started
---

By following the instructions on this page, you should be able to generate an
[LSIF](https://microsoft.github.io/language-server-protocol/specifications/lsif/0.5.0/specification/)
index of your Java codebase using Gradle or Maven. See
[Supported build tools](#supported-build-tools) for an overview of other build
tools that we're planning to support in the future.

## Install `lsif-java`

Most users only install `lsif-java` on a CI machine to upload LSIF indexes to a
remote service like [Sourcegraph](https://sourcegraph.com/). The easiest way to
install `lsif-java` is to download the native binary. However, you can also
install `lsif-java` as a Java binary if that's easier to integrate with your
setup.

### Native binary

The native binary is only available for Linux and macOS. The native binary
includes all dependencies and does not need further access to the internet after
it's been downloaded.

```sh
# macOS
curl -Lo lsif-java https://github.com/sourcegraph/lsif-java/releases/download/@STABLE_VERSION@/lsif-java-x86_64-apple-darwin
chmod +x lsif-java
./lsif-java --help

# Linux
curl -Lo lsif-java https://github.com/sourcegraph/lsif-java/releases/download/@STABLE_VERSION@/lsif-java-x86_64-pc-linux
chmod +x lsif-java
./lsif-java --help
```

### Java launcher

Use [Coursier](https://get-coursier.io/docs/cli-installation.html) to launch the
Java binary. The jar files of `lsif-java` are downloaded the first time you run
the `launch` command, and they're cached for subsequent runs.

```sh
# Homebrew
brew install coursier/formulas/coursier
coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help

# macOS/Linux
curl -fLo coursier https://git.io/coursier-cli
chmod +x coursier
./coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help

# Windows
bitsadmin /transfer downloadCoursierCli https://git.io/coursier-cli "%cd%\coursier"
bitsadmin /transfer downloadCoursierBat https://git.io/coursier-bat "%cd%\coursier.bat"
./coursier launch com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@ -- --help
```

### Java fat jar

Use the Coursier `bootstrap` command to generate an executable Java binary,
which includes all dependencies and does not require further access to the
internet after installation.

```sh
# macOS/Linux/Windows
cs bootstrap --standalone -o lsif-java com.sourcegraph:lsif-java_2.13:@STABLE_VERSION@
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

Run the `lsif-java index` command to generate an LSIF index for your codebase.
This command should automatically infer the structure of your codebase and
configure your build tool to generate LSIF.

```sh
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

## Supported Java versions

The `lsif-java` indexer is implemented as a Java compiler plugin that runs as
part of your regular compilation in the build tool. By using Java compiler APIs,
`lsif-java` is able to generate accurate indexing information for a broad range
of Java versions.

| Language version | Support                        |
| ---------------- | ------------------------------ |
| Java 7           | ❌                             |
| Java 8           | ✅                             |
| Java 11          | ✅                             |
| Java 12          | Not tested in CI, but may work |
| Java 13          | Not tested in CI, but may work |
| Java 14          | Not tested in CI, but may work |
| Java 15          | ✅                             |
| Java 16          | Not tested in CI, but may work |
| Java 17          | Not tested in CI, but may work |

## Supported build tools

Please open an issue if your build tool is not listed in the table below. Feel
free to subscribe to the tracking issues to receive updates on your build tool.

| Build tool | Support | Tracking issue                                                                   |
| ---------- | ------- | -------------------------------------------------------------------------------- |
| Gradle     | ✅      |                                                                                  |
| Maven      | ✅      |                                                                                  |
| Bazel      | ❌      | [sourcegraph/lsif-java#88](https://github.com/sourcegraph/lsif-java/issues/88)   |
| Buck       | ❌      | [sourcegraph/lsif-java#99](https://github.com/sourcegraph/lsif-java/issues/99)   |
| sbt        | ❌      | [sourcegraph/lsif-java#110](https://github.com/sourcegraph/lsif-java/issues/110) |

**✅**: automatic indexing is fully supported. Please report a bug if the
`lsif-java index` command does not work on your codebase.

**❌**: automatic inference is not supported but (!) you may still be able to
use `lsif-java` by configuring it manually using the instructions
[here](manual-configuration.md).
