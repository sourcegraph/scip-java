package com.sourcegraph.scip_java

import com.sourcegraph.scip_aggregator.ScipAggregatorReporter
import java.nio.file.NoSuchFileException
import java.util.concurrent.atomic.AtomicInteger

/**
 * Console reporter: `info` goes to stdout, `warning`/`error` to stderr.
 * Doubles as the [ScipAggregatorReporter] consumed by the aggregator.
 */
class CliReporter(private val env: CliEnvironment) : ScipAggregatorReporter() {
    private val errorCount = AtomicInteger()

    private var totalShards = 0
    private val processedShards = AtomicInteger()
    private val lastReportedDecile = AtomicInteger()

    fun info(message: String) {
        env.standardOutput.println(message)
    }

    override fun warning(message: String) {
        env.standardError.println("warning: $message")
    }

    override fun error(message: String) {
        errorCount.incrementAndGet()
        env.standardError.println("error: $message")
    }

    /** Dropped to avoid leaking noise into snapshot tests. */
    @Suppress("UNUSED_PARAMETER")
    fun debug(message: String) {}

    override fun error(e: Throwable) {
        if (e is NoSuchFileException) {
            error("no such file: ${e.message}")
            return
        }
        errorCount.incrementAndGet()
        e.printStackTrace(env.standardError)
    }

    override fun startProcessing(taskSize: Int) {
        totalShards = taskSize
        processedShards.set(0)
        lastReportedDecile.set(0)
        if (taskSize >= PROGRESS_THRESHOLD) {
            env.standardError.println("Aggregating $taskSize SCIP shards...")
        }
    }

    override fun processedOneItem() {
        val total = totalShards
        if (total < PROGRESS_THRESHOLD) return
        val current = processedShards.incrementAndGet()
        val decile = current * 10 / total
        val previous = lastReportedDecile.get()
        if (decile > previous && lastReportedDecile.compareAndSet(previous, decile)) {
            env.standardError.println(
                "Aggregated $current/$total SCIP shards (${current * 100 / total}%)"
            )
        }
    }

    override fun hasErrors(): Boolean = errorCount.get() > 0

    fun exitCode(): Int = if (hasErrors()) 1 else 0

    fun reset() {
        errorCount.set(0)
        totalShards = 0
        processedShards.set(0)
        lastReportedDecile.set(0)
    }

    private companion object {
        const val PROGRESS_THRESHOLD = 100
    }
}
