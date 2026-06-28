plugins {
    alias(libs.plugins.spotless)
}

tasks.register("saveSnapshots") {
    group = "verification"
    description = "Regenerates all SCIP snapshot goldens."
    dependsOn(":scip-snapshots:saveSnapshots")
}

spotless {
    java {
        target("scip-*/src/**/*.java")
        targetExclude("scip-java/src/test/resources/fixtures/**")
        googleJavaFormat("1.28.0")
    }

    kotlin {
        target("build-logic/src/**/*.kt", "scip-*/src/**/*.kt")
        targetExclude("scip-java/src/test/resources/fixtures/**")
        ktfmt("0.61").kotlinlangStyle()
    }
}

tasks.register("format") {
    group = "formatting"
    description = "Formats Java and Kotlin sources."
    dependsOn("spotlessApply")
}
