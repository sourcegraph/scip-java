plugins {
    id("scip.java-library")
    id("scip.shadow-producer")
}

dependencies {
    compileOnly(libs.gradle.api)
    compileOnly(libs.gradle.test.kit)
}
