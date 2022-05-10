load("@rules_java//java:defs.bzl", "java_proto_library")
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
	srcs = ["semanticdb.proto"]
)
