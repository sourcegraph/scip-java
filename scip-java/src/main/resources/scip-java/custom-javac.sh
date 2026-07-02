#!/usr/bin/env bash
set -eu

: "${SCIP_ERRORPATH:?}"
: "${SCIP_JAVAC_LAUNCHER_JVM_OPTIONS:?}"
: "${SCIP_JAVAC_OPTIONS_PREFIX:?}"
: "${SCIP_OLD_JAVAC_OPTS:?}"
: "${SCIP_PLUGINPATH:?}"
: "${SCIP_SOURCEROOT:?}"
: "${SCIP_TARGETROOT:?}"

LAUNCHER_ARGS=()
JAVAC_JVM_OPTIONS=()
while IFS= read -r option; do
  if [[ -n "$option" ]]; then
    JAVAC_JVM_OPTIONS+=("$option")
  fi
done <<< "$SCIP_JAVAC_LAUNCHER_JVM_OPTIONS"
NEW_JAVAC_OPTS="$SCIP_JAVAC_OPTIONS_PREFIX-$RANDOM"

for arg in "$@"; do
  if [[ $arg == -J* ]]; then
    LAUNCHER_ARGS+=("$arg")
  fi
done

java \
  "-Dscip.errorpath=$SCIP_ERRORPATH" \
  "-Dscip.pluginpath=$SCIP_PLUGINPATH" \
  "-Dscip.sourceroot=$SCIP_SOURCEROOT" \
  "-Dscip.targetroot=$SCIP_TARGETROOT" \
  -Dscip.output="$NEW_JAVAC_OPTS" \
  "-Dscip.old-output=$SCIP_OLD_JAVAC_OPTS" \
  -classpath "$SCIP_PLUGINPATH" \
  org.scip_code.scip_java.javac.InjectScipOptions \
  "$@"

javac "${JAVAC_JVM_OPTIONS[@]}" "@$NEW_JAVAC_OPTS" "${LAUNCHER_ARGS[@]}"
