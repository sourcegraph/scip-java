# Follow-ups

## Derive JDK version in stdlib symbols from the bytecode target, not the runtime

### Current state

`JdkPackage.forRuntime()` embeds `Runtime.version().feature()` into every SCIP
symbol that references a JRT classfile, e.g.:

```
semanticdb maven jdk 11 java/lang/String#
```

This means the JDK version baked into the symbol is whichever JVM happens to
run the indexer — not a property of the project being indexed. As a workaround
for cross-JDK snapshot stability we expose a `scip.jdk.version` system property
(see `JdkPackage.forRuntime()`) that overrides the runtime value.

### Why this is the wrong source of truth

A repo whose bytecode targets Java 11 will produce different SCIP symbols
depending on whether CI happens to run scip-java on JDK 11, 17, or 21. That
silently breaks cross-repo navigation against the standard library.

scip-go does something analogous (it embeds the Go version into stdlib
symbols, e.g. `scip-go gomod github.com/golang/go/src go1.22 fmt/Println().`)
but takes the version from the project's `go.mod` `go` directive, **not** from
the Go toolchain that runs the indexer. That's the principled design: the
embedded version is a property of the project, so two repos that declare the
same version interop regardless of where they were indexed.

### Proposed direction

Source the JDK version from the project's bytecode target rather than the
running JVM:

- Maven: `maven.compiler.release` / `maven.compiler.target`
- Gradle: the toolchain `languageVersion` for the compile task
- Bazel: the `java_toolchain` `--source`/`--target` or the classfile major
  version embedded in produced `.class` files
- Fallback: read the major version directly from one of the produced
  classfiles in the targetroot (bytes 6-7 of any `.class` file, mapped via
  `major - 44`).

Plumb the resulting value into `ScipSemanticdbOptions` (e.g. a
`JdkPackage jdkPackage` field), use it in `PackageTable` in place of the
current `JdkPackage.forRuntime()` call, and expose it on
`IndexSemanticdbCommand` as `--jdk-version=<N>` for callers that want to set
it explicitly.

### Expected outcome

- Two repos that compile against Java 11 always emit
  `semanticdb maven jdk 11 java/lang/String#`, regardless of which JDK runs
  scip-java in CI.
- The `scip.jdk.version` system-property escape hatch and the snapshot test's
  reliance on it can both be removed.
- Cross-repo "jump to definition" against the standard library becomes
  stable across CI upgrades.

### Open questions

- What should the default be when no bytecode target can be inferred? Probably
  `Runtime.version().feature()` (current behavior), to avoid regressions.
- Should the version be per-document (a single targetroot can in principle
  mix targets) or per-index? Per-index matches the current model and is
  almost always correct in practice.
