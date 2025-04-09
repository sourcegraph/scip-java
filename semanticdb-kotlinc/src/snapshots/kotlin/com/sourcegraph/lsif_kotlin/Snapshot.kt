package com.sourcegraph.lsif_kotlin

import com.sourcegraph.scip_java.ScipJava
import kotlin.io.path.Path

fun main() {
    val snapshotDir = Path(System.getProperty("snapshotDir"))
    val sourceroot = Path(System.getProperty("sourceroot"))
    val targetroot = Path(System.getProperty("targetroot"))

    ScipJava.main(arrayOf(
        "index-semanticdb",
        "--no-emit-inverse-relationships",
        "--cwd",
        sourceroot.toString(),
        "--output",
        targetroot.resolve("index.scip").toString(),
        targetroot.toString()
    ))
    ScipJava.main(arrayOf(
        "snapshot",
        "--cwd",
        sourceroot.toString(),
        "--output",
        snapshotDir.toString(),
        targetroot.toString()
    ))
}

