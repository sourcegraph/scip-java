#!/usr/bin/env bash
# Wrapper script for `scip-java`, which automatically picks up the correct JVM
# version. It assumes that `coursier` is available on the `$PATH` and that the
# `scip-java` binary is already installed at `/app/scip-java/bin/scip-java`.
set -eu
JVM_VERSION="${JVM_VERSION:-17,11,8}"
FILE="$PWD/lsif-java.json"
if test -f "$FILE"; then
	FROM_CONFIG=$(jq -r '.jvm' "$FILE")
	if [ "$FROM_CONFIG" != "null" ]; then
		JVM_VERSION="$FROM_CONFIG"
	fi
fi

JVM_VERSIONS=$(echo $JVM_VERSION | tr "," "\n")

LAST_CODE="-1"

ARGS=$@

for JVM_VERSION in $JVM_VERSIONS
do 
	if [ "$LAST_CODE" != "0" ]; then
		echo "Using JVM version '$JVM_VERSION'"

		if [ "$JVM_VERSION" = "17" ]; then
			export JAVA_OPTS="--add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.code=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.model=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED --add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED"
		else
			export JAVA_OPTS=""
		fi

		eval "$(coursier java --jvm "$JVM_VERSION" --env --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json)"

		java -version
		if /app/scip-java/bin/scip-java "$@"; then 
			LAST_CODE="0"
		else 
			LAST_CODE=$?
		fi

	fi
done

exit $LAST_CODE
