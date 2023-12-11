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
import androidx.annotation.StringRes;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#

public class StringAttributeData {
//           ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#
//                               display_name StringAttributeData
//                               signature_documentation java public class StringAttributeData
  private final boolean hasDefault;
//                      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hasDefault.
//                                 display_name hasDefault
//                                 signature_documentation java private final boolean hasDefault
  @Nullable private final CharSequence defaultString;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                        ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                     ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultString.
//                                                   display_name defaultString
//                                                   signature_documentation java @Nullable\nprivate final CharSequence defaultString
  @StringRes private final int defaultStringRes;
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#
//                             ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
//                                              display_name defaultStringRes
//                                              signature_documentation java @StringRes\nprivate final int defaultStringRes

  @Nullable private CharSequence string;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                  ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                                      display_name string
//                                      signature_documentation java @Nullable\nprivate CharSequence string
  @StringRes private int stringRes;
// ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#
//                       ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
//                                 display_name stringRes
//                                 signature_documentation java @StringRes\nprivate int stringRes
  @PluralsRes private int pluralRes;
// ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                        ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
//                                  display_name pluralRes
//                                  signature_documentation java @PluralsRes\nprivate int pluralRes
  private int quantity;
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
//                     display_name quantity
//                     signature_documentation java private int quantity
  @Nullable private Object[] formatArgs;
// ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                  ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                           ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
//                                      display_name formatArgs
//                                      signature_documentation java @Nullable\nprivate Object[] formatArgs

  public StringAttributeData() {
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#`<init>`().
//                           display_name <init>
//                           signature_documentation java public StringAttributeData()
    hasDefault = false;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hasDefault.
    defaultString = null;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultString.
    defaultStringRes = 0;
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
  }

  public StringAttributeData(@Nullable CharSequence defaultString) {
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#`<init>`(+1).
//                           display_name <init>
//                           signature_documentation java public StringAttributeData(CharSequence defaultString)
//                            ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                     ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                                  ^^^^^^^^^^^^^ definition local 0
//                                                                display_name defaultString
//                                                                signature_documentation java @Nullable\nCharSequence defaultString
    hasDefault = true;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hasDefault.
    this.defaultString = defaultString;
//       ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultString.
//                       ^^^^^^^^^^^^^ reference local 0
    string = defaultString;
//  ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//           ^^^^^^^^^^^^^ reference local 0
    defaultStringRes = 0;
//  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
  }

  public StringAttributeData(@StringRes int defaultStringRes) {
//       ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#`<init>`(+2).
//                           display_name <init>
//                           signature_documentation java public StringAttributeData(int defaultStringRes)
//                            ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#
//                                          ^^^^^^^^^^^^^^^^ definition local 1
//                                                           display_name defaultStringRes
//                                                           signature_documentation java @StringRes\nint defaultStringRes
    hasDefault = true;
//  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hasDefault.
    this.defaultStringRes = defaultStringRes;
//       ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
//                          ^^^^^^^^^^^^^^^^ reference local 1
    stringRes = defaultStringRes;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
//              ^^^^^^^^^^^^^^^^ reference local 1
    defaultString = null;
//  ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultString.
  }

  public void setValue(@Nullable CharSequence string) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue().
//                     display_name setValue
//                     signature_documentation java public void setValue(CharSequence string)
//                      ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                               ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                                            ^^^^^^ definition local 2
//                                                   display_name string
//                                                   signature_documentation java @Nullable\nCharSequence string
    this.string = string;
//       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                ^^^^^^ reference local 2
    stringRes = 0;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
    pluralRes = 0;
//  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
  }

  public void setValue(@StringRes int stringRes) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue(+1).
//                     display_name setValue
//                     signature_documentation java public void setValue(int stringRes)
//                      ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#
//                                    ^^^^^^^^^ definition local 3
//                                              display_name stringRes
//                                              signature_documentation java @StringRes\nint stringRes
    setValue(stringRes, null);
//  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue(+2).
//           ^^^^^^^^^ reference local 3
  }

  public void setValue(@StringRes int stringRes, @Nullable Object[] formatArgs) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue(+2).
//                     display_name setValue
//                     signature_documentation java public void setValue(int stringRes, Object[] formatArgs)
//                      ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/StringRes#
//                                    ^^^^^^^^^ definition local 4
//                                              display_name stringRes
//                                              signature_documentation java @StringRes\nint stringRes
//                                                ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                         ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                  ^^^^^^^^^^ definition local 5
//                                                                             display_name formatArgs
//                                                                             signature_documentation java @Nullable\nObject[] formatArgs
    if (stringRes != 0) {
//      ^^^^^^^^^ reference local 4
      this.stringRes = stringRes;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
//                     ^^^^^^^^^ reference local 4
      this.formatArgs = formatArgs;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
//                      ^^^^^^^^^^ reference local 5
      string = null;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
      pluralRes = 0;
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
    } else {
      handleInvalidStringRes();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes().
    }
  }

  private void handleInvalidStringRes() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes().
