package com.sourcegraph.semanticdb_javac;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javadoc.JavadocClassReader;

/** Entrypoint of the semanticdb-javac compiler plugin. */
public class SemanticdbPlugin implements Plugin {

  @Override
  public String getName() {
    return "semanticdb";
  }

  @Override
  public void init(JavacTask task, String... args) {
    Context ctx = ((BasicJavacTask) task).getContext();

    SemanticdbReporter reporter = new SemanticdbReporter();
    SemanticdbJavacOptions options = SemanticdbJavacOptions.parse(args, ctx);
    GlobalSymbolsCache globals = new GlobalSymbolsCache(options);
    JavacTypes javacTypes = JavacTypes.instance(ctx);
    JavadocClassReader javadocClassReader = JavadocClassReader.instance0(ctx);
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
