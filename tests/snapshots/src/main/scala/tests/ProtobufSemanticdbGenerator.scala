package tests

import scala.jdk.CollectionConverters._

import scala.meta.io.AbsolutePath

import com.sourcegraph.lsif_semanticdb.SymbolDescriptor
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols

class ProtobufSemanticdbGenerator extends SnapshotGenerator {
  def run(context: SnapshotContext, handler: SnapshotHandler): Unit = {
    handler.onSnapshotTest(
      context,
      context.expectDirectory.resolve("protobuf-missing-symbols.txt"),
      () => {
        val sourceroot = AbsolutePath(BuildInfo.sourceroot)
        val targetroot = AbsolutePath(BuildInfo.minimizedProtobufTargetroot)
        val protobufDocuments = SemanticdbFile.fromProtobuf(
          AbsolutePath(BuildInfo.minimizedProtobufSourceDirectory),
          sourceroot,
          targetroot
        )
        val javaDocuments = SemanticdbFile.fromDirectory(
          AbsolutePath(BuildInfo.minimizedProtobufGeneratedSourceDirectory),
          sourceroot,
          targetroot
        )
        val isGeneratedJavaSymbol = publicSymbols(javaDocuments)
        val isProtobufSymbol = definitionSymbols(protobufDocuments)
        val missingProtobufSymbols = isGeneratedJavaSymbol -- isProtobufSymbol
        val redundantProtobufSymbols = isProtobufSymbol -- isGeneratedJavaSymbol
        val out = new StringBuilder()
        if (missingProtobufSymbols.nonEmpty) {
          out
            .append("=========================\n")
            .append("Missing Protobuf symbols:\n")
            .append("=========================\n")
            .append(
              missingProtobufSymbols.toSeq.sorted.mkString("", "\n", "\n")
            )
        }
        if (redundantProtobufSymbols.nonEmpty) {
          out
            .append("===========================\n")
            .append("Redundant Protobuf symbols:\n")
            .append("===========================\n")
            .append(
              redundantProtobufSymbols.toSeq.sorted.mkString("", "\n", "\n")
            )
        }
        out.toString()
      }
    )
    handler.onFinished(context)
  }

  def definitionSymbols(files: Seq[SemanticdbFile]): Set[String] = {
    (
      for {
        file <- files.iterator
        occ <- file.textDocument.getOccurrencesList().asScala.iterator
        if occ.getRole() == Role.DEFINITION
      } yield occ.getSymbol()
    ).toSet
  }

  def publicSymbols(files: Seq[SemanticdbFile]): Set[String] = {
    (
      for {
        file <- files.iterator
        symbol <- file.textDocument.getSymbolsList().asScala.iterator
        if SemanticdbSymbols.isGlobal(symbol.getSymbol())
        if !isPrivate(symbol)
        if symbol.getKind() != SymbolInformation.Kind.PACKAGE
        if !isGenericProtobufSymbol(symbol)
      } yield symbol.getSymbol()
    ).toSet
  }

  val genericProtobufNames = Set[String](
    "writeTo",
    "registerAllExtensions",
    "valueOf",
    "setField",
    "setRepeatedField",
    "getNumber",
    "getValueDescriptor",
//     "UNKNOWN_VALUE",
    "UNRECOGNIZED",
    "clearOneof",
    "clearField",
    "forNumber",
    "build",
    "buildPartial",
    "clear",
    "mergeFrom",
    "parseFrom",
    "parseDelimitedFrom",
    "addRepeatedField",
    "getUnknownFields",
    "setUnknownFields",
    "hashCode",
    "equals",
    "getDefaultInstanceForType",
    "getDefaultInstance",
    "toBuilder",
    "newBuilderForType",
    "newBuilder",
    "newInstance",
    "mergeUnknownFields",
    "isInitialized",
    "clone",
    "oneOf",
    "getDescriptor",
    "getDescriptorForType",
    "internalGetFieldAccessorTable",
    "internalGetValueMap",
    "getParserForType",
    "parser",
    "getSerializedSize"
  )

  private def isGenericProtobufSymbol(symbol: SymbolInformation): Boolean = {
    val sym = SymbolDescriptor.parseFromSymbol(symbol.getSymbol())
    genericProtobufNames.contains(sym.descriptor.name)
  }
  private def isPrivate(symbol: SymbolInformation): Boolean = {
    symbol.getAccess.hasPrivateAccess() ||
    symbol.getAccess.hasPrivateThisAccess() ||
    symbol.getAccess.hasPrivateWithinAccess()
  }
}
