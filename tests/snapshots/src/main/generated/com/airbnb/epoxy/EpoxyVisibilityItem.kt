package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntRange
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/IntRange#
import androidx.annotation.Px
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#
import androidx.annotation.VisibleForTesting
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/

/**
 * This class represent an item in a [android.view.ViewGroup] and it is
 * being reused with multiple model via the update method. There is 1:1 relationship between an
 * EpoxyVisibilityItem and a child within the [android.view.ViewGroup].
 *
 * It contains the logic to compute the visibility state of an item. It will also invoke the
 * visibility callbacks on [com.airbnb.epoxy.EpoxyViewHolder]
 *
 * This class should remain non-public and is intended to be used by [EpoxyVisibilityTracker]
 * only.
 */
@VisibleForTesting(otherwise = VisibleForTesting.PACKAGE_PRIVATE)
//^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#`<init>`().
//                 ^^^^^^^^^ reference androidx/annotation/VisibleForTesting#`<init>`().(otherwise)
//                             ^^^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#
//                                               ^^^^^^^^^^^^^^^ reference androidx/annotation/VisibleForTesting#PACKAGE_PRIVATE.
class EpoxyVisibilityItem(adapterPosition: Int? = null) {
//    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#
//    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().
//                        ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().(adapterPosition)
//                                         ^^^ reference kotlin/Int#

    private val localVisibleRect = Rect()
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().

    var adapterPosition = RecyclerView.NO_POSITION
//      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
        private set
//              ^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setAdapterPosition().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var height = 0
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#height.
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//              ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var width = 0
//              ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#width.
//              ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//              ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var visibleHeight = 0
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var visibleWidth = 0
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var viewportHeight = 0
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().

    @Px
//   ^^ reference androidx/annotation/Px#`<init>`().
    private var viewportWidth = 0
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
    private var partiallyVisible = false
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
    private var fullyVisible = false
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
    private var visible = false
//              ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//              ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//              ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
    private var focusedVisible = false
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
    private var viewVisibility = View.GONE
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().

    /** Store last value for de-duping  */
    private var lastVisibleHeightNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                         ^^^ reference kotlin/Int#
    private var lastVisibleWidthNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//              ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                        ^^^ reference kotlin/Int#
    private var lastVisibilityNotified: Int? = null
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
//                                      ^^^ reference kotlin/Int#

    init {
        adapterPosition?.let {
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().(adapterPosition)
//                       ^^^ reference kotlin/StandardKt#let().
            reset(it)
//          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#reset().
//                ^^ reference local0
        }
    }

    /**
     * Update the visibility item according the current layout.
     *
     * @param view        the current [com.airbnb.epoxy.EpoxyViewHolder]'s itemView
     * @param parent      the [android.view.ViewGroup]
     * @return true if the view has been measured
     */
    fun update(view: View, parent: ViewGroup, detachEvent: Boolean): Boolean {
//      ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#update().
//             ^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
//                         ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
//                                            ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#update().(detachEvent)
//                                                         ^^^^^^^ reference kotlin/Boolean#
//                                                                   ^^^^^^^ reference kotlin/Boolean#
        // Clear the rect before calling getLocalVisibleRect
        localVisibleRect.setEmpty()
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
        val viewDrawn = view.getLocalVisibleRect(localVisibleRect) && !detachEvent
//          ^^^^^^^^^ definition local1
//                      ^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
//                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//                                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
//                                                                    ^ reference kotlin/Boolean#not().
//                                                                     ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(detachEvent)
        height = view.height
//      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//               ^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        width = view.width
//      ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//      ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//      ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//              ^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        viewportHeight = parent.height
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().
//                       ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
        viewportWidth = parent.width
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(parent)
        visibleHeight = if (viewDrawn) localVisibleRect.height() else 0
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                          ^^^^^^^^^ reference local1
//                                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//                                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
        visibleWidth = if (viewDrawn) localVisibleRect.width() else 0
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                         ^^^^^^^^^ reference local1
//                                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#localVisibleRect.
//                                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLocalVisibleRect().
        viewVisibility = view.visibility
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                       ^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#update().(view)
        return height > 0 && width > 0
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                    ^ reference kotlin/Int#compareTo(+3).
//                           ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                           ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                           ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                                 ^ reference kotlin/Int#compareTo(+3).
    }

