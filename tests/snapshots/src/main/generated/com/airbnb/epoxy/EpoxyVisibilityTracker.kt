package com.airbnb.epoxy
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/

import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^ reference androidx/annotation/IdRes#
import androidx.annotation.IntRange
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^^^^ reference androidx/annotation/IntRange#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import com.airbnb.viewmodeladapter.R
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
import java.util.ArrayList
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^^^ reference java/util/ArrayList#
import java.util.HashMap
//     ^^^^ reference java/
//          ^^^^ reference java/util/
//               ^^^^^^^ reference java/util/HashMap#

/**
 * A simple way to track visibility events on [com.airbnb.epoxy.EpoxyModel].
 *
 * [EpoxyVisibilityTracker] works with any [androidx.recyclerview.widget.RecyclerView]
 * backed by an Epoxy controller. Once attached the events will be forwarded to the Epoxy model (or
 * to the Epoxy view when using annotations).
 *
 * Note that support for visibility events on an [EpoxyModelGroup] is somewhat limited. Only model
 * additions will receive visibility events. Models that are removed from the group will not receive
 * events (e.g. [VisibilityState.INVISIBLE]) because the model group does not keep a reference,
 * nor does it get notified of model removals.
 *
 * @see OnVisibilityChanged
 *
 * @see OnVisibilityStateChanged
 *
 * @see OnModelVisibilityChangedListener
 *
 * @see OnModelVisibilityStateChangedListener
 */
class EpoxyVisibilityTracker {
//    ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#
//    ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#`<init>`().

    /**
     * Used to listen to [RecyclerView.ItemAnimator] ending animations.
     */
    private val itemAnimatorFinishedListener =
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#itemAnimatorFinishedListener.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getItemAnimatorFinishedListener().
        RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
            processChangeEvent(
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
                "ItemAnimatorFinishedListener.onAnimationsFinished",
                /* don't check item animator to prevent recursion */ false
            )
        }

    /** Maintain visibility item indexed by view id (identity hashcode)  */
    private val visibilityIdToItemMap = SparseArray<EpoxyVisibilityItem>()
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//                                                  ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#
    private val visibilityIdToItems: MutableList<EpoxyVisibilityItem> = ArrayList()
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                                   ^^^^^^^^^^^ reference kotlin/collections/MutableList#
//                                               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#
//                                                                      ^^^^^^^^^ reference java/util/ArrayList#`<init>`(+1).

    /** listener used to process scroll, layout and attach events  */
    private val listener = Listener()
//              ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//              ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                         ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#`<init>`().

    /** listener used to process data events  */
    private val observer = DataObserver()
//              ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
//              ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#`<init>`().

    private var attachedRecyclerView: RecyclerView? = null
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

    private var lastAdapterSeen: RecyclerView.Adapter<*>? = null
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().

    /** All nested visibility trackers  */
    private val nestedTrackers: MutableMap<RecyclerView, EpoxyVisibilityTracker> = HashMap()
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//                              ^^^^^^^^^^ reference kotlin/collections/MutableMap#
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#
//                                                                                 ^^^^^^^ reference java/util/HashMap#`<init>`(+2).

    /** This flag is for optimizing the process on detach. If detach is from data changed then it
     * need to re-process all views, else no need (ex: scroll). */
    private var visibleDataChanged = false
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().

    /**
     * Enable or disable visibility changed event. Default is `true`, disable it if you don't need
     * (triggered by every pixel scrolled).
     *
     * @see OnVisibilityChanged
     *
     * @see OnModelVisibilityChangedListener
     */
    var onChangedEnabled = true
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#onChangedEnabled.
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getOnChangedEnabled().
//      ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#setOnChangedEnabled().

    /**
     * Set the threshold of percentage visible area to identify the partial impression view state.
     *
     * @param thresholdPercentage Percentage of visible area of an element in the range [0..100].
     * Defaults to `null`, which disables
     * [VisibilityState.PARTIAL_IMPRESSION_VISIBLE] and
     * [VisibilityState.PARTIAL_IMPRESSION_INVISIBLE] events.
     */
    @IntRange(from = 0, to = 100)
