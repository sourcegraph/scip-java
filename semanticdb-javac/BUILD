load("@bazel_skylib//rules:common_settings.bzl", "string_flag")
load("@rules_java//java:defs.bzl", "java_import", "java_library", "java_plugin")

package(
    default_visibility = ["//visibility:public"],
)

config_setting(
    name = "is_enabled",
    flag_values = {":enabled": "true"},
)

string_flag(
    name = "enabled",
    values = ["true", "false"],
    build_setting_default = "false",
)

java_import(
    name = "javac-import",
    jars = ["@bazel_tools//third_party/java/jdk/langtools:javac_jar"],
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
                "//semanticdb-java/src/main/protobuf:semanticdb_java_proto",
		"//semanticdb-java",
		":javac-import",
	],
)
