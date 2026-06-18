package tests

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class MissingBuildToolTest : BuildToolHarness() {

    @TestFactory
    fun tests(): List<DynamicTest> =
        listOf(
            checkErrorOutput(
                "basic",
                listOf("index"),
                expectedOutput =
                    "error: No build tool detected in workspace '/workingDirectory'. " +
                        "At the moment, the only supported build tools are: Maven, Gradle.",
            ),
            checkErrorOutput(
                "ambiguous",
                listOf("index"),
                expectedOutput =
                    "error: Multiple build tools detected: Maven, Gradle. To fix this " +
                        "problem, use the '--build-tool=BUILD_TOOL_NAME' flag to specify " +
                        "which build tool to run.",
                fixture = "missing/ambiguous",
            ),
            checkErrorOutput(
                "no-matching-explicit",
                listOf("index", "--build-tool", "Gradle"),
                expectedOutput =
                    "error: Automatically detected the build tool(s) Maven but none of " +
                        "them match the explicitly provided flag '--build-tool=Gradle'. To " +
                        "fix this problem, run again with the --build-tool flag set to one " +
                        "of the detected build tools.",
                fixture = "missing/no-matching-explicit",
            ),
        )
}
