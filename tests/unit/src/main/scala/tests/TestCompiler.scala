package tests

import java.io.StringWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import javax.tools.ToolProvider
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._
import scala.meta.Input
import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath
import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sun.tools.javac.api.BasicJavacTask
import com.sun.tools.javac.util.Context
import com.sun.tools.javadoc.JavadocClassReader

object TestCompiler {
  val PROCESSOR_PATH = System.getProperty("java.class.path")
}

class TestCompiler(
    val classpath: String,
    val options: List[String],
    val targetroot: Path,
    val sourceroot: Path = Files.createTempDirectory("semanticdb-javac")
) {

  private val compiler = ToolProvider.getSystemJavaCompiler
  private val fileManager =
    new SimpleFileManager(
      compiler.getStandardFileManager(null, null, null),
      targetroot
    )

  def this(targetroot: Path) {
    this(TestCompiler.PROCESSOR_PATH, Nil, targetroot)
  }

  def compileSemanticdbDirectory(dir: Path): CompileResult = {
    compileSemanticdb(inputsFromDirectory(dir))
  }

  def compileSemanticdb(inputs: Seq[Input.VirtualFile]): CompileResult = {
    compile(
      inputs,
      List(
        String.format(
          "-Xplugin:semanticdb -verbose -text:on -sourceroot:%s -targetroot:%s",
          sourceroot,
          targetroot
        )
      )
    )
  }

  def compile(
      inputs: Seq[Input.VirtualFile],
      extraArguments: Seq[String] = Nil
  ): CompileResult = {
    val output = new StringWriter
    val compilationUnits = inputs.map { input =>
      val source = sourceroot.resolve(input.path)
      new SimpleSourceFile(source, input.text)
    }
    val arguments = ListBuffer.empty[String]
    arguments += "-processorpath"
    arguments += TestCompiler.PROCESSOR_PATH
    arguments += "-classpath"
    arguments += classpath
    arguments ++= extraArguments
    arguments ++= options
    val task = compiler.getTask(
      output,
      fileManager,
      null,
      arguments.asJava,
      null,
      compilationUnits.asJava
    )
    val ctx = task.asInstanceOf[BasicJavacTask].getContext
    val isSuccess = task.call()
    var bytecode = new Array[Byte](0)
    if (!fileManager.compiled.isEmpty)
      bytecode = fileManager.compiled.iterator.next.getCompiledBinaries
    val textDocuments = Semanticdb.TextDocuments.newBuilder
    inputs.map { input =>
      val outputPath = targetroot
        .resolve("META-INF")
        .resolve("semanticdb")
        .resolve(input.path + ".semanticdb")
      if (Files.isRegularFile(outputPath)) {
        textDocuments.addAllDocuments(
          Semanticdb
            .TextDocuments
            .parseFrom(Files.readAllBytes(outputPath))
            .getDocumentsList
        )
      }
    }
    val stdout = output.toString
    CompileResult(bytecode, stdout, textDocuments.build(), isSuccess)
  }

  private def inputsFromDirectory(dir: Path): Seq[Input.VirtualFile] = {
    val root = AbsolutePath(dir)
    FileIO
      .listAllFilesRecursively(root)
      .filter(_.toNIO.getFileName.toString.endsWith(".java"))
      .map(p =>
        Input.VirtualFile(
          p.toRelative(root).toString(),
          FileIO.slurp(p, StandardCharsets.UTF_8)
        )
      )
  }
}
