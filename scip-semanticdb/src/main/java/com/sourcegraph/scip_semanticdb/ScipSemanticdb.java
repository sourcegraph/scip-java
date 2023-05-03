package com.sourcegraph.scip_semanticdb;

import com.google.protobuf.CodedInputStream;
import com.sourcegraph.lsif_protocol.MarkupKind;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolInformation;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import com.sourcegraph.Scip;

import javax.annotation.Nullable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** The core logic that converts SemanticDB into SCIP. */
public class ScipSemanticdb {
  private final ScipWriter writer;
  private final ScipSemanticdbOptions options;
  private final Map<String, ResultIds> globals;

  public ScipSemanticdb(ScipWriter writer, ScipSemanticdbOptions options) {
    this.writer = writer;
    this.options = options;
    this.globals = new ConcurrentHashMap<>();
  }

  public static void run(ScipSemanticdbOptions options) throws IOException {
    ScipWriter writer = new ScipWriter(options);
    new ScipSemanticdb(writer, options).run();
  }

  private void run() throws IOException {
    PackageTable packages = new PackageTable(options, writer);
    List<Path> files = SemanticdbWalker.findSemanticdbFiles(options);
    Collections.sort(files);
    if (options.reporter.hasErrors()) return;
    if (files.isEmpty()) {
      options.reporter.error(
          "No SemanticDB files found. "
              + "This typically means that `scip-java` is unable to automatically "
              + "index this codebase. If you are using Gradle or Maven, please report an issue to "
              + "https://github.com/sourcegraph/scip-java and include steps to reproduce. "
              + "If you are using a different build tool, make sure that you have followed all "
              + "of the steps from https://sourcegraph.github.io/scip-java/docs/manual-configuration.html");
      return;
    }
    options.reporter.startProcessing(files.size());
    if (options.format.isTyped()) {
      runTyped(files, packages);
    } else {
      runGraph(files, packages);
    }
    writer.build();
    options.reporter.endProcessing();
  }

  private void runTyped(List<Path> files, PackageTable packages) {
    writer.emitTyped(typedMetadata());
    InverseReferenceRelationships references = inverseReferenceRelationships(files);
    filesStream(files).forEach(document -> processTypedDocument(document, packages, references));
  }

  private String typedSymbol(String symbol, Package pkg) {
    if (symbol.isEmpty()) {
      return "";
    }
    if (symbol.startsWith("local")) {
      return "local " + symbol.substring("local".length());
    }
    return "semanticdb maven " + pkg.repoName() + " " + pkg.version() + " " + symbol;
  }

  public static boolean isDefinitionRole(Role role) {
    return role == Role.DEFINITION || role == Role.SYNTHETIC_DEFINITION;
  }

