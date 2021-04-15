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
import androidx.annotation.StringRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/StringRes#

public class StringAttributeData {
//           ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData# public class StringAttributeData
  private final boolean hasDefault;
//                      ^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#hasDefault. private final boolean hasDefault
  @Nullable private final CharSequence defaultString;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//                        ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                     ^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#defaultString. @Nullable private final CharSequence defaultString
  @StringRes private final int defaultStringRes;
// ^^^^^^^^^ reference androidx/annotation/StringRes#
//                             ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#defaultStringRes. @StringRes private final int defaultStringRes

  @Nullable private CharSequence string;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//                  ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                               ^^^^^^ definition com/airbnb/epoxy/StringAttributeData#string. @Nullable private CharSequence string
  @StringRes private int stringRes;
// ^^^^^^^^^ reference androidx/annotation/StringRes#
//                       ^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#stringRes. @StringRes private int stringRes
  @PluralsRes private int pluralRes;
// ^^^^^^^^^^ reference androidx/annotation/PluralsRes#
//                        ^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#pluralRes. @PluralsRes private int pluralRes
  private int quantity;
//            ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#quantity. private int quantity
  @Nullable private Object[] formatArgs;
// ^^^^^^^^ reference androidx/annotation/Nullable#
//                  ^^^^^^ reference java/lang/Object#
//                           ^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#formatArgs. @Nullable private Object[] formatArgs

  public StringAttributeData() {
//       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#`<init>`(). public StringAttributeData()
    hasDefault = false;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#hasDefault.
    defaultString = null;
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultString.
    defaultStringRes = 0;
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultStringRes.
  }

  public StringAttributeData(@Nullable CharSequence defaultString) {
//       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#`<init>`(+1). public StringAttributeData(CharSequence defaultString)
//                            ^^^^^^^^ reference androidx/annotation/Nullable#
//                                     ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                                  ^^^^^^^^^^^^^ definition local0 @Nullable CharSequence defaultString
    hasDefault = true;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#hasDefault.
    this.defaultString = defaultString;
//  ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//       ^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultString.
//                       ^^^^^^^^^^^^^ reference local0
    string = defaultString;
//  ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//           ^^^^^^^^^^^^^ reference local0
    defaultStringRes = 0;
//  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultStringRes.
  }

  public StringAttributeData(@StringRes int defaultStringRes) {
//       ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#`<init>`(+2). public StringAttributeData(int defaultStringRes)
//                            ^^^^^^^^^ reference androidx/annotation/StringRes#
//                                          ^^^^^^^^^^^^^^^^ definition local1 @StringRes int defaultStringRes
    hasDefault = true;
//  ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#hasDefault.
    this.defaultStringRes = defaultStringRes;
//  ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultStringRes.
//                          ^^^^^^^^^^^^^^^^ reference local1
    stringRes = defaultStringRes;
//  ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
//              ^^^^^^^^^^^^^^^^ reference local1
    defaultString = null;
//  ^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultString.
  }

  public void setValue(@Nullable CharSequence string) {
//            ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#setValue(). public void setValue(CharSequence string)
//                      ^^^^^^^^ reference androidx/annotation/Nullable#
//                               ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                                            ^^^^^^ definition local2 @Nullable CharSequence string
    this.string = string;
//  ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//       ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                ^^^^^^ reference local2
    stringRes = 0;
//  ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
    pluralRes = 0;
//  ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
  }

  public void setValue(@StringRes int stringRes) {
//            ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#setValue(+1). public void setValue(int stringRes)
//                      ^^^^^^^^^ reference androidx/annotation/StringRes#
//                                    ^^^^^^^^^ definition local3 @StringRes int stringRes
    setValue(stringRes, null);
//  ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#setValue(+2).
//           ^^^^^^^^^ reference local3
  }

  public void setValue(@StringRes int stringRes, @Nullable Object[] formatArgs) {
//            ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#setValue(+2). public void setValue(int stringRes, Object[] formatArgs)
//                      ^^^^^^^^^ reference androidx/annotation/StringRes#
//                                    ^^^^^^^^^ definition local4 @StringRes int stringRes
//                                                ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                         ^^^^^^ reference java/lang/Object#
//                                                                  ^^^^^^^^^^ definition local5 @Nullable Object[] formatArgs
    if (stringRes != 0) {
//      ^^^^^^^^^ reference local4
      this.stringRes = stringRes;
//    ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//         ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
//                     ^^^^^^^^^ reference local4
      this.formatArgs = formatArgs;
//    ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//         ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
//                      ^^^^^^^^^^ reference local5
      string = null;
//    ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
      pluralRes = 0;
//    ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
    } else {
      handleInvalidStringRes();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes().
    }
  }

  private void handleInvalidStringRes() {
//             ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes(). private void handleInvalidStringRes()
    if (hasDefault) {
//      ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#hasDefault.
      if (defaultStringRes != 0) {
//        ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultStringRes.
        setValue(defaultStringRes);
//      ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#setValue(+1).
//               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultStringRes.
      } else {
        setValue(defaultString);
//      ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#setValue().
//               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#defaultString.
      }
    } else {
      throw new IllegalArgumentException("0 is an invalid value for required strings.");
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#`<init>`(+1).
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference java/lang/IllegalArgumentException#
    }
  }

