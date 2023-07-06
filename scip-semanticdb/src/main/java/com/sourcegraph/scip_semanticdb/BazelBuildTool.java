package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.scip_java.Bazelbuild;
import com.sourcegraph.lsif_protocol.LsifToolInfo;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BazelBuildTool {

  public static int runAndReturnExitCode(String[] args) throws IOException, InterruptedException {
    Optional<BazelOptions> maybeOptions = BazelOptions.parse(args);
    if (!maybeOptions.isPresent()) {
      return 1;
    }
    BazelOptions options = maybeOptions.get();
    if (options.isHelp) {
      BazelOptions.printHelp();
      return 0;
    }
    if (options.isVersion) {
      System.out.println(
          "This command-line tool has no version because it is supposed to be compiled from source.");
      return 0;
    }

    List<MavenPackage> mavenPackages = mavenPackages(options);
    ScipSemanticdbReporter reporter =
        new ScipSemanticdbReporter() {
          private boolean hasErrors = false;

          @Override
          public void error(Throwable e) {
            e.printStackTrace(System.err);
            hasErrors = true;
          }

          @Override
          public void error(String message) {
            System.err.println("ERROR[scip-semanticdb]: " + message);
            hasErrors = true;
          }

          @Override
          public boolean hasErrors() {
            return this.hasErrors;
          }
        };
    ScipSemanticdbOptions scipOptions =
        new ScipSemanticdbOptions(
            options.targetroots,
            options.output,
            options.sourceroot,
            reporter,
            LsifToolInfo.newBuilder().setName("scip-java").setVersion("HEAD").build(),
            "java",
            ScipOutputFormat.TYPED_PROTOBUF,
            options.parallel,
            mavenPackages,
            "",
            true);
    ScipSemanticdb.run(scipOptions);

    if (!scipOptions.reporter.hasErrors()) {
      System.out.println("done: " + scipOptions.output);
      return 0;
    } else {
      System.out.println("SCIP index generation failed");
      return 1;
    }
  }

  public static List<MavenPackage> mavenPackages(BazelOptions options)
      throws IOException, InterruptedException {
    ArrayList<MavenPackage> result = new ArrayList<>();
    if (!options.isQueryMavenImports) {
      return result;
    }
    Bazelbuild.QueryResult jvmImports = runBazelQuery(options, "kind('.*_import', @maven//...)");
    Path baseDirectory =
        options.sourceroot.resolve("bazel-bin").resolve("external").resolve("maven");
    PathMatcher jarPattern = FileSystems.getDefault().getPathMatcher("glob:**.jar");
    for (Bazelbuild.Target target : jvmImports.getTargetList()) {
      if (target.getType() != Bazelbuild.Target.Discriminator.RULE) {
        continue;
      }
      Bazelbuild.Rule rule = target.getRule();
      MavenPackage basePackage = null;
      List<Path> jarDirectories = new ArrayList<>();
      for (Bazelbuild.Attribute attribute : rule.getAttributeList()) {
        if (attribute.getName().equals("jars")) {
          for (String tag : attribute.getStringListValueList()) {
            if (tag.startsWith("@maven//:")) {
              jarDirectories.add(
                  baseDirectory.resolve(tag.substring("@maven//:".length())).getParent());
            }
          }
        }
        if (attribute.getName().equals("tags")) {
          for (String tag : attribute.getStringListValueList()) {
            if (tag.startsWith("maven_coordinates=")) {
              String[] parts = tag.substring("maven_coordinates=".length()).split(":");
              if (parts.length == 3) {
                // The jar part is populated via `withJar()` below.
                basePackage = new MavenPackage(/* jar = */ null, parts[0], parts[1], parts[2]);
              }
            }
          }
        }
      }
      if (basePackage == null) {
        continue;
      }
      for (Path directory : jarDirectories) {
        try (Stream<Path> list = Files.list(directory)) {
          List<Path> jars = list.filter(jarPattern::matches).collect(Collectors.toList());
          for (Path jar : jars) {
            result.add(basePackage.withJar(jar));
          }
        }
      }
    }
    return result;
  }

  public static Bazelbuild.QueryResult runBazelQuery(BazelOptions options, String query)
      throws IOException, InterruptedException {
    List<String> command = Arrays.asList(options.bazelBinary, "query", query, "--output=proto");
    System.out.println("running: " + String.join(" ", command));
    Process bazelQuery = new ProcessBuilder(command).directory(options.sourceroot.toFile()).start();
    byte[] bytes = InputStreamBytes.readAll(bazelQuery.getInputStream());
    int exitValue = bazelQuery.waitFor();
    if (exitValue != 0) {
      throw new RuntimeException("bazel command failed\n" + new String(bytes));
    }
    return Bazelbuild.QueryResult.parseFrom(bytes);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    System.exit(runAndReturnExitCode(args));
  }
}
