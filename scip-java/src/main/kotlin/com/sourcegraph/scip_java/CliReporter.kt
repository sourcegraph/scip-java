package com.sourcegraph.scip_java

import java.util.concurrent.atomic.AtomicInteger

/**
 * Minimal reporter that mirrors the moped `ConsoleReporter` API surface that
 * scip-java actually uses (info/warning/error/debug/hasErrors/exitCode).
 *
 * `info` is written to stdout to match the previous behaviour of the
 * default moped reporter; `warning` and `error` go to stderr.
 */
class CliReporter(private val env: CliEnvironment) {
    private val errorCount = AtomicInteger()

    fun info(message: String) {
        env.standardOutput.println(message)
    }

    fun warning(message: String) {
        env.standardError.println("warning: $message")
    }

    fun error(message: String) {
        errorCount.incrementAndGet()
        env.standardError.println("error: $message")
    }

    /**
     * Debug messages are dropped to avoid leaking noise into snapshot tests.
     */
    @Suppress("UNUSED_PARAMETER")
    fun debug(message: String) {
        // intentional no-op
    }

    fun error(e: Throwable) {
        errorCount.incrementAndGet()
        e.printStackTrace(env.standardError)
    }

    fun hasErrors(): Boolean = errorCount.get() > 0

    fun exitCode(): Int = if (hasErrors()) 1 else 0

    fun reset() {
        errorCount.set(0)
    }
}
