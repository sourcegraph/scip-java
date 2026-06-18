package tests

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class MavenBuildToolTest : BuildToolHarness() {

    @TestFactory
    fun tests(): List<DynamicTest> =
        listOf(
            checkBuild(
                "basic",
                fixture = "maven/basic",
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
                fixture = "maven/basic",
                expectedScipFiles = 1,
                extraArguments = listOf("--", "compile"),
            ),
        )
}
