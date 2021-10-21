package com.sourcegraph.lsif_protobuf

object Cases {
  private val snakePattern = "_([a-z])".r.pattern
  def snakeCaseToCamelCase(value: String): String = {
    val m = snakePattern.matcher(value)
    val sb = new StringBuffer
    while (m.find()) {
      val replacement = m.group().charAt(1).toUpper + m.group().substring(2)
      m.appendReplacement(sb, replacement)
    }
    m.appendTail(sb)
    sb.toString
  }
}
