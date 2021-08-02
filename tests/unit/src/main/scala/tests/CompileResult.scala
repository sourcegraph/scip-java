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

  def merge(other: CompileResult): CompileResult = {
    copy(
      byteCode = this.byteCode ++ other.byteCode,
      stdout = this.stdout ++ other.stdout,
      textDocuments = this
        .textDocuments
        .toBuilder
        .addAllDocuments(other.textDocuments.getDocumentsList)
        .build(),
      isSuccess = this.isSuccess && other.isSuccess
    )
  }
}

object CompileResult {
  val empty: CompileResult = CompileResult(
    Array.emptyByteArray,
    "",
    Semanticdb.TextDocuments.getDefaultInstance,
    isSuccess = true
  )
}
