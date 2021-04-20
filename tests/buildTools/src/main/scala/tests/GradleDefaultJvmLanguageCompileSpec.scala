package tests

import java.io.File
import java.util

import scala.jdk.CollectionConverters._

class GradleDefaultJvmLanguageCompileSpec(base: List[String]) {
  def getCompileClasspath: util.List[File] = {
    base.map(new File(_)).asJava
  }
}
