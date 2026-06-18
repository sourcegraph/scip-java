package tests

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class AutoBuildToolTest : BuildToolHarness() {

    @TestFactory
    fun tests(): List<DynamicTest> =
        listOf(
            checkErrorOutput(
                "no-tools-found",
                listOf("index", "--build-tool", "auto"),
                expectedOutput =
                    "error: Build tool mode set to `auto`, but no supported build tools " +
                        "were detected",
            ),
        )
}
