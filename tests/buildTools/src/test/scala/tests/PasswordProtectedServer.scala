package tests

import java.net.URI

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import com.sun.net.httpserver._

case class PasswordProtectedServer(user: String, pwd: String) {
  import PasswordProtectedServer._
  private class MyHandler(storage: ListBuffer[SimpleHttpRequest])
      extends HttpHandler {
    val auth =
      new BasicAuthenticator("") {
        override def checkCredentials(
            username: String,
            password: String
        ): Boolean = username == user && password == pwd
      }
    override def handle(t: HttpExchange): Unit = {
      val headers = t
        .getRequestHeaders()
        .asScala
        .toMap
        .flatMap { case (k, v) =>
          v.asScala.headOption.map(k -> _)
        }

      val url = t.getRequestURI()
      storage.synchronized {
        storage.addOne(SimpleHttpRequest(url, headers))
      }

      auth.authenticate(t) match {
        case f: Authenticator.Failure =>
          t.sendResponseHeaders(f.getResponseCode(), 0L)
        case r: Authenticator.Retry =>
          t.sendResponseHeaders(r.getResponseCode(), 0L)
        case r: Authenticator.Success =>
          t.sendResponseHeaders(404, 0L)
      }

      t.close()
    }
  }
  def runWith[A](f: RunningServer => A): (List[SimpleHttpRequest], A) = {
    val storage = ListBuffer.empty[SimpleHttpRequest]
    val server = HttpServer
      .create(new java.net.InetSocketAddress("localhost", 0), 0);
    val result =
      try {
        server.createContext("/", new MyHandler(storage))
        server.setExecutor(null) // creates a default executor
        server.start()
        f(
          RunningServer(
            new URI(
              s"http://${server.getAddress().getHostName()}:${server.getAddress().getPort()}"
            ),
            () => server.stop(0)
          )
        )
      } finally {
        server.stop(0)
      }

    storage.toList -> result
  }
}

object PasswordProtectedServer {
  case class SimpleHttpRequest(url: URI, simpleHeaders: Map[String, String])

  case class RunningServer(address: URI, shutdown: () => Unit)
}
