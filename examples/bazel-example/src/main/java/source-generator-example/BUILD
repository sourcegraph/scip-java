load("@scip_java//semanticdb-javac:defs.bzl", "java_library")
load("@rules_java//java:defs.bzl", "java_plugin")

package(
    default_visibility = ["//visibility:public"],
)

java_library(
	name = "animal",
	srcs = ["Animal.java"],
	deps = [
    ":autovalue",
	],
)

java_plugin(
    name = "autovalue_plugin",
    processor_class = "com.google.auto.value.processor.AutoValueProcessor",
    deps = [
        "@maven//:com_google_auto_value_auto_value",
    ],
)

java_library(
    name = "autovalue",
    exported_plugins = [
        ":autovalue_plugin",
    ],
    neverlink = 1,
    exports = [
        "@maven//:com_google_auto_value_auto_value",
    ],
)

