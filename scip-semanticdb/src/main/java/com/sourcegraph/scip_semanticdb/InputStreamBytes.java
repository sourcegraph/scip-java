package com.sourcegraph.scip_semanticdb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamBytes {
  public static byte[] readAll(InputStream in) throws IOException {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buffer = new byte[4096];
      int nread;
      do {
        nread = in.read(buffer, 0, buffer.length);
        if (nread != -1) baos.write(buffer, 0, nread);
      } while (nread != -1);
      return baos.toByteArray();
    } finally {
      in.close();
    }
  }
}
