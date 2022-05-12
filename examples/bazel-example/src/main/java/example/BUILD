# We import the custom `java_library` implementation that automatically adds the
# SemanticDB compiler plugin based on the presence of the flag
# `--@scip_java//semanticdb-javac:enabled=true`. By default, this java_library
# rule works just like the official java_library rule. Feel free to copy-paste
# the `semanticdb:defs.bzl` file and adapt to your needs. This example is only
# for demonstration purposes.
load("@scip_java//semanticdb-javac:defs.bzl", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

java_library(
	name = "example",
	srcs = ["Example.java"],
	deps = [
		"@maven//:com_google_guava_guava",
	],
)
