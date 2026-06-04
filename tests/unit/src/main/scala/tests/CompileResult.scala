package tests

import org.scip_code.scip.Document
import org.scip_code.scip.Index

case class CompileResult(
    byteCode: Array[Byte],
    stdout: String,
    documents: Seq[Document],
    isSuccess: Boolean
) {
  def document: Option[Document] = documents.headOption

  def merge(other: CompileResult): CompileResult = copy(
    byteCode = this.byteCode ++ other.byteCode,
    stdout = this.stdout ++ other.stdout,
    documents = this.documents ++ other.documents,
    isSuccess = this.isSuccess && other.isSuccess
  )
}

object CompileResult {
  val empty: CompileResult = CompileResult(
    Array.emptyByteArray,
    "",
    Seq.empty,
    isSuccess = true
  )

  /**
   * Convenience: builds an empty SCIP {@link Index} from this result's
   * documents.
   */
  def index(documents: Seq[Document]): Index = Index
    .newBuilder()
    .addAllDocuments(
      scala.jdk.CollectionConverters.SeqHasAsJava(documents).asJava
    )
    .build()
}
