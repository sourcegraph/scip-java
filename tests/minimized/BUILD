load("@rules_java//java:defs.bzl", "java_library")

java_library(
	name = "minimized",
	srcs = glob(["src/main/java/minimized/*.java"]),
	deps = [
		"@maven//:org_projectlombok_lombok",
	],
	plugins = [
          "//scip-javac:plugin",
	],
	javacopts = [
          "'-Xplugin:scip -build-tool:bazel'",
          # These are deliberately minimal SCIP indexer inputs (e.g. ignored
          # return values), not production code, so skip Error Prone linting.
          "-XepDisableAllChecks",
	],
)
