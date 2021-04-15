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

/**
 * This can be used to annotate methods inside classes with a {@link ModelView} annotation. Methods
 * with this annotation will be called when the visibility state is changed.
 * <p>
 * Annotated methods should follow this signature :
 * `@OnVisibilityStateChanged
 * public void method(@Visibility int state)`
 * <p>
 * Possible States are declared in {@link com.airbnb.epoxy.VisibilityState}.
 * <p>
 * The equivalent methods on the model is
 * {@link com.airbnb.epoxy.EpoxyModel#onVisibilityStateChanged}
 * <p>
 * @see OnModelVisibilityStateChangedListener
 */
@SuppressWarnings("JavadocReference")
//^^^^^^^^^^^^^^^ reference java/lang/SuppressWarnings#
@Target(ElementType.METHOD)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^^^ reference java/lang/annotation/ElementType#METHOD.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface OnVisibilityStateChanged {
//                ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/OnVisibilityStateChanged# @SuppressWarnings("JavadocReference") @Target(ElementType.METHOD) @Retention(RetentionPolicy.CLASS) public @interface OnVisibilityStateChanged
}
