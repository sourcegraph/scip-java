load("@rules_proto//proto:defs.bzl", "proto_library")
load("@rules_java//java:defs.bzl", "java_proto_library")

package(
    default_visibility = ["//visibility:public"],
)

java_proto_library(
	name = "lsif_java_proto",
	deps = [":lsif_proto"],
)
proto_library(
	name = "lsif_proto",
	srcs = ["lsif.proto"]
)
