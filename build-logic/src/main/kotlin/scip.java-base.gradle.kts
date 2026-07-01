import org.gradle.api.artifacts.VersionCatalogsExtension

plugins {
    id("scip.project-base")
    java
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(17)
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
    (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter(libs.findVersion("junit-jupiter").get().requiredVersion)
        }
    }
}

tasks.withType<Test>().configureEach {
    testLogging {
        events("failed", "skipped")
    }
}
