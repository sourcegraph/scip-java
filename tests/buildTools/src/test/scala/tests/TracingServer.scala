package tests

import java.net.URI

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import com.sun.net.httpserver._

object TracingServer {
  case class SimpleHttpRequest(url: URI, simpleHeaders: Map[String, String])

  case class RunningServer(address: URI, shutdown: () => Unit)

  private def runImpl[A](handler: MyHandler)(f: RunningServer => A) = {
    val server = HttpServer.create(
      new java.net.InetSocketAddress("localhost", 0),
      0
    );
    val result =
      try {
        server.createContext("/", handler)
        server.setExecutor(null) // creates a default executor
        server.start()
        f(
          RunningServer(
            new URI(
              s"http://${server.getAddress().getHostName()}:${server
                  .getAddress()
                  .getPort()}"
            ),
            () => server.stop(0)
          )
        )
      } finally {
        server.stop(0)
      }

    handler.tracedRequests -> result
  }

  def run[A](f: RunningServer => A): (List[SimpleHttpRequest], A) = {
    runImpl(new MyHandler(auth = None))(f)
  }
  def runWithAuth[A](username: String, password: String)(
      f: RunningServer => A
  ): (List[SimpleHttpRequest], A) = {
    val authenticator =
      new BasicAuthenticator("") {
        override def checkCredentials(
            _username: String,
            _password: String
        ): Boolean = username == _username && _password == password
      }

    runImpl(new MyHandler(auth = Some(authenticator)))(f)
  }

  private class MyHandler(auth: Option[Authenticator] = None)
      extends HttpHandler {

    val storage: ListBuffer[SimpleHttpRequest] = ListBuffer.empty

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

      auth.foreach {
        _.authenticate(t) match {
          case f: Authenticator.Failure =>
            t.sendResponseHeaders(f.getResponseCode(), 0L)
          case r: Authenticator.Retry =>
            t.sendResponseHeaders(r.getResponseCode(), 0L)
          case r: Authenticator.Success =>
            t.sendResponseHeaders(404, 0L)
        }
      }

      t.close()
    }

    def tracedRequests = storage.result

  }
}
