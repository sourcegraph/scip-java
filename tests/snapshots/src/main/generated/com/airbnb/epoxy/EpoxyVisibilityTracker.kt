package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.util.Log
import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IdRes#
import androidx.annotation.IntRange
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.viewmodeladapter.R
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
import java.util.ArrayList
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#
import java.util.HashMap
//     ^^^^ reference semanticdb maven . . java/
//          ^^^^ reference semanticdb maven . . java/util/
//               ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#

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
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
//                           documentation ```kt\npublic final class EpoxyVisibilityTracker\n```\n\n----\n\n\n A simple way to track visibility events on [com.airbnb.epoxy.EpoxyModel].\n\n [EpoxyVisibilityTracker] works with any [androidx.recyclerview.widget.RecyclerView]\n backed by an Epoxy controller. Once attached the events will be forwarded to the Epoxy model (or\n to the Epoxy view when using annotations).\n\n Note that support for visibility events on an [EpoxyModelGroup] is somewhat limited. Only model\n additions will receive visibility events. Models that are removed from the group will not receive\n events (e.g. [VisibilityState.INVISIBLE]) because the model group does not keep a reference,\n nor does it get notified of model removals.\n\n @see OnVisibilityChanged\n\n @see OnVisibilityStateChanged\n\n @see OnModelVisibilityChangedListener\n\n @see OnModelVisibilityStateChangedListener\n
//    ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#`<init>`().
//                           documentation ```kt\npublic constructor EpoxyVisibilityTracker()\n```\n\n----\n\n\n A simple way to track visibility events on [com.airbnb.epoxy.EpoxyModel].\n\n [EpoxyVisibilityTracker] works with any [androidx.recyclerview.widget.RecyclerView]\n backed by an Epoxy controller. Once attached the events will be forwarded to the Epoxy model (or\n to the Epoxy view when using annotations).\n\n Note that support for visibility events on an [EpoxyModelGroup] is somewhat limited. Only model\n additions will receive visibility events. Models that are removed from the group will not receive\n events (e.g. [VisibilityState.INVISIBLE]) because the model group does not keep a reference,\n nor does it get notified of model removals.\n\n @see OnVisibilityChanged\n\n @see OnVisibilityStateChanged\n\n @see OnModelVisibilityChangedListener\n\n @see OnModelVisibilityStateChangedListener\n

    /**
     * Used to listen to [RecyclerView.ItemAnimator] ending animations.
     */
    private val itemAnimatorFinishedListener =
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getItemAnimatorFinishedListener().
//                                           documentation ```kt\nprivate final val itemAnimatorFinishedListener: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```\n\n----\n\n\n Used to listen to [RecyclerView.ItemAnimator] ending animations.\n
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#itemAnimatorFinishedListener.
//                                           documentation ```kt\nprivate final val itemAnimatorFinishedListener: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```\n\n----\n\n\n Used to listen to [RecyclerView.ItemAnimator] ending animations.\n
        RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
            processChangeEvent(
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
                "ItemAnimatorFinishedListener.onAnimationsFinished",
                /* don't check item animator to prevent recursion */ false
            )
        }

    /** Maintain visibility item indexed by view id (identity hashcode)  */
    private val visibilityIdToItemMap = SparseArray<EpoxyVisibilityItem>()
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//                                    documentation ```kt\nprivate final val visibilityIdToItemMap: [ERROR : Type for SparseArray<EpoxyVisibilityItem>()]\n```\n\n----\n\n Maintain visibility item indexed by view id (identity hashcode)
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//                                    documentation ```kt\nprivate final val visibilityIdToItemMap: [ERROR : Type for SparseArray<EpoxyVisibilityItem>()]\n```\n\n----\n\n Maintain visibility item indexed by view id (identity hashcode)
//                                                  ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#
    private val visibilityIdToItems: MutableList<EpoxyVisibilityItem> = ArrayList()
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                                  documentation ```kt\nprivate final val visibilityIdToItems: kotlin.collections.MutableList<com.airbnb.epoxy.EpoxyVisibilityItem>\n```
//              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                                  documentation ```kt\nprivate final val visibilityIdToItems: kotlin.collections.MutableList<com.airbnb.epoxy.EpoxyVisibilityItem>\n```
//                                   ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#
//                                                                      ^^^^^^^^^ reference semanticdb maven jdk 11 java/util/ArrayList#`<init>`(+1).

    /** listener used to process scroll, layout and attach events  */
    private val listener = Listener()
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                       documentation ```kt\nprivate final val listener: com.airbnb.epoxy.EpoxyVisibilityTracker.Listener\n```\n\n----\n\n listener used to process scroll, layout and attach events
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
//                       documentation ```kt\nprivate final val listener: com.airbnb.epoxy.EpoxyVisibilityTracker.Listener\n```\n\n----\n\n listener used to process scroll, layout and attach events
//                         ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#`<init>`().

    /** listener used to process data events  */
    private val observer = DataObserver()
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
//                       documentation ```kt\nprivate final val observer: com.airbnb.epoxy.EpoxyVisibilityTracker.DataObserver\n```\n\n----\n\n listener used to process data events
//              ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
//                       documentation ```kt\nprivate final val observer: com.airbnb.epoxy.EpoxyVisibilityTracker.DataObserver\n```\n\n----\n\n listener used to process data events
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#`<init>`().

    private var attachedRecyclerView: RecyclerView? = null
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                                   documentation ```kt\nprivate final var attachedRecyclerView: [ERROR : RecyclerView]?\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                                   documentation ```kt\nprivate final var attachedRecyclerView: [ERROR : RecyclerView]?\n```
//              ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
//                                   documentation ```kt\nprivate final var attachedRecyclerView: [ERROR : RecyclerView]?\n```

    private var lastAdapterSeen: RecyclerView.Adapter<*>? = null
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//                              documentation ```kt\nprivate final var lastAdapterSeen: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//                              documentation ```kt\nprivate final var lastAdapterSeen: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                              documentation ```kt\nprivate final var lastAdapterSeen: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```

    /** All nested visibility trackers  */
    private val nestedTrackers: MutableMap<RecyclerView, EpoxyVisibilityTracker> = HashMap()
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//                             documentation ```kt\nprivate final val nestedTrackers: kotlin.collections.MutableMap<[ERROR : RecyclerView], com.airbnb.epoxy.EpoxyVisibilityTracker>\n```\n\n----\n\n All nested visibility trackers
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//                             documentation ```kt\nprivate final val nestedTrackers: kotlin.collections.MutableMap<[ERROR : RecyclerView], com.airbnb.epoxy.EpoxyVisibilityTracker>\n```\n\n----\n\n All nested visibility trackers
//                              ^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#
//                                                       ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
//                                                                                 ^^^^^^^ reference semanticdb maven jdk 11 java/util/HashMap#`<init>`(+2).

    /** This flag is for optimizing the process on detach. If detach is from data changed then it
     * need to re-process all views, else no need (ex: scroll). */
    private var visibleDataChanged = false
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                                 documentation ```kt\nprivate final var visibleDataChanged: kotlin.Boolean\n```\n\n----\n\n This flag is for optimizing the process on detach. If detach is from data changed then it\n need to re-process all views, else no need (ex: scroll).
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                                 documentation ```kt\nprivate final var visibleDataChanged: kotlin.Boolean\n```\n\n----\n\n This flag is for optimizing the process on detach. If detach is from data changed then it\n need to re-process all views, else no need (ex: scroll).
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
//                                 documentation ```kt\nprivate final var visibleDataChanged: kotlin.Boolean\n```\n\n----\n\n This flag is for optimizing the process on detach. If detach is from data changed then it\n need to re-process all views, else no need (ex: scroll).

    /**
     * Enable or disable visibility changed event. Default is `true`, disable it if you don't need
     * (triggered by every pixel scrolled).
     *
     * @see OnVisibilityChanged
     *
     * @see OnModelVisibilityChangedListener
     */
    var onChangedEnabled = true
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getOnChangedEnabled().
//                       documentation ```kt\npublic final var onChangedEnabled: kotlin.Boolean\n```\n\n----\n\n\n Enable or disable visibility changed event. Default is `true`, disable it if you don't need\n (triggered by every pixel scrolled).\n\n @see OnVisibilityChanged\n\n @see OnModelVisibilityChangedListener\n
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#onChangedEnabled.
//                       documentation ```kt\npublic final var onChangedEnabled: kotlin.Boolean\n```\n\n----\n\n\n Enable or disable visibility changed event. Default is `true`, disable it if you don't need\n (triggered by every pixel scrolled).\n\n @see OnVisibilityChanged\n\n @see OnModelVisibilityChangedListener\n
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setOnChangedEnabled().
//                       documentation ```kt\npublic final var onChangedEnabled: kotlin.Boolean\n```\n\n----\n\n\n Enable or disable visibility changed event. Default is `true`, disable it if you don't need\n (triggered by every pixel scrolled).\n\n @see OnVisibilityChanged\n\n @see OnModelVisibilityChangedListener\n

    /**
     * Set the threshold of percentage visible area to identify the partial impression view state.
     *
     * @param thresholdPercentage Percentage of visible area of an element in the range [0..100].
     * Defaults to `null`, which disables
     * [VisibilityState.PARTIAL_IMPRESSION_VISIBLE] and
     * [VisibilityState.PARTIAL_IMPRESSION_INVISIBLE] events.
     */
    @IntRange(from = 0, to = 100)
