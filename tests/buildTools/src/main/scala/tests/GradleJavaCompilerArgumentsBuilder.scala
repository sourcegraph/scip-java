package tests

import scala.jdk.CollectionConverters._

class GradleJavaCompilerArgumentsBuilder(base: List[String]) {
  def build(): java.util.List[String] = base.asJava
}
