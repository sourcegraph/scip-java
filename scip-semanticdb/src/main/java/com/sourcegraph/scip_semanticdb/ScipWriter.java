package com.sourcegraph.scip_semanticdb;

import com.sourcegraph.lsif_protocol.LsifHover;
import com.sourcegraph.lsif_protocol.LsifHover.Content;
import com.sourcegraph.lsif_protocol.LsifObject;
import com.sourcegraph.lsif_protocol.LsifPosition;
import com.sourcegraph.semanticdb_javac.Semanticdb;
import com.sourcegraph.semanticdb_javac.SemanticdbSymbols;
import com.sourcegraph.Scip;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/** High-level utility methods to write SCIP vertex/edge objects into the SCIP output stream. */
public class ScipWriter implements AutoCloseable {

  private final Path tmp;
  private final ScipOutputStream output;
  private final ScipSemanticdbOptions options;
  private final AtomicInteger id = new AtomicInteger();

  public ScipWriter(ScipSemanticdbOptions options) throws IOException {
    if (OperatingSystem.isWindows()) {
      this.tmp = Files.createTempFile("scip-semanticdb", "index.scip");
    } else {
      this.tmp =
          Files.createTempFile(
              "scip-semanticdb",
              "index.scip",
              PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-r--r--")));
    }
    this.output =
        new ScipOutputStream(options, new BufferedOutputStream(Files.newOutputStream(tmp)));
    this.options = options;
  }

  public void emitTyped(Scip.Index index) {
    this.output.write(index.toByteArray());
  }

  public void emitMetaData() {
    emitObject(
        scipVertex("metaData")
            .setVersion("0.4.3")
            .setProjectRoot(options.sourceroot.toUri().toString())
            .setPositionEncoding("utf-16")
            .setToolInfo(options.toolInfo));
  }

  public int emitProject(String language) {
    return emitObject(scipVertex("project").setKind(language));
  }

  public int emitDocument(ScipTextDocument doc) {
    return emitObject(
        scipVertex("document")
            .setUri(doc.semanticdb.getUri())
            .setLanguage(doc.semanticdb.getLanguage().toString().toLowerCase()));
  }

  public void emitContains(int outV, List<Integer> inVs) {
    emitObject(scipEdge("contains").setOutV(outV).addAllInVs(inVs));
  }

  public int emitRange(Semanticdb.Range range) {
    return emitObject(
        scipVertex("range")
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
    return emitObject(scipVertex("resultSet"));
  }

  public void emitNext(int outV, int inV) {
    emitObject(scipEdge("next").setOutV(outV).setInV(inV));
  }

  public void emitEdge(String label, int outV, int inV) {
    emitObject(scipEdge(label).setOutV(outV).setInV(inV));
  }

  public int emitReferenceResult(int resultSet) {
    int referenceResult = emitObject(scipVertex("referenceResult"));
    emitEdge("textDocument/references", resultSet, referenceResult);
    return referenceResult;
  }

  public int emitDefinitionResult(int resultSet) {
    int definitionResult = emitObject(scipVertex("definitionResult"));
    emitEdge("textDocument/definition", resultSet, definitionResult);
    return definitionResult;
  }

  public int emitHoverResult(MarkupContent markupContents) {
    return emitObject(
        scipVertex("hoverResult")
            .setResult(
                LsifHover.newBuilder()
                    .setContents(
                        Content.newBuilder()
                            .setKind(markupContents.kind.toString().toLowerCase())
                            .setValue(markupContents.value))));
  }

  public void emitHoverEdge(int outV, int inV) {
    emitObject(scipEdge("textDocument/hover").setOutV(outV).setInV(inV));
  }

  public void emitMonikerEdge(int outV, int inV) {
    emitObject(scipEdge("moniker").setOutV(outV).setInV(inV));
  }

  public int emitMonikerVertex(String symbol, boolean isExportedSymbol) {
    String kind =
        SemanticdbSymbols.isLocal(symbol) ? "local" : isExportedSymbol ? "export" : "import";
    return emitObject(
        scipVertex("moniker").setKind(kind).setScheme("semanticdb").setIdentifier(symbol));
  }

  public void emitPackageInformationEdge(int monikerId, int packageId) {
    emitObject(scipEdge("packageInformation").setOutV(monikerId).setInV(packageId));
  }

  public int emitpackageinformationVertex(Package pkg) {
    return emitObject(
        scipVertex("packageInformation")
            .setName(pkg.repoName())
            .setManager("jvm-dependencies")
            .setVersion(pkg.version()));
  }

  public void emitItem(int outV, int inV, int document) {
    emitObject(scipEdge("item").setOutV(outV).addInVs(inV).setDocument(document));
  }

  public void emitReferenceResultsItemEdge(int outV, Iterable<Integer> inVs, int document) {
    emitObject(
        scipEdge("item")
            .setOutV(outV)
            .addAllInVs(inVs)
            .setDocument(document)
            .setProperty("referenceResults"));
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

  private LsifObject.Builder scipObject() {
    return LsifObject.newBuilder().setId(nextId());
  }

  private LsifObject.Builder scipEdge(String label) {
    return scipObject().setType("edge").setLabel(label);
  }

  private LsifObject.Builder scipVertex(String label) {
    return scipObject().setType("vertex").setLabel(label);
  }

  private int nextId() {
    return id.incrementAndGet();
  }
}
