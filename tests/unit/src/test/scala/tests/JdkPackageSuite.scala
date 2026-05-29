package tests

import java.io.DataOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.jar.JarEntry
import java.util.jar.JarOutputStream

import com.sourcegraph.scip_semanticdb.JdkPackage
import munit.FunSuite
import munit.TestOptions

class JdkPackageSuite extends FunSuite {
  def checkVersion(original: TestOptions, expected: String): Unit = {
    test(original) {
      val obtained = JdkPackage.parse(original.name)
      assertNoDiff(obtained.version, expected)
    }
  }

  checkVersion("11.0.9", "11")
  checkVersion("17.0.5", "17")

  private def writeFakeClassfile(file: Path, major: Int): Path = {
    Files.createDirectories(file.getParent)
    val out = new DataOutputStream(Files.newOutputStream(file))
    try {
      out.writeInt(0xCAFEBABE)
      out.writeShort(0) // minor
      out.writeShort(major) // major
    } finally out.close()
    file
  }

  test("fromClassfile reads bytecode major version and maps major - 44") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      val classfile = writeFakeClassfile(tmp.resolve("Foo.class"), 55)
      val pkg = JdkPackage.fromClassfile(classfile)
      assert(pkg.isPresent, "expected a JdkPackage")
      assertNoDiff(pkg.get.version, "11")
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

  test("fromClassfile returns empty for non-classfile bytes") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      val bogus = tmp.resolve("Bogus.class")
      Files.write(bogus, "not a classfile".getBytes())
      assert(!JdkPackage.fromClassfile(bogus).isPresent)
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

  test("fromDirectory walks recursively for any classfile") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      writeFakeClassfile(tmp.resolve("a/b/c/Deep.class"), 61) // 61 - 44 = 17
      val pkg = JdkPackage.fromDirectory(tmp, 64)
      assert(pkg.isPresent)
      assertNoDiff(pkg.get.version, "17")
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

  test("fromDirectory returns empty when no classfiles exist") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      Files.write(tmp.resolve("README.md"), "not a classfile".getBytes())
      assert(!JdkPackage.fromDirectory(tmp, 64).isPresent)
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

  test("fromJar reads version from first regular classfile entry") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      val jar = tmp.resolve("test.jar")
      val out = new JarOutputStream(Files.newOutputStream(jar))
      try {
        // Multi-release entry under META-INF/versions should be skipped.
        out.putNextEntry(new JarEntry("META-INF/versions/17/com/Newer.class"))
        val mr = new DataOutputStream(out)
        mr.writeInt(0xCAFEBABE)
        mr.writeShort(0)
        mr.writeShort(61) // would map to 17
        out.closeEntry()

        out.putNextEntry(new JarEntry("com/Base.class"))
        val base = new DataOutputStream(out)
        base.writeInt(0xCAFEBABE)
        base.writeShort(0)
        base.writeShort(55) // maps to 11
        out.closeEntry()
      } finally out.close()
      val pkg = JdkPackage.fromJar(jar)
      assert(pkg.isPresent)
      assertNoDiff(pkg.get.version, "11")
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

  test("fromPath dispatches by file type") {
    val tmp = Files.createTempDirectory("jdk-package-test")
    try {
      writeFakeClassfile(tmp.resolve("Foo.class"), 52) // 52 - 44 = 8
      val direct = JdkPackage.fromPath(tmp.resolve("Foo.class"))
      assert(direct.isPresent)
      assertNoDiff(direct.get.version, "8")
      val viaDir = JdkPackage.fromPath(tmp)
      assert(viaDir.isPresent)
      assertNoDiff(viaDir.get.version, "8")
    } finally Files.walk(tmp).sorted(java.util.Comparator.reverseOrder()).forEach(Files.delete)
  }

}
