package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.semanticdb.Semanticdb;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Wrapper around a SemanticDB TextDocument with SCIP-related utilities. */
public class ScipTextDocument {
  public final Path semanticdbPath;
  public final Semanticdb.TextDocument semanticdb;

  public ScipTextDocument(
      Path semanticdbPath, Semanticdb.TextDocument semanticdb, Path sourceroot) {
    this.semanticdbPath = semanticdbPath;
    String uri = sourceroot.resolve(semanticdb.getUri()).toUri().toString();
    this.semanticdb = Semanticdb.TextDocument.newBuilder(semanticdb).setUri(uri).build();
  }

  @Override
  public String toString() {
    return "ScipDocument{" + "path=" + semanticdbPath + ", semanticdb=" + semanticdb + '}';
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
}
