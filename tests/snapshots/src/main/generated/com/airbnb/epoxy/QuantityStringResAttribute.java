package com.airbnb.epoxy;

import android.content.Context;
//     ^^^^^^^ reference semanticdb maven . . android/
//             ^^^^^^^ reference semanticdb maven . . android/content/
//                     ^^^^^^^ reference semanticdb maven . . android/content/Context#

import java.util.Arrays;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
import androidx.annotation.PluralsRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#

public class QuantityStringResAttribute {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#
//                                      display_name QuantityStringResAttribute
//                                      documentation ```java\npublic class QuantityStringResAttribute\n```
  @PluralsRes private final int id;
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                              ^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                 display_name id
//                                 documentation ```java\n@PluralsRes\nprivate final int id\n```
  private final int quantity;
//                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                           display_name quantity
//                           documentation ```java\nprivate final int quantity\n```
  @Nullable private final Object[] formatArgs;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                            display_name formatArgs
//                                            documentation ```java\n@Nullable\nprivate final Object[] formatArgs\n```

  public QuantityStringResAttribute(@PluralsRes int id, int quantity,
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//                                  display_name <init>
//                                  documentation ```java\npublic QuantityStringResAttribute(int id, int quantity, Object[] formatArgs)\n```
//                                   ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                                                  ^^ definition local 0
//                                                     display_name id
//                                                     documentation ```java\n@PluralsRes\nint id\n```
//                                                          ^^^^^^^^ definition local 1
//                                                                   display_name quantity
//                                                                   documentation ```java\nint quantity\n```
      @Nullable Object[] formatArgs) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                       ^^^^^^^^^^ definition local 2
//                                  display_name formatArgs
//                                  documentation ```java\n@Nullable\nObject[] formatArgs\n```
    this.quantity = quantity;
//       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                  ^^^^^^^^ reference local 1
    this.id = id;
//       ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//            ^^ reference local 0
    this.formatArgs = formatArgs;
//       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                    ^^^^^^^^^^ reference local 2
  }

  public QuantityStringResAttribute(int id, int quantity) {
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`(+1).
//                                  display_name <init>
//                                  documentation ```java\npublic QuantityStringResAttribute(int id, int quantity)\n```
//                                      ^^ definition local 3
//                                         display_name id
//                                         documentation ```java\nint id\n```
//                                              ^^^^^^^^ definition local 4
//                                                       display_name quantity
//                                                       documentation ```java\nint quantity\n```
    this(id, quantity, null);
//  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//       ^^ reference local 3
//           ^^^^^^^^ reference local 4
  }

  @PluralsRes
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
  public int getId() {
//           ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#getId().
//                 display_name getId
//                 documentation ```java\n@PluralsRes\npublic int getId()\n```
    return id;
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
  }

  public int getQuantity() {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#getQuantity().
//                       display_name getQuantity
//                       documentation ```java\npublic int getQuantity()\n```
    return quantity;
//         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public Object[] getFormatArgs() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#getFormatArgs().
//                              display_name getFormatArgs
//                              documentation ```java\n@Nullable\npublic Object[] getFormatArgs()\n```
    return formatArgs;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
  }

  public CharSequence toString(Context context) {
//       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#toString().
//                             display_name toString
//                             documentation ```java\npublic CharSequence toString(unresolved_type context)\n```
//                             ^^^^^^^ reference semanticdb maven . . Context#
//                                     ^^^^^^^ definition local 5
//                                             display_name context
//                                             documentation ```java\nunresolved_type context\n```
    if (formatArgs == null || formatArgs.length == 0) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                       ^^^^^^ reference semanticdb maven . . Array#length.
      return context.getResources().getQuantityString(id, quantity);
//           ^^^^^^^ reference local 5
//                   ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#getQuantityString#
//                                                    ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
    } else {
      return context.getResources().getQuantityString(id, quantity, formatArgs);
//           ^^^^^^^ reference local 5
//                   ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#getQuantityString#
//                                                    ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#equals().
//                      display_name equals
//                      documentation ```java\n@Override\npublic boolean equals(Object o)\n```
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 6
//                               display_name o
//                               documentation ```java\nObject o\n```
    if (this == o) {
//              ^ reference local 6
      return true;
    }
    if (!(o instanceof QuantityStringResAttribute)) {
//        ^ reference local 6
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#
      return false;
    }

    QuantityStringResAttribute that = (QuantityStringResAttribute) o;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#
//                             ^^^^ definition local 7
//                                  display_name that
//                                  documentation ```java\nQuantityStringResAttribute that\n```
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#
//                                                                 ^ reference local 6

    if (id != that.id) {
//      ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//            ^^^^ reference local 7
//                 ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
      return false;
    }
    if (quantity != that.quantity) {
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                  ^^^^ reference local 7
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
      return false;
    }
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    return Arrays.equals(formatArgs, that.formatArgs);
//         ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#equals(+8).
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                   ^^^^ reference local 7
//                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#hashCode().
//                    display_name hashCode
//                    documentation ```java\n@Override\npublic int hashCode()\n```
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = id;
//      ^^^^^^ definition local 8
//             display_name result
//             documentation ```java\nint result\n```
//               ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
    result = 31 * result + quantity;
//  ^^^^^^ reference local 8
//                ^^^^^^ reference local 8
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
    result = 31 * result + Arrays.hashCode(formatArgs);
//  ^^^^^^ reference local 8
//                ^^^^^^ reference local 8
//                         ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#hashCode(+8).
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
    return result;
//         ^^^^^^ reference local 8
  }
}
