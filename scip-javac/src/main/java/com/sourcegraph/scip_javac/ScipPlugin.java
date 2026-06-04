package com.sourcegraph.scip_javac;

import com.sun.source.util.Plugin;
import com.sun.source.util.JavacTask;
import com.sun.source.util.Trees;

/** Entrypoint of the scip-javac compiler plugin. */
public class ScipPlugin implements Plugin {

  public static String stubClassName = "META-INF-scip-stub";

  @Override
  public String getName() {
    return "scip";
  }

  @Override
  public void init(JavacTask task, String... args) {
    Trees trees = Trees.instance(task);
    ScipReporter reporter = new ScipReporter(trees);
    ScipJavacOptions options = ScipJavacOptions.parse(args, task);
    GlobalSymbolsCache globals = new GlobalSymbolsCache(options);
    task.addTaskListener(new ScipTaskListener(options, task, trees, globals, reporter));
  }
}
