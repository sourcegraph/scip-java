package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    this.semanticdb = semanticdb;
    for (Semanticdb.SymbolInformation info : semanticdb.getSymbolsList()) {
      symbols.put(info.getSymbol(), info);
    }
  }
}
