package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** The core logic that converts SemanticDB into LSIF. */
public class LsifSemanticdb {
  private final LsifWriter writer;
  private final LsifSemanticdbOptions options;
  private final Map<String, ResultIds> globals;

  public LsifSemanticdb(LsifWriter writer, LsifSemanticdbOptions options) {
    this.writer = writer;
    this.options = options;
    this.globals = new ConcurrentHashMap<>();
  }

  public static void run(LsifSemanticdbOptions options) throws IOException {
    LsifWriter writer = new LsifWriter(options);
    new LsifSemanticdb(writer, options).run();
  }

  private void run() throws IOException {
    writer.emitMetaData();
    int projectId = writer.emitProject(options.language);

    List<Path> files = SemanticdbWalker.findSemanticdbFiles(options);
    if (options.reporter.hasErrors()) return;
    options.reporter.startProcessing(files.size());

    Set<String> isExportedSymbol = exportSymbols(files);
    List<Integer> documentIds =
        filesStream(files)
            .flatMap(d -> processPath(d, isExportedSymbol))
            .collect(Collectors.toList());

    writer.emitContains(projectId, documentIds);

    writer.build();
    options.reporter.endProcessing();
  }

  private Stream<Path> filesStream(List<Path> files) {
    return options.parallel ? files.parallelStream() : files.stream();
  }

  private Set<String> exportSymbols(List<Path> files) {
    return filesStream(files)
        .flatMap(this::parseTextDocument)
        .flatMap(
            d ->
                d.semanticdb.getOccurrencesList().stream()
                    .filter(occ -> occ.getRole() == Role.DEFINITION)
                    .map(SymbolOccurrence::getSymbol)
                    .filter(SemanticdbSymbols::isGlobal))
        .collect(Collectors.toSet());
  }

  private Stream<Integer> processPath(Path path, Set<String> isExportedSymbol) {
    return parseTextDocument(path).map(d -> processDocument(d, isExportedSymbol));
  }

  private Integer processDocument(LsifTextDocument doc, Set<String> isExportedSymbol) {
    Symtab symtab = new Symtab(doc.semanticdb);

    int documentId = writer.emitDocument(doc);
    Set<String> localDefinitions =
        doc.semanticdb.getOccurrencesList().stream()
            .filter(
                occ ->
                    occ.getRole() == Role.DEFINITION && SemanticdbSymbols.isLocal(occ.getSymbol()))
            .map(SymbolOccurrence::getSymbol)
            .collect(Collectors.toSet());
    doc.id = documentId;
    ResultSets results = new ResultSets(writer, globals, isExportedSymbol, localDefinitions);
    Set<Integer> rangeIds = new LinkedHashSet<>();

    for (SymbolOccurrence occ : doc.sortedSymbolOccurrences()) {
      SymbolInformation symbolInformation =
          doc.symbols.getOrDefault(occ.getSymbol(), SymbolInformation.getDefaultInstance());
      ResultIds ids = results.getOrInsertResultSet(occ.getSymbol());
      int rangeId = writer.emitRange(occ.getRange());
      rangeIds.add(rangeId);

      // Range
      writer.emitNext(rangeId, ids.resultSet);

      // Reference
      writer.emitItem(ids.referenceResult, rangeId, doc.id);

      // Definition
      if (occ.getRole() == SymbolOccurrence.Role.DEFINITION) {
        if (ids.isDefinitionDefined()) {
          writer.emitItem(ids.definitionResult, rangeId, doc.id);
        } else {
          options.reporter.error(
              new NoSuchElementException(
                  String.format("no definition ID for symbol '%s'", occ.getSymbol())));
        }

        // Hover
        ArrayList<MarkedString> markedStrings = new ArrayList<>();
        String documentation = symbolInformation.getDocumentation().getMessage();
        if (!documentation.isEmpty()) {
          markedStrings.add(new MarkedString(doc.semanticdb.getLanguage(), documentation));
        }

        if (symbolInformation.hasSignature()) {
          markedStrings.add(
              new MarkedString(
                  doc.semanticdb.getLanguage(),
                  new SignatureFormatter(symbolInformation, symtab).formatSymbol()));
        }

        if (!markedStrings.isEmpty()) {
          int hoverId = writer.emitHoverResult(markedStrings.toArray(new MarkedString[0]));
          writer.emitHoverEdge(ids.resultSet, hoverId);
        }
      }
    }
    writer.emitContains(doc.id, new ArrayList<>(rangeIds));
    writer.flush();
    options.reporter.processedOneItem();
    return documentId;
  }

  private Stream<LsifTextDocument> parseTextDocument(Path semanticdbPath) {
    try {
      return Semanticdb.TextDocuments.parseFrom(Files.readAllBytes(semanticdbPath))
          .getDocumentsList().stream()
          .filter(sdb -> !sdb.getOccurrencesList().isEmpty())
          .map(sdb -> new LsifTextDocument(semanticdbPath, sdb, options.sourceroot));
    } catch (IOException e) {
      options.reporter.error(e);
      return Stream.empty();
    }
  }
}
