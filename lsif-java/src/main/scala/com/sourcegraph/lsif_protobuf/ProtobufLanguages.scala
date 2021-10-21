package com.sourcegraph.lsif_protobuf

class ProtobufLanguages(command: List[String]) {
  val isJavaEnabled = command.exists(_.startsWith("--java_out"))
}
