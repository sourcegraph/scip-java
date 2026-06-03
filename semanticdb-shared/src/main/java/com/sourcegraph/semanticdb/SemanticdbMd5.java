package com.sourcegraph.semanticdb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility to compute uppercase-hex MD5 checksums for SemanticDB {@code TextDocument.md5} fields.
 *
 * <p>The uppercase-hex format is shared by every SemanticDB producer and matches the prior
 * per-plugin implementations in {@code semanticdb-javac} and {@code semanticdb-kotlinc}.
 */
public final class SemanticdbMd5 {
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

  private SemanticdbMd5() {}

  /** Computes the uppercase-hex MD5 digest of the given UTF-8 encoded text. */
  public static String digest(CharSequence text) {
    return digest(text.toString().getBytes(StandardCharsets.UTF_8));
  }

  /** Computes the uppercase-hex MD5 digest of the given bytes. */
  public static String digest(byte[] bytes) {
    return bytesToHex(newMd5().digest(bytes));
  }

  private static MessageDigest newMd5() {
    try {
      return MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      // MD5 is a JDK-required algorithm and is always available.
      throw new AssertionError("MD5 algorithm unavailable in this JVM", e);
    }
  }

  private static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_ARRAY[v >>> 4];
      hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars);
  }
}
