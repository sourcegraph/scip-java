load("@rules_java//java:defs.bzl", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "semanticdb-java",
    srcs = glob(["src/main/java/**/*.java"]),
    deps = [
        "//semanticdb-java/src/main/protobuf:semanticdb_java_proto",
    ],
)
