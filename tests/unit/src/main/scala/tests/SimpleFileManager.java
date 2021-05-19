package tests;

import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;

import com.sourcegraph.semanticdb_javac.SemanticdbJavacOptions;

public class SimpleFileManager
    extends ForwardingJavaFileManager<StandardJavaFileManager> {

  public final List<SimpleClassFile> compiled = new ArrayList<>();
  public final Path targetroot;

  protected SimpleFileManager(StandardJavaFileManager fileManager, Path targetroot) {
    super(fileManager);
    this.targetroot = targetroot;
  }

  // standard constructors/getters

  @Override
  public JavaFileObject getJavaFileForOutput(Location location,
                                             String className, JavaFileObject.Kind kind, FileObject sibling) {
    URI uri = targetroot.resolve(className).toUri();
    SimpleClassFile result = new SimpleClassFile(uri);
    if (!className.equals(SemanticdbJavacOptions.stubClassName)) {
      compiled.add(result);
    }
    return result;
  }

}

