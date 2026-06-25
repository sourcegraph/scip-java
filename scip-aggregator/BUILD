load("@com_google_protobuf//bazel:java_proto_library.bzl", "java_proto_library")
load("@com_google_protobuf//bazel:proto_library.bzl", "proto_library")
load("@rules_jvm_external//:defs.bzl", "artifact")
load("@rules_java//java:defs.bzl", "java_binary", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

java_binary(
    name = "bazel",
    main_class = "com.sourcegraph.scip_aggregator.BazelBuildTool",
    runtime_deps = [
        artifact(
            "com.sourcegraph:scip-aggregator:0.0.0-SNAPSHOT",
            repository_name = "local_maven",
        ),
    ],
)

java_library(
    name = "scip-aggregator",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        ":all_java_proto",
        "//scip-shared",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_protobuf_protobuf_java",
        "@maven//:com_google_protobuf_protobuf_java_util",
        "@maven//:org_scip_code_scip_java_bindings",
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
