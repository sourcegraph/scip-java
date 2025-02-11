package com.sourcegraph.scip_java.commands

case class CommentSyntax(value: String) {
  private val map =
    value
      .split("\\s+")
      .map(_.split(","))
      .collect { case Array(a, b) =>
        a -> b
      }
      .toMap
  def extensionSyntax(fileExtension: String): String =
    map.getOrElse(fileExtension, "//")
}
object CommentSyntax {
  val default = CommentSyntax("py,# sql,-- yaml,# yml,#")
  implicit val codec: moped.json.JsonCodec[com.sourcegraph.scip_java.commands.CommentSyntax] = moped.macros.deriveCodec(default)
}
