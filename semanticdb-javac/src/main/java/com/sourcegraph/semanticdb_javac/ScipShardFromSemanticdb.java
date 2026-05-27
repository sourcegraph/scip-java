package com.sourcegraph.semanticdb_javac;

import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;
import org.scip_code.scip.SymbolRole;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Kind;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation.Property;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts an in-memory {@link Semanticdb.TextDocument} into a single-document {@link Index}
 * shard.
 *
 * <p>Global SemanticDB symbols are rewritten via {@link ScipSymbols#fromSemanticdbSymbol(String)}
 * to use the {@code ". . . . "} placeholder scheme expected by the aggregator. Local symbols are
 * normalized to the SCIP {@code "local N"} form.
 *
 * <p>This is an intermediate stepping stone: a future {@code ScipVisitor} will build {@link
 * Document} values directly from the javac AST, removing the need for this conversion.
 */
public final class ScipShardFromSemanticdb {

  private ScipShardFromSemanticdb() {}

  /** Builds a single-document {@link Index} shard from {@code doc}. */
  public static Index buildShard(Semanticdb.TextDocument doc, String relativePath) {
    Document.Builder document =
        Document.newBuilder()
            .setRelativePath(relativePath)
            .setLanguage(scipLanguage(doc.getLanguage()));

    for (SymbolOccurrence occ : doc.getOccurrencesList()) {
      if (occ.getSymbol().isEmpty()) continue;
      document.addOccurrences(toScipOccurrence(occ));
    }

    for (SymbolInformation info : doc.getSymbolsList()) {
      if (info.getSymbol().isEmpty()) continue;
      document.addSymbols(toScipSymbolInformation(info));
    }

    return Index.newBuilder().addDocuments(document).build();
  }

  private static String scipLanguage(Semanticdb.Language lang) {
    switch (lang) {
      case JAVA:
        return Scip.Language.Java.name();
      case KOTLIN:
        return Scip.Language.Kotlin.name();
      case SCALA:
        return Scip.Language.Scala.name();
      default:
        return "";
    }
  }

  private static Occurrence toScipOccurrence(SymbolOccurrence occ) {
    Occurrence.Builder builder =
        Occurrence.newBuilder()
            .addAllRange(scipRange(occ.getRange()))
            .setSymbol(ScipSymbols.fromSemanticdbSymbol(occ.getSymbol()))
            .setSymbolRoles(scipRoles(occ.getRole()));
    if (occ.hasEnclosingRange()) {
      builder.addAllEnclosingRange(scipRange(occ.getEnclosingRange()));
    }
    return builder.build();
  }

  private static int scipRoles(Role role) {
    if (role == Role.DEFINITION || role == Role.SYNTHETIC_DEFINITION) {
      return SymbolRole.Definition_VALUE;
    }
    return 0;
  }

  private static List<Integer> scipRange(Semanticdb.Range range) {
    List<Integer> result = new ArrayList<>(4);
    result.add(range.getStartLine());
    result.add(range.getStartCharacter());
    if (range.getStartLine() == range.getEndLine()) {
      result.add(range.getEndCharacter());
    } else {
      result.add(range.getEndLine());
      result.add(range.getEndCharacter());
    }
    return result;
  }

  private static SymbolInformation toScipSymbolInformation(SymbolInformation info) {
    SymbolInformation.Builder builder =
        SymbolInformation.newBuilder()
            .setSymbol(ScipSymbols.fromSemanticdbSymbol(info.getSymbol()))
            .setDisplayName(info.getDisplayName())
            .setKind(scipKind(info));

    if (!info.getEnclosingSymbol().isEmpty()) {
      builder.setEnclosingSymbol(ScipSymbols.fromSemanticdbSymbol(info.getEnclosingSymbol()));
    }

    for (int i = 0; i < info.getOverriddenSymbolsCount(); i++) {
      String overridden = info.getOverriddenSymbols(i);
      if (overridden.isEmpty()) continue;
      if (isIgnoredOverriddenSymbol(overridden)) continue;
      builder.addRelationships(
          Relationship.newBuilder()
              .setSymbol(ScipSymbols.fromSemanticdbSymbol(overridden))
              .setIsImplementation(true)
              .setIsReference(supportsReferenceRelationship(info)));
    }

    String documentation = info.getDocumentation().getMessage();
    if (!documentation.isEmpty()) {
      builder.addDocumentation(documentation);
    }

    return builder.build();
  }

  private static boolean isIgnoredOverriddenSymbol(String symbol) {
    return symbol.equals("java/lang/Object#");
  }

  private static boolean supportsReferenceRelationship(SymbolInformation info) {
    switch (info.getKind()) {
      case INTERFACE:
      case TYPE:
      case CLASS:
      case OBJECT:
      case PACKAGE_OBJECT:
        return false;
      default:
        return true;
    }
  }

  private static SymbolInformation.Kind scipKind(SymbolInformation info) {
    Kind kind = info.getKind();
    int properties = info.getProperties();
    boolean isStatic = (properties & Property.STATIC_VALUE) > 0;
    boolean isAbstract = (properties & Property.ABSTRACT_VALUE) > 0;
    boolean isEnum = (properties & Property.ENUM_VALUE) > 0;

    switch (kind) {
      case CLASS:
        return isEnum ? SymbolInformation.Kind.Enum : SymbolInformation.Kind.Class;
      case CONSTRUCTOR:
        return SymbolInformation.Kind.Constructor;
      case FIELD:
        return isStatic
            ? SymbolInformation.Kind.StaticField
            : SymbolInformation.Kind.Field;
      case INTERFACE:
        return SymbolInformation.Kind.Interface;
      case LOCAL:
        return isStatic
            ? SymbolInformation.Kind.StaticVariable
            : SymbolInformation.Kind.Variable;
      case MACRO:
        return SymbolInformation.Kind.Macro;
      case METHOD:
        if (isStatic) return SymbolInformation.Kind.StaticMethod;
        if (isAbstract) return SymbolInformation.Kind.AbstractMethod;
        return SymbolInformation.Kind.Method;
      case OBJECT:
        return SymbolInformation.Kind.Object;
      case PACKAGE:
        return SymbolInformation.Kind.Package;
      case PACKAGE_OBJECT:
        return SymbolInformation.Kind.PackageObject;
      case PARAMETER:
        return SymbolInformation.Kind.Parameter;
      case SELF_PARAMETER:
        return SymbolInformation.Kind.SelfParameter;
      case TRAIT:
        return SymbolInformation.Kind.Trait;
      case TYPE:
        return isEnum ? SymbolInformation.Kind.Enum : SymbolInformation.Kind.Type;
      case TYPE_PARAMETER:
        return SymbolInformation.Kind.TypeParameter;
      case UNKNOWN_KIND:
      default:
        return SymbolInformation.Kind.UnspecifiedKind;
    }
  }
}