//   ^^^^^^^^ reference androidx/annotation/IntRange#`<init>`().
//            ^^^^ reference androidx/annotation/IntRange#`<init>`().(from)
//                      ^^ reference androidx/annotation/IntRange#`<init>`().(to)
    var partialImpressionThresholdPercentage: Int? = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                            ^^^ reference kotlin/Int#

    /**
     * Attach the tracker.
     *
     * @param recyclerView The recyclerview that the EpoxyController has its adapter added to.
     */
    fun attach(recyclerView: RecyclerView) {
//      ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#attach().
//             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
        attachedRecyclerView = recyclerView
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
//                             ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
        recyclerView.addOnScrollListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        recyclerView.addOnLayoutChangeListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                             ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                             ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        recyclerView.addOnChildAttachStateChangeListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                                       ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        setTracker(recyclerView, this)
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                               ^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#
    }

    /**
     * Detach the tracker
     *
     * @param recyclerView The recycler view that the EpoxyController has its adapter added to.
     */
    fun detach(recyclerView: RecyclerView) {
//      ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#detach().
//             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
        recyclerView.removeOnScrollListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        recyclerView.removeOnLayoutChangeListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                                ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                                ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        recyclerView.removeOnChildAttachStateChangeListener(listener)
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                                                          ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
        setTracker(recyclerView, null)
//      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
        attachedRecyclerView = null
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
    }

    /**
     * The tracker is storing visibility states internally and is using if to send events, only the
     * difference is sent. Use this method to clear the states and thus regenerate the visibility
     * events. This may be useful when you change the adapter on the [RecyclerView].
     */
    fun clearVisibilityStates() {
//      ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#clearVisibilityStates().
        // Clear our visibility items
        visibilityIdToItemMap.clear()
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
        visibilityIdToItems.clear()
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                          ^^^^^ reference kotlin/collections/MutableList#clear().
    }

    /**
     * Calling this method will make the visibility tracking check and trigger events if necessary. It
     * is particularly useful when the visibility of an Epoxy model is changed outside of an Epoxy
     * RecyclerView.
     *
     * An example is when you nest an horizontal Epoxy backed RecyclerView in a non Epoxy vertical
     * RecyclerView. When the vertical RecyclerView scroll you want to notify the visibility tracker
     * attached on the horizontal RecyclerView.
     */
    fun requestVisibilityCheck() {
//      ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#requestVisibilityCheck().
        processChangeEvent("requestVisibilityCheck")
//      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
    }

    /**
     * Process a change event.
     * @param debug: string for debug usually the source of the call
     * @param checkItemAnimator: true if it need to check if ItemAnimator is running
     */
    private fun processChangeEvent(debug: String, checkItemAnimator: Boolean = true) {
//              ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
//                                 ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
//                                        ^^^^^^ reference kotlin/String#
//                                                ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(checkItemAnimator)
//                                                                   ^^^^^^^ reference kotlin/Boolean#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local0
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        val itemAnimator = recyclerView.itemAnimator
//          ^^^^^^^^^^^^ definition local1
//                         ^^^^^^^^^^^^ reference local0
        if (checkItemAnimator && itemAnimator != null) {
//          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(checkItemAnimator)
//                               ^^^^^^^^^^^^ reference local1
            // `itemAnimatorFinishedListener.onAnimationsFinished` will process visibility check
            // - If the animations are running `onAnimationsFinished` will be invoked on animations end.
            // - If the animations are not running `onAnimationsFinished` will be invoked right away.
            if (itemAnimator.isRunning(itemAnimatorFinishedListener)) {
//              ^^^^^^^^^^^^ reference local1
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#itemAnimatorFinishedListener.
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getItemAnimatorFinishedListener().
                // If running process visibility now as `onAnimationsFinished` was not yet called
                processChangeEventWithDetachedView(null, debug)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                       ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
            }
        } else {
            processChangeEventWithDetachedView(null, debug)
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                   ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
        }
    }

    private fun processChangeEventWithDetachedView(detachedView: View?, debug: String) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                 ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
