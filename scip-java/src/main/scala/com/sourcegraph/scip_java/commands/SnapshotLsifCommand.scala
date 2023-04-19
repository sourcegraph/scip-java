package com.sourcegraph.scip_java.commands

import java.nio.file.Path
import java.nio.file.Paths

import moped.annotations.CommandName
import moped.annotations.Inline
import moped.annotations.PositionalArguments
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser

@CommandName("snapshot-lsif")
case class SnapshotLsifCommand(
    @Inline() app: Application = Application.default,
    @PositionalArguments() input: List[Path] = List(Paths.get("dump.lsif"))
) extends Command {
  def run(): Int = {
    app.error(
      "this command is no longer supported. To run this command, downgrade to scip-java v0.8.14 and try again."
    )
    1
  }

}

object SnapshotLsifCommand {
  val default = SnapshotLsifCommand()
  implicit val parser = CommandParser.derive(default)
}
