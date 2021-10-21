package com.sourcegraph.lsif_protobuf

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import scala.annotation.tailrec
import scala.jdk.CollectionConverters._

import com.google.protobuf.DescriptorProtos.DescriptorProto
import com.google.protobuf.DescriptorProtos.EnumDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorProto
import com.google.protobuf.DescriptorProtos.FileDescriptorSet
import com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location
import com.sourcegraph.semanticdb_javac.MD5
import com.sourcegraph.semanticdb_javac.Semanticdb
import com.sourcegraph.semanticdb_javac.Semanticdb.Language
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocument
import com.sourcegraph.semanticdb_javac.Semanticdb.TextDocuments
import moped.reporters.Reporter

class LsifProtobuf(
    sourceroot: Path,
    protocOptions: List[String],
    reporter: Reporter
) {
  private val protoPath: List[Path] =
    for {
      option <- protocOptions
      path <-
        option match {
          case s"-I$path" =>
            Some(path)
          case s"--proto_path=$path" =>
            Some(path)
          case _ =>
            None
        }
    } yield Paths.get(path)

  def textDocuments(): TextDocuments = {
    val documents =
      for {
        descriptorSet <- fileDescriptorSet().toList
        doc <- textDocumentsFromFileDescriptorSet(descriptorSet)
      } yield doc
    TextDocuments.newBuilder().addAllDocuments(documents.asJava).build()
  }

  private def textDocumentsFromFileDescriptorSet(
      value: FileDescriptorSet
  ): Iterable[TextDocument] = {
    for {
      file <- value.getFileList.asScala
      path <- resolveAbsolutePath(file)
      if path.startsWith(sourceroot) ||
        reportWarning(s"ignoring non-sourceroot path: $path")
    } yield {
      val symtab = new ProtobufSymtab(file)
      val relativePath = sourceroot.relativize(path)
      val text = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
      val md5 = MD5.digest(text)
      val occurrences =
        for {
          location <- file.getSourceCodeInfo.getLocationList.asScala
          occ <- locationToOccurrence(symtab, file, location)
        } yield occ
      TextDocument
        .newBuilder()
        .setUri(relativePath.iterator().asScala.mkString("/"))
        .setMd5(md5)
        .setText(text)
        .setLanguage(Language.PROTOBUF)
        .addAllOccurrences(javaOuterClassOccurrences(symtab, file).asJava)
        .addAllOccurrences(occurrences.asJava)
        .build()
    }
  }

  private def javaOuterClassOccurrences(
      symtab: ProtobufSymtab,
      file: FileDescriptorProto
  ): List[SymbolOccurrence] = {
    new ProtobufSymbolBuilder(protocOptions, symtab, file)
      .buildOuterClassSymbol()
      .map { outerClassSymbol =>
        SymbolOccurrence
          .newBuilder()
          .setSymbol(outerClassSymbol)
          .setRole(SymbolOccurrence.Role.DEFINITION)
          .setRange(
            Semanticdb
              .Range
              .newBuilder()
              .setStartLine(0)
              .setStartCharacter(0)
              .setEndLine(0)
              .setEndCharacter(0)
          )
          .build()
      }
  }

  private def locationToOccurrence(
      symtab: ProtobufSymtab,
      file: FileDescriptorProto,
      location: Location
  ): Iterable[SymbolOccurrence] = {
    if (location.getSpanCount() != 3 && location.getSpanCount() != 4) {
      return Nil
    }
    val spans = location.getSpanList
    val range = Semanticdb
      .Range
      .newBuilder()
      .setStartLine(spans.get(0))
      .setStartCharacter(spans.get(1))
      .setEndLine(
        if (location.getSpanCount == 3)
          spans.get(0)
        else
          spans.get(2)
      )
      .setEndCharacter(
        if (location.getSpanCount == 3)
          spans.get(2)
        else
          spans.get(3)
      )

    val symbol = new ProtobufSymbolBuilder(protocOptions, symtab, file)
    @tailrec
    def loop(path: List[Int]): List[SymbolOccurrence] =
      path match {
        case symbol.Package(
              proto,
              FileDescriptorProto.MESSAGE_TYPE_FIELD_NUMBER :: index :: tail
            ) =>
          symbol.addMessage(proto.getMessageType(index))
          loop(tail)
        case symbol.Message(
              proto,
              DescriptorProto.NESTED_TYPE_FIELD_NUMBER :: index :: tail
            ) =>
          symbol.addMessage(proto.getNestedType(index))
          loop(tail)
        case symbol.Message(
              proto,
              DescriptorProto.FIELD_FIELD_NUMBER :: index :: tail
            ) =>
          symbol.addField(proto.getField(index))
          loop(tail)
        case symbol.Message(
              proto,
              DescriptorProto.ENUM_TYPE_FIELD_NUMBER :: index :: tail
            ) =>
          symbol.addEnum(proto.getEnumType(index))
          loop(tail)
        case symbol.Enum(
              proto,
              EnumDescriptorProto.VALUE_FIELD_NUMBER :: index :: tail
            ) =>
          symbol.addEnumValue(proto.getValue(index))
          loop(tail)
        case DescriptorProto.NAME_FIELD_NUMBER :: Nil =>
          symbol
            .build()
            .map { sym =>
              SymbolOccurrence
                .newBuilder()
                .setSymbol(sym)
                .setRole(SymbolOccurrence.Role.DEFINITION)
                .setRange(range)
                .build()
            }
        case _ =>
          Nil
      }
    loop(location.getPathList.iterator().asScala.map(_.toInt).toList)
  }

  private def resolveAbsolutePath(file: FileDescriptorProto): Option[Path] = {
    for {
      dir <- protoPath
      path = dir.resolve(file.getName)
      if Files.isRegularFile(path)
    } yield path
  }.headOption

  private def reportWarning(message: String): Boolean = {
    reporter.warning(message)
    false
  }

  private def fileDescriptorSet(): Option[FileDescriptorSet] = {
    for {
      s"--descriptor_set_out=$outPath" <- protocOptions
      out = Paths.get(outPath)
      if Files.isRegularFile(out) || reportWarning(s"no such file: $out")
    } yield FileDescriptorSet.parseFrom(Files.readAllBytes(out))
  }.headOption
}
