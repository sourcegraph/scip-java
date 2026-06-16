package com.sourcegraph.scip_java.buildtools

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

data class ProcessResult(val exitCode: Int)

/**
 * Tiny `ProcessBuilder` wrapper that streams stdout/stderr line-by-line to
 * caller-provided sinks. Each stream is drained on its own thread so the
 * spawned process cannot deadlock on a full pipe.
 */
object ProcessRunner {
    fun run(
        command: List<String>,
        cwd: Path,
        env: Map<String, String> = emptyMap(),
        onStdout: (String) -> Unit = {},
        onStderr: (String) -> Unit = {},
    ): ProcessResult {
        val builder = ProcessBuilder(command).directory(cwd.toFile())
        if (env.isNotEmpty()) {
            val merged = builder.environment()
            for ((k, v) in env) {
                merged[k] = v
            }
        }
        val process = builder.start()
        val pool = Executors.newFixedThreadPool(2)
        try {
            val outFuture = pool.submit { drain(process.inputStream, onStdout) }
            val errFuture = pool.submit { drain(process.errorStream, onStderr) }
            val exit = process.waitFor()
            outFuture.get(30, TimeUnit.SECONDS)
            errFuture.get(30, TimeUnit.SECONDS)
            return ProcessResult(exit)
        } finally {
            pool.shutdown()
        }
    }

    private fun drain(input: java.io.InputStream, sink: (String) -> Unit) {
        BufferedReader(InputStreamReader(input, StandardCharsets.UTF_8)).useLines { lines ->
            for (line in lines) sink(line)
        }
    }
}
