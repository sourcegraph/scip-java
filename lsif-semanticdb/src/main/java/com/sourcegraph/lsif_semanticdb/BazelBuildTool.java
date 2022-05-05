package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.lsif_java.Bazelbuild;
import com.sourcegraph.lsif_protocol.LsifToolInfo;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BazelBuildTool {


  public static int runAndReturnExitCode(String[] args) throws IOException {
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
    LsifSemanticdbOptions lsifOptions =
        new LsifSemanticdbOptions(
            options.targetroots,
            options.output,
            options.sourceroot,
            new LsifSemanticdbReporter() {
              @Override
              public void error(Throwable e) {
                e.printStackTrace(System.err);
              }
            },
            LsifToolInfo.newBuilder().setName("lsif-java").setVersion("HEAD").build(),
            "java",
            LsifOutputFormat.TYPED_PROTOBUF,
            options.parallel,
            mavenPackages,
            "");
    LsifSemanticdb.run(lsifOptions);
    if (!lsifOptions.reporter.hasErrors()) {
      System.out.println("done: " + lsifOptions.output);
    }
    return 0;
  }

  public static List<MavenPackage> mavenPackages(BazelOptions options)
      throws IOException {
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
                basePackage = new MavenPackage(/* jar = */null, parts[0], parts[1], parts[2]);
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
      throws IOException {
    List<String> command = Arrays.asList(options.bazelBinary, "query", query, "--output=proto");
    System.out.println("running: " + String.join(" ", command));
    Process bazelQuery =
        new ProcessBuilder(command)
            .directory(options.sourceroot.toFile())
            .start();
    byte[] bytes = InputStreamBytes.readAll(bazelQuery.getInputStream());
    if (bazelQuery.isAlive()) {
      throw new RuntimeException(new String(InputStreamBytes.readAll(bazelQuery.getErrorStream())));
    }
    int exitValue = bazelQuery.exitValue();
    if (exitValue != 0) {
      throw new RuntimeException("bazel command failed\n" + new String(bytes));
    }
    return Bazelbuild.QueryResult.parseFrom(bytes);
  }

  public static void main(String[] args) throws IOException {
    System.exit(runAndReturnExitCode(args));
  }
}
