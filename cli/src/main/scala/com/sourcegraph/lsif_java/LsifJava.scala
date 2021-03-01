package com.sourcegraph.lsif_java

import moped.cli.Application
import moped.cli.CommandParser
import moped.commands.HelpCommand
import moped.commands.VersionCommand

object LsifJava {
  val app: Application = Application
    .fromName(
      binaryName = "lsif-java",
      BuildInfo.version,
      List(
        CommandParser[HelpCommand],
        CommandParser[VersionCommand],
        CommandParser[IndexCommand]
      )
    )
    .withIsSingleCommand(true)
  def main(args: Array[String]): Unit = {
    app.runAndExitIfNonZero(args.toList)
  }
}
