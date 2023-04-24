package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;

import java.nio.file.Path;
import java.util.*;

/** Wrapper around a SemanticDB TextDocument with SCIP-related utilities. */
public class ScipTextDocument {
  public final Path semanticdbPath;
  public Semanticdb.TextDocument semanticdb;
  public int id;
  public final Map<String, Semanticdb.SymbolInformation> symbols;
  public final Map<String, ResultIds> localSymbols;
  // Map from symbols that have a definition occurrence to the list of symbols that have
  // `is_definition` relationships to that symbol.
  // This map is used to add `is_reference` relationships between all symbols in the list so that
  // doing "Find references"
  // on any of those symbols returns occurrences for all of the symbols in the "clique" (per
  // https://en.wikipedia.org/wiki/Clique_(graph_theory)).
  // See https://github.com/sourcegraph/sourcegraph/issues/50927 for more details.
  public final Map<String, ArrayList<String>> definitionCliques = new HashMap<>();

  public ScipTextDocument(
      Path semanticdbPath, Semanticdb.TextDocument semanticdb, Path sourceroot) {
    this.semanticdbPath = semanticdbPath;
    this.symbols = new HashMap<>();
    this.localSymbols = new HashMap<>();
    String uri = sourceroot.resolve(semanticdb.getUri()).toUri().toString();
    setSemanticdb(Semanticdb.TextDocument.newBuilder(semanticdb).setUri(uri).build());
  }

  @Override
  public String toString() {
    return "ScipDocument{"
        + "path="
        + semanticdbPath
        + ", semanticdb="
        + semanticdb
        + ", id="
        + id
        + '}';
  }

  public List<Semanticdb.SymbolOccurrence> sortedSymbolOccurrences() {
    return ScipTextDocument.sortedSymbolOccurrences(semanticdb);
  }

  public static List<Semanticdb.SymbolOccurrence> sortedSymbolOccurrences(
      Semanticdb.TextDocument semanticdb) {
    ArrayList<Semanticdb.SymbolOccurrence> result =
        new ArrayList<>(semanticdb.getOccurrencesList().size());
    result.addAll(semanticdb.getOccurrencesList());
    for (Semanticdb.Synthetic synthetic : semanticdb.getSyntheticsList()) {
      addAllSyntheticOccurrences(synthetic, result);
    }
    result.sort((o1, o2) -> new RangeComparator().compare(o1.getRange(), o2.getRange()));
    return result;
  }

  private static void addAllSyntheticOccurrences(
      Semanticdb.Synthetic synthetic, ArrayList<Semanticdb.SymbolOccurrence> buffer) {
    Semanticdb.Range offsetRange =
        Semanticdb.Range.newBuilder(synthetic.getRange())
            .setStartLine(synthetic.getRange().getEndLine())
            .setStartCharacter(synthetic.getRange().getEndCharacter())
            .build();
    new SemanticdbTreeVisitor() {
      @Override
      void visitIdTree(Semanticdb.IdTree tree) {
        Semanticdb.SymbolOccurrence syntheticOccurrence =
            Semanticdb.SymbolOccurrence.newBuilder()
                .setRange(offsetRange)
                .setSymbol(tree.getSymbol())
                .setRole(Semanticdb.SymbolOccurrence.Role.REFERENCE)
                .build();
        buffer.add(syntheticOccurrence);
      }
    }.visitTree(synthetic.getTree());
  }

  private void setSemanticdb(Semanticdb.TextDocument semanticdb) {
    this.semanticdb = manifestOccurrencesForSyntheticSymbols(semanticdb);
    for (Semanticdb.SymbolInformation info : semanticdb.getSymbolsList()) {
      symbols.put(info.getSymbol(), info);
    }
  }

