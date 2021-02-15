package tests

import com.sourcegraph.semanticdb_javac.Semanticdb

case class CompileResult(
    byteCode: Array[Byte],
    stdout: String,
    textDocuments: Semanticdb.TextDocuments,
    isSuccess: Boolean
) {
  def textDocument: Semanticdb.TextDocument = {
    textDocuments.getDocuments(0)
  }
}