//                                    display_name handleInvalidStringRes
//                                    signature_documentation java private void handleInvalidStringRes()
    if (hasDefault) {
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hasDefault.
      if (defaultStringRes != 0) {
//        ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
        setValue(defaultStringRes);
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue(+1).
//               ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultStringRes.
      } else {
        setValue(defaultString);
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue().
//               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#defaultString.
      }
    } else {
      throw new IllegalArgumentException("0 is an invalid value for required strings.");
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/IllegalArgumentException#`<init>`(+1).
    }
  }

  public void setValue(@PluralsRes int pluralRes, int quantity, @Nullable Object[] formatArgs) {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#setValue(+3).
//                     display_name setValue
//                     signature_documentation java public void setValue(int pluralRes, int quantity, Object[] formatArgs)
//                      ^^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/PluralsRes#
//                                     ^^^^^^^^^ definition local 6
//                                               display_name pluralRes
//                                               signature_documentation java @PluralsRes\nint pluralRes
//                                                    ^^^^^^^^ definition local 7
//                                                             display_name quantity
//                                                             signature_documentation java int quantity
//                                                               ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Nullable#
//                                                                        ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                                                                                 ^^^^^^^^^^ definition local 8
//                                                                                            display_name formatArgs
//                                                                                            signature_documentation java @Nullable\nObject[] formatArgs
    if (pluralRes != 0) {
//      ^^^^^^^^^ reference local 6
      this.pluralRes = pluralRes;
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
//                     ^^^^^^^^^ reference local 6
      this.quantity = quantity;
//         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
//                    ^^^^^^^^ reference local 7
      this.formatArgs = formatArgs;
//         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
//                      ^^^^^^^^^^ reference local 8
      string = null;
//    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
      stringRes = 0;
//    ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
    } else {
      handleInvalidStringRes();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes().
    }
  }

  public CharSequence toString(Context context) {
//       ^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/CharSequence#
//                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#toString().
//                             display_name toString
//                             signature_documentation java public CharSequence toString(unresolved_type context)
//                             ^^^^^^^ reference semanticdb maven . . Context#
//                                     ^^^^^^^ definition local 9
//                                             display_name context
//                                             signature_documentation java unresolved_type context
    if (pluralRes != 0) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
      if (formatArgs != null) {
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
        return context.getResources().getQuantityString(pluralRes, quantity, formatArgs);
//             ^^^^^^^ reference local 9
//                     ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#getQuantityString#
//                                                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
//                                                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
//                                                                           ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
      } else {
        return context.getResources().getQuantityString(pluralRes, quantity);
//             ^^^^^^^ reference local 9
//                     ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#getQuantityString#
//                                                      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
//                                                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
      }
    } else if (stringRes != 0) {
//             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
      if (formatArgs != null) {
//        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
        return context.getResources().getString(stringRes, formatArgs);
//             ^^^^^^^ reference local 9
//                     ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                    ^^^^^^^^^ reference semanticdb maven . . Context#getResources#getString#
//                                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
//                                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
      } else {
        return context.getResources().getText(stringRes);
//             ^^^^^^^ reference local 9
//                     ^^^^^^^^^^^^ reference semanticdb maven . . Context#getResources#
//                                    ^^^^^^^ reference semanticdb maven . . Context#getResources#getText#
//                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
      }
    } else {
      return string;
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
    }
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#equals().
//                      display_name equals
//                      signature_documentation java @Override\npublic boolean equals(Object o)
//                      relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#equals().
//                      ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#
//                             ^ definition local 10
//                               display_name o
//                               signature_documentation java Object o
    if (this == o) {
//              ^ reference local 10
      return true;
    }
    if (!(o instanceof StringAttributeData)) {
//        ^ reference local 10
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#
      return false;
    }

    StringAttributeData that = (StringAttributeData) o;
//  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#
//                      ^^^^ definition local 11
//                           display_name that
//                           signature_documentation java StringAttributeData that
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#
//                                                   ^ reference local 10

    if (stringRes != that.stringRes) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
//                   ^^^^ reference local 11
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
      return false;
    }
    if (pluralRes != that.pluralRes) {
//      ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
//                   ^^^^ reference local 11
//                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
      return false;
    }
    if (quantity != that.quantity) {
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
//                  ^^^^ reference local 11
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
      return false;
    }
    if (string != null ? !string.equals(that.string) : that.string != null) {
//      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                        ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                               ^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#equals().
//                                      ^^^^ reference local 11
//                                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                                                     ^^^^ reference local 11
//                                                          ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
      return false;
    }

    return Arrays.equals(formatArgs, that.formatArgs);
//         ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#equals(+8).
//                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
//                                   ^^^^ reference local 11
//                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
  }

  @Override
// ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/StringAttributeData#hashCode().
//                    display_name hashCode
//                    signature_documentation java @Override\npublic int hashCode()
//                    relationship is_reference is_implementation semanticdb maven jdk 11 java/lang/Object#hashCode().
    int result = string != null ? string.hashCode() : 0;
//      ^^^^^^ definition local 12
//             display_name result
//             signature_documentation java int result
//               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                                ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#string.
//                                       ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Object#hashCode().
    result = 31 * result + stringRes;
//  ^^^^^^ reference local 12
//                ^^^^^^ reference local 12
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#stringRes.
    result = 31 * result + pluralRes;
//  ^^^^^^ reference local 12
//                ^^^^^^ reference local 12
//                         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#pluralRes.
    result = 31 * result + quantity;
//  ^^^^^^ reference local 12
//                ^^^^^^ reference local 12
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#quantity.
    result = 31 * result + Arrays.hashCode(formatArgs);
//  ^^^^^^ reference local 12
//                ^^^^^^ reference local 12
//                         ^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#
//                                ^^^^^^^^ reference semanticdb maven jdk 11 java/util/Arrays#hashCode(+8).
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/StringAttributeData#formatArgs.
    return result;
//         ^^^^^^ reference local 12
  }
}
