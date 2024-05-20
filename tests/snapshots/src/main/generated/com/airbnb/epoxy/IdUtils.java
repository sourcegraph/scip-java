package com.airbnb.epoxy;

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#

/**
 * Utilities for generating 64-bit long IDs from types such as {@link CharSequence}.
 */
public final class IdUtils {
//                 ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IdUtils#
//                         display_name IdUtils
//                         signature_documentation java public final class IdUtils
//                         kind Class
//                         documentation  Utilities for generating 64-bit long IDs from types such as {@link CharSequence}.\n
  private IdUtils() {
//        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IdUtils#`<init>`().
//                display_name <init>
//                signature_documentation java private IdUtils()
//                kind Constructor
  }

  /**
   * Hash a long into 64 bits instead of the normal 32. This uses a xor shift implementation to
   * attempt psuedo randomness so object ids have an even spread for less chance of collisions.
   * <p>
   * From http://stackoverflow.com/a/11554034
   * <p>
   * http://www.javamex.com/tutorials/random_numbers/xorshift.shtml
   */
  public static long hashLong64Bit(long value) {
//                   ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
//                                 display_name hashLong64Bit
//                                 signature_documentation java public static long hashLong64Bit(long value)
//                                 kind StaticMethod
//                                 documentation  Hash a long into 64 bits instead of the normal 32. This uses a xor shift implementation to\n attempt psuedo randomness so object ids have an even spread for less chance of collisions.\n <p>\n From http://stackoverflow.com/a/11554034\n <p>\n http://www.javamex.com/tutorials/random_numbers/xorshift.shtml\n
//                                      ^^^^^ definition local 0
//                                            display_name value
//                                            signature_documentation java long value
//                                            enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IdUtils#hashLong64Bit().
    value ^= (value << 21);
//  ^^^^^ reference local 0
//            ^^^^^ reference local 0
    value ^= (value >>> 35);
//  ^^^^^ reference local 0
//            ^^^^^ reference local 0
    value ^= (value << 4);
//  ^^^^^ reference local 0
//            ^^^^^ reference local 0
    return value;
//         ^^^^^ reference local 0
  }

  /**
   * Hash a string into 64 bits instead of the normal 32. This allows us to better use strings as a
   * model id with less chance of collisions. This uses the FNV-1a algorithm for a good mix of speed
   * and distribution.
   * <p>
   * Performance comparisons found at http://stackoverflow.com/a/1660613
   * <p>
   * Hash implementation from http://www.isthe.com/chongo/tech/comp/fnv/index.html#FNV-1a
   */
  public static long hashString64Bit(@Nullable CharSequence str) {
//                   ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                                   display_name hashString64Bit
//                                   signature_documentation java public static long hashString64Bit(CharSequence str)
//                                   kind StaticMethod
//                                   documentation  Hash a string into 64 bits instead of the normal 32. This allows us to better use strings as a\n model id with less chance of collisions. This uses the FNV-1a algorithm for a good mix of speed\n and distribution.\n <p>\n Performance comparisons found at http://stackoverflow.com/a/1660613\n <p>\n Hash implementation from http://www.isthe.com/chongo/tech/comp/fnv/index.html#FNV-1a\n
//                                    ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                          ^^^ definition local 1
//                                                              display_name str
//                                                              signature_documentation java @Nullable\nCharSequence str
//                                                              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
    if (str == null) {
//      ^^^ reference local 1
      return 0;
    }

    long result = 0xcbf29ce484222325L;
//       ^^^^^^ definition local 2
//              display_name result
//              signature_documentation java long result
//              enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//              kind Variable
    final int len = str.length();
//            ^^^ definition local 3
//                display_name len
//                signature_documentation java final int len
//                enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//                kind Variable
//                  ^^^ reference local 1
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    for (int i = 0; i < len; i++) {
//           ^ definition local 4
//             display_name i
//             signature_documentation java int i
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/IdUtils#hashString64Bit().
//             kind Variable
//                  ^ reference local 4
//                      ^^^ reference local 3
//                           ^ reference local 4
      result ^= str.charAt(i);
//    ^^^^^^ reference local 2
//              ^^^ reference local 1
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#charAt().
//                         ^ reference local 4
      result *= 0x100000001b3L;
//    ^^^^^^ reference local 2
    }
    return result;
//         ^^^^^^ reference local 2
  }
}
