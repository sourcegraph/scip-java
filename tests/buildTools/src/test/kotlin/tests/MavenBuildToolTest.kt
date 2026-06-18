package tests

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class MavenBuildToolTest : BuildToolHarness() {

    private val pomXml: String =
        MavenBuildToolTest::class
            .java
            .getResourceAsStream("/example-maven-pom.xml")!!
            .readBytes()
            .toString(Charsets.UTF_8)

    @TestFactory
    fun tests(): List<DynamicTest> =
        listOf(
            checkBuild(
                "basic",
                """
                |/pom.xml
                |$pomXml
                |/src/main/java/com/Example.java
                |package com;
                |public class Example {}
                |/src/test/java/com/ExampleSuite.java
                |package com;
                |public class ExampleSuite {}
                |""".trimMargin(),
                expectedScipFiles = 2,
                expectedPackages =
                    """
                    |maven:com.sourcegraph:example:1.0-SNAPSHOT
                    |maven:junit:junit:4.11
                    |maven:org.hamcrest:hamcrest-core:1.3
                    |""".trimMargin(),
            ),
            checkBuild(
                "build-command",
                """
                |/pom.xml
                |$pomXml
                |/src/main/java/com/Example.java
                |package com;
                |public class Example {}
                |/src/test/java/com/ExampleSuite.java
                |package com;
                |public class ExampleSuite {}
                |""".trimMargin(),
                expectedScipFiles = 1,
                extraArguments = listOf("--", "compile"),
            ),
        )
}
