"""Java rules that automatically register the SemanticDB compiler plugin based on the presence of a string flag."""
load("@rules_java//java:defs.bzl", native_java_library="java_library", native_java_binary="java_binary")

def java_library(javacopts=[], plugins=[],**kwargs):
    native_java_library(
	    javacopts=_actual_javacopts(javacopts),
	    plugins=_actual_plugins(plugins),
	    **kwargs)


def java_binary(javacopts=[], plugins=[],**kwargs):
    native_java_binary(
	    javacopts=_actual_javacopts(javacopts),
	    plugins=_actual_plugins(plugins),
	    **kwargs)

def _actual_javacopts(javacopts):
    return select({
        "@scip_java//semanticdb-javac:is_enabled": ["'-Xplugin:semanticdb -build-tool:bazel'"] + javacopts,
        "//conditions:default": javacopts,
    })

def _actual_plugins(plugins):
    return select({
        "@scip_java//semanticdb-javac:is_enabled": ["@scip_java//semanticdb-javac:plugin"] + plugins,
        "//conditions:default": plugins,
    })
