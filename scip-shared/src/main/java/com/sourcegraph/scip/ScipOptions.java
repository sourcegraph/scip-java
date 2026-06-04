package com.sourcegraph.scip;

import java.nio.file.Path;

/** Settings shared between all SCIP-emitting compiler plugins. */
public class ScipOptions {
  public Path sourceroot;
  public Path targetroot;
  public boolean includeText = false;
  public NoRelativePathMode noRelativePath = NoRelativePathMode.INDEX_ANYWAY;
  public UriScheme uriScheme = UriScheme.DEFAULT;
}
