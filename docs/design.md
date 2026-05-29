---
id: design
title: Design
---

This project is implemented as a
[Java compiler plugin](https://docs.oracle.com/en/java/javase/11/docs/api/jdk.compiler/com/sun/source/util/Plugin.html)
that emits one [SCIP](https://github.com/sourcegraph/scip) shard file for every
`*.java` source file. After compilation completes, the per-file SCIP shards are
aggregated into a single SCIP index.

### Why Java compiler plugin?

There are several benefits to implementing scip-java as a compiler plugin:

- **Simple installation**: compiler plugins are enabled with the `-Xplugin`
  compiler option. All Java build tools support a way to customize compiler
  options, simplifying installation.
- **Language fidelity**: by using the Java compiler to produce semantic
  information, we ensure that the produced SCIP data is accurate even as new
  Java language versions with new language features are released.
- **Environment fidelity**: by hooking into the compilation process of the build
  tool, we minimize the risk of diverging from the CI build environment such as
  installed system dependencies, custom compiler options and custom annotation
  processors.
