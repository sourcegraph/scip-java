package com.sourcegraph.lsif_java

import java.io.PrintStream

import moped.cli.Application
import moped.cli.CommandParser
import moped.commands.HelpCommand
import moped.commands.VersionCommand
import moped.reporters.Tput

object LsifJava {
  val app: Application = Application.fromName(
    binaryName = "lsif-java",
    BuildInfo.version,
    List(
      CommandParser[HelpCommand],
      CommandParser[VersionCommand],
      CommandParser[IndexCommand],
      CommandParser[IndexSemanticdbCommand],
      CommandParser[SnapshotCommand]
    )
  )
  def main(args: Array[String]): Unit = {
    app.runAndExitIfNonZero(args.toList)
  }

  def printHelp(out: PrintStream): Unit = {
    out.println("```text")
    out.println("$ lsif-java index --help")
    val newApp = app
      .withTput(Tput.constant(100))
      .withEnv(app.env.withStandardOutput(out))
    newApp.run(List("index", "--help"))
    out.println("```")
  }
}
