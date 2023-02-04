#!/usr/bin/env bash
# Wrapper script for `scip-java`, which automatically picks up the correct JVM
# version. It assumes that `coursier` is available on the `$PATH` and that the
# `scip-java` binary is already installed at `/app/scip-java/bin/scip-java`.
set -eu
JVM_VERSION="${JVM_VERSION:-17}"
FILE="$PWD/lsif-java.json"
if test -f "$FILE"; then
	FROM_CONFIG=$(jq -r '.jvm' "$FILE")
	if [ "$FROM_CONFIG" != "null" ]; then
		JVM_VERSION="$FROM_CONFIG"
	fi
fi

echo "Using JVM version '$JVM_VERSION'"

if [ "$JVM_VERSION" = "17" ]; then
  export JAVA_OPTS="--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
  # No need to download Java 17 because it's pre-installed.
else
  eval "$(coursier java --jvm "$JVM_VERSION" --env --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json)"
fi

/app/scip-java/bin/scip-java "$@"
