package com.sourcegraph.scip_java

import java.io.PrintStream

import com.sourcegraph.scip_java.commands.IndexCommand
import com.sourcegraph.scip_java.commands.IndexDependencyCommand
import com.sourcegraph.scip_java.commands.IndexSemanticdbCommand
import com.sourcegraph.scip_java.commands.SnapshotCommand
import com.sourcegraph.scip_java.commands.SnapshotLsifCommand
import moped.cli.Application
import moped.cli.CommandParser
import moped.commands.HelpCommand
import moped.commands.VersionCommand
import moped.reporters.Tput

object ScipJava {
  val app: Application = Application.fromName(
    binaryName = "scip-java",
    BuildInfo.version,
    List(
      CommandParser[HelpCommand],
      CommandParser[VersionCommand],
      CommandParser[IndexCommand],
      CommandParser[IndexSemanticdbCommand],
      CommandParser[IndexDependencyCommand],
      CommandParser[SnapshotCommand],
      CommandParser[SnapshotLsifCommand]
    )
  )
  def main(args: Array[String]): Unit = {
    app.runAndExitIfNonZero(args.toList)
  }

  def printHelp(out: PrintStream): Unit = {
    out.println("```text")
    out.println("$ scip-java index --help")
    val newApp = app
      .withTput(Tput.constant(100))
      .withEnv(app.env.withStandardOutput(out))
    newApp.run(List("index", "--help"))
    out.println("```")
  }
}
