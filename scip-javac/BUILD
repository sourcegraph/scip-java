load("@bazel_skylib//rules:common_settings.bzl", "string_flag")
load("@rules_jvm_external//:defs.bzl", "artifact")
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
        artifact(
            "com.sourcegraph:scip-javac:jar:all:0.0.0-SNAPSHOT",
            repository_name = "local_maven",
        ),
    ],
)

java_library(
    name = "scip-javac",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = ["src/main/resources/META-INF/services/com.sun.source.util.Plugin"],
    deps = [
        "//scip-shared",
    ],
)
