package com.airbnb.epoxy
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import androidx.annotation.CallSuper
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#
import androidx.annotation.DimenRes
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#
import androidx.annotation.Dimension
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
import androidx.annotation.Px
//     ^^^^^^^^ reference semanticdb maven . . androidx/
//              ^^^^^^^^^^ reference semanticdb maven . . androidx/annotation/
//                         ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#
import androidx.recyclerview.widget.GridLayoutManager
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.recyclerview.widget.LinearLayoutManager
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import androidx.recyclerview.widget.RecyclerView
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.epoxy.preload.EpoxyModelPreloader
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
import com.airbnb.epoxy.preload.EpoxyPreloader
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
import com.airbnb.epoxy.preload.PreloadErrorHandler
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
import com.airbnb.epoxy.preload.PreloadRequestHolder
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/
//                              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
import com.airbnb.epoxy.preload.ViewMetadata
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
import com.airbnb.viewmodeladapter.R
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/

/**
 * A RecyclerView implementation that makes for easier integration with Epoxy. The goal of this
 * class is to reduce boilerplate in setting up a RecyclerView by applying common defaults.
 * Additionally, several performance optimizations are made.
 *
 * Improvements in this class are:
 *
 * 1. A single view pool is automatically shared between all [EpoxyRecyclerView] instances in
 * the same activity. This should increase view recycling potential and increase performance when
 * nested RecyclerViews are used. See [.initViewPool].
 *
 * 2. A layout manager is automatically added with assumed defaults. See [createLayoutManager]
 *
 * 3. Fixed size is enabled if this view's size is MATCH_PARENT
 *
 * 4. If a [GridLayoutManager] is used this will automatically sync the span count with the
 * [EpoxyController]. See [syncSpanCount]
 *
 * 5. Helper methods like [withModels], [setModels], [buildModelsWith]
 * make it simpler to set up simple RecyclerViews.
 *
 * 6. Set an EpoxyController and build models in one step -
 * [setControllerAndBuildModels] or [withModels]
 *
 * 7. Support for automatic item spacing. See [.setItemSpacingPx]
 *
 * 8. Defaults for usage as a nested recyclerview are provided in [Carousel].
 *
 * 9. [setClipToPadding] is set to false by default since that behavior is commonly
 * desired in a scrolling list
 */
