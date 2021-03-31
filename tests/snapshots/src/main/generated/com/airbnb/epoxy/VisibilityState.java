package com.airbnb.epoxy;

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

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^ reference androidx/annotation/IntDef#

public final class VisibilityState {
//                 ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState# public final class VisibilityState
//                 ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#`<init>`(). public <init>()

  @Retention(RetentionPolicy.SOURCE)
// ^^^^^^^^^ reference java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference java/lang/annotation/RetentionPolicy#SOURCE.
  @IntDef({VISIBLE,
// ^^^^^^ reference androidx/annotation/IntDef#
//         ^^^^^^^ reference com/airbnb/epoxy/VisibilityState#VISIBLE.
           INVISIBLE,
//         ^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#INVISIBLE.
           FOCUSED_VISIBLE,
//         ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#FOCUSED_VISIBLE.
           UNFOCUSED_VISIBLE,
//         ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#UNFOCUSED_VISIBLE.
           FULL_IMPRESSION_VISIBLE,
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#FULL_IMPRESSION_VISIBLE.
           PARTIAL_IMPRESSION_VISIBLE,
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_VISIBLE.
           PARTIAL_IMPRESSION_INVISIBLE})
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_INVISIBLE.
  public @interface Visibility {
//                  ^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#Visibility# public @interface Visibility
  }

  /**
   * Event triggered when a Component enters the Visible Range. This happens when at least a pixel
   * of the Component is visible.
   */
  public static final int VISIBLE = 0;
//                        ^^^^^^^ definition com/airbnb/epoxy/VisibilityState#VISIBLE. public static final int VISIBLE

  /**
   * Event triggered when a Component becomes invisible. This is the same with exiting the Visible
   * Range, the Focused Range and the Full Impression Range. All the code that needs to be executed
   * when a component leaves any of these ranges should be written in the handler for this event.
   */
  public static final int INVISIBLE = 1;
//                        ^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#INVISIBLE. public static final int INVISIBLE

  /**
   * Event triggered when a Component enters the Focused Range. This happens when either the
   * Component occupies at least half of the viewport or, if the Component is smaller than half of
   * the viewport, when the it is fully visible.
   */
  public static final int FOCUSED_VISIBLE = 2;
//                        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#FOCUSED_VISIBLE. public static final int FOCUSED_VISIBLE

  /**
   * Event triggered when a Component exits the Focused Range. The Focused Range is defined as at
   * least half of the viewport or, if the Component is smaller than half of the viewport, when the
   * it is fully visible.
   */
  public static final int UNFOCUSED_VISIBLE = 3;
//                        ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#UNFOCUSED_VISIBLE. public static final int UNFOCUSED_VISIBLE

  /**
   * Event triggered when a Component enters the Full Impression Range. This happens, for instance
   * in the case of a vertical RecyclerView, when both the top and bottom edges of the component
   * become visible.
   */
  public static final int FULL_IMPRESSION_VISIBLE = 4;
//                        ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#FULL_IMPRESSION_VISIBLE. public static final int FULL_IMPRESSION_VISIBLE

  /**
   * Event triggered when a Component enters the Partial Impression Range. This happens, for
   * instance in the case of a vertical RecyclerView, when the percentage of the visible area is
   * at least the specified threshold. The threshold can be set in
   * {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.
   */
  public static final int PARTIAL_IMPRESSION_VISIBLE = 5;
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_VISIBLE. public static final int PARTIAL_IMPRESSION_VISIBLE

  /**
   * Event triggered when a Component exits the Partial Impression Range. This happens, for
   * instance in the case of a vertical RecyclerView, when the percentage of the visible area is
   * less than a specified threshold. The threshold can be set in
   * {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.
   */
  public static final int PARTIAL_IMPRESSION_INVISIBLE = 6;
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_INVISIBLE. public static final int PARTIAL_IMPRESSION_INVISIBLE
}
