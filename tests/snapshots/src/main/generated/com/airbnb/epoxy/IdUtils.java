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
//                         documentation ```java\npublic final class IdUtils\n```
//                         documentation  Utilities for generating 64-bit long IDs from types such as {@link CharSequence}.\n
  private IdUtils() {
//        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/IdUtils#`<init>`().
//                documentation ```java\nprivate IdUtils()\n```
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
//                                 documentation ```java\npublic static long hashLong64Bit(long value)\n```
//                                 documentation  Hash a long into 64 bits instead of the normal 32. This uses a xor shift implementation to\n attempt psuedo randomness so object ids have an even spread for less chance of collisions.\n <p>\n From http://stackoverflow.com/a/11554034\n <p>\n http://www.javamex.com/tutorials/random_numbers/xorshift.shtml\n
//                                      ^^^^^ definition local 0
//                                            documentation ```java\nlong value\n```
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
//                                   documentation ```java\npublic static long hashString64Bit(CharSequence str)\n```
//                                   documentation  Hash a string into 64 bits instead of the normal 32. This allows us to better use strings as a\n model id with less chance of collisions. This uses the FNV-1a algorithm for a good mix of speed\n and distribution.\n <p>\n Performance comparisons found at http://stackoverflow.com/a/1660613\n <p>\n Hash implementation from http://www.isthe.com/chongo/tech/comp/fnv/index.html#FNV-1a\n
//                                    ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                             ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                          ^^^ definition local 1
//                                                              documentation ```java\n@Nullable\nCharSequence str\n```
    if (str == null) {
//      ^^^ reference local 1
      return 0;
    }

    long result = 0xcbf29ce484222325L;
//       ^^^^^^ definition local 2
//              documentation ```java\nlong result\n```
    final int len = str.length();
//            ^^^ definition local 3
//                documentation ```java\nfinal int len\n```
//                  ^^^ reference local 1
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#length().
    for (int i = 0; i < len; i++) {
//           ^ definition local 4
//             documentation ```java\nint i\n```
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
