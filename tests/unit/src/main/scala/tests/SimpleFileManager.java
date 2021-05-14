package tests;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;

import com.sourcegraph.semanticdb_javac.SemanticdbJavacOptions;

public class SimpleFileManager
    extends ForwardingJavaFileManager<StandardJavaFileManager> {

  public List<SimpleClassFile> compiled = new ArrayList<>();

  protected SimpleFileManager(StandardJavaFileManager fileManager) {
    super(fileManager);
  }

  // standard constructors/getters

  @Override
  public JavaFileObject getJavaFileForOutput(Location location,
                                             String className, JavaFileObject.Kind kind, FileObject sibling) {
    SimpleClassFile result = new SimpleClassFile(
        URI.create("string://" + className));
    if (!className.equals(SemanticdbJavacOptions.stubClassName)) {
      compiled.add(result);
    }
    return result;
  }

}

