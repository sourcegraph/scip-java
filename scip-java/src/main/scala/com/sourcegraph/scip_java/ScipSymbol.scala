package com.sourcegraph.scip_java

import com.sourcegraph.scip_semanticdb.SymbolDescriptor
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols

sealed abstract class ScipSymbol {}
final case class LocalScipSymbol(identifier: String) extends ScipSymbol
final case class GlobalScipSymbol(
    scheme: String,
    packageManager: String,
    packageName: String,
    packageVersion: String,
    descriptors: List[SymbolDescriptor]
) extends ScipSymbol

object ScipSymbol {

  def parseOrThrowExceptionIfInvalid(scipSymbol: String): ScipSymbol = {
    if (scipSymbol.startsWith("local ")) {
      LocalScipSymbol(scipSymbol.stripPrefix("local "))
    } else {
      scipSymbol.split(" ", 5) match {
        case Array(
              scheme,
              packageManager,
              packageName,
              packageVersion,
              descriptor
            ) =>
          GlobalScipSymbol(
            scheme,
            packageManager,
            packageName,
            packageVersion,
            parseDescriptors(descriptor)
          )
        case _ =>
          throw new IllegalArgumentException(
            s"Invalid scip symbol: $scipSymbol"
          )
      }
    }
  }

  private def parseDescriptors(
      semanticdbSymbol: String
  ): List[SymbolDescriptor] = {
    val descriptor = SymbolDescriptor.parseFromSymbol(semanticdbSymbol)
    if (descriptor.owner == SemanticdbSymbols.ROOT_PACKAGE)
      Nil
    else
      descriptor :: parseDescriptors(descriptor.owner)
  }

}
