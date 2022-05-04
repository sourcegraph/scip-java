package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.*;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Options;

/** Entrypoint of the semanticdb-javac compiler plugin. */
public class SemanticdbPlugin implements Plugin {

  @Override
  public String getName() {
    return "semanticdb";
  }

  @Override
  public void init(JavacTask task, String... args) {
    Context ctx = ((BasicJavacTask) task).getContext();

    SemanticdbReporter reporter = new SemanticdbReporter(Trees.instance(task));
    SemanticdbJavacOptions options = SemanticdbJavacOptions.parse(args, ctx);
    GlobalSymbolsCache globals = new GlobalSymbolsCache(options);
    JavacTypes javacTypes = JavacTypes.instance(ctx);
    task.addTaskListener(new SemanticdbTaskListener(options, task, globals, reporter, javacTypes));
  }
}
