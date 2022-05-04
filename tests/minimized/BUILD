load("//semanticdb-javac:defs.bzl", "java_library")

package(
    default_visibility = ["//visibility:public"],
)

java_library(
	name = "minimized",
	srcs = glob(["src/main/java/minimized/*.java"]),
	deps = [
		"@maven//:org_projectlombok_lombok",
	],
)
