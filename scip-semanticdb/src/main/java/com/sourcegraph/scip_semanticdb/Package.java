package com.sourcegraph.scip_semanticdb;

public abstract class Package {
  public static final Package EMPTY =
      new Package() {
        @Override
        public String repoName() {
          return ".";
        }

        @Override
        public String version() {
          return ".";
        }
      };

  public abstract String repoName();

  public abstract String version();

  public final String scipTypedEncoding() {
    return "maven " + encode(repoName()) + " " + encode(version());
  }

  private String encode(String value) {
    if (value.contains(" ")) {
      return "`" + value + "`";
    }
    return value;
  }
}
