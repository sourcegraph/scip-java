package com.airbnb.epoxy.stickyheader
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/

import android.content.Context
import android.graphics.PointF
import android.os.Build
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.LinearLayoutManager
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import kotlinx.android.parcel.Parcelize
//     ^^^^^^^ reference semanticdb maven . . kotlinx/
//             ^^^^^^^ reference semanticdb maven . . kotlinx/android/
//                     ^^^^^^ reference semanticdb maven . . kotlinx/android/parcel/
//                            ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-parcelize-runtime 1.4.20-RC kotlinx/android/parcel/Parcelize#

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
//    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//                                    display_name StickyHeaderLinearLayoutManager
//                                    documentation ```kt\npublic final class StickyHeaderLinearLayoutManager\n```\n\n----\n\n\n Adds sticky headers capabilities to your [RecyclerView.Adapter].\n The adapter / controller must override [StickyHeaderCallbacks.isStickyHeader] to\n indicate which items are sticky.\n\n Example usage:\n ```\n  class StickyHeaderController() : EpoxyController() {\n      override fun isStickyHeader(position: Int) {\n          // Write your logic to tell which item is sticky.\n      }\n  }\n ```\n
//                                     ^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/jvm/JvmOverloads#`<init>`().
//                                                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().
//                                                              display_name StickyHeaderLinearLayoutManager
//                                                              documentation ```kt\npublic constructor StickyHeaderLinearLayoutManager(context: [Error type: Unresolved type for Context], orientation: kotlin.Int = ..., reverseLayout: kotlin.Boolean = ...)\n```
    context: Context,
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(context)
//          display_name context
//          documentation ```kt\nvalue-parameter context: [Error type: Unresolved type for Context]\n```
    orientation: Int = RecyclerView.VERTICAL,
//  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(orientation)
//              display_name orientation
//              documentation ```kt\nvalue-parameter orientation: kotlin.Int = ...\n```
//               ^^^ reference semanticdb maven . . kotlin/Int#
    reverseLayout: Boolean = false
//  ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(reverseLayout)
//                display_name reverseLayout
//                documentation ```kt\nvalue-parameter reverseLayout: kotlin.Boolean = ...\n```
//                 ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
) : LinearLayoutManager(context, orientation, reverseLayout) {
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(context)
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(orientation)
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#`<init>`().(reverseLayout)

    private var adapter: BaseEpoxyAdapter? = null
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                      display_name adapter
//                      documentation ```kt\nprivate final var adapter: [Error type: Unresolved type for BaseEpoxyAdapter]?\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                      display_name adapter
//                      documentation ```kt\nprivate final var adapter: [Error type: Unresolved type for BaseEpoxyAdapter]?\n```
//              ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                      display_name setAdapter
//                      documentation ```kt\nprivate final fun setAdapter(newAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?)\n```

    // Translation for header
    private var translationX: Float = 0f
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                           display_name translationX
//                           documentation ```kt\nprivate final var translationX: kotlin.Float\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                           display_name translationX
//                           documentation ```kt\nprivate final var translationX: kotlin.Float\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                           display_name translationX
//                           documentation ```kt\nprivate final var translationX: kotlin.Float\n```
//                            ^^^^^ reference semanticdb maven . . kotlin/Float#
    private var translationY: Float = 0f
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                           display_name translationY
//                           documentation ```kt\nprivate final var translationY: kotlin.Float\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                           display_name translationY
//                           documentation ```kt\nprivate final var translationY: kotlin.Float\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                           display_name translationY
//                           documentation ```kt\nprivate final var translationY: kotlin.Float\n```
//                            ^^^^^ reference semanticdb maven . . kotlin/Float#

    // Header positions for the currently displayed list and their observer.
    private val headerPositions = mutableListOf<Int>()
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              display_name headerPositions
//                              documentation ```kt\nprivate final val headerPositions: kotlin.collections.MutableList<kotlin.Int>\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              display_name headerPositions
//                              documentation ```kt\nprivate final val headerPositions: kotlin.collections.MutableList<kotlin.Int>\n```
//                                ^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#mutableListOf().
//                                              ^^^ reference semanticdb maven . . kotlin/Int#
    private val headerPositionsObserver = HeaderPositionsAdapterDataObserver()
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//                                      display_name headerPositionsObserver
//                                      documentation ```kt\nprivate final val headerPositionsObserver: com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager.HeaderPositionsAdapterDataObserver\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//                                      display_name headerPositionsObserver
//                                      documentation ```kt\nprivate final val headerPositionsObserver: com.airbnb.epoxy.stickyheader.StickyHeaderLinearLayoutManager.HeaderPositionsAdapterDataObserver\n```
//                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#`<init>`().

    // Sticky header's ViewHolder and dirty state.
    private var stickyHeader: View? = null
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                           display_name stickyHeader
//                           documentation ```kt\nprivate final var stickyHeader: [Error type: Unresolved type for View]?\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                           display_name stickyHeader
//                           documentation ```kt\nprivate final var stickyHeader: [Error type: Unresolved type for View]?\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                           display_name stickyHeader
//                           documentation ```kt\nprivate final var stickyHeader: [Error type: Unresolved type for View]?\n```
    private var stickyHeaderPosition = RecyclerView.NO_POSITION
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                   display_name stickyHeaderPosition
//                                   documentation ```kt\nprivate final var stickyHeaderPosition: [Error type: Error property type]\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                                   display_name stickyHeaderPosition
//                                   documentation ```kt\nprivate final var stickyHeaderPosition: [Error type: Error property type]\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                                   display_name stickyHeaderPosition
//                                   documentation ```kt\nprivate final var stickyHeaderPosition: [Error type: Error property type]\n```

    // Save / Restore scroll state
    private var scrollPosition = RecyclerView.NO_POSITION
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                             display_name scrollPosition
//                             documentation ```kt\nprivate final var scrollPosition: [Error type: Error property type]\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                             display_name scrollPosition
//                             documentation ```kt\nprivate final var scrollPosition: [Error type: Error property type]\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                             display_name scrollPosition
//                             documentation ```kt\nprivate final var scrollPosition: [Error type: Error property type]\n```
    private var scrollOffset = 0
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//                           display_name scrollOffset
//                           documentation ```kt\nprivate final var scrollOffset: kotlin.Int\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//                           display_name scrollOffset
//                           documentation ```kt\nprivate final var scrollOffset: kotlin.Int\n```
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
//                           display_name scrollOffset
//                           documentation ```kt\nprivate final var scrollOffset: kotlin.Int\n```

    override fun onAttachedToWindow(recyclerView: RecyclerView) {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().
//                                  display_name onAttachedToWindow
//                                  documentation ```kt\npublic open fun onAttachedToWindow(recyclerView: [Error type: Unresolved type for RecyclerView])\n```
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
//                                               display_name recyclerView
//                                               documentation ```kt\nvalue-parameter recyclerView: [Error type: Unresolved type for RecyclerView]\n```
        super.onAttachedToWindow(recyclerView)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
        setAdapter(recyclerView.adapter)
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAttachedToWindow().(recyclerView)
    }

    override fun onAdapterChanged(oldAdapter: RecyclerView.Adapter<*>?, newAdapter: RecyclerView.Adapter<*>?) {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().
//                                display_name onAdapterChanged
//                                documentation ```kt\npublic open fun onAdapterChanged(oldAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?, newAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?)\n```
//                                ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(oldAdapter)
//                                           display_name oldAdapter
//                                           documentation ```kt\nvalue-parameter oldAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?\n```
//                                                                      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
//                                                                                 display_name newAdapter
//                                                                                 documentation ```kt\nvalue-parameter newAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?\n```
        super.onAdapterChanged(oldAdapter, newAdapter)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(oldAdapter)
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
        setAdapter(newAdapter)
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onAdapterChanged().(newAdapter)
    }

    @Suppress("UNCHECKED_CAST")
//   ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
    private fun setAdapter(newAdapter: RecyclerView.Adapter<*>?) {
//              ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                         display_name setAdapter
//                         documentation ```kt\nprivate final fun setAdapter(newAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?)\n```
//                         ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
//                                    display_name newAdapter
//                                    documentation ```kt\nvalue-parameter newAdapter: [Error type: Unresolved type for RecyclerView.Adapter<*>]<out [Error type: Error type projection]>?\n```
        adapter?.unregisterAdapterDataObserver(headerPositionsObserver)
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//                                             ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
        if (newAdapter is BaseEpoxyAdapter) {
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
            adapter = newAdapter
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().(newAdapter)
            adapter?.registerAdapterDataObserver(headerPositionsObserver)
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//                                               ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
            headerPositionsObserver.onChanged()
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositionsObserver().
//          ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositionsObserver.
//                                  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onChanged().
        } else {
            adapter = null
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
            headerPositions.clear()
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                          ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
        }
    }

    override fun onSaveInstanceState(): Parcelable {
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onSaveInstanceState().
//                                   display_name onSaveInstanceState
//                                   documentation ```kt\npublic open fun onSaveInstanceState(): [Error type: Unresolved type for Parcelable]\n```
        return SavedState(
//             ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().
            superState = super.onSaveInstanceState(),
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(superState)
//                       ^^^^^ reference semanticdb maven . . kotlin/Any#
            scrollPosition = scrollPosition,
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollPosition)
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                           ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
            scrollOffset = scrollOffset
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollOffset)
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
        )
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
//               ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().
//                                      display_name onRestoreInstanceState
//                                      documentation ```kt\npublic open fun onRestoreInstanceState(state: [Error type: Unresolved type for Parcelable]?)\n```
//                                      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().(state)
//                                            display_name state
//                                            documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for Parcelable]?\n```
        (state as? SavedState)?.let {
//       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onRestoreInstanceState().(state)
//                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#
//                              ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#let().
            scrollPosition = it.scrollPosition
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                           ^^ reference local 0
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollPosition().
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollPosition.
            scrollOffset = it.scrollOffset
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
//                         ^^ reference local 0
//                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollOffset().
//                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollOffset.
            super.onRestoreInstanceState(it.superState)
//          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                       ^^ reference local 0
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getSuperState().
//                                          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#superState.
        }
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State?): Int {
//               ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().
//                                  display_name scrollVerticallyBy
//                                  documentation ```kt\npublic open fun scrollVerticallyBy(dy: kotlin.Int, recycler: [Error type: Unresolved type for RecyclerView.Recycler], state: [Error type: Unresolved type for RecyclerView.State]?): kotlin.Int\n```
//                                  ^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(dy)
//                                     display_name dy
//                                     documentation ```kt\nvalue-parameter dy: kotlin.Int\n```
//                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                           ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
//                                                    display_name recycler
//                                                    documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(state)
//                                                                                  display_name state
//                                                                                  documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]?\n```
//                                                                                                         ^^^ reference semanticdb maven . . kotlin/Int#
        val scrolled = restoreView { super.scrollVerticallyBy(dy, recycler, state) }
//          ^^^^^^^^ definition local 1
//                   display_name scrolled
//                   documentation ```kt\nval scrolled: kotlin.Unit\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                   ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                            ^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(dy)
//                                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
//                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(state)
        if (scrolled != 0) {
//          ^^^^^^^^ reference local 1
//                   ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#equals().
            updateStickyHeader(recycler, false)
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollVerticallyBy().(recycler)
        }
        return scrolled
//             ^^^^^^^^ reference local 1
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State?): Int {
//               ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().
//                                    display_name scrollHorizontallyBy
//                                    documentation ```kt\npublic open fun scrollHorizontallyBy(dx: kotlin.Int, recycler: [Error type: Unresolved type for RecyclerView.Recycler], state: [Error type: Unresolved type for RecyclerView.State]?): kotlin.Int\n```
//                                    ^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(dx)
//                                       display_name dx
//                                       documentation ```kt\nvalue-parameter dx: kotlin.Int\n```
//                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                             ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
//                                                      display_name recycler
//                                                      documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(state)
//                                                                                    display_name state
//                                                                                    documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]?\n```
//                                                                                                           ^^^ reference semanticdb maven . . kotlin/Int#
        val scrolled = restoreView { super.scrollHorizontallyBy(dx, recycler, state) }
//          ^^^^^^^^ definition local 2
//                   display_name scrolled
//                   documentation ```kt\nval scrolled: kotlin.Unit\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                   ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                              ^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(dx)
//                                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
//                                                                            ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(state)
        if (scrolled != 0) {
//          ^^^^^^^^ reference local 2
//                   ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#equals().
            updateStickyHeader(recycler, false)
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollHorizontallyBy().(recycler)
        }
        return scrolled
//             ^^^^^^^^ reference local 2
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().
//                                display_name onLayoutChildren
//                                documentation ```kt\npublic open fun onLayoutChildren(recycler: [Error type: Unresolved type for RecyclerView.Recycler], state: [Error type: Unresolved type for RecyclerView.State])\n```
//                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
//                                         display_name recycler
//                                         documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                 ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
//                                                                       display_name state
//                                                                       documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
        restoreView { super.onLayoutChildren(recycler, state) }
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                    ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
//                                                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
        if (!state.isPreLayout) {
//           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(state)
            updateStickyHeader(recycler, true)
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onLayoutChildren().(recycler)
        }
    }

    override fun scrollToPosition(position: Int) = scrollToPositionWithOffset(position, INVALID_OFFSET)
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().
//                                display_name scrollToPosition
//                                documentation ```kt\npublic open fun scrollToPosition(position: kotlin.Int)\n```
//                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().(position)
//                                         display_name position
//                                         documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                          ^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                                                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPosition().(position)

    override fun scrollToPositionWithOffset(position: Int, offset: Int) = scrollToPositionWithOffset(position, offset, true)
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                          display_name scrollToPositionWithOffset
//                                          documentation ```kt\npublic open fun scrollToPositionWithOffset(position: kotlin.Int, offset: kotlin.Int)\n```
//                                          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(position)
//                                                   display_name position
//                                                   documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                    ^^^ reference semanticdb maven . . kotlin/Int#
//                                                         ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(offset)
//                                                                display_name offset
//                                                                documentation ```kt\nvalue-parameter offset: kotlin.Int\n```
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).
//                                                                                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(position)
//                                                                                                             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().(offset)

    private fun scrollToPositionWithOffset(position: Int, offset: Int, adjustForStickyHeader: Boolean) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).
