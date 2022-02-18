package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;

import java.nio.file.Path;
import java.util.*;

/** Wrapper around a SemanticDB TextDocument with LSIF-related utilities. */
public class LsifTextDocument {
  public final Path semanticdbPath;
  public Semanticdb.TextDocument semanticdb;
  public int id;
  public final Map<String, Semanticdb.SymbolInformation> symbols;
  public final Map<String, ResultIds> localSymbols;

  public LsifTextDocument(
      Path semanticdbPath, Semanticdb.TextDocument semanticdb, Path sourceroot) {
    this.semanticdbPath = semanticdbPath;
    this.symbols = new HashMap<>();
    this.localSymbols = new HashMap<>();
    String uri = sourceroot.resolve(semanticdb.getUri()).toUri().toString();
    setSemanticdb(Semanticdb.TextDocument.newBuilder(semanticdb).setUri(uri).build());
  }

  @Override
  public String toString() {
    return "LsifDocument{"
        + "path="
        + semanticdbPath
        + ", semanticdb="
        + semanticdb
        + ", id="
        + id
        + '}';
  }

  public List<Semanticdb.SymbolOccurrence> sortedSymbolOccurrences() {
    return LsifTextDocument.sortedSymbolOccurrences(semanticdb);
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

  public static Semanticdb.TextDocument manifestOccurrencesForSyntheticSymbols(
      Semanticdb.TextDocument semanticdb) {
    if (semanticdb.getLanguage() != Semanticdb.Language.SCALA) {
      // It's only semanticdb-scalac that emits SymbolInformation for symbols that have no
      // definition occurrences.
      return semanticdb;
    }
    Semanticdb.TextDocument.Builder builder = Semanticdb.TextDocument.newBuilder(semanticdb);
    HashMap<String, Semanticdb.SymbolOccurrence> definitionOccurrences = new HashMap<>();
    for (Semanticdb.SymbolOccurrence occ : semanticdb.getOccurrencesList()) {
      if (occ.getRole() == Semanticdb.SymbolOccurrence.Role.DEFINITION) {
        definitionOccurrences.put(occ.getSymbol(), occ);
      }
    }
    for (Semanticdb.SymbolInformation info : semanticdb.getSymbolsList()) {
      Semanticdb.SymbolOccurrence definition = definitionOccurrences.get(info.getSymbol());
      if (definition != null) {
        continue;
      }
      for (String alternativeSymbol : alternativeSymbols(info)) {
        Semanticdb.SymbolOccurrence alternativeDefinition =
            definitionOccurrences.get(alternativeSymbol);
        if (alternativeDefinition != null) {
          builder.addOccurrences(
              Semanticdb.SymbolOccurrence.newBuilder(alternativeDefinition)
                  .setSymbol(info.getSymbol()));
          break;
        }
      }
    }
    return builder.build();
  }

  public static final Set<String> syntheticCaseClassMethodNames =
      new HashSet<>(Arrays.asList("copy", "productElement", "productElementName"));
  public static final Set<String> syntheticCompanionObjectNames =
      new HashSet<>(Arrays.asList("apply", "copy"));

  public static List<String> alternativeSymbols(Semanticdb.SymbolInformation info) {
    ArrayList<String> alternatives = new ArrayList<>();
    SymbolDescriptor sym = SymbolDescriptor.parseFromSymbol(info.getSymbol());
    switch (sym.descriptor.kind) {
      case Method:
        if (sym.descriptor.name.endsWith("_=")) {
          String newName = sym.descriptor.name.substring(0, sym.descriptor.name.length() - 2);
          alternatives.add(SemanticdbSymbols.global(sym.owner, sym.descriptor.withName(newName)));
        } else if (syntheticCaseClassMethodNames.contains(sym.descriptor.name)) {
          alternatives.add(sym.owner);
        } else if (syntheticCompanionObjectNames.contains(sym.descriptor.name)) {
          alternatives.add(sym.owner);
          SymbolDescriptor owner = SymbolDescriptor.parseFromSymbol(sym.owner);
          alternatives.add(
              SemanticdbSymbols.global(
                  owner.owner, owner.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Type)));
        }
        break;
      case Term:
        alternatives.add(
            SemanticdbSymbols.global(
                sym.owner, sym.descriptor.withKind(SemanticdbSymbols.Descriptor.Kind.Type)));
        break;
      default:
    }
    return alternatives;
  }
}
