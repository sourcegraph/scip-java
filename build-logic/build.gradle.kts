import org.gradle.plugin.use.PluginDependency

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(plugin(libs.plugins.kotlin.jvm))
    implementation(plugin(libs.plugins.shadow))
    implementation(plugin(libs.plugins.vanniktech.maven.publish))
}

// Maps a version-catalog plugin alias to its plugin-marker dependency so the
// external plugin can be applied by id from the precompiled convention plugins.
fun plugin(dependency: Provider<PluginDependency>): Provider<String> =
    dependency.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }
