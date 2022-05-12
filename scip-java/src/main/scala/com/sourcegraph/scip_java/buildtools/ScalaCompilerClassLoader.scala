package com.sourcegraph.scip_java.buildtools
// Copied from: https://github.com/scalameta/metals/blob/3c83447ec658f87fdccbfb3f0a39fca1cec4ef6e/metals/src/main/scala/scala/meta/internal/metals/PresentationCompilerClassLoader.scala

/**
 * ClassLoader that is used to reflectively invoke the Scala compiler.
 *
 * The Scala compiler is compiled against the exact Scala versions of the
 * compiler while scip-java is only compiled with Scala 2.13. In order to
 * communicate between scip-java and multiple versions of the compiler, this
 * classloader shares a subset of Java classes that appear in method signatures
 * of the `scala.meta.pc.PresentationCompiler` class.
 */
class ScalaCompilerClassLoader(parent: ClassLoader) extends ClassLoader(null) {
  override def findClass(name: String): Class[_] = {
    val isShared =
      name.startsWith("org.eclipse.lsp4j") || name.startsWith("javax.") ||
        name.startsWith("com.google.gson") || name.startsWith("scala.meta.pc")
    if (isShared) {
      parent.loadClass(name)
    } else {
      throw new ClassNotFoundException(name)
    }
  }
}