  public Semanticdb.TextDocument manifestOccurrencesForSyntheticSymbols(
      Semanticdb.TextDocument semanticdb) {
    if (semanticdb.getLanguage() != Semanticdb.Language.SCALA) {
      // It's only semanticdb-scalac that emits SymbolInformation for symbols that have no
      // definition occurrences.
      return semanticdb;
    }
    Semanticdb.TextDocument.Builder builder = Semanticdb.TextDocument.newBuilder(semanticdb);
    builder.clearSymbols();
    HashMap<String, Semanticdb.SymbolOccurrence> definitionOccurrences = new HashMap<>();
    for (Semanticdb.SymbolOccurrence occ : semanticdb.getOccurrencesList()) {
      if (occ.getRole() == Semanticdb.SymbolOccurrence.Role.DEFINITION) {
        definitionOccurrences.put(occ.getSymbol(), occ);
      }
    }
    for (Semanticdb.SymbolInformation info : semanticdb.getSymbolsList()) {
      Semanticdb.SymbolInformation.Builder newInfo = Semanticdb.SymbolInformation.newBuilder(info);
      Semanticdb.SymbolOccurrence definition = definitionOccurrences.get(info.getSymbol());
      if (definition != null) {
        // This symbol has a definition so it doesn't need an is_definition relationship.
        builder.addSymbols(newInfo);
        continue;
      }
      for (Semanticdb.SymbolOccurrence alternativeSymbol : alternativeSymbols(info)) {
        Semanticdb.SymbolOccurrence alternativeDefinition =
            definitionOccurrences.get(alternativeSymbol.getSymbol());
        if (alternativeDefinition != null) {
          ArrayList<String> clique =
              this.definitionCliques.computeIfAbsent(
                  alternativeSymbol.getSymbol(), k -> new ArrayList<>());
          clique.add(info.getSymbol());
          newInfo.addDefinitionRelationships(alternativeDefinition.getSymbol());
          break;
        }
      }
      builder.addSymbols(newInfo);
    }
    return builder.build();
  }

  public static final Set<String> syntheticCaseClassMethodNames =
      new HashSet<>(Arrays.asList("copy", "productElement", "productElementName"));
  public static final Set<String> syntheticCompanionObjectNames =
      new HashSet<>(Arrays.asList("apply", "copy"));

  public static List<Semanticdb.SymbolOccurrence> alternativeSymbols(
      Semanticdb.SymbolInformation info) {
    SymbolOccurrences alternatives = new SymbolOccurrences();
    SymbolDescriptor sym = SymbolDescriptor.parseFromSymbol(info.getSymbol());
    switch (sym.descriptor.kind) {
      case Method:
        if (sym.descriptor.name.endsWith("_=")) {
          String newName = sym.descriptor.name.substring(0, sym.descriptor.name.length() - 2);
          alternatives.addDefinition(
              SemanticdbSymbols.global(sym.owner, sym.descriptor.withName(newName)));
        } else if (syntheticCaseClassMethodNames.contains(sym.descriptor.name)) {
          alternatives.addSyntheticDefinition(sym.owner);
        } else if (syntheticCompanionObjectNames.contains(sym.descriptor.name)) {
          alternatives.addSyntheticDefinition(sym.owner);
          SymbolDescriptor owner = SymbolDescriptor.parseFromSymbol(sym.owner);
          alternatives.addSyntheticDefinition(
              SemanticdbSymbols.global(
                  owner.owner, owner.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Type)));
        }
        break;
      case Parameter:
        SymbolDescriptor owner = SymbolDescriptor.parseFromSymbol(sym.owner);
        if (owner.descriptor.name.equals("copy") || owner.descriptor.name.equals("<init>")) {
          // case classes copy method parameter.
          alternatives.addDefinition(
              SemanticdbSymbols.global(
                  owner.owner, sym.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Term)));
        } else if (owner.descriptor.name.equals("apply")) {
          // case class companion apply constructor parameter.
          SymbolDescriptor grandparent = SymbolDescriptor.parseFromSymbol(owner.owner);
          String companion =
              SemanticdbSymbols.global(
                  grandparent.owner,
                  grandparent.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Type));
          alternatives.addDefinition(
              SemanticdbSymbols.global(
                  companion, sym.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Term)));
        }
      case Term:
        alternatives.addDefinition(
            SemanticdbSymbols.global(
                sym.owner, sym.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Type)));
        break;
      default:
    }

    return alternatives.occurrences;
  }
}
