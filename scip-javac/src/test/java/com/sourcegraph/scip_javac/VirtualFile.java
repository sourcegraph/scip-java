package com.sourcegraph.scip_javac;

/**
 * Minimal in-memory source file (relative path + text), replacing the former use of scalameta's
 * {@code Input.VirtualFile} in the test harness.
 */
public final class VirtualFile {
  public final String path;
  public final String text;

  public VirtualFile(String path, String text) {
    this.path = path;
    this.text = text;
  }
}
