package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.annotation.IdRes
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^^^^ reference androidx/annotation/IdRes#
import androidx.annotation.Px
//     ^^^^^^^^ reference androidx/
//              ^^^^^^^^^^ reference androidx/annotation/
//                         ^^ reference androidx/annotation/Px#
import androidx.recyclerview.widget.LinearLayoutManager
//     ^^^^^^^^ reference androidx/
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyAdapter
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyController
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.getModelForPositionInternal
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#getModelForPositionInternal().
import kotlin.math.max
//     ^^^^^^ reference kotlin/
//            ^^^^ reference kotlin/math/
import kotlin.math.min
//     ^^^^^^ reference kotlin/
//            ^^^^ reference kotlin/math/

/**
 * A scroll listener that prefetches view content.
 *
 * To use this, create implementations of [EpoxyModelPreloader] for each EpoxyModel class that you want to preload.
 * Then, use the [EpoxyPreloader.with] methods to create an instance that preloads models of that type.
 * Finally, add the resulting scroll listener to your RecyclerView.
 *
 * If you are using [com.airbnb.epoxy.EpoxyRecyclerView] then use [com.airbnb.epoxy.EpoxyRecyclerView.addPreloader]
 * to setup the preloader as a listener.
 *
 * Otherwise there is a [RecyclerView.addEpoxyPreloader] extension for easy usage.
 */
