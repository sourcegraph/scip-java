package tests

import scala.jdk.CollectionConverters._

import org.scip_code.scip.Document
import org.scip_code.scip.Index

case class CompileResult(
    byteCode: Array[Byte],
    stdout: String,
    documents: List[Document],
    isSuccess: Boolean
) {
  def document: Option[Document] = documents.headOption

  def merge(other: CompileResult): CompileResult = {
    copy(
      byteCode = this.byteCode ++ other.byteCode,
      stdout = this.stdout ++ other.stdout,
      documents = this.documents ++ other.documents,
      isSuccess = this.isSuccess && other.isSuccess
    )
  }
}

object CompileResult {
  val empty: CompileResult = CompileResult(
    Array.emptyByteArray,
    "",
    Nil,
    isSuccess = true
  )

  /** Parses a `*.scip` shard and returns its documents. */
  def documentsFromShard(bytes: Array[Byte]): List[Document] =
    Index.parseFrom(bytes).getDocumentsList.asScala.toList
}
