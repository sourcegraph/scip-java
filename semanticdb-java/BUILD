load("@rules_java//java:defs.bzl", "java_library", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")

package(
    default_visibility = ["//visibility:public"],
)

java_proto_library(
	name = "semanticdb_java_proto",
	deps = [":semanticdb_proto"],
)

proto_library(
	name = "semanticdb_proto",
	srcs = glob(["src/main/protobuf/*.proto"]),
)

java_library(
	name = "semanticdb-java",
	srcs = glob(["src/main/java/**/*.java"]),
	deps = [
		"//semanticdb-java/src/main/protobuf:semanticdb_java_proto",
	],
)
