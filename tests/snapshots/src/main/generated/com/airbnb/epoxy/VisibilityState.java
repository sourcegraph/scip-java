package com.airbnb.epoxy;

import java.lang.annotation.Retention;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
import java.lang.annotation.RetentionPolicy;
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/lang/
//               ^^^^^^^^^^ reference semanticdb maven . . java/lang/annotation/
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#

import androidx.annotation.IntDef;
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#

public final class VisibilityState {
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#
//                                 display_name VisibilityState
//                                 signature_documentation java public final class VisibilityState
//                                 kind Class
//                 ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#`<init>`().
//                                 display_name <init>
//                                 signature_documentation java public VisibilityState()
//                                 kind Constructor

  @Retention(RetentionPolicy.SOURCE)
// ^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/Retention#
//           ^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#
//                           ^^^^^^ reference semanticdb maven jdk 11 java/lang/annotation/RetentionPolicy#SOURCE.
  @IntDef({VISIBLE,
// ^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntDef#
//         ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#VISIBLE.
           INVISIBLE,
//         ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#INVISIBLE.
           FOCUSED_VISIBLE,
//         ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#FOCUSED_VISIBLE.
           UNFOCUSED_VISIBLE,
//         ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#UNFOCUSED_VISIBLE.
           FULL_IMPRESSION_VISIBLE,
//         ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#FULL_IMPRESSION_VISIBLE.
           PARTIAL_IMPRESSION_VISIBLE,
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_VISIBLE.
           PARTIAL_IMPRESSION_INVISIBLE})
//         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_INVISIBLE.
  public @interface Visibility {
//                  ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#Visibility#
//                             display_name Visibility
//                             signature_documentation java @Retention(RetentionPolicy.SOURCE)\n@IntDef({VISIBLE, INVISIBLE, FOCUSED_VISIBLE, UNFOCUSED_VISIBLE, FULL_IMPRESSION_VISIBLE, PARTIAL_IMPRESSION_VISIBLE, PARTIAL_IMPRESSION_INVISIBLE})\npublic @interface Visibility
//                             kind Interface
//                             relationship is_implementation semanticdb maven jdk 11 java/lang/annotation/Annotation#
  }

  /**
   * Event triggered when a Component enters the Visible Range. This happens when at least a pixel
   * of the Component is visible.
   */
  public static final int VISIBLE = 0;
//                        ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#VISIBLE.
//                                display_name VISIBLE
//                                signature_documentation java public static final int VISIBLE
//                                kind StaticField
//                                documentation  Event triggered when a Component enters the Visible Range. This happens when at least a pixel\n of the Component is visible.\n

  /**
   * Event triggered when a Component becomes invisible. This is the same with exiting the Visible
   * Range, the Focused Range and the Full Impression Range. All the code that needs to be executed
   * when a component leaves any of these ranges should be written in the handler for this event.
   */
  public static final int INVISIBLE = 1;
//                        ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#INVISIBLE.
//                                  display_name INVISIBLE
//                                  signature_documentation java public static final int INVISIBLE
//                                  kind StaticField
//                                  documentation  Event triggered when a Component becomes invisible. This is the same with exiting the Visible\n Range, the Focused Range and the Full Impression Range. All the code that needs to be executed\n when a component leaves any of these ranges should be written in the handler for this event.\n

  /**
   * Event triggered when a Component enters the Focused Range. This happens when either the
   * Component occupies at least half of the viewport or, if the Component is smaller than half of
   * the viewport, when the it is fully visible.
   */
  public static final int FOCUSED_VISIBLE = 2;
//                        ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#FOCUSED_VISIBLE.
//                                        display_name FOCUSED_VISIBLE
//                                        signature_documentation java public static final int FOCUSED_VISIBLE
//                                        kind StaticField
//                                        documentation  Event triggered when a Component enters the Focused Range. This happens when either the\n Component occupies at least half of the viewport or, if the Component is smaller than half of\n the viewport, when the it is fully visible.\n

  /**
   * Event triggered when a Component exits the Focused Range. The Focused Range is defined as at
   * least half of the viewport or, if the Component is smaller than half of the viewport, when the
   * it is fully visible.
   */
  public static final int UNFOCUSED_VISIBLE = 3;
//                        ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#UNFOCUSED_VISIBLE.
//                                          display_name UNFOCUSED_VISIBLE
//                                          signature_documentation java public static final int UNFOCUSED_VISIBLE
//                                          kind StaticField
//                                          documentation  Event triggered when a Component exits the Focused Range. The Focused Range is defined as at\n least half of the viewport or, if the Component is smaller than half of the viewport, when the\n it is fully visible.\n

  /**
   * Event triggered when a Component enters the Full Impression Range. This happens, for instance
   * in the case of a vertical RecyclerView, when both the top and bottom edges of the component
   * become visible.
   */
  public static final int FULL_IMPRESSION_VISIBLE = 4;
//                        ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#FULL_IMPRESSION_VISIBLE.
//                                                display_name FULL_IMPRESSION_VISIBLE
//                                                signature_documentation java public static final int FULL_IMPRESSION_VISIBLE
//                                                kind StaticField
//                                                documentation  Event triggered when a Component enters the Full Impression Range. This happens, for instance\n in the case of a vertical RecyclerView, when both the top and bottom edges of the component\n become visible.\n

  /**
   * Event triggered when a Component enters the Partial Impression Range. This happens, for
   * instance in the case of a vertical RecyclerView, when the percentage of the visible area is
   * at least the specified threshold. The threshold can be set in
   * {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.
   */
  public static final int PARTIAL_IMPRESSION_VISIBLE = 5;
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_VISIBLE.
//                                                   display_name PARTIAL_IMPRESSION_VISIBLE
//                                                   signature_documentation java public static final int PARTIAL_IMPRESSION_VISIBLE
//                                                   kind StaticField
//                                                   documentation  Event triggered when a Component enters the Partial Impression Range. This happens, for\n instance in the case of a vertical RecyclerView, when the percentage of the visible area is\n at least the specified threshold. The threshold can be set in\n {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.\n

  /**
   * Event triggered when a Component exits the Partial Impression Range. This happens, for
   * instance in the case of a vertical RecyclerView, when the percentage of the visible area is
   * less than a specified threshold. The threshold can be set in
   * {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.
   */
  public static final int PARTIAL_IMPRESSION_INVISIBLE = 6;
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/VisibilityState#PARTIAL_IMPRESSION_INVISIBLE.
//                                                     display_name PARTIAL_IMPRESSION_INVISIBLE
//                                                     signature_documentation java public static final int PARTIAL_IMPRESSION_INVISIBLE
//                                                     kind StaticField
//                                                     documentation  Event triggered when a Component exits the Partial Impression Range. This happens, for\n instance in the case of a vertical RecyclerView, when the percentage of the visible area is\n less than a specified threshold. The threshold can be set in\n {@link EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage(int)}.\n
}
