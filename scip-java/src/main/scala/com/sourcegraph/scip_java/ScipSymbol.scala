package com.sourcegraph.scip_java

import com.sourcegraph.scip.ScipSymbols
import com.sourcegraph.scip_aggregator.SymbolDescriptor

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

  private def parseDescriptors(scipSymbol: String): List[SymbolDescriptor] = {
    val descriptor = SymbolDescriptor.parseFromSymbol(scipSymbol)
    if (descriptor.owner == ScipSymbols.ROOT_PACKAGE)
      Nil
    else
      descriptor :: parseDescriptors(descriptor.owner)
  }

}