open class EpoxyRecyclerView @JvmOverloads constructor(
//         ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#
//                           documentation ```kt\npublic open class EpoxyRecyclerView\n```\n\n----\n\n\n A RecyclerView implementation that makes for easier integration with Epoxy. The goal of this\n class is to reduce boilerplate in setting up a RecyclerView by applying common defaults.\n Additionally, several performance optimizations are made.\n\n Improvements in this class are:\n\n 1. A single view pool is automatically shared between all [EpoxyRecyclerView] instances in\n the same activity. This should increase view recycling potential and increase performance when\n nested RecyclerViews are used. See [.initViewPool].\n\n 2. A layout manager is automatically added with assumed defaults. See [createLayoutManager]\n\n 3. Fixed size is enabled if this view's size is MATCH_PARENT\n\n 4. If a [GridLayoutManager] is used this will automatically sync the span count with the\n [EpoxyController]. See [syncSpanCount]\n\n 5. Helper methods like [withModels], [setModels], [buildModelsWith]\n make it simpler to set up simple RecyclerViews.\n\n 6. Set an EpoxyController and build models in one step -\n [setControllerAndBuildModels] or [withModels]\n\n 7. Support for automatic item spacing. See [.setItemSpacingPx]\n\n 8. Defaults for usage as a nested recyclerview are provided in [Carousel].\n\n 9. [setClipToPadding] is set to false by default since that behavior is commonly\n desired in a scrolling list\n
//                            ^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/jvm/JvmOverloads#`<init>`().
//                                         ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().
//                                                     documentation ```kt\npublic constructor EpoxyRecyclerView(context: [ERROR : Context], attrs: [ERROR : AttributeSet]? = ..., defStyleAttr: kotlin.Int = ...)\n```
    context: Context,
//  ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(context)
//          documentation ```kt\nvalue-parameter context: [ERROR : Context]\n```
    attrs: AttributeSet? = null,
//  ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(attrs)
//        documentation ```kt\nvalue-parameter attrs: [ERROR : AttributeSet]? = ...\n```
    defStyleAttr: Int = 0
//  ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(defStyleAttr)
//               documentation ```kt\nvalue-parameter defStyleAttr: kotlin.Int = ...\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
) : RecyclerView(context, attrs, defStyleAttr) {
//               ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(context)
//                        ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(attrs)
//                               ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(defStyleAttr)

    protected val spacingDecorator = EpoxyItemSpacingDecorator()
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getSpacingDecorator().
//                                 documentation ```kt\nprotected final val spacingDecorator: [ERROR : Type for EpoxyItemSpacingDecorator()]\n```
//                ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#spacingDecorator.
//                                 documentation ```kt\nprotected final val spacingDecorator: [ERROR : Type for EpoxyItemSpacingDecorator()]\n```

    private var epoxyController: EpoxyController? = null
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//                              documentation ```kt\nprivate final var epoxyController: [ERROR : EpoxyController]?\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//                              documentation ```kt\nprivate final var epoxyController: [ERROR : EpoxyController]?\n```
//              ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
//                              documentation ```kt\nprivate final var epoxyController: [ERROR : EpoxyController]?\n```

    /**
     * The adapter that was removed because the RecyclerView was detached from the window. We save it
     * so we can reattach it if the RecyclerView is reattached to window. This allows us to
     * automatically restore the adapter, without risking leaking the RecyclerView if this view is
     * never used again.
     *
     * Since the adapter is removed this recyclerview won't get adapter changes, but that's fine since
     * the view isn't attached to window and isn't being drawn.
     *
     * This reference is cleared if another adapter is manually set, so we don't override the user's
     * adapter choice.
     *
     * @see .setRemoveAdapterWhenDetachedFromWindow
     */
    private var removedAdapter: RecyclerView.Adapter<*>? = null
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemovedAdapter().
//                             documentation ```kt\nprivate final var removedAdapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```\n\n----\n\n\n The adapter that was removed because the RecyclerView was detached from the window. We save it\n so we can reattach it if the RecyclerView is reattached to window. This allows us to\n automatically restore the adapter, without risking leaking the RecyclerView if this view is\n never used again.\n\n Since the adapter is removed this recyclerview won't get adapter changes, but that's fine since\n the view isn't attached to window and isn't being drawn.\n\n This reference is cleared if another adapter is manually set, so we don't override the user's\n adapter choice.\n\n @see .setRemoveAdapterWhenDetachedFromWindow\n
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removedAdapter.
//                             documentation ```kt\nprivate final var removedAdapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```\n\n----\n\n\n The adapter that was removed because the RecyclerView was detached from the window. We save it\n so we can reattach it if the RecyclerView is reattached to window. This allows us to\n automatically restore the adapter, without risking leaking the RecyclerView if this view is\n never used again.\n\n Since the adapter is removed this recyclerview won't get adapter changes, but that's fine since\n the view isn't attached to window and isn't being drawn.\n\n This reference is cleared if another adapter is manually set, so we don't override the user's\n adapter choice.\n\n @see .setRemoveAdapterWhenDetachedFromWindow\n
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemovedAdapter().
//                             documentation ```kt\nprivate final var removedAdapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```\n\n----\n\n\n The adapter that was removed because the RecyclerView was detached from the window. We save it\n so we can reattach it if the RecyclerView is reattached to window. This allows us to\n automatically restore the adapter, without risking leaking the RecyclerView if this view is\n never used again.\n\n Since the adapter is removed this recyclerview won't get adapter changes, but that's fine since\n the view isn't attached to window and isn't being drawn.\n\n This reference is cleared if another adapter is manually set, so we don't override the user's\n adapter choice.\n\n @see .setRemoveAdapterWhenDetachedFromWindow\n

    private var removeAdapterWhenDetachedFromWindow = true
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterWhenDetachedFromWindow().
//                                                  documentation ```kt\nprivate final var removeAdapterWhenDetachedFromWindow: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterWhenDetachedFromWindow.
//                                                  documentation ```kt\nprivate final var removeAdapterWhenDetachedFromWindow: kotlin.Boolean\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().
//                                                  documentation ```kt\npublic final fun setRemoveAdapterWhenDetachedFromWindow(removeAdapterWhenDetachedFromWindow: kotlin.Boolean)\n```\n\n----\n\n\n If set to true, any adapter set on this recyclerview will be removed when this view is detached\n from the window. This is useful to prevent leaking a reference to this RecyclerView. This is\n useful in cases where the same adapter can be used across multiple views (views which can be\n destroyed and recreated), such as with fragments. In that case the adapter is not necessarily\n cleared from previous RecyclerViews, so the adapter will continue to hold a reference to those\n views and leak them. More details at https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks#parent-view\n\n The default is true, but you can disable this if you don't want your adapter detached\n automatically.\n\n If the adapter is removed via this setting, it will be re-set on the RecyclerView if the\n RecyclerView is re-attached to the window at a later point.\n

    private var delayMsWhenRemovingAdapterOnDetach: Int = DEFAULT_ADAPTER_REMOVAL_DELAY_MS
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#delayMsWhenRemovingAdapterOnDetach.
//                                                 documentation ```kt\nprivate final var delayMsWhenRemovingAdapterOnDetach: kotlin.Int\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getDelayMsWhenRemovingAdapterOnDetach().
//                                                 documentation ```kt\nprivate final var delayMsWhenRemovingAdapterOnDetach: kotlin.Int\n```
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().
//                                                 documentation ```kt\npublic final fun setDelayMsWhenRemovingAdapterOnDetach(delayMsWhenRemovingAdapterOnDetach: kotlin.Int)\n```\n\n----\n\n\n If [.setRemoveAdapterWhenDetachedFromWindow] is set to true, this is the delay\n in milliseconds between when [.onDetachedFromWindow] is called and when the adapter is\n actually removed.\n\n By default a delay of {@value #DEFAULT_ADAPTER_REMOVAL_DELAY_MS} ms is used so that view\n transitions can complete before the adapter is removed. Otherwise if the adapter is removed\n before transitions finish it can clear the screen and break the transition. A notable case is\n fragment transitions, in which the fragment view is detached from window before the transition\n ends.\n
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#DEFAULT_ADAPTER_REMOVAL_DELAY_MS.
//                                                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#getDEFAULT_ADAPTER_REMOVAL_DELAY_MS().

    /**
     * Tracks whether [.removeAdapterRunnable] has been posted to run
     * later. This lets us know if we should cancel the runnable at certain times. This removes the
     * overhead of needlessly attempting to remove the runnable when it isn't posted.
     */
    private var isRemoveAdapterRunnablePosted: Boolean = false
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//                                            documentation ```kt\nprivate final var isRemoveAdapterRunnablePosted: kotlin.Boolean\n```\n\n----\n\n\n Tracks whether [.removeAdapterRunnable] has been posted to run\n later. This lets us know if we should cancel the runnable at certain times. This removes the\n overhead of needlessly attempting to remove the runnable when it isn't posted.\n
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//                                            documentation ```kt\nprivate final var isRemoveAdapterRunnablePosted: kotlin.Boolean\n```\n\n----\n\n\n Tracks whether [.removeAdapterRunnable] has been posted to run\n later. This lets us know if we should cancel the runnable at certain times. This removes the\n overhead of needlessly attempting to remove the runnable when it isn't posted.\n
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
//                                            documentation ```kt\nprivate final var isRemoveAdapterRunnablePosted: kotlin.Boolean\n```\n\n----\n\n\n Tracks whether [.removeAdapterRunnable] has been posted to run\n later. This lets us know if we should cancel the runnable at certain times. This removes the\n overhead of needlessly attempting to remove the runnable when it isn't posted.\n
//                                             ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    private val removeAdapterRunnable = Runnable {
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterRunnable().
//                                    documentation ```kt\nprivate final val removeAdapterRunnable: java.lang.Runnable\n```
//              ^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterRunnable.
//                                    documentation ```kt\nprivate final val removeAdapterRunnable: java.lang.Runnable\n```
//                                      ^^^^^^^^ reference semanticdb maven jdk 11 java/lang/Runnable#
        if (isRemoveAdapterRunnablePosted) {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
            // Canceling a runnable doesn't work accurately when a view switches between
            // attached/detached, so we manually check that this should still be run
            isRemoveAdapterRunnablePosted = false
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
            removeAdapter()
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapter().
        }
    }

    private val preloadScrollListeners: MutableList<EpoxyPreloader<*>> = mutableListOf()
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadScrollListeners().
//                                     documentation ```kt\nprivate final val preloadScrollListeners: kotlin.collections.MutableList<com.airbnb.epoxy.preload.EpoxyPreloader<*>>\n```
//              ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadScrollListeners.
//                                     documentation ```kt\nprivate final val preloadScrollListeners: kotlin.collections.MutableList<com.airbnb.epoxy.preload.EpoxyPreloader<*>>\n```
//                                      ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
//                                                                       ^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#mutableListOf().

    private val preloadConfigs: MutableList<PreloadConfig<*, *, *>> = mutableListOf()
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadConfigs().
//                             documentation ```kt\nprivate final val preloadConfigs: kotlin.collections.MutableList<com.airbnb.epoxy.EpoxyRecyclerView.PreloadConfig<*, *, *>>\n```
//              ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadConfigs.
//                             documentation ```kt\nprivate final val preloadConfigs: kotlin.collections.MutableList<com.airbnb.epoxy.EpoxyRecyclerView.PreloadConfig<*, *, *>>\n```
//                              ^^^^^^^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#
//                                          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#
//                                                                    ^^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#mutableListOf().

    private class PreloadConfig<T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder>(
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#
//                              documentation ```kt\nprivate final class PreloadConfig<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().
//                              documentation ```kt\npublic constructor PreloadConfig<T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder>(maxPreload: kotlin.Int, errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, requestHolderFactory: () -> P)\n```
//                              ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[T]
//                                documentation ```kt\n<T>\n```
//                                                 ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[U]
//                                                   documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                                     ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                                    ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[P]
//                                                                      documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                                        ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
        val maxPreload: Int,
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().(maxPreload)
//                     documentation ```kt\nvalue-parameter maxPreload: kotlin.Int\n```
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getMaxPreload().
//                     documentation ```kt\npublic final val maxPreload: kotlin.Int\n```
//          ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#maxPreload.
//                     documentation ```kt\npublic final val maxPreload: kotlin.Int\n```
//                      ^^^ reference semanticdb maven . . kotlin/Int#
        val errorHandler: PreloadErrorHandler,
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().(errorHandler)
//                       documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#errorHandler.
//                       documentation ```kt\npublic final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//          ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getErrorHandler().
//                       documentation ```kt\npublic final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                        ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
        val preloader: EpoxyModelPreloader<T, U, P>,
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().(preloader)
//                    documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getPreloader().
//                    documentation ```kt\npublic final val preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#preloader.
//                    documentation ```kt\npublic final val preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//                     ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                         ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[T]
//                                            ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[U]
//                                               ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[P]
        val requestHolderFactory: () -> P
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().(requestHolderFactory)
//                               documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getRequestHolderFactory().
//                               documentation ```kt\npublic final val requestHolderFactory: () -> P\n```
//          ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#requestHolderFactory.
//                               documentation ```kt\npublic final val requestHolderFactory: () -> P\n```
//                                      ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#[P]
    )

    /**
     * Setup a preloader to fetch content for a model's view before it is bound.
     * This can be called multiple times if you would like to add separate preloaders
     * for different models or content types.
     *
     * Preloaders are automatically attached and run, and are updated if the adapter changes.
     *
     * @param maxPreloadDistance How many items to prefetch ahead of the last bound item
     * @param errorHandler Called when the preloader encounters an exception. We recommend throwing an
     * exception in debug builds, and logging an error in production.
     * @param preloader Describes how view content for the EpoxyModel should be preloaded
     * @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked
     */
    fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> addPreloader(
//       ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[T]
//         documentation ```kt\n<T>\n```
//                          ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[U]
//                            documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[P]
//                                               documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().
//                                                                                    documentation ```kt\npublic final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> addPreloader(maxPreloadDistance: kotlin.Int = ..., errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */, preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, requestHolderFactory: () -> P)\n```\n\n----\n\n\n Setup a preloader to fetch content for a model's view before it is bound.\n This can be called multiple times if you would like to add separate preloaders\n for different models or content types.\n\n Preloaders are automatically attached and run, and are updated if the adapter changes.\n\n @param maxPreloadDistance How many items to prefetch ahead of the last bound item\n @param errorHandler Called when the preloader encounters an exception. We recommend throwing an\n exception in debug builds, and logging an error in production.\n @param preloader Describes how view content for the EpoxyModel should be preloaded\n @param requestHolderFactory Should create and return a new [PreloadRequestHolder] each time it is invoked\n
        maxPreloadDistance: Int = 3,
//      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(maxPreloadDistance)
//                         documentation ```kt\nvalue-parameter maxPreloadDistance: kotlin.Int = ...\n```
//                          ^^^ reference semanticdb maven . . kotlin/Int#
        errorHandler: PreloadErrorHandler,
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(errorHandler)
//                   documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(preloader)
//                documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[T]
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[U]
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[P]
        requestHolderFactory: () -> P
//      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(requestHolderFactory)
//                           documentation ```kt\nvalue-parameter requestHolderFactory: () -> P\n```
//                                  ^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().[P]
    ) {
        preloadConfigs.add(
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadConfigs().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadConfigs.
//                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
            PreloadConfig(
//          ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#`<init>`().
                maxPreloadDistance,
//              ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(maxPreloadDistance)
                errorHandler,
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(errorHandler)
                preloader,
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(preloader)
                requestHolderFactory
//              ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#addPreloader().(requestHolderFactory)
            )
        )

        updatePreloaders()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#updatePreloaders().
    }

    /**
     * Clears all preloaders added with [addPreloader]
     */
    fun clearPreloaders() {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearPreloaders().
//                      documentation ```kt\npublic final fun clearPreloaders()\n```\n\n----\n\n\n Clears all preloaders added with [addPreloader]\n
        preloadConfigs.clear()
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadConfigs().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadConfigs.
//                     ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
        updatePreloaders()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#updatePreloaders().
    }

    private fun updatePreloaders() {
//              ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#updatePreloaders().
//                               documentation ```kt\nprivate final fun updatePreloaders()\n```
        preloadScrollListeners.forEach { removeOnScrollListener(it) }
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadScrollListeners().
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadScrollListeners.
//                             ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                                                              ^^ reference local 0
        preloadScrollListeners.clear()
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadScrollListeners().
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadScrollListeners.
//                             ^^^^^ reference semanticdb maven . . kotlin/collections/MutableList#clear().
        val currAdapter = adapter ?: return
//          ^^^^^^^^^^^ definition local 1
//                      documentation ```kt\nval currAdapter: [ERROR : Type for adapter ?: return]\n```

        preloadConfigs.forEach { preloadConfig ->
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadConfigs().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadConfigs.
//                     ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                               ^^^^^^^^^^^^^ definition local 2
//                                             documentation ```kt\nvalue-parameter preloadConfig: com.airbnb.epoxy.EpoxyRecyclerView.PreloadConfig<*, *, *>\n```

            if (currAdapter is EpoxyAdapter) {
//              ^^^^^^^^^^^ reference local 1
                EpoxyPreloader.with(
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
                    currAdapter,
//                  ^^^^^^^^^^^ reference local 1
                    preloadConfig.requestHolderFactory,
//                  ^^^^^^^^^^^^^ reference local 2
//                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getRequestHolderFactory().
//                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#requestHolderFactory.
                    preloadConfig.errorHandler,
//                  ^^^^^^^^^^^^^ reference local 2
//                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#errorHandler.
//                                ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getErrorHandler().
                    preloadConfig.maxPreload,
//                  ^^^^^^^^^^^^^ reference local 2
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getMaxPreload().
//                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#maxPreload.
                    listOf(preloadConfig.preloader)
//                  ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#listOf().
//                         ^^^^^^^^^^^^^ reference local 2
//                                       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getPreloader().
//                                       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#preloader.
                )
            } else {
                epoxyController?.let {
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//              ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
                    EpoxyPreloader.with(
//                  ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#
                        it,
                        preloadConfig.requestHolderFactory,
//                      ^^^^^^^^^^^^^ reference local 2
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getRequestHolderFactory().
//                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#requestHolderFactory.
                        preloadConfig.errorHandler,
//                      ^^^^^^^^^^^^^ reference local 2
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#errorHandler.
//                                    ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getErrorHandler().
                        preloadConfig.maxPreload,
//                      ^^^^^^^^^^^^^ reference local 2
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getMaxPreload().
//                                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#maxPreload.
                        listOf(preloadConfig.preloader)
//                      ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#listOf().
//                             ^^^^^^^^^^^^^ reference local 2
//                                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#getPreloader().
//                                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#PreloadConfig#preloader.
                    )
                }
            }?.let {
                preloadScrollListeners.add(it)
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadScrollListeners().
//              ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadScrollListeners.
//                                     ^^^ reference semanticdb maven . . kotlin/collections/MutableList#add().
                addOnScrollListener(it)
            }
        }
    }

    /**
     * If set to true, any adapter set on this recyclerview will be removed when this view is detached
     * from the window. This is useful to prevent leaking a reference to this RecyclerView. This is
     * useful in cases where the same adapter can be used across multiple views (views which can be
     * destroyed and recreated), such as with fragments. In that case the adapter is not necessarily
     * cleared from previous RecyclerViews, so the adapter will continue to hold a reference to those
     * views and leak them. More details at https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks#parent-view
     *
     * The default is true, but you can disable this if you don't want your adapter detached
     * automatically.
     *
     * If the adapter is removed via this setting, it will be re-set on the RecyclerView if the
     * RecyclerView is re-attached to the window at a later point.
     */
    fun setRemoveAdapterWhenDetachedFromWindow(removeAdapterWhenDetachedFromWindow: Boolean) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().