    fun reset(newAdapterPosition: Int) {
//      ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#reset().
//            ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#reset().(newAdapterPosition)
//                                ^^^ reference kotlin/Int#
        fullyVisible = false
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
        visible = false
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
        focusedVisible = false
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
        adapterPosition = newAdapterPosition
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                        ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#reset().(newAdapterPosition)
        lastVisibleHeightNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
        lastVisibleWidthNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
        lastVisibilityNotified = null
//      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
    }

    fun handleVisible(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
//                                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(detachEvent)
//                                                               ^^^^^^^ reference kotlin/Boolean#
        val previousVisible = visible
//          ^^^^^^^^^^^^^^^ definition local2
//                            ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//                            ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//                            ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
        visible = !detachEvent && isVisible()
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//                ^ reference kotlin/Boolean#not().
//                 ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(detachEvent)
//                                ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
        if (visible != previousVisible) {
//          ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//          ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//          ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
//                  ^^ reference kotlin/Boolean#equals().
//                     ^^^^^^^^^^^^^^^ reference local2
            if (visible) {
//              ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visible.
//              ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisible().
//              ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.VISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.INVISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleVisible().(epoxyHolder)
            }
        }
    }

    fun handleFocus(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
//                                                ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(detachEvent)
//                                                             ^^^^^^^ reference kotlin/Boolean#
        val previousFocusedVisible = focusedVisible
//          ^^^^^^^^^^^^^^^^^^^^^^ definition local3
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
        focusedVisible = !detachEvent && isInFocusVisible()
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
//                       ^ reference kotlin/Boolean#not().
//                        ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(detachEvent)
//                                       ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isInFocusVisible().
        if (focusedVisible != previousFocusedVisible) {
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
//                         ^^ reference kotlin/Boolean#equals().
//                            ^^^^^^^^^^^^^^^^^^^^^^ reference local3
            if (focusedVisible) {
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#focusedVisible.
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFocusedVisible().
//              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFocusedVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.FOCUSED_VISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.UNFOCUSED_VISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleFocus().(epoxyHolder)
            }
        }
    }

    fun handlePartialImpressionVisible(
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().
        epoxyHolder: EpoxyViewHolder,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(detachEvent)
//                   ^^^^^^^ reference kotlin/Boolean#
        @IntRange(from = 0, to = 100) thresholdPercentage: Int
//       ^^^^^^^^ reference androidx/annotation/IntRange#`<init>`().
//                ^^^^ reference androidx/annotation/IntRange#`<init>`().(from)
//                          ^^ reference androidx/annotation/IntRange#`<init>`().(to)
//                                    ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(thresholdPercentage)
//                                                         ^^^ reference kotlin/Int#
    ) {
        val previousPartiallyVisible = partiallyVisible
//          ^^^^^^^^^^^^^^^^^^^^^^^^ definition local4
//                                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//                                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//                                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
        partiallyVisible = !detachEvent && isPartiallyVisible(thresholdPercentage)
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
//                         ^ reference kotlin/Boolean#not().
//                          ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(detachEvent)
//                                         ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().
//                                                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(thresholdPercentage)
        if (partiallyVisible != previousPartiallyVisible) {
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
//                           ^^ reference kotlin/Boolean#equals().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^ reference local4
            if (partiallyVisible) {
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#partiallyVisible.
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getPartiallyVisible().
//              ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setPartiallyVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.PARTIAL_IMPRESSION_VISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
            } else {
                epoxyHolder.visibilityStateChanged(VisibilityState.PARTIAL_IMPRESSION_INVISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handlePartialImpressionVisible().(epoxyHolder)
            }
        }
    }

    fun handleFullImpressionVisible(epoxyHolder: EpoxyViewHolder, detachEvent: Boolean) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().
//                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(epoxyHolder)
//                                                                ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(detachEvent)
//                                                                             ^^^^^^^ reference kotlin/Boolean#
        val previousFullyVisible = fullyVisible
//          ^^^^^^^^^^^^^^^^^^^^ definition local5
//                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
        fullyVisible = !detachEvent && isFullyVisible()
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
//                     ^ reference kotlin/Boolean#not().
//                      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(detachEvent)
//                                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isFullyVisible().
        if (fullyVisible != previousFullyVisible) {
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
//                       ^^ reference kotlin/Boolean#equals().
//                          ^^^^^^^^^^^^^^^^^^^^ reference local5
            if (fullyVisible) {
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#fullyVisible.
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getFullyVisible().
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setFullyVisible().
                epoxyHolder.visibilityStateChanged(VisibilityState.FULL_IMPRESSION_VISIBLE)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleFullImpressionVisible().(epoxyHolder)
            }
        }
    }

