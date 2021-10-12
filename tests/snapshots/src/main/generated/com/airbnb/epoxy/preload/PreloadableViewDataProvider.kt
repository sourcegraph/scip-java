package com.airbnb.epoxy.preload
//      ^^^ reference com/
//          ^^^^^^ reference com/airbnb/
//                 ^^^^^ reference com/airbnb/epoxy/
//                       ^^^^^^^ reference com/airbnb/epoxy/preload/

import android.view.View
import androidx.core.view.ViewCompat
//     ^^^^^^^^ reference androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
import com.airbnb.epoxy.boundViewHoldersInternal
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().
import com.airbnb.epoxy.objectToBindInternal
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().
import com.airbnb.epoxy.viewTypeInternal
//     ^^^ reference com/
//         ^^^^^^ reference com/airbnb/
//                ^^^^^ reference com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().

/**
 * In order to preload content we need to know the size of the view that they it be loaded into.
 * This class provides the view size, as well as other view metadata that might be necessary to construct the preload request.
 */
internal class PreloadableViewDataProvider(
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().
    val adapter: BaseEpoxyAdapter,
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(adapter)
    val errorHandler: PreloadErrorHandler
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#errorHandler.
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getErrorHandler().
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(errorHandler)
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
) {

    /**
     * A given model class might have different sized preloadable views depending on configuration.
     * We use this cache key to separate view configurations.
     */
    private data class CacheKey(
//                     ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
//                     ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().
        val epoxyModelClass: Class<out EpoxyModel<*>>,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#epoxyModelClass.
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getEpoxyModelClass().
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(epoxyModelClass)
//                           ^^^^^ reference java/lang/Class#
        val spanSize: Int,
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#spanSize.
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSpanSize().
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(spanSize)
//                    ^^^ reference kotlin/Int#
        val viewType: Int,
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#viewType.
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getViewType().
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(viewType)
//                    ^^^ reference kotlin/Int#
        /** An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins */
        val signature: Any?
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#signature.
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSignature().
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(signature)
//                     ^^^ reference kotlin/Any#
    )

    private val cache = mutableMapOf<CacheKey, List<ViewData<*>>?>()
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cache.
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getCache().
//                      ^^^^^^^^^^^^ reference kotlin/collections/MapsKt#mutableMapOf().
//                                   ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
//                                             ^^^^ reference kotlin/collections/List#
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#

    /** @return A list containing the data necessary to load each view in the given model. */
    fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> dataForModel(
//       ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
//                          ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                             ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P]
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
        position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(position)
//                ^^^ reference kotlin/Int#
    ): List<ViewData<U>> {
//     ^^^^ reference kotlin/collections/List#
//          ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                   ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
        val cacheKey = cacheKey(preloader, epoxyModel, position)
//          ^^^^^^^^ definition local0
//                     ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
//                              ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                                         ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                                                     ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(position)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference kotlin/Suppress#`<init>`().
        return cache.getOrPut(cacheKey) {
//             ^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cache.
//             ^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getCache().
//                   ^^^^^^^^ reference kotlin/collections/MapsKt#getOrPut(+1).
//                            ^^^^^^^^ reference local0
            // Look up view data based on currently bound views. This can be null if a matching view type is not found.
            // In that case we save the null so we know to try the lookup again next time.
            findViewData(preloader, epoxyModel, cacheKey)
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().
//                       ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                                              ^^^^^^^^ reference local0
        } as? List<ViewData<U>> ?: return emptyList()
//            ^^^^ reference kotlin/collections/List#
//                 ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                          ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                                        ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
    }

    private fun <T : EpoxyModel<*>> cacheKey(
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
//                                  ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
        preloader: EpoxyModelPreloader<T, *, *>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(preloader)
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(position)
//                ^^^ reference kotlin/Int#
    ): CacheKey {
//     ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
        val modelSpanSize = if (adapter.isMultiSpan) {
//          ^^^^^^^^^^^^^ definition local1
//                              ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                              ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
            epoxyModel.spanSize(adapter.spanCount, position, adapter.itemCount)
//          ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                              ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                              ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
//                                                 ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(position)
//                                                           ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                                                           ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
        } else {
            1
        }

        return CacheKey(
//             ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().
            epoxyModel.javaClass,
//          ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
            modelSpanSize,
//          ^^^^^^^^^^^^^ reference local1
            epoxyModel.viewTypeInternal(),
//          ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                     ^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().
            preloader.viewSignature(epoxyModel)
//          ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(preloader)
//                    ^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().
//                                  ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
        )
    }

    private fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> findViewData(
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                  ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P]
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                               ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
        cacheKey: CacheKey
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(cacheKey)
//                ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
    ): List<ViewData<U>>? {
//     ^^^^ reference kotlin/collections/List#
//          ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                   ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
        // It is a bit tricky to get details on the view to be preloaded, since the view doesn't necessarily exist at the time of preload.
        // This approach looks at currently bound views and tries to get one who's cache key is the same as what we need.
        // This should mostly work, since RecyclerViews are generally the same type of views shown repeatedly.
        // If a model is only shown sporadically we may never be able to get data about it with this approach, which we could address in the future.

        val holderMatch = adapter.boundViewHoldersInternal().find {
//          ^^^^^^^^^^^ definition local2
//                        ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                        ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
            val boundModel = it.model
//              ^^^^^^^^^^ definition local3
            if (boundModel::class == epoxyModel::class) {
//              ^^^^^^^^^^ reference local3
//                                   ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
                @Suppress("UNCHECKED_CAST")
//               ^^^^^^^^ reference kotlin/Suppress#`<init>`().
                // We need the view sizes, but viewholders can be bound without actually being laid out on screen yet
                ViewCompat.isAttachedToWindow(it.itemView) &&
                    ViewCompat.isLaidOut(it.itemView) &&
                    cacheKey(preloader, boundModel as T, it.adapterPosition) == cacheKey
//                  ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
//                           ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                                      ^^^^^^^^^^ reference local3
//                                                    ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                                                           ^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#equals().
//                                                                              ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(cacheKey)
            } else {
                false
            }
        }

        val rootView = holderMatch?.itemView ?: return null
//          ^^^^^^^^ definition local4
//                     ^^^^^^^^^^^ reference local2

        val boundObject = holderMatch.objectToBindInternal() // Allows usage of view holder models
//          ^^^^^^^^^^^ definition local5
//                        ^^^^^^^^^^^ reference local2

        val preloadableViews: List<View> = when {
//          ^^^^^^^^^^^^^^^^ definition local6
//                            ^^^^ reference kotlin/collections/List#
            preloader.preloadableViewIds.isNotEmpty() -> rootView.findViews(
//          ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
//                    ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
//                                       ^^^^^^^^^^ reference kotlin/collections/CollectionsKt#isNotEmpty(+9).
//                                                       ^^^^^^^^ reference local4
//                                                                ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
                preloader.preloadableViewIds,
//              ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                        ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
//                        ^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
                epoxyModel
//              ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
            )
            rootView is Preloadable -> rootView.viewsToPreload
//          ^^^^^^^^ reference local4
//                      ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/Preloadable#
//                                     ^^^^^^^^ reference local4
            boundObject is Preloadable -> boundObject.viewsToPreload
//          ^^^^^^^^^^^ reference local5
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/Preloadable#
//                                        ^^^^^^^^^^^ reference local5
            else -> emptyList()
//                  ^^^^^^^^^ reference kotlin/collections/CollectionsKt#emptyList().
        }

        if (preloadableViews.isEmpty()) {
//          ^^^^^^^^^^^^^^^^ reference local6
//                           ^^^^^^^ reference kotlin/collections/List#isEmpty().
            errorHandler(rootView.context, EpoxyPreloadException("No preloadable views were found in ${epoxyModel.javaClass.simpleName}"))
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#errorHandler.
//          ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getErrorHandler().
//                       ^^^^^^^^ reference local4
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().
//                                                                                                     ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
        }

        return preloadableViews
//             ^^^^^^^^^^^^^^^^ reference local6
            .flatMap { it.recursePreloadableViews() }
//           ^^^^^^^ reference kotlin/collections/CollectionsKt#flatMap(+10).
//                     ^^ reference local7
            .mapNotNull { it.buildData(preloader, epoxyModel) }
//                                     ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                                                ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
    }

    /** Returns child views with the given view ids. */
    private fun <T : EpoxyModel<*>> View.findViews(
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T]
//                                       ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
        viewIds: List<Int>,
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds)
//               ^^^^ reference kotlin/collections/List#
//                    ^^^ reference kotlin/Int#
        epoxyModel: T
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T]
    ): List<View> {
//     ^^^^ reference kotlin/collections/List#
        return viewIds.mapNotNull { id ->
//             ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds)
//                     ^^^^^^^^^^ reference kotlin/collections/CollectionsKt#mapNotNull(+1).
//                                  ^^ definition local8
            findViewById<View>(id).apply {
//                             ^^ reference local8
                if (this == null) errorHandler(context, EpoxyPreloadException("View with id $id in ${epoxyModel.javaClass.simpleName} could not be found."))
//                  ^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
//                                                                                           ^^ reference local8
//                                                                                                   ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(epoxyModel)
            }
        }
    }

    /** If a View with the [Preloadable] interface is used we want to get all of the preloadable views contained in that Preloadable instead. */
    private fun <T : View> T.recursePreloadableViews(): List<View> {
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T]
//                         ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T]
//                           ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
//                                                      ^^^^ reference kotlin/collections/List#
        return if (this is Preloadable) {
//                 ^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
//                         ^^^^^^^^^^^ reference com/airbnb/epoxy/preload/Preloadable#
            viewsToPreload.flatMap { it.recursePreloadableViews() }
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/Preloadable#viewsToPreload.
//          ^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/Preloadable#getViewsToPreload().
//                         ^^^^^^^ reference kotlin/collections/CollectionsKt#flatMap(+10).
//                                   ^^ reference local9
        } else {
            listOf(this)
//          ^^^^^^ reference kotlin/collections/CollectionsKt#listOf().
//                 ^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
        }
    }

    private fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> View.buildData(
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
//                                  ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P]
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                    ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(preloader)
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P]
        epoxyModel: T
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(epoxyModel)
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
    ): ViewData<U>? {
//     ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//              ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]

        // Glide's internal size determiner takes view dimensions and subtracts padding to get target size.
        // TODO: We could support size overrides by allowing the preloader to specify a size override callback
        val width = width - paddingLeft - paddingRight
//          ^^^^^ definition local10
        val height = height - paddingTop - paddingBottom
//          ^^^^^^ definition local11

        if (width <= 0 || height <= 0) {
//          ^^^^^ reference local10
//                        ^^^^^^ reference local11
            // If no placeholder or aspect ratio is used then the view might be empty before its content loads
            errorHandler(context, EpoxyPreloadException("${this.javaClass.simpleName} in ${epoxyModel.javaClass.simpleName} has zero size. A size must be set to allow preloading."))
//                                                         ^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
//                                                                                         ^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(epoxyModel)
            return null
        }

        return ViewData(
            id,
            width,
//          ^^^^^ reference local10
            height,
//          ^^^^^^ reference local11
            preloader.buildViewMetadata(this)
//          ^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(preloader)
//                    ^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().
//                                      ^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
        )
    }
}