  public void setValue(@PluralsRes int pluralRes, int quantity, @Nullable Object[] formatArgs) {
//            ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#setValue(+3). public void setValue(int pluralRes, int quantity, Object[] formatArgs)
//                      ^^^^^^^^^^ reference androidx/annotation/PluralsRes#
//                                     ^^^^^^^^^ definition local6 @PluralsRes int pluralRes
//                                                    ^^^^^^^^ definition local7 int quantity
//                                                               ^^^^^^^^ reference androidx/annotation/Nullable#
//                                                                        ^^^^^^ reference java/lang/Object#
//                                                                                 ^^^^^^^^^^ definition local8 @Nullable Object[] formatArgs
    if (pluralRes != 0) {
//      ^^^^^^^^^ reference local6
      this.pluralRes = pluralRes;
//    ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//         ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
//                     ^^^^^^^^^ reference local6
      this.quantity = quantity;
//    ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//         ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
//                    ^^^^^^^^ reference local7
      this.formatArgs = formatArgs;
//    ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//         ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
//                      ^^^^^^^^^^ reference local8
      string = null;
//    ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
      stringRes = 0;
//    ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
    } else {
      handleInvalidStringRes();
//    ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#handleInvalidStringRes().
    }
  }

  public CharSequence toString(Context context) {
//       ^^^^^^^^^^^^ reference java/lang/CharSequence#
//                    ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#toString(). public CharSequence toString(unresolved_type context)
//                             ^^^^^^^ reference _root_/
//                                     ^^^^^^^ definition local9 unresolved_type context
    if (pluralRes != 0) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
      if (formatArgs != null) {
//        ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
        return context.getResources().getQuantityString(pluralRes, quantity, formatArgs);
//             ^^^^^^^ reference local9
//                     ^^^^^^^^^^^^ reference getResources#
//                                    ^^^^^^^^^^^^^^^^^ reference getResources#getQuantityString#
//                                                      ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
//                                                                 ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
//                                                                           ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
      } else {
        return context.getResources().getQuantityString(pluralRes, quantity);
//             ^^^^^^^ reference local9
//                     ^^^^^^^^^^^^ reference getResources#
//                                    ^^^^^^^^^^^^^^^^^ reference getResources#getQuantityString#
//                                                      ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
//                                                                 ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
      }
    } else if (stringRes != 0) {
//             ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
      if (formatArgs != null) {
//        ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
        return context.getResources().getString(stringRes, formatArgs);
//             ^^^^^^^ reference local9
//                     ^^^^^^^^^^^^ reference getResources#
//                                    ^^^^^^^^^ reference getResources#getString#
//                                              ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
//                                                         ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
      } else {
        return context.getResources().getText(stringRes);
//             ^^^^^^^ reference local9
//                     ^^^^^^^^^^^^ reference getResources#
//                                    ^^^^^^^ reference getResources#getText#
//                                            ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
      }
    } else {
      return string;
//           ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
    }
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public boolean equals(Object o) {
//               ^^^^^^ definition com/airbnb/epoxy/StringAttributeData#equals(). @Override public boolean equals(Object o)
//                      ^^^^^^ reference java/lang/Object#
//                             ^ definition local10 Object o
    if (this == o) {
//      ^^^^ reference com/airbnb/epoxy/StringAttributeData#
//              ^ reference local10
      return true;
    }
    if (!(o instanceof StringAttributeData)) {
//        ^ reference local10
//                     ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#
      return false;
    }

    StringAttributeData that = (StringAttributeData) o;
//  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#
//                      ^^^^ definition local11 StringAttributeData that
//                              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#
//                                                   ^ reference local10

    if (stringRes != that.stringRes) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
//                   ^^^^ reference local11
//                        ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
      return false;
    }
    if (pluralRes != that.pluralRes) {
//      ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
//                   ^^^^ reference local11
//                        ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
      return false;
    }
    if (quantity != that.quantity) {
//      ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
//                  ^^^^ reference local11
//                       ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
      return false;
    }
    if (string != null ? !string.equals(that.string) : that.string != null) {
//      ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                        ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                               ^^^^^^ reference java/lang/Object#equals().
//                                      ^^^^ reference local11
//                                           ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                                                     ^^^^ reference local11
//                                                          ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
      return false;
    }

    return Arrays.equals(formatArgs, that.formatArgs);
//         ^^^^^^ reference java/util/Arrays#
//                ^^^^^^ reference java/util/Arrays#equals(+16).
//                       ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
//                                   ^^^^ reference local11
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
  }

  @Override
// ^^^^^^^^ reference java/lang/Override#
  public int hashCode() {
//           ^^^^^^^^ definition com/airbnb/epoxy/StringAttributeData#hashCode(). @Override public int hashCode()
    int result = string != null ? string.hashCode() : 0;
//      ^^^^^^ definition local12 int result
//               ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                                ^^^^^^ reference com/airbnb/epoxy/StringAttributeData#string.
//                                       ^^^^^^^^ reference java/lang/Object#hashCode().
    result = 31 * result + stringRes;
//  ^^^^^^ reference local12
//                ^^^^^^ reference local12
//                         ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#stringRes.
    result = 31 * result + pluralRes;
//  ^^^^^^ reference local12
//                ^^^^^^ reference local12
//                         ^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#pluralRes.
    result = 31 * result + quantity;
//  ^^^^^^ reference local12
//                ^^^^^^ reference local12
//                         ^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#quantity.
    result = 31 * result + Arrays.hashCode(formatArgs);
//  ^^^^^^ reference local12
//                ^^^^^^ reference local12
//                         ^^^^^^ reference java/util/Arrays#
//                                ^^^^^^^^ reference java/util/Arrays#hashCode(+8).
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/StringAttributeData#formatArgs.
    return result;
//         ^^^^^^ reference local12
  }
}
