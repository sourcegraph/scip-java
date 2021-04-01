package com.sourcegraph.packagehub

import javax.sql.DataSource

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import moped.reporters.Reporter

final case class PostgresOptions(
    url: String = "",
    username: String = "",
    password: String = ""
) {
  def toDataSource(reporter: Reporter): Option[DataSource] = {
    if (url.isEmpty() || username.isEmpty() || password.isEmpty()) {
      if (url.nonEmpty) {
        reporter.warning(
          "ignoring unused PostgresSQL URL. To fix this problem, ensure the username, password and URL are all configured."
        )
      }
      if (username.nonEmpty) {
        reporter.warning(
          "ignoring unused PostgresSQL username. To fix this problem, ensure the username, password and URL are all configured."
        )
      }
      if (password.nonEmpty) {
        reporter.warning(
          "ignoring unused PostgresSQL password. To fix this problem, ensure the username, password and URL are all configured."
        )
      }
      None
    } else {
      Class.forName("org.postgresql.Driver")
      val config = new HikariConfig()
      config.setUsername(username)
      config.setPassword(password)
      config.setJdbcUrl(url)
      config.setMaximumPoolSize(5)
      config.setMinimumIdle(5)
      config.setConnectionTimeout(10000) // 10 seconds
      config.setIdleTimeout(600000) // 10 minutes
      config.setMaxLifetime(1800000) // 30 minutes
      Some(new HikariDataSource(config))
    }
  }
}

object PostgresOptions {
  implicit val codec = moped.macros.deriveCodec(PostgresOptions())
}
