load("@bazel_skylib//rules:common_settings.bzl", "string_flag")
load("@rules_java//java:defs.bzl", "java_library", "java_plugin")

package(
    default_visibility = ["//visibility:public"],
)

config_setting(
    name = "is_enabled",
    flag_values = {":enabled": "true"},
)

string_flag(
    name = "enabled",
    build_setting_default = "false",
    values = [
        "true",
        "false",
    ],
)

java_plugin(
    name = "plugin",
    deps = [
        ":semanticdb-javac",
    ],
)

java_library(
    name = "semanticdb-javac",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = ["src/main/resources/META-INF/services/com.sun.source.util.Plugin"],
    deps = [
        "//semanticdb-java",
        "@maven//:org_scip_code_scip_java_bindings",
    ],
)
