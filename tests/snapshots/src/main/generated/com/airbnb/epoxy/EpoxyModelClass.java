
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

import androidx.annotation.LayoutRes;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^ reference androidx/annotation/LayoutRes#

/**
 * Used to annotate EpoxyModel classes in order to generate a subclass of that model with getters,
 * setters, equals, and hashcode for the annotated fields, as well as other helper methods and
 * boilerplate reduction.
 */
@Target(ElementType.TYPE)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^ reference java/lang/annotation/ElementType#TYPE.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface EpoxyModelClass {
//                ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelClass# public abstract EpoxyModelClass extends Annotation
  /**
   * A layout resource that should be used as the default layout for the model. If you set this you
   * don't have to implement `getDefaultLayout`; it will be generated for you.
   */
  @LayoutRes int layout() default 0;
// ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//               ^^^^^^ definition com/airbnb/epoxy/EpoxyModelClass#layout(). public abstract int layout()

  /**
   * If true, any layout file name that has {@link #layout()} as a prefix will be included as a
   * method on the generated model.
   * <p>
   * For example, if the layout is "R.layout.my_view" then any layouts in the form of
   * "R.layout.my_view_*" will result in a generated method like "with*Layout" that will apply that
   * other layout instead of the default.
   */
  boolean useLayoutOverloads() default false;
//        ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyModelClass#useLayoutOverloads(). public abstract boolean useLayoutOverloads()
}
