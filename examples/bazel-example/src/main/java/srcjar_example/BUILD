genrule(
    name = "generated-srcjar",
    outs = ["sources.srcjar"],
    cmd = "echo 'package com.testing; public class Bar {};' > Bar.java && jar cf $(@) Bar.java",
)

java_library(
    name = "testing",
    srcs = [
        "Foo.java",
        ":generated-srcjar",
    ],
)