  private void processTypedDocument(
      Path path, PackageTable packages, InverseReferenceRelationships references) {
    for (ScipTextDocument doc : parseTextDocument(path).collect(Collectors.toList())) {
      if (doc.semanticdb.getOccurrencesCount() == 0) {
        continue;
      }

      Path absolutePath = Paths.get(URI.create(doc.semanticdb.getUri()));
      String relativePath =
          StreamSupport.stream(options.sourceroot.relativize(absolutePath).spliterator(), false)
              .map(p -> p.getFileName().toString())
              .collect(Collectors.joining("/"));
      Scip.Document.Builder tdoc = Scip.Document.newBuilder().setRelativePath(relativePath);
      for (SymbolOccurrence occ : doc.sortedSymbolOccurrences()) {
        if (occ.getSymbol().isEmpty()) {
          continue;
        }
        int role = 0;
        if (isDefinitionRole(occ.getRole())) {
          role |= Scip.SymbolRole.Definition_VALUE;
        }
        boolean isSingleLineRange = occ.getRange().getStartLine() == occ.getRange().getEndLine();
        Iterable<Integer> range =
            isSingleLineRange
                ? Arrays.asList(
                    occ.getRange().getStartLine(),
                    occ.getRange().getStartCharacter(),
                    occ.getRange().getEndCharacter())
                : Arrays.asList(
                    occ.getRange().getStartLine(),
                    occ.getRange().getStartCharacter(),
                    occ.getRange().getEndLine(),
                    occ.getRange().getEndCharacter());
        Package pkg = packages.packageForSymbol(occ.getSymbol()).orElse(Package.EMPTY);
        tdoc.addOccurrences(
            Scip.Occurrence.newBuilder()
                .addAllRange(range)
                .setSymbol(typedSymbol(occ.getSymbol(), pkg))
                .setSymbolRoles(role));
      }
      Symtab symtab = new Symtab(doc.semanticdb);
      for (SymbolInformation info : doc.semanticdb.getSymbolsList()) {
        if (info.getSymbol().isEmpty()) {
          continue;
        }
        Package pkg = packages.packageForSymbol(info.getSymbol()).orElse(Package.EMPTY);
        Scip.SymbolInformation.Builder scipInfo =
            Scip.SymbolInformation.newBuilder().setSymbol(typedSymbol(info.getSymbol(), pkg));

        // TODO: this can be removed once https://github.com/sourcegraph/sourcegraph/issues/50927 is
        // fixed.
        ArrayList<String> inverseReferences = references.map.get(info.getSymbol());
        if (inverseReferences != null) {
          for (String inverseReference : inverseReferences) {
            Package inverseReferencePkg =
                packages.packageForSymbol(inverseReference).orElse(Package.EMPTY);
            scipInfo.addRelationships(
                Scip.Relationship.newBuilder()
                    .setSymbol(typedSymbol(inverseReference, inverseReferencePkg))
                    .setIsImplementation(true)
                    .setIsReference(true));
          }
        }

        for (int i = 0; i < info.getDefinitionRelationshipsCount(); i++) {
          String definitionSymbol = info.getDefinitionRelationships(i);
          if (definitionSymbol.isEmpty()) {
            continue;
          }
          Package definitionSymbolPkg =
              packages.packageForSymbol(definitionSymbol).orElse(Package.EMPTY);
          SymbolInformation definitionInfo = symtab.symbols.get(definitionSymbol);

          scipInfo.addRelationships(
              Scip.Relationship.newBuilder()
                  .setSymbol(typedSymbol(definitionSymbol, definitionSymbolPkg))
                  .setIsDefinition(true)
                  .setIsReference(
                      definitionInfo != null
                          && definitionInfo.getDisplayName().equals(info.getDisplayName())
                          && supportsReferenceRelationship(info)));

          addReferenceRelationships(
              symtab, info, scipInfo, doc.definitionCliques.get(definitionSymbol), packages);
        }

        addReferenceRelationships(
            symtab, info, scipInfo, doc.definitionCliques.get(info.getSymbol()), packages);

        for (int i = 0; i < info.getOverriddenSymbolsCount(); i++) {
          String overriddenSymbol = info.getOverriddenSymbols(i);
          if (overriddenSymbol.isEmpty()) {
            continue;
          }
          if (isIgnoredOverriddenSymbol(overriddenSymbol)) {
            continue;
          }
          Package overriddenSymbolPkg =
              packages.packageForSymbol(overriddenSymbol).orElse(Package.EMPTY);
          scipInfo.addRelationships(
              Scip.Relationship.newBuilder()
                  .setSymbol(typedSymbol(overriddenSymbol, overriddenSymbolPkg))
                  .setIsImplementation(true)
                  .setIsReference(supportsReferenceRelationship(info)));
        }
        if (info.hasSignature()) {
          String language =
              doc.semanticdb.getLanguage().toString().toLowerCase(Locale.ROOT).intern();
          String signature = new SignatureFormatter(info, symtab).formatSymbol();
          scipInfo.addDocumentation("```" + language + "\n" + signature + "\n```");
        }
        String documentation = info.getDocumentation().getMessage();
        if (!documentation.isEmpty()) {
          scipInfo.addDocumentation(documentation);
        }
        tdoc.addSymbols(scipInfo);
      }
      writer.emitTyped(Scip.Index.newBuilder().addDocuments(tdoc).build());
    }
  }

  private void addReferenceRelationships(
      Symtab symtab,
      SymbolInformation info,
      Scip.SymbolInformation.Builder scipInfo,
      @Nullable ArrayList<String> clique,
      PackageTable packages) {
    if (clique == null) {
      return;
    }
    for (String symbol : clique) {
      if (symbol.equals(info.getSymbol())) {
        continue;
      }
      SymbolInformation otherInfo = symtab.symbols.get(symbol);
      if (otherInfo == null) {
        continue;
      }
      if (!symbol.endsWith(".apply().")
          && !otherInfo.getDisplayName().equals(info.getDisplayName())) {
        continue;
      }
      Package pkg = packages.packageForSymbol(symbol).orElse(Package.EMPTY);
      scipInfo.addRelationships(
          Scip.Relationship.newBuilder().setSymbol(typedSymbol(symbol, pkg)).setIsReference(true));
    }
  }

  private Scip.Index typedMetadata() {
    return Scip.Index.newBuilder()
        .setMetadata(
            Scip.Metadata.newBuilder()
                .setVersion(Scip.ProtocolVersion.UnspecifiedProtocolVersion)
                .setProjectRoot(options.sourceroot.toUri().toString())
                .setTextDocumentEncoding(Scip.TextEncoding.UTF8)
                .setToolInfo(
                    Scip.ToolInfo.newBuilder()
                        .setName(options.toolInfo.getName())
                        .setVersion(options.toolInfo.getVersion())
                        .addAllArguments(options.toolInfo.getArgsList())))
        .build();
  }

