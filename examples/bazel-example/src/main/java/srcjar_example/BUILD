genrule(
    name = "generated-srcjar",
    outs = ["sources.srcjar"],
    cmd = "echo 'package com.testing; public class Bar {};' > Bar.java && jar cf $(@) Bar.java",
)

genrule(
    name = "empty-srcjar",
    outs = ["empty.srcjar"],
    cmd = "touch test.txt && zip $(@) test.txt && zip -d $(@) test.txt",
)

java_library(
    name = "testing",
    srcs = [
        "Foo.java",
        ":generated-srcjar",
        ":empty-srcjar"
    ],
)

java_library(
    name = "other_library",
    srcs = [
        "Baz.java", # create a new file in source at test/Baz.java, alongside test/Foo.java
        ":generated-srcjar",
    ],
)

java_test(
    name = "testing_test",
    srcs = [
        "Foo.java",
        ":generated-srcjar",
    ],
    test_class = "Foo",
)
