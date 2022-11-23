load("@rules_java//java:defs.bzl", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")

package(
    default_visibility = ["//visibility:public"],
)

java_proto_library(
    name = "scip_java_proto",
    deps = [":scip_proto"],
)

proto_library(
    name = "scip_proto",
    srcs = ["scip.proto"],
)
