pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "scip-java"

include(
    "scip-shared",
    "scip-javac",
    "scip-kotlinc",
    "scip-aggregator",
    "scip-maven-plugin",
    "scip-gradle-plugin",
    "scip-java",
    "scip-snapshots",
    "scip-snapshots-java-common",
    "scip-snapshots-kotlin-common",
)

project(":scip-snapshots-java-common").projectDir = file("scip-snapshots/cases/java/common")
project(":scip-snapshots-kotlin-common").projectDir = file("scip-snapshots/cases/kotlin/common")