//                                             documentation ```kt\npublic final fun setRemoveAdapterWhenDetachedFromWindow(removeAdapterWhenDetachedFromWindow: kotlin.Boolean)\n```\n\n----\n\n\n If set to true, any adapter set on this recyclerview will be removed when this view is detached\n from the window. This is useful to prevent leaking a reference to this RecyclerView. This is\n useful in cases where the same adapter can be used across multiple views (views which can be\n destroyed and recreated), such as with fragments. In that case the adapter is not necessarily\n cleared from previous RecyclerViews, so the adapter will continue to hold a reference to those\n views and leak them. More details at https://github.com/airbnb/epoxy/wiki/Avoiding-Memory-Leaks#parent-view\n\n The default is true, but you can disable this if you don't want your adapter detached\n automatically.\n\n If the adapter is removed via this setting, it will be re-set on the RecyclerView if the\n RecyclerView is re-attached to the window at a later point.\n
//                                             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().(removeAdapterWhenDetachedFromWindow)
//                                                                                 documentation ```kt\nvalue-parameter removeAdapterWhenDetachedFromWindow: kotlin.Boolean\n```
//                                                                                  ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        this.removeAdapterWhenDetachedFromWindow = removeAdapterWhenDetachedFromWindow
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterWhenDetachedFromWindow().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterWhenDetachedFromWindow.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().(removeAdapterWhenDetachedFromWindow)
    }

    /**
     * If [.setRemoveAdapterWhenDetachedFromWindow] is set to true, this is the delay
     * in milliseconds between when [.onDetachedFromWindow] is called and when the adapter is
     * actually removed.
     *
     * By default a delay of {@value #DEFAULT_ADAPTER_REMOVAL_DELAY_MS} ms is used so that view
     * transitions can complete before the adapter is removed. Otherwise if the adapter is removed
     * before transitions finish it can clear the screen and break the transition. A notable case is
     * fragment transitions, in which the fragment view is detached from window before the transition
     * ends.
     */
    fun setDelayMsWhenRemovingAdapterOnDetach(delayMsWhenRemovingAdapterOnDetach: Int) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().
