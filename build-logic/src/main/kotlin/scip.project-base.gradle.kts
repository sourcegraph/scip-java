group = "com.sourcegraph"
version = providers.gradleProperty("releaseVersion").orElse("0.0.0-SNAPSHOT").get()

// Several modules also have Bazel `BUILD` files. On the default macOS
// case-insensitive filesystem, Gradle's default `build/` directory collides
// with those files, so keep Gradle outputs under the already-ignored target/.
if (layout.projectDirectory.file("BUILD").asFile.isFile) {
    layout.buildDirectory.set(layout.projectDirectory.dir("target/gradle"))
}
