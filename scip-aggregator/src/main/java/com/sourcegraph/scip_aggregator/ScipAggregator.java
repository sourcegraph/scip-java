package com.sourcegraph.scip_aggregator;

import com.google.protobuf.CodedInputStream;
import com.sourcegraph.scip.ScipSymbols;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;
import org.scip_code.scip.Document;
import org.scip_code.scip.Index;
import org.scip_code.scip.Metadata;
import org.scip_code.scip.Occurrence;
import org.scip_code.scip.ProtocolVersion;
import org.scip_code.scip.Relationship;
import org.scip_code.scip.SymbolInformation;
import org.scip_code.scip.TextEncoding;
import org.scip_code.scip.ToolInfo;

/**
 * Aggregates per-source SCIP shards (one {@link Index} per {@code *.scip} file emitted by the
 * compiler plugins) into a single SCIP index. The aggregator:
 *
 * <ul>
 *   <li>discovers shards under each requested target root,
 *   <li>resolves each shard's bare-descriptor symbols to fully-qualified SCIP symbols using a
 *       {@link PackageTable},
 *   <li>optionally adds inverse-reference relationships across documents, and
 *   <li>emits a single {@link Index} with leading {@link Metadata}.
 * </ul>
 */
public class ScipAggregator {
  private static final PathMatcher JAR_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.jar");
  private static final PathMatcher SCIP_PATTERN =
      FileSystems.getDefault().getPathMatcher("glob:**.scip");

  private final ScipWriter writer;
  private final ScipAggregatorOptions options;

  public ScipAggregator(ScipWriter writer, ScipAggregatorOptions options) {
    this.writer = writer;
    this.options = options;
  }

  public static void run(ScipAggregatorOptions options) throws IOException {
    ScipWriter writer = new ScipWriter(options);
    new ScipAggregator(writer, options).run();
  }

  private void run() throws IOException {
    PackageTable packages = new PackageTable(options);
    SymbolRewriter rewriter = new SymbolRewriter(packages);
    List<Path> shards = findShards();
    Collections.sort(shards);
    if (options.reporter().hasErrors()) return;
    if (shards.isEmpty() && !options.allowEmptyIndex()) {
      options
          .reporter()
          .error(
              "No SCIP shards found. This typically means that `scip-java` is unable to"
                  + " automatically index this codebase. If you are using Gradle or Maven, please"
                  + " report an issue to https://github.com/sourcegraph/scip-java and include steps"
                  + " to reproduce. If you are using a different build tool, make sure that you"
                  + " have followed all of the manual configuration steps.");
      return;
    }
    options.reporter().startProcessing(shards.size());
    writer.emitTyped(metadataIndex());

    Map<String, List<String>> inverseReferences = computeInverseReferences(shards, rewriter);
    shardStream(shards).forEach(shard -> processShard(shard, rewriter, inverseReferences));
    writer.build();
    options.reporter().endProcessing();
  }

