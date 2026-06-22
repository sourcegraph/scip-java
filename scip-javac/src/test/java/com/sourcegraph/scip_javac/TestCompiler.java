package com.sourcegraph.scip_javac;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;

/** Drives javac in-process with the scip compiler plugin attached. */
public class TestCompiler {
  public static final String PROCESSOR_PATH = System.getProperty("java.class.path");

  public final String classpath;
  public final List<String> javacOptions;
  public final Path targetroot;
  public final Path sourceroot;

  private final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
  private final SimpleFileManager fileManager;

  public TestCompiler(
      String classpath, List<String> javacOptions, Path targetroot, Path sourceroot) {
    this.classpath = classpath;
    this.javacOptions = javacOptions;
    this.targetroot = targetroot;
    this.sourceroot = sourceroot;
    this.fileManager =
        new SimpleFileManager(compiler.getStandardFileManager(null, null, null), targetroot);
  }

  public CompileResult compile(List<VirtualFile> inputs, List<String> extraJavacOptions) {
    List<VirtualFile> javacInputs =
        inputs.stream().filter(i -> i.path.endsWith(".java")).collect(Collectors.toList());
    if (javacInputs.isEmpty()) {
      return CompileResult.empty();
    }
    return compileJavac(javacInputs, extraJavacOptions);
  }

  private CompileResult compileJavac(List<VirtualFile> inputs, List<String> extraJavacOptions) {
    StringWriter output = new StringWriter();
    List<JavaFileObject> compilationUnits = new ArrayList<>();
    for (VirtualFile input : inputs) {
      Path source = sourceroot.resolve(input.path);
      compilationUnits.add(new SimpleSourceFile(source, input.text));
    }
    List<String> arguments = new ArrayList<>();
    arguments.add("-processorpath");
    arguments.add(PROCESSOR_PATH);
    arguments.add("-classpath");
    arguments.add(classpath);
    arguments.addAll(extraJavacOptions);
    arguments.addAll(javacOptions);
    JavaCompiler.CompilationTask task =
        compiler.getTask(output, fileManager, null, arguments, null, compilationUnits);
    boolean isSuccess = task.call();
    byte[] bytecode = new byte[0];
    if (!fileManager.compiled.isEmpty()) {
      bytecode = fileManager.compiled.iterator().next().getCompiledBinaries();
    }
    List<Document> docs = new ArrayList<>();
    for (VirtualFile input : inputs) {
      Path shardPath = targetroot.resolve("META-INF").resolve("scip").resolve(input.path + ".scip");
      if (Files.isRegularFile(shardPath)) {
        try {
          Index shard = Index.parseFrom(Files.readAllBytes(shardPath));
          docs.addAll(shard.getDocumentsList());
        } catch (IOException e) {
          throw new UncheckedIOException(e);
        }
      }
    }
    return new CompileResult(bytecode, output.toString(), docs, isSuccess);
  }
}