//                                                                      ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)
//                                                                             ^^^^^^ reference kotlin/String#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local2
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        // On every every events lookup for a new adapter
        processNewAdapterIfNecessary()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processNewAdapterIfNecessary().

        // Process the detached child if any
        detachedView?.let { processChild(it, true, debug) }
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                                                 ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)

        // Process all attached children
        for (i in 0 until recyclerView.childCount) {
//           ^ definition local3
//                  ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^^^ reference local2
            val child = recyclerView.getChildAt(i)
//              ^^^^^ definition local4
//                      ^^^^^^^^^^^^ reference local2
//                                              ^ reference local3
            if (child != null && child !== detachedView) {
//              ^^^^^ reference local4
//                               ^^^^^ reference local4
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
                // Is some case the detached child is still in the recycler view. Don't process it as it
                // was already processed.
                processChild(child, false, debug)
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           ^^^^^ reference local4
//                                         ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)
            }
        }
    }

    /**
     * If there is a new adapter on the attached RecyclerView it will register the data observer and
     * clear the current visibility states
     */
    private fun processNewAdapterIfNecessary() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processNewAdapterIfNecessary().
        attachedRecyclerView?.adapter?.let { adapter ->
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
//                                           ^^^^^^^ definition local5
            if (lastAdapterSeen != adapter) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                 ^^^^^^^ reference local5
                // Unregister the old adapter
                lastAdapterSeen?.unregisterAdapterDataObserver(observer)
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                                             ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
//                                                             ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
                // Register the new adapter
                adapter.registerAdapterDataObserver(observer)
//              ^^^^^^^ reference local5
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
                lastAdapterSeen = adapter
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                ^^^^^^^ reference local5
            }
        }
    }

    /**
     * Don't call this method directly, it is called from
     * [EpoxyVisibilityTracker.processVisibilityEvents]
     *
     * @param child               the view to process for visibility event
     * @param detachEvent         true if the child was just detached
     * @param eventOriginForDebug a debug strings used for logs
     */
    private fun processChild(child: View, detachEvent: Boolean, eventOriginForDebug: String) {
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                        ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                     ^^^^^^^ reference kotlin/Boolean#
//                                                              ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
//                                                                                   ^^^^^^ reference kotlin/String#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local6
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        // Preemptive check for child's parent validity to prevent `IllegalArgumentException` in
        // `getChildViewHolder`.
        val isParentValid = child.parent == null || child.parent === recyclerView
//          ^^^^^^^^^^^^^ definition local7
//                          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                                  ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                                                   ^^^^^^^^^^^^ reference local6
        val viewHolder = if (isParentValid) recyclerView.getChildViewHolder(child) else null
//          ^^^^^^^^^^ definition local8
//                           ^^^^^^^^^^^^^ reference local7
//                                          ^^^^^^^^^^^^ reference local6
//                                                                          ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
        if (viewHolder is EpoxyViewHolder) {
//          ^^^^^^^^^^ reference local8
            val epoxyHolder = viewHolder.holder
//              ^^^^^^^^^^^ definition local9
//                            ^^^^^^^^^^ reference local8
            processChild(recyclerView, child, detachEvent, eventOriginForDebug, viewHolder)
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
//                       ^^^^^^^^^^^^ reference local6
//                                     ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                         ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
//                                                                              ^^^^^^^^^^ reference local8
            if (epoxyHolder is ModelGroupHolder) {
//              ^^^^^^^^^^^ reference local9
//                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#
                processModelGroupChildren(recyclerView, epoxyHolder, detachEvent, eventOriginForDebug)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().
//                                        ^^^^^^^^^^^^ reference local6
//                                                      ^^^^^^^^^^^ reference local9
//                                                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                                                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
            }
        }
    }

    /**
     * Loop through the children of the model group and process visibility events on each one in
     * relation to the model group's layout. This will attach or detach trackers to any nested
     * [RecyclerView]s.
     *
     * @param epoxyHolder         the [ModelGroupHolder] with children to process
     * @param detachEvent         true if the child was just detached
     * @param eventOriginForDebug a debug strings used for logs
     */
    private fun processModelGroupChildren(
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(recyclerView)
        epoxyHolder: ModelGroupHolder,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(epoxyHolder)
//                   ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
//                   ^^^^^^^ reference kotlin/Boolean#
        eventOriginForDebug: String
//      ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(eventOriginForDebug)
//                           ^^^^^^ reference kotlin/String#
    ) {
        // Iterate through models in the group and process each of them instead of the group
        for (groupChildHolder in epoxyHolder.viewHolders) {
//           ^^^^^^^^^^^^^^^^ definition local10
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(epoxyHolder)
//                                           ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#viewHolders.
//                                           ^^^^^^^^^^^ reference com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
            // Since the group is likely using a ViewGroup other than a RecyclerView, handle the
            // potential of a nested RecyclerView. This cannot be done through the normal flow
            // without recursively searching through the view children.
            if (groupChildHolder.itemView is RecyclerView) {
//              ^^^^^^^^^^^^^^^^ reference local10
                if (detachEvent) {
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
                    processChildRecyclerViewDetached(groupChildHolder.itemView)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                                   ^^^^^^^^^^^^^^^^ reference local10
                } else {
                    processChildRecyclerViewAttached(groupChildHolder.itemView)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                                   ^^^^^^^^^^^^^^^^ reference local10
                }
            }
            processChild(
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
                recyclerView,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(recyclerView)
                groupChildHolder.itemView,
//              ^^^^^^^^^^^^^^^^ reference local10
                detachEvent,
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
                eventOriginForDebug,
//              ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(eventOriginForDebug)
                groupChildHolder
//              ^^^^^^^^^^^^^^^^ reference local10
            )
        }
    }

    /**
     * Process visibility events for a view and propagate to a nested tracker if the view is a
     * [RecyclerView].
     *
     * @param child               the view to process for visibility event
     * @param detachEvent         true if the child was just detached
     * @param eventOriginForDebug a debug strings used for logs
     * @param viewHolder          the view holder for the child view
     */
    private fun processChild(
//              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(recyclerView)
        child: View,
//      ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(detachEvent)
//                   ^^^^^^^ reference kotlin/Boolean#
        eventOriginForDebug: String,
//      ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(eventOriginForDebug)
//                           ^^^^^^ reference kotlin/String#
        viewHolder: EpoxyViewHolder
//      ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(viewHolder)
    ) {
        val changed = processVisibilityEvents(
//          ^^^^^^^ definition local11
//                    ^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().
            recyclerView,
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(recyclerView)
            viewHolder,
//          ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(viewHolder)
            detachEvent,
//          ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(detachEvent)
            eventOriginForDebug
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(eventOriginForDebug)
        )
        if (changed && child is RecyclerView) {
//          ^^^^^^^ reference local11
//                     ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
            nestedTrackers[child]?.processChangeEvent("parent")
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//                         ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
//                                 ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
        }
    }

    /**
     * Call this methods every time something related to ui (scroll, layout, ...) or something related
     * to data changed.
     *
     * @param recyclerView        the recycler view
     * @param epoxyHolder         the [RecyclerView]
     * @param detachEvent         true if the event originated from a view detached from the
     * recycler view
     * @param eventOriginForDebug a debug strings used for logs
     * @return true if changed
     */
    private fun processVisibilityEvents(
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(recyclerView)
        epoxyHolder: EpoxyViewHolder,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
//                   ^^^^^^^ reference kotlin/Boolean#
        eventOriginForDebug: String
//      ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(eventOriginForDebug)
//                           ^^^^^^ reference kotlin/String#
    ): Boolean {
//     ^^^^^^^ reference kotlin/Boolean#
        if (DEBUG_LOG) {
//          ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//          ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
            Log.d(
                TAG,
//              ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//              ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
                "$eventOriginForDebug.processVisibilityEvents " +
//                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(eventOriginForDebug)
//                                                              ^ reference kotlin/String#plus().
                    "${System.identityHashCode(epoxyHolder)}, " +
//                     ^^^^^^ reference java/lang/System#
//                            ^^^^^^^^^^^^^^^^ reference java/lang/System#identityHashCode().
//                                             ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                              ^ reference kotlin/String#plus().
                    "$detachEvent, ${epoxyHolder.adapterPosition}"
//                    ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
//                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            )
        }
        val itemView = epoxyHolder.itemView
//          ^^^^^^^^ definition local12
//                     ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        val id = System.identityHashCode(itemView)
//          ^^ definition local13
//               ^^^^^^ reference java/lang/System#
//                      ^^^^^^^^^^^^^^^^ reference java/lang/System#identityHashCode().
//                                       ^^^^^^^^ reference local12
        var vi = visibilityIdToItemMap[id]
//          ^^ definition local14
//               ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//               ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//                                     ^^ reference local13
        if (vi == null) {
//          ^^ reference local14
            // New view discovered, assign an EpoxyVisibilityItem
            vi = EpoxyVisibilityItem(epoxyHolder.adapterPosition)
//          ^^ reference local14
//               ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().
//                                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            visibilityIdToItemMap.put(id, vi)
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//                                    ^^ reference local13
//                                        ^^ reference local14
            visibilityIdToItems.add(vi)
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                              ^^^ reference kotlin/collections/MutableList#add().
//                                  ^^ reference local14
        } else if (epoxyHolder.adapterPosition != RecyclerView.NO_POSITION &&
//                 ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            vi.adapterPosition != epoxyHolder.adapterPosition
//          ^^ reference local14
//                                ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        ) {
            // EpoxyVisibilityItem being re-used for a different adapter position
            vi.reset(epoxyHolder.adapterPosition)
//          ^^ reference local14
//                   ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        }
        var changed = false
//          ^^^^^^^ definition local15
        if (vi.update(itemView, recyclerView, detachEvent)) {
//          ^^ reference local14
//                    ^^^^^^^^ reference local12
//                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(recyclerView)
//                                            ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            // View is measured, process events
            vi.handleVisible(epoxyHolder, detachEvent)
//          ^^ reference local14
//                           ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                        ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            partialImpressionThresholdPercentage?.let { percentage ->
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                                ^^^ reference kotlin/StandardKt#let().
//                                                      ^^^^^^^^^^ definition local16
                vi.handlePartialImpressionVisible(
//              ^^ reference local14
                    epoxyHolder, detachEvent,
//                  ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                               ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
                    percentage
//                  ^^^^^^^^^^ reference local16
                )
            }
            vi.handleFocus(epoxyHolder, detachEvent)
//          ^^ reference local14
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            vi.handleFullImpressionVisible(epoxyHolder, detachEvent)
//          ^^ reference local14
//                                         ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                      ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            changed = vi.handleChanged(epoxyHolder, onChangedEnabled)
//          ^^^^^^^ reference local15
//                    ^^ reference local14
//                                     ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#onChangedEnabled.
//                                                  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getOnChangedEnabled().
//                                                  ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setOnChangedEnabled().
        }
        return changed
//             ^^^^^^^ reference local15
    }

    private fun processChildRecyclerViewAttached(childRecyclerView: RecyclerView) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
        // Register itself in the EpoxyVisibilityTracker. This will take care of nested list
        // tracking (ex: carousel)
        val tracker = getTracker(childRecyclerView) ?: EpoxyVisibilityTracker().let { nested ->
//          ^^^^^^^ definition local17
//                    ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().
//                               ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#`<init>`().
//                                                                              ^^^ reference kotlin/StandardKt#let().
//                                                                                    ^^^^^^ definition local18
            nested.partialImpressionThresholdPercentage = partialImpressionThresholdPercentage
//          ^^^^^^ reference local18
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
            nested.attach(childRecyclerView)
//          ^^^^^^ reference local18
//                 ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attach().
//                        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
            nested
//          ^^^^^^ reference local18
        }
        nestedTrackers[childRecyclerView] = tracker
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//                     ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
//                                          ^^^^^^^ reference local17
    }

    private fun processChildRecyclerViewDetached(childRecyclerView: RecyclerView) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                               ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().(childRecyclerView)
        nestedTrackers.remove(childRecyclerView)
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//                     ^^^^^^ reference kotlin/collections/MutableMap#remove().
//                            ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().(childRecyclerView)
    }

    /**
     * Helper class that host the [androidx.recyclerview.widget.RecyclerView] listener
     * implementations
     */
    private inner class Listener :