//                                            documentation ```kt\npublic final fun setDelayMsWhenRemovingAdapterOnDetach(delayMsWhenRemovingAdapterOnDetach: kotlin.Int)\n```\n\n----\n\n\n If [.setRemoveAdapterWhenDetachedFromWindow] is set to true, this is the delay\n in milliseconds between when [.onDetachedFromWindow] is called and when the adapter is\n actually removed.\n\n By default a delay of {@value #DEFAULT_ADAPTER_REMOVAL_DELAY_MS} ms is used so that view\n transitions can complete before the adapter is removed. Otherwise if the adapter is removed\n before transitions finish it can clear the screen and break the transition. A notable case is\n fragment transitions, in which the fragment view is detached from window before the transition\n ends.\n
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().(delayMsWhenRemovingAdapterOnDetach)
//                                                                               documentation ```kt\nvalue-parameter delayMsWhenRemovingAdapterOnDetach: kotlin.Int\n```
//                                                                                ^^^ reference semanticdb maven . . kotlin/Int#
        this.delayMsWhenRemovingAdapterOnDetach = delayMsWhenRemovingAdapterOnDetach
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#delayMsWhenRemovingAdapterOnDetach.
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getDelayMsWhenRemovingAdapterOnDetach().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().
//                                                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().(delayMsWhenRemovingAdapterOnDetach)
    }

    init {

        if (attrs != null) {
//          ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(attrs)
            val a = context.obtainStyledAttributes(
//              ^ definition local 3
//                documentation ```kt\nval a: [ERROR : <ERROR FUNCTION RETURN TYPE>]\n```
//                  ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(context)
                attrs, R.styleable.EpoxyRecyclerView,
//              ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(attrs)
                defStyleAttr, 0
//              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#`<init>`().(defStyleAttr)
            )
            setItemSpacingPx(
//          ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().
                a.getDimensionPixelSize(
//              ^ reference local 3
                    R.styleable.EpoxyRecyclerView_itemSpacing,
                    0
                )
            )
            a.recycle()
//          ^ reference local 3
        }

        init()
//      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#init().
    }

    @CallSuper
