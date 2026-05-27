#!/usr/bin/env bash
# Wrapper script for `scip-java`, which automatically picks up the correct JVM
# version. It assumes that `coursier` is available on the `$PATH` and that the
# `scip-java` binary is already installed at `/app/scip-java/bin/scip-java`.
set -eu
JVM_VERSION="${JVM_VERSION:-21,17,11,8}"

JVM_VERSIONS=$(echo "$JVM_VERSION" | tr "," "\n")

LAST_CODE="-1"

for JVM_VERSION in $JVM_VERSIONS
do 
	if [ "$LAST_CODE" != "0" ]; then
		echo "Using JVM version '$JVM_VERSION'"

		if [ "$JVM_VERSION" = "17" ] || [ "$JVM_VERSION" = "21" ]; then
			export JAVA_OPTS="--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
		else
			export JAVA_OPTS=""
		fi
		eval "$(coursier java --jvm "$JVM_VERSION" --env --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json)"

		java -version
		if /app/scip-java "$@"; then 
			LAST_CODE="0"
		else 
			LAST_CODE=$?
		fi

	fi
done

exit $LAST_CODE
