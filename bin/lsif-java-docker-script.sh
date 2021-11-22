#!/usr/bin/env bash
# Wrapper script for `lsif-java`, which automatically picks up the correct JVM
# version. It assumes that `coursier` is available on the `$PATH` and that the
# `lsif-java` binary is already installed at `/app/lsif-java/bin/lsif-java`.
set -eu
JVM_VERSION="8"
FILE="$PWD/lsif-java.json"
if test -f "$FILE"; then
	FROM_CONFIG=$(jq -r '.jvm' "$FILE")
	if [ "$FROM_CONFIG" != "null" ]; then
		JVM_VERSION="$FROM_CONFIG"
	fi
fi
if [ "$JVM_VERSION" = "17" ]; then
	JVM_VERSION="temurin:17"
fi

echo "Using JVM version '$JVM_VERSION'"
eval "$(coursier java --jvm "$JVM_VERSION" --env --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json)"

if [ "$JVM_VERSION" = "17" ]; then
	export JAVA_OPTS="--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
fi

/app/lsif-java/bin/lsif-java "$@"