//                                         display_name scrollToPositionWithOffset
//                                         documentation ```kt\nprivate final fun scrollToPositionWithOffset(position: kotlin.Int, offset: kotlin.Int, adjustForStickyHeader: kotlin.Boolean)\n```
//                                         ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                  display_name position
//                                                  documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                                        ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                                               display_name offset
//                                                               documentation ```kt\nvalue-parameter offset: kotlin.Int\n```
//                                                                ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                     ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(adjustForStickyHeader)
//                                                                                           display_name adjustForStickyHeader
//                                                                                           documentation ```kt\nvalue-parameter adjustForStickyHeader: kotlin.Boolean\n```
//                                                                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        // Reset pending scroll.
        setScrollState(RecyclerView.NO_POSITION, INVALID_OFFSET)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().

        // Adjusting is disabled.
        if (!adjustForStickyHeader) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(adjustForStickyHeader)
            super.scrollToPositionWithOffset(position, offset)
//          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // There is no header above or the position is a header.
        val headerIndex = findHeaderIndexOrBefore(position)
//          ^^^^^^^^^^^ definition local 3
//                      display_name headerIndex
//                      documentation ```kt\nval headerIndex: kotlin.Int\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
        if (headerIndex == -1 || findHeaderIndex(position) != -1) {
//          ^^^^^^^^^^^ reference local 3
//                      ^^ reference semanticdb maven . . kotlin/Int#equals().
//                         ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                               ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                         ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                            ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
            super.scrollToPositionWithOffset(position, offset)
//          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // The position is right below a header, scroll to the header.
        if (findHeaderIndex(position - 1) != -1) {
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                   ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                        ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                           ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
            super.scrollToPositionWithOffset(position - 1, offset)
//          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                    ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                         ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
            return
        }

        // Current sticky header is the same as at the position. Adjust the scroll offset and reset pending scroll.
        if (stickyHeader != null && headerIndex == findHeaderIndex(stickyHeaderPosition)) {
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                  ^^^^^^^^^^^ reference local 3
//                                              ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
            val adjustedOffset = (if (offset != INVALID_OFFSET) offset else 0) + stickyHeader!!.height
//              ^^^^^^^^^^^^^^ definition local 4
//                             display_name adjustedOffset
//                             documentation ```kt\nval adjustedOffset: [Error type: Not found recorded type for (if (offset != INVALID_OFFSET) offset else 0) + stickyHeader!!.height]\n```
//                                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                           ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
            super.scrollToPositionWithOffset(position, adjustedOffset)
//          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                     ^^^^^^^^^^^^^^ reference local 4
            return
        }

        // Remember this position and offset and scroll to it to trigger creating the sticky header.
        setScrollState(position, offset)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                               ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
        super.scrollToPositionWithOffset(position, offset)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(position)
//                                                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset(+1).(offset)
    }

    //region Computation
    // Mainly [RecyclerView] functionality by removing sticky header from calculations

    override fun computeVerticalScrollExtent(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollExtent(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().
//                                           display_name computeVerticalScrollExtent
//                                           documentation ```kt\npublic open fun computeVerticalScrollExtent(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                           ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().(state)
//                                                 display_name state
//                                                 documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                       ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                           ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollExtent().(state)

    override fun computeVerticalScrollOffset(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollOffset(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().
//                                           display_name computeVerticalScrollOffset
//                                           documentation ```kt\npublic open fun computeVerticalScrollOffset(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                           ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().(state)
//                                                 display_name state
//                                                 documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                       ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                           ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollOffset().(state)

    override fun computeVerticalScrollRange(state: RecyclerView.State): Int = restoreView { super.computeVerticalScrollRange(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().
//                                          display_name computeVerticalScrollRange
//                                          documentation ```kt\npublic open fun computeVerticalScrollRange(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().(state)
//                                                display_name state
//                                                documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                          ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeVerticalScrollRange().(state)

    override fun computeHorizontalScrollExtent(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollExtent(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().
//                                             display_name computeHorizontalScrollExtent
//                                             documentation ```kt\npublic open fun computeHorizontalScrollExtent(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                             ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().(state)
//                                                   display_name state
//                                                   documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollExtent().(state)

    override fun computeHorizontalScrollOffset(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollOffset(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().
//                                             display_name computeHorizontalScrollOffset
//                                             documentation ```kt\npublic open fun computeHorizontalScrollOffset(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                             ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().(state)
//                                                   display_name state
//                                                   documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                         ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                             ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollOffset().(state)

    override fun computeHorizontalScrollRange(state: RecyclerView.State): Int = restoreView { super.computeHorizontalScrollRange(state) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().
//                                            display_name computeHorizontalScrollRange
//                                            documentation ```kt\npublic open fun computeHorizontalScrollRange(state: [Error type: Unresolved type for RecyclerView.State]): kotlin.Int\n```
//                                            ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().(state)
//                                                  display_name state
//                                                  documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
//                                                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                            ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeHorizontalScrollRange().(state)

    override fun computeScrollVectorForPosition(targetPosition: Int): PointF? = restoreView { super.computeScrollVectorForPosition(targetPosition) }
//               ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().
//                                              display_name computeScrollVectorForPosition
//                                              documentation ```kt\npublic open fun computeScrollVectorForPosition(targetPosition: kotlin.Int): [Error type: Unresolved type for PointF]?\n```
//                                              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().(targetPosition)
//                                                             display_name targetPosition
//                                                             documentation ```kt\nvalue-parameter targetPosition: kotlin.Int\n```
//                                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                                                                                            ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                                                                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#computeScrollVectorForPosition().(targetPosition)

    override fun onFocusSearchFailed(
//               ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().
//                                   display_name onFocusSearchFailed
//                                   documentation ```kt\npublic open fun onFocusSearchFailed(focused: [Error type: Unresolved type for View], focusDirection: kotlin.Int, recycler: [Error type: Unresolved type for RecyclerView.Recycler], state: [Error type: Unresolved type for RecyclerView.State]): [Error type: Unresolved type for View]?\n```
        focused: View,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focused)
//              display_name focused
//              documentation ```kt\nvalue-parameter focused: [Error type: Unresolved type for View]\n```
        focusDirection: Int,
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focusDirection)
//                     display_name focusDirection
//                     documentation ```kt\nvalue-parameter focusDirection: kotlin.Int\n```
//                      ^^^ reference semanticdb maven . . kotlin/Int#
        recycler: RecyclerView.Recycler,
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(recycler)
//               display_name recycler
//               documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
        state: RecyclerView.State
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(state)
//            display_name state
//            documentation ```kt\nvalue-parameter state: [Error type: Unresolved type for RecyclerView.State]\n```
    ): View? = restoreView { super.onFocusSearchFailed(focused, focusDirection, recycler, state) }
//             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                           ^^^^^ reference semanticdb maven . . kotlin/Any#
//                                                     ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focused)
//                                                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(focusDirection)
//                                                                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(recycler)
//                                                                                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#onFocusSearchFailed().(state)

    /**
     * Perform the [operation] without the sticky header view by
     * detaching the view -> performing operation -> detaching the view.
     */
    private fun <T> restoreView(operation: () -> T): T {
//               ^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().
//                              display_name restoreView
//                              documentation ```kt\nprivate final fun <T> restoreView(operation: () -> T): T\n```\n\n----\n\n\n Perform the [operation] without the sticky header view by\n detaching the view -> performing operation -> detaching the view.\n
//                              ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().(operation)
//                                        display_name operation
//                                        documentation ```kt\nvalue-parameter operation: () -> T\n```
//                                               ^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
//                                                   ^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().[T]
        stickyHeader?.let(this::detachView)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
        val result = operation()
//          ^^^^^^ definition local 5
//                 display_name result
//                 documentation ```kt\nval result: T\n```
//                   ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#restoreView().(operation)
        stickyHeader?.let(this::attachView)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
        return result
//             ^^^^^^ reference local 5
    }

    //endregion

    /**
     * Offsets the vertical location of the sticky header relative to the its default position.
     */
    fun setStickyHeaderTranslationY(translationY: Float) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().
//                                  display_name setStickyHeaderTranslationY
//                                  documentation ```kt\npublic final fun setStickyHeaderTranslationY(translationY: kotlin.Float)\n```\n\n----\n\n\n Offsets the vertical location of the sticky header relative to the its default position.\n
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().(translationY)
//                                               display_name translationY
//                                               documentation ```kt\nvalue-parameter translationY: kotlin.Float\n```
//                                                ^^^^^ reference semanticdb maven . . kotlin/Float#
        this.translationY = translationY
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationY().(translationY)
        requestLayout()
    }

    /**
     * Offsets the horizontal location of the sticky header relative to the its default position.
     */
    fun setStickyHeaderTranslationX(translationX: Float) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().
//                                  display_name setStickyHeaderTranslationX
//                                  documentation ```kt\npublic final fun setStickyHeaderTranslationX(translationX: kotlin.Float)\n```\n\n----\n\n\n Offsets the horizontal location of the sticky header relative to the its default position.\n
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().(translationX)
//                                               display_name translationX
//                                               documentation ```kt\nvalue-parameter translationX: kotlin.Float\n```
//                                                ^^^^^ reference semanticdb maven . . kotlin/Float#
        this.translationX = translationX
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderTranslationX().(translationX)
        requestLayout()
    }

    /**
     * Returns true if `view` is the current sticky header.
     */
    fun isStickyHeader(view: View): Boolean = view === stickyHeader
//      ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().
//                     display_name isStickyHeader
//                     documentation ```kt\npublic final fun isStickyHeader(view: [Error type: Unresolved type for View]): kotlin.Boolean\n```\n\n----\n\n\n Returns true if `view` is the current sticky header.\n
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().(view)
//                          display_name view
//                          documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isStickyHeader().(view)
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.

    /**
     * Updates the sticky header state (creation, binding, display), to be called whenever there's a layout or scroll
     */
    private fun updateStickyHeader(recycler: RecyclerView.Recycler, layout: Boolean) {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().
//                                 display_name updateStickyHeader
//                                 documentation ```kt\nprivate final fun updateStickyHeader(recycler: [Error type: Unresolved type for RecyclerView.Recycler], layout: kotlin.Boolean)\n```\n\n----\n\n\n Updates the sticky header state (creation, binding, display), to be called whenever there's a layout or scroll\n
//                                 ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                          display_name recycler
//                                          documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(layout)
//                                                                         display_name layout
//                                                                         documentation ```kt\nvalue-parameter layout: kotlin.Boolean\n```
//                                                                          ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        val headerCount = headerPositions.size
//          ^^^^^^^^^^^ definition local 6
//                      display_name headerCount
//                      documentation ```kt\nval headerCount: kotlin.Int\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                        ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                        ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
        val childCount = childCount
//          ^^^^^^^^^^ definition local 7
//                     display_name childCount
//                     documentation ```kt\nval childCount: [Error type: Not found recorded type for childCount]\n```
        if (headerCount > 0 && childCount > 0) {
//          ^^^^^^^^^^^ reference local 6
//                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                             ^^^^^^^^^^ reference local 7
            // Find first valid child.
            var anchorView: View? = null
//              ^^^^^^^^^^ definition local 8
//                         display_name anchorView
//                         documentation ```kt\nvar anchorView: [Error type: Unresolved type for View]?\n```
            var anchorIndex = -1
//              ^^^^^^^^^^^ definition local 9
//                          display_name anchorIndex
//                          documentation ```kt\nvar anchorIndex: kotlin.Int\n```
//                            ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
            var anchorPos = -1
//              ^^^^^^^^^ definition local 10
//                        display_name anchorPos
//                        documentation ```kt\nvar anchorPos: kotlin.Int\n```
//                          ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
            for (i in 0 until childCount) {
//               ^ definition local 11
//                 display_name i
//                 documentation ```kt\nval i: kotlin.Int\n```
//                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^^ reference local 7
                val child = getChildAt(i)
//                  ^^^^^ definition local 12
//                        display_name child
//                        documentation ```kt\nval child: [Error type: Not found recorded type for getChildAt(i)]\n```
//                                     ^ reference local 11
                val params = child!!.layoutParams as RecyclerView.LayoutParams
//                  ^^^^^^ definition local 13
//                         display_name params
//                         documentation ```kt\nval params: [Error type: Unresolved type for RecyclerView.LayoutParams]\n```
//                           ^^^^^ reference local 12
                if (isViewValidAnchor(child, params)) {
//                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().
//                                    ^^^^^ reference local 12
//                                           ^^^^^^ reference local 13
                    anchorView = child
//                  ^^^^^^^^^^ reference local 8
//                               ^^^^^ reference local 12
                    anchorIndex = i
//                  ^^^^^^^^^^^ reference local 9
//                                ^ reference local 11
                    anchorPos = params.viewAdapterPosition
//                  ^^^^^^^^^ reference local 10
//                              ^^^^^^ reference local 13
                    break
                }
            }
            if (anchorView != null && anchorPos != -1) {
//              ^^^^^^^^^^ reference local 8
//                                    ^^^^^^^^^ reference local 10
//                                              ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                 ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                val headerIndex = findHeaderIndexOrBefore(anchorPos)
//                  ^^^^^^^^^^^ definition local 14
//                              display_name headerIndex
//                              documentation ```kt\nval headerIndex: kotlin.Int\n```
//                                ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                                        ^^^^^^^^^ reference local 10
                val headerPos = if (headerIndex != -1) headerPositions[headerIndex] else -1
//                  ^^^^^^^^^ definition local 15
//                            display_name headerPos
//                            documentation ```kt\nval headerPos: kotlin.Int\n```
//                                  ^^^^^^^^^^^ reference local 14
//                                              ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                 ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                                     ^^^^^^^^^^^ reference local 14
//                                                                                       ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                val nextHeaderPos = if (headerCount > headerIndex + 1) headerPositions[headerIndex + 1] else -1
//                  ^^^^^^^^^^^^^ definition local 16
//                                display_name nextHeaderPos
//                                documentation ```kt\nval nextHeaderPos: kotlin.Int\n```
//                                      ^^^^^^^^^^^ reference local 6
//                                                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                    ^^^^^^^^^^^ reference local 14
//                                                                ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                                     ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                                                     ^^^^^^^^^^^ reference local 14
//                                                                                                 ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                                                           ^ reference semanticdb maven . . kotlin/Int#unaryMinus().

                // Show sticky header if:
                // - There's one to show;
                // - It's on the edge or it's not the anchor view;
                // - Isn't followed by another sticky header;
                if (headerPos != -1 &&
//                  ^^^^^^^^^ reference local 15
//                            ^^ reference semanticdb maven . . kotlin/Int#equals().
//                               ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                    (headerPos != anchorPos || isViewOnBoundary(anchorView)) &&
//                   ^^^^^^^^^ reference local 15
//                             ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                ^^^^^^^^^ reference local 10
//                                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().
//                                                              ^^^^^^^^^^ reference local 8
                    nextHeaderPos != headerPos + 1
//                  ^^^^^^^^^^^^^ reference local 16
//                                ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                   ^^^^^^^^^ reference local 15
//                                             ^ reference semanticdb maven . . kotlin/Int#plus(+3).
                ) {
                    // 1. Ensure existing sticky header, if any, is of correct type.
                    if (stickyHeader != null && getItemViewType(stickyHeader!!) != adapter?.getItemViewType(headerPos)) {
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                                                                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                                                                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                                                                          ^^^^^^^^^ reference local 15
                        // A sticky header was shown before but is not of the correct type. Scrap it.
                        scrapStickyHeader(recycler)
//                      ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
                    }

                    // 2. Ensure sticky header is created, if absent, or bound, if being laid out or the position changed.
                    if (stickyHeader == null) createStickyHeader(recycler, headerPos)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                            ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().
//                                                               ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                                                         ^^^^^^^^^ reference local 15
                    // 3. Bind the sticky header
                    if (layout || getPosition(stickyHeader!!) != headerPos) bindStickyHeader(recycler, stickyHeader!!, headerPos)
//                      ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(layout)
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                               ^^^^^^^^^ reference local 15
//                                                                          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().
//                                                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
//                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                                                                                     ^^^^^^^^^ reference local 15

                    // 4. Draw the sticky header using translation values which depend on orientation, direction and
                    // position of the next header view.
                    stickyHeader?.let {
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
                        val nextHeaderView: View? = if (nextHeaderPos != -1) {
//                          ^^^^^^^^^^^^^^ definition local 17
//                                         display_name nextHeaderView
//                                         documentation ```kt\nval nextHeaderView: [Error type: Unresolved type for View]?\n```
//                                                      ^^^^^^^^^^^^^ reference local 16
//                                                                    ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                                                       ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                            val nextHeaderView = getChildAt(anchorIndex + (nextHeaderPos - anchorPos))
//                              ^^^^^^^^^^^^^^ definition local 18
//                                             display_name nextHeaderView
//                                             documentation ```kt\nval nextHeaderView: [Error type: Not found recorded type for getChildAt(anchorIndex + (nextHeaderPos - anchorPos))]\n```
//                                                          ^^^^^^^^^^^ reference local 9
//                                                                      ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                         ^^^^^^^^^^^^^ reference local 16
//                                                                                       ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                                         ^^^^^^^^^ reference local 10
                            // The header view itself is added to the RecyclerView. Discard it if it comes up.
                            if (nextHeaderView === stickyHeader) null else nextHeaderView
//                              ^^^^^^^^^^^^^^ reference local 18
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                                                         ^^^^^^^^^^^^^^ reference local 18
                        } else null
                        it.translationX = getX(it, nextHeaderView)
//                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().
//                                                 ^^^^^^^^^^^^^^ reference local 17
                        it.translationY = getY(it, nextHeaderView)
//                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().
//                                                 ^^^^^^^^^^^^^^ reference local 17
                    }
                    return
                }
            }
        }

        if (stickyHeader != null) {
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
            scrapStickyHeader(recycler)
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#updateStickyHeader().(recycler)
        }
    }

    /**
     * Creates [RecyclerView.ViewHolder] for [position], including measure / layout, and assigns it to
     * [stickyHeader].
     */
    private fun createStickyHeader(recycler: RecyclerView.Recycler, position: Int) {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().
//                                 display_name createStickyHeader
//                                 documentation ```kt\nprivate final fun createStickyHeader(recycler: [Error type: Unresolved type for RecyclerView.Recycler], position: kotlin.Int)\n```\n\n----\n\n\n Creates [RecyclerView.ViewHolder] for [position], including measure / layout, and assigns it to\n [stickyHeader].\n
//                                 ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(recycler)
//                                          display_name recycler
//                                          documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)
//                                                                           display_name position
//                                                                           documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                            ^^^ reference semanticdb maven . . kotlin/Int#
        val stickyHeader = recycler.getViewForPosition(position)
//          ^^^^^^^^^^^^ definition local 19
//                       display_name stickyHeader
//                       documentation ```kt\nval stickyHeader: [Error type: Return type for function cannot be resolved]\n```
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(recycler)
//                                                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)

        // Setup sticky header if the adapter requires it.
        adapter?.setupStickyHeaderView(stickyHeader)
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                     ^^^^^^^^^^^^ reference local 19

        // Add sticky header as a child view, to be detached / reattached whenever LinearLayoutManager#fill() is called,
        // which happens on layout and scroll (see overrides).
        addView(stickyHeader)
//              ^^^^^^^^^^^^ reference local 19
        measureAndLayout(stickyHeader)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                       ^^^^^^^^^^^^ reference local 19

        // Ignore sticky header, as it's fully managed by this LayoutManager.
        ignoreView(stickyHeader)
//                 ^^^^^^^^^^^^ reference local 19

        this.stickyHeader = stickyHeader
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                          ^^^^^^^^^^^^ reference local 19
        this.stickyHeaderPosition = position
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#createStickyHeader().(position)
    }

    /**
     * Binds the [stickyHeader] for the given [position].
     */
    private fun bindStickyHeader(recycler: RecyclerView.Recycler, stickyHeader: View, position: Int) {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().
//                               display_name bindStickyHeader
//                               documentation ```kt\nprivate final fun bindStickyHeader(recycler: [Error type: Unresolved type for RecyclerView.Recycler], stickyHeader: [Error type: Unresolved type for View], position: kotlin.Int)\n```\n\n----\n\n\n Binds the [stickyHeader] for the given [position].\n
//                               ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(recycler)
//                                        display_name recycler
//                                        documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]\n```
//                                                                ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                             display_name stickyHeader
//                                                                             documentation ```kt\nvalue-parameter stickyHeader: [Error type: Unresolved type for View]\n```
//                                                                                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
//                                                                                             display_name position
//                                                                                             documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                                                              ^^^ reference semanticdb maven . . kotlin/Int#
        // Bind the sticky header.
        recycler.bindViewToPosition(stickyHeader, position)
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(recycler)
//                                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
        stickyHeaderPosition = position
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
//                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(position)
        measureAndLayout(stickyHeader)
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)

        // If we have a pending scroll wait until the end of layout and scroll again.
        if (scrollPosition != RecyclerView.NO_POSITION) {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
            stickyHeader.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
                override fun onGlobalLayout() {
//                           ^^^^^^^^^^^^^^ definition local 20
//                                          display_name onGlobalLayout
//                                          documentation ```kt\npublic open fun onGlobalLayout()\n```
                    if (Build.VERSION.SDK_INT < 16) stickyHeader.viewTreeObserver.removeGlobalOnLayoutListener(this)
//                                                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                                                             ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().`<no name provided>`#
                    else stickyHeader.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().(stickyHeader)
//                                                                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#bindStickyHeader().`<no name provided>`#
                    if (scrollPosition != RecyclerView.NO_POSITION) {
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
                        scrollToPositionWithOffset(scrollPosition, scrollOffset)
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollToPositionWithOffset().
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//                                                 ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//                                                                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
                        setScrollState(RecyclerView.NO_POSITION, INVALID_OFFSET)
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
                    }
                }
            })
        }
    }

    /**
     * Measures and lays out [stickyHeader].
     */
    private fun measureAndLayout(stickyHeader: View) {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().
//                               display_name measureAndLayout
//                               documentation ```kt\nprivate final fun measureAndLayout(stickyHeader: [Error type: Unresolved type for View])\n```\n\n----\n\n\n Measures and lays out [stickyHeader].\n
//                               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
//                                            display_name stickyHeader
//                                            documentation ```kt\nvalue-parameter stickyHeader: [Error type: Unresolved type for View]\n```
        measureChildWithMargins(stickyHeader, 0, 0)
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
        when (orientation) {
            VERTICAL -> stickyHeader.layout(paddingLeft, 0, width - paddingRight, stickyHeader.measuredHeight)
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
//                                                                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
            else -> stickyHeader.layout(0, paddingTop, stickyHeader.measuredWidth, height - paddingBottom)
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#measureAndLayout().(stickyHeader)
        }
    }

    /**
     * Returns [stickyHeader] to the [RecyclerView]'s [RecyclerView.RecycledViewPool], assigning it
     * to `null`.
     *
     * @param recycler If passed, the sticky header will be returned to the recycled view pool.
     */
    private fun scrapStickyHeader(recycler: RecyclerView.Recycler?) {
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
//                                display_name scrapStickyHeader
//                                documentation ```kt\nprivate final fun scrapStickyHeader(recycler: [Error type: Unresolved type for RecyclerView.Recycler]?)\n```\n\n----\n\n\n Returns [stickyHeader] to the [RecyclerView]'s [RecyclerView.RecycledViewPool], assigning it\n to `null`.\n\n @param recycler If passed, the sticky header will be returned to the recycled view pool.\n
//                                ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().(recycler)
//                                         display_name recycler
//                                         documentation ```kt\nvalue-parameter recycler: [Error type: Unresolved type for RecyclerView.Recycler]?\n```
        val stickyHeader = stickyHeader ?: return
//          ^^^^^^^^^^^^ definition local 21
//                       display_name stickyHeader
//                       documentation ```kt\nval stickyHeader: kotlin.Nothing\n```
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
        this.stickyHeader = null
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
        this.stickyHeaderPosition = RecyclerView.NO_POSITION
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.

        // Revert translation values.
        stickyHeader.translationX = 0f
//      ^^^^^^^^^^^^ reference local 21
        stickyHeader.translationY = 0f
//      ^^^^^^^^^^^^ reference local 21

        // Teardown holder if the adapter requires it.
        adapter?.teardownStickyHeaderView(stickyHeader)
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                        ^^^^^^^^^^^^ reference local 21

        // Stop ignoring sticky header so that it can be recycled.
        stopIgnoringView(stickyHeader)
//                       ^^^^^^^^^^^^ reference local 21

        // Remove and recycle sticky header.
        removeView(stickyHeader)
//                 ^^^^^^^^^^^^ reference local 21
        recycler?.recycleView(stickyHeader)
//      ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().(recycler)
//                            ^^^^^^^^^^^^ reference local 21
    }

    /**
     * Returns true when `view` is a valid anchor, ie. the first view to be valid and visible.
     */
    private fun isViewValidAnchor(view: View, params: RecyclerView.LayoutParams): Boolean {
//              ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().
//                                display_name isViewValidAnchor
//                                documentation ```kt\nprivate final fun isViewValidAnchor(view: [Error type: Unresolved type for View], params: [Error type: Unresolved type for RecyclerView.LayoutParams]): kotlin.Boolean\n```\n\n----\n\n\n Returns true when `view` is a valid anchor, ie. the first view to be valid and visible.\n
//                                ^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                     display_name view
//                                     documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
//                                                   display_name params
//                                                   documentation ```kt\nvalue-parameter params: [Error type: Unresolved type for RecyclerView.LayoutParams]\n```
//                                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return when {
            !params.isItemRemoved && !params.isViewInvalid -> when (orientation) {
//           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
//                                    ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(params)
                VERTICAL -> when {
                    reverseLayout -> view.top + view.translationY <= height + translationY
//                                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                              ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
                    else -> view.bottom - view.translationY >= translationY
//                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                        ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                                                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
                }
                else -> when {
                    reverseLayout -> view.left + view.translationX <= width + translationX
//                                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
                    else -> view.right - view.translationX >= translationX
//                          ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                       ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewValidAnchor().(view)
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
                }
            }
            else -> false
        }
    }

    /**
     * Returns true when the `view` is at the edge of the parent [RecyclerView].
     */
    private fun isViewOnBoundary(view: View): Boolean {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().
//                               display_name isViewOnBoundary
//                               documentation ```kt\nprivate final fun isViewOnBoundary(view: [Error type: Unresolved type for View]): kotlin.Boolean\n```\n\n----\n\n\n Returns true when the `view` is at the edge of the parent [RecyclerView].\n
//                               ^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                    display_name view
//                                    documentation ```kt\nvalue-parameter view: [Error type: Unresolved type for View]\n```
//                                            ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return when (orientation) {
            VERTICAL -> when {
                reverseLayout -> view.bottom - view.translationY > height + translationY
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                             ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                                                                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
                else -> view.top + view.translationY < translationY
//                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
            }
            else -> when {
                reverseLayout -> view.right - view.translationX > width + translationX
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                            ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                                                                        ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
                else -> view.left + view.translationX < translationX
//                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#isViewOnBoundary().(view)
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
            }
        }
    }

    /**
     * Returns the position in the Y axis to position the header appropriately, depending on orientation, direction and
     * [android.R.attr.clipToPadding].
     */
    private fun getY(headerView: View, nextHeaderView: View?): Float {
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().
//                   display_name getY
//                   documentation ```kt\nprivate final fun getY(headerView: [Error type: Unresolved type for View], nextHeaderView: [Error type: Unresolved type for View]?): kotlin.Float\n```\n\n----\n\n\n Returns the position in the Y axis to position the header appropriately, depending on orientation, direction and\n [android.R.attr.clipToPadding].\n
//                   ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
//                              display_name headerView
//                              documentation ```kt\nvalue-parameter headerView: [Error type: Unresolved type for View]\n```
//                                     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                    display_name nextHeaderView
//                                                    documentation ```kt\nvalue-parameter nextHeaderView: [Error type: Unresolved type for View]?\n```
//                                                             ^^^^^ reference semanticdb maven . . kotlin/Float#
        when (orientation) {
            VERTICAL -> {
                var y = translationY
//                  ^ definition local 22
//                    display_name y
//                    documentation ```kt\nvar y: kotlin.Float\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
                if (reverseLayout) {
                    y += (height - headerView.height).toFloat()
//                  ^ reference local 22
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
                }
                if (nextHeaderView != null) {
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    val bottomMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin ?: 0
//                      ^^^^^^^^^^^^ definition local 23
//                                   display_name bottomMargin
//                                   documentation ```kt\nval bottomMargin: kotlin.Int\n```
//                                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    val topMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin ?: 0
//                      ^^^^^^^^^ definition local 24
//                                display_name topMargin
//                                documentation ```kt\nval topMargin: kotlin.Int\n```
//                                   ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
                    y = when {
//                  ^ reference local 22
                        reverseLayout -> (nextHeaderView.bottom + bottomMargin).toFloat().coerceAtLeast(y)
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                                ^^^^^^^^^^^^ reference local 23
//                                                                                                      ^ reference local 22
                        else -> (nextHeaderView.top - topMargin - headerView.height).toFloat().coerceAtMost(y)
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(nextHeaderView)
//                                                    ^^^^^^^^^ reference local 24
//                                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getY().(headerView)
//                                                                                                          ^ reference local 22
                    }
                }
                return y
//                     ^ reference local 22
            }
            else -> return translationY
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationY().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationY().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationY.
        }
    }

    /**
     * Returns the position in the X axis to position the header appropriately, depending on orientation, direction and
     * [android.R.attr.clipToPadding].
     */
    private fun getX(headerView: View, nextHeaderView: View?): Float {
//              ^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().
//                   display_name getX
//                   documentation ```kt\nprivate final fun getX(headerView: [Error type: Unresolved type for View], nextHeaderView: [Error type: Unresolved type for View]?): kotlin.Float\n```\n\n----\n\n\n Returns the position in the X axis to position the header appropriately, depending on orientation, direction and\n [android.R.attr.clipToPadding].\n
//                   ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
//                              display_name headerView
//                              documentation ```kt\nvalue-parameter headerView: [Error type: Unresolved type for View]\n```
//                                     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                    display_name nextHeaderView
//                                                    documentation ```kt\nvalue-parameter nextHeaderView: [Error type: Unresolved type for View]?\n```
//                                                             ^^^^^ reference semanticdb maven . . kotlin/Float#
        when (orientation) {
            HORIZONTAL -> {
                var x = translationX
//                  ^ definition local 25
//                    display_name x
//                    documentation ```kt\nvar x: kotlin.Float\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
                if (reverseLayout) {
                    x += (width - headerView.width).toFloat()
//                  ^ reference local 25
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
                }
                if (nextHeaderView != null) {
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    val leftMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.leftMargin ?: 0
//                      ^^^^^^^^^^ definition local 26
//                                 display_name leftMargin
//                                 documentation ```kt\nval leftMargin: kotlin.Int\n```
//                                    ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    val rightMargin = (nextHeaderView.layoutParams as? ViewGroup.MarginLayoutParams)?.rightMargin ?: 0
//                      ^^^^^^^^^^^ definition local 27
//                                  display_name rightMargin
//                                  documentation ```kt\nval rightMargin: kotlin.Int\n```
//                                     ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
                    x = when {
//                  ^ reference local 25
                        reverseLayout -> (nextHeaderView.right + rightMargin).toFloat().coerceAtLeast(x)
//                                        ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                               ^^^^^^^^^^^ reference local 27
//                                                                                                    ^ reference local 25
                        else -> (nextHeaderView.left - leftMargin - headerView.width).toFloat().coerceAtMost(x)
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(nextHeaderView)
//                                                     ^^^^^^^^^^ reference local 26
//                                                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getX().(headerView)
//                                                                                                           ^ reference local 25
                    }
                }
                return x
//                     ^ reference local 25
            }
            else -> return translationX
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getTranslationX().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setTranslationX().
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#translationX.
        }
    }

    /**
     * Finds the header index of `position` in `headerPositions`.
     */
    private fun findHeaderIndex(position: Int): Int {
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                              display_name findHeaderIndex
//                              documentation ```kt\nprivate final fun findHeaderIndex(position: kotlin.Int): kotlin.Int\n```\n\n----\n\n\n Finds the header index of `position` in `headerPositions`.\n
//                              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                       display_name position
//                                       documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                        ^^^ reference semanticdb maven . . kotlin/Int#
//                                              ^^^ reference semanticdb maven . . kotlin/Int#
        var low = 0
//          ^^^ definition local 28
//              display_name low
//              documentation ```kt\nvar low: kotlin.Int\n```
        var high = headerPositions.size - 1
//          ^^^^ definition local 29
//               display_name high
//               documentation ```kt\nvar high: kotlin.Int\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
//                                      ^ reference semanticdb maven . . kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local 28
//                 ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                    ^^^^ reference local 29
            val middle = (low + high) / 2
//              ^^^^^^ definition local 30
//                     display_name middle
//                     documentation ```kt\nval middle: kotlin.Int\n```
//                        ^^^ reference local 28
//                            ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                              ^^^^ reference local 29
//                                    ^ reference semanticdb maven . . kotlin/Int#div(+3).
            when {
                headerPositions[middle] > position -> high = middle - 1
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^ reference local 30
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                                    ^^^^ reference local 29
//                                                           ^^^^^^ reference local 30
//                                                                  ^ reference semanticdb maven . . kotlin/Int#minus(+3).
                headerPositions[middle] < position -> low = middle + 1
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^ reference local 30
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().(position)
//                                                    ^^^ reference local 28
//                                                          ^^^^^^ reference local 30
//                                                                 ^ reference semanticdb maven . . kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local 30
            }
        }
        return -1
//             ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
    }

    /**
     * Finds the header index of `position` or the one before it in `headerPositions`.
     */
    private fun findHeaderIndexOrBefore(position: Int): Int {
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().
//                                      display_name findHeaderIndexOrBefore
//                                      documentation ```kt\nprivate final fun findHeaderIndexOrBefore(position: kotlin.Int): kotlin.Int\n```\n\n----\n\n\n Finds the header index of `position` or the one before it in `headerPositions`.\n
//                                      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                               display_name position
//                                               documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                                ^^^ reference semanticdb maven . . kotlin/Int#
//                                                      ^^^ reference semanticdb maven . . kotlin/Int#
        var low = 0
//          ^^^ definition local 31
//              display_name low
//              documentation ```kt\nvar low: kotlin.Int\n```
        var high = headerPositions.size - 1
//          ^^^^ definition local 32
//               display_name high
//               documentation ```kt\nvar high: kotlin.Int\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
//                                      ^ reference semanticdb maven . . kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local 31
//                 ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                    ^^^^ reference local 32
            val middle = (low + high) / 2
//              ^^^^^^ definition local 33
//                     display_name middle
//                     documentation ```kt\nval middle: kotlin.Int\n```
//                        ^^^ reference local 31
//                            ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                              ^^^^ reference local 32
//                                    ^ reference semanticdb maven . . kotlin/Int#div(+3).
            when {
                headerPositions[middle] > position -> high = middle - 1
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^ reference local 33
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                                    ^^^^ reference local 32
//                                                           ^^^^^^ reference local 33
//                                                                  ^ reference semanticdb maven . . kotlin/Int#minus(+3).
                middle < headerPositions.size - 1 && headerPositions[middle + 1] <= position -> low = middle + 1
//              ^^^^^^ reference local 33
//                     ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                       ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                       ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
//                                            ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                                   ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                                   ^^^^^^ reference local 33
//                                                                          ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                               ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrBefore().(position)
//                                                                                              ^^^ reference local 31
//                                                                                                    ^^^^^^ reference local 33
//                                                                                                           ^ reference semanticdb maven . . kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local 33
            }
        }
        return -1
//             ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
    }

    /**
     * Finds the header index of `position` or the one next to it in `headerPositions`.
     */
    private fun findHeaderIndexOrNext(position: Int): Int {
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                    display_name findHeaderIndexOrNext
//                                    documentation ```kt\nprivate final fun findHeaderIndexOrNext(position: kotlin.Int): kotlin.Int\n```\n\n----\n\n\n Finds the header index of `position` or the one next to it in `headerPositions`.\n
//                                    ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                             display_name position
//                                             documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                    ^^^ reference semanticdb maven . . kotlin/Int#
        var low = 0
//          ^^^ definition local 34
//              display_name low
//              documentation ```kt\nvar low: kotlin.Int\n```
        var high = headerPositions.size - 1
//          ^^^^ definition local 35
//               display_name high
//               documentation ```kt\nvar high: kotlin.Int\n```
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                 ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                 ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
//                                      ^ reference semanticdb maven . . kotlin/Int#minus(+3).
        while (low <= high) {
//             ^^^ reference local 34
//                 ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                    ^^^^ reference local 35
            val middle = (low + high) / 2
//              ^^^^^^ definition local 36
//                     display_name middle
//                     documentation ```kt\nval middle: kotlin.Int\n```
//                        ^^^ reference local 34
//                            ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                              ^^^^ reference local 35
//                                    ^ reference semanticdb maven . . kotlin/Int#div(+3).
            when {
                middle > 0 && headerPositions[middle - 1] >= position -> high = middle - 1
//              ^^^^^^ reference local 36
//                     ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                            ^^^^^^ reference local 36
//                                                   ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                        ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                           ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                                                       ^^^^ reference local 35
//                                                                              ^^^^^^ reference local 36
//                                                                                     ^ reference semanticdb maven . . kotlin/Int#minus(+3).
                headerPositions[middle] < position -> low = middle + 1
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^^^^ reference local 36
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().(position)
//                                                    ^^^ reference local 34
//                                                          ^^^^^^ reference local 36
//                                                                 ^ reference semanticdb maven . . kotlin/Int#plus(+3).
                else -> return middle
//                             ^^^^^^ reference local 36
            }
        }
        return -1
//             ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
    }

    private fun setScrollState(position: Int, offset: Int) {
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().
//                             display_name setScrollState
//                             documentation ```kt\nprivate final fun setScrollState(position: kotlin.Int, offset: kotlin.Int)\n```
//                             ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(position)
//                                      display_name position
//                                      documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                                       ^^^ reference semanticdb maven . . kotlin/Int#
//                                            ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(offset)
//                                                   display_name offset
//                                                   documentation ```kt\nvalue-parameter offset: kotlin.Int\n```
//                                                    ^^^ reference semanticdb maven . . kotlin/Int#
        scrollPosition = position
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollPosition().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollPosition.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollPosition().
//                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(position)
        scrollOffset = offset
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getScrollOffset().
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrollOffset.
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollOffset().
//                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setScrollState().(offset)
    }

    /**
     * Save / restore existing [RecyclerView] state and
     * scrolling position and offset.
     */
    @Parcelize
