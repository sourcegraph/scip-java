load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_proto_library")
load("@rules_proto//proto:defs.bzl", "proto_library")

package(
    default_visibility = ["//visibility:public"],
)

java_binary(
    name = "bazel",
    main_class = "com.sourcegraph.lsif_semanticdb.BazelBuildTool",
    runtime_deps = [
        ":lsif-semanticdb",
    ],
)

java_library(
    name = "lsif-semanticdb",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        ":all_java_proto",
        "//semanticdb-java",
        "//semanticdb-java/src/main/protobuf:semanticdb_java_proto",
        "@maven//:com_google_protobuf_protobuf_java",
        "@maven//:com_google_protobuf_protobuf_java_util",
    ],
)

java_proto_library(
    name = "all_java_proto",
    deps = [":all_proto"],
)

proto_library(
    name = "all_proto",
    srcs = glob(["src/main/protobuf/*.proto"]),
)
