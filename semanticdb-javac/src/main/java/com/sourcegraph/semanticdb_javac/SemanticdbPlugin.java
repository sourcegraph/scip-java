package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.*;

/** Entrypoint of the semanticdb-javac compiler plugin. */
public class SemanticdbPlugin implements Plugin {

  @Override
  public String getName() {
    return "semanticdb";
  }

  @Override
  public void init(JavacTask task, String... args) {
    SemanticdbReporter reporter = new SemanticdbReporter();
    SemanticdbOptions options = SemanticdbOptions.parse(args);
    GlobalSymbolsCache globals = new GlobalSymbolsCache(options);
    if (!options.errors.isEmpty()) {
      for (String error : options.errors) {
        reporter.error(error);
      }
    } else {
      task.addTaskListener(new SemanticdbTaskListener(options, task, globals, reporter));
    }
  }
}
