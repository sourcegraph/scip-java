package com.sourcegraph.semanticdb_javac;

public class CompilationUnitException extends Throwable {
  public CompilationUnitException(String compilationUnit, Throwable cause) {
    super(compilationUnit, cause);
  }

  @Override
  public Throwable fillInStackTrace() {
    return this;
  }
}
