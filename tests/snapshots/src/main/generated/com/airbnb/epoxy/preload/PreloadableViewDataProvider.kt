package com.airbnb.epoxy.preload
//      ^^^ reference semanticdb maven . . com/
//          ^^^^^^ reference semanticdb maven . . com/airbnb/
//                 ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                       ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/

import android.view.View
import androidx.core.view.ViewCompat
//     ^^^^^^^^ reference semanticdb maven . . androidx/
import com.airbnb.epoxy.BaseEpoxyAdapter
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.EpoxyModel
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
import com.airbnb.epoxy.boundViewHoldersInternal
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#boundViewHoldersInternal().
import com.airbnb.epoxy.objectToBindInternal
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#objectToBindInternal().
import com.airbnb.epoxy.viewTypeInternal
//     ^^^ reference semanticdb maven . . com/
//         ^^^^^^ reference semanticdb maven . . com/airbnb/
//                ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/
//                      ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().

/**
 * In order to preload content we need to know the size of the view that they it be loaded into.
 * This class provides the view size, as well as other view metadata that might be necessary to construct the preload request.
 */
internal class PreloadableViewDataProvider(
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#
//                                         display_name PreloadableViewDataProvider
//                                         documentation ```kt\ninternal final class PreloadableViewDataProvider\n```\n\n----\n\n\n In order to preload content we need to know the size of the view that they it be loaded into.\n This class provides the view size, as well as other view metadata that might be necessary to construct the preload request.\n
//             ^^^^^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().
//                                         display_name PreloadableViewDataProvider
//                                         documentation ```kt\npublic constructor PreloadableViewDataProvider(adapter: [Error type: Unresolved type for BaseEpoxyAdapter], errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */)\n```
    val adapter: BaseEpoxyAdapter,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(adapter)
//              display_name adapter
//              documentation ```kt\nvalue-parameter adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//              display_name adapter
//              documentation ```kt\npublic final val adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
//              display_name adapter
//              documentation ```kt\npublic final val adapter: [Error type: Unresolved type for BaseEpoxyAdapter]\n```
    val errorHandler: PreloadErrorHandler
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#`<init>`().(errorHandler)
//                   display_name errorHandler
//                   documentation ```kt\nvalue-parameter errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#errorHandler.
//                   display_name errorHandler
//                   documentation ```kt\npublic final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//      ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getErrorHandler().
//                   display_name errorHandler
//                   documentation ```kt\npublic final val errorHandler: com.airbnb.epoxy.preload.PreloadErrorHandler /* = ([Error type: Unresolved type for Context], kotlin.RuntimeException /* = java.lang.RuntimeException */) -> kotlin.Unit */\n```
//                    ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadErrorHandler#
) {

    /**
     * A given model class might have different sized preloadable views depending on configuration.
     * We use this cache key to separate view configurations.
     */
    private data class CacheKey(
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
//                              display_name CacheKey
//                              documentation ```kt\nprivate final data class CacheKey\n```\n\n----\n\n\n A given model class might have different sized preloadable views depending on configuration.\n We use this cache key to separate view configurations.\n
//                     ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().
//                              display_name CacheKey
//                              documentation ```kt\npublic constructor CacheKey(epoxyModelClass: java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>, spanSize: kotlin.Int, viewType: kotlin.Int, signature: kotlin.Any?)\n```
        val epoxyModelClass: Class<out EpoxyModel<*>>,
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(epoxyModelClass)
//                          display_name epoxyModelClass
//                          documentation ```kt\nvalue-parameter epoxyModelClass: java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>\n```
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#epoxyModelClass.
//                          display_name epoxyModelClass
//                          documentation ```kt\npublic final val epoxyModelClass: java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>\n```
//          ^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getEpoxyModelClass().
//                          display_name epoxyModelClass
//                          documentation ```kt\npublic final val epoxyModelClass: java.lang.Class<out [Error type: Unresolved type for EpoxyModel<*>]<out [Error type: Error type projection]>>\n```
//                           ^^^^^ reference semanticdb maven jdk 11 java/lang/Class#
        val spanSize: Int,
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(spanSize)
//                   display_name spanSize
//                   documentation ```kt\nvalue-parameter spanSize: kotlin.Int\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSpanSize().
//                   display_name spanSize
//                   documentation ```kt\npublic final val spanSize: kotlin.Int\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#spanSize.
//                   display_name spanSize
//                   documentation ```kt\npublic final val spanSize: kotlin.Int\n```
//                    ^^^ reference semanticdb maven . . kotlin/Int#
        val viewType: Int,
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(viewType)
//                   display_name viewType
//                   documentation ```kt\nvalue-parameter viewType: kotlin.Int\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getViewType().
//                   display_name viewType
//                   documentation ```kt\npublic final val viewType: kotlin.Int\n```
//          ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#viewType.
//                   display_name viewType
//                   documentation ```kt\npublic final val viewType: kotlin.Int\n```
//                    ^^^ reference semanticdb maven . . kotlin/Int#
        /** An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins */
        val signature: Any?
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().(signature)
//                    display_name signature
//                    documentation ```kt\nvalue-parameter signature: kotlin.Any?\n```\n\n----\n\n An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#getSignature().
//                    display_name signature
//                    documentation ```kt\npublic final val signature: kotlin.Any?\n```\n\n----\n\n An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins
//          ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#signature.
//                    display_name signature
//                    documentation ```kt\npublic final val signature: kotlin.Any?\n```\n\n----\n\n An optional, custom signature provided by the model preloader. This allows the user to specify custom cache mixins
//                     ^^^ reference semanticdb maven . . kotlin/Any#
    )

    private val cache = mutableMapOf<CacheKey, List<ViewData<*>>?>()
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cache.
//                    display_name cache
//                    documentation ```kt\nprivate final val cache: kotlin.collections.MutableMap<com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey, kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<*>>?>\n```
//              ^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getCache().
//                    display_name cache
//                    documentation ```kt\nprivate final val cache: kotlin.collections.MutableMap<com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey, kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<*>>?>\n```
//                      ^^^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/MapsKt#mutableMapOf().
//                                   ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
//                                             ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                                                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#

    /** @return A list containing the data necessary to load each view in the given model. */
    fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> dataForModel(
//       ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
//         display_name T
//         documentation ```kt\n<T>\n```
//                          ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                            display_name U
//                            documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                              ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                             ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P]
//                                               display_name P
//                                               documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                 ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                       ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().
//                                                                                    display_name dataForModel
//                                                                                    documentation ```kt\npublic final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> dataForModel(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T, position: kotlin.Int): kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<U>>\n```\n\n----\n\n @return A list containing the data necessary to load each view in the given model.
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                display_name preloader
//                documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[T]
        position: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(position)
//               display_name position
//               documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
    ): List<ViewData<U>> {
//     ^^^^ reference semanticdb maven . . kotlin/collections/List#
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
        val cacheKey = cacheKey(preloader, epoxyModel, position)
//          ^^^^^^^^ definition local 0
//                   display_name cacheKey
//                   documentation ```kt\nval cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey\n```
//                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
//                              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                                                     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(position)

        @Suppress("UNCHECKED_CAST")
//       ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
        return cache.getOrPut(cacheKey) {
//             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cache.
//             ^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getCache().
//                   ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/MapsKt#getOrPut(+1).
//                            ^^^^^^^^ reference local 0
            // Look up view data based on currently bound views. This can be null if a matching view type is not found.
            // In that case we save the null so we know to try the lookup again next time.
            findViewData(preloader, epoxyModel, cacheKey)
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().
//                       ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(preloader)
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().(epoxyModel)
//                                              ^^^^^^^^ reference local 0
        } as? List<ViewData<U>> ?: return emptyList()
//            ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                          ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#dataForModel().[U]
//                                        ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
    }

    private fun <T : EpoxyModel<*>> cacheKey(
//               ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                                  ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
//                                           display_name cacheKey
//                                           documentation ```kt\nprivate final fun <T> cacheKey(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, *, *>, epoxyModel: T, position: kotlin.Int): com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey\n```
        preloader: EpoxyModelPreloader<T, *, *>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(preloader)
//                display_name preloader
//                documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, *, *>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        epoxyModel: T,
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().[T]
        position: Int
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(position)
//               display_name position
//               documentation ```kt\nvalue-parameter position: kotlin.Int\n```
//                ^^^ reference semanticdb maven . . kotlin/Int#
    ): CacheKey {
//     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
        val modelSpanSize = if (adapter.isMultiSpan) {
//          ^^^^^^^^^^^^^ definition local 1
//                        display_name modelSpanSize
//                        documentation ```kt\nval modelSpanSize: kotlin.Int\n```
//                              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
            epoxyModel.spanSize(adapter.spanCount, position, adapter.itemCount)
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                              ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
//                                                 ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(position)
//                                                           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                                                           ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
        } else {
            1
        }

        return CacheKey(
//             ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#`<init>`().
            epoxyModel.javaClass,
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
            modelSpanSize,
//          ^^^^^^^^^^^^^ reference local 1
            epoxyModel.viewTypeInternal(),
//          ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
//                     ^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/InternalExposerKt#viewTypeInternal().
            preloader.viewSignature(epoxyModel)
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(preloader)
//                    ^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#viewSignature().
//                                  ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().(epoxyModel)
        )
    }

    private fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> findViewData(
//               ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                                  ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
//                                    display_name U
//                                    documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P]
//                                                       display_name P
//                                                       documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                               ^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().
//                                                                                            display_name findViewData
//                                                                                            documentation ```kt\nprivate final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> findViewData(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T, cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey): kotlin.collections.List<com.airbnb.epoxy.preload.ViewData<U>>?\n```
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                display_name preloader
//                documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[P]
        epoxyModel: T,
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
        cacheKey: CacheKey
//      ^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(cacheKey)
//               display_name cacheKey
//               documentation ```kt\nvalue-parameter cacheKey: com.airbnb.epoxy.preload.PreloadableViewDataProvider.CacheKey\n```
//                ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#
    ): List<ViewData<U>>? {
//     ^^^^ reference semanticdb maven . . kotlin/collections/List#
//          ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//                   ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[U]
        // It is a bit tricky to get details on the view to be preloaded, since the view doesn't necessarily exist at the time of preload.
        // This approach looks at currently bound views and tries to get one who's cache key is the same as what we need.
        // This should mostly work, since RecyclerViews are generally the same type of views shown repeatedly.
        // If a model is only shown sporadically we may never be able to get data about it with this approach, which we could address in the future.

        val holderMatch = adapter.boundViewHoldersInternal().find {
//          ^^^^^^^^^^^ definition local 2
//                      display_name holderMatch
//                      documentation ```kt\nval holderMatch: [Error type: Return type for function cannot be resolved]\n```
//                        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#adapter.
//                        ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getAdapter().
            val boundModel = it.model
//              ^^^^^^^^^^ definition local 3
//                         display_name boundModel
//                         documentation ```kt\nval boundModel: [Error type: Error property type]\n```
            if (boundModel::class == epoxyModel::class) {
//              ^^^^^^^^^^ reference local 3
//                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
                @Suppress("UNCHECKED_CAST")
//               ^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/Suppress#`<init>`().
                // We need the view sizes, but viewholders can be bound without actually being laid out on screen yet
                ViewCompat.isAttachedToWindow(it.itemView) &&
                    ViewCompat.isLaidOut(it.itemView) &&
                    cacheKey(preloader, boundModel as T, it.adapterPosition) == cacheKey
//                  ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#cacheKey().
//                           ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                                      ^^^^^^^^^^ reference local 3
//                                                    ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().[T]
//                                                                           ^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#CacheKey#equals().
//                                                                              ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(cacheKey)
            } else {
                false
            }
        }

        val rootView = holderMatch?.itemView ?: return null
//          ^^^^^^^^ definition local 4
//                   display_name rootView
//                   documentation ```kt\nval rootView: kotlin.Nothing\n```
//                     ^^^^^^^^^^^ reference local 2

        val boundObject = holderMatch.objectToBindInternal() // Allows usage of view holder models
//          ^^^^^^^^^^^ definition local 5
//                      display_name boundObject
//                      documentation ```kt\nval boundObject: [Error type: Return type for function cannot be resolved]\n```
//                        ^^^^^^^^^^^ reference local 2

        val preloadableViews: List<View> = when {
//          ^^^^^^^^^^^^^^^^ definition local 6
//                           display_name preloadableViews
//                           documentation ```kt\nval preloadableViews: kotlin.collections.List<[Error type: Unresolved type for View]>\n```
//                            ^^^^ reference semanticdb maven . . kotlin/collections/List#
            preloader.preloadableViewIds.isNotEmpty() -> rootView.findViews(
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
//                    ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
//                                       ^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#isNotEmpty(+9).
//                                                       ^^^^^^^^ reference local 4
//                                                                ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
                preloader.preloadableViewIds,
//              ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#getPreloadableViewIds().
//                        ^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#preloadableViewIds.
                epoxyModel
//              ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
            )
            rootView is Preloadable -> rootView.viewsToPreload
//          ^^^^^^^^ reference local 4
//                      ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#
//                                     ^^^^^^^^ reference local 4
            boundObject is Preloadable -> boundObject.viewsToPreload
//          ^^^^^^^^^^^ reference local 5
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#
//                                        ^^^^^^^^^^^ reference local 5
            else -> emptyList()
//                  ^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#emptyList().
        }

        if (preloadableViews.isEmpty()) {
//          ^^^^^^^^^^^^^^^^ reference local 6
//                           ^^^^^^^ reference semanticdb maven . . kotlin/collections/List#isEmpty().
            errorHandler(rootView.context, EpoxyPreloadException("No preloadable views were found in ${epoxyModel.javaClass.simpleName}"))
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#errorHandler.
//          ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#getErrorHandler().
//                       ^^^^^^^^ reference local 4
//                                         ^^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyPreloadException#`<init>`().
//                                                                                                     ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
        }

        return preloadableViews
//             ^^^^^^^^^^^^^^^^ reference local 6
            .flatMap { it.recursePreloadableViews() }
            .mapNotNull { it.buildData(preloader, epoxyModel) }
//                                     ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(preloader)
//                                                ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViewData().(epoxyModel)
    }

    /** Returns child views with the given view ids. */
    private fun <T : EpoxyModel<*>> View.findViews(
//               ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                                       ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
//                                                 display_name findViews
//                                                 documentation ```kt\nprivate final fun <T> [Error type: Unresolved type for View].findViews(viewIds: kotlin.collections.List<kotlin.Int>, epoxyModel: T): kotlin.collections.List<[Error type: Unresolved type for View]>\n```\n\n----\n\n Returns child views with the given view ids.
        viewIds: List<Int>,
//      ^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds)
//              display_name viewIds
//              documentation ```kt\nvalue-parameter viewIds: kotlin.collections.List<kotlin.Int>\n```
//               ^^^^ reference semanticdb maven . . kotlin/collections/List#
//                    ^^^ reference semanticdb maven . . kotlin/Int#
        epoxyModel: T
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().[T]
    ): List<View> {
//     ^^^^ reference semanticdb maven . . kotlin/collections/List#
        return viewIds.mapNotNull { id ->
//             ^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(viewIds)
//                     ^^^^^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#mapNotNull(+1).
//                                  ^^ definition local 7
//                                     display_name id
//                                     documentation ```kt\nvalue-parameter id: kotlin.Int\n```
            findViewById<View>(id).apply {
//                             ^^ reference local 7
                if (this == null) errorHandler(context, EpoxyPreloadException("View with id $id in ${epoxyModel.javaClass.simpleName} could not be found."))
//                  ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().
//                                                                                           ^^ reference local 7
//                                                                                                   ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#findViews().(epoxyModel)
            }
        }
    }

    /** If a View with the [Preloadable] interface is used we want to get all of the preloadable views contained in that Preloadable instead. */
    private fun <T : View> T.recursePreloadableViews(): List<View> {
//               ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                         ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().[T]
//                           ^^^^^^^^^^^^^^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
//                                                   display_name recursePreloadableViews
//                                                   documentation ```kt\nprivate final fun <T> T.recursePreloadableViews(): kotlin.collections.List<[Error type: Unresolved type for View]>\n```\n\n----\n\n If a View with the [Preloadable] interface is used we want to get all of the preloadable views contained in that Preloadable instead.
//                                                      ^^^^ reference semanticdb maven . . kotlin/collections/List#
        return if (this is Preloadable) {
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
//                         ^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#
            viewsToPreload.flatMap { it.recursePreloadableViews() }
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#getViewsToPreload().
//          ^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/Preloadable#viewsToPreload.
        } else {
            listOf(this)
//          ^^^^^^ reference semanticdb maven maven/org.jetbrains.kotlin/kotlin-stdlib 1.4.20-RC kotlin/collections/CollectionsKt#listOf().
//                 ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#recursePreloadableViews().
        }
    }

    private fun <T : EpoxyModel<*>, U : ViewMetadata?, P : PreloadRequestHolder> View.buildData(
//               ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
//                 display_name T
//                 documentation ```kt\n<T>\n```
//                                  ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]
//                                    display_name U
//                                    documentation ```kt\n<U : com.airbnb.epoxy.preload.ViewMetadata?>\n```
//                                      ^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewMetadata#
//                                                     ^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P]
//                                                       display_name P
//                                                       documentation ```kt\n<P : com.airbnb.epoxy.preload.PreloadRequestHolder>\n```
//                                                         ^^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadRequestHolder#
//                                                                                    ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
//                                                                                              display_name buildData
//                                                                                              documentation ```kt\nprivate final fun <T, U : com.airbnb.epoxy.preload.ViewMetadata?, P : com.airbnb.epoxy.preload.PreloadRequestHolder> [Error type: Unresolved type for View].buildData(preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>, epoxyModel: T): com.airbnb.epoxy.preload.ViewData<U>?\n```
        preloader: EpoxyModelPreloader<T, U, P>,
//      ^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(preloader)
//                display_name preloader
//                documentation ```kt\nvalue-parameter preloader: com.airbnb.epoxy.preload.EpoxyModelPreloader<T, U, P>\n```
//                 ^^^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#
//                                     ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
//                                        ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]
//                                           ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[P]
        epoxyModel: T
//      ^^^^^^^^^^ definition semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(epoxyModel)
//                 display_name epoxyModel
//                 documentation ```kt\nvalue-parameter epoxyModel: T\n```
//                  ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[T]
    ): ViewData<U>? {
//     ^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/ViewData#
//              ^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().[U]

        // Glide's internal size determiner takes view dimensions and subtracts padding to get target size.
        // TODO: We could support size overrides by allowing the preloader to specify a size override callback
        val width = width - paddingLeft - paddingRight
//          ^^^^^ definition local 8
//                display_name width
//                documentation ```kt\nval width: [Error type: Return type for function cannot be resolved]\n```
        val height = height - paddingTop - paddingBottom
//          ^^^^^^ definition local 9
//                 display_name height
//                 documentation ```kt\nval height: [Error type: Return type for function cannot be resolved]\n```

        if (width <= 0 || height <= 0) {
//          ^^^^^ reference local 8
//                        ^^^^^^ reference local 9
            // If no placeholder or aspect ratio is used then the view might be empty before its content loads
            errorHandler(context, EpoxyPreloadException("${this.javaClass.simpleName} in ${epoxyModel.javaClass.simpleName} has zero size. A size must be set to allow preloading."))
//                                                         ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
//                                                                                         ^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(epoxyModel)
            return null
        }

        return ViewData(
            id,
            width,
//          ^^^^^ reference local 8
            height,
//          ^^^^^^ reference local 9
            preloader.buildViewMetadata(this)
//          ^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().(preloader)
//                    ^^^^^^^^^^^^^^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/EpoxyModelPreloader#buildViewMetadata().
//                                      ^^^^ reference semanticdb maven . . com/airbnb/epoxy/preload/PreloadableViewDataProvider#buildData().
        )
    }
}
