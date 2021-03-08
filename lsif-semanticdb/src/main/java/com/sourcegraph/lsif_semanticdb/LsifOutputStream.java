package com.sourcegraph.lsif_semanticdb;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.Printer;
import com.sourcegraph.lsif_protocol.LsifObject;
import com.sourcegraph.lsif_protocol.LsifPosition;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/** Low-level methods to write raw LSIF objects into the output stream. */
public class LsifOutputStream {
  private final LsifSemanticdbOptions options;
  private final OutputStream out;
  private final ConcurrentLinkedDeque<byte[]> buffer;
  private final AtomicBoolean isFlushing;
  private static final byte[] NEWLINE = "\n".getBytes(StandardCharsets.UTF_8);
  private final ThreadLocal<LsifByteOutputStream> baos =
      ThreadLocal.withInitial(LsifByteOutputStream::new);
  private final Printer jsonPrinter;

  public LsifOutputStream(LsifSemanticdbOptions options, OutputStream out) {
    this.options = options;
    this.out = out;
    buffer = new ConcurrentLinkedDeque<>();
    isFlushing = new AtomicBoolean(false);

    Set<FieldDescriptor> fieldsToAlwaysInclude =
        new HashSet<>(LsifPosition.getDescriptor().getFields());
    fieldsToAlwaysInclude.add(LsifObject.getDescriptor().findFieldByName("id"));
    jsonPrinter =
        JsonFormat.printer()
            .includingDefaultValueFields(fieldsToAlwaysInclude)
            .omittingInsignificantWhitespace();
  }

  public void write(byte[] bytes) {
    if (bytes.length == 0) return;
    buffer.add(bytes);
  }

  public void writeLsifObject(LsifObject.Builder object) {
    LsifByteOutputStream b = baos.get();
    b.output.reset();
    try {
      switch (options.format) {
        case PROTOBUF:
          object.buildPartial().writeTo(b.output);
          break;
        case JSON:
        default:
          jsonPrinter.appendTo(object, b.writer);
          b.writer.flush();
          break;
      }
    } catch (IOException e) {
      options.reporter.error(e);
    }
    write(b.output.toByteArray());
  }

  public void flush() throws IOException {
    if (isFlushing.compareAndSet(false, true)) {
      byte[] bytes = buffer.poll();
      while (bytes != null) {
        out.write(bytes);
        out.write(NEWLINE);
        bytes = buffer.poll();
      }
      out.flush();
      isFlushing.set(false);
    }
  }
}
