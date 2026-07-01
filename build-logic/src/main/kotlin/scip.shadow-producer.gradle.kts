import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("com.gradleup.shadow")
}

// Publish the shaded jar as a consumable artifact, resolved by consumers via
// `shadowJarArtifact` (see SharedArtifacts.kt).
val shadowJarElements = configurations.consumable("shadowJarElements").get()
artifacts.add(shadowJarElements.name, tasks.named<ShadowJar>("shadowJar"))
