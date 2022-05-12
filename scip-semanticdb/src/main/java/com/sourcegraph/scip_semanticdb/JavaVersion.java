package com.sourcegraph.scip_semanticdb;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Enumeration;
import java.util.Optional;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JavaVersion {
  public final boolean isJava8;
  public final JdkPackage pkg;
  private static final PathMatcher CLASS_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.class");
  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");

  public static final int JAVA8_VERSION = 8;
  public static final int JAVA11_VERSION = 11;
  public static final int JAVA17_VERSION = 17;
  public static final int DEFAULT_JAVA_VERSION = JAVA8_VERSION;

  @SuppressWarnings("FieldCanBeLocal")
  private static final int JAVA0_MAJOR_VERSION = 44;

  public JavaVersion() {
    this(System.getProperty("java.version"));
  }

  public JavaVersion(String version) {
    isJava8 = version.startsWith("1.8");
    pkg = new JdkPackage(isJava8 ? "8" : javaVersion(version));
  }

  private String javaVersion(String version) {
    if (version.startsWith("1.8")) return "8";
    String[] parts = version.split("\\.");
    if (parts.length > 0) return parts[0];
    else return version;
  }

  @SuppressWarnings("ManualMinMaxCalculation")
  public static int roundToNearestStableRelease(int version) {
    if (version <= JAVA8_VERSION) return JAVA8_VERSION;
    if (version <= JAVA11_VERSION) return JAVA11_VERSION;
    if (version <= JAVA17_VERSION) return JAVA17_VERSION;
    return version;
  }

  /**
   * Return the JVM version of the given jar/class file.
   *
   * <p>The JVM version is determined by reading the 5-8th bytes of classfiles, according to the
   * Java Language spec. See
   * https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.1
   *
   * @return the JVM version such as <code>8</code> for Java 8 and <code>11</code> for Java 11.
   */
  public static Optional<Integer> classfileJvmVersion(Path file) {
    try {
      int major = classfileMajorVersion(file);
      return major < 0 ? Optional.empty() : Optional.of(major - JAVA0_MAJOR_VERSION);
    } catch (IOException e) {
      return Optional.empty();
    }
  }

  private static int classfileMajorVersion(Path file) throws IOException {
    if (CLASS_PATTERN.matches(file)) {
      return classfileMajorVersion(Files.newInputStream(file));
    } else if (JAR_PATTERN.matches(file)) {
      try (JarFile jar = new JarFile(file.toFile())) {
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
          JarEntry entry = entries.nextElement();
          if (entry.getName().endsWith(".class")) {
            return classfileMajorVersion(jar.getInputStream(entry));
          }
        }
      }
    }

    return -1;
  }

  private static int classfileMajorVersion(InputStream classfileBytes) throws IOException {
    DataInputStream in = new DataInputStream(classfileBytes);
    // See https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-4.html#jvms-4.1
    int magic = in.readInt(); // u4 magic
    if (magic != 0xCAFEBABE) return -1;
    in.readUnsignedShort(); // u2 minor_version
    return in.readUnsignedShort(); // u2 major_version
  }
}
