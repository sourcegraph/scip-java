package com.airbnb.epoxy.stickyheader
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/

import android.content.Context
import android.graphics.PointF
import android.os.Build
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.LinearLayoutManager
//     ^^^^^^^^ reference androidx/
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import kotlinx.android.parcel.Parcelize
//     ^^^^^^^ reference kotlinx/
//             ^^^^^^^ reference kotlinx/android/
//                     ^^^^^^ reference kotlinx/android/parcel/
//                            ^^^^^^^^^ reference kotlinx/android/parcel/Parcelize#

/**
 * Adds sticky headers capabilities to your [RecyclerView.Adapter].
 * The adapter / controller must override [StickyHeaderCallbacks.isStickyHeader] to
 * indicate which items are sticky.
 *
 * Example usage:
 * ```
 *  class StickyHeaderController() : EpoxyController() {
 *      override fun isStickyHeader(position: Int) {
 *          // Write your logic to tell which item is sticky.
 *      }
 *  }
 * ```
 */
class StickyHeaderLinearLayoutManager @JvmOverloads constructor(
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//                                     ^^^^^^^^^^^^ reference kotlin/jvm/JvmOverloads#`<init>`().
//                                                  ^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().
    context: Context,
//  ^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(context)
    orientation: Int = RecyclerView.VERTICAL,
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(orientation)
//               ^^^ reference kotlin/Int#
    reverseLayout: Boolean = false
//  ^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(reverseLayout)
//                 ^^^^^^^ reference kotlin/Boolean#
) : LinearLayoutManager(context, orientation, reverseLayout) {
//                      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(context)
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(orientation)
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(reverseLayout)

    private var adapter: BaseEpoxyAdapter? = null
//              ^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//              ^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//              ^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().

    // Translation for header
    private var translationX: Float = 0f
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                            ^^^^^ reference kotlin/Float#
    private var translationY: Float = 0f
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                            ^^^^^ reference kotlin/Float#

    // Header positions for the currently displayed list and their observer.
    private val headerPositions = mutableListOf<Int>()
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                ^^^^^^^^^^^^^ reference kotlin/collections/CollectionsKt#mutableListOf().
//                                              ^^^ reference kotlin/Int#
    private val headerPositionsObserver = HeaderPositionsAdapterDataObserver()
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#`<init>`().

    // Sticky header's ViewHolder and dirty state.
    private var stickyHeader: View? = null
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
    private var stickyHeaderPosition = RecyclerView.NO_POSITION
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().

    // Save / Restore scroll state
    private var scrollPosition = RecyclerView.NO_POSITION
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
    private var scrollOffset = 0
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().

    override fun onAttachedToWindow(recyclerView: RecyclerView) {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
        super.onAttachedToWindow(recyclerView)
//      ^^^^^ reference kotlin/Any#
//                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
        setAdapter(recyclerView.adapter)
//      ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
    }

    override fun onAdapterChanged(oldAdapter: RecyclerView.Adapter<*>?, newAdapter: RecyclerView.Adapter<*>?) {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().
//                                ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(oldAdapter)
//                                                                      ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
        super.onAdapterChanged(oldAdapter, newAdapter)
//      ^^^^^ reference kotlin/Any#
//                             ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(oldAdapter)
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
        setAdapter(newAdapter)
//      ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                 ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
    }

    @Suppress("UNCHECKED_CAST")
//   ^^^^^^^^ reference kotlin/Suppress#`<init>`().
    private fun setAdapter(newAdapter: RecyclerView.Adapter<*>?) {
//              ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                         ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
        adapter?.unregisterAdapterDataObserver(headerPositionsObserver)
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                             ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//                                             ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
        if (newAdapter is BaseEpoxyAdapter) {
//          ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
            adapter = newAdapter
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
            adapter?.registerAdapterDataObserver(headerPositionsObserver)
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//                                               ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
            headerPositionsObserver.onChanged()
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//                                  ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onChanged().
        } else {
            adapter = null
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
            headerPositions.clear()
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                          ^^^^^ reference kotlin/collections/MutableList#clear().
        }
    }

    override fun onSaveInstanceState(): Parcelable {
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onSaveInstanceState().
        return SavedState(
//             ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().
            superState = super.onSaveInstanceState(),
//          ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(superState)
//                       ^^^^^ reference kotlin/Any#
            scrollPosition = scrollPosition,
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollPosition)
//                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                           ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
            scrollOffset = scrollOffset
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollOffset)
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
        )
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().
//                                      ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().(state)
        (state as? SavedState)?.let {
//       ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().(state)
//                 ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#
//                              ^^^ reference kotlin/StandardKt#let().
            scrollPosition = it.scrollPosition
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                           ^^ reference local0
//                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollPosition.
//                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollPosition().
            scrollOffset = it.scrollOffset
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
//                         ^^ reference local0
//                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollOffset.
//                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollOffset().
            super.onRestoreInstanceState(it.superState)
//          ^^^^^ reference kotlin/Any#
//                                       ^^ reference local0
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#superState.
//                                          ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getSuperState().
        }
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State?): Int {
//               ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().
//                                  ^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(dy)
//                                      ^^^ reference kotlin/Int#
//                                           ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
//                                                                            ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(state)
//                                                                                                         ^^^ reference kotlin/Int#
        val scrolled = restoreView { super.scrollVerticallyBy(dy, recycler, state) }
//          ^^^^^^^^ definition local1
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                   ^^^^^ reference kotlin/Any#
//                                                            ^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(dy)
//                                                                ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
//                                                                          ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(state)
        if (scrolled != 0) {
//          ^^^^^^^^ reference local1
//                   ^^ reference kotlin/Unit#equals().
            updateStickyHeader(recycler, false)
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
        }
        return scrolled
//             ^^^^^^^^ reference local1
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State?): Int {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().
//                                    ^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(dx)
//                                        ^^^ reference kotlin/Int#
//                                             ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
//                                                                              ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(state)
//                                                                                                           ^^^ reference kotlin/Int#
        val scrolled = restoreView { super.scrollHorizontallyBy(dx, recycler, state) }
//          ^^^^^^^^ definition local2
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                   ^^^^^ reference kotlin/Any#
//                                                              ^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(dx)
//                                                                  ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
//                                                                            ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(state)
        if (scrolled != 0) {
//          ^^^^^^^^ reference local2
//                   ^^ reference kotlin/Unit#equals().
            updateStickyHeader(recycler, false)
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
        }
        return scrolled
//             ^^^^^^^^ reference local2
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().
//                                ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
//                                                                 ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
        restoreView { super.onLayoutChildren(recycler, state) }
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                    ^^^^^ reference kotlin/Any#
//                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
//                                                     ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
        if (!state.isPreLayout) {
//           ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
            updateStickyHeader(recycler, true)
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
        }
    }

    override fun scrollToPosition(position: Int) = scrollToPositionWithOffset(position, INVALID_OFFSET)