    fun handleChanged(epoxyHolder: EpoxyViewHolder, visibilityChangedEnabled: Boolean): Boolean {
//      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().
//                    ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
//                                                  ^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(visibilityChangedEnabled)
//                                                                            ^^^^^^^ reference kotlin/Boolean#
//                                                                                      ^^^^^^^ reference kotlin/Boolean#
        var changed = false
//          ^^^^^^^ definition local6
        if (visibleHeight != lastVisibleHeightNotified || visibleWidth != lastVisibleWidthNotified || viewVisibility != lastVisibilityNotified) {
//          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                        ^^ reference kotlin/Int#equals().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//                           ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                                     ^^ reference kotlin/Int#equals().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                                                                                    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                                                                                    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                                                                                                    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//                                                                                                                      ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
            if (visibilityChangedEnabled) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(visibilityChangedEnabled)
                if (viewVisibility == View.GONE) {
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
                    epoxyHolder.visibilityChanged(0f, 0f, 0, 0)
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
                } else {
                    epoxyHolder.visibilityChanged(
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#handleChanged().(epoxyHolder)
                        100f / height * visibleHeight,
//                           ^ reference kotlin/Float#div(+3).
//                             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                             ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                                    ^ reference kotlin/Float#times(+3).
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
                        100f / width * visibleWidth,
//                           ^ reference kotlin/Float#div(+3).
//                             ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                             ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                             ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
//                                   ^ reference kotlin/Float#times(+3).
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
                        visibleHeight, visibleWidth
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
                    )
                }
            }
            lastVisibleHeightNotified = visibleHeight
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleHeightNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleHeightNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleHeightNotified().
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
            lastVisibleWidthNotified = visibleWidth
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibleWidthNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibleWidthNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibleWidthNotified().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
            lastVisibilityNotified = viewVisibility
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#lastVisibilityNotified.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getLastVisibilityNotified().
//          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setLastVisibilityNotified().
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
            changed = true
//          ^^^^^^^ reference local6
        }
        return changed
//             ^^^^^^^ reference local6
    }

    private fun isVisible(): Boolean {
//              ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
//                           ^^^^^^^ reference kotlin/Boolean#
        return viewVisibility == View.VISIBLE && visibleHeight > 0 && visibleWidth > 0
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                                             ^ reference kotlin/Int#compareTo(+3).
//                                                                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                                    ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                                                 ^ reference kotlin/Int#compareTo(+3).
    }

    private fun isInFocusVisible(): Boolean {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#isInFocusVisible().
//                                  ^^^^^^^ reference kotlin/Boolean#
        val halfViewportArea = viewportHeight * viewportWidth / 2
//          ^^^^^^^^^^^^^^^^ definition local7
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewportHeight.
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewportHeight().
//                             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewportHeight().
//                                            ^ reference kotlin/Int#times(+3).
//                                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewportWidth.
//                                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewportWidth().
//                                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewportWidth().
//                                                            ^ reference kotlin/Int#div(+3).
        val totalArea = height * width
//          ^^^^^^^^^ definition local8
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                             ^ reference kotlin/Int#times(+3).
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
        val visibleArea = visibleHeight * visibleWidth
//          ^^^^^^^^^^^ definition local9
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                      ^ reference kotlin/Int#times(+3).
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
        // The model has entered the focused range either if it is larger than half of the viewport
        // and it occupies at least half of the viewport or if it is smaller than half of the viewport
        // and it is fully visible.
        return viewVisibility == View.VISIBLE &&
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
            if (totalArea >= halfViewportArea) visibleArea >= halfViewportArea else totalArea == visibleArea
//              ^^^^^^^^^ reference local8
//                        ^^ reference kotlin/Int#compareTo(+3).
//                           ^^^^^^^^^^^^^^^^ reference local7
//                                             ^^^^^^^^^^^ reference local9
//                                                         ^^ reference kotlin/Int#compareTo(+3).
//                                                            ^^^^^^^^^^^^^^^^ reference local7
//                                                                                  ^^^^^^^^^ reference local8
//                                                                                            ^^ reference kotlin/Int#equals().
//                                                                                               ^^^^^^^^^^^ reference local9
    }

    private fun isPartiallyVisible(
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().
        @IntRange(
//       ^^^^^^^^ reference androidx/annotation/IntRange#`<init>`().
            from = 0,
//          ^^^^ reference androidx/annotation/IntRange#`<init>`().(from)
            to = 100
//          ^^ reference androidx/annotation/IntRange#`<init>`().(to)
        ) thresholdPercentage: Int
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
//                             ^^^ reference kotlin/Int#
    ): Boolean {
//     ^^^^^^^ reference kotlin/Boolean#
        // special case 0%: trigger as soon as some pixels are one the screen
        if (thresholdPercentage == 0) return isVisible()
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
//                              ^^ reference kotlin/Int#equals().
//                                           ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isVisible().
        val totalArea = height * width
//          ^^^^^^^^^ definition local10
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                      ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                             ^ reference kotlin/Int#times(+3).
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
        val visibleArea = visibleHeight * visibleWidth
//          ^^^^^^^^^^^ definition local11
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                      ^ reference kotlin/Int#times(+3).
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
        val visibleAreaPercentage = visibleArea / totalArea.toFloat() * 100
//          ^^^^^^^^^^^^^^^^^^^^^ definition local12
//                                  ^^^^^^^^^^^ reference local11
//                                              ^ reference kotlin/Int#div(+2).
//                                                ^^^^^^^^^ reference local10
//                                                          ^^^^^^^ reference kotlin/Int#toFloat().
//                                                                    ^ reference kotlin/Float#times(+3).
        return viewVisibility == View.VISIBLE && visibleAreaPercentage >= thresholdPercentage
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                               ^^^^^^^^^^^^^^^^^^^^^ reference local12
//                                                                     ^^ reference kotlin/Float#compareTo(+3).
//                                                                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#isPartiallyVisible().(thresholdPercentage)
    }

    private fun isFullyVisible(): Boolean {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#isFullyVisible().
//                                ^^^^^^^ reference kotlin/Boolean#
        return viewVisibility == View.VISIBLE && visibleHeight == height && visibleWidth == width
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#viewVisibility.
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getViewVisibility().
//             ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setViewVisibility().
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleHeight.
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleHeight().
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleHeight().
//                                                             ^^ reference kotlin/Int#equals().
//                                                                ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#height.
//                                                                ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getHeight().
//                                                                ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setHeight().
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#visibleWidth.
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getVisibleWidth().
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setVisibleWidth().
//                                                                                       ^^ reference kotlin/Int#equals().
//                                                                                          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#width.
//                                                                                          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getWidth().
//                                                                                          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#setWidth().
    }

    fun shiftBy(offsetPosition: Int) {
//      ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().(offsetPosition)
//                              ^^^ reference kotlin/Int#
        adapterPosition += offsetPosition
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
    }
}
