package org.scip_code.scip_java.javac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class JavacClassesDirectoryTest {

  @Test
  void targetrootJavacClassesDirectory(@TempDir Path sourceroot) {
    TestCompiler compiler =
        new TestCompiler(
            TestCompiler.PROCESSOR_PATH, Collections.emptyList(), sourceroot, sourceroot);
    CompileResult compileResult =
        compiler.compile(
            Collections.singletonList(
                new VirtualFile(
                    "example/Example.java", "package example;\npublic class Example{}")),
            Arrays.asList(
                "-Xplugin:scip -sourceroot:" + sourceroot + " -targetroot:javac-classes-directory",
                "-d",
                sourceroot.toString()));
    assertTrue(compileResult.isSuccess, "compilation should succeed");
    Path shardPath =
        sourceroot
            .resolve("META-INF")
            .resolve("scip")
            .resolve("example")
            .resolve("Example.java.scip");
    assertTrue(Files.isRegularFile(shardPath), () -> "expected SCIP shard at " + shardPath);
  }
}