//   ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().
//            ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(from)
//                      ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IntRange#`<init>`().(to)
    var partialImpressionThresholdPercentage: Int? = null
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//                                           documentation ```kt\npublic final var partialImpressionThresholdPercentage: kotlin.Int?\n```\n\n----\n\n\n Set the threshold of percentage visible area to identify the partial impression view state.\n\n @param thresholdPercentage Percentage of visible area of an element in the range [0..100].\n Defaults to `null`, which disables\n [VisibilityState.PARTIAL_IMPRESSION_VISIBLE] and\n [VisibilityState.PARTIAL_IMPRESSION_INVISIBLE] events.\n
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//                                           documentation ```kt\npublic final var partialImpressionThresholdPercentage: kotlin.Int?\n```\n\n----\n\n\n Set the threshold of percentage visible area to identify the partial impression view state.\n\n @param thresholdPercentage Percentage of visible area of an element in the range [0..100].\n Defaults to `null`, which disables\n [VisibilityState.PARTIAL_IMPRESSION_VISIBLE] and\n [VisibilityState.PARTIAL_IMPRESSION_INVISIBLE] events.\n
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                           documentation ```kt\npublic final var partialImpressionThresholdPercentage: kotlin.Int?\n```\n\n----\n\n\n Set the threshold of percentage visible area to identify the partial impression view state.\n\n @param thresholdPercentage Percentage of visible area of an element in the range [0..100].\n Defaults to `null`, which disables\n [VisibilityState.PARTIAL_IMPRESSION_VISIBLE] and\n [VisibilityState.PARTIAL_IMPRESSION_INVISIBLE] events.\n
//                                            ^^^ reference semanticdb maven . . kotlin/Int#

    /**
     * Attach the tracker.
     *
     * @param recyclerView The recyclerview that the EpoxyController has its adapter added to.
     */
    fun attach(recyclerView: RecyclerView) {
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().
//             documentation ```kt\npublic final fun attach(recyclerView: [ERROR : RecyclerView])\n```\n\n----\n\n\n Attach the tracker.\n\n @param recyclerView The recyclerview that the EpoxyController has its adapter added to.\n
//             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                          documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
        attachedRecyclerView = recyclerView
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
//                             ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
        recyclerView.addOnScrollListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        recyclerView.addOnLayoutChangeListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        recyclerView.addOnChildAttachStateChangeListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                                       ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        setTracker(recyclerView, this)
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().(recyclerView)
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
    }

    /**
     * Detach the tracker
     *
     * @param recyclerView The recycler view that the EpoxyController has its adapter added to.
     */
    fun detach(recyclerView: RecyclerView) {
//      ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().
//             documentation ```kt\npublic final fun detach(recyclerView: [ERROR : RecyclerView])\n```\n\n----\n\n\n Detach the tracker\n\n @param recyclerView The recycler view that the EpoxyController has its adapter added to.\n
//             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                          documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
        recyclerView.removeOnScrollListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        recyclerView.removeOnLayoutChangeListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        recyclerView.removeOnChildAttachStateChangeListener(listener)
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
//                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getListener().
//                                                          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#listener.
        setTracker(recyclerView, null)
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#detach().(recyclerView)
        attachedRecyclerView = null
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
    }

    /**
     * The tracker is storing visibility states internally and is using if to send events, only the
     * difference is sent. Use this method to clear the states and thus regenerate the visibility
     * events. This may be useful when you change the adapter on the [RecyclerView].
     */
    fun clearVisibilityStates() {
//      ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#clearVisibilityStates().
//                            documentation ```kt\npublic final fun clearVisibilityStates()\n```\n\n----\n\n\n The tracker is storing visibility states internally and is using if to send events, only the\n difference is sent. Use this method to clear the states and thus regenerate the visibility\n events. This may be useful when you change the adapter on the [RecyclerView].\n
        // Clear our visibility items
        visibilityIdToItemMap.clear()
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//      ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
        visibilityIdToItems.clear()
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//      ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                          ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
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
//      ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#requestVisibilityCheck().
//                             documentation ```kt\npublic final fun requestVisibilityCheck()\n```\n\n----\n\n\n Calling this method will make the visibility tracking check and trigger events if necessary. It\n is particularly useful when the visibility of an Epoxy model is changed outside of an Epoxy\n RecyclerView.\n\n An example is when you nest an horizontal Epoxy backed RecyclerView in a non Epoxy vertical\n RecyclerView. When the vertical RecyclerView scroll you want to notify the visibility tracker\n attached on the horizontal RecyclerView.\n
        processChangeEvent("requestVisibilityCheck")
//      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
    }

    /**
     * Process a change event.
     * @param debug: string for debug usually the source of the call
     * @param checkItemAnimator: true if it need to check if ItemAnimator is running
     */
    private fun processChangeEvent(debug: String, checkItemAnimator: Boolean = true) {
//              ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
//                                 documentation ```kt\nprivate final fun processChangeEvent(debug: kotlin.String, checkItemAnimator: kotlin.Boolean = ...)\n```\n\n----\n\n\n Process a change event.\n @param debug: string for debug usually the source of the call\n @param checkItemAnimator: true if it need to check if ItemAnimator is running\n
//                                 ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
//                                       documentation ```kt\nvalue-parameter debug: kotlin.String\n```
//                                        ^^^^^^ reference semanticdb maven . . kotlin/String#
//                                                ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(checkItemAnimator)
//                                                                  documentation ```kt\nvalue-parameter checkItemAnimator: kotlin.Boolean = ...\n```
//                                                                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local 0
//                       documentation ```kt\nval recyclerView: kotlin.Nothing\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        val itemAnimator = recyclerView.itemAnimator
//          ^^^^^^^^^^^^ definition local 1
//                       documentation ```kt\nval itemAnimator: [ERROR : Type for recyclerView.itemAnimator]\n```
//                         ^^^^^^^^^^^^ reference local 0
        if (checkItemAnimator && itemAnimator != null) {
//          ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(checkItemAnimator)
//                               ^^^^^^^^^^^^ reference local 1
            // `itemAnimatorFinishedListener.onAnimationsFinished` will process visibility check
            // - If the animations are running `onAnimationsFinished` will be invoked on animations end.
            // - If the animations are not running `onAnimationsFinished` will be invoked right away.
            if (itemAnimator.isRunning(itemAnimatorFinishedListener)) {
//              ^^^^^^^^^^^^ reference local 1
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getItemAnimatorFinishedListener().
//                                     ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#itemAnimatorFinishedListener.
                // If running process visibility now as `onAnimationsFinished` was not yet called
                processChangeEventWithDetachedView(null, debug)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
            }
        } else {
            processChangeEventWithDetachedView(null, debug)
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                   ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().(debug)
        }
    }

    private fun processChangeEventWithDetachedView(detachedView: View?, debug: String) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                 documentation ```kt\nprivate final fun processChangeEventWithDetachedView(detachedView: [ERROR : View]?, debug: kotlin.String)\n```
