package com.sourcegraph.scip_semanticdb

import java.util.concurrent.atomic.AtomicInteger

import moped.progressbars.ProgressRenderer
import moped.progressbars.ProgressStep
import org.typelevel.paiges.Doc

/**
 * Progress bar for the scip-semanticdb command.
 */
class ScipSemanticdbProgressRenderer() extends ProgressRenderer {
  var totalSize = 0
  val currentSize = new AtomicInteger()
  override def renderStep(): ProgressStep = {
    if (totalSize < 100)
      return ProgressStep.empty

    val current = currentSize.get()
    val ratio = current.toDouble / totalSize
    val progress: Int = (ratio * 10).toInt
    val percentage: String = s"${(ratio * 100).toInt}%".padTo(4, ' ')
    val bars = ("#" * progress).padTo(10, ' ')
    val render =
      f"Generating SCIP... [$bars] $percentage $current%,.0f files processed"
    ProgressStep(static = Doc.empty, dynamic = Doc.text(render))
  }
}