//                      ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#
//                      ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#`<init>`().
        RecyclerView.OnScrollListener(),
        View.OnLayoutChangeListener,
        RecyclerView.OnChildAttachStateChangeListener {
        override fun onLayoutChange(
//                   ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().
            recyclerView: View,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(recyclerView)
            left: Int,
//          ^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(left)
//                ^^^ reference kotlin/Int#
            top: Int,
//          ^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(top)
//               ^^^ reference kotlin/Int#
            right: Int,
//          ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(right)
//                 ^^^ reference kotlin/Int#
            bottom: Int,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(bottom)
//                  ^^^ reference kotlin/Int#
            oldLeft: Int,
//          ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldLeft)
//                   ^^^ reference kotlin/Int#
            oldTop: Int,
//          ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldTop)
//                  ^^^ reference kotlin/Int#
            oldRight: Int,
//          ^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldRight)
//                    ^^^ reference kotlin/Int#
            oldBottom: Int
//          ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldBottom)
//                     ^^^ reference kotlin/Int#
        ) {
            processChangeEvent("onLayoutChange")
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                   ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().
//                              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(recyclerView)
//                                                          ^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(dx)
//                                                              ^^^ reference kotlin/Int#
//                                                                   ^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(dy)
//                                                                       ^^^ reference kotlin/Int#
            processChangeEvent("onScrolled")
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
        }

        override fun onChildViewAttachedToWindow(child: View) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().
//                                               ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
            if (child is RecyclerView) {
//              ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
                processChildRecyclerViewAttached(child)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
            }
            processChild(child, false, "onChildViewAttachedToWindow")
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                       ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
        }

        override fun onChildViewDetachedFromWindow(child: View) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().
