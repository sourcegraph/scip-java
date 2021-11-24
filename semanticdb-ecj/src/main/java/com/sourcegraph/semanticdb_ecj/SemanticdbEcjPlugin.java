package com.sourcegraph.semanticdb_ecj;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.*;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;

public class SemanticdbEcjPlugin {
  @SuppressWarnings("unused")
  public static void run(Object unit) {
    if (!(unit instanceof CompilationUnitDeclaration)) {
      throw new IllegalArgumentException(String.valueOf(unit));
    }
    runUnit((CompilationUnitDeclaration) unit);
  }

  public static void runUnit(CompilationUnitDeclaration unit) {
    ASTVisitor visitor =
        new ASTVisitor() {
          @Override
          public boolean visit(MethodDeclaration methodDeclaration, ClassScope scope) {
            return super.visit(methodDeclaration, scope);
          }

          @Override
          public boolean visit(Block block, BlockScope scope) {
            return super.visit(block, scope);
          }

          @Override
          public boolean visit(SingleNameReference singleNameReference, ClassScope scope) {
            return super.visit(singleNameReference, scope);
          }

          @Override
          public boolean visit(SingleNameReference singleNameReference, BlockScope scope) {
            return super.visit(singleNameReference, scope);
          }

          @Override
          public boolean visit(LocalDeclaration localDeclaration, BlockScope scope) {
            return super.visit(localDeclaration, scope);
          }
        };
    unit.traverse(visitor, unit.scope);
  }

  public static void main(String[] args) throws IOException {
    Path dir = Files.createTempDirectory("ecj");
    Path tmp = dir.resolve("Hello.java");
    Files.write(
        tmp,
        Arrays.asList(
            "package example;",
            "public class Hello {",
            "  public static void main(String[] args) {",
            "    int x = 42;",
            "    System.out.println(x);",
            "  }",
            "}"));
    new Main(
            new PrintWriter(System.out),
            new PrintWriter(System.err),
            false,
            Collections.emptyMap(),
            null)
        .compile(new String[] {"-d", dir.toString(), tmp.toString()});
    deleteRecursively(dir);
  }

  public static void deleteRecursively(Path dir) throws IOException {
    Files.walkFileTree(
        dir,
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            Files.delete(file);
            return super.visitFile(file, attrs);
          }

          @Override
          public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            return super.postVisitDirectory(dir, exc);
          }
        });
  }
}
