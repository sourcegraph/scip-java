load("@com_google_protobuf//bazel:java_proto_library.bzl", "java_proto_library")
load("@com_google_protobuf//bazel:proto_library.bzl", "proto_library")
load("@rules_java//java:defs.bzl", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

proto_library(
    name = "semanticdb_proto",
    srcs = ["src/main/protobuf/semanticdb.proto"],
)

java_proto_library(
    name = "semanticdb_java_proto",
    deps = [":semanticdb_proto"],
)

java_library(
    name = "semanticdb-shared",
    srcs = glob(["src/main/java/**/*.java"]),
    exports = [":semanticdb_java_proto"],
    deps = [":semanticdb_java_proto"],
)
