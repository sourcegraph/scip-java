package com.sourcegraph.lsif_semanticdb;

import com.sourcegraph.lsif_protocol.LsifHover;
import com.sourcegraph.lsif_protocol.LsifHover.Content;
import com.sourcegraph.lsif_protocol.LsifObject;
import com.sourcegraph.lsif_protocol.LsifPosition;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/** High-level utility methods to write LSIF vertex/edge objects into the LSIF output stream. */
public class LsifWriter implements AutoCloseable {

  private final Path tmp;
  private final LsifOutputStream output;
  private final LsifSemanticdbOptions options;
  private final AtomicInteger id = new AtomicInteger();

  public LsifWriter(LsifSemanticdbOptions options) throws IOException {
    this.tmp = Files.createTempFile("lsif-semanticdb", "dump.lsif");
    this.output =
        new LsifOutputStream(options, new BufferedOutputStream(Files.newOutputStream(tmp)));
    this.options = options;
  }

  public void emitMetaData() {
    emitObject(
        lsifVertex("metaData")
            .setVersion("0.4.3")
            .setProjectRoot(options.sourceroot.toUri().toString())
            .setPositionEncoding("utf-16")
            .setToolInfo(options.toolInfo));
  }

  public int emitProject(String language) {
    return emitObject(lsifVertex("project").setKind(language));
  }

  public int emitDocument(LsifTextDocument doc) {
    return emitObject(
        lsifVertex("document")
            .setUri(doc.semanticdb.getUri())
            .setLanguage(doc.semanticdb.getLanguage().toString().toLowerCase()));
  }

  public void emitContains(int outV, List<Integer> inVs) {
    emitObject(lsifEdge("contains").setOutV(outV).addAllInVs(inVs));
  }

  public int emitRange(Semanticdb.Range range) {
    return emitObject(
        lsifVertex("range")
            .setStart(
                LsifPosition.newBuilder()
                    .setLine(range.getStartLine())
                    .setCharacter(range.getStartCharacter()))
            .setEnd(
                LsifPosition.newBuilder()
                    .setLine(range.getEndLine())
                    .setCharacter(range.getEndCharacter())));
  }

  public int emitResultSet() {
    return emitObject(lsifVertex("resultSet"));
  }

  public void emitNext(int outV, int inV) {
    emitObject(lsifEdge("next").setOutV(outV).setInV(inV));
  }

  public void emitEdge(String label, int outV, int inV) {
    emitObject(lsifEdge(label).setOutV(outV).setInV(inV));
  }

  public int emitReferenceResult(int resultSet) {
    int referenceResult = emitObject(lsifVertex("referenceResult"));
    emitEdge("textDocument/reference", resultSet, referenceResult);
    return referenceResult;
  }

  public int emitDefinitionResult(int resultSet) {
    int definitionResult = emitObject(lsifVertex("definitionResult"));
    emitEdge("textDocument/definition", resultSet, definitionResult);
    return definitionResult;
  }

  public int emitHoverResult(MarkedString... markedStrings) {
    return emitObject(
        lsifVertex("hoverResult")
            .setResult(
                LsifHover.newBuilder()
                    .addAllContents(
                        Arrays.stream(markedStrings)
                            .map(
                                (ms) ->
                                    Content.newBuilder()
                                        .setLanguage(
                                            ms.language.toString().toLowerCase(Locale.ROOT))
                                        .setValue(ms.value)
                                        .build())
                            .collect(Collectors.toList()))));
  }

  public void emitHoverEdge(int outV, int inV) {
    emitObject(lsifEdge("textDocument/hover").setOutV(outV).setInV(inV));
  }

  public void emitMonikerEdge(int outV, int inV) {
    emitObject(lsifEdge("moniker").setOutV(outV).setInV(inV));
  }

  public int emitMonikerVertex(String symbol, boolean isExportedSymbol) {
    String kind = isExportedSymbol ? "export" : "import";
    return emitObject(
        lsifVertex("moniker").setKind(kind).setScheme("semanticdb").setIdentifier(symbol));
  }

  public void emitItem(int outV, int inV, int document) {
    emitObject(lsifEdge("item").setOutV(outV).addInVs(inV).setDocument(document));
  }

  public void build() throws IOException {
    close();
    Files.move(tmp, options.output, StandardCopyOption.REPLACE_EXISTING);
  }

  @Override
  public void close() throws IOException {
    output.flush();
  }

  public void flush() {
    try {
      output.flush();
    } catch (IOException e) {
      options.reporter.error(e);
    }
  }

  public int emitObject(LsifObject.Builder object) {
    output.writeLsifObject(object);
    return object.getId();
  }

  private LsifObject.Builder lsifObject() {
    return LsifObject.newBuilder().setId(nextId());
  }

  private LsifObject.Builder lsifEdge(String label) {
    return lsifObject().setType("edge").setLabel(label);
  }

  private LsifObject.Builder lsifVertex(String label) {
    return lsifObject().setType("vertex").setLabel(label);
  }

  private int nextId() {
    return id.incrementAndGet();
  }
}