//   ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/CallSuper#`<init>`().
    protected open fun init() {
//                     ^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#init().
//                          documentation ```kt\nprotected open fun init()\n```
        clipToPadding = false
        initViewPool()
//      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#initViewPool().
    }

    /**
     * Get or create a view pool to use for this RecyclerView. By default the same pool is shared for
     * all [EpoxyRecyclerView] usages in the same Activity.
     *
     * @see .createViewPool
     * @see .shouldShareViewPoolAcrossContext
     */
    private fun initViewPool() {
//              ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#initViewPool().
//                           documentation ```kt\nprivate final fun initViewPool()\n```\n\n----\n\n\n Get or create a view pool to use for this RecyclerView. By default the same pool is shared for\n all [EpoxyRecyclerView] usages in the same Activity.\n\n @see .createViewPool\n @see .shouldShareViewPoolAcrossContext\n
        if (!shouldShareViewPoolAcrossContext()) {
//          ^ reference semanticdb maven . . kotlin/Boolean#not().
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#shouldShareViewPoolAcrossContext().
            setRecycledViewPool(createViewPool())
//                              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#createViewPool().
            return
        }

        setRecycledViewPool(
            ACTIVITY_RECYCLER_POOL.getPool(
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#ACTIVITY_RECYCLER_POOL.
//          ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#getACTIVITY_RECYCLER_POOL().
//                                 ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#getPool().
                context
            ) { createViewPool() }.viewPool
//              ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#createViewPool().
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#getViewPool().
//                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/PoolReference#viewPool.
        )
    }

    /**
     * Create a new instance of a view pool to use with this recyclerview. By default a [ ] is used.
     */
    protected open fun createViewPool(): RecyclerView.RecycledViewPool {
//                     ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#createViewPool().
//                                    documentation ```kt\nprotected open fun createViewPool(): [ERROR : RecyclerView.RecycledViewPool]\n```\n\n----\n\n\n Create a new instance of a view pool to use with this recyclerview. By default a [ ] is used.\n
        return UnboundedViewPool()
//             ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/UnboundedViewPool#`<init>`().
    }

    /**
     * To maximize view recycling by default we share the same view pool across all instances in the same Activity. This behavior can be disabled by returning
     * false here.
     */
    open fun shouldShareViewPoolAcrossContext(): Boolean {
//           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#shouldShareViewPoolAcrossContext().
//                                            documentation ```kt\npublic open fun shouldShareViewPoolAcrossContext(): kotlin.Boolean\n```\n\n----\n\n\n To maximize view recycling by default we share the same view pool across all instances in the same Activity. This behavior can be disabled by returning\n false here.\n
//                                               ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
        return true
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) {
//               ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutParams().
//                               documentation ```kt\npublic open fun setLayoutParams(params: [ERROR : ViewGroup.LayoutParams])\n```
//                               ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutParams().(params)
//                                      documentation ```kt\nvalue-parameter params: [ERROR : ViewGroup.LayoutParams]\n```
        val isFirstParams = layoutParams == null
//          ^^^^^^^^^^^^^ definition local 4
//                        documentation ```kt\nval isFirstParams: kotlin.Boolean\n```
        super.setLayoutParams(params)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                            ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutParams().(params)

        if (isFirstParams) {
//          ^^^^^^^^^^^^^ reference local 4
            // Set a default layout manager if one was not set via xml
            // We need layout params for this to guess at the right size and type
            if (layoutManager == null) {
                layoutManager = createLayoutManager()
//                              ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#createLayoutManager().
            }
        }
    }

    /**
     * Create a new [androidx.recyclerview.widget.RecyclerView.LayoutManager]
     * instance to use for this RecyclerView.
     *
     * By default a LinearLayoutManager is used, and a reasonable default is chosen for scrolling
     * direction based on layout params.
     *
     * If the RecyclerView is set to match parent size then the scrolling orientation is set to
     * vertical and [.setHasFixedSize] is set to true.
     *
     * If the height is set to wrap_content then the scrolling orientation is set to horizontal, and
     * [.setClipToPadding] is set to false.
     */
    protected open fun createLayoutManager(): RecyclerView.LayoutManager {
//                     ^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#createLayoutManager().
//                                         documentation ```kt\nprotected open fun createLayoutManager(): [ERROR : RecyclerView.LayoutManager]\n```\n\n----\n\n\n Create a new [androidx.recyclerview.widget.RecyclerView.LayoutManager]\n instance to use for this RecyclerView.\n\n By default a LinearLayoutManager is used, and a reasonable default is chosen for scrolling\n direction based on layout params.\n\n If the RecyclerView is set to match parent size then the scrolling orientation is set to\n vertical and [.setHasFixedSize] is set to true.\n\n If the height is set to wrap_content then the scrolling orientation is set to horizontal, and\n [.setClipToPadding] is set to false.\n
        val layoutParams = layoutParams
//          ^^^^^^^^^^^^ definition local 5
//                       documentation ```kt\nval layoutParams: [ERROR : Type for layoutParams]\n```

        // 0 represents matching constraints in a LinearLayout or ConstraintLayout
        if (layoutParams.height == RecyclerView.LayoutParams.MATCH_PARENT || layoutParams.height == 0) {
//          ^^^^^^^^^^^^ reference local 5
//                                                                           ^^^^^^^^^^^^ reference local 5

            if (layoutParams.width == RecyclerView.LayoutParams.MATCH_PARENT || layoutParams.width == 0) {
//              ^^^^^^^^^^^^ reference local 5
//                                                                              ^^^^^^^^^^^^ reference local 5
                // If we are filling as much space as possible then we usually are fixed size
                setHasFixedSize(true)
            }

            // A sane default is a vertically scrolling linear layout
            return LinearLayoutManager(context)
        } else {
            // This is usually the case for horizontally scrolling carousels and should be a sane
            // default
            return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun setLayoutManager(layout: RecyclerView.LayoutManager?) {
//               ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutManager().
//                                documentation ```kt\npublic open fun setLayoutManager(layout: [ERROR : RecyclerView.LayoutManager]?)\n```
//                                ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutManager().(layout)
//                                       documentation ```kt\nvalue-parameter layout: [ERROR : RecyclerView.LayoutManager]?\n```
        super.setLayoutManager(layout)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                             ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setLayoutManager().(layout)
        syncSpanCount()
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#syncSpanCount().
    }

    /**
     * If a grid layout manager is set we sync the span count between the layout and the epoxy
     * adapter automatically.
     */
    private fun syncSpanCount() {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#syncSpanCount().
//                            documentation ```kt\nprivate final fun syncSpanCount()\n```\n\n----\n\n\n If a grid layout manager is set we sync the span count between the layout and the epoxy\n adapter automatically.\n
        val layout = layoutManager
//          ^^^^^^ definition local 6
//                 documentation ```kt\nval layout: [ERROR : Type for layoutManager]\n```
        val controller = epoxyController
//          ^^^^^^^^^^ definition local 7
//                     documentation ```kt\nval controller: [ERROR : EpoxyController]?\n```
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//                       ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
        if (layout is GridLayoutManager && controller != null) {
//          ^^^^^^ reference local 6
//                                         ^^^^^^^^^^ reference local 7

            if (controller.spanCount != layout.spanCount || layout.spanSizeLookup !== controller.spanSizeLookup) {
//              ^^^^^^^^^^ reference local 7
//                                      ^^^^^^ reference local 6
//                                                          ^^^^^^ reference local 6
//                                                                                    ^^^^^^^^^^ reference local 7
                controller.spanCount = layout.spanCount
//              ^^^^^^^^^^ reference local 7
//                                     ^^^^^^ reference local 6
                layout.spanSizeLookup = controller.spanSizeLookup
//              ^^^^^^ reference local 6
//                                      ^^^^^^^^^^ reference local 7
            }
        }
    }

    override fun requestLayout() {
//               ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#requestLayout().
//                             documentation ```kt\npublic open fun requestLayout()\n```
        // Grid layout manager calls this when the span count is changed. Its the easiest way to
        // detect a span count change and update our controller accordingly.
        syncSpanCount()
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#syncSpanCount().
        super.requestLayout()
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
    }

    fun setItemSpacingRes(@DimenRes itemSpacingRes: Int) {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingRes().
//                        documentation ```kt\npublic final fun setItemSpacingRes(itemSpacingRes: kotlin.Int)\n```
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#`<init>`().
//                                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingRes().(itemSpacingRes)
//                                                 documentation ```kt\nvalue-parameter itemSpacingRes: kotlin.Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
        setItemSpacingPx(resToPx(itemSpacingRes))
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#resToPx().
//                               ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingRes().(itemSpacingRes)
    }

    fun setItemSpacingDp(@Dimension(unit = Dimension.DP) dp: Int) {
//      ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingDp().
//                       documentation ```kt\npublic final fun setItemSpacingDp(dp: kotlin.Int)\n```
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#`<init>`().
//                                  ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#`<init>`().(unit)
//                                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                       ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingDp().(dp)
//                                                          documentation ```kt\nvalue-parameter dp: kotlin.Int\n```
//                                                           ^^^ reference semanticdb maven . . kotlin/Int#
        setItemSpacingPx(dpToPx(dp))
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().
//                       ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#dpToPx().
//                              ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingDp().(dp)
    }

    /**
     * Set a pixel value to use as spacing between items. If this is a positive number an item
     * decoration will be added to space all items this far apart from each other. If the value is 0
     * or negative no extra spacing will be used, and any previous spacing will be removed.
     *
     * This only works if a [LinearLayoutManager] or [GridLayoutManager] is used with this
     * RecyclerView.
     *
     * This can also be set via the `app:itemSpacing` styleable attribute.
     *
     * @see .setItemSpacingDp
     * @see .setItemSpacingRes
     */
    open fun setItemSpacingPx(@Px spacingPx: Int) {
//           ^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().
//                            documentation ```kt\npublic open fun setItemSpacingPx(spacingPx: kotlin.Int)\n```\n\n----\n\n\n Set a pixel value to use as spacing between items. If this is a positive number an item\n decoration will be added to space all items this far apart from each other. If the value is 0\n or negative no extra spacing will be used, and any previous spacing will be removed.\n\n This only works if a [LinearLayoutManager] or [GridLayoutManager] is used with this\n RecyclerView.\n\n This can also be set via the `app:itemSpacing` styleable attribute.\n\n @see .setItemSpacingDp\n @see .setItemSpacingRes\n
//                             ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
//                                ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().(spacingPx)
//                                          documentation ```kt\nvalue-parameter spacingPx: kotlin.Int\n```
//                                           ^^^ reference semanticdb maven . . kotlin/Int#
        removeItemDecoration(spacingDecorator)
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getSpacingDecorator().
//                           ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#spacingDecorator.
        spacingDecorator.pxBetweenItems = spacingPx
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getSpacingDecorator().
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#spacingDecorator.
//                                        ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().(spacingPx)

        if (spacingPx > 0) {
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setItemSpacingPx().(spacingPx)
//                    ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).
            addItemDecoration(spacingDecorator)
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getSpacingDecorator().
//                            ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#spacingDecorator.
        }
    }

    /**
     * Set a list of [EpoxyModel]'s to show in this RecyclerView.
     *
     * Alternatively you can set an [EpoxyController] to handle building models dynamically.
     *
     * @see withModels
     * @see setController
     * @see setControllerAndBuildModels
     * @see buildModelsWith
     */

    open fun setModels(models: List<EpoxyModel<*>>) {
//           ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setModels().
//                     documentation ```kt\npublic open fun setModels(models: kotlin.collections.List<[ERROR : EpoxyModel<*>]<out [ERROR : *]>>)\n```\n\n----\n\n\n Set a list of [EpoxyModel]'s to show in this RecyclerView.\n\n Alternatively you can set an [EpoxyController] to handle building models dynamically.\n\n @see withModels\n @see setController\n @see setControllerAndBuildModels\n @see buildModelsWith\n
//                     ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setModels().(models)
//                            documentation ```kt\nvalue-parameter models: kotlin.collections.List<[ERROR : EpoxyModel<*>]<out [ERROR : *]>>\n```
//                             ^^^^ reference semanticdb maven . . kotlin/collections/List#
        val controller = (epoxyController as? SimpleEpoxyController)
//          ^^^^^^^^^^ definition local 8
//                     documentation ```kt\nval controller: ???\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
            ?: SimpleEpoxyController().also {
                setController(it)
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().
            }

        controller.setModels(models)
//      ^^^^^^^^^^ reference local 8
//                           ^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setModels().(models)
    }

    /**
     * Set an EpoxyController to populate this RecyclerView. This does not make the controller build
     * its models, that must be done separately via [requestModelBuild].
     *
     * Use this if you don't want [requestModelBuild] called automatically. Common cases
     * are if you are using [TypedEpoxyController] (in which case you must call setData on the
     * controller), or if you have not otherwise populated your controller's data yet.
     *
     * Otherwise if you want models built automatically for you use [setControllerAndBuildModels]
     *
     * The controller can be cleared with [clear]
     *
     * @see .setControllerAndBuildModels
     * @see .buildModelsWith
     * @see .setModels
     */

    fun setController(controller: EpoxyController) {
//      ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().
//                    documentation ```kt\npublic final fun setController(controller: [ERROR : EpoxyController])\n```\n\n----\n\n\n Set an EpoxyController to populate this RecyclerView. This does not make the controller build\n its models, that must be done separately via [requestModelBuild].\n\n Use this if you don't want [requestModelBuild] called automatically. Common cases\n are if you are using [TypedEpoxyController] (in which case you must call setData on the\n controller), or if you have not otherwise populated your controller's data yet.\n\n Otherwise if you want models built automatically for you use [setControllerAndBuildModels]\n\n The controller can be cleared with [clear]\n\n @see .setControllerAndBuildModels\n @see .buildModelsWith\n @see .setModels\n
//                    ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().(controller)
//                               documentation ```kt\nvalue-parameter controller: [ERROR : EpoxyController]\n```
        epoxyController = controller
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
//                        ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().(controller)
        adapter = controller.adapter
//                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().(controller)
        syncSpanCount()
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#syncSpanCount().
    }

    /**
     * Set an EpoxyController to populate this RecyclerView, and tell the controller to build
     * models.
     *
     * The controller can be cleared with [clear]
     *
     * @see setController
     * @see buildModelsWith
     * @see setModels
     */
    fun setControllerAndBuildModels(controller: EpoxyController) {
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setControllerAndBuildModels().
//                                  documentation ```kt\npublic final fun setControllerAndBuildModels(controller: [ERROR : EpoxyController])\n```\n\n----\n\n\n Set an EpoxyController to populate this RecyclerView, and tell the controller to build\n models.\n\n The controller can be cleared with [clear]\n\n @see setController\n @see buildModelsWith\n @see setModels\n
//                                  ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setControllerAndBuildModels().(controller)
//                                             documentation ```kt\nvalue-parameter controller: [ERROR : EpoxyController]\n```
        controller.requestModelBuild()
//      ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setControllerAndBuildModels().(controller)
        setController(controller)
//      ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().
//                    ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setControllerAndBuildModels().(controller)
    }

    /**
     * The simplest way to add models to the RecyclerView without needing to create an EpoxyController.
     * This is intended for Kotlin usage, and has the EpoxyController as the lambda receiver so
     * models can be added easily.
     *
     * Multiple calls to this will reuse the same underlying EpoxyController so views in the
     * RecyclerView will be reused.
     *
     * The Java equivalent is [buildModelsWith].
     */
    fun withModels(buildModels: EpoxyController.() -> Unit) {
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#withModels().
//                 documentation ```kt\npublic final fun withModels(buildModels: [ERROR : EpoxyController].() -> kotlin.Unit)\n```\n\n----\n\n\n The simplest way to add models to the RecyclerView without needing to create an EpoxyController.\n This is intended for Kotlin usage, and has the EpoxyController as the lambda receiver so\n models can be added easily.\n\n Multiple calls to this will reuse the same underlying EpoxyController so views in the\n RecyclerView will be reused.\n\n The Java equivalent is [buildModelsWith].\n
//                 ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#withModels().(buildModels)
//                             documentation ```kt\nvalue-parameter buildModels: [ERROR : EpoxyController].() -> kotlin.Unit\n```
//                                                    ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#
        val controller = (epoxyController as? WithModelsController)
//          ^^^^^^^^^^ definition local 9
//                     documentation ```kt\nval controller: com.airbnb.epoxy.EpoxyRecyclerView.WithModelsController\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
//                                            ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#
            ?: WithModelsController().also { setController(it) }
//             ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#`<init>`().
//                                    ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#also().
//                                           ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().
//                                                         ^^ reference local 10

        controller.callback = buildModels
//      ^^^^^^^^^^ reference local 9
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#callback.
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#getCallback().
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#setCallback().
//                            ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#withModels().(buildModels)
        controller.requestModelBuild()
//      ^^^^^^^^^^ reference local 9
    }

    private class WithModelsController : EpoxyController() {
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#
//                                     documentation ```kt\nprivate final class WithModelsController\n```
//                ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#`<init>`().
//                                     documentation ```kt\npublic constructor WithModelsController()\n```
        var callback: EpoxyController.() -> Unit = {}
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#callback.
//                   documentation ```kt\npublic final var callback: [ERROR : EpoxyController].() -> kotlin.Unit\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#getCallback().
//                   documentation ```kt\npublic final var callback: [ERROR : EpoxyController].() -> kotlin.Unit\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#setCallback().
//                   documentation ```kt\npublic final var callback: [ERROR : EpoxyController].() -> kotlin.Unit\n```
//                                          ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Unit#

        override fun buildModels() {
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#buildModels().
//                               documentation ```kt\npublic open fun buildModels()\n```
            callback(this)
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#callback.
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#getCallback().
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#setCallback().
//                   ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#WithModelsController#
        }
    }

    /**
     * Allows you to build models via a callback instead of needing to create a new EpoxyController
     * class. This is useful if your models are simple and you would like to simply declare them in
     * your activity/fragment.
     *
     * Multiple calls to this will reuse the same underlying EpoxyController so views in the
     * RecyclerView will be reused.
     *
     * Another useful pattern is having your Activity or Fragment implement [ModelBuilderCallback].
     *
     * If you're using Kotlin, prefer [withModels].
     *
     * @see setController
     * @see setControllerAndBuildModels
     * @see setModels
     */
    fun buildModelsWith(callback: ModelBuilderCallback) {
//      ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#buildModelsWith().
//                      documentation ```kt\npublic final fun buildModelsWith(callback: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallback)\n```\n\n----\n\n\n Allows you to build models via a callback instead of needing to create a new EpoxyController\n class. This is useful if your models are simple and you would like to simply declare them in\n your activity/fragment.\n\n Multiple calls to this will reuse the same underlying EpoxyController so views in the\n RecyclerView will be reused.\n\n Another useful pattern is having your Activity or Fragment implement [ModelBuilderCallback].\n\n If you're using Kotlin, prefer [withModels].\n\n @see setController\n @see setControllerAndBuildModels\n @see setModels\n
//                      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#buildModelsWith().(callback)
//                               documentation ```kt\nvalue-parameter callback: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallback\n```
//                                ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#
        val controller = (epoxyController as? ModelBuilderCallbackController)
//          ^^^^^^^^^^ definition local 11
//                     documentation ```kt\nval controller: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallbackController\n```
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//                        ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
//                                            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#
            ?: ModelBuilderCallbackController().also { setController(it) }
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#`<init>`().
//                                              ^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/StandardKt#also().
//                                                     ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setController().
//                                                                   ^^ reference local 12

        controller.callback = callback
//      ^^^^^^^^^^ reference local 11
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#callback.
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#getCallback().
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#setCallback().
//                            ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#buildModelsWith().(callback)
        controller.requestModelBuild()
//      ^^^^^^^^^^ reference local 11
    }

    private class ModelBuilderCallbackController : EpoxyController() {
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#
//                                               documentation ```kt\nprivate final class ModelBuilderCallbackController\n```
//                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#`<init>`().
//                                               documentation ```kt\npublic constructor ModelBuilderCallbackController()\n```
        var callback: ModelBuilderCallback = object : ModelBuilderCallback {
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#callback.
//                   documentation ```kt\npublic final var callback: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallback\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#getCallback().
//                   documentation ```kt\npublic final var callback: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallback\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#setCallback().
//                   documentation ```kt\npublic final var callback: com.airbnb.epoxy.EpoxyRecyclerView.ModelBuilderCallback\n```
//                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#
//                                                    ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#
            override fun buildModels(controller: EpoxyController) {
//                       ^^^^^^^^^^^ definition local 13
//                                   documentation ```kt\npublic open fun buildModels(controller: [ERROR : EpoxyController])\n```
//                                   ^^^^^^^^^^ definition local 14
//                                              documentation ```kt\nvalue-parameter controller: [ERROR : EpoxyController]\n```
            }
        }

        override fun buildModels() {
//                   ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#buildModels().
//                               documentation ```kt\npublic open fun buildModels()\n```
            callback.buildModels(this)
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#callback.
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#getCallback().
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#setCallback().
//                   ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#buildModels().
//                               ^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallbackController#
        }
    }

    /**
     * A callback for creating models without needing a custom EpoxyController class. Used with [buildModelsWith]
     */
    interface ModelBuilderCallback {
//            ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#
//                                 documentation ```kt\npublic interface ModelBuilderCallback\n```\n\n----\n\n\n A callback for creating models without needing a custom EpoxyController class. Used with [buildModelsWith]\n
        /**
         * Analagous to [EpoxyController.buildModels]. You should create new model instances and
         * add them to the given controller. [AutoModel] cannot be used with models added this
         * way.
         */
        fun buildModels(controller: EpoxyController)
//          ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#buildModels().
//                      documentation ```kt\npublic abstract fun buildModels(controller: [ERROR : EpoxyController])\n```\n\n----\n\n\n Analagous to [EpoxyController.buildModels]. You should create new model instances and\n add them to the given controller. [AutoModel] cannot be used with models added this\n way.\n
//                      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#ModelBuilderCallback#buildModels().(controller)
//                                 documentation ```kt\nvalue-parameter controller: [ERROR : EpoxyController]\n```
    }

    /**
     * Request that the currently set EpoxyController has its models rebuilt. You can use this to
     * avoid saving your controller as a field.
     *
     * You cannot use this if your controller is a [TypedEpoxyController] or if you set
     * models via [setModels]. In that case you must set data directly on the
     * controller or set models again.
     */
    fun requestModelBuild() {
//      ^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#requestModelBuild().
//                        documentation ```kt\npublic final fun requestModelBuild()\n```\n\n----\n\n\n Request that the currently set EpoxyController has its models rebuilt. You can use this to\n avoid saving your controller as a field.\n\n You cannot use this if your controller is a [TypedEpoxyController] or if you set\n models via [setModels]. In that case you must set data directly on the\n controller or set models again.\n
        if (epoxyController == null) {
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
            throw IllegalStateException("A controller must be set before requesting a model build.")
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
        }

        if (epoxyController is SimpleEpoxyController) {
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//          ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
            throw IllegalStateException("Models were set with #setModels, they can not be rebuilt.")
//                ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . kotlin/IllegalStateException#`<init>`(+1).
        }

        epoxyController!!.requestModelBuild()
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
    }

    /**
     * Clear the currently set EpoxyController or Adapter as well as any models that are displayed.
     *
     * Any pending requests to the EpoxyController to build models are canceled.
     *
     * Any existing child views are recycled to the view pool.
     */
    open fun clear() {
//           ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clear().
//                 documentation ```kt\npublic open fun clear()\n```\n\n----\n\n\n Clear the currently set EpoxyController or Adapter as well as any models that are displayed.\n\n Any pending requests to the EpoxyController to build models are canceled.\n\n Any existing child views are recycled to the view pool.\n
        // The controller is cleared so the next time models are set we can create a fresh one.
        epoxyController?.cancelPendingModelBuild()
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().
        epoxyController = null
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#epoxyController.
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getEpoxyController().
//      ^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setEpoxyController().

        // We use swapAdapter instead of setAdapter so that the view pool is not cleared.
        // 'removeAndRecycleExistingViews=true' is used in case this is a nested recyclerview
        // and we want to recycle the views back to a shared view pool
        swapAdapter(null, true)
//      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().
    }

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    protected fun dpToPx(@Dimension(unit = Dimension.DP) dp: Int): Int {
//                ^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#dpToPx().
//                       documentation ```kt\nprotected final fun dpToPx(dp: kotlin.Int): kotlin.Int\n```
//                        ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#`<init>`().
//                                  ^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#`<init>`().(unit)
//                                         ^^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#
//                                                   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Dimension#DP.
//                                                       ^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#dpToPx().(dp)
//                                                          documentation ```kt\nvalue-parameter dp: kotlin.Int\n```
//                                                           ^^^ reference semanticdb maven . . kotlin/Int#
//                                                                 ^^^ reference semanticdb maven . . kotlin/Int#
        return TypedValue
            .applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
//                                           ^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#dpToPx().(dp)
//                                              ^^^^^^^ reference semanticdb maven . . kotlin/Int#toFloat().
                resources.displayMetrics
            ).toInt()
    }

    @Px
//   ^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/Px#`<init>`().
    protected fun resToPx(@DimenRes itemSpacingRes: Int): Int {
//                ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#resToPx().
//                        documentation ```kt\nprotected final fun resToPx(itemSpacingRes: kotlin.Int): kotlin.Int\n```
//                         ^^^^^^^^ reference semanticdb maven maven/androidx.annotation/annotation 1.1.0 androidx/annotation/DimenRes#`<init>`().
//                                  ^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#resToPx().(itemSpacingRes)
//                                                 documentation ```kt\nvalue-parameter itemSpacingRes: kotlin.Int\n```
//                                                  ^^^ reference semanticdb maven . . kotlin/Int#
//                                                        ^^^ reference semanticdb maven . . kotlin/Int#
        return resources.getDimensionPixelOffset(itemSpacingRes)
//                                               ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#resToPx().(itemSpacingRes)
    }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
//               ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setAdapter().
//                          documentation ```kt\npublic open fun setAdapter(adapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?)\n```
//                          ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setAdapter().(adapter)
//                                  documentation ```kt\nvalue-parameter adapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```
        super.setAdapter(adapter)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setAdapter().(adapter)

        clearRemovedAdapterAndCancelRunnable()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearRemovedAdapterAndCancelRunnable().
        updatePreloaders()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#updatePreloaders().
    }

    override fun swapAdapter(
//               ^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().
//                           documentation ```kt\npublic open fun swapAdapter(adapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?, removeAndRecycleExistingViews: kotlin.Boolean)\n```
        adapter: RecyclerView.Adapter<*>?,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().(adapter)
//              documentation ```kt\nvalue-parameter adapter: [ERROR : RecyclerView.Adapter<*>]<out [ERROR : *]>?\n```
        removeAndRecycleExistingViews: Boolean
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().(removeAndRecycleExistingViews)
//                                    documentation ```kt\nvalue-parameter removeAndRecycleExistingViews: kotlin.Boolean\n```
//                                     ^^^^^^^ reference semanticdb maven . . kotlin/Boolean#
    ) {
        super.swapAdapter(adapter, removeAndRecycleExistingViews)
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
//                        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().(adapter)
//                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().(removeAndRecycleExistingViews)

        clearRemovedAdapterAndCancelRunnable()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearRemovedAdapterAndCancelRunnable().
        updatePreloaders()
//      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#updatePreloaders().
    }

    public override fun onAttachedToWindow() {
//                      ^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#onAttachedToWindow().
//                                         documentation ```kt\npublic open fun onAttachedToWindow()\n```
        super.onAttachedToWindow()
//      ^^^^^ reference semanticdb maven . . kotlin/Any#

        if (removedAdapter != null) {
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemovedAdapter().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removedAdapter.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemovedAdapter().
            // Restore the adapter that was removed when the view was detached from window
            swapAdapter(removedAdapter, false)
//          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemovedAdapter().
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removedAdapter.
//                      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemovedAdapter().
        }
        clearRemovedAdapterAndCancelRunnable()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearRemovedAdapterAndCancelRunnable().
    }

    public override fun onDetachedFromWindow() {
//                      ^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#onDetachedFromWindow().
//                                           documentation ```kt\npublic open fun onDetachedFromWindow()\n```
        super.onDetachedFromWindow()
//      ^^^^^ reference semanticdb maven . . kotlin/Any#
        preloadScrollListeners.forEach { it.cancelPreloadRequests() }
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getPreloadScrollListeners().
//      ^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#preloadScrollListeners.
//                             ^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#forEach(+10).
//                                       ^^ reference local 15
//                                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloader#cancelPreloadRequests().

        if (removeAdapterWhenDetachedFromWindow) {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterWhenDetachedFromWindow().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterWhenDetachedFromWindow.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemoveAdapterWhenDetachedFromWindow().
            if (delayMsWhenRemovingAdapterOnDetach > 0) {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#delayMsWhenRemovingAdapterOnDetach.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getDelayMsWhenRemovingAdapterOnDetach().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().
//                                                 ^ reference semanticdb maven . . kotlin/Int#compareTo(+3).

                isRemoveAdapterRunnablePosted = true
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
                postDelayed(removeAdapterRunnable, delayMsWhenRemovingAdapterOnDetach.toLong())
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterRunnable().
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterRunnable.
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#delayMsWhenRemovingAdapterOnDetach.
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getDelayMsWhenRemovingAdapterOnDetach().
//                                                 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setDelayMsWhenRemovingAdapterOnDetach().
//                                                                                    ^^^^^^ reference semanticdb maven . . kotlin/Int#toLong().
            } else {
                removeAdapter()
//              ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapter().
            }
        }
        clearPoolIfActivityIsDestroyed()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearPoolIfActivityIsDestroyed().
    }

    private fun removeAdapter() {
//              ^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapter().
//                            documentation ```kt\nprivate final fun removeAdapter()\n```
        val currentAdapter = adapter
//          ^^^^^^^^^^^^^^ definition local 16
//                         documentation ```kt\nval currentAdapter: [ERROR : Type for adapter]\n```
        if (currentAdapter != null) {
//          ^^^^^^^^^^^^^^ reference local 16
            // Clear the adapter so the adapter releases its reference to this RecyclerView.
            // Views are recycled so they can return to a view pool (default behavior is to not recycle
            // them).
            swapAdapter(null, true)
//          ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#swapAdapter().
            // Keep a reference to the removed adapter so we can add it back if the recyclerview is
            // attached again.
            removedAdapter = currentAdapter
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemovedAdapter().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removedAdapter.
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemovedAdapter().
//                           ^^^^^^^^^^^^^^ reference local 16
        }

        // Do this after clearing the adapter, since that sends views back to the pool
        clearPoolIfActivityIsDestroyed()
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearPoolIfActivityIsDestroyed().
    }

    private fun clearRemovedAdapterAndCancelRunnable() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearRemovedAdapterAndCancelRunnable().
