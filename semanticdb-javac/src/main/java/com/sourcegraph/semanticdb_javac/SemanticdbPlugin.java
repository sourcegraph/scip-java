package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

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
    //    JavacTypes javacTypes = JavacTypes.instance(ctx);
    if (!options.errors.isEmpty()) {
      for (String error : options.errors) {
        reporter.error(error);
      }
    } else {
      task.addTaskListener(
          new SemanticdbTaskListener(options, task, globals, reporter, task.getTypes()));
    }
  }
}
