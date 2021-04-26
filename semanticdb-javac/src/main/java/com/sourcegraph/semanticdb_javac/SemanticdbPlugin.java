package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.*;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.model.JavacTypes;

/** Entrypoint of the semanticdb-javac compiler plugin. */
public class SemanticdbPlugin implements Plugin {

  @Override
  public String getName() {
    return "semanticdb";
  }

  @Override
  public void init(JavacTask task, String... args) {
    SemanticdbReporter reporter = new SemanticdbReporter();
    SemanticdbJavacOptions options = SemanticdbJavacOptions.parse(args);
    GlobalSymbolsCache globals = new GlobalSymbolsCache(options);
    JavacTypes javacTypes = JavacTypes.instance(((BasicJavacTask) task).getContext());
    if (!options.errors.isEmpty()) {
      for (String error : options.errors) {
        reporter.error(error);
      }
    } else {
      task.addTaskListener(
          new SemanticdbTaskListener(options, task, globals, reporter, javacTypes));
    }
  }
}
