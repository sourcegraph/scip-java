package com.sourcegraph.scip_java

import scala.collection.mutable
import scala.jdk.CollectionConverters.CollectionHasAsScala
import scala.math.Ordering.Implicits.seqOrdering

import com.sourcegraph.Scip
import com.sourcegraph.Scip.SymbolRole
import com.sourcegraph.scip_java.commands.CommentSyntax
import moped.reporters.Input
import moped.reporters.Position

object ScipPrinters {

  def printTextDocument(
      doc: Scip.Document,
      text: String,
      comments: CommentSyntax = CommentSyntax.default
  ): String = {
    val out = new mutable.StringBuilder()
    val occurrencesByLine = doc
      .getOccurrencesList
      .asScala
      .groupBy(_.getRange(0))
    val symtab =
      doc.getSymbolsList.asScala.map(info => info.getSymbol -> info).toMap

    val syntheticDefinitions =
      doc
        .getSymbolsList
        .asScala
        .flatMap { info =>
          info
            .getRelationshipsList
            .asScala
            .collect {
              case relationship if relationship.getIsDefinition =>
                info -> relationship
            }
        }
        .groupBy { case (_, relationship) =>
          relationship.getSymbol
        }
        .view
        .mapValues(
          _.map { case (info, _) =>
            info
          }
        )
        .toMap
    val extension = doc.getRelativePath.split("\\.").lastOption.getOrElse("")
    val commentSyntax = comments.extensionSyntax(extension)
    val input = Input.filename(doc.getRelativePath, text)
    text
      .linesWithSeparators
      .zipWithIndex
      .foreach { case (line, i) =>
        out.append(line.replace("\t", "→"))
        val occurrences = occurrencesByLine
          .getOrElse(i, Nil)
          .toSeq
          .sortBy(o =>
            (o.getRangeList.asScala.toList.map(_.toInt), o.getSymbol)
          )
        occurrences.foreach { occ =>
          formatOccurrence(input, out, occ, line, symtab, commentSyntax)
          if ((occ.getSymbolRoles & SymbolRole.Definition_VALUE) > 0) {
            syntheticDefinitions
              .getOrElse(occ.getSymbol, Nil)
              .foreach { syntheticDefinition =>
                formatOccurrence(
                  input,
                  out,
                  occ,
                  line,
                  symtab,
                  commentSyntax,
                  syntheticDefinition = Some(syntheticDefinition)
                )
              }
          }
        }
      }
    out.toString()
  }

  private def mopedPosition(input: Input, occ: Scip.Occurrence): Position = {
    if (occ.getRangeCount == 3)
      Position.range(
        input,
        occ.getRange(0),
        occ.getRange(1),
        occ.getRange(0),
        occ.getRange(2)
      )
    else if (occ.getRangeCount == 4)
      Position.range(
        input,
        occ.getRange(0),
        occ.getRange(1),
        occ.getRange(2),
        occ.getRange(3)
      )
    else
      throw new IllegalArgumentException(s"Invalid range: $occ")
  }

  private def formatOccurrence(
      input: Input,
      out: mutable.StringBuilder,
      occ: Scip.Occurrence,
      line: String,
      symtab: Map[String, Scip.SymbolInformation],
      comment: String,
      syntheticDefinition: Option[Scip.SymbolInformation] = None
  ): Unit = {
    val pos = mopedPosition(input, occ)
    val isMultiline = pos.startLine != pos.endLine
    val width =
      if (isMultiline) {
        line.length - pos.startColumn - 1
      } else {
        math.max(1, pos.endColumn - pos.startColumn)
      }

    val isDefinition =
      (occ.getSymbolRoles & SymbolRole.Definition.getNumber) > 0
    val role =
      if (syntheticDefinition.isDefined)
        "synthetic_definition"
      else if (isDefinition)
        "definition"
      else
        "reference"
    val indent =
      if (pos.startColumn > comment.length)
        " " * (pos.startColumn - comment.length)
      else
        ""
    val caretCharacter =
      if (syntheticDefinition.isDefined)
        "_"
      else
        "^"
    val carets =
      if (pos.startColumn == 1)
        caretCharacter * (width - 1)
      else
        caretCharacter * width

    val symbol = syntheticDefinition.fold(occ.getSymbol)(_.getSymbol)

    // Fail the tests if the index contains symbols that don't parse as valid SCIP symbols.
    val _ = ScipSymbol.parseOrThrowExceptionIfInvalid(symbol)

    out
      .append(comment)
      .append(indent)
      .append(carets)
      .append(" ")
      .append(role)
      .append(" ")
      .append(symbol)
    if (isMultiline) {
      out.append(s" ${pos.endLine - pos.startLine}:${pos.endColumn}")
    }
    out.append("\n")

    syntheticDefinition.orElse(symtab.get(occ.getSymbol)) match {
      case Some(info) if isDefinition =>
        val prefix =
          comment + (" " * indent.length) + (" " * carets.length) + " "
        0.until(info.getDocumentationCount)
          .foreach { n =>
            val documentation = info.getDocumentation(n)
            out
              .append(prefix)
              .append("documentation ")
              .append(documentation.replace("\n", "\\n").replace("\t", "\\t"))
              .append("\n")
          }
        info
          .getRelationshipsList
          .asScala
          .toList
          .sortBy(_.getSymbol) // sort for deterministic order
          .foreach { relationship =>
            out.append(prefix).append("relationship")
            if (relationship.getIsReference) {
              out.append(" is_reference")
            }
            if (relationship.getIsDefinition) {
              out.append(" is_definition")
            }
            if (relationship.getIsImplementation) {
              out.append(" is_implementation")
            }
            if (relationship.getIsTypeDefinition) {
              out.append(" is_type_definition")
            }
            out.append(" ").append(relationship.getSymbol).append("\n")
          }
      case _ =>
    }
  }
}
