package tests

import scala.jdk.CollectionConverters._

class GradleOptionsBuilder(base: List[String]) {
  def build(): java.util.List[String] = base.asJava
}