//               ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().
//                                ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().(position)
//                                          ^^^ reference kotlin/Int#
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                                                            ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().(position)

    override fun scrollToPositionWithOffset(position: Int, offset: Int) = scrollToPositionWithOffset(position, offset, true)
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                          ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(position)
//                                                    ^^^ reference kotlin/Int#
//                                                         ^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(offset)
//                                                                 ^^^ reference kotlin/Int#
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).
//                                                                                                   ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(position)
//                                                                                                             ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(offset)

    private fun scrollToPositionWithOffset(position: Int, offset: Int, adjustForStickyHeader: Boolean) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).
//                                         ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                   ^^^ reference kotlin/Int#
//                                                        ^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                                                ^^^ reference kotlin/Int#
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(adjustForStickyHeader)
//                                                                                            ^^^^^^^ reference kotlin/Boolean#
        // Reset pending scroll.
        setScrollState(RecyclerView.NO_POSITION, INVALID_OFFSET)
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().

        // Adjusting is disabled.
        if (!adjustForStickyHeader) {
//          ^ reference kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(adjustForStickyHeader)
            super.scrollToPositionWithOffset(position, offset)
//          ^^^^^ reference kotlin/Any#
//                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // There is no header above or the position is a header.
        val headerIndex = findHeaderIndexOrBefore(position)
//          ^^^^^^^^^^^ definition local3
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                                ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
        if (headerIndex == -1 || findHeaderIndex(position) != -1) {
//          ^^^^^^^^^^^ reference local3
//                      ^^ reference kotlin/Int#equals().
//                         ^ reference kotlin/Int#unaryMinus().
//                               ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                               ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                         ^^ reference kotlin/Int#equals().
//                                                            ^ reference kotlin/Int#unaryMinus().
            super.scrollToPositionWithOffset(position, offset)
//          ^^^^^ reference kotlin/Any#
//                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // The position is right below a header, scroll to the header.
        if (findHeaderIndex(position - 1) != -1) {
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                          ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                   ^ reference kotlin/Int#minus(+3).
//                                        ^^ reference kotlin/Int#equals().
//                                           ^ reference kotlin/Int#unaryMinus().
            super.scrollToPositionWithOffset(position - 1, offset)
//          ^^^^^ reference kotlin/Any#
//                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                    ^ reference kotlin/Int#minus(+3).
//                                                         ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // Current sticky header is the same as at the position. Adjust the scroll offset and reset pending scroll.
        if (stickyHeader != null && headerIndex == findHeaderIndex(stickyHeaderPosition)) {
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                  ^^^^^^^^^^^ reference local3
//                                              ^^ reference kotlin/Int#equals().
//                                                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
            val adjustedOffset = (if (offset != INVALID_OFFSET) offset else 0) + stickyHeader!!.height
//              ^^^^^^^^^^^^^^ definition local4
//                                    ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                           ^^ reference kotlin/Int#equals().
//                                                              ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                                                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                                               ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
            super.scrollToPositionWithOffset(position, adjustedOffset)
//          ^^^^^ reference kotlin/Any#
//                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^^^^^^^^^ reference local4
            return
        }

        // Remember this position and offset and scroll to it to trigger creating the sticky header.
        setScrollState(position, offset)
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
//                     ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                               ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
        super.scrollToPositionWithOffset(position, offset)
//      ^^^^^ reference kotlin/Any#
//                                       ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                 ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
    }

    //region Computation
    // Mainly [RecyclerView] functionality by removing sticky header from calculations

    override fun computeVerticalScrollExtent(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollExtent(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().
//                                           ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().(state)
//                                                                       ^^^ reference kotlin/Int#
//                                                                             ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                           ^^^^^ reference kotlin/Any#
//                                                                                                                             ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().(state)

    override fun computeVerticalScrollOffset(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollOffset(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().
//                                           ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().(state)
//                                                                       ^^^ reference kotlin/Int#
//                                                                             ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                           ^^^^^ reference kotlin/Any#
//                                                                                                                             ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().(state)

    override fun computeVerticalScrollRange(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollRange(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().
//                                          ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().(state)
//                                                                      ^^^ reference kotlin/Int#
//                                                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                          ^^^^^ reference kotlin/Any#
//                                                                                                                           ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().(state)

    override fun computeHorizontalScrollExtent(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollExtent(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().
//                                             ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().(state)
//                                                                         ^^^ reference kotlin/Int#
//                                                                               ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                             ^^^^^ reference kotlin/Any#
//                                                                                                                                 ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().(state)

    override fun computeHorizontalScrollOffset(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollOffset(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().
//                                             ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().(state)
//                                                                         ^^^ reference kotlin/Int#
//                                                                               ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                             ^^^^^ reference kotlin/Any#
//                                                                                                                                 ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().(state)

    override fun computeHorizontalScrollRange(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollRange(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().
//                                            ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().(state)
//                                                                        ^^^ reference kotlin/Int#
//                                                                              ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                            ^^^^^ reference kotlin/Any#
//                                                                                                                               ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().(state)

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF? = restoreView { super.computeScrollVectorForPosition(targetPosition) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().
//                                              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().(targetPosition)
//                                                              ^^^ reference kotlin/Int#
//                                                                              ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                            ^^^^^ reference kotlin/Any#
//                                                                                                                                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().(targetPosition)

    override fun onFocusSearchFailed(
//               ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().
        focused: View,
//      ^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focused)
        focusDirection: Int,
//      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focusDirection)
//                      ^^^ reference kotlin/Int#
        recycler: RecyclerView.Recycler,
//      ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(recycler)
        state: RecyclerView.State
//      ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(state)
    ): View? = restoreView { super.onFocusSearchFailed(focused, focusDirection, recycler, state) }
//             ^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                           ^^^^^ reference kotlin/Any#
//                                                     ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focused)
//                                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focusDirection)
//                                                                              ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(recycler)
//                                                                                        ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(state)

    /**
     * Perform the [operation] without the sticky header view by
     * detaching the view -> performing operation -> detaching the view.
     */
    private fun <T> restoreView(operation: () -> T): T {
//               ^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                              ^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().(operation)
//                                               ^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
//                                                   ^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
        stickyHeader?.let(this::detachView)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                        ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
        val result = operation()
//          ^^^^^^ definition local5
//                   ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().(operation)
        stickyHeader?.let(this::attachView)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                        ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
        return result
//             ^^^^^^ reference local5
    }

    //endregion

    /**
     * Offsets the vertical location of the sticky header relative to the its default position.
     */
    fun setStickyHeaderTranslationY(translationY: Float) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().(translationY)
//                                                ^^^^^ reference kotlin/Float#
        this.translationY = translationY
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().(translationY)
        requestLayout()
    }

    /**
     * Offsets the horizontal location of the sticky header relative to the its default position.
     */
    fun setStickyHeaderTranslationX(translationX: Float) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().(translationX)
//                                                ^^^^^ reference kotlin/Float#
        this.translationX = translationX
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().(translationX)
        requestLayout()
    }

    /**
     * Returns true if `view` is the current sticky header.
     */
    fun isStickyHeader(view: View): Boolean = view === stickyHeader
//      ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().
//                     ^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().(view)
//                                  ^^^^^^^ reference kotlin/Boolean#
//                                            ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().(view)
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().

    /**
     * Updates the sticky header state (creation, binding, display), to be called whenever there's a layout or scroll
     */
    private fun updateStickyHeader(recycler: RecyclerView.Recycler, layout: Boolean) {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                                 ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                                                  ^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(layout)
//                                                                          ^^^^^^^ reference kotlin/Boolean#
        val headerCount = headerPositions.size
//          ^^^^^^^^^^^ definition local6
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                        ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                        ^^^^ reference kotlin/collections/MutableList#size.
//                                        ^^^^ reference kotlin/collections/MutableList#getSize().
        val childCount = childCount
//          ^^^^^^^^^^ definition local7
        if (headerCount > 0 && childCount > 0) {
//          ^^^^^^^^^^^ reference local6
//                      ^ reference kotlin/Int#compareTo(+3).
//                             ^^^^^^^^^^ reference local7
            // Find first valid child.
            var anchorView: View? = null
//              ^^^^^^^^^^ definition local8
            var anchorIndex = -1
//              ^^^^^^^^^^^ definition local9
//                            ^ reference kotlin/Int#unaryMinus().
            var anchorPos = -1
//              ^^^^^^^^^ definition local10
//                          ^ reference kotlin/Int#unaryMinus().
            for (i in 0 until childCount) {
//               ^ definition local11
//                      ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^^ reference local7
                val child = getChildAt(i)
//                  ^^^^^ definition local12
//                                     ^ reference local11
                val params = child!!.layoutParams as RecyclerView.LayoutParams
//                  ^^^^^^ definition local13
//                           ^^^^^ reference local12
                if (isViewValidAnchor(child, params)) {
//                  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().
//                                    ^^^^^ reference local12
//                                           ^^^^^^ reference local13
                    anchorView = child
//                  ^^^^^^^^^^ reference local8
//                               ^^^^^ reference local12
                    anchorIndex = i
//                  ^^^^^^^^^^^ reference local9
//                                ^ reference local11
                    anchorPos = params.viewAdapterPosition
//                  ^^^^^^^^^ reference local10
//                              ^^^^^^ reference local13
                    break
                }
            }
            if (anchorView != null && anchorPos != -1) {
//              ^^^^^^^^^^ reference local8
//                                    ^^^^^^^^^ reference local10
//                                              ^^ reference kotlin/Int#equals().
//                                                 ^ reference kotlin/Int#unaryMinus().
                val headerIndex = findHeaderIndexOrBefore(anchorPos)
//                  ^^^^^^^^^^^ definition local14
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                                        ^^^^^^^^^ reference local10
                val headerPos = if (headerIndex != -1) headerPositions[headerIndex] else -1
//                  ^^^^^^^^^ definition local15
//                                  ^^^^^^^^^^^ reference local14
//                                              ^^ reference kotlin/Int#equals().
//                                                 ^ reference kotlin/Int#unaryMinus().
//                                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                                     ^^^^^^^^^^^ reference local14
//                                                                                       ^ reference kotlin/Int#unaryMinus().
                val nextHeaderPos = if (headerCount > headerIndex + 1) headerPositions[headerIndex + 1] else -1
//                  ^^^^^^^^^^^^^ definition local16
//                                      ^^^^^^^^^^^ reference local6
//                                                  ^ reference kotlin/Int#compareTo(+3).
//                                                    ^^^^^^^^^^^ reference local14
//                                                                ^ reference kotlin/Int#plus(+3).
//                                                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                                     ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                                                     ^^^^^^^^^^^ reference local14
//                                                                                                 ^ reference kotlin/Int#plus(+3).
//                                                                                                           ^ reference kotlin/Int#unaryMinus().

                // Show sticky header if:
                // - There's one to show;
                // - It's on the edge or it's not the anchor view;
                // - Isn't followed by another sticky header;
                if (headerPos != -1 &&
//                  ^^^^^^^^^ reference local15
//                            ^^ reference kotlin/Int#equals().
//                               ^ reference kotlin/Int#unaryMinus().
                    (headerPos != anchorPos || isViewOnBoundary(anchorView)) &&
//                   ^^^^^^^^^ reference local15
//                             ^^ reference kotlin/Int#equals().
//                                ^^^^^^^^^ reference local10
//                                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().
//                                                              ^^^^^^^^^^ reference local8
                    nextHeaderPos != headerPos + 1
//                  ^^^^^^^^^^^^^ reference local16
//                                ^^ reference kotlin/Int#equals().
//                                   ^^^^^^^^^ reference local15
//                                             ^ reference kotlin/Int#plus(+3).
                ) {
                    // 1. Ensure existing sticky header, if any, is of correct type.
                    if (stickyHeader != null && getItemViewType(stickyHeader!!) != adapter?.getItemViewType(headerPos)) {
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                                                 ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                                                                                 ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                                                                                 ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                                                                          ^^^^^^^^^ reference local15
                        // A sticky header was shown before but is not of the correct type. Scrap it.
                        scrapStickyHeader(recycler)
//                      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                                        ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
                    }

                    // 2. Ensure sticky header is created, if absent, or bound, if being laid out or the position changed.
                    if (stickyHeader == null) createStickyHeader(recycler, headerPos)
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                            ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().
//                                                               ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                                                         ^^^^^^^^^ reference local15
                    // 3. Bind the sticky header
                    if (layout || getPosition(stickyHeader!!) != headerPos) bindStickyHeader(recycler, stickyHeader!!, headerPos)
//                      ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(layout)
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                               ^^^^^^^^^ reference local15
//                                                                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().
//                                                                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                                                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                                                                                     ^^^^^^^^^ reference local15

                    // 4. Draw the sticky header using translation values which depend on orientation, direction and
                    // position of the next header view.
                    stickyHeader?.let {
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
                        val nextHeaderView: View? = if (nextHeaderPos != -1) {
//                          ^^^^^^^^^^^^^^ definition local17
//                                                      ^^^^^^^^^^^^^ reference local16
//                                                                    ^^ reference kotlin/Int#equals().
//                                                                       ^ reference kotlin/Int#unaryMinus().
                            val nextHeaderView = getChildAt(anchorIndex + (nextHeaderPos - anchorPos))
//                              ^^^^^^^^^^^^^^ definition local18
//                                                          ^^^^^^^^^^^ reference local9
//                                                                      ^ reference kotlin/Int#plus(+3).
//                                                                         ^^^^^^^^^^^^^ reference local16
//                                                                                       ^ reference kotlin/Int#minus(+3).
//                                                                                         ^^^^^^^^^ reference local10
                            // The header view itself is added to the RecyclerView. Discard it if it comes up.
                            if (nextHeaderView === stickyHeader) null else nextHeaderView
//                              ^^^^^^^^^^^^^^ reference local18
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                                         ^^^^^^^^^^^^^^ reference local18
                        } else null
                        it.translationX = getX(it, nextHeaderView)
//                                        ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().
//                                                 ^^^^^^^^^^^^^^ reference local17
                        it.translationY = getY(it, nextHeaderView)
//                                        ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().
//                                                 ^^^^^^^^^^^^^^ reference local17
                    }
                    return
                }
            }
        }

        if (stickyHeader != null) {
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
            scrapStickyHeader(recycler)
//          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                            ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
        }
    }

    /**
     * Creates [RecyclerView.ViewHolder] for [position], including measure / layout, and assigns it to
     * [stickyHeader].
     */
    private fun createStickyHeader(recycler: RecyclerView.Recycler, position: Int) {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().
//                                 ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(recycler)
//                                                                  ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)
//                                                                            ^^^ reference kotlin/Int#
        val stickyHeader = recycler.getViewForPosition(position)
//          ^^^^^^^^^^^^ definition local19
//                         ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(recycler)
//                                                     ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)

        // Setup sticky header if the adapter requires it.
        adapter?.setupStickyHeaderView(stickyHeader)
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                     ^^^^^^^^^^^^ reference local19

        // Add sticky header as a child view, to be detached / reattached whenever LinearLayoutManager#fill() is called,
        // which happens on layout and scroll (see overrides).
        addView(stickyHeader)
//              ^^^^^^^^^^^^ reference local19
        measureAndLayout(stickyHeader)
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                       ^^^^^^^^^^^^ reference local19

        // Ignore sticky header, as it's fully managed by this LayoutManager.
        ignoreView(stickyHeader)
//                 ^^^^^^^^^^^^ reference local19

        this.stickyHeader = stickyHeader
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                          ^^^^^^^^^^^^ reference local19
        this.stickyHeaderPosition = position
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                                  ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)
    }

    /**
     * Binds the [stickyHeader] for the given [position].
     */
    private fun bindStickyHeader(recycler: RecyclerView.Recycler, stickyHeader: View, position: Int) {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().
//                               ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(recycler)
//                                                                ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                                    ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
//                                                                                              ^^^ reference kotlin/Int#
        // Bind the sticky header.
        recycler.bindViewToPosition(stickyHeader, position)
//      ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(recycler)
//                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
        stickyHeaderPosition = position
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                             ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
        measureAndLayout(stickyHeader)
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)

        // If we have a pending scroll wait until the end of layout and scroll again.
        if (scrollPosition != RecyclerView.NO_POSITION) {
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
            stickyHeader.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
                override fun onGlobalLayout() {
//                           ^^^^^^^^^^^^^^ definition local20
                    if (Build.VERSION.SDK_INT < 16) stickyHeader.viewTreeObserver.removeGlobalOnLayoutListener(this)
//                                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                                                             ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().`<no name provided>`#
                    else stickyHeader.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                                  ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().`<no name provided>`#
                    if (scrollPosition != RecyclerView.NO_POSITION) {
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
                        scrollToPositionWithOffset(scrollPosition, scrollOffset)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                                                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                                                 ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//                                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//                                                                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
                        setScrollState(RecyclerView.NO_POSITION, INVALID_OFFSET)
//                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
                    }
                }
            })
        }
    }

    /**
     * Measures and lays out [stickyHeader].
     */
    private fun measureAndLayout(stickyHeader: View) {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                               ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
        measureChildWithMargins(stickyHeader, 0, 0)
//                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
        when (orientation) {
            VERTICAL -> stickyHeader.layout(paddingLeft, 0, width - paddingRight, stickyHeader.measuredHeight)
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
//                                                                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
            else -> stickyHeader.layout(0, paddingTop, stickyHeader.measuredWidth, height - paddingBottom)
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
        }
    }

    /**
     * Returns [stickyHeader] to the [RecyclerView]'s [RecyclerView.RecycledViewPool], assigning it
     * to `null`.
     *
     * @param recycler If passed, the sticky header will be returned to the recycled view pool.
     */
    private fun scrapStickyHeader(recycler: RecyclerView.Recycler?) {
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                                ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().(recycler)
        val stickyHeader = stickyHeader ?: return
//          ^^^^^^^^^^^^ definition local21
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
        this.stickyHeader = null
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
        this.stickyHeaderPosition = RecyclerView.NO_POSITION
//      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().

        // Revert translation values.
        stickyHeader.translationX = 0f
//      ^^^^^^^^^^^^ reference local21
        stickyHeader.translationY = 0f
//      ^^^^^^^^^^^^ reference local21

        // Teardown holder if the adapter requires it.
        adapter?.teardownStickyHeaderView(stickyHeader)
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                        ^^^^^^^^^^^^ reference local21

        // Stop ignoring sticky header so that it can be recycled.
        stopIgnoringView(stickyHeader)
//                       ^^^^^^^^^^^^ reference local21

        // Remove and recycle sticky header.
        removeView(stickyHeader)
//                 ^^^^^^^^^^^^ reference local21
        recycler?.recycleView(stickyHeader)
//      ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().(recycler)
//                            ^^^^^^^^^^^^ reference local21
    }

    /**
     * Returns true when `view` is a valid anchor, ie. the first view to be valid and visible.
     */
    private fun isViewValidAnchor(view: View, params: RecyclerView.LayoutParams): Boolean {
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().
//                                ^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                            ^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
//                                                                                ^^^^^^^ reference kotlin/Boolean#
        return when {
            !params.isItemRemoved && !params.isViewInvalid -> when (orientation) {
//           ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
//                                    ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
                VERTICAL -> when {
                    reverseLayout -> view.top + view.translationY <= height + translationY
//                                   ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                              ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
                    else -> view.bottom - view.translationY >= translationY
//                          ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                        ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                                                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
                }
                else -> when {
                    reverseLayout -> view.left + view.translationX <= width + translationX
//                                   ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                               ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
                    else -> view.right - view.translationX >= translationX
//                          ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                       ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
                }
            }
            else -> false
        }
    }

    /**
     * Returns true when the `view` is at the edge of the parent [RecyclerView].
     */
    private fun isViewOnBoundary(view: View): Boolean {
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().
//                               ^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                            ^^^^^^^ reference kotlin/Boolean#
        return when (orientation) {
            VERTICAL -> when {
                reverseLayout -> view.bottom - view.translationY > height + translationY
//                               ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                             ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
                else -> view.top + view.translationY < translationY
//                      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                 ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
            }
            else -> when {
                reverseLayout -> view.right - view.translationX > width + translationX
//                               ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                            ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
                else -> view.left + view.translationX < translationX
//                      ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                  ^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
            }
        }
    }

    /**
     * Returns the position in the Y axis to position the header appropriately, depending on orientation, direction and
     * [android.R.attr.clipToPadding].
     */
    private fun getY(headerView: View, nextHeaderView: View?): Float {
//              ^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().
//                   ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
//                                     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                             ^^^^^ reference kotlin/Float#
        when (orientation) {
            VERTICAL -> {
                var y = translationY
//                  ^ definition local22
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
                if (reverseLayout) {
                    y += (height - headerView.height).toFloat()
//                  ^ reference local22
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
                }
                if (nextHeaderView != null) {
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    val bottomMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin ?: 0
//                      ^^^^^^^^^^^^ definition local23
//                                      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    val topMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin ?: 0
//                      ^^^^^^^^^ definition local24
//                                   ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    y = when {
//                  ^ reference local22
                        reverseLayout -> (nextHeaderView.bottom + bottomMargin).toFloat().coerceAtLeast(y)
//                                        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                                ^^^^^^^^^^^^ reference local23
//                                                                                                      ^ reference local22
                        else -> (nextHeaderView.top - topMargin - headerView.height).toFloat().coerceAtMost(y)
//                               ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                    ^^^^^^^^^ reference local24
//                                                                ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
//                                                                                                          ^ reference local22
                    }
                }
                return y
//                     ^ reference local22
            }
            else -> return translationY
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
        }
    }

    /**
     * Returns the position in the X axis to position the header appropriately, depending on orientation, direction and
     * [android.R.attr.clipToPadding].
     */
    private fun getX(headerView: View, nextHeaderView: View?): Float {
//              ^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().
//                   ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
//                                     ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                             ^^^^^ reference kotlin/Float#
        when (orientation) {
            HORIZONTAL -> {
                var x = translationX
//                  ^ definition local25
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
                if (reverseLayout) {
                    x += (width - headerView.width).toFloat()
//                  ^ reference local25
//                                ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
                }
                if (nextHeaderView != null) {
//                  ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    val leftMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin ?: 0
//                      ^^^^^^^^^^ definition local26
//                                    ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    val rightMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin ?: 0
//                      ^^^^^^^^^^^ definition local27
//                                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    x = when {
//                  ^ reference local25
                        reverseLayout -> (nextHeaderView.right + rightMargin).toFloat().coerceAtLeast(x)
//                                        ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                               ^^^^^^^^^^^ reference local27
//                                                                                                    ^ reference local25
                        else -> (nextHeaderView.left - leftMargin - headerView.width).toFloat().coerceAtMost(x)
//                               ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                     ^^^^^^^^^^ reference local26
//                                                                  ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
//                                                                                                           ^ reference local25
                    }
                }
                return x
//                     ^ reference local25
            }
            else -> return translationX
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
        }
    }

    /**
     * Finds the header index of `position` in `headerPositions`.
     */
    private fun findHeaderIndex(position: Int): Int {
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                              ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                        ^^^ reference kotlin/Int#
//                                              ^^^ reference kotlin/Int#
        var low = 0
//          ^^^ definition local28
        var high = headerPositions.size - 1
//          ^^^^ definition local29
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                 ^^^^ reference kotlin/collections/MutableList#size.
//                                 ^^^^ reference kotlin/collections/MutableList#getSize().
//                                      ^ reference kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local28
//                 ^^ reference kotlin/Int#compareTo(+3).
//                    ^^^^ reference local29
            val middle = (low + high) / 2
//              ^^^^^^ definition local30
//                        ^^^ reference local28
//                            ^ reference kotlin/Int#plus(+3).
//                              ^^^^ reference local29
//                                    ^ reference kotlin/Int#div(+3).
            when {
                headerPositions[middle] > position -> high = middle - 1
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^ reference local30
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                                    ^^^^ reference local29
//                                                           ^^^^^^ reference local30
//                                                                  ^ reference kotlin/Int#minus(+3).
                headerPositions[middle] < position -> low = middle + 1
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^ reference local30
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                                    ^^^ reference local28
//                                                          ^^^^^^ reference local30
//                                                                 ^ reference kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local30
            }
        }
        return -1
//             ^ reference kotlin/Int#unaryMinus().
    }

    /**
     * Finds the header index of `position` or the one before it in `headerPositions`.
     */
    private fun findHeaderIndexOrBefore(position: Int): Int {
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                      ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                                ^^^ reference kotlin/Int#
//                                                      ^^^ reference kotlin/Int#
        var low = 0
//          ^^^ definition local31
        var high = headerPositions.size - 1
//          ^^^^ definition local32
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                 ^^^^ reference kotlin/collections/MutableList#size.
//                                 ^^^^ reference kotlin/collections/MutableList#getSize().
//                                      ^ reference kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local31
//                 ^^ reference kotlin/Int#compareTo(+3).
//                    ^^^^ reference local32
            val middle = (low + high) / 2
//              ^^^^^^ definition local33
//                        ^^^ reference local31
//                            ^ reference kotlin/Int#plus(+3).
//                              ^^^^ reference local32
//                                    ^ reference kotlin/Int#div(+3).
            when {
                headerPositions[middle] > position -> high = middle - 1
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^ reference local33
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                                    ^^^^ reference local32
//                                                           ^^^^^^ reference local33
//                                                                  ^ reference kotlin/Int#minus(+3).
                middle < headerPositions.size - 1 && headerPositions[middle + 1] <= position -> low = middle + 1
//              ^^^^^^ reference local33
//                     ^ reference kotlin/Int#compareTo(+3).
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                       ^^^^ reference kotlin/collections/MutableList#size.
//                                       ^^^^ reference kotlin/collections/MutableList#getSize().
//                                            ^ reference kotlin/Int#minus(+3).
//                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                   ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                                   ^^^^^^ reference local33
//                                                                          ^ reference kotlin/Int#plus(+3).
//                                                                               ^^ reference kotlin/Int#compareTo(+3).
//                                                                                  ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                                                                              ^^^ reference local31
//                                                                                                    ^^^^^^ reference local33
//                                                                                                           ^ reference kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local33
            }
        }
        return -1
//             ^ reference kotlin/Int#unaryMinus().
    }

    /**
     * Finds the header index of `position` or the one next to it in `headerPositions`.
     */
    private fun findHeaderIndexOrNext(position: Int): Int {
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                    ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                              ^^^ reference kotlin/Int#
//                                                    ^^^ reference kotlin/Int#
        var low = 0
//          ^^^ definition local34
        var high = headerPositions.size - 1
//          ^^^^ definition local35
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                 ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                 ^^^^ reference kotlin/collections/MutableList#size.
//                                 ^^^^ reference kotlin/collections/MutableList#getSize().
//                                      ^ reference kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local34
//                 ^^ reference kotlin/Int#compareTo(+3).
//                    ^^^^ reference local35
            val middle = (low + high) / 2
//              ^^^^^^ definition local36
//                        ^^^ reference local34
//                            ^ reference kotlin/Int#plus(+3).
//                              ^^^^ reference local35
//                                    ^ reference kotlin/Int#div(+3).
            when {
                middle > 0 && headerPositions[middle - 1] >= position -> high = middle - 1
//              ^^^^^^ reference local36
//                     ^ reference kotlin/Int#compareTo(+3).
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                            ^^^^^^ reference local36
//                                                   ^ reference kotlin/Int#minus(+3).
//                                                        ^^ reference kotlin/Int#compareTo(+3).
//                                                           ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                                                       ^^^^ reference local35
//                                                                              ^^^^^^ reference local36
//                                                                                     ^ reference kotlin/Int#minus(+3).
                headerPositions[middle] < position -> low = middle + 1
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^ reference local36
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                                    ^^^ reference local34
//                                                          ^^^^^^ reference local36
//                                                                 ^ reference kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local36
            }
        }
        return -1
//             ^ reference kotlin/Int#unaryMinus().
    }

    private fun setScrollState(position: Int, offset: Int) {
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
//                             ^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(position)
//                                       ^^^ reference kotlin/Int#
//                                            ^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(offset)
//                                                    ^^^ reference kotlin/Int#
        scrollPosition = position
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                       ^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(position)
        scrollOffset = offset
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
//                     ^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(offset)
    }

    /**
     * Save / restore existing [RecyclerView] state and
     * scrolling position and offset.
     */
    @Parcelize
//   ^^^^^^^^^ reference kotlinx/android/parcel/Parcelize#`<init>`().
    data class SavedState(
//             ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#
//             ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().
        val superState: Parcelable?,
//          ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#superState.
//          ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getSuperState().
//          ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(superState)
        val scrollPosition: Int,
//          ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollPosition.
//          ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollPosition().
//          ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollPosition)
//                          ^^^ reference kotlin/Int#
        val scrollOffset: Int
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollOffset.
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollOffset().
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollOffset)
//                        ^^^ reference kotlin/Int#
    ) : Parcelable

    /**
     * Handles header positions while adapter changes occur.
     *
     * This is used in detriment of [RecyclerView.LayoutManager]'s callbacks to control when they're received.
     */
    private inner class HeaderPositionsAdapterDataObserver : RecyclerView.AdapterDataObserver() {
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#`<init>`().
        override fun onChanged() {
//                   ^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onChanged().
            // There's no hint at what changed, so go through the adapter.
            headerPositions.clear()
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                          ^^^^^ reference kotlin/collections/MutableList#clear().
            val itemCount = adapter?.itemCount ?: 0
//              ^^^^^^^^^ definition local37
//                          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                          ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
            for (i in 0 until itemCount) {
//               ^ definition local38
//                      ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^ reference local37
                val isSticky = adapter?.isStickyHeader(i) ?: false
//                  ^^^^^^^^ definition local39
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                     ^ reference local38
                if (isSticky) {
//                  ^^^^^^^^ reference local39
                    headerPositions.add(i)
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                  ^^^ reference kotlin/collections/MutableList#add().
//                                      ^ reference local38
                }
            }

            // Remove sticky header immediately if the entry it represents has been removed. A layout will follow.
            if (stickyHeader != null && !headerPositions.contains(stickyHeaderPosition)) {
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                      ^ reference kotlin/Boolean#not().
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                       ^^^^^^^^ reference kotlin/collections/MutableList#contains().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
                scrapStickyHeader(null)
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
            }
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().
//                                       ^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                                      ^^^ reference kotlin/Int#
//                                                           ^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
//                                                                      ^^^ reference kotlin/Int#
            // Shift headers below down.
            val headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local40
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                            ^^^^ reference kotlin/collections/MutableList#size.
//                                            ^^^^ reference kotlin/collections/MutableList#getSize().
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local40
//                          ^ reference kotlin/Int#compareTo(+3).
                var i = findHeaderIndexOrNext(positionStart)
//                  ^ definition local41
//                      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
                while (i != -1 && i < headerCount) {
//                     ^ reference local41
//                       ^^ reference kotlin/Int#equals().
//                          ^ reference kotlin/Int#unaryMinus().
//                                ^ reference local41
//                                  ^ reference kotlin/Int#compareTo(+3).
//                                    ^^^^^^^^^^^ reference local40
                    headerPositions[i] = headerPositions[i] + itemCount
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                  ^ reference local41
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                       ^ reference local41
//                                                          ^ reference kotlin/Int#plus(+3).
//                                                            ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
                    i++
//                  ^ reference local41
//                   ^^ reference kotlin/Int#inc().
                }
            }

            // Add new headers.
            for (i in positionStart until positionStart + itemCount) {
//               ^ definition local42
//                    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                                      ^ reference kotlin/Int#plus(+3).
//                                                        ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
                val isSticky = adapter?.isStickyHeader(i) ?: false
//                  ^^^^^^^^ definition local43
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                             ^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                     ^ reference local42
                if (isSticky) {
//                  ^^^^^^^^ reference local43
                    val headerIndex = findHeaderIndexOrNext(i)
//                      ^^^^^^^^^^^ definition local44
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                          ^ reference local42
                    if (headerIndex != -1) {
//                      ^^^^^^^^^^^ reference local44
//                                  ^^ reference kotlin/Int#equals().
//                                     ^ reference kotlin/Int#unaryMinus().
                        headerPositions.add(headerIndex, i)
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                      ^^^ reference kotlin/collections/MutableList#add(+1).
//                                          ^^^^^^^^^^^ reference local44
//                                                       ^ reference local42
                    } else {
                        headerPositions.add(i)
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                      ^^^ reference kotlin/collections/MutableList#add().
//                                          ^ reference local42
                    }
                }
            }
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().
//                                      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                                     ^^^ reference kotlin/Int#
//                                                          ^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
//                                                                     ^^^ reference kotlin/Int#
            var headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local45
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                            ^^^^ reference kotlin/collections/MutableList#size.
//                                            ^^^^ reference kotlin/collections/MutableList#getSize().
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local45
//                          ^ reference kotlin/Int#compareTo(+3).
                // Remove headers.
                for (i in positionStart + itemCount - 1 downTo positionStart) {
//                   ^ definition local46
//                        ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                      ^ reference kotlin/Int#plus(+3).
//                                        ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
//                                                  ^ reference kotlin/Int#minus(+3).
//                                                      ^^^^^^ reference kotlin/ranges/RangesKt#downTo(+6).
//                                                             ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
                    val index = findHeaderIndex(i)
//                      ^^^^^ definition local47
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                              ^ reference local46
                    if (index != -1) {
//                      ^^^^^ reference local47
//                            ^^ reference kotlin/Int#equals().
//                               ^ reference kotlin/Int#unaryMinus().
                        headerPositions.removeAt(index)
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                      ^^^^^^^^ reference kotlin/collections/MutableList#removeAt().
//                                               ^^^^^ reference local47
                        headerCount--
//                      ^^^^^^^^^^^ reference local45
//                                 ^^ reference kotlin/Int#dec().
                    }
                }

                // Remove sticky header immediately if the entry it represents has been removed. A layout will follow.
                if (stickyHeader != null && !headerPositions.contains(stickyHeaderPosition)) {
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                          ^ reference kotlin/Boolean#not().
//                                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                           ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                           ^^^^^^^^ reference kotlin/collections/MutableList#contains().
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
                    scrapStickyHeader(null)
//                  ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
                }

                // Shift headers below up.
                var i = findHeaderIndexOrNext(positionStart + itemCount)
//                  ^ definition local48
//                      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                            ^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                                          ^ reference kotlin/Int#plus(+3).
//                                                            ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
                while (i != -1 && i < headerCount) {
//                     ^ reference local48
//                       ^^ reference kotlin/Int#equals().
//                          ^ reference kotlin/Int#unaryMinus().
//                                ^ reference local48
//                                  ^ reference kotlin/Int#compareTo(+3).
//                                    ^^^^^^^^^^^ reference local45
                    headerPositions[i] = headerPositions[i] - itemCount
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                  ^ reference local48
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                       ^ reference local48
//                                                          ^ reference kotlin/Int#minus(+3).
//                                                            ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
                    i++
//                  ^ reference local48
//                   ^^ reference kotlin/Int#inc().
                }
            }
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().
//                                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                  ^^^ reference kotlin/Int#
//                                                       ^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                   ^^^ reference kotlin/Int#
//                                                                        ^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
//                                                                                   ^^^ reference kotlin/Int#
            // Shift moved headers by toPosition - fromPosition.
            // Shift headers in-between by -itemCount (reverse if upwards).
            val headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local49
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                            ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                            ^^^^ reference kotlin/collections/MutableList#size.
//                                            ^^^^ reference kotlin/collections/MutableList#getSize().
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local49
//                          ^ reference kotlin/Int#compareTo(+3).
                if (fromPosition < toPosition) {
//                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                               ^ reference kotlin/Int#compareTo(+3).
//                                 ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                    var i = findHeaderIndexOrNext(fromPosition)
//                      ^ definition local50
//                          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                    while (i != -1 && i < headerCount) {
//                         ^ reference local50
//                           ^^ reference kotlin/Int#equals().
//                              ^ reference kotlin/Int#unaryMinus().
//                                    ^ reference local50
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^^ reference local49
                        val headerPos = headerPositions[i]
//                          ^^^^^^^^^ definition local51
//                                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                      ^ reference local50
                        if (headerPos >= fromPosition && headerPos < fromPosition + itemCount) {
//                          ^^^^^^^^^ reference local51
//                                    ^^ reference kotlin/Int#compareTo(+3).
//                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                       ^^^^^^^^^ reference local51
//                                                                 ^ reference kotlin/Int#compareTo(+3).
//                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                                                ^ reference kotlin/Int#plus(+3).
//                                                                                  ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                            headerPositions[i] = headerPos - (toPosition - fromPosition)
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                          ^ reference local50
//                                               ^^^^^^^^^ reference local51
//                                                         ^ reference kotlin/Int#minus(+3).
//                                                            ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                       ^ reference kotlin/Int#minus(+3).
//                                                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                            sortHeaderAtIndex(i)
//                          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                            ^ reference local50
                        } else if (headerPos >= fromPosition + itemCount && headerPos <= toPosition) {
//                                 ^^^^^^^^^ reference local51
//                                           ^^ reference kotlin/Int#compareTo(+3).
//                                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                           ^ reference kotlin/Int#plus(+3).
//                                                             ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
//                                                                          ^^^^^^^^^ reference local51
//                                                                                    ^^ reference kotlin/Int#compareTo(+3).
//                                                                                       ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                            headerPositions[i] = headerPos - itemCount
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                          ^ reference local50
//                                               ^^^^^^^^^ reference local51
//                                                         ^ reference kotlin/Int#minus(+3).
//                                                           ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                            sortHeaderAtIndex(i)
//                          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                            ^ reference local50
                        } else {
                            break
                        }
                        i++
//                      ^ reference local50
//                       ^^ reference kotlin/Int#inc().
                    }
                } else {
                    var i = findHeaderIndexOrNext(toPosition)
//                      ^ definition local52
//                          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                    loop@ while (i != -1 && i < headerCount) {
//                               ^ reference local52
//                                 ^^ reference kotlin/Int#equals().
//                                    ^ reference kotlin/Int#unaryMinus().
//                                          ^ reference local52
//                                            ^ reference kotlin/Int#compareTo(+3).
//                                              ^^^^^^^^^^^ reference local49
                        val headerPos = headerPositions[i]
//                          ^^^^^^^^^ definition local53
//                                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                      ^ reference local52
                        when {
                            headerPos >= fromPosition && headerPos < fromPosition + itemCount -> {
//                          ^^^^^^^^^ reference local53
//                                    ^^ reference kotlin/Int#compareTo(+3).
//                                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                       ^^^^^^^^^ reference local53
//                                                                 ^ reference kotlin/Int#compareTo(+3).
//                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                                                ^ reference kotlin/Int#plus(+3).
//                                                                                  ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                                headerPositions[i] = headerPos + (toPosition - fromPosition)
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                              ^ reference local52
//                                                   ^^^^^^^^^ reference local53
//                                                             ^ reference kotlin/Int#plus(+3).
//                                                                ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                           ^ reference kotlin/Int#minus(+3).
//                                                                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                                sortHeaderAtIndex(i)
//                              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                                ^ reference local52
                            }
                            headerPos in toPosition..fromPosition -> {
//                          ^^^^^^^^^ reference local53
//                                    ^^ reference kotlin/ranges/IntRange#contains().
//                                       ^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                 ^^ reference kotlin/Int#rangeTo(+1).
//                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                                headerPositions[i] = headerPos + itemCount
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                              ^ reference local52
//                                                   ^^^^^^^^^ reference local53
//                                                             ^ reference kotlin/Int#plus(+3).
//                                                               ^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                                sortHeaderAtIndex(i)
//                              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                                ^ reference local52
                            }
                            else -> break@loop
                        }
                        i++
//                      ^ reference local52
//                       ^^ reference kotlin/Int#inc().
                    }
                }
            }
        }

        private fun sortHeaderAtIndex(index: Int) {
//                  ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                    ^^^^^ definition com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().(index)
//                                           ^^^ reference kotlin/Int#
            val headerPos = headerPositions.removeAt(index)
//              ^^^^^^^^^ definition local54
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                          ^^^^^^^^ reference kotlin/collections/MutableList#removeAt().
//                                                   ^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().(index)
            val headerIndex = findHeaderIndexOrNext(headerPos)
//              ^^^^^^^^^^^ definition local55
//                            ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                  ^^^^^^^^^ reference local54
            if (headerIndex != -1) {
//              ^^^^^^^^^^^ reference local55
//                          ^^ reference kotlin/Int#equals().
//                             ^ reference kotlin/Int#unaryMinus().
                headerPositions.add(headerIndex, headerPos)
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^ reference kotlin/collections/MutableList#add(+1).
//                                  ^^^^^^^^^^^ reference local55
//                                               ^^^^^^^^^ reference local54
            } else {
                headerPositions.add(headerPos)
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^ reference kotlin/collections/MutableList#add().
//                                  ^^^^^^^^^ reference local54
            }
        }
    }
}
