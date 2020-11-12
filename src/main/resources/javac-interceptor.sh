#!/usr/bin/env sh

if [ -z "$JAVAC_PATH" ]; then
  if [ -z "$JAVA_HOME" ]; then
    readonly JAVAC_PATH="$(command -v javac)"
  else
    readonly JAVAC_PATH="$JAVA_HOME/bin/javac"
  fi
fi

FILENAME=$@

CONTENTS=$(cat "${FILENAME#?}")

BOOTCLASSPATH=$(echo "$CONTENTS" | grep -A 1 "\-bootclasspath")
echo "lsifjava $BOOTCLASSPATH"

CLASSPATH=$(echo "$CONTENTS" | grep -A 1 "\-classpath")
echo "lsifjava $CLASSPATH"

$JAVAC_PATH "$FILENAME"