load("@rules_java//java:defs.bzl", "java_library")

java_library(
	name = "minimized",
	srcs = glob(["src/main/java/minimized/*.java"]),
	deps = [
		"@maven//:org_projectlombok_lombok",
	],
	plugins = [
          "//semanticdb-javac:plugin",
	],
	javacopts = [
          "'-Xplugin:semanticdb -build-tool:bazel'",
	],
)
