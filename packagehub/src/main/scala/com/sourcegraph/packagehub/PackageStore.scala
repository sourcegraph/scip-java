package com.sourcegraph.packagehub

import java.sql.PreparedStatement
import java.util.Collections
import java.util.concurrent.ConcurrentHashMap
import java.{util => ju}
import javax.sql.DataSource

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.util.Using

import org.flywaydb.core.Flyway

/**
 * Data storage for what packages to host.
 */
trait PackageStore {
  def addPackages(pkg: List[Package]): Unit
  final def addPackage(pkg: Package): Unit = addPackages(List(pkg))
  def allPackages(): List[Package]

  def addIndexedPackages(pkg: List[Package]): Unit
  final def addIndexedPackage(pkg: Package): Unit =
    addIndexedPackages(List(pkg))
  def isIndexedPackage(pkg: Package): Boolean
  def allIndexedPackages(): List[Package]
}

class InMemoryPackageStore extends PackageStore {
  private def concurrentHashSet[T]: ju.Set[T] =
    Collections.newSetFromMap(new ConcurrentHashMap[T, java.lang.Boolean])
  val packages = new ConcurrentHashMap[String, Package]
  val jdks = concurrentHashSet[String]
  val indexedPackages = concurrentHashSet[String]

  override def addPackages(pkgs: List[Package]): Unit = {
    pkgs.foreach { pkg =>
      packages.put(pkg.id, pkg)
    }
  }
  override def allPackages(): List[Package] = packages.values.asScala.toList
  override def addIndexedPackages(pkgs: List[Package]): Unit = {
    pkgs.foreach { pkg =>
      indexedPackages.add(pkg.id)
    }
  }
  override def isIndexedPackage(pkg: Package): Boolean = {
    indexedPackages.contains(pkg.id)
  }
  override def allIndexedPackages(): List[Package] =
    indexedPackages.asScala.map(Package.parse).toList

}

class PostgresPackageStore(source: DataSource) extends PackageStore {
  Flyway.configure().dataSource(source).load().migrate()

  override def addPackages(pkgs: List[Package]): Unit = {
    add("packages", pkgs)
  }
  override def allPackages(): List[Package] = {
    all("packages")
  }
  override def addIndexedPackages(pkgs: List[Package]): Unit = {
    add("indexed_packages", pkgs)
  }
  override def isIndexedPackage(pkg: Package): Boolean = {
    withStatement("select id from indexed_packages where id = ?") { stat =>
      stat.setString(1, pkg.id)
      stat.executeQuery().next()
    }
  }
  override def allIndexedPackages(): List[Package] = {
    all("indexed_packages")
  }

  private def withStatement[T](query: String)(fn: PreparedStatement => T): T = {
    Using
      .Manager { use =>
        val conn = use(source.getConnection())
        val stat = use(conn.prepareStatement(query))
        fn(stat)
      }
      .get
  }

  private def add(table: String, pkgs: List[Package]): Unit = {
    withStatement(
      s"INSERT into $table (id) VALUES (?) ON CONFLICT DO NOTHING"
    ) { stat =>
      pkgs.foreach { pkg =>
        stat.setString(1, pkg.id)
        stat.addBatch()
      }
      stat.executeBatch()
    }
  }

  private def all(table: String): List[Package] = {
    withStatement(s"SELECT id FROM $table") { stat =>
      val rs = stat.executeQuery()
      val buf = ListBuffer.empty[Package]
      while (rs.next()) {
        buf += Package.parse(rs.getString("id"))
      }
      buf.toList
    }
  }
}
