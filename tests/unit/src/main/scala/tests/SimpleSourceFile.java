package tests;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;
import java.nio.file.Path;

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