class EpoxyPreloader<P : PreloadRequestHolder> private constructor(
//    ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#
//                   ^ definition com/airbnb/epoxy/preload/EpoxyPreloader#[P]
//                       ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                     ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().
    private val adapter: BaseEpoxyAdapter,
//              ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//              ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//              ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(adapter)
    preloadTargetFactory: () -> P,
//  ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(preloadTargetFactory)
//                              ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    errorHandler: PreloadErrorHandler,
//  ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(errorHandler)
//                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
    private val maxItemsToPreload: Int,
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//              ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(maxItemsToPreload)
//                                 ^^^ reference kotlin/Int#
    modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//  ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(modelPreloaders)
//                   ^^^^ reference kotlin/collections/List#
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                      ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
) : RecyclerView.OnScrollListener() {

    private var lastVisibleRange: IntRange = IntRange.EMPTY
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                                ^^^^^^^^ reference kotlin/ranges/IntRange#
//                                           ^^^^^^^^ reference kotlin/ranges/IntRange#Companion#
//                                                    ^^^^^ reference kotlin/ranges/IntRange#Companion#EMPTY.
//                                                    ^^^^^ reference kotlin/ranges/IntRange#Companion#getEMPTY().
    private var lastPreloadRange: IntProgression = IntRange.EMPTY
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//              ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                                ^^^^^^^^^^^^^^ reference kotlin/ranges/IntProgression#
//                                                 ^^^^^^^^ reference kotlin/ranges/IntRange#Companion#
//                                                          ^^^^^ reference kotlin/ranges/IntRange#Companion#EMPTY.
//                                                          ^^^^^ reference kotlin/ranges/IntRange#Companion#getEMPTY().
    private var totalItemCount = -1
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//              ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                               ^ reference kotlin/Int#unaryMinus().
    private var scrollState: Int = RecyclerView.SCROLL_STATE_IDLE
//              ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#scrollState.
//              ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getScrollState().
//              ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#setScrollState().
//                           ^^^ reference kotlin/Int#

    private val modelPreloaders: Map<Class<out EpoxyModel<*>>, EpoxyModelPreloader<*, *, out P>> =
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#modelPreloaders.
//              ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getModelPreloaders().
//                               ^^^ reference kotlin/collections/Map#
//                                   ^^^^^ reference java/lang/Class#
//                                                             ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                                           ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        modelPreloaders.associateBy { it.modelType }
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(modelPreloaders)
//                      ^^^^^^^^^^^ reference kotlin/collections/CollectionsKt#associateBy(+18).
//                                    ^^ reference local0
//                                       ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#modelType.
//                                       ^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#getModelType().

    private val requestHolderFactory =
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//              ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
        PreloadTargetProvider(maxItemsToPreload, preloadTargetFactory)
//      ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#`<init>`().
//                            ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                            ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(preloadTargetFactory)

    private val viewDataCache = PreloadableViewDataProvider(adapter, errorHandler)
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#viewDataCache.
//              ^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#getViewDataCache().
//                              ^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().
//                                                          ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//                                                          ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`().(errorHandler)

    constructor(
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).
        epoxyController: EpoxyController,
//      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(epoxyController)
        requestHolderFactory: () -> P,
//      ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(requestHolderFactory)
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        errorHandler: PreloadErrorHandler,
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(errorHandler)
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
        maxItemsToPreload: Int,
//      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(maxItemsToPreload)
//                         ^^^ reference kotlin/Int#
        modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(modelPreloaders)
//                       ^^^^ reference kotlin/collections/List#
//                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                          ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    ) : this(
        epoxyController.adapter,
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(epoxyController)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(errorHandler)
        maxItemsToPreload,
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(maxItemsToPreload)
        modelPreloaders
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+1).(modelPreloaders)
    )

    constructor(
//  ^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).
        adapter: EpoxyAdapter,
//      ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(adapter)
        requestHolderFactory: () -> P,
//      ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(requestHolderFactory)
//                                  ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
        errorHandler: PreloadErrorHandler,
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(errorHandler)
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
        maxItemsToPreload: Int,
//      ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(maxItemsToPreload)
//                         ^^^ reference kotlin/Int#
        modelPreloaders: List<EpoxyModelPreloader<*, *, out P>>
//      ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(modelPreloaders)
//                       ^^^^ reference kotlin/collections/List#
//                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                          ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
    ) : this(
        adapter as BaseEpoxyAdapter,
//      ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(adapter)
        requestHolderFactory,
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(requestHolderFactory)
        errorHandler,
//      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(errorHandler)
        maxItemsToPreload,
//      ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(maxItemsToPreload)
        modelPreloaders
//      ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#`<init>`(+2).(modelPreloaders)
    )

    init {
        require(maxItemsToPreload > 0) {
//      ^^^^^^^ reference kotlin/PreconditionsKt#require(+1).
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                ^ reference kotlin/Int#compareTo(+3).
            "maxItemsToPreload must be greater than 0. Was $maxItemsToPreload"
//                                                          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                                          ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//               ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().
//                                    ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(recyclerView)
//                                                                ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(newState)
//                                                                          ^^^ reference kotlin/Int#
        scrollState = newState
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#scrollState.
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getScrollState().
//      ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setScrollState().
//                    ^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrollStateChanged().(newState)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//               ^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().
//                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)
//                                                      ^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//                                                          ^^^ reference kotlin/Int#
//                                                               ^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                                                                   ^^^ reference kotlin/Int#
        if (dx == 0 && dy == 0) {
//          ^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//             ^^ reference kotlin/Int#equals().
//                     ^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                        ^^ reference kotlin/Int#equals().
            // Sometimes flings register a bunch of 0 dx/dy scroll events. To avoid redundant prefetching we just skip these
            // Additionally, the first RecyclerView layout notifies a scroll of 0, since that can be an important time for
            // performance (eg page load) we avoid prefetching at the same time.
            return
        }

        if (dx.isFling() || dy.isFling()) {
//          ^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dx)
//             ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                          ^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(dy)
//                             ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
            // We avoid preloading during flings for two reasons
            // 1. Image requests are expensive and we don't want to drop frames on fling
            // 2. We'll likely scroll past the preloading item anyway
            return
        }

        // Update item count before anything else because validations depend on it
        totalItemCount = recyclerView.adapter?.itemCount ?: 0
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//      ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                       ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//          ^^^^^^^^^^^^^ definition local1
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#onScrolled().(recyclerView)
        val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
//          ^^^^^^^^^^^^^^^^^^^^ definition local2
//                                 ^^^^^^^^^^^^^ reference local1
        val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
//          ^^^^^^^^^^^^^^^^^^^ definition local3
//                                ^^^^^^^^^^^^^ reference local1

        if (firstVisiblePosition.isInvalid() || lastVisiblePosition.isInvalid()) {
//          ^^^^^^^^^^^^^^^^^^^^ reference local2
//                                              ^^^^^^^^^^^^^^^^^^^ reference local3
            lastVisibleRange = IntRange.EMPTY
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                             ^^^^^^^^ reference kotlin/ranges/IntRange#Companion#
//                                      ^^^^^ reference kotlin/ranges/IntRange#Companion#EMPTY.
//                                      ^^^^^ reference kotlin/ranges/IntRange#Companion#getEMPTY().
            lastPreloadRange = IntRange.EMPTY
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                             ^^^^^^^^ reference kotlin/ranges/IntRange#Companion#
//                                      ^^^^^ reference kotlin/ranges/IntRange#Companion#EMPTY.
//                                      ^^^^^ reference kotlin/ranges/IntRange#Companion#getEMPTY().
            return
        }

        val visibleRange = IntRange(firstVisiblePosition, lastVisiblePosition)
//          ^^^^^^^^^^^^ definition local4
//                         ^^^^^^^^ reference kotlin/ranges/IntRange#`<init>`().
//                                  ^^^^^^^^^^^^^^^^^^^^ reference local2
//                                                        ^^^^^^^^^^^^^^^^^^^ reference local3
        if (visibleRange == lastVisibleRange) {
//          ^^^^^^^^^^^^ reference local4
//                       ^^ reference kotlin/ranges/IntRange#equals().
//                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                          ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
            return
        }

        val isIncreasing =
//          ^^^^^^^^^^^^ definition local5
            visibleRange.first > lastVisibleRange.first || visibleRange.last > lastVisibleRange.last
//          ^^^^^^^^^^^^ reference local4
//                       ^^^^^ reference kotlin/ranges/IntRange#first.
//                       ^^^^^ reference kotlin/ranges/IntRange#getFirst().
//                             ^ reference kotlin/Int#compareTo(+3).
//                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                               ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                                                ^^^^^ reference kotlin/ranges/IntRange#first.
//                                                ^^^^^ reference kotlin/ranges/IntRange#getFirst().
//                                                         ^^^^^^^^^^^^ reference local4
//                                                                      ^^^^ reference kotlin/ranges/IntRange#last.
//                                                                      ^^^^ reference kotlin/ranges/IntRange#getLast().
//                                                                           ^ reference kotlin/Int#compareTo(+3).
//                                                                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//                                                                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//                                                                             ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                                                                                              ^^^^ reference kotlin/ranges/IntRange#last.
//                                                                                              ^^^^ reference kotlin/ranges/IntRange#getLast().

        val preloadRange =
//          ^^^^^^^^^^^^ definition local6
            calculatePreloadRange(firstVisiblePosition, lastVisiblePosition, isIncreasing)
//          ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().
//                                ^^^^^^^^^^^^^^^^^^^^ reference local2
//                                                      ^^^^^^^^^^^^^^^^^^^ reference local3
//                                                                           ^^^^^^^^^^^^ reference local5

        // Start preload for any items that weren't already preloaded
        preloadRange
//      ^^^^^^^^^^^^ reference local6
            .subtract(lastPreloadRange)
//           ^^^^^^^^ reference kotlin/collections/CollectionsKt#subtract(+9).
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//                    ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
            .forEach { preloadAdapterPosition(it) }
//           ^^^^^^^ reference kotlin/collections/CollectionsKt#forEach(+10).
//                     ^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().
//                                            ^^ reference local7

        lastVisibleRange = visibleRange
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastVisibleRange.
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastVisibleRange().
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastVisibleRange().
//                         ^^^^^^^^^^^^ reference local4
        lastPreloadRange = preloadRange
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#lastPreloadRange.
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getLastPreloadRange().
//      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setLastPreloadRange().
//                         ^^^^^^^^^^^^ reference local6
    }

    /**
     * @receiver The number of pixels scrolled.
     * @return True if this distance is large enough to be considered a fast fling.
     */
    private fun Int.isFling() = Math.abs(this) > FLING_THRESHOLD_PX
//              ^^^ reference kotlin/Int#
//                  ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                              ^^^^ reference java/lang/Math#
//                                   ^^^ reference java/lang/Math#abs().
//                                       ^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#isFling().
//                                             ^ reference kotlin/Int#compareTo(+3).
//                                               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#FLING_THRESHOLD_PX.
//                                               ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#getFLING_THRESHOLD_PX().

    private fun calculatePreloadRange(
//              ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().
        firstVisiblePosition: Int,
//      ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(firstVisiblePosition)
//                            ^^^ reference kotlin/Int#
        lastVisiblePosition: Int,
//      ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(lastVisiblePosition)
//                           ^^^ reference kotlin/Int#
        isIncreasing: Boolean
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                    ^^^^^^^ reference kotlin/Boolean#
    ): IntProgression {
//     ^^^^^^^^^^^^^^ reference kotlin/ranges/IntProgression#
        val from = if (isIncreasing) lastVisiblePosition + 1 else firstVisiblePosition - 1
//          ^^^^ definition local8
//                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                   ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(lastVisiblePosition)
//                                                       ^ reference kotlin/Int#plus(+3).
//                                                                ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(firstVisiblePosition)
//                                                                                     ^ reference kotlin/Int#minus(+3).
        val to = from + if (isIncreasing) maxItemsToPreload - 1 else 1 - maxItemsToPreload
//          ^^ definition local9
//               ^^^^ reference local8
//                    ^ reference kotlin/Int#plus(+3).
//                          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                        ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().
//                                                          ^ reference kotlin/Int#minus(+3).
//                                                                     ^ reference kotlin/Int#minus(+3).
//                                                                       ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#maxItemsToPreload.
//                                                                       ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getMaxItemsToPreload().

        return IntProgression.fromClosedRange(
//             ^^^^^^^^^^^^^^ reference kotlin/ranges/IntProgression#Companion#
//                            ^^^^^^^^^^^^^^^ reference kotlin/ranges/IntProgression#Companion#fromClosedRange().
            rangeStart = from.clampToAdapterRange(),
//          ^^^^^^^^^^ reference kotlin/ranges/IntProgression#Companion#fromClosedRange().(rangeStart)
//                       ^^^^ reference local8
//                            ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
            rangeEnd = to.clampToAdapterRange(),
//          ^^^^^^^^ reference kotlin/ranges/IntProgression#Companion#fromClosedRange().(rangeEnd)
//                     ^^ reference local9
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
            step = if (isIncreasing) 1 else -1
//          ^^^^ reference kotlin/ranges/IntProgression#Companion#fromClosedRange().(step)
//                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#calculatePreloadRange().(isIncreasing)
//                                          ^ reference kotlin/Int#unaryMinus().
        )
    }

    /** Check if an item index is valid. It may not be if the adapter is empty, or if adapter changes have been dispatched since the last layout pass. */
    private fun Int.isInvalid() = this == RecyclerView.NO_POSITION || this >= totalItemCount
//              ^^^ reference kotlin/Int#
//                  ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                                ^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                                     ^^ reference kotlin/Int#equals().
//                                                                    ^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#isInvalid().
//                                                                         ^^ reference kotlin/Int#compareTo(+3).
//                                                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//                                                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//                                                                            ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().

    private fun Int.clampToAdapterRange() = min(totalItemCount - 1, max(this, 0))
//              ^^^ reference kotlin/Int#
//                  ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().
//                                          ^^^ reference kotlin/math/MathKt#min(+2).
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#totalItemCount.
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getTotalItemCount().
//                                              ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#setTotalItemCount().
//                                                             ^ reference kotlin/Int#minus(+3).
//                                                                  ^^^ reference kotlin/math/MathKt#max(+2).
//                                                                      ^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#clampToAdapterRange().

    private fun preloadAdapterPosition(position: Int) {
//              ^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().
//                                     ^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
//                                               ^^^ reference kotlin/Int#
        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference kotlin/Suppress#`<init>`().
        val epoxyModel = adapter.getModelForPositionInternal(position) as? EpoxyModel<Any>
//          ^^^^^^^^^^ definition local10
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#adapter.
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getAdapter().
//                                                           ^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
//                                                                                    ^^^ reference kotlin/Any#
            ?: return

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference kotlin/Suppress#`<init>`().
        val preloader =
//          ^^^^^^^^^ definition local11
            modelPreloaders[epoxyModel::class.java] as? EpoxyModelPreloader<EpoxyModel<*>, ViewMetadata?, P>
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#modelPreloaders.
//          ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getModelPreloaders().
//                          ^^^^^^^^^^ reference local10
//                                            ^^^^ reference kotlin/jvm/JvmClassMappingKt#java.
//                                                      ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                                         ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                                        ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#[P]
                ?: return

        viewDataCache
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#viewDataCache.
//      ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getViewDataCache().
            .dataForModel(preloader, epoxyModel, position)
//           ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().
//                        ^^^^^^^^^ reference local11
//                                   ^^^^^^^^^^ reference local10
//                                               ^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#preloadAdapterPosition().(position)
            .forEach { viewData ->
//           ^^^^^^^ reference kotlin/collections/CollectionsKt#forEach(+10).
//                     ^^^^^^^^ definition local12
                val preloadTarget = requestHolderFactory.next()
//                  ^^^^^^^^^^^^^ definition local13
//                                  ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//                                  ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
//                                                       ^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#next().
                preloader.startPreload(epoxyModel, preloadTarget, viewData)
//              ^^^^^^^^^ reference local11
//                        ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#startPreload().
//                                     ^^^^^^^^^^ reference local10
//                                                 ^^^^^^^^^^^^^ reference local13
//                                                                ^^^^^^^^ reference local12
            }
    }

    /**
     * Cancels all current preload requests in progress.
     */
    fun cancelPreloadRequests() {
//      ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#cancelPreloadRequests().
        requestHolderFactory.clearAll()
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#requestHolderFactory.
//      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#getRequestHolderFactory().
//                           ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadTargetProvider#clearAll().
    }

    companion object {
//            ^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#

        /**
         *
         * Represents a threshold for fast scrolling.
         * This is a bit arbitrary and was determined by looking at values while flinging vs slow scrolling.
         * Ideally it would be based on DP, but this is simpler.
         */
        private const val FLING_THRESHOLD_PX = 75
//                        ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#FLING_THRESHOLD_PX.
//                        ^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#getFLING_THRESHOLD_PX().

        /**
         * Helper to create a preload scroll listener. Add the result to your RecyclerView.
         * for different models or content types.
         *
         * @param maxItemsToPreload How many items to prefetch ahead of the last bound item
         * @param errorHandler Called when the preloader encounters an exception. By default this throws only
         * if the app is not in a debuggle model
         * @param modelPreloader Describes how view content for the EpoxyModel should be preloaded
         * @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked
         */
        fun <P : PreloadRequestHolder> with(
//           ^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
//               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().
            epoxyController: EpoxyController,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(epoxyController)
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(requestHolderFactory)
//                                      ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(errorHandler)
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(maxItemsToPreload)
//                             ^^^ reference kotlin/Int#
            modelPreloader: EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>
//          ^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(modelPreloader)
//                          ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                        ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
        ): EpoxyPreloader<P> =
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().[P]
            with(
                epoxyController,
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(epoxyController)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(maxItemsToPreload)
                listOf(modelPreloader)
//              ^^^^^^ reference kotlin/collections/CollectionsKt#listOf().
//                     ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with().(modelPreloader)
            )

        fun <P : PreloadRequestHolder> with(
//           ^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
//               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).
            epoxyController: EpoxyController,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(epoxyController)
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(requestHolderFactory)
//                                      ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(errorHandler)
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(maxItemsToPreload)
//                             ^^^ reference kotlin/Int#
            modelPreloaders: List<EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>>
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(modelPreloaders)
//                           ^^^^ reference kotlin/collections/List#
//                                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                           ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                              ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]
        ): EpoxyPreloader<P> {
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).[P]

            return EpoxyPreloader(
                epoxyController,
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(epoxyController)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(maxItemsToPreload)
                modelPreloaders
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+1).(modelPreloaders)
            )
        }

        /** Helper to create a preload scroll listener. Add the result to your RecyclerView. */
        fun <P : PreloadRequestHolder> with(
//           ^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
//               ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                     ^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).
            epoxyAdapter: EpoxyAdapter,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(epoxyAdapter)
            requestHolderFactory: () -> P,
//          ^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(requestHolderFactory)
//                                      ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
            errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(errorHandler)
//                        ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
            maxItemsToPreload: Int,
//          ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(maxItemsToPreload)
//                             ^^^ reference kotlin/Int#
            modelPreloaders: List<EpoxyModelPreloader<out EpoxyModel<*>, out ViewMetadata?, out P>>
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(modelPreloaders)
//                           ^^^^ reference kotlin/collections/List#
//                                ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                                                           ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                                                              ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]
        ): EpoxyPreloader<P> {
//         ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#
//                        ^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).[P]

            return EpoxyPreloader(
                epoxyAdapter,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(epoxyAdapter)
                requestHolderFactory,
//              ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(requestHolderFactory)
                errorHandler,
//              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(errorHandler)
                maxItemsToPreload,
//              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(maxItemsToPreload)
                modelPreloaders
//              ^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloader#Companion#with(+2).(modelPreloaders)
            )
        }
    }
}

