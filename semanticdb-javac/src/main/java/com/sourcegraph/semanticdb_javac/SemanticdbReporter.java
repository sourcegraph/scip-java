package com.sourcegraph.semanticdb_javac;

import java.io.PrintStream;

/**
 * Utilities to report error messages.
 *
 * <p>NOTE(olafur): this class exists because I couldn't find compiler APIs to report diagnostics.
 * This class can be removed if the Java compiler has APIs to report info/warning/error messages.
 */
public class SemanticdbReporter {
  private final PrintStream out;

  public SemanticdbReporter() {
    this.out = System.err;
  }

  public void exception(Throwable e) {
    e.printStackTrace(out);
    out.println(
        "Please report a bug to https://github.com/sourcegraph/semanticdb-java with the stack trace above.");
  }

  public void error(String message) {
    // NOTE(olafur): ideally, this message should be reported as a compiler diagnostic, but I dind't
    // find
    // the reporter API so the message goes to stderr instead for now.
    out.printf("semanticdb-javac: %s\n", message);
  }
}