//                                                 ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
//                                                              documentation ```kt\nvalue-parameter detachedView: [ERROR : View]?\n```
//                                                                      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)
//                                                                            documentation ```kt\nvalue-parameter debug: kotlin.String\n```
//                                                                             ^^^^^^ reference semanticdb maven . . kotlin/String#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local 2
//                       documentation ```kt\nval recyclerView: kotlin.Nothing\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        // On every every events lookup for a new adapter
        processNewAdapterIfNecessary()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processNewAdapterIfNecessary().

        // Process the detached child if any
        detachedView?.let { processChild(it, true, debug) }
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)

        // Process all attached children
        for (i in 0 until recyclerView.childCount) {
//           ^ definition local 3
//             documentation ```kt\nval i: kotlin.Int\n```
//                  ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                        ^^^^^^^^^^^^ reference local 2
            val child = recyclerView.getChildAt(i)
//              ^^^^^ definition local 4
//                    documentation ```kt\nval child: [ERROR : Type for recyclerView.getChildAt(i)]\n```
//                      ^^^^^^^^^^^^ reference local 2
//                                              ^ reference local 3
            if (child != null && child !== detachedView) {
//              ^^^^^ reference local 4
//                               ^^^^^ reference local 4
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(detachedView)
                // Is some case the detached child is still in the recycler view. Don't process it as it
                // was already processed.
                processChild(child, false, debug)
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           ^^^^^ reference local 4
//                                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().(debug)
            }
        }
    }

    /**
     * If there is a new adapter on the attached RecyclerView it will register the data observer and
     * clear the current visibility states
     */
    private fun processNewAdapterIfNecessary() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processNewAdapterIfNecessary().
