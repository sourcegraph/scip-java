package com.sourcegraph.packagehub

import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.nio.file.Files

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.NoStackTrace

import cask.Response.Data
import cask.model.Request
import cask.model.Response
import cask.model.StaticFile
import cask.model.Status
import cask.util.Logger
import castor.Context
import os.Internals
import os.Shellable
import os.SubProcess
import ujson.Arr
import ujson.Obj
import ujson.Value

/**
 * The HTTP routes that are served by PackageHub.
 */
class PackageRoutes(
    server: PackageHub,
    actor: PackageActor,
    store: PackageStore,
    override implicit val log: Logger
)(implicit ctx: Context)
    extends cask.MainRoutes {
  override def host: String = server.host
  override def port: Int = server.port.toInt
  override def verbose: Boolean = server.verbose

  // ===========================================================
  // The following endpoints are required by src-cli "serve-git"
  // ===========================================================

  @cask.get("/v1/list-repos")
  def listRepos(): ujson.Value = {
    val items = Arr.from(store.allPackages().map(_.toJsonRepo))
    Obj("Items" -> items)
  }

  @cask.route("/repos", methods = Seq("get", "post"), subpath = true)
  def repoSubpath(
      request: cask.Request,
      service: Seq[String] = Nil
  ): cask.Response[Data] = {
    Package.fromPath(request.remainingPathSegments.toList) match {
      case Some((pkg, requestPath)) =>
        repoSubpath(request, pkg, requestPath)
      case _ =>
        badRequest(
          "invalid repo name (want /repos/maven/ORGANIZATION/NAME/VERSION/...)"
        )
    }
  }

  // =====================================================================
  // The following endpoints are not required by src-cli "serve-git". They
  // monstly exist for debugging purposes and to manually trigger stuff.
  // =====================================================================

  @cask.get("/packagehub/packages")
  def packages(): ujson.Value = Arr.from(store.allPackages().map(_.id))

  @cask.postJson("/packagehub/packages")
  def addPackage(packages: Seq[String]): cask.Response[Value] = {
    val parsed = packages.toList.map(parsePackage)
    val ok = parsed.collect { case Right(value) =>
      value
    }
    store.addPackages(ok)
    val errors = parsed.collect { case Left(value) =>
      value
    }
    cask.Response(Obj("errors" -> Arr.from(errors)))
  }

  @cask.post("/packagehub/package/:pkg")
  def addPackage(pkg: String): cask.Response[Value] = {
    withPackage(pkg) { p =>
      store.addPackage(p)
    }
  }

  @cask.get("/packagehub/indexed-packages")
  def indexedPackages(): ujson.Value =
    Arr.from(store.allIndexedPackages().map(_.id))

  @cask.post("/packagehub/index-package/:pkg")
  def indexPackage(
      pkg: String,
      upload: Boolean = false
  ): cask.Response[Data] = {
    parsePackage(pkg) match {
      case Left(error) =>
        badRequest(error)
      case Right(pkg) =>
        store.addPackage(pkg)
        if (!store.isIndexedPackage(pkg)) {
          val dump = actor.lsifIndex(pkg, lsifUpload = upload)
          val size = Files.size(dump)
          val verb =
            if (upload)
              "uploaded"
            else
              "generated"
          okResponse(s"$verb index for package '${pkg.id}'")
        } else {
          okResponse(s"package '${pkg.id}' is already indexed")
        }
    }
  }

  @cask.post("/packagehub/indexed-package/:pkg")
  def addIndexedPackage(pkg: String): cask.Response[Value] = {
    withPackage(pkg) { p =>
      store.addIndexedPackage(p)
    }
  }

  private def repoSubpath(
      request: cask.Request,
      pkg: Package,
      requestPath: List[String]
  ): cask.Response[Data] = {
    val path = actor.packageDir(pkg)
    actor.commitSources(pkg)
    val args = ListBuffer[String](
      "git",
      // Partial clones/fetches
      "-c",
      "uploadpack.allowFilter=true",
      // Can fetch any object. Used in case of race between a resolve ref and a
      // fetch of a commit. Safe to do, since this is only used internally.
      "-c",
      "uploadpack.allowAnySHA1InWant=true",
      "upload-pack",
      "--stateless-rpc"
    )
    val headers = mutable.Map.empty[String, String]
    val bytes = new ByteArrayOutputStream
    val isStaticFile: Boolean =
      if (requestPath.endsWith(List("info", "refs"))) {
        server
          .autoIndexDelay
          .foreach { delay =>
            ctx.scheduleMsg(actor, pkg, delay)
          }
        headers("Content-Type") = "application/x-git-upload-pack-advertisement"
        bytes.write(packetWrite("# service=git-upload-pack\n"))
        bytes.write("0000".getBytes())
        args += "--advertise-refs"
        false
      } else if (requestPath.endsWith(List("git-upload-pack"))) {
        headers("Content-Type") = "application/x-git-upload-pack-result"
        false
      } else {
        true
      }
    if (isStaticFile) {
      val file = path.resolve(requestPath.mkString("/"))
      if (Files.isRegularFile(file)) {
        val text = new String(Files.readAllBytes(file))
        StaticFile(file.toString(), Nil)
      } else if (Files.isDirectory(file)) {
        val ls = file.toFile().list().map(f => s"<li>$f</li>")
        ls.mkString("<ul>\n . ", "\n ", "</ul>")
      } else {
        notFound(s"no such file: $file")
      }
    } else {
      val env = mutable.Map.empty[String, String]
      Option(request.exchange.getRequestHeaders().getLast("Git-Protocol"))
        .foreach { protocol =>
          env("GIT_PROTOCOL") = protocol
        }
      args += path.toString()
      val result = os
        .proc(Shellable(args.toSeq))
        .spawn(
          env = env.toMap,
          stdout = os.Pipe,
          stderr = os.Pipe,
          stdin = request.bytes
        )
      Response(new ProcessData(result, request), 200, headers.toSeq)
    }
  }

  private class ProcessData(proc: SubProcess, request: Request) extends Data {
    def write(out: OutputStream): Unit = {
      Internals.transfer(proc.stdout, out)
      proc.waitFor()
      val exit = proc.exitCode()
      if (exit != 0) {
        val path = Obj(
          "exit" -> exit,
          "path" -> request.exchange.getRequestPath(),
          "method" -> request.exchange.getRequestMethod().toString()
        )
        throw new RuntimeException(ujson.write(path)) with NoStackTrace
      }
    }
    def headers: Seq[(String, String)] = Nil
  }

  private def packetWrite(str: String): Array[Byte] = {
    var s = Integer.toString(str.length() + 4, 16)
    val modulo = s.length() % 4
    if (modulo != 0) {
      val padding = "0" * (4 - modulo)
      s = padding + s
    }
    (s + str).getBytes()
  }

  private def parsePackage(pkg: String) =
    Package.fromString(pkg, server.coursier)

  private def withPackage(
      pkg: String
  )(fn: Package => Unit): cask.Response[Value] = {
    parsePackage(pkg) match {
      case Left(error) =>
        badRequest(error)
      case Right(p) =>
        fn(p)
        cask.Response(Obj())
    }
  }

  private def badRequest(error: Value): Response[Value] =
    errorResponse(error, Status.BadRequest.code)
  private def notFound(error: Value): Response[Value] =
    errorResponse(error, Status.NotFound.code)
  private def okResponse(result: String*): Response[Value] =
    Response(Obj("message" -> Arr.from(result)))
  private def errorResponse(error: Value, code: Int): Response[Value] =
    Response(Obj("error" -> error), code, Nil, Nil)

  initialize()
}