//                                                 ^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
            if (child is RecyclerView) {
//              ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
                processChildRecyclerViewDetached(child)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                               ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
            }
            if (visibleDataChanged) {
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                // On detach event caused by data set changed we need to re-process all children because
                // the removal caused the others views to changes.
                processChangeEventWithDetachedView(child, "onChildViewDetachedFromWindow")
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                 ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
                visibleDataChanged = false
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
            } else {
                processChild(child, true, "onChildViewDetachedFromWindow")
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           ^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
            }
        }
    }

    /**
     * The layout/scroll events are not enough to detect all sort of visibility changes. We also
     * need to look at the data events from the adapter.
     */
    internal inner class DataObserver : RecyclerView.AdapterDataObserver() {
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#
//                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#`<init>`().
        /**
         * Clear the current visibility statues
         */
        override fun onChanged() {
//                   ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onChanged().
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onChanged()")
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
            }
            visibilityIdToItemMap.clear()
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
            visibilityIdToItems.clear()
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                              ^^^^^ reference kotlin/collections/MutableList#clear().
            visibleDataChanged = true
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//          ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
        }

        /**
         * For all items after the inserted range shift each [EpoxyVisibilityTracker] adapter
         * position by inserted item count.
         */
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().
//                                       ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
//                                                      ^^^ reference kotlin/Int#
//                                                           ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
//                                                                      ^^^ reference kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeInserted($positionStart, $itemCount)")
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                               ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
//                                                               ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local19
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
                if (item.adapterPosition >= positionStart) {
//                  ^^^^ reference local19
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                                          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                    item.shiftBy(itemCount)
//                  ^^^^ reference local19
//                       ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
                }
            }
        }

        /**
         * For all items after the removed range reverse-shift each [EpoxyVisibilityTracker]
         * adapter position by removed item count
         */
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().
//                                      ^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
//                                                     ^^^ reference kotlin/Int#
//                                                          ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
//                                                                     ^^^ reference kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeRemoved($positionStart, $itemCount)")
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                              ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
//                                                              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local20
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
                if (item.adapterPosition >= positionStart) {
//                  ^^^^ reference local20
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                       ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                                          ^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                    item.shiftBy(-itemCount)
//                  ^^^^ reference local20
//                       ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^ reference kotlin/Int#unaryMinus().
//                                ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
                }
            }
        }

        /**
         * This is a bit more complex, for move we need to first swap the moved position then shift the
         * items between the swap. To simplify we split any range passed to individual item moved.
         *
         * ps: anyway [androidx.recyclerview.widget.AdapterListUpdateCallback]
         * does not seem to use range for moved items.
         */
        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().
