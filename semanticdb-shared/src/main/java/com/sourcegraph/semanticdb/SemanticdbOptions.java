package com.sourcegraph.semanticdb;

import java.nio.file.Path;

/** Settings shared between all SemanticDB-emitting compiler plugins. */
public class SemanticdbOptions {
  public Path sourceroot;
  public Path targetroot;
  public boolean includeText = false;
  public NoRelativePathMode noRelativePath = NoRelativePathMode.INDEX_ANYWAY;
  public UriScheme uriScheme = UriScheme.DEFAULT;
}