  /**
   * Returns every {@code *.scip} shard under {@code options.targetroots}. A targetroot that happens
   * to be a {@code .jar} is included as-is so callers can pick out shards stored inside.
   */
  private List<Path> findShards() throws IOException {
    List<Path> shards = new ArrayList<>();
    SimpleFileVisitor<Path> visitor =
        new SimpleFileVisitor<Path>() {
          @Override
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (SCIP_PATTERN.matches(file)) shards.add(file);
            return FileVisitResult.CONTINUE;
          }

          @Override
          public FileVisitResult visitFileFailed(Path file, IOException exc) {
            options.reporter().error(exc);
            return FileVisitResult.CONTINUE;
          }
        };
    for (Path root : options.targetroots()) {
      if (JAR_PATTERN.matches(root)) shards.add(root);
      else if (Files.isDirectory(root)) Files.walkFileTree(root, visitor);
      else
        options
            .reporter()
            .warning("ignoring target root that does not exist or is not a directory: " + root);
    }
    return shards;
  }

  private Index metadataIndex() {
    return Index.newBuilder()
        .setMetadata(
            Metadata.newBuilder()
                .setVersion(ProtocolVersion.UnspecifiedProtocolVersion)
                .setProjectRoot(options.sourceroot().toUri().toString())
                .setTextDocumentEncoding(TextEncoding.UTF8)
                .setToolInfo(
                    ToolInfo.newBuilder()
                        .setName(options.toolInfo().getName())
                        .setVersion(options.toolInfo().getVersion())
                        .addAllArguments(options.toolInfo().getArgumentsList())))
        .build();
  }

  private void processShard(
      Path shardPath, SymbolRewriter rewriter, Map<String, List<String>> inverseReferences) {
    for (Document shard : readShard(shardPath)) {
      Document rewritten = rewriteDocument(shard, rewriter, inverseReferences);
      writer.emitTyped(Index.newBuilder().addDocuments(rewritten).build());
      options.reporter().processedOneItem();
    }
  }

  private Document rewriteDocument(
      Document shard, SymbolRewriter rewriter, Map<String, List<String>> inverseReferences) {
    Document.Builder out =
        Document.newBuilder()
            .setLanguage(shard.getLanguage())
            .setRelativePath(shard.getRelativePath());
    if (!shard.getText().isEmpty()) out.setText(shard.getText());

    for (Occurrence occ : shard.getOccurrencesList()) {
      Occurrence.Builder rebuilt =
          Occurrence.newBuilder()
              .setSymbol(rewriter.rewrite(occ.getSymbol()))
              .setSymbolRoles(occ.getSymbolRoles());
      switch (occ.getTypedRangeCase()) {
        case SINGLE_LINE_RANGE -> rebuilt.setSingleLineRange(occ.getSingleLineRange());
        case MULTI_LINE_RANGE -> rebuilt.setMultiLineRange(occ.getMultiLineRange());
        case TYPEDRANGE_NOT_SET ->
            throw new IllegalArgumentException("expected SCIP 0.9 typed occurrence range");
      }
      switch (occ.getTypedEnclosingRangeCase()) {
        case SINGLE_LINE_ENCLOSING_RANGE ->
            rebuilt.setSingleLineEnclosingRange(occ.getSingleLineEnclosingRange());
        case MULTI_LINE_ENCLOSING_RANGE ->
            rebuilt.setMultiLineEnclosingRange(occ.getMultiLineEnclosingRange());
        case TYPEDENCLOSINGRANGE_NOT_SET -> {}
      }
      out.addOccurrences(rebuilt);
    }

    for (SymbolInformation info : shard.getSymbolsList()) {
      SymbolInformation.Builder rebuilt =
          SymbolInformation.newBuilder()
              .setSymbol(rewriter.rewrite(info.getSymbol()))
              .setDisplayName(info.getDisplayName())
              .setKind(info.getKind());
      if (info.hasSignatureDocumentation()) {
        rebuilt.setSignatureDocumentation(info.getSignatureDocumentation());
      }
      if (!info.getEnclosingSymbol().isEmpty()) {
        rebuilt.setEnclosingSymbol(rewriter.rewrite(info.getEnclosingSymbol()));
      }
      for (String doc : info.getDocumentationList()) rebuilt.addDocumentation(doc);
      for (Relationship rel : info.getRelationshipsList()) {
        rebuilt.addRelationships(
            Relationship.newBuilder(rel).setSymbol(rewriter.rewrite(rel.getSymbol())));
      }
      List<String> inverse = inverseReferences.get(info.getSymbol());
      if (inverse != null) {
        for (String overrider : inverse) {
          rebuilt.addRelationships(
              Relationship.newBuilder()
                  .setSymbol(rewriter.rewrite(overrider))
                  .setIsImplementation(true)
                  .setIsReference(true));
        }
      }
      out.addSymbols(rebuilt);
    }
    return out.build();
  }

  /**
   * Builds {@code overridden-symbol → [overriding-symbols]} for every method-style relationship.
   * Class/interface parent relationships are excluded because they shouldn't surface as
   * find-references results (TODO: drop once sourcegraph#50927 is fixed).
   */
  private Map<String, List<String>> computeInverseReferences(
      List<Path> shards, SymbolRewriter rewriter) {
    if (!options.emitInverseRelationships()) return Collections.emptyMap();
    Map<String, List<String>> result = new HashMap<>();
    for (Path shard : shards) {
      for (Document doc : readShard(shard)) {
        for (SymbolInformation info : doc.getSymbolsList()) {
          if (!supportsReferenceRelationship(info)) continue;
          if (info.getSymbol().isEmpty() || ScipSymbols.isLocal(info.getSymbol())) continue;
          for (Relationship rel : info.getRelationshipsList()) {
            if (!rel.getIsImplementation()) continue;
            if (ScipSymbols.isLocal(rel.getSymbol())) continue;
            if (isIgnoredOverriddenSymbol(rel.getSymbol())) continue;
            result.computeIfAbsent(rel.getSymbol(), k -> new ArrayList<>()).add(info.getSymbol());
          }
        }
      }
    }
    return result;
  }

  private static boolean supportsReferenceRelationship(SymbolInformation info) {
    return switch (info.getKind()) {
      case Class, Enum, Interface, Type, Object, PackageObject -> false;
      default -> true;
    };
  }

  private static boolean isIgnoredOverriddenSymbol(String symbol) {
    // Skip java/lang/Object# from cross-shard reference relationships; it's the parent
    // of every class and would dominate "find implementations" results.
    return symbol.endsWith("java/lang/Object#");
  }

  private Stream<Path> shardStream(List<Path> shards) {
    return options.parallel() ? shards.parallelStream() : shards.stream();
  }

  private Collection<Document> readShard(Path shardPath) {
    try {
      if (JAR_PATTERN.matches(shardPath)) return readShardsFromJar(shardPath);
      return Index.parseFrom(parseFromBytes(Files.readAllBytes(shardPath))).getDocumentsList();
    } catch (IOException e) {
      options.reporter().error("invalid SCIP shard: " + shardPath);
      options.reporter().error(e);
      return Collections.emptyList();
    }
  }

  private Collection<Document> readShardsFromJar(Path jarFile) throws IOException {
    List<Document> result = new ArrayList<>();
    try (JarFile jar = new JarFile(jarFile.toFile())) {
      Enumeration<JarEntry> entries = jar.entries();
      while (entries.hasMoreElements()) {
        JarEntry entry = entries.nextElement();
        if (!entry.getName().endsWith(".scip")) continue;
        byte[] bytes = InputStreamBytes.readAll(jar.getInputStream(entry));
        result.addAll(Index.parseFrom(parseFromBytes(bytes)).getDocumentsList());
      }
    }
    return result;
  }

  private static CodedInputStream parseFromBytes(byte[] bytes) {
    CodedInputStream in = CodedInputStream.newInstance(bytes);
    in.setRecursionLimit(1000);
    return in;
  }
}
