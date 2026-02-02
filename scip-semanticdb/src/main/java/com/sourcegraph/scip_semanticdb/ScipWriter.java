package com.sourcegraph.scip_semanticdb;

import com.google.protobuf.util.JsonFormat;
import com.sourcegraph.Scip;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermissions;

/** High-level utility methods to write SCIP index into the SCIP output stream. */
public class ScipWriter implements AutoCloseable {

  private final Path tmp;
  private final ScipOutputStream output;
  private final ScipSemanticdbOptions options;
  private final JsonFormat.Printer jsonPrinter;

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
        new ScipOutputStream(options.format, new BufferedOutputStream(Files.newOutputStream(tmp)));
    this.options = options;
    this.jsonPrinter = JsonFormat.printer().omittingInsignificantWhitespace();
  }

  public void emitTyped(Scip.Index index) {
    try {
      if (options.format.isNewlineDelimitedJSON()) {
        this.output.write(jsonPrinter.print(index).getBytes(StandardCharsets.UTF_8));
      } else {
        this.output.write(index.toByteArray());
      }
    } catch (IOException e) {
      options.reporter.error(e);
    }
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
}
