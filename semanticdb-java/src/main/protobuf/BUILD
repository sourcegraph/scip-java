load("@com_google_protobuf//bazel:java_proto_library.bzl", "java_proto_library")
load("@com_google_protobuf//bazel:proto_library.bzl", "proto_library")

package(
    default_visibility = ["//visibility:public"],
)

java_proto_library(
    name = "semanticdb_java_proto",
    deps = [":semanticdb_proto"],
)

proto_library(
    name = "semanticdb_proto",
    srcs = ["semanticdb.proto"],
)
