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
//                                      signature_documentation java public class QuantityStringResAttribute
  @PluralsRes private final int id;
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                              ^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
//                                 display_name id
//                                 signature_documentation java @PluralsRes\nprivate final int id
  private final int quantity;
//                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
//                           display_name quantity
//                           signature_documentation java private final int quantity
  @Nullable private final Object[] formatArgs;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
//                                            display_name formatArgs
//                                            signature_documentation java @Nullable\nprivate final Object[] formatArgs

  public QuantityStringResAttribute(@PluralsRes int id, int quantity,
//       ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//                                  display_name <init>
//                                  signature_documentation java public QuantityStringResAttribute(int id, int quantity, Object[] formatArgs)
//                                   ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                                                  ^^ definition local 0
//                                                     display_name id
//                                                     signature_documentation java @PluralsRes\nint id
//                                                     enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
//                                                          ^^^^^^^^ definition local 1
//                                                                   display_name quantity
//                                                                   signature_documentation java int quantity
//                                                                   enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
      @Nullable Object[] formatArgs) {
//     ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//              ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                       ^^^^^^^^^^ definition local 2
//                                  display_name formatArgs
//                                  signature_documentation java @Nullable\nObject[] formatArgs
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`().
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
//                                  signature_documentation java public QuantityStringResAttribute(int id, int quantity)
//                                      ^^ definition local 3
//                                         display_name id
//                                         signature_documentation java int id
//                                         enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`(+1).
//                                              ^^^^^^^^ definition local 4
//                                                       display_name quantity
//                                                       signature_documentation java int quantity
//                                                       enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#`<init>`(+1).
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
//                 signature_documentation java @PluralsRes\npublic int getId()
    return id;
//         ^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#id.
  }

  public int getQuantity() {
//           ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#getQuantity().
//                       display_name getQuantity
//                       signature_documentation java public int getQuantity()
    return quantity;
//         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#quantity.
  }

  @Nullable
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
  public Object[] getFormatArgs() {
//       ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#getFormatArgs().
//                              display_name getFormatArgs
//                              signature_documentation java @Nullable\npublic Object[] getFormatArgs()
    return formatArgs;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#formatArgs.
  }

  public CharSequence toString(Context context) {
//       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#toString().
//                             display_name toString
//                             signature_documentation java public CharSequence toString(unresolved_type context)
//                             ^^^^^^^ reference semanticdb maven . . Context#
//                                     ^^^^^^^ definition local 5
//                                             display_name context
//                                             signature_documentation java unresolved_type context
//                                             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#toString().
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
//                      signature_documentation java @Override\npublic boolean equals(Object o)
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 6
//                               display_name o
//                               signature_documentation java Object o
//                               enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#equals().
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
//                                  signature_documentation java QuantityStringResAttribute that
//                                  enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#equals().
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
//                    signature_documentation java @Override\npublic int hashCode()
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = id;
//      ^^^^^^ definition local 8
//             display_name result
//             signature_documentation java int result
//             enclosing_symbol semanticdb maven . . com/airbnb/epoxy/QuantityStringResAttribute#hashCode().
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
