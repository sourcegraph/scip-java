package org.scip_code.scip_java.javac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sun.tools.javac.api.ClientCodeWrapper;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;

/**
 * Tests the automatic sourceroot inference of {@code -build-tool:bazel} compilations (see {@code
 * ScipTaskListener.inferBazelSourceroot}) by driving the real compiler with file objects that mimic
 * the ones constructed by Bazel's Java compiler.
 */
class BazelSourcerootTest {

  /**
   * Mimics the {@code com.sun.tools.javac.file.PathFileObject.SimpleFileObject} instances that the
   * plugin sees under Bazel: {@code toUri()} points to the file in a sandbox/temporary directory
   * while {@code toString()} renders a "human-readable" path pointing to the original source file.
   *
   * <p>The {@link ClientCodeWrapper.Trusted} annotation stops javac from wrapping this file object
   * in a {@code WrappedJavaFileObject}, which would change the result of {@code toString()}.
   * Bazel's file objects are never wrapped because javac-internal classes are trusted.
   */
  @ClientCodeWrapper.Trusted
  private static final class BazelSourceFile extends SimpleJavaFileObject {
    private final Path humanReadablePath;
    private final String content;

    BazelSourceFile(Path sandboxPath, Path humanReadablePath, String content) {
      super(sandboxPath.toUri(), Kind.SOURCE);
      this.humanReadablePath = humanReadablePath;
      this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
      return content;
    }

    @Override
    public String toString() {
      return "SimpleFileObject[" + humanReadablePath + "]";
    }
  }

  private static void compile(Path targetroot, List<JavaFileObject> compilationUnits) {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    SimpleFileManager fileManager =
        new SimpleFileManager(compiler.getStandardFileManager(null, null, null), targetroot);
    StringWriter output = new StringWriter();
    List<String> arguments =
        Arrays.asList(
            "-processorpath",
            TestCompiler.PROCESSOR_PATH,
            "-classpath",
            TestCompiler.PROCESSOR_PATH,
            "-Xplugin:scip -build-tool:bazel");
    JavaCompiler.CompilationTask task =
        compiler.getTask(output, fileManager, null, arguments, null, compilationUnits);
    boolean isSuccess = task.call();
    assertTrue(isSuccess, () -> "compilation should succeed, compiler output:\n" + output);
  }

  private static Document readShardDocument(Path shardPath) {
    assertTrue(Files.isRegularFile(shardPath), () -> "expected SCIP shard at " + shardPath);
    try {
      Index shard = Index.parseFrom(Files.readAllBytes(shardPath));
      assertEquals(1, shard.getDocumentsCount());
      return shard.getDocuments(0);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Test
  void sandboxedCompilation(
      @TempDir Path workspace, @TempDir Path sandbox, @TempDir Path targetroot) {
    // The typical case: javac sees the source files in a sandbox directory while their
    // human-readable paths point into the workspace. The sourceroot is inferred from the
    // first compilation unit (the longest common suffix of the two paths is
    // src/com/example/Hello.java, what remains is the workspace directory) and shards are
    // written under the workspace-relative path of each source file.
    Path execroot = sandbox.resolve("execroot").resolve("_main");
    compile(
        targetroot,
        Arrays.asList(
            new BazelSourceFile(
                execroot.resolve("src/com/example/Hello.java"),
                workspace.resolve("src/com/example/Hello.java"),
                "package com.example;\npublic class Hello {}"),
            new BazelSourceFile(
                execroot.resolve("src/com/example/inner/World.java"),
                workspace.resolve("src/com/example/inner/World.java"),
                "package com.example.inner;\npublic class World {}")));
    Path scipRoot = targetroot.resolve("META-INF").resolve("scip");
    Document hello = readShardDocument(scipRoot.resolve("src/com/example/Hello.java.scip"));
    assertEquals("src/com/example/Hello.java", hello.getRelativePath());
    Document world = readShardDocument(scipRoot.resolve("src/com/example/inner/World.java.scip"));
    assertEquals("src/com/example/inner/World.java", world.getRelativePath());
  }

  @Test
  void onlyFileNameInCommon(
      @TempDir Path workspace, @TempDir Path sandbox, @TempDir Path targetroot) {
    // When the sandbox layout shares nothing with the workspace layout except the file
    // name, the inferred sourceroot is the parent directory of the source file.
    compile(
        targetroot,
        Collections.singletonList(
            new BazelSourceFile(
                sandbox.resolve("Hello.java"),
                workspace.resolve("nested/dir/Hello.java"),
                "public class Hello {}")));
    Document document =
        readShardDocument(
            targetroot.resolve("META-INF").resolve("scip").resolve("Hello.java.scip"));
    assertEquals("Hello.java", document.getRelativePath());
  }

  @Test
  void unrecognizedFileObjectsFallBackToFilesystemRoot(
      @TempDir Path sandbox, @TempDir Path targetroot) {
    // SimpleSourceFile's toString() doesn't match any of the known Bazel file object
    // patterns, so the plugin falls back to using the URI path as the human-readable path.
    // The two paths are then identical and the inferred sourceroot degenerates to the
    // filesystem root: shards are written under the full path of each source file.
    Path source = sandbox.resolve("com/example/Hello.java");
    compile(
        targetroot,
        Collections.singletonList(
            new SimpleSourceFile(source, "package com.example;\npublic class Hello {}")));
    Path relative = source.getRoot().relativize(source);
    Document document =
        readShardDocument(
            targetroot.resolve("META-INF").resolve("scip").resolve(relative + ".scip"));
    assertEquals(relative.toString().replace(File.separatorChar, '/'), document.getRelativePath());
  }
}