  private void runGraph(List<Path> files, PackageTable packages) {
    writer.emitMetaData();
    int projectId = writer.emitProject(options.language);

    Set<String> isExportedSymbol = exportSymbols(files);
    List<Integer> documentIds =
        filesStream(files)
            .flatMap(d -> processPath(d, isExportedSymbol, packages))
            .collect(Collectors.toList());
    writer.emitContains(projectId, documentIds);
  }

  private Stream<Path> filesStream(List<Path> files) {
    return options.parallel ? files.parallelStream() : files.stream();
  }

  private static class InverseReferenceRelationships {
    public final Map<String, ArrayList<String>> map;

    private InverseReferenceRelationships(Map<String, ArrayList<String>> map) {
      this.map = map;
    }
  }

  private InverseReferenceRelationships inverseReferenceRelationships(List<Path> files) {
    if (!options.emitInverseRelationships) {
      return new InverseReferenceRelationships(Collections.emptyMap());
    }
    return new InverseReferenceRelationships(
        filesStream(files)
            .flatMap(this::parseTextDocument)
            .flatMap(this::referenceRelationships)
            .collect(
                Collectors.groupingBy(
                    SymbolRelationship::getTo,
                    Collectors.mapping(
                        SymbolRelationship::getFrom, Collectors.toCollection(ArrayList::new)))));
  }

  private Stream<SymbolRelationship> referenceRelationships(ScipTextDocument document) {
    ArrayList<SymbolRelationship> relationships = new ArrayList<>();
    for (int i = 0; i < document.semanticdb.getSymbolsCount(); i++) {
      SymbolInformation info = document.semanticdb.getSymbols(i);
      if (!supportsReferenceRelationship(info)) {
        continue;
      }
      if (info.getSymbol().isEmpty() || SemanticdbSymbols.isLocal(info.getSymbol())) {
        continue;
      }
      for (int j = 0; j < info.getOverriddenSymbolsCount(); j++) {
        String overriddenSymbol = info.getOverriddenSymbols(j);
        if (SemanticdbSymbols.isLocal(overriddenSymbol)) {
          continue;
        }
        relationships.add(new SymbolRelationship(info.getSymbol(), overriddenSymbol));
      }
    }
    return relationships.stream();
  }

  private Set<String> exportSymbols(List<Path> files) {
    return filesStream(files)
        .flatMap(this::parseTextDocument)
        .flatMap(
            d ->
                d.semanticdb.getOccurrencesList().stream()
                    .filter(occ -> isDefinitionRole(occ.getRole()))
                    .map(SymbolOccurrence::getSymbol)
                    .filter(SemanticdbSymbols::isGlobal))
        .collect(Collectors.toSet());
  }

  private Stream<Integer> processPath(
      Path path, Set<String> isExportedSymbol, PackageTable packages) {
    return parseTextDocument(path).flatMap(d -> processDocument(d, isExportedSymbol, packages));
  }

  private Stream<Integer> processDocument(
      ScipTextDocument doc, Set<String> isExportedSymbol, PackageTable packages) {
    try {
      return Stream.of(processDocumentUnsafe(doc, isExportedSymbol, packages));
    } catch (Exception e) {
      options.reporter.error(new ScipProcessingException(doc, e));
      return Stream.empty();
    }
  }

