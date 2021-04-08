package com.airbnb.epoxy;

import java.lang.annotation.ElementType;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
import java.lang.annotation.Retention;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^ reference java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
import java.lang.annotation.Target;
//     ^^^^ reference java/
//          ^^^^ reference java/lang/
//               ^^^^^^^^^^ reference java/lang/annotation/
//                          ^^^^^^ reference java/lang/annotation/Target#

import androidx.annotation.StringRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/StringRes#

/**
 * A convenient replacement for {@link ModelProp} when the prop represents text.
 * <p>
 * This can only be used when the setter parameter is a {@link CharSequence}
 * <p>
 * This is the same as using {@link ModelProp} with the option {@link
 * com.airbnb.epoxy.ModelProp.Option#GenerateStringOverloads}
 */
@Target({ElementType.METHOD, ElementType.FIELD})
//^^^^^ reference java/lang/annotation/Target#
//       ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                   ^^^^^^ reference java/lang/annotation/ElementType#METHOD.
//                           ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                                       ^^^^^ reference java/lang/annotation/ElementType#FIELD.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface TextProp {
//                ^^^^^^^^ definition com/airbnb/epoxy/TextProp# @Target({ElementType.METHOD, ElementType.FIELD}) @Retention(RetentionPolicy.CLASS) public @interface TextProp

  @StringRes int defaultRes() default 0;
// ^^^^^^^^^ reference androidx/annotation/StringRes#
//               ^^^^^^^^^^ definition com/airbnb/epoxy/TextProp#defaultRes(). @StringRes public abstract int defaultRes()
}
