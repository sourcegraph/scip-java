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
 * An annotation on custom view classes to automatically generate an EpoxyModel for that view. Used
 * in conjunction with {@link ModelProp}
 * <p>
 * See https://github.com/airbnb/epoxy/wiki/Generating-Models-from-View-Annotations
 */
@Target(ElementType.TYPE)
//^^^^^ reference java/lang/annotation/Target#
//      ^^^^^^^^^^^ reference java/lang/annotation/ElementType#
//                  ^^^^ reference java/lang/annotation/ElementType#TYPE.
@Retention(RetentionPolicy.CLASS)
//^^^^^^^^ reference java/lang/annotation/Retention#
//         ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                         ^^^^^ reference java/lang/annotation/RetentionPolicy#CLASS.
public @interface ModelView {
//                ^^^^^^^^^ definition com/airbnb/epoxy/ModelView# public @interface ModelView

  /**
   * Use with {@link #autoLayout()} to declare what layout parameters should be used to size your
   * view when it is added to a RecyclerView. This maps to the LayoutParams options {@code
   * layout_width} and {@code layout_height}.
   */
  enum Size {
//     ^^^^ definition com/airbnb/epoxy/ModelView#Size# public enum Size
//     ^^^^ definition com/airbnb/epoxy/ModelView#Size#`<init>`(). private void <init>()
    NONE,
//  ^^^^ definition com/airbnb/epoxy/ModelView#Size#NONE. Size.NONE /* ordinal 0 */
    WRAP_WIDTH_WRAP_HEIGHT,
//  ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#Size#WRAP_WIDTH_WRAP_HEIGHT. Size.WRAP_WIDTH_WRAP_HEIGHT /* ordinal 1 */
    WRAP_WIDTH_MATCH_HEIGHT,
//  ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#Size#WRAP_WIDTH_MATCH_HEIGHT. Size.WRAP_WIDTH_MATCH_HEIGHT /* ordinal 2 */
    MATCH_WIDTH_WRAP_HEIGHT,
//  ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#Size#MATCH_WIDTH_WRAP_HEIGHT. Size.MATCH_WIDTH_WRAP_HEIGHT /* ordinal 3 */
    MATCH_WIDTH_MATCH_HEIGHT
//  ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#Size#MATCH_WIDTH_MATCH_HEIGHT. Size.MATCH_WIDTH_MATCH_HEIGHT /* ordinal 4 */
  }

  /**
   * If set to an option besides {@link Size#NONE} Epoxy will create an instance of this view
   * programmatically at runtime instead of inflating the view from xml. This is an alternative to
   * using {@link #defaultLayout()}, and is a good option if you just need to specify layout
   * parameters on your view with no other styling.
   * <p>
   * The size option you choose will define which layout parameters Epoxy uses at runtime when
   * creating the view.
   */
  Size autoLayout() default Size.NONE;
//^^^^ reference com/airbnb/epoxy/ModelView#Size#
//     ^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#autoLayout(). public abstract Size autoLayout()
//                          ^^^^ reference com/airbnb/epoxy/ModelView#Size#
//                               ^^^^ reference com/airbnb/epoxy/ModelView#Size#NONE.

  /**
   * The layout file to use in the generated model to inflate the view. This is required unless a
   * default pattern is set via {@link PackageModelViewConfig} or {@link #autoLayout()} is used.
   * <p>
   * Overrides any default set in {@link PackageModelViewConfig}
   */
  @LayoutRes int defaultLayout() default 0;
// ^^^^^^^^^ reference androidx/annotation/LayoutRes#
//               ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#defaultLayout(). public abstract int defaultLayout()
  /**
   * An optional EpoxyModel subclass to use as the base class of the generated view. A default can
   * also be set with {@link PackageModelViewConfig}
   * <p>
   * * Overrides any default set in {@link PackageModelViewConfig}
   */
  Class<?> baseModelClass() default Void.class;
//^^^^^ reference java/lang/Class#
//         ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#baseModelClass(). public abstract Class<?> baseModelClass()
//                                  ^^^^ reference java/lang/Void#
//                                       ^^^^^ reference java/lang/Void#class.
  /**
   * Whether the model should save view state when unbound.
   * <p>
   * see: EpoxyModel#shouldSaveViewState
   */
  boolean saveViewState() default false;
//        ^^^^^^^^^^^^^ definition com/airbnb/epoxy/ModelView#saveViewState(). public abstract boolean saveViewState()
  /**
   * True to have the generated model take up the total available span count. False to instead use a
   * span count of 1. If you need to programmatically determine your model's span size you can use
   * the spanSizeCallback method on EpoxyModel.
   */
  boolean fullSpan() default true;
//        ^^^^^^^^ definition com/airbnb/epoxy/ModelView#fullSpan(). public abstract boolean fullSpan()
}
