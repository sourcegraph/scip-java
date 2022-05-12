package com.sourcegraph.scip_semanticdb

import java.io.PrintWriter
import java.nio.file.NoSuchFileException

import moped.cli.Application
import moped.progressbars.InteractiveProgressBar

/**
 * Console reporter for index-semanticdb command.
 */
class ConsoleScipSemanticdbReporter(app: Application)
    extends ScipSemanticdbReporter {

  val renderer = new ScipSemanticdbProgressRenderer
  val progressbar =
    new InteractiveProgressBar(
      new PrintWriter(app.env.standardError),
      renderer,
      isDynamicPartEnabled = app.env.isProgressBarEnabled
    )
  override def error(e: Throwable): Unit = {
    e match {
      case _: NoSuchFileException =>
        app.reporter.error(s"no such file: ${e.getMessage}")
      case _ =>
        e.printStackTrace(app.err)
    }
  }

  override def hasErrors: Boolean = app.reporter.hasErrors()
  override def startProcessing(taskSize: Int): Unit = {
    renderer.totalSize = taskSize
    progressbar.start()
  }
  override def processedOneItem(): Unit = {
    renderer.currentSize.incrementAndGet()
  }
  override def endProcessing(): Unit = {
    progressbar.stop()
  }

}