//   ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-parcelize-runtime 1.4.20-RC kotlinx/android/parcel/Parcelize#`<init>`().
    data class SavedState(
//             ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#
//                        display_name SavedState
//                        documentation ```kt\npublic final data class SavedState\n```\n\n----\n\n\n Save / restore existing [RecyclerView] state and\n scrolling position and offset.\n
//             ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().
//                        display_name SavedState
//                        documentation ```kt\npublic constructor SavedState(superState: [Error type: Unresolved type for Parcelable]?, scrollPosition: kotlin.Int, scrollOffset: kotlin.Int)\n```
        val superState: Parcelable?,
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(superState)
//                     display_name superState
//                     documentation ```kt\nvalue-parameter superState: [Error type: Unresolved type for Parcelable]?\n```
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getSuperState().
//                     display_name superState
//                     documentation ```kt\npublic final val superState: [Error type: Unresolved type for Parcelable]?\n```
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#superState.
//                     display_name superState
//                     documentation ```kt\npublic final val superState: [Error type: Unresolved type for Parcelable]?\n```
        val scrollPosition: Int,
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollPosition)
//                         display_name scrollPosition
//                         documentation ```kt\nvalue-parameter scrollPosition: kotlin.Int\n```
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollPosition().
//                         display_name scrollPosition
//                         documentation ```kt\npublic final val scrollPosition: kotlin.Int\n```
//          ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollPosition.
//                         display_name scrollPosition
//                         documentation ```kt\npublic final val scrollPosition: kotlin.Int\n```
//                          ^^^ reference semanticdb maven . . kotlin/Int#
        val scrollOffset: Int
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#`<init>`().(scrollOffset)
//                       display_name scrollOffset
//                       documentation ```kt\nvalue-parameter scrollOffset: kotlin.Int\n```
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#getScrollOffset().
//                       display_name scrollOffset
//                       documentation ```kt\npublic final val scrollOffset: kotlin.Int\n```
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#SavedState#scrollOffset.
//                       display_name scrollOffset
//                       documentation ```kt\npublic final val scrollOffset: kotlin.Int\n```
//                        ^^^ reference semanticdb maven . . kotlin/Int#
    ) : Parcelable

    /**
     * Handles header positions while adapter changes occur.
     *
     * This is used in detriment of [RecyclerView.LayoutManager]'s callbacks to control when they're received.
     */
    private inner class HeaderPositionsAdapterDataObserver : RecyclerView.AdapterDataObserver() {
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#
//                                                         display_name HeaderPositionsAdapterDataObserver
//                                                         documentation ```kt\nprivate final inner class HeaderPositionsAdapterDataObserver\n```\n\n----\n\n\n Handles header positions while adapter changes occur.\n\n This is used in detriment of [RecyclerView.LayoutManager]'s callbacks to control when they're received.\n
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#`<init>`().
//                                                         display_name HeaderPositionsAdapterDataObserver
//                                                         documentation ```kt\npublic constructor HeaderPositionsAdapterDataObserver()\n```\n\n----\n\n\n Handles header positions while adapter changes occur.\n\n This is used in detriment of [RecyclerView.LayoutManager]'s callbacks to control when they're received.\n
        override fun onChanged() {
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onChanged().
//                             display_name onChanged
//                             documentation ```kt\npublic open fun onChanged()\n```
            // There's no hint at what changed, so go through the adapter.
            headerPositions.clear()
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                          ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
            val itemCount = adapter?.itemCount ?: 0
//              ^^^^^^^^^ definition local 37
//                        display_name itemCount
//                        documentation ```kt\nval itemCount: kotlin.Int\n```
//                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                          ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
            for (i in 0 until itemCount) {
//               ^ definition local 38
//                 display_name i
//                 documentation ```kt\nval i: kotlin.Int\n```
//                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^ reference local 37
                val isSticky = adapter?.isStickyHeader(i) ?: false
//                  ^^^^^^^^ definition local 39
//                           display_name isSticky
//                           documentation ```kt\nval isSticky: kotlin.Boolean\n```
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                     ^ reference local 38
                if (isSticky) {
//                  ^^^^^^^^ reference local 39
                    headerPositions.add(i)
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                  ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                      ^ reference local 38
                }
            }

            // Remove sticky header immediately if the entry it represents has been removed. A layout will follow.
            if (stickyHeader != null && !headerPositions.contains(stickyHeaderPosition)) {
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                      ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                       ^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#contains().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
                scrapStickyHeader(null)
//              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
            }
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().
//                                       display_name onItemRangeInserted
//                                       documentation ```kt\npublic open fun onItemRangeInserted(positionStart: kotlin.Int, itemCount: kotlin.Int)\n```
//                                       ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                                     display_name positionStart
//                                                     documentation ```kt\nvalue-parameter positionStart: kotlin.Int\n```
//                                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                                           ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
//                                                                     display_name itemCount
//                                                                     documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                      ^^^ reference semanticdb maven . . kotlin/Int#
            // Shift headers below down.
            val headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local 40
//                          display_name headerCount
//                          documentation ```kt\nval headerCount: kotlin.Int\n```
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local 40
//                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
                var i = findHeaderIndexOrNext(positionStart)
//                  ^ definition local 41
//                    display_name i
//                    documentation ```kt\nvar i: kotlin.Int\n```
//                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
                while (i != -1 && i < headerCount) {
//                     ^ reference local 41
//                       ^^ reference semanticdb maven . . kotlin/Int#equals().
//                          ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                ^ reference local 41
//                                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                    ^^^^^^^^^^^ reference local 40
                    headerPositions[i] = headerPositions[i] + itemCount
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                  ^ reference local 41
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                       ^ reference local 41
//                                                          ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
                    i++
//                  ^ reference local 41
//                   ^^ reference semanticdb maven . . kotlin/Int#inc().
                }
            }

            // Add new headers.
            for (i in positionStart until positionStart + itemCount) {
//               ^ definition local 42
//                 display_name i
//                 documentation ```kt\nval i: kotlin.Int\n```
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(positionStart)
//                                                      ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeInserted().(itemCount)
                val isSticky = adapter?.isStickyHeader(i) ?: false
//                  ^^^^^^^^ definition local 43
//                           display_name isSticky
//                           documentation ```kt\nval isSticky: kotlin.Boolean\n```
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#adapter.
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getAdapter().
//                             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setAdapter().
//                                                     ^ reference local 42
                if (isSticky) {
//                  ^^^^^^^^ reference local 43
                    val headerIndex = findHeaderIndexOrNext(i)
//                      ^^^^^^^^^^^ definition local 44
//                                  display_name headerIndex
//                                  documentation ```kt\nval headerIndex: kotlin.Int\n```
//                                    ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                          ^ reference local 42
                    if (headerIndex != -1) {
//                      ^^^^^^^^^^^ reference local 44
//                                  ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                     ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                        headerPositions.add(headerIndex, i)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                      ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add(+1).
//                                          ^^^^^^^^^^^ reference local 44
//                                                       ^ reference local 42
                    } else {
                        headerPositions.add(i)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                      ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                          ^ reference local 42
                    }
                }
            }
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().
//                                      display_name onItemRangeRemoved
//                                      documentation ```kt\npublic open fun onItemRangeRemoved(positionStart: kotlin.Int, itemCount: kotlin.Int)\n```
//                                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                                    display_name positionStart
//                                                    documentation ```kt\nvalue-parameter positionStart: kotlin.Int\n```
//                                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                                          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
//                                                                    display_name itemCount
//                                                                    documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                     ^^^ reference semanticdb maven . . kotlin/Int#
            var headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local 45
//                          display_name headerCount
//                          documentation ```kt\nvar headerCount: kotlin.Int\n```
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local 45
//                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
                // Remove headers.
                for (i in positionStart + itemCount - 1 downTo positionStart) {
//                   ^ definition local 46
//                     display_name i
//                     documentation ```kt\nval i: kotlin.Int\n```
//                        ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                      ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
//                                                  ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                      ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#downTo(+6).
//                                                             ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
                    val index = findHeaderIndex(i)
//                      ^^^^^ definition local 47
//                            display_name index
//                            documentation ```kt\nval index: kotlin.Int\n```
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndex().
//                                              ^ reference local 46
                    if (index != -1) {
//                      ^^^^^ reference local 47
//                            ^^ reference semanticdb maven . . kotlin/Int#equals().
//                               ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                        headerPositions.removeAt(index)
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                      ^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#removeAt().
//                                               ^^^^^ reference local 47
                        headerCount--
//                      ^^^^^^^^^^^ reference local 45
//                                 ^^ reference semanticdb maven . . kotlin/Int#dec().
                    }
                }

                // Remove sticky header immediately if the entry it represents has been removed. A layout will follow.
                if (stickyHeader != null && !headerPositions.contains(stickyHeaderPosition)) {
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeader().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeader().
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeader.
//                                          ^ reference semanticdb maven . . kotlin/Boolean#not().
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                           ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                           ^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#contains().
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getStickyHeaderPosition().
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#setStickyHeaderPosition().
//                                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#stickyHeaderPosition.
                    scrapStickyHeader(null)
//                  ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#scrapStickyHeader().
                }

                // Shift headers below up.
                var i = findHeaderIndexOrNext(positionStart + itemCount)
//                  ^ definition local 48
//                    display_name i
//                    documentation ```kt\nvar i: kotlin.Int\n```
//                      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                            ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(positionStart)
//                                                          ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
                while (i != -1 && i < headerCount) {
//                     ^ reference local 48
//                       ^^ reference semanticdb maven . . kotlin/Int#equals().
//                          ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                ^ reference local 48
//                                  ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                    ^^^^^^^^^^^ reference local 45
                    headerPositions[i] = headerPositions[i] - itemCount
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                  ^ reference local 48
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                       ^ reference local 48
//                                                          ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeRemoved().(itemCount)
                    i++
//                  ^ reference local 48
//                   ^^ reference semanticdb maven . . kotlin/Int#inc().
                }
            }
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().
//                                    display_name onItemRangeMoved
//                                    documentation ```kt\npublic open fun onItemRangeMoved(fromPosition: kotlin.Int, toPosition: kotlin.Int, itemCount: kotlin.Int)\n```
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                 display_name fromPosition
//                                                 documentation ```kt\nvalue-parameter fromPosition: kotlin.Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                       ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                  display_name toPosition
//                                                                  documentation ```kt\nvalue-parameter toPosition: kotlin.Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
//                                                                                  display_name itemCount
//                                                                                  documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
            // Shift moved headers by toPosition - fromPosition.
            // Shift headers in-between by -itemCount (reverse if upwards).
            val headerCount = headerPositions.size
