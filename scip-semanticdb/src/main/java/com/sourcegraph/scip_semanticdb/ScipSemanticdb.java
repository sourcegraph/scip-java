package com.sourcegraph.scip_semanticdb;

import com.google.protobuf.CodedInputStream;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence;
import com.sourcegraph.semanticdb_javac.Semanticdb.SymbolOccurrence.Role;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Metadata;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.ProtocolVersion;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.Signature;
import org.scip_code.scip.SymbolInformation;
import org.scip_code.scip.SymbolRole;
import org.scip_code.scip.TextEncoding;
import org.scip_code.scip.ToolInfo;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/** The core logic that converts SemanticDB into SCIP. */
public class ScipSemanticdb {
  private final ScipWriter writer;
  private final ScipSemanticdbOptions options;

  public ScipSemanticdb(ScipWriter writer, ScipSemanticdbOptions options) {
    this.writer = writer;
    this.options = options;
  }

  public static void run(ScipSemanticdbOptions options) throws IOException {
    ScipWriter writer = new ScipWriter(options);
    new ScipSemanticdb(writer, options).run();
  }

  private void run() throws IOException {
    PackageTable packages = new PackageTable(options);
    List<Path> files = SemanticdbWalker.findSemanticdbFiles(options);
    Collections.sort(files);
    if (options.reporter.hasErrors()) return;
    if (files.isEmpty() && !options.allowEmptyIndex) {
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
    runTyped(files, packages);
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

  private static SymbolInformation.Kind scipKind(Semanticdb.SymbolInformation info) {
    Semanticdb.SymbolInformation.Kind kind = info.getKind();
    int properties = info.getProperties();
    boolean isStatic = (properties & Semanticdb.SymbolInformation.Property.STATIC_VALUE) > 0;
    boolean isAbstract = (properties & Semanticdb.SymbolInformation.Property.ABSTRACT_VALUE) > 0;
    boolean isEnum = (properties & Semanticdb.SymbolInformation.Property.ENUM_VALUE) > 0;

    switch (kind) {
      case CLASS:
        if (isEnum) {
          return SymbolInformation.Kind.Enum;
        } else {
          return SymbolInformation.Kind.Class;
        }
      case CONSTRUCTOR:
        return SymbolInformation.Kind.Constructor;
      case FIELD:
        if (isStatic) {
          return SymbolInformation.Kind.StaticField;
        } else {
          return SymbolInformation.Kind.Field;
        }
      case INTERFACE:
        return SymbolInformation.Kind.Interface;
      case LOCAL:
        if (isStatic) {
          return SymbolInformation.Kind.StaticVariable;
        } else {
          return SymbolInformation.Kind.Variable;
        }
      case MACRO:
        return SymbolInformation.Kind.Macro;
      case METHOD:
        if (isStatic) {
          return SymbolInformation.Kind.StaticMethod;
        } else if (isAbstract) {
          return SymbolInformation.Kind.AbstractMethod;
        } else {
          return SymbolInformation.Kind.Method;
        }
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
        if (isEnum) {
          return SymbolInformation.Kind.Enum;
        } else {
          return SymbolInformation.Kind.Type;
        }
      case TYPE_PARAMETER:
        return SymbolInformation.Kind.TypeParameter;
      case UNKNOWN_KIND:
        return SymbolInformation.Kind.UnspecifiedKind;
    }

    return SymbolInformation.Kind.UnspecifiedKind;
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
      Document.Builder tdoc = Document.newBuilder().setRelativePath(relativePath);
      for (SymbolOccurrence occ : doc.sortedSymbolOccurrences()) {
        if (occ.getSymbol().isEmpty()) {
          continue;
        }
        int role = 0;
        if (isDefinitionRole(occ.getRole())) {
          role |= SymbolRole.Definition_VALUE;
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
        Occurrence.Builder occBuilder =
            Occurrence.newBuilder()
                .addAllRange(range)
                .setSymbol(typedSymbol(occ.getSymbol(), pkg))
                .setSymbolRoles(role);
        // Add enclosing_range if it exists
        if (occ.hasEnclosingRange()) {
          Semanticdb.Range enclosingRange = occ.getEnclosingRange();
          boolean isEnclosingSingleLine =
              enclosingRange.getStartLine() == enclosingRange.getEndLine();
          Iterable<Integer> enclosingRangeInts =
              isEnclosingSingleLine
                  ? Arrays.asList(
                      enclosingRange.getStartLine(),
                      enclosingRange.getStartCharacter(),
                      enclosingRange.getEndCharacter())
                  : Arrays.asList(
                      enclosingRange.getStartLine(),
                      enclosingRange.getStartCharacter(),
                      enclosingRange.getEndLine(),
                      enclosingRange.getEndCharacter());
          occBuilder.addAllEnclosingRange(enclosingRangeInts);
        }
        tdoc.addOccurrences(occBuilder);
      }
      Symtab symtab = new Symtab(doc.semanticdb);
      for (Semanticdb.SymbolInformation info : doc.semanticdb.getSymbolsList()) {
        if (info.getSymbol().isEmpty()) {
          continue;
        }
        Package pkg = packages.packageForSymbol(info.getSymbol()).orElse(Package.EMPTY);
        SymbolInformation.Builder scipInfo =
            SymbolInformation.newBuilder().setSymbol(typedSymbol(info.getSymbol(), pkg));

        scipInfo.setDisplayName(info.getDisplayName());
        if (!info.getEnclosingSymbol().isEmpty()) {
          scipInfo.setEnclosingSymbol(typedSymbol(info.getEnclosingSymbol(), pkg));
        }

        scipInfo.setKind(scipKind(info));

        // TODO: this can be removed once https://github.com/sourcegraph/sourcegraph/issues/50927 is
        // fixed.
        ArrayList<String> inverseReferences = references.map.get(info.getSymbol());
        if (inverseReferences != null) {
          for (String inverseReference : inverseReferences) {
            Package inverseReferencePkg =
                packages.packageForSymbol(inverseReference).orElse(Package.EMPTY);
            scipInfo.addRelationships(
                Relationship.newBuilder()
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
          Semanticdb.SymbolInformation definitionInfo = symtab.symbols.get(definitionSymbol);

          scipInfo.addRelationships(
              Relationship.newBuilder()
                  .setSymbol(typedSymbol(definitionSymbol, definitionSymbolPkg))
                  .setIsDefinition(true)
                  .setIsReference(
                      definitionInfo != null
                          && definitionInfo.getDisplayName().equals(info.getDisplayName())
                          && supportsReferenceRelationship(info)));
        }

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
              Relationship.newBuilder()
                  .setSymbol(typedSymbol(overriddenSymbol, overriddenSymbolPkg))
                  .setIsImplementation(true)
                  .setIsReference(supportsReferenceRelationship(info)));
        }
        if (info.hasSignature()) {
          String language =
              doc.semanticdb.getLanguage().toString().toLowerCase(Locale.ROOT).intern();
          String signature = new SignatureFormatter(info, symtab).formatSymbol();
          Signature.Builder signatureDocumentation =
              Signature.newBuilder().setLanguage(language).setText(signature);
          scipInfo.setSignatureDocumentation(signatureDocumentation);
        }
        String documentation = info.getDocumentation().getMessage();
        if (!documentation.isEmpty()) {
          scipInfo.addDocumentation(documentation);
        }
        tdoc.addSymbols(scipInfo);
      }
      writer.emitTyped(Index.newBuilder().addDocuments(tdoc).build());
    }
  }

  private Index typedMetadata() {
    return Index.newBuilder()
        .setMetadata(
            Metadata.newBuilder()
                .setVersion(ProtocolVersion.UnspecifiedProtocolVersion)
                .setProjectRoot(options.sourceroot.toUri().toString())
                .setTextDocumentEncoding(TextEncoding.UTF8)
                .setToolInfo(
                    ToolInfo.newBuilder()
                        .setName(options.toolInfo.getName())
                        .setVersion(options.toolInfo.getVersion())
                        .addAllArguments(options.toolInfo.getArgumentsList())))
        .build();
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
      Semanticdb.SymbolInformation info = document.semanticdb.getSymbols(i);
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

  private static boolean supportsReferenceRelationship(Semanticdb.SymbolInformation info) {
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
