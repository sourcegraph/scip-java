package com.sourcegraph.scip_semanticdb;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageTable {

  private final Map<String, Package> byClassfile = new HashMap<>();
  private final Set<String> cachedJdkSymbols = new HashSet<>();
  private final JavaVersion javaVersion;
  private final boolean indexDirectoryEntries;

  private static final PathMatcher CLASS_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.class");
  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");

  public PackageTable(ScipSemanticdbOptions options) throws IOException {
    this.javaVersion = new JavaVersion();
    this.indexDirectoryEntries = options.allowExportingGlobalSymbolsFromDirectoryEntries;
    // NOTE: it's important that we index the JDK before maven packages. Some maven packages
    // redefine classes from the JDK and we want those maven packages to take precedence over
    // the JDK. The motivation to prioritize maven packages over the JDK is that we only want
    // to exports monikers against the JDK when indexing the JDK repo.
    indexJdk();
    for (MavenPackage pkg : options.packages) {
      indexPackage(pkg);
    }
  }

  public Optional<Package> packageForSymbol(String symbol) {
    return SymbolDescriptor.toplevel(symbol)
        .flatMap(
            toplevel -> {
              String classfile = toplevel.owner + toplevel.descriptor.name + ".class";
              return packageForClassfile(classfile);
            });
  }

  private Optional<Package> packageForClassfile(String classfile) {

    Package result = byClassfile.get(classfile);
    if (result != null) return Optional.of(result);
    if (!javaVersion.isJava8 && isJrtClassfile(classfile)) return Optional.of(javaVersion.pkg);
    return Optional.empty();
  }

  private void indexPackage(MavenPackage pkg) throws IOException {
    if (JAR_PATTERN.matches(pkg.jar) && Files.isRegularFile(pkg.jar)) {
      indexJarFile(pkg.jar, pkg);
    } else if (this.indexDirectoryEntries && Files.isDirectory(pkg.jar)) {
      indexDirectoryPackage(pkg);
    }
  }

  private void indexDirectoryPackage(MavenPackage pkg) throws IOException {
    Files.walkFileTree(
        pkg.jar,
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
              throws IOException {
            if (CLASS_PATTERN.matches(file)) {
              String classfile = pkg.jar.relativize(file).toString();
              if (!classfile.contains("$")) {
                byClassfile.put(classfile, pkg);
              }
            }
            return super.visitFile(file, attrs);
          }
        });
  }

  private void indexJarFile(Path file, Package pkg) throws IOException {
    try (JarFile jar = new JarFile(file.toFile())) {
      Enumeration<JarEntry> entries = jar.entries();
      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        if (entry.getName().endsWith(".class") && !entry.getName().contains("$")) {
          byClassfile.put(entry.getName(), pkg);
        }
      }
    }
  }

  private void indexJdk() throws IOException {
    if (javaVersion.isJava8) {
      indexBootstrapClasspath();
    }
  }

  /**
   * The JRT classpath contains classfiles for the JDK for Java versions 9+.
   *
   * <p>The JRT classpath isn't a jar file on disk, it needs to be read from an internal file system
   * under the URL "jrt:/".
   */
  private boolean isJrtClassfile(String classfile) {
    if (cachedJdkSymbols.contains(classfile)) return true;
    URL resource = getClass().getResource("/" + classfile);
    boolean isJrt = resource != null && "jrt".equals(resource.getProtocol());
    if (isJrt) {
      cachedJdkSymbols.add(classfile);
    }
    return isJrt;
  }

  /**
   * The boot classpath contains jar files for the JDK in Java 8.
   *
   * <p>The bootclasspath is normal jar files on disk that can live under $JAVA_HOME.
   */
  private void indexBootstrapClasspath() throws IOException {
    for (Object keyObject : System.getProperties().keySet()) {
      Package jdk = new JdkPackage("8");
      if (!(keyObject instanceof String)) continue;
      String key = (String) keyObject;
      if (!key.endsWith(".boot.class.path")) continue;
      String value = System.getProperty(key);
      for (String entry : value.split(File.pathSeparator)) {
        Path path = Paths.get(entry);
        if (JAR_PATTERN.matches(path) && Files.isRegularFile(path)) {
          indexJarFile(path, jdk);
        }
      }
    }
  }
}
