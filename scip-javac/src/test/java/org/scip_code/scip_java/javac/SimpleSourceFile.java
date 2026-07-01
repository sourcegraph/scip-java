package org.scip_code.scip_java.javac;

import java.nio.file.Path;
import javax.tools.SimpleJavaFileObject;

public class SimpleSourceFile extends SimpleJavaFileObject {
  private final String content;

  public SimpleSourceFile(Path path, String testSource) {
    super(path.toUri(), Kind.SOURCE);
    content = testSource;
  }

  @Override
  public CharSequence getCharContent(boolean ignoreEncodingErrors) {
    return content;
  }
}
