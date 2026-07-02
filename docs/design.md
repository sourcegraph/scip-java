# Design

This project is implemented as a
[Java compiler plugin](https://docs.oracle.com/en/java/javase/11/docs/api/jdk.compiler/com/sun/source/util/Plugin.html)
that generates one partial
[SCIP](https://github.com/scip-code/scip) index (a "shard") for
every `*.java` source file. After compilation completes, the per-file SCIP
shards are merged into a single SCIP index.

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

### Why per-file SCIP shards?

[SCIP](https://github.com/scip-code/scip) is a Protobuf schema for information
about symbols and types in Java programs and other languages. There are several
benefits to emitting one SCIP shard per source file and merging them afterwards:

- **Simplicity**: It's easy to translate a single Java source file into a single
  SCIP shard inside a compiler plugin. It's more complicated to produce a
  complete project-wide index directly because compiler plugins do not have
  access to a project-wide context, which is necessary to produce accurate
  definitions and hovers in multi-module projects with external library
  dependencies.
- **Performance**: SCIP shards are fast to write and read. Each compilation unit
  can be processed independently to keep memory usage low. The final merge of
  the shards into a single index can be safely parallelized.
- **Cross-repository**: Compiler plugins have access to both source code and the
  classpath (compiled bytecode of upstream dependencies). SCIP has been
  designed so that it's also possible to generate spec-compliant symbols from
  the classpath alone (no source code) and from the syntax tree of an individual
  source file (no classpath). This flexibility will be helpful for scip-java in
  the future to unblock cross-repository navigation.
