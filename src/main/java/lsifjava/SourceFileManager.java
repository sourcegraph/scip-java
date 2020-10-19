package lsifjava;

import com.sun.tools.javac.file.JavacFileManager;
import com.sun.tools.javac.util.Context;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.tools.*;

public class SourceFileManager extends JavacFileManager {
    private final Set<Path> paths;
    SourceFileManager(Set<Path> paths) {
        super(new Context(), false, Charset.defaultCharset());
        this.paths = paths;
    }

    @Override
    public Iterable<JavaFileObject> list(
            Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
        if (location == StandardLocation.SOURCE_PATH) {

            final Stream<JavaFileObject> sourceFileObjectStream = list(packageName);
            return sourceFileObjectStream::iterator;
        } else {
            return super.list(location, packageName, kinds, recurse);
        }
    }

    private Stream<JavaFileObject> list(String packageName) {
        return paths.stream().map(path -> {
            try {
                return new SourceFileObject(path);
            } catch(IOException e) {
                return null;
            }
        }).filter(obj -> packageName(obj).equals(packageName)).map(obj -> obj);
    }
    
    static String packageName(SourceFileObject file) {
        var packagePattern = Pattern.compile("^package +(.*);");
        var startOfClass = Pattern.compile("^[\\w ]*class +\\w+");
        var lines = file.contents.lines().iterator();
        for (var line = lines.next(); line != null; line = lines.next()) {
            if (startOfClass.matcher(line).find()) return "";
            var matchPackage = packagePattern.matcher(line);
            if (matchPackage.matches()) {
                return matchPackage.group(1);
            }
        }
        // TODO fall back on parsing file
        return "";
    }

    private JavaFileObject asJavaFileObject(Path file) throws IOException {
        // TODO erase method bodies of files that are not open
        return new SourceFileObject(file);
    }

    @Override
    public String inferBinaryName(Location location, JavaFileObject file) {
        if (location == StandardLocation.SOURCE_PATH) {
            var source = (SourceFileObject) file;
            var packageName = packageName(source);
            var className = removeExtension(source.path.getFileName().toString());
            if (!packageName.isEmpty()) className = packageName + "." + className;
            return className;
        } else {
            return super.inferBinaryName(location, file);
        }
    }

    private String removeExtension(String fileName) {
        var lastDot = fileName.lastIndexOf(".");
        return (lastDot == -1 ? fileName : fileName.substring(0, lastDot));
    }

    @Override
    public boolean hasLocation(Location location) {
        return location == StandardLocation.SOURCE_PATH || super.hasLocation(location);
    }

    @Override
    public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
        // FileStore shadows disk
        if (location == StandardLocation.SOURCE_PATH) {
            if (className.equals("module-info")) return null;
            var packageName = mostName(className);
            var simpleClassName = lastName(className);
            Iterator<SourceFileObject> iterator = list(packageName).map(obj -> (SourceFileObject)obj).iterator();
            for (var f = iterator.next(); iterator.hasNext(); f = iterator.next()) {
                if (f.path.getFileName().toString().equals(simpleClassName + kind.extension)) {
                    return f;
                }
            }
            // Fall through to disk in case we have .jar or .zip files on the source path
        }
        return super.getJavaFileForInput(location, className, kind);
    }

    // TODO this doesn't work for inner classes, eliminate
    static String mostName(String name) {
        var lastDot = name.lastIndexOf('.');
        return lastDot == -1 ? "" : name.substring(0, lastDot);
    }

    // TODO this doesn't work for inner classes, eliminate
    static String lastName(String name) {
        int i = name.lastIndexOf('.');
        if (i == -1) return name;
        else return name.substring(i + 1);
    }

    @Override
    public FileObject getFileForInput(Location location, String packageName, String relativeName) throws IOException {
        if (location == StandardLocation.SOURCE_PATH) {
            return null;
        }
        return super.getFileForInput(location, packageName, relativeName);
    }

    @Override
    public boolean contains(Location location, FileObject file) throws IOException {
        if (location == StandardLocation.SOURCE_PATH) {
            var source = (SourceFileObject) file;
            return paths.contains(source.path);
        } else {
            return super.contains(location, file);
        }
    }

    private static final Logger LOG = Logger.getLogger("main");
}
