plugins {
    id("scip.java-library")
    id("scip.maven-publish")
}

description = "A Maven plugin that exports dependency metadata for scip-java"

dependencies {
    implementation(libs.maven.plugin.api)
    implementation(libs.maven.project)
    compileOnly(libs.maven.plugin.annotations)
}

tasks.named<ProcessResources>("processResources") {
    exclude("META-INF/maven/plugin.template.xml")
    from("src/main/resources/META-INF/maven/plugin.template.xml") {
        into("META-INF/maven")
        rename { "plugin.xml" }
        filter { line: String -> line.replace("@VERSION@", project.version.toString()) }
    }
    inputs.property("version", project.version.toString())
}
