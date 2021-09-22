package com.sourcegraph.lsif_semanticdb;

import com.google.protobuf.CodedInputStream;
import com.sourcegraph.lsif_protocol.MarkupKind;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
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
    PackageTable packages = new PackageTable(options, writer);
    List<Path> files = SemanticdbWalker.findSemanticdbFiles(options);
    Collections.sort(files);
    if (options.reporter.hasErrors()) return;
    if (files.isEmpty()) {
      options.reporter.error(
          "No SemanticDB files found. "
              + "This typically means that `lsif-java` is unable to automatically "
              + "index this codebase. If you are using Gradle or Maven, please report an issue to "
              + "https://github.com/sourcegraph/lsif-java and include steps to reproduce. "
              + "If you are using a different build tool, make sure that you have followed all "
              + "of the steps from https://sourcegraph.github.io/lsif-java/docs/manual-configuration.html");
      return;
    }
    options.reporter.startProcessing(files.size());
    writer.emitMetaData();
    int projectId = writer.emitProject(options.language);

    Set<String> isExportedSymbol = exportSymbols(files);
    List<Integer> documentIds =
        filesStream(files)
            .flatMap(d -> processPath(d, isExportedSymbol, packages))
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

  private Stream<Integer> processPath(
      Path path, Set<String> isExportedSymbol, PackageTable packages) {
    return parseTextDocument(path).flatMap(d -> processDocument(d, isExportedSymbol, packages));
  }

  private Stream<Integer> processDocument(
      LsifTextDocument doc, Set<String> isExportedSymbol, PackageTable packages) {
    try {
      return Stream.of(processDocumentUnsafe(doc, isExportedSymbol, packages));
    } catch (Exception e) {
      options.reporter.error(new LsifProcessingException(doc, e));
      return Stream.empty();
    }
  }

  private Integer processDocumentUnsafe(
      LsifTextDocument doc, Set<String> isExportedSymbol, PackageTable packages) {
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
    ResultSets results =
        new ResultSets(writer, globals, isExportedSymbol, localDefinitions, packages, options);
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

        // Hover 1: signature
        String documentation = symbolInformation.getDocumentation().getMessage();
        StringBuilder markupContent = new StringBuilder(documentation.length());
        if (symbolInformation.hasSignature()) {
          String language =
              doc.semanticdb.getLanguage().toString().toLowerCase(Locale.ROOT).intern();
          String signature = new SignatureFormatter(symbolInformation, symtab).formatSymbol();
          markupContent
              .append("```")
              .append(language)
              .append('\n')
              .append(signature)
              .append("\n```");
        }

        // Hover 2: docstring
        if (!documentation.isEmpty()) {
          if (markupContent.length() != 0) markupContent.append("\n---\n");
          markupContent.append(documentation.replaceAll("\n", "\n\n"));
        }

        if (markupContent.length() == 0) {
          // Always emit a non-empty hover message to prevent Sourcegraph from falling back to
          // Search-Based hover messages.
          markupContent.append(symbolInformation.getDisplayName());
        }

        int hoverId =
            writer.emitHoverResult(
                new MarkupContent(MarkupKind.MARKDOWN, markupContent.toString()));
        writer.emitHoverEdge(ids.resultSet, hoverId);
      }

      // Overrides
      if (symbolInformation.getOverriddenSymbolsCount() > 0) {
        int[] overriddenReferenceResultIds = new int[symbolInformation.getOverriddenSymbolsCount()];
        for (int i = 0; i < symbolInformation.getOverriddenSymbolsCount(); i++) {
          String overriddenSymbol = symbolInformation.getOverriddenSymbols(i);
          ResultIds overriddenIds = results.getOrInsertResultSet(overriddenSymbol);
          overriddenReferenceResultIds[i] = overriddenIds.referenceResult;
          writer.emitReferenceResultsItemEdge(
              overriddenIds.referenceResult, new int[] {rangeId}, doc.id);
        }
        writer.emitReferenceResultsItemEdge(
            ids.referenceResult, overriddenReferenceResultIds, doc.id);
      }
    }
    writer.emitContains(doc.id, new ArrayList<>(rangeIds));
    writer.flush();
    options.reporter.processedOneItem();
    return documentId;
  }

  private Stream<LsifTextDocument> parseTextDocument(Path semanticdbPath) {
    try {
      return textDocumentsParseFrom(semanticdbPath).getDocumentsList().stream()
          .filter(sdb -> !sdb.getOccurrencesList().isEmpty())
          .map(sdb -> new LsifTextDocument(semanticdbPath, sdb, options.sourceroot));
    } catch (IOException e) {
      options.reporter.error("invalid protobuf: " + semanticdbPath);
      options.reporter.error(e);
      return Stream.empty();
    }
  }

  private Semanticdb.TextDocuments textDocumentsParseFrom(Path semanticdbPath) throws IOException {
    byte[] bytes = Files.readAllBytes(semanticdbPath);
    try {
      CodedInputStream in = CodedInputStream.newInstance(bytes);
      in.setRecursionLimit(1000);
      return Semanticdb.TextDocuments.parseFrom(in);
    } catch (NoSuchMethodError ignored) {
      // NOTE(olafur): For some reason, NoSuchMethodError gets thrown when running `snapshots/run`
      // in the sbt build. I'm unable to reproduce the error in `snapshots/test` or when running the
      // published version
      // of `lsif-java index`.
      return Semanticdb.TextDocuments.parseFrom(bytes);
    }
  }
}
