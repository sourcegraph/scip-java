package com.sourcegraph.packagehub

import java.nio.file.Path
import java.time
import java.time.Duration

import scala.concurrent.Await
import scala.concurrent.Promise
import scala.concurrent.duration

import cask.main.Main
import cask.util.Logger
import castor.Context
import com.sourcegraph.lsif_java.BuildInfo
import io.undertow.Undertow
import moped.annotations.Description
import moped.annotations.ExampleValue
import moped.annotations.Hidden
import moped.cli.Application
import moped.cli.Command
import moped.cli.CommandParser
import moped.commands.HelpCommand
import moped.commands.VersionCommand
import moped.json.DecodingContext
import moped.json.JsonString
import moped.json.Result

/**
 * Entrypoint to start the PackageHub server.
 */
case class PackageHub(
    port: String = "8080",
    host: String = "localhost",
    verbose: Boolean = false,
    dir: Option[Path] = None,
    app: Application = Application.default,
    @Hidden() cancelToken: Promise[Unit] = Promise(),
    ctx: Context = castor.Context.Simple.global,
    postgres: PostgresOptions = PostgresOptions(),
    @Description("URL of the PackageHub server") packagehubUrl: String =
      "https://packagehub-ohcltxh6aq-uc.a.run.app",
    @Description("Path to the src-cli binary") src: String = "src",
    @Description("Path to the coursier binary") coursier: String = "coursier",
    @Description("If enabled, schedule an LSIF index after the given delay")
    @ExampleValue("--auto-index-delay=PT1M") autoIndexDelay: Option[Duration] =
      None
) extends Command {
  val log = new Logger.Console()
  def run(): Int = {
    val store: PackageStore =
      postgres.toDataSource(app.reporter) match {
        case Some(source) =>
          app.info("Connected to PostgreSQL database")
          new PostgresPackageStore(source)
        case None =>
          new InMemoryPackageStore
      }
    if (!verbose)
      Main.silenceJboss()
    val actor =
      new PackageActor(
        src,
        coursier,
        store,
        packagehubUrl,
        dir.getOrElse(app.env.cacheDirectory)
      )(ctx, log)
    val routes = new PackageRoutes(this, actor, store, log)(ctx)
    val server = Undertow
      .builder
      .addHttpListener(routes.port, host)
      .setHandler(routes.defaultHandler)
      .build()
    server.start()
    app.info(s"Listening on http://$host:$port")
    try Await.result(cancelToken.future, duration.Duration.Inf)
    finally server.stop()
    0
  }

  def isEnv(name: String): Boolean = app.env.environmentVariables.contains(name)

}

object PackageHub {
  implicit val promiseCodec = new EmptyJsonCodec[Promise[Unit]]
  implicit val contextCodec = new EmptyJsonCodec[Context]
  implicit val durationCodec =
    new EmptyJsonCodec[Duration] {
      override def decode(context: DecodingContext): Result[Duration] =
        context.json match {
          case JsonString(value) =>
            Result.fromUnsafe(() => Duration.parse(value))
          case _ =>
            super.decode(context)
        }
    }
  implicit val parser = CommandParser.derive(PackageHub())
  val app = Application
    .fromName(
      "packagehub",
      BuildInfo.version,
      commands = List(
        CommandParser[HelpCommand],
        CommandParser[VersionCommand],
        CommandParser[PackageHub]
      )
    )
    .withIsSingleCommand(true)
  def main(args: Array[String]): Unit = {
    app.runAndExitIfNonZero(args.toList)
  }
}
