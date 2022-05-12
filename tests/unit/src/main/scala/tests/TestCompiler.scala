package tests

import java.io.StringWriter
import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.ServiceLoader
import javax.tools.ToolProvider

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

import scala.meta.Input
import scala.meta.internal.io.FileIO
import scala.meta.io.AbsolutePath
import scala.meta.io.Classpath
import scala.meta.pc.PresentationCompiler

import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments

object TestCompiler {
  val PROCESSOR_PATH = System.getProperty("java.class.path")
}

class TestCompiler(
    val classpath: String,
    val javacOptions: List[String],
    val scalacOptions: List[String],
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
    this(TestCompiler.PROCESSOR_PATH, Nil, Nil, targetroot)
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
      extraJavacOptions: Seq[String] = Nil,
      extraScalacOptions: Seq[String] = Nil
  ): CompileResult = {
    val javacInputs = inputs.filter(_.path.endsWith(".java"))
    val scalacInputs = inputs.filter(_.path.endsWith(".scala"))
    val results = ListBuffer.empty[CompileResult]
    if (javacInputs.nonEmpty) {
      results += compileJavac(javacInputs, extraJavacOptions)
    } else if (scalacInputs.nonEmpty) {
      results += compileScalac(scalacInputs, extraScalacOptions)
    }
    results.foldLeft(CompileResult.empty)(_ merge _)
  }

  private def compileScalac(
      inputs: Seq[Input.VirtualFile],
      extraScalacOptions: Seq[String]
  ): CompileResult = {
    val List(compiler) =
      ServiceLoader
        .load(classOf[PresentationCompiler])
        .iterator()
        .asScala
        .toList
    val compilerWithClasspath = compiler.newInstance(
      "file://scip-java",
      Classpath(classpath).entries.map(_.toNIO).asJava,
      (scalacOptions ++ extraScalacOptions).asJava
    )
    val textDocuments =
      try {
        inputs.map { input =>
          val uri = URI.create(s"file:///${input.path}")
          val bytes = compilerWithClasspath
            .semanticdbTextDocument(uri, input.text)
            .get()
          TextDocument.parseFrom(bytes).toBuilder.setUri(input.path).build
        }
      } finally {
        compilerWithClasspath.shutdown()
      }
    CompileResult(
      Array.emptyByteArray,
      "",
      TextDocuments.newBuilder().addAllDocuments(textDocuments.asJava).build(),
      isSuccess = true
    )
  }

  private def compileJavac(
      inputs: Seq[Input.VirtualFile],
      extraJavacOptions: Seq[String]
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
    arguments ++= extraJavacOptions
    arguments ++= javacOptions
    val task = compiler.getTask(
      output,
      fileManager,
      null,
      arguments.asJava,
      null,
      compilationUnits.asJava
    )
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
