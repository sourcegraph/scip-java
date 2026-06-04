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

import org.scip_code.scip.Index

object TestCompiler {
  val PROCESSOR_PATH = System.getProperty("java.class.path")
}

class TestCompiler(
    val classpath: String,
    val javacOptions: List[String],
    val targetroot: Path,
    val sourceroot: Path = Files.createTempDirectory("scip-javac")
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

  def compileSemanticdbDirectory(dir: Path): CompileResult = compileSemanticdb(
    inputsFromDirectory(dir)
  )

  def compileSemanticdb(inputs: Seq[Input.VirtualFile]): CompileResult =
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

  def compile(
      inputs: Seq[Input.VirtualFile],
      extraJavacOptions: Seq[String] = Nil
  ): CompileResult = {
    val javacInputs = inputs.filter(_.path.endsWith(".java"))
    val results = ListBuffer.empty[CompileResult]
    if (javacInputs.nonEmpty)
      results += compileJavac(javacInputs, extraJavacOptions)
    results.foldLeft(CompileResult.empty)(_ merge _)
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
    val docs = ListBuffer.empty[org.scip_code.scip.Document]
    inputs.foreach { input =>
      val shardPath = targetroot
        .resolve("META-INF")
        .resolve("scip")
        .resolve(input.path + ".scip")
      if (Files.isRegularFile(shardPath)) {
        val shard = Index.parseFrom(Files.readAllBytes(shardPath))
        docs ++= shard.getDocumentsList.asScala
      }
    }
    val stdout = output.toString
    CompileResult(bytecode, stdout, docs.toSeq, isSuccess)
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
