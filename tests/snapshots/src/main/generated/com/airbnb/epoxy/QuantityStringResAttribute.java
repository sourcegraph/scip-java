package com.airbnb.epoxy;

import android.content.Context;
//     ^^^^^^^ reference android/
//             ^^^^^^^ reference android/content/
//                     ^^^^^^^ reference android/content/Context#

import java.util.Arrays;
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^ reference java/util/Arrays#

import androidx.annotation.Nullable;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/Nullable#
import androidx.annotation.PluralsRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^ reference androidx/annotation/PluralsRes#

public class QuantityStringResAttribute {
//     ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#
  @PluralsRes private final int id;
   ^^^^^^^^^^ reference androidx/annotation/PluralsRes#
//                              ^^ definition com/airbnb/epoxy/QuantityStringResAttribute#id.
  private final int quantity;
//                  ^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#quantity.
  @Nullable private final Object[] formatArgs;
   ^^^^^^^^ reference androidx/annotation/Nullable#
//                        ^^^^^^ reference java/lang/Object#
//                                 ^^^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.

  public QuantityStringResAttribute(@PluralsRes int id, int quantity,
//       ^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//                                   ^^^^^^^^^^ reference androidx/annotation/PluralsRes#
//                                                  ^^ definition local0
//                                                          ^^^^^^^^ definition local1
      @Nullable Object[] formatArgs) {
//     ^^^^^^^^ reference androidx/annotation/Nullable#
//              ^^^^^^ reference java/lang/Object#
//                       ^^^^^^^^^^ definition local2
    this.quantity = quantity;
//  ^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#this.
//       ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                  ^^^^^^^^ reference local1
    this.id = id;
//  ^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#this.
//       ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
//            ^^ reference local0
    this.formatArgs = formatArgs;
//  ^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#this.
//       ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                    ^^^^^^^^^^ reference local2
  }

  public QuantityStringResAttribute(int id, int quantity) {
//       ^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#`<init>`(+1).
//                                      ^^ definition local3
//                                              ^^^^^^^^ definition local4
    this(id, quantity, null);
//  ^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//       ^^ reference local3
//           ^^^^^^^^ reference local4
  }

  @PluralsRes
   ^^^^^^^^^^ reference androidx/annotation/PluralsRes#
  public int getId() {
//           ^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#getId().
    return id;
//         ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
  }

  public int getQuantity() {
//           ^^^^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#getQuantity().
    return quantity;
//         ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
  }

  @Nullable
   ^^^^^^^^ reference androidx/annotation/Nullable#
  public Object[] getFormatArgs() {
//       ^^^^^^ reference java/lang/Object#
//                ^^^^^^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#getFormatArgs().
    return formatArgs;
//         ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
  }

  public CharSequence toString(Context context) {
//       ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                    ^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#toString().
//                             ^^^^^^^ reference _root_/
//                                     ^^^^^^^ definition local5
    if (formatArgs == null || formatArgs.length == 0) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                            ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                       ^^^^^^ reference length.
      return context.getResources().getQuantityString(id, quantity);
//           ^^^^^^^ reference local5
//                   ^^^^^^^^^^^^ reference getResources#
//                                  ^^^^^^^^^^^^^^^^^ reference getResources#getQuantityString#
//                                                    ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                                        ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
    } else {
      return context.getResources().getQuantityString(id, quantity, formatArgs);
//           ^^^^^^^ reference local5
//                   ^^^^^^^^^^^^ reference getResources#
//                                  ^^^^^^^^^^^^^^^^^ reference getResources#getQuantityString#
//                                                    ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                                        ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                                                                  ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
    }
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#equals().
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local6
    if (this == o) {
//      ^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#this.
//              ^ reference local6
      return true;
    }
    if (!(o instanceof QuantityStringResAttribute)) {
//        ^ reference local6
//                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#
      return false;
    }

    QuantityStringResAttribute that = (QuantityStringResAttribute) o;
//  ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#
//                             ^^^^ definition local7
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#
//                                                                 ^ reference local6

    if (id != that.id) {
//      ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
//            ^^^^ reference local7
//                 ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
      return false;
    }
    if (quantity != that.quantity) {
//      ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                  ^^^^ reference local7
//                       ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
      return false;
    }
    // Probably incorrect - comparing Object[] arrays with Arrays.equals
    return Arrays.equals(formatArgs, that.formatArgs);
//         ^^^^^^ reference java/util/Arrays#
//                ^^^^^^ reference java/util/Arrays#equals(+16).
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                   ^^^^ reference local7
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
  }

  @Override
   ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/QuantityStringResAttribute#hashCode().
    int result = id;
//      ^^^^^^ definition local8
//               ^^ reference com/airbnb/epoxy/QuantityStringResAttribute#id.
    result = 31 * result + quantity;
//  ^^^^^^ reference local8
//                ^^^^^^ reference local8
//                         ^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#quantity.
    result = 31 * result + Arrays.hashCode(formatArgs);
//  ^^^^^^ reference local8
//                ^^^^^^ reference local8
//                         ^^^^^^ reference java/util/Arrays#
//                                ^^^^^^^^ reference java/util/Arrays#hashCode(+8).
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
    return result;
//         ^^^^^^ reference local8
  }
}