//                                                   documentation ```kt\nprivate final fun clearRemovedAdapterAndCancelRunnable()\n```
        removedAdapter = null
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemovedAdapter().
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removedAdapter.
//      ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setRemovedAdapter().
        if (isRemoveAdapterRunnablePosted) {
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
            removeCallbacks(removeAdapterRunnable)
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getRemoveAdapterRunnable().
//                          ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#removeAdapterRunnable.
            isRemoveAdapterRunnablePosted = false
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#getIsRemoveAdapterRunnablePosted().
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#isRemoveAdapterRunnablePosted.
//          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#setIsRemoveAdapterRunnablePosted().
        }
    }

    private fun clearPoolIfActivityIsDestroyed() {
//              ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#clearPoolIfActivityIsDestroyed().
//                                             documentation ```kt\nprivate final fun clearPoolIfActivityIsDestroyed()\n```
        // Views in the pool hold context references which can keep the activity from being GC'd,
        // plus they can hold significant memory resources. We should clear it asap after the pool
        // is no longer needed - the main signal we use for this is that the activity is destroyed.
        if (context.isActivityDestroyed()) {
            recycledViewPool.clear()
        }
    }

    companion object {
//            ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion# 1:0
//                     documentation ```kt\npublic companion object\n```
        private const val DEFAULT_ADAPTER_REMOVAL_DELAY_MS = 2000
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#DEFAULT_ADAPTER_REMOVAL_DELAY_MS.
//                                                         documentation ```kt\nprivate const final val DEFAULT_ADAPTER_REMOVAL_DELAY_MS: kotlin.Int\n```
//                        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#getDEFAULT_ADAPTER_REMOVAL_DELAY_MS().
//                                                         documentation ```kt\nprivate const final val DEFAULT_ADAPTER_REMOVAL_DELAY_MS: kotlin.Int\n```

        /**
         * Store one unique pool per activity. They are cleared out when activities are destroyed, so this
         * only needs to hold pools for active activities.
         */
        private val ACTIVITY_RECYCLER_POOL = ActivityRecyclerPool()
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#ACTIVITY_RECYCLER_POOL.
//                                         documentation ```kt\nprivate final val ACTIVITY_RECYCLER_POOL: com.airbnb.epoxy.ActivityRecyclerPool\n```\n\n----\n\n\n Store one unique pool per activity. They are cleared out when activities are destroyed, so this\n only needs to hold pools for active activities.\n
//                  ^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/EpoxyRecyclerView#Companion#getACTIVITY_RECYCLER_POOL().
//                                         documentation ```kt\nprivate final val ACTIVITY_RECYCLER_POOL: com.airbnb.epoxy.ActivityRecyclerPool\n```\n\n----\n\n\n Store one unique pool per activity. They are cleared out when activities are destroyed, so this\n only needs to hold pools for active activities.\n
//                                           ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/ActivityRecyclerPool#`<init>`().
    }
}
