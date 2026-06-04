---
id: manual-configuration
title: Manual configuration
---

The `scip-java index` command does a best-effort to automatically index a given
codebase. The automatic step may not always work. The purpose of this page is to
document the steps to manually configure scip-java when automatic indexing
fails.

## Overview

Indexing a codebase consists of two independent phases:

- Compile the codebase with the SCIP compiler plugin.
- Generate SCIP index from SCIP files.

![A three stage pipeline that starts with a list of Java sources, creates a list of SCIP files that then become a single SCIP index.](assets/scip-javac-pipeline.svg)

The first phase can be complicated to configure and it can take a while to run.
The second phase is quite simple to configure and it usually runs very fast.

## Step 1: Add SCIP compiler plugin to the classpath

The SCIP compiler plugin is published to Maven Central as a
zero-dependency Java library that you can install like any normal dependency.

[![](https://img.shields.io/maven-central/v/com.sourcegraph/scip-javac)](https://repo1.maven.org/maven2/com/sourcegraph/scip-javac/)

Use `curl` to download the compiler plugin jar file manually so that it can be
added to the `javac -classpath` option.

```sh
curl -Lo scip-javac.jar https://repo1.maven.org/maven2/com/sourcegraph/scip-javac/@STABLE_VERSION@/scip-javac-@STABLE_VERSION@.jar
javac -classpath scip-javac.jar MyApplication.java
```

If you're using Gradle.

```groovy
// Option 1: if you are not using annotation processors
compileOnly 'com.sourcegraph:scip-javac:@STABLE_VERSION@'
// Option 2: if you are using annotation processors
annotationProcessor 'com.sourcegraph:scip-javac:@STABLE_VERSION@'
```

If you're using Maven.

```xml
<dependency>
    <groupId>com.sourcegraph</groupId>
    <artifactId>scip-javac</artifactId>
    <version>@STABLE_VERSION@</version>
</dependency>
```

## Step 2: Enable `-Xplugin:scip` compiler option

Add `-Xplugin:scip` to your compiler options to enable the SCIP
compiler plugin. To do this you need to explicitly configure two directories:

- `-sourceroot:PATH`: the absolute path to the root directory of your codebase.
  It's important that all of the source files that should be index live under
  this directory.
- `-targetroot:PATH`: the absolute path to the directory where to generate
  SCIP file. This directory can be anywhere on your file system.  
  Alternatively, pass in `-targetroot:javac-classes-directory` for the plugin to
  automatically use the `javac` output directory.

If you're using Gradle.

```groovy
tasks.withType(JavaCompile) {
  def sourceroot = rootProject.projectDir
  def targetroot = new File(rootProject.buildDir, "scip-targetroot")
  options.compilerArgs << "-Xplugin:scip -sourceroot:$sourceroot -targetroot:$targetroot"
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
+            <arg>-Xplugin:scip -sourceroot:${session.executionRootDirectory} -targetroot:${session.executionRootDirectory}/target/scip-targetroot</arg>
           </compilerArgs>
         </configuration>
       </plugin>
     </plugins>
     [...]
   </build>
   [...]
 </project>
```

## Step 3: Compile the codebase

Compile all source files in the codebase once the compiler setting has been
configured. The exact command depends on your build tool. Below are some
examples:

- Gradle: `./gradlew clean compileJava compileTestJava`
- Maven: `mvn clean verify -DskipTests`
- Bazel: `bazel build //...`

If everything went well, you should have a lot of `*.scip` files in the
targetroot directory.

```
❯ find $TARGETROOT -type f
build/scip-targetroot/META-INF/scip/j11/src/test/java/example/ExampleTest.java.scip
build/scip-targetroot/META-INF/scip/j11/src/main/java/example/Example.java.scip
...
```


## Step 4 (optional): Enable cross-repository navigation

Cross-repository navigation is a feature that allows "goto definition" and "find
references" to show results from multiple repositories.

By default, the `index.scip` file only enables navigation within the local
repository. You can optionally enable cross-repository navigation by creating
one of the following files in the SCIP _targetroot_ directory (the path in
`-Xplugin:scip -targeroot:PATH`).

- `javacopts.txt`: line-separated list of Java compiler options that got passed
  to the compiler. For example,

  ```sh
  $ cat $TARGETROOT/javacopts.txt
  -Xlint
  -classpath
  -path/to/dependency1.jar:/path/to/dependency2.jar
  -d
  /path/to/classes/directory
  /path/to/com/example/Main.java
  ```

  The `javacopts.txt` file format can only be used if the jars on the dependency
  classpath have sibling `.pom` files. In some build tools like Gradle, the POM
  files are not siblings to the jars on the classpath so the `javacopts.txt`
  format cannot be used.

- `dependencies.txt`: a tab-separated values file where the columns are: group
  ID, artifact ID, version and jar path. For example,

  ```sh
  $ cat $TARGETROOT/dependencies.txt
  junit junit 4.13.2  /path/to/junit.jar
  org.hamcrest hamcrest-core 1.3  /path/to/hamcrest-core.jar
  ```

  The `dependencies.txt` format is used by scip-java to map symbols such as
  `org.junit.Assert` to Maven coordinates like `junit:junit:4.13.2`. As long as
  your Sourcegraph instance has another repository that defines that symbol, the
  cross-repository navigation should succeed. 

### Maven plugin

To simplify setting up cross-repo navigation for Maven projects, we provide a 
plugin that can dump the project's dependencies in a format that scip-java understands.

You can either use it directly from commandline:

```
$ mvn com.sourcegraph:scip-maven-plugin:@STABLE_VERSION@:sourcegraphDependencies
```

Or add it to your build like any other maven plugin:

```xml
<plugin>
    <groupId>com.sourcegraph</groupId>
    <artifactId>scip-maven-plugin</artifactId>
    <version>@STABLE_VERSION@</version>
    <executions>
        <execution>
            <goals>
                <goal>sourcegraphDependencies</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Which allows you to invoke it by simply running `mvn sourcegraph:sourcegraphDependencies`.

Cross-repository navigation is a feature that allows "goto definition" and "find
references" to show results from multiple repositories.

## Step 5: Generate SCIP index from SCIP files

First, install the `scip-java` command-line tool according to the instructions
in the [getting started guide](getting-started.md).

Next, run the `scip-java aggregate` command to merge the per-file SCIP
files into a single SCIP index.

```sh
❯ scip-java aggregate $TARGETROOT
❯ file index.scip
index.scip: JSON data
```