//              ^^^^^^^^^^^ definition local 49
//                          display_name headerCount
//                          documentation ```kt\nval headerCount: kotlin.Int\n```
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                            ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#getSize().
//                                            ^^^^ reference semanticdb maven . . kotlin/collections/MutableList#size.
            if (headerCount > 0) {
//              ^^^^^^^^^^^ reference local 49
//                          ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
                if (fromPosition < toPosition) {
//                  ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                               ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                 ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                    var i = findHeaderIndexOrNext(fromPosition)
//                      ^ definition local 50
//                        display_name i
//                        documentation ```kt\nvar i: kotlin.Int\n```
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                    while (i != -1 && i < headerCount) {
//                         ^ reference local 50
//                           ^^ reference semanticdb maven . . kotlin/Int#equals().
//                              ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                    ^ reference local 50
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^^ reference local 49
                        val headerPos = headerPositions[i]
//                          ^^^^^^^^^ definition local 51
//                                    display_name headerPos
//                                    documentation ```kt\nval headerPos: kotlin.Int\n```
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                      ^ reference local 50
                        if (headerPos >= fromPosition && headerPos < fromPosition + itemCount) {
//                          ^^^^^^^^^ reference local 51
//                                    ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                       ^^^^^^^^^ reference local 51
//                                                                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                                                ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                            headerPositions[i] = headerPos - (toPosition - fromPosition)
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                          ^ reference local 50
//                                               ^^^^^^^^^ reference local 51
//                                                         ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                       ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                            sortHeaderAtIndex(i)
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                            ^ reference local 50
                        } else if (headerPos >= fromPosition + itemCount && headerPos <= toPosition) {
//                                 ^^^^^^^^^ reference local 51
//                                           ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                           ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                             ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
//                                                                          ^^^^^^^^^ reference local 51
//                                                                                    ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                            headerPositions[i] = headerPos - itemCount
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                          ^ reference local 50
//                                               ^^^^^^^^^ reference local 51
//                                                         ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                            sortHeaderAtIndex(i)
//                          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                            ^ reference local 50
                        } else {
                            break
                        }
                        i++
//                      ^ reference local 50
//                       ^^ reference semanticdb maven . . kotlin/Int#inc().
                    }
                } else {
                    var i = findHeaderIndexOrNext(toPosition)
//                      ^ definition local 52
//                        display_name i
//                        documentation ```kt\nvar i: kotlin.Int\n```
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
                    loop@ while (i != -1 && i < headerCount) {
//                               ^ reference local 52
//                                 ^^ reference semanticdb maven . . kotlin/Int#equals().
//                                    ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                          ^ reference local 52
//                                            ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                              ^^^^^^^^^^^ reference local 49
                        val headerPos = headerPositions[i]
//                          ^^^^^^^^^ definition local 53
//                                    display_name headerPos
//                                    documentation ```kt\nval headerPos: kotlin.Int\n```
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                                      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                                      ^ reference local 52
                        when {
                            headerPos >= fromPosition && headerPos < fromPosition + itemCount -> {
//                          ^^^^^^^^^ reference local 53
//                                    ^^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                       ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                       ^^^^^^^^^ reference local 53
//                                                                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
//                                                                                ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                                  ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                                headerPositions[i] = headerPos + (toPosition - fromPosition)
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                              ^ reference local 52
//                                                   ^^^^^^^^^ reference local 53
//                                                             ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                                           ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                                                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                                sortHeaderAtIndex(i)
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                                ^ reference local 52
                            }
                            headerPos in toPosition..fromPosition -> {
//                          ^^^^^^^^^ reference local 53
//                                    ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#contains().
//                                       ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(toPosition)
//                                                 ^^ reference semanticdb maven . . kotlin/Int#rangeTo(+1).
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(fromPosition)
                                headerPositions[i] = headerPos + itemCount
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                              ^ reference local 52
//                                                   ^^^^^^^^^ reference local 53
//                                                             ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#onItemRangeMoved().(itemCount)
                                sortHeaderAtIndex(i)
//                              ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                                ^ reference local 52
                            }
                            else -> break@loop
                        }
                        i++
//                      ^ reference local 52
//                       ^^ reference semanticdb maven . . kotlin/Int#inc().
                    }
                }
            }
        }

        private fun sortHeaderAtIndex(index: Int) {
//                  ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().
//                                    display_name sortHeaderAtIndex
//                                    documentation ```kt\nprivate final fun sortHeaderAtIndex(index: kotlin.Int)\n```
//                                    ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().(index)
//                                          display_name index
//                                          documentation ```kt\nvalue-parameter index: kotlin.Int\n```
//                                           ^^^ reference semanticdb maven . . kotlin/Int#
            val headerPos = headerPositions.removeAt(index)
//              ^^^^^^^^^ definition local 54
//                        display_name headerPos
//                        documentation ```kt\nval headerPos: kotlin.Int\n```
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//                          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                                          ^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#removeAt().
//                                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#HeaderPositionsAdapterDataObserver#sortHeaderAtIndex().(index)
            val headerIndex = findHeaderIndexOrNext(headerPos)
//              ^^^^^^^^^^^ definition local 55
//                          display_name headerIndex
//                          documentation ```kt\nval headerIndex: kotlin.Int\n```
//                            ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#findHeaderIndexOrNext().
//                                                  ^^^^^^^^^ reference local 54
            if (headerIndex != -1) {
//              ^^^^^^^^^^^ reference local 55
//                          ^^ reference semanticdb maven . . kotlin/Int#equals().
//                             ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                headerPositions.add(headerIndex, headerPos)
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add(+1).
//                                  ^^^^^^^^^^^ reference local 55
//                                               ^^^^^^^^^ reference local 54
            } else {
                headerPositions.add(headerPos)
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#getHeaderPositions().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/stickyheader/StickyHeaderLinearLayoutManager#headerPositions.
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                  ^^^^^^^^^ reference local 54
            }
        }
    }
}
