package com.sourcegraph.scip_aggregator

import com.sourcegraph.scip_java.CliReporter
import java.nio.file.NoSuchFileException

/**
 * Console reporter for the `aggregate` command.
 *
 * The old reporter rendered an `InteractiveProgressBar` via moped's
 * `paiges`-based renderer. Progress reporting is dropped here to keep the
 * CLI runtime free of Scala libraries; the renderer was always silent
 * when fewer than 100 files were processed anyway.
 */
class ConsoleScipAggregatorReporter(private val reporter: CliReporter) : ScipAggregatorReporter() {

    override fun error(e: Throwable) {
        if (e is NoSuchFileException) {
            reporter.error("no such file: ${e.message}")
        } else {
            reporter.error(e)
        }
    }

    override fun hasErrors(): Boolean = reporter.hasErrors()

    override fun startProcessing(taskSize: Int) {}

    override fun processedOneItem() {}

    override fun endProcessing() {}
}
