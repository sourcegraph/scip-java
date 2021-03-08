package tests

import java.nio.file.Files
import java.nio.file.Path

import com.sourcegraph.io.DeleteVisitor
import munit.FunSuite

trait TempDirectories {
  self: FunSuite =>

  class DirectoryFixture extends Fixture[Path]("DirectoryFixture") {
    private var path: Path = _
    override def apply(): Path = path

    override def beforeEach(context: BeforeEach): Unit = {
      path = Files.createTempDirectory("semanticdb-javac")
    }

    override def afterEach(context: AfterEach): Unit = {
      Files.walkFileTree(path, new DeleteVisitor())
    }
  }

}