class EpoxyPreloadException(errorMessage: String) : RuntimeException(errorMessage)
//    ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloadException#
//    ^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().
//                          ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().(errorMessage)
//                                        ^^^^^^ reference kotlin/String#
//                                                  ^^^^^^^^^^^^^^^^ reference kotlin/RuntimeException#`<init>`(+1).
//                                                                   ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().(errorMessage)

typealias PreloadErrorHandler = (Context, RuntimeException) -> Unit
//        ^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadErrorHandler#
//                               ^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloaderKt#`<no name provided>`.
//                                        ^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/EpoxyPreloaderKt#`<no name provided>`.
//                                        ^^^^^^^^^^^^^^^^ reference kotlin/RuntimeException#
//                                                             ^^^^ reference kotlin/Unit#

/**
 * Data about an image view to be preloaded. This data is used to construct a Glide image request.
 *
 * @param metadata Any custom, additional data that the [EpoxyModelPreloader] chooses to provide that may be necessary to create the image request.
 */
class ViewData<out U : ViewMetadata?>(
//    ^^^^^^^^ definition com/airbnb/epoxy/preload/ViewData#
//    ^^^^^^^^ definition com/airbnb/epoxy/preload/ViewData#`<init>`().
//                 ^ definition com/airbnb/epoxy/preload/ViewData#[U]
//                     ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
    @IdRes val viewId: Int,
//   ^^^^^ reference androidx/annotation/IdRes#`<init>`().
//             ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#viewId.
//             ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#getViewId().
//             ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#`<init>`().(viewId)
//                     ^^^ reference kotlin/Int#
    @Px val width: Int,
//   ^^ reference androidx/annotation/Px#`<init>`().
//          ^^^^^ definition com/airbnb/epoxy/preload/ViewData#width.
//          ^^^^^ definition com/airbnb/epoxy/preload/ViewData#getWidth().
//          ^^^^^ definition com/airbnb/epoxy/preload/ViewData#`<init>`().(width)
//                 ^^^ reference kotlin/Int#
    @Px val height: Int,
//   ^^ reference androidx/annotation/Px#`<init>`().
//          ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#height.
//          ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#getHeight().
//          ^^^^^^ definition com/airbnb/epoxy/preload/ViewData#`<init>`().(height)
//                  ^^^ reference kotlin/Int#
    val metadata: U
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/ViewData#metadata.
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/ViewData#getMetadata().
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/ViewData#`<init>`().(metadata)
//                ^ reference com/airbnb/epoxy/preload/ViewData#[U]
)

interface ViewMetadata {
//        ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/ViewMetadata#
    companion object {
//            ^^^^^^^^^ definition com/airbnb/epoxy/preload/ViewMetadata#Companion#
        fun getDefault(view: View): ViewMetadata? {
//          ^^^^^^^^^^ definition com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().
//                     ^^^^ definition com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
//                                  ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
            return when (view) {
//                       ^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
                is ImageView -> ImageViewMetadata(view.scaleType)
//                              ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().
//                                                ^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#Companion#getDefault().(view)
                else -> null
            }
        }
    }
}

/**
 * Default implementation of [ViewMetadata] for an ImageView.
 * This data can help the preload request know how to configure itself.
 */
open class ImageViewMetadata(
//         ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/ImageViewMetadata#
//         ^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().
    val scaleType: ImageView.ScaleType
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/ImageViewMetadata#scaleType.
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/ImageViewMetadata#getScaleType().
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/ImageViewMetadata#`<init>`().(scaleType)
) : ViewMetadata
//  ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
