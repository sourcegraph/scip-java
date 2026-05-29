package com.sourcegraph.scip_semanticdb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class JdkPackage extends Package {
  public final String version;

  public JdkPackage(String version) {
    this.version = version;
  }

  /** Returns a {@link JdkPackage} for the currently running JVM. */
  public static JdkPackage forRuntime() {
    return new JdkPackage(Integer.toString(Runtime.version().feature()));
  }

  /** Parses a {@code java.version}-style string, keeping only the major version. */
  public static JdkPackage parse(String version) {
    int dot = version.indexOf('.');
    return new JdkPackage(dot < 0 ? version : version.substring(0, dot));
  }

  /**
   * Reads the JDK version from the major version field of a classfile (bytes 6-7, big endian)
   * mapped via {@code major - 44}. Returns empty if the file is not a valid classfile.
   */
  public static Optional<JdkPackage> fromClassfile(Path classfile) {
    try (InputStream in = Files.newInputStream(classfile)) {
      return fromHeader(in.readNBytes(8));
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  /**
   * Walks {@code directory} (depth-bounded) for any {@code .class} file and returns the JDK
   * version inferred from its major version field. Skips multi-release classfiles under
   * {@code META-INF/versions/} so the result reflects the base bytecode target when walking
   * a jar mounted as a {@link FileSystem}. Returns empty if the directory does not exist or
   * contains no valid classfile.
   */
  public static Optional<JdkPackage> fromDirectory(Path directory, int maxDepth) {
    if (directory == null || !Files.isDirectory(directory)) return Optional.empty();
    try (Stream<Path> stream = Files.walk(directory, maxDepth)) {
      return stream
          .filter(p -> p.getFileName() != null && p.getFileName().toString().endsWith(".class"))
          .filter(p -> !p.toString().replace('\\', '/').contains("/META-INF/versions/"))
          .map(JdkPackage::fromClassfile)
          .flatMap(Optional::stream)
          .findFirst();
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  /**
   * Reads the JDK version from the first regular {@code .class} entry of a jar file by mounting
   * it as a {@link FileSystem} and reusing {@link #fromDirectory}.
   */
  public static Optional<JdkPackage> fromJar(Path jar) {
    if (jar == null || !Files.isRegularFile(jar)) return Optional.empty();
    URI uri = URI.create("jar:" + jar.toUri());
    try (FileSystem fs = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
      return fromDirectory(fs.getPath("/"), Integer.MAX_VALUE);
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  /**
   * Convenience dispatch: detects whether {@code path} is a jar, classfile, or directory and
   * delegates to the appropriate reader.
   */
  public static Optional<JdkPackage> fromPath(Path path) {
    if (path == null) return Optional.empty();
    if (Files.isDirectory(path)) return fromDirectory(path, 64);
    if (!Files.isRegularFile(path)) return Optional.empty();
    String name = path.getFileName().toString();
    if (name.endsWith(".jar")) return fromJar(path);
    if (name.endsWith(".class")) return fromClassfile(path);
    return Optional.empty();
  }

  private static Optional<JdkPackage> fromHeader(byte[] header) {
    if (header.length < 8) return Optional.empty();
    ByteBuffer buf = ByteBuffer.wrap(header);
    if (buf.getInt(0) != 0xCAFEBABE) return Optional.empty();
    int major = Short.toUnsignedInt(buf.getShort(6));
    if (major < 45) return Optional.empty();
    return Optional.of(new JdkPackage(Integer.toString(major - 44)));
  }

  @Override
  public String repoName() {
    return "jdk";
  }

  @Override
  public String version() {
    return version;
  }

  @Override
  public String toString() {
    return "JdkPackage{" + "version='" + version + '\'' + '}';
  }
}
