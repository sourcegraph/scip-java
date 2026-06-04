load("@rules_java//java:defs.bzl", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

java_library(
    name = "scip-shared",
    srcs = glob(["src/main/java/**/*.java"]),
    exports = [
        "@maven//:org_scip_code_scip_java_bindings",
    ],
    deps = [
        "@maven//:org_scip_code_scip_java_bindings",
    ],
)
