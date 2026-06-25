# AGENTS.md

Guidance for coding agents working in `scip-java`, a Java and Kotlin indexer that
produces [SCIP](https://github.com/scip-code/scip) index files.

## Setup

The recommended environment is provided via [Nix](https://nixos.org/download) and
the repo's `flake.nix`, which pins `gradle`, `maven`, `bazelisk`, `nodejs`,
`yarn`, `google-java-format`, `ktfmt`, and friends to the versions used in CI:

```sh
nix develop              # default shell (JDK 11)
nix develop .#jdk17      # JDK 17
nix develop .#jdk21      # JDK 21
```

Without Nix, you need at least `java`, `git`, `gradle`, and `mvn`. The build uses
Gradle (`build.gradle.kts`, `settings.gradle.kts`); dependency and plugin
versions live in `gradle/libs.versions.toml`.

## Build, test, and lint

Run from the repo root (commands match CI in `.github/workflows/nix.yaml`):

```sh
gradle test --no-daemon                          # run all Gradle tests
gradle :scip-java:test --no-daemon               # CLI build-tool integration tests
gradle :scip-kotlinc:test --no-daemon            # Kotlin compiler-plugin tests
gradle :scip-snapshots:test --no-daemon          # compare snapshot goldens
gradle :scip-snapshots:saveSnapshots --no-daemon # regenerate snapshot goldens
gradle :scip-java:installDist --no-daemon        # build local dist under scip-java/build/install/
gradle :scip-java:run --args='--cwd DIRECTORY'   # run scip-java against a build

nix flake check -L                               # checks formatting (run from any shell)
google-java-format --replace $(git ls-files '*.java')  # format Java (from nix develop)
ktfmt --kotlinlang-style $(git ls-files '*.kt')        # format Kotlin (from nix develop)
```

Formatting is enforced by `nix flake check`; run the formatters before
finishing. There is also a Bazel build (`MODULE.bazel`, `bazelisk build //...`).

## Conventions

- Tests use JUnit 5 via Gradle's JUnit Platform. The snapshot suite is a JUnit
  `@TestFactory` that emits one dynamic test per generated document, comparing
  against committed goldens under `scip-snapshots/expected`.
- Prefer running tests through Gradle rather than the IntelliJ UI.

## Where the code lives

- `scip-javac/src/main/java` — the Java compiler plugin that emits SCIP.
- `scip-kotlinc` — the Kotlin compiler plugin.
- `scip-java/src/main/kotlin` — the `scip-java` command-line interface.
- `scip-java/src/test` — build-tool integration tests and fixtures (Kotlin).
- `scip-shared`, `scip-aggregator`, `scip-maven-plugin`, `scip-gradle-plugin` —
  supporting modules (see `settings.gradle.kts` for the full layout).
- `scip-snapshots` — slow snapshot tests indexing a corpus of published libraries.
- `docs/`, `examples/` — documentation and example projects.

See `CONTRIBUTING.md` for more detail.