//                                           documentation ```kt\nprivate final fun processNewAdapterIfNecessary()\n```\n\n----\n\n\n If there is a new adapter on the attached RecyclerView it will register the data observer and\n clear the current visibility states\n
        attachedRecyclerView?.adapter?.let { adapter ->
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
//                                           ^^^^^^^ definition local 5
//                                                   documentation ```kt\nvalue-parameter adapter: [ERROR : <Unknown lambda parameter type>]\n```
            if (lastAdapterSeen != adapter) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                 ^^^^^^^ reference local 5
                // Unregister the old adapter
                lastAdapterSeen?.unregisterAdapterDataObserver(observer)
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
//                                                             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
                // Register the new adapter
                adapter.registerAdapterDataObserver(observer)
//              ^^^^^^^ reference local 5
//                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getObserver().
//                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#observer.
                lastAdapterSeen = adapter
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getLastAdapterSeen().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#lastAdapterSeen.
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setLastAdapterSeen().
//                                ^^^^^^^ reference local 5
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
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           documentation ```kt\nprivate final fun processChild(child: [ERROR : View], detachEvent: kotlin.Boolean, eventOriginForDebug: kotlin.String)\n```\n\n----\n\n\n Don't call this method directly, it is called from\n [EpoxyVisibilityTracker.processVisibilityEvents]\n\n @param child               the view to process for visibility event\n @param detachEvent         true if the child was just detached\n @param eventOriginForDebug a debug strings used for logs\n
//                           ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                 documentation ```kt\nvalue-parameter child: [ERROR : View]\n```
//                                        ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                    documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
//                                                              ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
//                                                                                  documentation ```kt\nvalue-parameter eventOriginForDebug: kotlin.String\n```
//                                                                                   ^^^^^^ reference semanticdb maven . . kotlin/String#

        // Only if attached
        val recyclerView = attachedRecyclerView ?: return
//          ^^^^^^^^^^^^ definition local 6
//                       documentation ```kt\nval recyclerView: kotlin.Nothing\n```
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().

        // Preemptive check for child's parent validity to prevent `IllegalArgumentException` in
        // `getChildViewHolder`.
        val isParentValid = child.parent == null || child.parent === recyclerView
//          ^^^^^^^^^^^^^ definition local 7
//                        documentation ```kt\nval isParentValid: kotlin.Boolean\n```
//                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                                  ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                                                   ^^^^^^^^^^^^ reference local 6
        val viewHolder = if (isParentValid) recyclerView.getChildViewHolder(child) else null
//          ^^^^^^^^^^ definition local 8
//                     documentation ```kt\nval viewHolder: kotlin.Nothing?\n```
//                           ^^^^^^^^^^^^^ reference local 7
//                                          ^^^^^^^^^^^^ reference local 6
//                                                                          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
        if (viewHolder is EpoxyViewHolder) {
//          ^^^^^^^^^^ reference local 8
            val epoxyHolder = viewHolder.holder
//              ^^^^^^^^^^^ definition local 9
//                          documentation ```kt\nval epoxyHolder: [ERROR : Type for viewHolder.holder]\n```
//                            ^^^^^^^^^^ reference local 8
            processChild(recyclerView, child, detachEvent, eventOriginForDebug, viewHolder)
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
//                       ^^^^^^^^^^^^ reference local 6
//                                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(child)
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                         ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
//                                                                              ^^^^^^^^^^ reference local 8
            if (epoxyHolder is ModelGroupHolder) {
//              ^^^^^^^^^^^ reference local 9
//                             ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
                processModelGroupChildren(recyclerView, epoxyHolder, detachEvent, eventOriginForDebug)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().
//                                        ^^^^^^^^^^^^ reference local 6
//                                                      ^^^^^^^^^^^ reference local 9
//                                                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(detachEvent)
//                                                                                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().(eventOriginForDebug)
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
//              ^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().
//                                        documentation ```kt\nprivate final fun processModelGroupChildren(recyclerView: [ERROR : RecyclerView], epoxyHolder: com.airbnb.epoxy.ModelGroupHolder, detachEvent: kotlin.Boolean, eventOriginForDebug: kotlin.String)\n```\n\n----\n\n\n Loop through the children of the model group and process visibility events on each one in\n relation to the model group's layout. This will attach or detach trackers to any nested\n [RecyclerView]s.\n\n @param epoxyHolder         the [ModelGroupHolder] with children to process\n @param detachEvent         true if the child was just detached\n @param eventOriginForDebug a debug strings used for logs\n
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(recyclerView)
//                   documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
        epoxyHolder: ModelGroupHolder,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(epoxyHolder)
//                  documentation ```kt\nvalue-parameter epoxyHolder: com.airbnb.epoxy.ModelGroupHolder\n```
//                   ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
//                  documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        eventOriginForDebug: String
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(eventOriginForDebug)
//                          documentation ```kt\nvalue-parameter eventOriginForDebug: kotlin.String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
    ) {
        // Iterate through models in the group and process each of them instead of the group
        for (groupChildHolder in epoxyHolder.viewHolders) {
//           ^^^^^^^^^^^^^^^^ definition local 10
//                            documentation ```kt\nval groupChildHolder: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(epoxyHolder)
//                                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#getViewHolders().
//                                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ModelGroupHolder#viewHolders.
            // Since the group is likely using a ViewGroup other than a RecyclerView, handle the
            // potential of a nested RecyclerView. This cannot be done through the normal flow
            // without recursively searching through the view children.
            if (groupChildHolder.itemView is RecyclerView) {
//              ^^^^^^^^^^^^^^^^ reference local 10
                if (detachEvent) {
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
                    processChildRecyclerViewDetached(groupChildHolder.itemView)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                                   ^^^^^^^^^^^^^^^^ reference local 10
                } else {
                    processChildRecyclerViewAttached(groupChildHolder.itemView)
//                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                                   ^^^^^^^^^^^^^^^^ reference local 10
                }
            }
            processChild(
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
                recyclerView,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(recyclerView)
                groupChildHolder.itemView,
//              ^^^^^^^^^^^^^^^^ reference local 10
                detachEvent,
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(detachEvent)
                eventOriginForDebug,
//              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processModelGroupChildren().(eventOriginForDebug)
                groupChildHolder
//              ^^^^^^^^^^^^^^^^ reference local 10
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
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).
//                           documentation ```kt\nprivate final fun processChild(recyclerView: [ERROR : RecyclerView], child: [ERROR : View], detachEvent: kotlin.Boolean, eventOriginForDebug: kotlin.String, viewHolder: [ERROR : EpoxyViewHolder])\n```\n\n----\n\n\n Process visibility events for a view and propagate to a nested tracker if the view is a\n [RecyclerView].\n\n @param child               the view to process for visibility event\n @param detachEvent         true if the child was just detached\n @param eventOriginForDebug a debug strings used for logs\n @param viewHolder          the view holder for the child view\n
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(recyclerView)
//                   documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
        child: View,
//      ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
//            documentation ```kt\nvalue-parameter child: [ERROR : View]\n```
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(detachEvent)
//                  documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        eventOriginForDebug: String,
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(eventOriginForDebug)
//                          documentation ```kt\nvalue-parameter eventOriginForDebug: kotlin.String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
        viewHolder: EpoxyViewHolder
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(viewHolder)
//                 documentation ```kt\nvalue-parameter viewHolder: [ERROR : EpoxyViewHolder]\n```
    ) {
        val changed = processVisibilityEvents(
//          ^^^^^^^ definition local 11
//                  documentation ```kt\nval changed: kotlin.Boolean\n```
//                    ^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().
            recyclerView,
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(recyclerView)
            viewHolder,
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(viewHolder)
            detachEvent,
//          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(detachEvent)
            eventOriginForDebug
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(eventOriginForDebug)
        )
        if (changed && child is RecyclerView) {
//          ^^^^^^^ reference local 11
//                     ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
            nestedTrackers[child]?.processChangeEvent("parent")
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//                         ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild(+1).(child)
//                                 ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
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
//              ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().
//                                      documentation ```kt\nprivate final fun processVisibilityEvents(recyclerView: [ERROR : RecyclerView], epoxyHolder: [ERROR : EpoxyViewHolder], detachEvent: kotlin.Boolean, eventOriginForDebug: kotlin.String): kotlin.Boolean\n```\n\n----\n\n\n Call this methods every time something related to ui (scroll, layout, ...) or something related\n to data changed.\n\n @param recyclerView        the recycler view\n @param epoxyHolder         the [RecyclerView]\n @param detachEvent         true if the event originated from a view detached from the\n recycler view\n @param eventOriginForDebug a debug strings used for logs\n @return true if changed\n
        recyclerView: RecyclerView,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(recyclerView)
//                   documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
        epoxyHolder: EpoxyViewHolder,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                  documentation ```kt\nvalue-parameter epoxyHolder: [ERROR : EpoxyViewHolder]\n```
        detachEvent: Boolean,
//      ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
//                  documentation ```kt\nvalue-parameter detachEvent: kotlin.Boolean\n```
//                   ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        eventOriginForDebug: String
//      ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(eventOriginForDebug)
//                          documentation ```kt\nvalue-parameter eventOriginForDebug: kotlin.String\n```
//                           ^^^^^^ reference semanticdb maven . . kotlin/String#
    ): Boolean {
//     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        if (DEBUG_LOG) {
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
            Log.d(
                TAG,
//              ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//              ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
                "$eventOriginForDebug.processVisibilityEvents " +
//                ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(eventOriginForDebug)
//                                                              ^ reference semanticdb maven . . kotlin/String#plus().
                    "${System.identityHashCode(epoxyHolder)}, " +
//                     ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#identityHashCode().
//                                             ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                              ^ reference semanticdb maven . . kotlin/String#plus().
                    "$detachEvent, ${epoxyHolder.adapterPosition}"
//                    ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
//                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            )
        }
        val itemView = epoxyHolder.itemView
//          ^^^^^^^^ definition local 12
//                   documentation ```kt\nval itemView: [ERROR : <ERROR PROPERTY TYPE>]\n```
//                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        val id = System.identityHashCode(itemView)
//          ^^ definition local 13
//             documentation ```kt\nval id: kotlin.Int\n```
//               ^^^^^^ reference semanticdb maven jdk 11 java/lang/System#
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven jdk 11 java/lang/System#identityHashCode().
//                                       ^^^^^^^^ reference local 12
        var vi = visibilityIdToItemMap[id]
//          ^^ definition local 14
//             documentation ```kt\nvar vi: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//               ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//                                     ^^ reference local 13
        if (vi == null) {
//          ^^ reference local 14
            // New view discovered, assign an EpoxyVisibilityItem
            vi = EpoxyVisibilityItem(epoxyHolder.adapterPosition)
//          ^^ reference local 14
//               ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#`<init>`().
//                                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            visibilityIdToItemMap.put(id, vi)
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
//                                    ^^ reference local 13
//                                        ^^ reference local 14
            visibilityIdToItems.add(vi)
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                              ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
//                                  ^^ reference local 14
        } else if (epoxyHolder.adapterPosition != RecyclerView.NO_POSITION &&
//                 ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
            vi.adapterPosition != epoxyHolder.adapterPosition
//          ^^ reference local 14
//                                ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        ) {
            // EpoxyVisibilityItem being re-used for a different adapter position
            vi.reset(epoxyHolder.adapterPosition)
//          ^^ reference local 14
//                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
        }
        var changed = false
//          ^^^^^^^ definition local 15
//                  documentation ```kt\nvar changed: kotlin.Boolean\n```
        if (vi.update(itemView, recyclerView, detachEvent)) {
//          ^^ reference local 14
//                    ^^^^^^^^ reference local 12
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(recyclerView)
//                                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            // View is measured, process events
            vi.handleVisible(epoxyHolder, detachEvent)
//          ^^ reference local 14
//                           ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                        ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            partialImpressionThresholdPercentage?.let { percentage ->
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                                ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#let().
//                                                      ^^^^^^^^^^ definition local 16
//                                                                 documentation ```kt\nvalue-parameter percentage: kotlin.Int\n```
                vi.handlePartialImpressionVisible(
//              ^^ reference local 14
                    epoxyHolder, detachEvent,
//                  ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                               ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
                    percentage
//                  ^^^^^^^^^^ reference local 16
                )
            }
            vi.handleFocus(epoxyHolder, detachEvent)
//          ^^ reference local 14
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            vi.handleFullImpressionVisible(epoxyHolder, detachEvent)
//          ^^ reference local 14
//                                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(detachEvent)
            changed = vi.handleChanged(epoxyHolder, onChangedEnabled)
//          ^^^^^^^ reference local 15
//                    ^^ reference local 14
//                                     ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processVisibilityEvents().(epoxyHolder)
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getOnChangedEnabled().
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#onChangedEnabled.
//                                                  ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setOnChangedEnabled().
        }
        return changed
//             ^^^^^^^ reference local 15
    }

    private fun processChildRecyclerViewAttached(childRecyclerView: RecyclerView) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                               documentation ```kt\nprivate final fun processChildRecyclerViewAttached(childRecyclerView: [ERROR : RecyclerView])\n```
//                                               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
//                                                                 documentation ```kt\nvalue-parameter childRecyclerView: [ERROR : RecyclerView]\n```
        // Register itself in the EpoxyVisibilityTracker. This will take care of nested list
        // tracking (ex: carousel)
        val tracker = getTracker(childRecyclerView) ?: EpoxyVisibilityTracker().let { nested ->
//          ^^^^^^^ definition local 17
//                  documentation ```kt\nval tracker: com.airbnb.epoxy.EpoxyVisibilityTracker\n```
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().
//                               ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
//                                                     ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#`<init>`().
//                                                                              ^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#let().
//                                                                                    ^^^^^^ definition local 18
//                                                                                           documentation ```kt\nvalue-parameter nested: com.airbnb.epoxy.EpoxyVisibilityTracker\n```
            nested.partialImpressionThresholdPercentage = partialImpressionThresholdPercentage
//          ^^^^^^ reference local 18
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getPartialImpressionThresholdPercentage().
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#partialImpressionThresholdPercentage.
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setPartialImpressionThresholdPercentage().
            nested.attach(childRecyclerView)
//          ^^^^^^ reference local 18
//                 ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attach().
//                        ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
            nested
//          ^^^^^^ reference local 18
        }
        nestedTrackers[childRecyclerView] = tracker
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//                     ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().(childRecyclerView)
//                                          ^^^^^^^ reference local 17
    }

    private fun processChildRecyclerViewDetached(childRecyclerView: RecyclerView) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                               documentation ```kt\nprivate final fun processChildRecyclerViewDetached(childRecyclerView: [ERROR : RecyclerView])\n```
//                                               ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().(childRecyclerView)
//                                                                 documentation ```kt\nvalue-parameter childRecyclerView: [ERROR : RecyclerView]\n```
        nestedTrackers.remove(childRecyclerView)
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getNestedTrackers().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#nestedTrackers.
//                     ^^^^^^ reference semanticdb maven . . kotlin/collections/MutableMap#remove().
//                            ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().(childRecyclerView)
    }

    /**
     * Helper class that host the [androidx.recyclerview.widget.RecyclerView] listener
     * implementations
     */
    private inner class Listener :
//                      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#
//                               documentation ```kt\nprivate final inner class Listener\n```\n\n----\n\n\n Helper class that host the [androidx.recyclerview.widget.RecyclerView] listener\n implementations\n
//                      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#`<init>`().
//                               documentation ```kt\npublic constructor Listener()\n```\n\n----\n\n\n Helper class that host the [androidx.recyclerview.widget.RecyclerView] listener\n implementations\n
        RecyclerView.OnScrollListener(),
        View.OnLayoutChangeListener,
        RecyclerView.OnChildAttachStateChangeListener {
        override fun onLayoutChange(
//                   ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().
//                                  documentation ```kt\npublic open fun onLayoutChange(recyclerView: [ERROR : View], left: kotlin.Int, top: kotlin.Int, right: kotlin.Int, bottom: kotlin.Int, oldLeft: kotlin.Int, oldTop: kotlin.Int, oldRight: kotlin.Int, oldBottom: kotlin.Int)\n```
            recyclerView: View,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(recyclerView)
//                       documentation ```kt\nvalue-parameter recyclerView: [ERROR : View]\n```
            left: Int,
//          ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(left)
//               documentation ```kt\nvalue-parameter left: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
            top: Int,
//          ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(top)
//              documentation ```kt\nvalue-parameter top: kotlin.Int\n```
//               ^^^ reference semanticdb maven . . kotlin/Int#
            right: Int,
//          ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(right)
//                documentation ```kt\nvalue-parameter right: kotlin.Int\n```
//                 ^^^ reference semanticdb maven . . kotlin/Int#
            bottom: Int,
//          ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(bottom)
//                 documentation ```kt\nvalue-parameter bottom: kotlin.Int\n```
//                  ^^^ reference semanticdb maven . . kotlin/Int#
            oldLeft: Int,
//          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldLeft)
//                  documentation ```kt\nvalue-parameter oldLeft: kotlin.Int\n```
//                   ^^^ reference semanticdb maven . . kotlin/Int#
            oldTop: Int,
//          ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldTop)
//                 documentation ```kt\nvalue-parameter oldTop: kotlin.Int\n```
//                  ^^^ reference semanticdb maven . . kotlin/Int#
            oldRight: Int,
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldRight)
//                   documentation ```kt\nvalue-parameter oldRight: kotlin.Int\n```
//                    ^^^ reference semanticdb maven . . kotlin/Int#
            oldBottom: Int
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onLayoutChange().(oldBottom)
//                    documentation ```kt\nvalue-parameter oldBottom: kotlin.Int\n```
//                     ^^^ reference semanticdb maven . . kotlin/Int#
        ) {
            processChangeEvent("onLayoutChange")
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                   ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().
//                              documentation ```kt\npublic open fun onScrolled(recyclerView: [ERROR : RecyclerView], dx: kotlin.Int, dy: kotlin.Int)\n```
//                              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(recyclerView)
//                                           documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
//                                                          ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(dx)
//                                                             documentation ```kt\nvalue-parameter dx: kotlin.Int\n```
//                                                              ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                   ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onScrolled().(dy)
//                                                                      documentation ```kt\nvalue-parameter dy: kotlin.Int\n```
//                                                                       ^^^ reference semanticdb maven . . kotlin/Int#
            processChangeEvent("onScrolled")
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEvent().
        }

        override fun onChildViewAttachedToWindow(child: View) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().
//                                               documentation ```kt\npublic open fun onChildViewAttachedToWindow(child: [ERROR : View])\n```
//                                               ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
//                                                     documentation ```kt\nvalue-parameter child: [ERROR : View]\n```
            if (child is RecyclerView) {
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
                processChildRecyclerViewAttached(child)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewAttached().
//                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
            }
            processChild(child, false, "onChildViewAttachedToWindow")
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                       ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewAttachedToWindow().(child)
        }

        override fun onChildViewDetachedFromWindow(child: View) {
//                   ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().
//                                                 documentation ```kt\npublic open fun onChildViewDetachedFromWindow(child: [ERROR : View])\n```
//                                                 ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
//                                                       documentation ```kt\nvalue-parameter child: [ERROR : View]\n```
            if (child is RecyclerView) {
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
                processChildRecyclerViewDetached(child)
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChildRecyclerViewDetached().
//                                               ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
            }
            if (visibleDataChanged) {
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                // On detach event caused by data set changed we need to re-process all children because
                // the removal caused the others views to changes.
                processChangeEventWithDetachedView(child, "onChildViewDetachedFromWindow")
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChangeEventWithDetachedView().
//                                                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
                visibleDataChanged = false
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
            } else {
                processChild(child, true, "onChildViewDetachedFromWindow")
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#processChild().
//                           ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Listener#onChildViewDetachedFromWindow().(child)
            }
        }
    }

    /**
     * The layout/scroll events are not enough to detect all sort of visibility changes. We also
     * need to look at the data events from the adapter.
     */
    internal inner class DataObserver : RecyclerView.AdapterDataObserver() {
//                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#
//                                    documentation ```kt\ninternal final inner class DataObserver\n```\n\n----\n\n\n The layout/scroll events are not enough to detect all sort of visibility changes. We also\n need to look at the data events from the adapter.\n
//                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#`<init>`().
//                                    documentation ```kt\npublic constructor DataObserver()\n```\n\n----\n\n\n The layout/scroll events are not enough to detect all sort of visibility changes. We also\n need to look at the data events from the adapter.\n
        /**
         * Clear the current visibility statues
         */
        override fun onChanged() {
//                   ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onChanged().
//                             documentation ```kt\npublic open fun onChanged()\n```\n\n----\n\n\n Clear the current visibility statues\n
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onChanged()")
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
            }
            visibilityIdToItemMap.clear()
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItemMap().
//          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItemMap.
            visibilityIdToItems.clear()
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//          ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
//                              ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
            visibleDataChanged = true
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//          ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
        }

        /**
         * For all items after the inserted range shift each [EpoxyVisibilityTracker] adapter
         * position by inserted item count.
         */
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().
//                                       documentation ```kt\npublic open fun onItemRangeInserted(positionStart: kotlin.Int, itemCount: kotlin.Int)\n```\n\n----\n\n\n For all items after the inserted range shift each [EpoxyVisibilityTracker] adapter\n position by inserted item count.\n
//                                       ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
//                                                     documentation ```kt\nvalue-parameter positionStart: kotlin.Int\n```
//                                                      ^^^ reference semanticdb maven . . kotlin/Int#
//                                                           ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
//                                                                     documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                      ^^^ reference semanticdb maven . . kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeInserted($positionStart, $itemCount)")
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                               ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
//                                                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local 19
//                    documentation ```kt\nval item: com.airbnb.epoxy.EpoxyVisibilityItem\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
                if (item.adapterPosition >= positionStart) {
//                  ^^^^ reference local 19
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(positionStart)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                    item.shiftBy(itemCount)
//                  ^^^^ reference local 19
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeInserted().(itemCount)
                }
            }
        }

        /**
         * For all items after the removed range reverse-shift each [EpoxyVisibilityTracker]
         * adapter position by removed item count
         */
        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