//                                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(fromPosition)
//                                                  ^^^ reference kotlin/Int#
//                                                       ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(toPosition)
//                                                                   ^^^ reference kotlin/Int#
//                                                                        ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(itemCount)
//                                                                                   ^^^ reference kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            for (i in 0 until itemCount) {
//               ^ definition local21
//                      ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(itemCount)
                onItemMoved(fromPosition + i, toPosition + i)
//              ^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(fromPosition)
//                                       ^ reference kotlin/Int#plus(+3).
//                                         ^ reference local21
//                                            ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(toPosition)
//                                                       ^ reference kotlin/Int#plus(+3).
//                                                         ^ reference local21
            }
        }

        private fun onItemMoved(fromPosition: Int, toPosition: Int) {
//                  ^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().
//                              ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                            ^^^ reference kotlin/Int#
//                                                 ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                                             ^^^ reference kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeMoved($fromPosition, $fromPosition, 1)")
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                                           ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local22
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                       ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
                val position = item.adapterPosition
//                  ^^^^^^^^ definition local23
//                             ^^^^ reference local22
//                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                                  ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
                if (position == fromPosition) {
//                  ^^^^^^^^ reference local23
//                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                    // We found the item to be moved, just swap the position.
                    item.shiftBy(toPosition - fromPosition)
//                  ^^^^ reference local22
//                       ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                          ^ reference kotlin/Int#minus(+3).
//                                            ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                } else if (fromPosition < toPosition) {
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                    // Item will be moved down in the list
                    if (position in (fromPosition + 1)..toPosition) {
//                      ^^^^^^^^ reference local23
//                               ^^ reference kotlin/ranges/IntRange#contains().
//                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                                ^ reference kotlin/Int#plus(+3).
//                                                    ^^ reference kotlin/Int#rangeTo(+1).
//                                                      ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                        // Item is between the moved from and to indexes, it should move up
                        item.shiftBy(-1)
//                      ^^^^ reference local22
//                           ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                                   ^ reference kotlin/Int#unaryMinus().
                        visibleDataChanged = true
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                    }
                } else if (fromPosition > toPosition) {
//                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                      ^ reference kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                    // Item will be moved up in the list
                    if (position in toPosition until fromPosition) {
//                      ^^^^^^^^ reference local23
//                               ^^ reference kotlin/ranges/IntRange#contains().
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                             ^^^^^ reference kotlin/ranges/RangesKt#until(+6).
//                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                        // Item is between the moved to and from indexes, it should move down
                        item.shiftBy(1)
//                      ^^^^ reference local22
//                           ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
                        visibleDataChanged = true
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
                    }
                }
            }
        }

        /**
         * @param recyclerView the recycler view
         * @return true if managed by an [BaseEpoxyAdapter]
         */
        private fun notEpoxyManaged(recyclerView: RecyclerView?): Boolean {
//                  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                                  ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
//                                                                ^^^^^^^ reference kotlin/Boolean#
            return recyclerView == null || recyclerView.adapter !is BaseEpoxyAdapter
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
//                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
        }
    }

    companion object {
//            ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#
        private const val TAG = "EpoxyVisibilityTracker"
//                        ^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                        ^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().

        @IdRes
//       ^^^^^ reference androidx/annotation/IdRes#`<init>`().
        private val TAG_ID = R.id.epoxy_visibility_tracker
//                  ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                  ^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().

        /**
         * @param recyclerView the view.
         * @return the tracker for the given [RecyclerView]. Null if no tracker was attached.
         */
        private fun getTracker(recyclerView: RecyclerView): EpoxyVisibilityTracker? {
//                  ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().
//                             ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().(recyclerView)
//                                                          ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#
            return recyclerView.getTag(TAG_ID) as EpoxyVisibilityTracker?
//                 ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().(recyclerView)
//                                     ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                                     ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#
        }

        /**
         * Store the tracker for the given [RecyclerView].
         * @param recyclerView the view
         * @param tracker the tracker
         */
        private fun setTracker(
//                  ^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
            recyclerView: RecyclerView,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(recyclerView)
            tracker: EpoxyVisibilityTracker?
//          ^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(tracker)
//                   ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#
        ) {
            recyclerView.setTag(TAG_ID, tracker)
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(recyclerView)
//                              ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                              ^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().
//                                      ^^^^^^^ reference com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(tracker)
        }

        // Not actionable at runtime. It is only useful for internal test-troubleshooting.
        const val DEBUG_LOG = false
//                ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//                ^^^^^^^^^ definition com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
    }
}