  private Integer processDocumentUnsafe(
      ScipTextDocument doc, Set<String> isExportedSymbol, PackageTable packages) {
    Symtab symtab = new Symtab(doc.semanticdb);

    int documentId = writer.emitDocument(doc);
    Set<String> localDefinitions =
        doc.semanticdb.getOccurrencesList().stream()
            .filter(
                occ ->
                    isDefinitionRole(occ.getRole()) && SemanticdbSymbols.isLocal(occ.getSymbol()))
            .map(SymbolOccurrence::getSymbol)
            .collect(Collectors.toSet());
    doc.id = documentId;
    ResultSets results =
        new ResultSets(writer, globals, isExportedSymbol, localDefinitions, packages, options);
    Set<Integer> rangeIds = new LinkedHashSet<>();

    for (SymbolOccurrence occ : doc.sortedSymbolOccurrences()) {
      for (String symbol : occ.getSymbol().split(";")) {
        SymbolInformation symbolInformation =
            doc.symbols.getOrDefault(symbol, SymbolInformation.getDefaultInstance());
        ResultIds ids = results.getOrInsertResultSet(symbol);
        int rangeId = writer.emitRange(occ.getRange());
        rangeIds.add(rangeId);

        // Range
        if (occ.getRole() != Role.SYNTHETIC_DEFINITION) {
          writer.emitNext(rangeId, ids.resultSet);
        }

        // Reference
        writer.emitItem(ids.referenceResult, rangeId, doc.id);

        // Definition
        if (isDefinitionRole(occ.getRole())) {
          if (ids.isDefinitionDefined()) {
            writer.emitItem(ids.definitionResult, rangeId, doc.id);
          } else {
            options.reporter.error(
                new NoSuchElementException(
                    String.format("no definition ID for symbol '%s'", symbol)));
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
            // Always emit a non-empty hover message to prevent Sourcegraph from falling
            // back to
            // Search-Based hover messages.
            markupContent.append(symbolInformation.getDisplayName());
          }

          int hoverId =
              writer.emitHoverResult(
                  new MarkupContent(MarkupKind.MARKDOWN, markupContent.toString()));
          writer.emitHoverEdge(ids.resultSet, hoverId);
        }

        // Overrides
        if (symbolInformation.getOverriddenSymbolsCount() > 0
            && supportsReferenceRelationship(symbolInformation)
            && occ.getRole() == Role.DEFINITION) {
          List<Integer> overriddenReferenceResultIds =
              new ArrayList<>(symbolInformation.getOverriddenSymbolsCount());
          for (int i = 0; i < symbolInformation.getOverriddenSymbolsCount(); i++) {
            String overriddenSymbol = symbolInformation.getOverriddenSymbols(i);
            if (isIgnoredOverriddenSymbol(overriddenSymbol)) {
              continue;
            }
            ResultIds overriddenIds = results.getOrInsertResultSet(overriddenSymbol);
            overriddenReferenceResultIds.add(overriddenIds.referenceResult);
            writer.emitReferenceResultsItemEdge(
                overriddenIds.referenceResult, Collections.singletonList(rangeId), doc.id);
          }
          if (overriddenReferenceResultIds.size() > 0) {
            writer.emitReferenceResultsItemEdge(
                ids.referenceResult, overriddenReferenceResultIds, doc.id);
          }
        }
      }
    }
    writer.emitContains(doc.id, new ArrayList<>(rangeIds));
    writer.flush();
    options.reporter.processedOneItem();
    return documentId;
  }

  private static boolean supportsReferenceRelationship(SymbolInformation info) {
    switch (info.getKind()) {
      case CLASS:
      case OBJECT:
      case PACKAGE_OBJECT:
        return false;
      default:
        return true;
    }
  }

  private Stream<ScipTextDocument> parseTextDocument(Path semanticdbPath) {
    try {
      return textDocumentsParseFrom(semanticdbPath).getDocumentsList().stream()
          .filter(sdb -> !sdb.getOccurrencesList().isEmpty())
          .map(sdb -> new ScipTextDocument(semanticdbPath, sdb, options.sourceroot));
    } catch (IOException e) {
      options.reporter.error("invalid protobuf: " + semanticdbPath);
      options.reporter.error(e);
      return Stream.empty();
    }
  }

  private static PathMatcher jarPattern = FileSystems.getDefault().getPathMatcher("glob:**.jar");

  private Semanticdb.TextDocuments textDocumentsParseFrom(Path semanticdbPath) throws IOException {
    if (jarPattern.matches(semanticdbPath)) {
      return textDocumentsParseJarFile(semanticdbPath);
    }
    return textDocumentsParseFromBytes(Files.readAllBytes(semanticdbPath));
  }

  private Semanticdb.TextDocuments textDocumentsParseJarFile(Path jarFile) throws IOException {
    Semanticdb.TextDocuments.Builder result = Semanticdb.TextDocuments.newBuilder();
    try (JarFile file = new JarFile(jarFile.toFile())) {
      Enumeration<JarEntry> entries = file.entries();
      while (entries.hasMoreElements()) {
        JarEntry element = entries.nextElement();
        if (element.getName().endsWith(".semanticdb")) {
          byte[] bytes = InputStreamBytes.readAll(file.getInputStream(element));
          result.addAllDocuments(textDocumentsParseFromBytes(bytes).getDocumentsList());
        }
      }
    }
    return result.build();
  }

  private Semanticdb.TextDocuments textDocumentsParseFromBytes(byte[] bytes) throws IOException {
    try {
      CodedInputStream in = CodedInputStream.newInstance(bytes);
      in.setRecursionLimit(1000);
      return Semanticdb.TextDocuments.parseFrom(in);
    } catch (NoSuchMethodError ignored) {
      // NOTE(olafur): For some reason, NoSuchMethodError gets thrown when running
      // `snapshots/run`
      // in the sbt build. I'm unable to reproduce the error in `snapshots/test` or
      // when running the
      // published version
      // of `scip-java index`.
      return Semanticdb.TextDocuments.parseFrom(bytes);
    }
  }

  private boolean isIgnoredOverriddenSymbol(String symbol) {
    // Skip java/lang/Object# and similar symbols from Scala since it's the parent
    // of all classes
    // making it noisy for "find implementations" results.
    return symbol.equals("java/lang/Object#");
  }
}
