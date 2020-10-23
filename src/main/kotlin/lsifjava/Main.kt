package lsifjava

import java.io.File
import java.io.PrintWriter

fun main(args: Array<String>) {
    println("Running JVM ${System.getProperty("java.version")}")

    val arguments = parse(args)
    val writer = createWriter(arguments)
    val emitter = Emitter(writer)
    val indexer = ProjectIndexer(arguments, emitter)
    
    val start = System.nanoTime()
    
    try {
        indexer.index()
    } finally {
        writer.flush()
        writer.close()
    }

    displayStats(indexer, emitter, start)
}

private fun createWriter(args: Arguments): PrintWriter {
    return PrintWriter(File(args.outFile))
}

private fun displayStats(indexer: ProjectIndexer, emitter: Emitter, start: Long) {
    System.out.printf(
        "%d file(s), %d def(s), %d element(s)\n",
        indexer.numFiles,
        indexer.numDefinitions,
        emitter.numElements()
    )
    System.out.printf("Processed in %.0fms", (System.nanoTime() - start) / 1e6)
}