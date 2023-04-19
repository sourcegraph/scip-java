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
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider# internal final class PreloadableViewDataProvider
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`(). public constructor PreloadableViewDataProvider(adapter: [ERROR : BaseEpoxyAdapter], errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */)
    val adapter: BaseEpoxyAdapter,
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter. public final val adapter: [ERROR : BaseEpoxyAdapter]
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter(). public final val adapter: [ERROR : BaseEpoxyAdapter]
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(adapter) value-parameter adapter: [ERROR : BaseEpoxyAdapter]
    val errorHandler: PreloadErrorHandler
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#errorHandler. public final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getErrorHandler(). public final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */
//      ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(errorHandler) value-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([ERROR : Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */
//                    ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadErrorHandler#
) {

    /**
     * A given model class might have different sized preloadable views depending on configuration.
     * We use this cache key to separate view configurations.
     */
    private data class CacheKey(
//                     ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey# private final data class CacheKey
//                     ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`(). public constructor CacheKey(epoxyModelClass: java.lang.Class<out [ERROR : EpoxyModel<*>]<out [ERROR : *]>>, spanSize: kotlin.Int, viewType: kotlin.Int, signature: kotlin.Any?)
        val epoxyModelClass: Class<out EpoxyModel<*>>,
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#epoxyModelClass. public final val epoxyModelClass: java.lang.Class<out [ERROR : EpoxyModel<*>]<out [ERROR : *]>>
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getEpoxyModelClass(). public final val epoxyModelClass: java.lang.Class<out [ERROR : EpoxyModel<*>]<out [ERROR : *]>>
//          ^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(epoxyModelClass) value-parameter epoxyModelClass: java.lang.Class<out [ERROR : EpoxyModel<*>]<out [ERROR : *]>>
//                           ^^^^^ reference java/lang/Class#
        val spanSize: Int,
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#spanSize. public final val spanSize: kotlin.Int
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSpanSize(). public final val spanSize: kotlin.Int
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(spanSize) value-parameter spanSize: kotlin.Int
//                    ^^^ reference kotlin/Int#
        val viewType: Int,
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#viewType. public final val viewType: kotlin.Int
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getViewType(). public final val viewType: kotlin.Int
//          ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(viewType) value-parameter viewType: kotlin.Int
//                    ^^^ reference kotlin/Int#
        /** An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins */
        val signature: Any?
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#signature. public final val signature: kotlin.Any?
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSignature(). public final val signature: kotlin.Any?
//          ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(signature) value-parameter signature: kotlin.Any?
//                     ^^^ reference kotlin/Any#
    )

    private val cache = mutableMapOf<CacheKey, List<ViewData<*>>?>()
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cache. private final val cache: kotlin.collections.MutableMap<com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey, kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<*>>?>
//              ^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#getCache(). private final val cache: kotlin.collections.MutableMap<com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey, kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<*>>?>
//                      ^^^^^^^^^^^^ reference kotlin/collections/MapsKt#mutableMapOf().
//                                   ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
//                                             ^^^^ reference kotlin/collections/List#
//                                                  ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#

    /** @return A list containing the data necessary to load each view in the given model. */
    fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> dataForModel(
//       ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T] <T>
//                          ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                              ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                             ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel(). public final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> dataForModel(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T, position: kotlin.Int): kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<U>>
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader) value-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
        position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(position) value-parameter position: kotlin.Int
//                ^^^ reference kotlin/Int#
    ): List<ViewData<U>> {
//     ^^^^ reference kotlin/collections/List#
//          ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//                   ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
        val cacheKey = cacheKey(preloader, epoxyModel, position)
//          ^^^^^^^^ definition local0 val cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey
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
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T] <T>
//                                  ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey(). private final fun <T> cacheKey(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, *, *>, epoxyModel: T, position: kotlin.Int): com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey
        preloader: EpoxyModelPreloader<T, *, *>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(preloader) value-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, *, *>
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        position: Int
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(position) value-parameter position: kotlin.Int
//                ^^^ reference kotlin/Int#
    ): CacheKey {
//     ^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
        val modelSpanSize = if (adapter.isMultiSpan) {
//          ^^^^^^^^^^^^^ definition local1 val modelSpanSize: kotlin.Int
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
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T] <T>
//                                  ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                               ^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData(). private final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> findViewData(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T, cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey): kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<U>>?
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader) value-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
        cacheKey: CacheKey
//      ^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(cacheKey) value-parameter cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey
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
//          ^^^^^^^^^^^ definition local2 val holderMatch: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                        ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                        ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
            val boundModel = it.model
//              ^^^^^^^^^^ definition local3 val boundModel: [ERROR : <ERROR PROPERTY TYPE>]
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
//          ^^^^^^^^ definition local4 val rootView: kotlin.Nothing
//                     ^^^^^^^^^^^ reference local2

        val boundObject = holderMatch.objectToBindInternal() // Allows usage of view holder models
//          ^^^^^^^^^^^ definition local5 val boundObject: [ERROR : <ERROR FUNCTION RETURN TYPE>]
//                        ^^^^^^^^^^^ reference local2

        val preloadableViews: List<View> = when {
//          ^^^^^^^^^^^^^^^^ definition local6 val preloadableViews: kotlin.collections.List<[ERROR : View]>
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
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T] <T>
//                                       ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews(). private final fun <T> [ERROR : View].findViews(viewIds: kotlin.collections.List<kotlin.Int>, epoxyModel: T): kotlin.collections.List<[ERROR : View]>
        viewIds: List<Int>,
//      ^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds) value-parameter viewIds: kotlin.collections.List<kotlin.Int>
//               ^^^^ reference kotlin/collections/List#
//                    ^^^ reference kotlin/Int#
        epoxyModel: T
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T]
    ): List<View> {
//     ^^^^ reference kotlin/collections/List#
        return viewIds.mapNotNull { id ->
//             ^^^^^^^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds)
//                     ^^^^^^^^^^ reference kotlin/collections/CollectionsKt#mapNotNull(+1).
//                                  ^^ definition local8 value-parameter id: kotlin.Int
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
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T] <T>
//                         ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T]
//                           ^^^^^^^^^^^^^^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews(). private final fun <T> T.recursePreloadableViews(): kotlin.collections.List<[ERROR : View]>
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
//               ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T] <T>
//                                  ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U] <U : com.airbnb.epoxy.preload.ViewMetadata?>
//                                      ^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P] <P : com.airbnb.epoxy.preload.PreloadRequestHolder>
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                    ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData(). private final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> [ERROR : View].buildData(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T): com.airbnb.epoxy.preload.ViewData<U>?
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(preloader) value-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>
//                 ^^^^^^^^^^^^^^^^^^^ reference com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
//                                        ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]
//                                           ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P]
        epoxyModel: T
//      ^^^^^^^^^^ definition com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(epoxyModel) value-parameter epoxyModel: T
//                  ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
    ): ViewData<U>? {
//     ^^^^^^^^ reference com/airbnb/epoxy/preload/ViewData#
//              ^ reference com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]

        // Glide's internal size determiner takes view dimensions and subtracts padding to get target size.
        // TODO: We could support size overrides by allowing the preloader to specify a size override callback
        val width = width - paddingLeft - paddingRight
//          ^^^^^ definition local10 val width: [ERROR : <ERROR FUNCTION RETURN TYPE>]
        val height = height - paddingTop - paddingBottom
//          ^^^^^^ definition local11 val height: [ERROR : <ERROR FUNCTION RETURN TYPE>]

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
