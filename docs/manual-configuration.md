---
id: manual-configuration
title: Manual configuration
---

The `lsif-java index` command does a best-effort to automatically index a given
codebase. The automatic step may not always work. The purpose of this page is to
document the steps to manually configure lsif-java when automatic indexing
fails.

## Overview

Indexing a codebase consists of two independent steps:

- Compile the codebase with the SemanticDB compiler plugin.
- Generate LSIF index from SemanticDB files.

![A three stage pipeline that starts with a list of Java sources, creates a list of SemanticDB files that then become a single LSIF index.](assets/semanticdb-javac-pipeline.svg)

## Step 1: Add SemanticDB compiler plugin to the classpath

The SemanticDB compiler plugin is published to Maven Central as a
zero-dependency Java library that you can install like any normal dependency.

[![](https://img.shields.io/maven-central/v/com.sourcegraph/semanticdb-javac)](https://repo1.maven.org/maven2/com/sourcegraph/semanticdb-javac/)

If you're using Gradle.

```groovy
implementation group: 'com.sourcegraph', name: 'semanticdb-javac', version: '@STABLE_VERSION@'
```

If you're using Maven.

```xml
<dependency>
    <groupId>com.sourcegraph</groupId>
    <artifactId>semanticdb-javac</artifactId>
    <version>@STABLE_VERSION@</version>
</dependency>
```

If you're using sbt.

```scala
libraryDependencies += "com.sourcegraph" % "semanticdb-javac" % "@STABLE_VERSION@"
```

## Step 2: Enable `-Xplugin:semanticdb` compiler option

Add `-Xplugin:semanticdb` to your compiler options to enable the SemanticDB
compiler plugin. To do this you need to explicitly configure two directories:

- `-sourceroot:PATH`: the absolute path to the root directory of your codebase.
  It's important that all of the source files that should be index live under
  this directory.
- `-targetroot:PATH`: the absolute path to the directory where to generate
  SemanticDB file. This directory can be anywhere on your file system.

If you're using Gradle.

```groovy
tasks.withType(JavaCompile) {
    def sourceroot = rootProject.projectDir
    def targetroot = new File(rootProject.buildDir, "semanticdb-targetroot")
    options.compilerArgs << '-Xplugin:semanticdb -sourceroot:$sourceroot -targetroot:$targetroot'
}
```

If you're using Maven.

```diff
 <project>
   [...]
   <build>
     [...]
     <plugins>
       <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.8.1</version>
         <configuration>
           <compilerArgs>
+            <arg>-Xplugin:semanticdb -sourceroot:${session.executionRootDirectory} -targetroot:${session.executionRootDirectory}/target/semanticdb-targetroot</arg>
           </compilerArgs>
         </configuration>
       </plugin>
     </plugins>
     [...]
   </build>
   [...]
 </project>
```

If you're using sbt.

```scala
Compile / javacOptions += {
    val sourceroot = (ThisBuild / baseDirectory).value
    val targetroot = (ThisBuild / target).value / "semanticdb-targetroot"
    s"-Xplugin:semanticdb -sourceroot:$sourceroot -targeroot:$sourceroot"
}
```

## Step 3: Compile the codebase

Compile all source files in the codebase once the compiler setting has been
configured. The exact command depends on your build tool. Below are some
examples:

- Gradle: `./gradlew clean compileJava compileTestJava`
- Maven: `mvn clean verify -DskipTests`
- sbt: `sbt clean test:compile`
- Bazel: `bazel build //...`

If everything went well, you should have a lot of `*.semanticdb` files in the
targetroot directory.

```
❯ find $TARGETROOT -type f
build/semanticdb-targetroot/META-INF/semanticdb/j8/src/test/java/example/ExampleTest.java.semanticdb
build/semanticdb-targetroot/META-INF/semanticdb/j8/src/main/java/example/Example.java.semanticdb
...
```

## Step 4: Generate LSIF index from SemanticDB files

Run the `lsif-java index-semanticdb` command to convert SemanticDB files into
LSIF.

```sh
❯ lsif-java index-semanticdb $TARGETROOT
❯ file dump.lsif
dump.lsif: JSON data
```
