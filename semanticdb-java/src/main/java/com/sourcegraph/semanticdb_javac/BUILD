load("@rules_java//java:defs.bzl", "java_library")
package(
    default_visibility = ["//visibility:public"],
)

java_library(
	name = "semanticdb_java",
	srcs = glob(["*.java"]),
	deps = [
		"//semanticdb-java/src/main/protobuf:semanticdb_java_proto",
	],
)
