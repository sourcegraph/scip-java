package tests

import scala.jdk.CollectionConverters._

import com.sourcegraph.Scip

case class CompileResult(
    byteCode: Array[Byte],
    stdout: String,
    documents: List[Scip.Document],
    isSuccess: Boolean
) {
  def document: Option[Scip.Document] = documents.headOption

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

  /**
   * Parses a `*.scip` shard from disk and returns its documents. Shards always
   * have a single document per source file, but we expose the list to keep the
   * call sites uniform when callers compile multiple inputs.
   */
  def documentsFromShard(bytes: Array[Byte]): List[Scip.Document] =
    Scip.Index.parseFrom(bytes).getDocumentsList.asScala.toList
}
