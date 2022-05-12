---
id: design
title: Design
---

This project is implemented as a
[Java compiler plugin](https://docs.oracle.com/en/java/javase/11/docs/api/jdk.compiler/com/sun/source/util/Plugin.html)
that generates one
[SemanticDB](https://scalameta.org/docs/semanticdb/specification.html) file for
every `*.java` source file. After compilation completes, the SemanticDB files
are processed to produce SCIP.

![A three stage pipeline that starts with a list of Java sources, creates a list of SemanticDB files that then become a single SCIP index.](assets/semanticdb-javac-pipeline.svg)

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

### Why SemanticDB?

SemanticDB is Protobuf schema for information about symbols and types in Java
programs, Scala programs and other languages. There are several benefits to
using SemanticDB as an intermediary representation for SCIP:

- **Simplicity**: It's easy to translate a single Java source file into a single
  SemanticDB file inside a compiler plugin. It's more complicated to produce
  SCIP because compiler plugins does not have access to a project-wide context,
  which is necessary to produce accurate definitions and hovers in multi-module
  projects with external library dependencies.
- **Performance**: SemanticDB is fast to write and read. Each compilation unit
  can be processed independently to keep memory usage low. The final conversion
  from SemanticDB to SCIP can be safely parallelized.
- **Cross-language**: SemanticDB has a
  [spec](https://scalameta.org/docs/semanticdb/specification.html) for Java and
  Scala enabling cross-language navigation in hybrid Java/Scala codebases.
- **Cross-repository**: Compiler plugins have access to both source code and the
  classpath (compiled bytecode of upstream dependencies). SemanticDB has been
  designed so that it's also possible to generate spec-compliant symbols from
  the classpath alone (no source code) and from the syntax tree of an individual
  source file (no classpath). This flexibility allows the
  [Metals](https://scalameta.org/metals/) language server to index codebases
  from a variety of different inputs, and will be helpful for scip-java in the
  future to unblock cross-repository navigation.