//                   ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().
//                                      documentation ```kt\npublic open fun onItemRangeRemoved(positionStart: kotlin.Int, itemCount: kotlin.Int)\n```\n\n----\n\n\n For all items after the removed range reverse-shift each [EpoxyVisibilityTracker]\n adapter position by removed item count\n
//                                      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
//                                                    documentation ```kt\nvalue-parameter positionStart: kotlin.Int\n```
//                                                     ^^^ reference semanticdb maven . . kotlin/Int#
//                                                          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
//                                                                    documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                     ^^^ reference semanticdb maven . . kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeRemoved($positionStart, $itemCount)")
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
//                                                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local 20
//                    documentation ```kt\nval item: com.airbnb.epoxy.EpoxyVisibilityItem\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
                if (item.adapterPosition >= positionStart) {
//                  ^^^^ reference local 20
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(positionStart)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                    item.shiftBy(-itemCount)
//                  ^^^^ reference local 20
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
//                                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeRemoved().(itemCount)
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
//                   ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().
//                                    documentation ```kt\npublic open fun onItemRangeMoved(fromPosition: kotlin.Int, toPosition: kotlin.Int, itemCount: kotlin.Int)\n```\n\n----\n\n\n This is a bit more complex, for move we need to first swap the moved position then shift the\n items between the swap. To simplify we split any range passed to individual item moved.\n\n ps: anyway [androidx.recyclerview.widget.AdapterListUpdateCallback]\n does not seem to use range for moved items.\n
//                                    ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(fromPosition)
//                                                 documentation ```kt\nvalue-parameter fromPosition: kotlin.Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                       ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(toPosition)
//                                                                  documentation ```kt\nvalue-parameter toPosition: kotlin.Int\n```
//                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                        ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(itemCount)
//                                                                                  documentation ```kt\nvalue-parameter itemCount: kotlin.Int\n```
//                                                                                   ^^^ reference semanticdb maven . . kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            for (i in 0 until itemCount) {
//               ^ definition local 21
//                 documentation ```kt\nval i: kotlin.Int\n```
//                      ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                            ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(itemCount)
                onItemMoved(fromPosition + i, toPosition + i)
//              ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().
//                          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(fromPosition)
//                                       ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                         ^ reference local 21
//                                            ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemRangeMoved().(toPosition)
//                                                       ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                         ^ reference local 21
            }
        }

        private fun onItemMoved(fromPosition: Int, toPosition: Int) {
//                  ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().
//                              documentation ```kt\nprivate final fun onItemMoved(fromPosition: kotlin.Int, toPosition: kotlin.Int)\n```
//                              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                           documentation ```kt\nvalue-parameter fromPosition: kotlin.Int\n```
//                                            ^^^ reference semanticdb maven . . kotlin/Int#
//                                                 ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                                            documentation ```kt\nvalue-parameter toPosition: kotlin.Int\n```
//                                                             ^^^ reference semanticdb maven . . kotlin/Int#
            if (notEpoxyManaged(attachedRecyclerView)) {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#attachedRecyclerView.
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getAttachedRecyclerView().
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setAttachedRecyclerView().
                return
            }
            if (DEBUG_LOG) {
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
                Log.d(TAG, "onItemRangeMoved($fromPosition, $fromPosition, 1)")
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                    ^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                                           ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
            }
            for (item in visibilityIdToItems) {
//               ^^^^ definition local 22
//                    documentation ```kt\nval item: com.airbnb.epoxy.EpoxyVisibilityItem\n```
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibilityIdToItems().
//                       ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibilityIdToItems.
                val position = item.adapterPosition
//                  ^^^^^^^^ definition local 23
//                           documentation ```kt\nval position: [ERROR : <ERROR PROPERTY TYPE>]\n```
//                             ^^^^ reference local 22
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#adapterPosition.
//                                  ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#getAdapterPosition().
                if (position == fromPosition) {
//                  ^^^^^^^^ reference local 23
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                    // We found the item to be moved, just swap the position.
                    item.shiftBy(toPosition - fromPosition)
//                  ^^^^ reference local 22
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                               ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                          ^ reference semanticdb maven . . kotlin/Int#minus(+3).
//                                            ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                    visibleDataChanged = true
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                  ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                } else if (fromPosition < toPosition) {
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                    // Item will be moved down in the list
                    if (position in (fromPosition + 1)..toPosition) {
//                      ^^^^^^^^ reference local 23
//                               ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#contains().
//                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                                ^ reference semanticdb maven . . kotlin/Int#plus(+3).
//                                                    ^^ reference semanticdb maven . . kotlin/Int#rangeTo(+1).
//                                                      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                        // Item is between the moved from and to indexes, it should move up
                        item.shiftBy(-1)
//                      ^^^^ reference local 22
//                           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
//                                   ^ reference semanticdb maven . . kotlin/Int#unaryMinus().
                        visibleDataChanged = true
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                    }
                } else if (fromPosition > toPosition) {
//                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
//                                      ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
//                                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
                    // Item will be moved up in the list
                    if (position in toPosition until fromPosition) {
//                      ^^^^^^^^ reference local 23
//                               ^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/IntRange#contains().
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(toPosition)
//                                             ^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/ranges/RangesKt#until(+6).
//                                                   ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#onItemMoved().(fromPosition)
                        // Item is between the moved to and from indexes, it should move down
                        item.shiftBy(1)
//                      ^^^^ reference local 22
//                           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityItem#shiftBy().
                        visibleDataChanged = true
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#getVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#setVisibleDataChanged().
//                      ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#visibleDataChanged.
                    }
                }
            }
        }

        /**
         * @param recyclerView the recycler view
         * @return true if managed by an [BaseEpoxyAdapter]
         */
        private fun notEpoxyManaged(recyclerView: RecyclerView?): Boolean {
//                  ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().
//                                  documentation ```kt\nprivate final fun notEpoxyManaged(recyclerView: [ERROR : RecyclerView]?): kotlin.Boolean\n```\n\n----\n\n\n @param recyclerView the recycler view\n @return true if managed by an [BaseEpoxyAdapter]\n
//                                  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
//                                               documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]?\n```
//                                                                ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
            return recyclerView == null || recyclerView.adapter !is BaseEpoxyAdapter
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
//                                         ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#DataObserver#notEpoxyManaged().(recyclerView)
        }
    }

    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion# 1:0
