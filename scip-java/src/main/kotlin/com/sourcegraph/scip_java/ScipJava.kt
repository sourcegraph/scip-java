package com.sourcegraph.scip_java

import java.io.PrintStream

/**
 * Public entry point for the scip-java CLI. The single [app] instance is shared across test suites
 * and reset between invocations.
 */
object ScipJava {

    @JvmField val app: ScipJavaApp = ScipJavaApp()

    @JvmStatic
    fun main(args: Array<String>) {
        app.runAndExitIfNonZero(args.toList())
    }

    fun printHelp(out: PrintStream) {
        out.println("```text")
        out.println("$ scip-java index --help")
        val replacement =
            ScipJavaApp().apply { env = env.withStandardOutput(out).withStandardError(out) }
        replacement.run(listOf("index", "--help"))
        out.println("```")
    }
}
