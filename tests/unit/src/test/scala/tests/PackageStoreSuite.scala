package tests

import com.dimafeng.testcontainers.PostgreSQLContainer
import com.dimafeng.testcontainers.munit.TestContainerForAll
import com.sourcegraph.packagehub.Package
import com.sourcegraph.packagehub.PackageHub
import com.sourcegraph.packagehub.PostgresOptions
import com.sourcegraph.packagehub.PostgresPackageStore
import moped.testkit.MopedSuite

class PackageStoreSuite
    extends MopedSuite(PackageHub.app)
    with TestContainerForAll {
  val store =
    new Fixture[PostgresPackageStore]("store") {
      private var p: PostgresPackageStore = _
      def apply(): PostgresPackageStore = p
      override def beforeEach(context: BeforeEach): Unit = {
        withContainers { c =>
          val options = PostgresOptions(
            url = c.jdbcUrl,
            username = c.username,
            password = c.password
          )
          p = new PostgresPackageStore(options.toDataSource(app().reporter).get)
        }
      }
    }
  override def munitFixtures: Seq[Fixture[_]] =
    super.munitFixtures ++ List(store)
  val pkg1 = Package.parse("maven:com.sourcegraph:semanticdb-javac:0.4.0")
  val pkg2 = Package.parse("maven:com.sourcegraph:semanticdb-javac:0.4.1")
  val pkg3 = Package.parse("maven:com.sourcegraph:semanticdb-javac:0.4.2")
  val containerDef = PostgreSQLContainer.Def()

  test("packages") {
    assertEquals(store().allPackages(), Nil)
    store().addPackage(pkg1)
    assertEquals(store().allPackages(), List(pkg1))
    store().addPackage(pkg1)
    assertEquals(store().allPackages(), List(pkg1))
    store().addPackages(List(pkg2, pkg3))
    assertEquals(store().allPackages(), List(pkg1, pkg2, pkg3))
  }

  test("indexed_packages") {
    assertEquals(store().allIndexedPackages(), Nil)
    store().addIndexedPackage(pkg1)
    assertEquals(store().allIndexedPackages(), List(pkg1))
    assert(store().isIndexedPackage(pkg1))
    assert(!store().isIndexedPackage(pkg2))
    assert(!store().isIndexedPackage(pkg3))
    store().addIndexedPackage(pkg1)
    assertEquals(store().allIndexedPackages(), List(pkg1))
    store().addIndexedPackages(List(pkg2, pkg3))
    assertEquals(store().allIndexedPackages(), List(pkg1, pkg2, pkg3))
    assert(store().isIndexedPackage(pkg1))
    assert(store().isIndexedPackage(pkg2))
    assert(store().isIndexedPackage(pkg3))
  }
}