//                     documentation ```kt\npublic companion object\n```
        private const val TAG = "EpoxyVisibilityTracker"
//                        ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG.
//                            documentation ```kt\nprivate const final val TAG: kotlin.String\n```
//                        ^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG().
//                            documentation ```kt\nprivate const final val TAG: kotlin.String\n```

        @IdRes
//       ^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/IdRes#`<init>`().
        private val TAG_ID = R.id.epoxy_visibility_tracker
//                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                         documentation ```kt\nprivate final val TAG_ID: [ERROR : <ERROR PROPERTY TYPE>]\n```
//                  ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().
//                         documentation ```kt\nprivate final val TAG_ID: [ERROR : <ERROR PROPERTY TYPE>]\n```

        /**
         * @param recyclerView the view.
         * @return the tracker for the given [RecyclerView]. Null if no tracker was attached.
         */
        private fun getTracker(recyclerView: RecyclerView): EpoxyVisibilityTracker? {
//                  ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().
//                             documentation ```kt\nprivate final fun getTracker(recyclerView: [ERROR : RecyclerView]): com.airbnb.epoxy.EpoxyVisibilityTracker?\n```\n\n----\n\n\n @param recyclerView the view.\n @return the tracker for the given [RecyclerView]. Null if no tracker was attached.\n
//                             ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().(recyclerView)
//                                          documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
//                                                          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
            return recyclerView.getTag(TAG_ID) as EpoxyVisibilityTracker?
//                 ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTracker().(recyclerView)
//                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                                     ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().
//                                                ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
        }

        /**
         * Store the tracker for the given [RecyclerView].
         * @param recyclerView the view
         * @param tracker the tracker
         */
        private fun setTracker(
//                  ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().
//                             documentation ```kt\nprivate final fun setTracker(recyclerView: [ERROR : RecyclerView], tracker: com.airbnb.epoxy.EpoxyVisibilityTracker?)\n```\n\n----\n\n\n Store the tracker for the given [RecyclerView].\n @param recyclerView the view\n @param tracker the tracker\n
            recyclerView: RecyclerView,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(recyclerView)
//                       documentation ```kt\nvalue-parameter recyclerView: [ERROR : RecyclerView]\n```
            tracker: EpoxyVisibilityTracker?
//          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(tracker)
//                  documentation ```kt\nvalue-parameter tracker: com.airbnb.epoxy.EpoxyVisibilityTracker?\n```
//                   ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#
        ) {
            recyclerView.setTag(TAG_ID, tracker)
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(recyclerView)
//                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#TAG_ID.
//                              ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getTAG_ID().
//                                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#setTracker().(tracker)
        }

        // Not actionable at runtime. It is only useful for internal test-troubleshooting.
        const val DEBUG_LOG = false
//                ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#DEBUG_LOG.
//                          documentation ```kt\npublic const final val DEBUG_LOG: kotlin.Boolean\n```
//                ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyVisibilityTracker#Companion#getDEBUG_LOG().
//                          documentation ```kt\npublic const final val DEBUG_LOG: kotlin.Boolean\n```
    }
}
