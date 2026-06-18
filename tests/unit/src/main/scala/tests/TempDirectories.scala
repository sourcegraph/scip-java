package tests

import java.nio.file.Files
import java.nio.file.Path

import munit.FunSuite

trait TempDirectories {
  self: FunSuite =>

  class DirectoryFixture extends Fixture[Path]("DirectoryFixture") {
    private var path: Path = _
    override def apply(): Path = path

    override def beforeEach(context: BeforeEach): Unit = {
      path = Files.createTempDirectory("scip-javac")
    }

    override def afterEach(context: AfterEach): Unit = {
      os.remove.all(os.Path(path))
    }
  }

}
