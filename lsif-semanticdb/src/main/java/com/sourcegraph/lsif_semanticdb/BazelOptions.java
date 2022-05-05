package com.sourcegraph.lsif_semanticdb;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class BazelOptions {
  public final List<Path> targetroots = new ArrayList<>();
  public Path sourceroot;
  public Path output;
  public String bazelBinary = "bazel";
  public boolean isQueryMavenImports = true;
  public boolean isHelp = false;
  public boolean isVersion = false;
  public boolean parallel = false;

  public static void printHelp() {
    System.out.println("bazel run //lsif-semanticdb:bazel -- [..options]");
    System.out.println();
    System.out.println("Command-line tool to generate LSIF for Java targets in a Bazel build.");
    System.out.println(
            "The idiomatic way to run this tool is to compile it from source via Bazel\n"
                    + "and invoke it through `bazel run ...`.");
    System.out.println();
    System.out.println("OPTIONS:");
    System.out.println(
            "  --sourceroot <path> the absolute path to the root directory of the Bazel codebase");
    System.out.println(
            "                      TIP: use --sourceroot $PWD to pass the current working directory");
    System.out.println("  --output <path> the absolute path to the file that should be generated");
    System.out.println("  --parallel whether to process files in parallel");
    System.out.println("  --no-query-maven-imports whether to skip the `bazel query @maven//...` phase.");
  }

  public static Optional<BazelOptions> parse(String[] args) throws IOException {

    ArrayList<String> errors = new ArrayList<>();
    BazelOptions options = new BazelOptions();

    if (args.length == 1
        && (args[0].equals("--help")
            || args[0].equals("help")
            || args[0].equals("-h")
            || args[0].equals("-help"))) {

      options.isHelp = true;
      return Optional.of(options);
    }
    if (args.length == 1
        && (args[0].equals("--version")
            || args[0].equals("version")
            || args[0].equals("-v")
            || args[0].equals("-version"))) {
      options.isVersion = true;
      return Optional.of(options);
    }

    Iterator<String> it = Arrays.asList(args).iterator();
    while (it.hasNext()) {
      String argument = it.next();
      if (argument.equals("--sourceroot") && it.hasNext()) {
        options.sourceroot = Paths.get(it.next());
      }

      if (argument.equals("--output")) {
        if (it.hasNext()) {
          options.output = Paths.get(it.next());
        } else {
          errors.add("missing argument for flag --output <path>");
        }
      }

      if (argument.equals("--parallel")) {
        options.parallel = true;
      }

      if (argument.equals("--query-maven-imports")) {
        options.isQueryMavenImports = true;
      }
      if (argument.equals("--no-query-maven-imports")) {
        options.isQueryMavenImports = false;
      }

      if (argument.equals("--bazel-binary")) {
        if (it.hasNext()) {
          options.bazelBinary = it.next();
        } else {
          errors.add("missing argument for flag --bazel-binary <path>");
        }
      }
    }

    if (options.sourceroot == null) {
      if (args.length == 0) {
        errors.add("missing required flag --sourceroot <path>. To fix this problem, pass in the `--sourceroot` flag like this: bazel run @lsif_java//lsif-semanticdb:bazel -- --sourceroot $PWD");
      } else {
      errors.add("missing required flag --sourceroot <path>");
      }
    } else if (!options.sourceroot.isAbsolute()) {
      // result.sourceroot must be an absolute path because `System.getProperty("user.dir")` is a
      // temporary directory that's generated by Bazel.
      errors.add(
          String.format("relative path --sourceroot '%s'. To fix this problem, pass in an an absolute path.", options.sourceroot));
    } else if (!Files.isDirectory(options.sourceroot)) {
      errors.add(
              String.format("not a directory --sourceroot '%s'", options.sourceroot));
    }

    if (options.output == null) {
      options.output = Paths.get("dump.lsif-typed");
    }

    if (!errors.isEmpty()) {
      if (errors.size() == 1) {
        System.err.printf("error: %s\n", errors.get(0));
      } else {
        for (int i = 0; i < errors.size(); i++) {
          System.err.printf("[%d] error: %s\n", i, errors.get(i));
        }
      }
      return Optional.empty();
    }

    inferTargetrootsAndPackages(options);

    options.output = absolutePath(options.sourceroot, options.output);

    return Optional.of(options);
  }

  public static void inferTargetrootsAndPackages(BazelOptions options) throws IOException {
    PathMatcher paramsPattern = FileSystems.getDefault().getPathMatcher("glob:**-0.params");
    Path bazelBin = options.sourceroot.resolve("bazel-bin");
    if (!Files.exists(bazelBin)) {
      return;
    }
    Files.walkFileTree(
        bazelBin,
        Collections.singleton(FileVisitOption.FOLLOW_LINKS),
        1000,
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFileFailed(Path file, IOException exc) {
            exc.printStackTrace(System.err);
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            if (paramsPattern.matches(file)) {
              visitParamsFile(file, options);
            }
            return super.visitFile(file, attrs);
          }
        });
  }

  private static Path absolutePath(Path sourceroot, Path path) {
    return path.isAbsolute() ? path : sourceroot.resolve(path);
  }

  public static void visitParamsFile(Path paramsFile, BazelOptions options) throws IOException {
    List<String> lines = Files.readAllLines(paramsFile);
    Optional<String> semanticdbPlugin =
        lines.stream().filter(line -> line.startsWith("-Xplugin:semanticdb")).findFirst();
    if (semanticdbPlugin.isPresent()) {
      String jarFileName = paramsFile.getFileName().toString();
      jarFileName = jarFileName.substring(0, jarFileName.length() - "-0.param".length() - 1);
      Path jarFile = paramsFile.resolveSibling(jarFileName);
      if (Files.isRegularFile(jarFile)) {
        options.targetroots.add(jarFile);
      }
    }
  }
}
